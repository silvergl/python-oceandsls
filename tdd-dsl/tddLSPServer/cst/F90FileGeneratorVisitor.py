'''FileGeneratorVisitor module.'''

__author__ = 'sgu'

# util
import os
from typing import Dict, List, Tuple

# jinja2
from jinja2 import Environment, FileSystemLoader

# user relative imports
from ..symbolTable.SymbolTable import SymbolTable, FunctionSymbol, ModuleSymbol, RoutineSymbol, VariableSymbol
from ..fileWriter.fileWriter import write_file
from ..gen.python.TestSuite.TestSuiteParser import TestSuiteParser
from ..gen.python.TestSuite.TestSuiteVisitor import TestSuiteVisitor
from ..utils.suggestVariables import getScope


class F90FileGeneratorVisitor( TestSuiteVisitor ):
    fileTemplates: Dict[ int, str ]
    templatePath: str
    workPath: str
    workFolder: str
    testFilePredicate: str
    environment: Environment
    ops: Dict[ str, List ]
    lastOpID : str

    # TODO hc
    def __init__( self, templatePath: str = 'tdd-dsl/tddLSPServer/fileWriter/jinja-templates/f90', files: dict[ str, Tuple[ float, str, str ] ] = {}, symbolTable: SymbolTable = None, workPath: str = 'tdd-dsl/output', workFolder: str = '', fileSuffix = '.f90' ):
        '''
        Fortran 90 source code file generator. Builds template file dictionary from TestSuiteParser.ruleNames.

        Write/merge pFUnit-file to :test_path:/:test_folder:/:filename:.pf

        :param templatePath: relative filepath for jinja templates
        :param workPath: relative path to generate test suite
        :param workFolder: relative path under :testWorkPath: to save fortran 90 source code files
        '''
        super( ).__init__( )
        self.files: dict[ str, Tuple[ float, str, str ] ] = files
        self.templatePath = templatePath
        self.workPath = workPath
        # TODO add test directory option
        self.workFolder = workFolder
        self.fileSuffix = fileSuffix
        # Load Jinja2 templates
        self.environment = Environment( loader = FileSystemLoader( templatePath ), trim_blocks = True, lstrip_blocks = True, keep_trailing_newline = False )

        # variable flags
        self.foundRef: bool = False
        self.foundPar: bool = False

        # set symboltable
        self._symbolTable: SymbolTable = symbolTable

        # Get template file names from grammar
        self.fileTemplates = {}
        i: int = 0
        for rule in TestSuiteParser.ruleNames:
            self.fileTemplates[ i ] = f'{rule}_template.txt'
            i += 1

        # Initialize dictionary to track operations of assertions
        self.ops = {}

    @property
    def symbolTable( self ) -> SymbolTable:
        return self._symbolTable

    # Visit a parse tree produced by TestSuiteParser#test_case.
    def visitTest_case( self, ctx: TestSuiteParser.Test_caseContext ) -> dict[ str, Tuple[ float, str, str ] ]:
        # Load Jinja2 template
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )

        moduleSymbols = self.visit( ctx.scope )

        # funSymbol = moduleSymbols[0].getSymbolsOfTypeSync( FunctionSymbol, True )
        #
        # routineSymbol = moduleSymbols[0].getSymbolsOfTypeSync( RoutineSymbol, True )

        # not implemented ops
        # opsNew = list(filter ( lambda ))

        # module: ModuleSymbol = next(filter ( lambda module: module.name == scopeName, modules))

        # Get test case template parameters

        # Get operations defined in assertions
        for assertion in ctx.assertions:
            self.visit( assertion )

        # Lookup if operation exists in symboltable
        opsNames: List[ str ] = [ ]
        opsImpl: List[ str ] = [ ]
        for key, valueList in self.ops.items( ):
            scope = getScope( ctx, self.symbolTable )
            routineSymbol = scope.getSymbolsOfTypeAndNameSync( RoutineSymbol, key, False )
            # If operations does not exist, add to newly generated ops
            if not routineSymbol:
                opsNames.append(key)
                opsImpl.append(valueList[3])

        # Get module name destination
        moduleName = moduleSymbols[0].name if moduleSymbols else None

        # Render template with new operations
        content = template.render( name = moduleName, opsNames = opsNames, ops = opsImpl )

        # Write content to file
        # Get path destination
        moduleFile = moduleSymbols[0].file if moduleSymbols else None
        # TODO rm?
        # Check if file suffix exists
        fileSuffix = '' if moduleFile.endswith( self.fileSuffix ) else self.fileSuffix

        self.visit( ctx.src_path( ) )
        absPath: str = os.path.join( os.getcwd( ), self.workPath, self.workFolder, moduleFile)

        # Are the files previously generated?
        fileAttr = self.files.get( absPath )
        self.files[ absPath ] = write_file( self.workPath, self.workFolder, moduleFile, fileSuffix, content, fileAttr )

        # TODO find test cases in children?
        self.visitChildren( ctx )

        # Return list of generated files
        return self.files

    # Save the source path to scan for existing variables
    def visitSrc_path( self, ctx: TestSuiteParser.Src_pathContext ):
        # Strip string terminals
        userPath: str = ctx.path.text.strip( '\'' )

        # TODO document
        # Update source directory
        # If the given path is an absolute path, then self._testPath is ignored and the joining is only the given path
        self.workPath = os.path.join( self.workPath, userPath )

    # Get list of used module symbols
    def visitUse_modules( self, ctx: TestSuiteParser.Use_modulesContext ):

        # Accumulate module names
        moduleSymbols: List[ ModuleSymbol ] = [ ]
        for module in ctx.modules:
            moduleSymbols.append( self.visit( module ) )

        return moduleSymbols

    # Find corresponding module symbol
    def visitTest_module( self, ctx: TestSuiteParser.Test_moduleContext ):
        # Return corresponding module symbol, optionally with implementing file and contain functions flag
        return getScope( ctx, self.symbolTable )

    # Visit a parse tree produced by TestSuiteParser#test_assertion.
    def visitTest_assertion( self, ctx: TestSuiteParser.Test_assertionContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )

        # extract comment
        # TODO remove comment
        comment = ctx.comment.text.rstrip( '\n' ).lstrip( '#' ) if ctx.comment is not None else None

        # extract id and optional arguments
        self.visit( ctx.input_ )

        returnType: str = self.visit( ctx.output )

        # Update return type of last new operation if function expression was in between
        if self.lastOpID:
            lastOp = self.ops.get(self.lastOpID)
            lastOp[ 2 ] = returnType
            self.ops[ self.lastOpID ] = lastOp

        # Generate fortran implementations for operations
        for key, valueList in self.ops.items( ):
            # Get name, arguments, unit and returnType
            name = key
            # Arguments
            argNames: List[str] = []
            argsDecl : List[str] = []
            for idx, argType in enumerate(valueList[0]):
                argName = f'arg{idx}'
                argNames.append(argName)
                argsDecl.append(f'{argType}, INTENT(IN)  :: {argName}')
            # Unit
            unit = valueList[1]
            # Add unit parameter if unit exists
            argNames += [ 'unit' ] if unit is not None else [ ]
            # ReturnType
            returnType = valueList[2]

            # TODO subroutine
            # Load operation template
            template = self.environment.get_template( 'test_assertion_template.txt' )
            # Fortran implementation
            valueList.append(template.render( comment = comment, name = name, argNames = argNames, unit = unit, argsDecl = argsDecl, returnType = returnType ))
            # Update operation list
            self.ops[ key ] = valueList


    # Visit a parse tree produced by TestSuiteParser#test_parameter.
    def visitTest_parameter( self, ctx: TestSuiteParser.Test_parameterContext ):
        # TODO rm declaration from grammar?
        # get value name and optional argument types
        parameterType = self.visit( ctx.value )

        # unit of expression
        exprUnit: str = self.visit( ctx.comment )

        # Update input unit of last new operation if function expression was in between
        if self.lastOpID:
            lastOp = self.ops.get(self.lastOpID)
            lastOp[ 1 ] = exprUnit
            self.ops[ self.lastOpID ] = lastOp

        return parameterType

    # Visit a parse tree produced by TestSuiteParser#emptyDesc.
    def visitEmptyDesc( self, ctx: TestSuiteParser.EmptyDescContext ):
        # return no unit
        # TODO no unit symbol?
        return None

    # Visit a parse tree produced by TestSuiteParser#specDesc.
    def visitSpecDesc( self, ctx: TestSuiteParser.SpecDescContext ):
        # get unit of expression
        return self.visit( ctx.type_ )

    # Visit a parse tree produced by TestSuiteParser#customUnit.
    def visitCustomUnit( self, ctx: TestSuiteParser.CustomUnitContext ):
        # return custom unit
        return ctx.name.text

    # Visit a parse tree produced by TestSuiteParser#siUnit.
    def visitSiUnit( self, ctx: TestSuiteParser.SiUnitContext ):
        # return si unit
        return ctx.type_.value.text

    # Visit a parse tree produced by TestSuiteParser#funRef.
    def visitFunRef( self, ctx: TestSuiteParser.FunRefContext ):
        # Get routine id
        name: str = ctx.ID( ).getText( )
        # Get routine arguments
        args: List[ str ] = [ ]
        for arg in ctx.args:
            args.append( self.visit( arg ) )

        # Lookup if routine exists in symboltable
        scope = getScope( ctx, self.symbolTable )
        routineSymbol = scope.getSymbolsOfTypeAndNameSync( RoutineSymbol, name, False )
        if routineSymbol:
            # Operation exists return returnType
            returnType = routineSymbol[ 0 ].returnType.lower( )
        else:
            # Operation is new, returnType is unknown
            returnType = None

        # TODO check if ops exists
        # Add operation to list of generated ops if it does not exists
        self.ops[ name ] = self.ops.get( name, [ args, None, returnType] )
        self.lastOpID = name

        # Return operation returnType
        return returnType

    # Visit a parse tree produced by TestSuiteParser#varRef.
    def visitVarRef( self, ctx: TestSuiteParser.VarRefContext ):
        name = ctx.ID( ).getText( )

        # extract most local type of reference from symboltable
        scope = getScope( ctx, self.symbolTable )
        var = scope.getNestedSymbolsOfTypeAndNameSync( VariableSymbol, name )
        varType = var[ 0 ].attached_type.lower( ) if var else None

        # Return variable type
        return varType

    # Visit a parse tree produced by TestSuiteParser#parensExpr.
    def visitParensExpr( self, ctx: TestSuiteParser.ParensExprContext ):
        innerType = self.visit( ctx.inner )
        return innerType

    # Visit a parse tree produced by TestSuiteParser#mulDivExpr.
    def visitMulDivExpr( self, ctx: TestSuiteParser.MulDivExprContext ):
        # extract left and right operator
        leftType = self.visit( ctx.left )
        rightType = self.visit( ctx.right )

        # determine type of expression
        # https://web.chem.ox.ac.uk/fortran/arithmetic.html
        match (leftType.lower( ) if leftType else None, rightType.lower( ) if rightType else None):
            case [ 'real', _ ]:
                # if any of the operands are real then result of the operation will be real
                exprType: str = 'real'
            case [ _, 'real' ]:
                # if any of the operands are real then result of the operation will be real
                exprType: str = 'real'
            case [ 'integer', 'integer' ]:
                if ctx.op == '*':
                    # if all the operands are integer then result of the operation will be integer
                    exprType: str = 'integer'
                else:
                    exprType: str = 'real'
            case [ None, None ]:
                # if both operands are None then result of the operation will be None
                exprType: str = None
            case _:
                # custom types have precedence
                # TODO mod custom type with second type
                exprType: str = ctx.op.text.join( [ str(leftType), str(leftType) ] )

        # Mark last added operation as not last operation
        self.lastOpID = None

        # return determined type
        return exprType

    # Visit a parse tree produced by TestSuiteParser#addSubExpr.
    def visitAddSubExpr( self, ctx: TestSuiteParser.AddSubExprContext ):
        # extract left and right operator
        leftType = self.visit( ctx.left )
        rightType = self.visit( ctx.right )

        # extract types from function references
        # https://web.chem.ox.ac.uk/fortran/arithmetic.html
        match (leftType.lower( ) if leftType else None, rightType.lower( ) if rightType else None):
            case [ 'real', _ ]:
                # if any of the operands are real then result of the operation will be real
                exprType: str = 'real'
            case [ _, 'real' ]:
                # if any of the operands are real then result of the operation will be real
                exprType: str = 'real'
            case [ 'integer', 'integer' ]:
                # if all the operands are integer then result of the operation will be integer
                exprType: str = 'integer'
            case [ None, None ]:
                # if both operands are None then result of the operation will be None
                exprType: str = None
            case _:
                # custom types have precedence
                # TODO mod custom type with second type
                exprType: str = ctx.op.text.join( [ str(leftType), str(leftType) ] )

        # Mark last added operation as not last operation
        self.lastOpID = None

        # return determined type
        return exprType

    # Visit a parse tree produced by TestSuiteParser#signExpr.
    def visitSignExpr( self, ctx: TestSuiteParser.SignExprContext ):
        innerType = self.visit( ctx.inner )
        return innerType

    # Visit a parse tree produced by TestSuiteParser#numberExpr.
    def visitNumberExpr( self, ctx: TestSuiteParser.NumberExprContext ):
        # power and decimal operation will be real
        return 'real'

    # Visit a parse tree produced by TestSuiteParser#strExpr.
    def visitStrExpr( self, ctx: TestSuiteParser.StrExprContext ):
        # custom types will be string
        # TODO add specific custom types
        return 'character(len = *)'

    # Visit a parse tree produced by TestSuiteParser#intExpr.
    def visitIntExpr( self, ctx: TestSuiteParser.IntExprContext ):
        # Integer operation will be integer
        return 'integer'

    # Visit a parse tree produced by TestSuiteParser#refExpr.
    def visitRefExpr( self, ctx: TestSuiteParser.RefExprContext ):
        # Return reference type
        return self.visit( ctx.value )
