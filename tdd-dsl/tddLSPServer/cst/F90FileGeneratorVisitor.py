'''FileGeneratorVisitor module.'''

__author__ = 'sgu'

# util
import os
from typing import Dict, List, Tuple

# jinja2
from jinja2 import Environment, FileSystemLoader

# user relative imports
from ..symbolTable.SymbolTable import SymbolTable, FunctionSymbol, ModuleSymbol, RoutineSymbol
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

    # TODO hc
    def __init__( self, templatePath: str = 'tdd-dsl/tddLSPServer/fileWriter/jinja-templates/f90', files: dict[ str, Tuple[ float, str, str ] ] = {}, symbolTable: SymbolTable = None, workPath: str = 'tdd-dsl/output', workFolder: str = 'tests' ):
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
        # Load Jinja2 templates
        self.environment = Environment( loader = FileSystemLoader( templatePath ), trim_blocks=True, lstrip_blocks = True, keep_trailing_newline = False )

        # variable flags
        self.foundRef: bool = False
        self.foundPar: bool = False

        # set symboltable
        self._symbolTable: SymbolTable = symbolTable

        self.fileTemplates = {}
        # Get template file names from grammar
        i: int = 0
        for rule in TestSuiteParser.ruleNames:
            self.fileTemplates[ i ] = f'{rule}_template.txt'
            i += 1

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
        name = ctx.name.text

        opsNames: List[ str ] = [ ]
        opsImpl: List[ str ] = [ ]
        for assertion in ctx.assertions:
            operation: Tuple[ str, str ] = self.visit( assertion )
            opsNames.append( operation[ 0 ] )
            opsImpl.append( operation[ 1 ] )

        # Render template
        content = template.render( name = name, opsNames = opsNames, ops = opsImpl )

        # Write content to file

        # Get path destination
        self.testPath = self.visit( ctx.src_path( ) )
        absPath: str = os.path.join( os.getcwd( ), self.testPath, self.testFolder, name, )

        # Are the files previously generated?
        fileAttr = self.files.get( absPath )
        # TODO alternative fileAttr = None ?
        if fileAttr:
            # Write  file
            self.files[ absPath ] = write_file( self.testPath, self.testFolder, name, content, fileAttr )
        else:
            # Write  file
            self.files[ absPath ] = write_file( self.testPath, self.testFolder, name, content )

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
        self.workPath: str = os.path.join( self.workPath, userPath )

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
        return getScope(ctx, self.symbolTable)

    # Visit a parse tree produced by TestSuiteParser#test_assertion.
    def visitTest_assertion( self, ctx: TestSuiteParser.Test_assertionContext ):
        # template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        template = self.environment.get_template( 'tmp_dev.txt')
        template.render( comment = 'test comment', integer = 1)

        comment = ctx.comment.text.rstrip( '\n' ).lstrip( '#' ) if ctx.comment is not None else None

        ops: dict[ str, List[ str ], str ] = self.visit( ctx.input_ )
        ret: dict[ str, List[ str ], str ] = self.visit( ctx.output )

        opsName: str = ''
        args: int = 0
        argTypes: List[ str ] = [ ]

        returnUnit: str = ''
        returnName: str = ''
        returnDecl: str = ''

    # Visit a parse tree produced by TestSuiteParser#test_parameter.
    def visitTest_parameter( self, ctx: TestSuiteParser.Test_parameterContext ):
        # get value name and optional argument types
        valueDecl: Tuple[ str, List[ str ] ] = self.visit( ctx.value )

        # unit of expression
        exprUnit: str = self.visit( ctx.comment )

        # return value expression and unit of expression
        # TODO rm declaration from grammar?
        return valueDecl, exprUnit

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
        name: str = ctx.ID( ).getText( )
        args: List[ str ] = [ ]
        for arg in ctx.args:
            args.append( self.visit( arg ) )
        return name, args

    # Visit a parse tree produced by TestSuiteParser#varRef.
    def visitVarRef( self, ctx: TestSuiteParser.VarRefContext ):
        name = ctx.ID( ).getText( )
        return name, None

    # Visit a parse tree produced by TestSuiteParser#parensExpr.
    def visitParensExpr( self, ctx: TestSuiteParser.ParensExprContext ):
        innerType = self.visit( ctx.inner )
        return innerType

    # Visit a parse tree produced by TestSuiteParser#mulDivExpr.
    def visitMulDivExpr( self, ctx: TestSuiteParser.MulDivExprContext ):
        leftType = self.visit( ctx.left )
        rightType = self.visit( ctx.right )
        # https://web.chem.ox.ac.uk/fortran/arithmetic.html
        match (leftType, rightType):
            case [ 'real', _ ]:
                # if any of the operands are real then result of the operation will be real
                return 'real'
            case [ _, 'real' ]:
                # if any of the operands are real then result of the operation will be real
                return 'real'
            case [ 'integer', 'integer' ]:
                if ctx.op == '*':
                    # if all the operands are integer then result of the operation will be integer
                    return 'integer'
                else:
                    return 'real'
            case _:
                # custom types have precedence
                # TODO mod custom type with second type
                return 'character(:),allocatable'

    # Visit a parse tree produced by TestSuiteParser#addSubExpr.
    def visitAddSubExpr( self, ctx: TestSuiteParser.AddSubExprContext ):
        leftType = self.visit( ctx.left )
        rightType = self.visit( ctx.right )
        # https://web.chem.ox.ac.uk/fortran/arithmetic.html
        match (leftType, rightType):
            case [ 'real', _ ]:
                # if any of the operands are real then result of the operation will be real
                return 'real'
            case [ _, 'real' ]:
                # if any of the operands are real then result of the operation will be real
                return 'real'
            case [ 'integer', 'integer' ]:
                # if all the operands are integer then result of the operation will be integer
                return 'integer'
            case _:
                # custom types have precedence
                # TODO mod custom type with second type
                return 'character(:),allocatable'

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
        return 'character(:),allocatable'

    # Visit a parse tree produced by TestSuiteParser#intExpr.
    def visitIntExpr( self, ctx: TestSuiteParser.IntExprContext ):
        # Integer operation will be integer
        return 'integer'

    # Visit a parse tree produced by TestSuiteParser#refExpr.
    def visitRefExpr( self, ctx: TestSuiteParser.RefExprContext ):
        # get the id, optional number of arguments and their types
        valueDecl: Tuple[ str, List[ str ] ] = self.visit( ctx.value )
        return valueDecl
