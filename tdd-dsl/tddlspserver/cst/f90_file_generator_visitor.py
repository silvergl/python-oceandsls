'''File generator visitor module.'''

__author__ = 'sgu'

# util
import os
from typing import Dict, List, Tuple

# jinja2
from jinja2 import Environment, FileSystemLoader

# user relative imports
from ..symboltable.symbol_table import SymbolTable, FunctionSymbol, ModuleSymbol, RoutineSymbol, VariableSymbol
from ..filewriter.file_writer import write_file
from ..gen.python.TestSuite.TestSuiteParser import TestSuiteParser
from ..gen.python.TestSuite.TestSuiteVisitor import TestSuiteVisitor
from ..utils.suggest_variables import get_scope


class F90FileGeneratorVisitor(TestSuiteVisitor):
    file_templates: Dict[int, str]
    template_path: str
    work_path: str
    test_file_predicate: str
    environment: Environment
    ops: Dict[str, List]
    last_op_id: str
    file_suffix: str
    _symbol_table: SymbolTable
    found_ref: bool
    found_par: bool

    # TODO hc
    def __init__(
        self, template_path: str = 'tdd-dsl/tddlspserver/filewriter/jinjatemplates/f90', files: Dict[str, Tuple[float, str, str]] = {},
        symbol_table: SymbolTable = None, work_path: str = 'tdd-dsl/output', file_suffix: str = 'f90'
    ):
        '''
        Fortran 90 source code file generator. Builds template file dictionary from TestSuiteParser.ruleNames.

        Write/merge pFUnit-file to :test_path:/:test_folder:/:filename:.pf

        :param template_path: relative filepath for jinja templates
        :param work_path: relative path to generate test suite
        '''
        super().__init__()
        self.files: dict[str, Tuple[float, str, str]] = files
        self.template_path = template_path
        self.work_path = work_path
        self.file_suffix = file_suffix
        # Load Jinja2 templates
        self.environment = Environment(loader=FileSystemLoader(template_path), trim_blocks=True, lstrip_blocks=True, keep_trailing_newline=False)

        # variable flags
        self.found_ref = False
        self.found_par = False

        # set symboltable
        self._symbol_table = symbol_table

        # Get template file names from grammar
        self.file_templates = {}
        i: int = 0
        for rule in TestSuiteParser.ruleNames:
            self.file_templates[i] = f'{rule}_template.txt'
            i += 1

        # Initialize dictionary to track operations of assertions
        self.ops = {}

    @property
    def symbol_table(self) -> SymbolTable:
        return self._symbol_table

    # Visit a parse tree produced by TestSuiteParser#test_case.
    def visitTest_case(self, ctx: TestSuiteParser.Test_caseContext) -> dict[str, Tuple[float, str, str]]:
        # Load Jinja2 template
        template = self.environment.get_template(self.file_templates[ctx.getRuleIndex()])

        module_symbols = self.visit(ctx.scope)

        # funSymbol = module_symbols[0].getSymbolsOfTypeSync( FunctionSymbol, True )
        #
        # routine_symbol = module_symbols[0].getSymbolsOfTypeSync( RoutineSymbol, True )

        # not implemented ops
        # opsNew = list(filter ( lambda ))

        # module: ModuleSymbol = next(filter ( lambda module: module.name == scopeName, modules))

        # Get test case template parameters

        # Get operations defined in assertions
        for assertion in ctx.assertions:
            self.visit(assertion)

        # Lookup if operation exists in symboltable
        ops_names: List[str] = []
        ops_impl: List[str] = []
        for key, value_list in self.ops.items():
            scope = get_scope(ctx, self.symbo_table)
            routine_symbol = scope.get_symbols_of_type_and_name_sync(RoutineSymbol, key, False)
            # If operations does not exist, add to newly generated ops
            if not routine_symbol:
                ops_names.append(key)
                ops_impl.append(value_list[3])

        # Write content to module if module is set
        if module_symbols:
            if module_symbols[0].file:
                # Module exists

                insert = True
                module_file = module_symbols[0].file

                content = [', '.join(ops_names), '\n\n'.join(ops_impl), module_symbols[0].name]

            else:
                # Module is new
                insert = False

                # Set module file
                module_name = module_symbols[0].name
                module_file = '.'.join([module_name, self.file_suffix])

                # Render template with new operations
                content = [template.render(name=module_name, opsNames=ops_names, ops=ops_impl)]

            # Get absolute file path
            self.visit(ctx.src_path())
            abs_path: str = os.path.join(self.work_path, module_file)

            # Get the file attributes for previously generated files
            file_attr = self.files.get(abs_path)

            # Write content to file
            self.files[self.work_path] = write_file(abs_path, content, file_attr, insert)

        # Return list of generated files
        return self.files

    # Save the source path to scan for existing variables
    def visitSrc_path(self, ctx: TestSuiteParser.Src_pathContext):
        # Strip string terminals
        user_path: str = ctx.path.text.strip('\'')

        # TODO document
        # Update source directory
        # If the given path is an absolute path, then self._testPath is ignored and the joining is only the given path
        self.work_path = os.path.join(self.work_path, user_path)

    # Get list of used module symbols
    def visitUse_modules(self, ctx: TestSuiteParser.Use_modulesContext):

        # Accumulate module names
        module_symbols: List[ModuleSymbol] = []
        for module in ctx.modules:
            module_symbols.append(self.visit(module))

        return module_symbols

    # Find corresponding module symbol
    def visitTest_module(self, ctx: TestSuiteParser.Test_moduleContext):
        # Return corresponding module symbol, optionally with implementing file and contain functions flag
        return get_scope(ctx, self.symbo_table)

    # Visit a parse tree produced by TestSuiteParser#test_assertion.
    def visitTest_assertion(self, ctx: TestSuiteParser.Test_assertionContext):
        # Load operation template
        template = self.environment.get_template(self.file_templates[ctx.getRuleIndex()])

        # extract comment
        # TODO remove comment
        comment = ctx.comment.text.rstrip('\n').lstrip('#') if ctx.comment is not None else None

        # extract id and optional arguments
        self.visit(ctx.input_)

        return_type: str = self.visit(ctx.output)

        # Update return type of last new operation if function expression was in between
        if self.last_op_id:
            last_op = self.ops.get(self.last_op_id)
            last_op[2] = return_type
            self.ops[self.last_op_id] = last_op

        # Generate fortran implementations for operations
        for key, value_list in self.ops.items():
            # Get name, arguments, unit and return_type
            name = key
            # Arguments
            arg_names: List[str] = []
            args_decl: List[str] = []
            for idx, arg_type in enumerate(value_list[0]):
                arg_name = f'arg{idx}'
                arg_names.append(arg_name)
                args_decl.append(f'{arg_type}, INTENT(IN)  :: {arg_name}')
            # Unit
            unit = value_list[1]
            # Add unit parameter if unit exists
            arg_names += ['unit'] if unit is not None else []
            # ReturnType
            return_type = value_list[2]

            # TODO subroutine
            # Fortran implementation
            value_list.append(template.render(comment=comment, name=name, argNames=arg_names, unit=unit, argsDecl=args_decl, returnType=return_type))
            # Update operation list
            self.ops[key] = value_list

    # Visit a parse tree produced by TestSuiteParser#test_parameter.
    def visitTest_parameter(self, ctx: TestSuiteParser.Test_parameterContext):
        # TODO rm declaration from grammar?
        # get value name and optional argument types
        parameter_type = self.visit(ctx.value)

        # unit of expression
        expr_unit: str = self.visit(ctx.comment)

        # Update input unit of last new operation if function expression was in between
        if self.last_op_id:
            last_op = self.ops.get(self.last_op_id)
            last_op[1] = expr_unit
            self.ops[self.last_op_id] = last_op

        return parameter_type

    # Visit a parse tree produced by TestSuiteParser#emptyDesc.
    def visitEmptyDesc(self, ctx: TestSuiteParser.EmptyDescContext):
        # return no unit
        # TODO no unit symbol?
        return None

    # Visit a parse tree produced by TestSuiteParser#specDesc.
    def visitSpecDesc(self, ctx: TestSuiteParser.SpecDescContext):
        # get unit of expression
        return self.visit(ctx.type_)

    # Visit a parse tree produced by TestSuiteParser#customUnit.
    def visitCustomUnit(self, ctx: TestSuiteParser.CustomUnitContext):
        # return custom unit
        return ctx.name.text

    # Visit a parse tree produced by TestSuiteParser#siUnit.
    def visitSiUnit(self, ctx: TestSuiteParser.SiUnitContext):
        # return si unit
        return ctx.type_.value.text

    # Visit a parse tree produced by TestSuiteParser#funRef.
    def visitFunRef(self, ctx: TestSuiteParser.FunRefContext):
        # Get routine id
        name: str = ctx.ID().getText()
        # Get routine arguments
        args: List[str] = []
        for arg in ctx.args:
            args.append(self.visit(arg))

        # Lookup if routine exists in symboltable
        scope = get_scope(ctx, self.symbo_table)
        routine_symbol = scope.get_symbols_of_type_and_name_sync(RoutineSymbol, name, False)
        if routine_symbol:
            # Operation exists return return_type
            return_type = routine_symbol[0].return_type.lower()
        else:
            # Operation is new, return_type is unknown
            return_type = None

        # TODO check if ops exists
        # Add operation to list of generated ops if it does not exists
        self.ops[name] = self.ops.get(name, [args, None, return_type])
        self.last_op_id = name

        # Return operation return_type
        return return_type

    # Visit a parse tree produced by TestSuiteParser#varRef.
    def visitVarRef(self, ctx: TestSuiteParser.VarRefContext):
        name = ctx.ID().getText()

        # extract most local type of reference from symboltable
        scope = get_scope(ctx, self.symbo_table)
        var = scope.get_nested_symbols_of_type_and_name_sync(VariableSymbol, name)
        varType = var[0].attached_type.lower() if var else None

        # Return variable type
        return varType

    # Visit a parse tree produced by TestSuiteParser#parensExpr.
    def visitParensExpr(self, ctx: TestSuiteParser.ParensExprContext):
        innerType = self.visit(ctx.inner)
        return innerType

    # Visit a parse tree produced by TestSuiteParser#mulDivExpr.
    def visitMulDivExpr(self, ctx: TestSuiteParser.MulDivExprContext):
        # extract left and right operator
        left_type = self.visit(ctx.left)
        right_type = self.visit(ctx.right)

        # determine type of expression
        # https://web.chem.ox.ac.uk/fortran/arithmetic.html
        match (left_type.lower() if left_type else None, right_type.lower() if right_type else None):
            case ['real', _]:
                # if any of the operands are real then result of the operation will be real
                expr_type: str = 'real'
            case [_, 'real']:
                # if any of the operands are real then result of the operation will be real
                expr_type: str = 'real'
            case ['integer', 'integer']:
                if ctx.op == '*':
                    # if all the operands are integer then result of the operation will be integer
                    expr_type: str = 'integer'
                else:
                    expr_type: str = 'real'
            case [None, None]:
                # if both operands are None then result of the operation will be None
                expr_type: str = None
            case _:
                # custom types have precedence
                # TODO mod custom type with second type
                expr_type: str = ctx.op.text.join([str(left_type), str(left_type)])

        # Mark last added operation as not last operation
        self.last_op_id = None

        # return determined type
        return expr_type

    # Visit a parse tree produced by TestSuiteParser#addSubExpr.
    def visitAddSubExpr(self, ctx: TestSuiteParser.AddSubExprContext):
        # extract left and right operator
        left_type = self.visit(ctx.left)
        right_type = self.visit(ctx.right)

        # extract types from function references
        # https://web.chem.ox.ac.uk/fortran/arithmetic.html
        match (left_type.lower() if left_type else None, right_type.lower() if right_type else None):
            case ['real', _]:
                # if any of the operands are real then result of the operation will be real
                expr_type: str = 'real'
            case [_, 'real']:
                # if any of the operands are real then result of the operation will be real
                expr_type: str = 'real'
            case ['integer', 'integer']:
                # if all the operands are integer then result of the operation will be integer
                expr_type: str = 'integer'
            case [None, None]:
                # if both operands are None then result of the operation will be None
                expr_type: str = None
            case _:
                # custom types have precedence
                # TODO mod custom type with second type
                expr_type: str = ctx.op.text.join([str(left_type), str(left_type)])

        # Mark last added operation as not last operation
        self.last_op_id = None

        # return determined type
        return expr_type

    # Visit a parse tree produced by TestSuiteParser#signExpr.
    def visitSignExpr(self, ctx: TestSuiteParser.SignExprContext):
        inner_type = self.visit(ctx.inner)
        return inner_type

    # Visit a parse tree produced by TestSuiteParser#numberExpr.
    def visitNumberExpr(self, ctx: TestSuiteParser.NumberExprContext):
        # power and decimal operation will be real
        return 'real'

    # Visit a parse tree produced by TestSuiteParser#strExpr.
    def visitStrExpr(self, ctx: TestSuiteParser.StrExprContext):
        # custom types will be string
        # TODO add specific custom types
        return 'character(len = *)'

    # Visit a parse tree produced by TestSuiteParser#intExpr.
    def visitIntExpr(self, ctx: TestSuiteParser.IntExprContext):
        # Integer operation will be integer
        return 'integer'

    # Visit a parse tree produced by TestSuiteParser#refExpr.
    def visitRefExpr(self, ctx: TestSuiteParser.RefExprContext):
        # Return reference type
        return self.visit(ctx.value)
