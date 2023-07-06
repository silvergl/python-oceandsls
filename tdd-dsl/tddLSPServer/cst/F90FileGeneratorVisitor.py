'''FileGeneratorVisitor module.'''

# util
import os
from typing import Dict, List, Tuple

# jinja2
from jinja2 import Environment, FileSystemLoader

# user relative imports
from ..fileWriter.fileWriter import write_file
from ..gen.python.TestSuite.TestSuiteParser import TestSuiteParser
from ..gen.python.TestSuite.TestSuiteVisitor import TestSuiteVisitor


class F90FileGeneratorVisitor( TestSuiteVisitor ):
    fileTemplates: Dict[ int, str ]
    templatePath: str
    workPath: str
    workFolder: str
    testFilePredicate: str
    environment: Environment

    # TODO hc
    def __init__( self, templatePath: str = 'tdd-dsl/tddLSPServer/fileWriter/jinja-templates/f90', files: dict[ str, Tuple[ float, str, str ] ] = {}, workPath: str = 'tdd-dsl/output', workFolder: str = 'tests' ):
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
        self.environment = Environment( loader = FileSystemLoader( templatePath ) )

        # variable flags
        self.foundRef: bool = False
        self.foundPar: bool = False

        self.fileTemplates = {}
        # Get template file names from grammar
        i: int = 0
        for rule in TestSuiteParser.ruleNames:
            self.fileTemplates[ i ] = f'{rule}_template.txt'
            i += 1

    # Visit a parse tree produced by TestSuiteParser#test_case.
    def visitTest_case( self, ctx: TestSuiteParser.Test_caseContext ) -> dict[ str, Tuple[ float, str, str ] ]:
        # Load Jinja2 template
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )

        # Get test case template parameters
        name = ctx.name.text

        opsNames: List[ str] = [ ]
        opsImpl: List[ str] = [ ]
        for assertion in ctx.assertions:
            operation: Tuple [str, str] = self.visit( assertion )
            opsNames.append( operation[0] )
            opsImpl.append( operation[1] )

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
            self.files[ absPath ] = write_file( self.testPath, self.testFolder, name, content, fileAttr)
        else:
            # Write  file
            self.files[ absPath ] = write_file( self.testPath, self.testFolder, name, content)

        # TODO find test cases in children?
        self.visitChildren( ctx )

        # Return list of generated files
        return self.files

    # Visit a parse tree produced by TestSuiteParser#funRef.
    def visitFunRef( self, ctx: TestSuiteParser.FunRefContext ):
        self.foundRef = True
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        name = ctx.ID( ).getText( )
        args = [ ]
        for arg in ctx.args:
            args.append( self.visit( arg ) )
        return template.render( name = name, args = args )

    # Visit a parse tree produced by TestSuiteParser#varRef.
    def visitVarRef( self, ctx: TestSuiteParser.VarRefContext ):
        self.foundRef = True
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        name = ctx.ID( ).getText( )
        return template.render( name = name )

    # Visit a parse tree produced by TestSuiteParser#parensExpr.
    def visitParensExpr( self, ctx: TestSuiteParser.ParensExprContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        inner = self.visit( ctx.inner )
        return template.render( inner = inner )

    # Visit a parse tree produced by TestSuiteParser#mulDivExpr.
    def visitMulDivExpr( self, ctx: TestSuiteParser.MulDivExprContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        left = self.visit( ctx.left )
        right = self.visit( ctx.right )
        op = ctx.op.text
        return template.render( left = left, right = right, op = op )

    # Visit a parse tree produced by TestSuiteParser#addSubExpr.
    def visitAddSubExpr( self, ctx: TestSuiteParser.AddSubExprContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        left = self.visit( ctx.left )
        right = self.visit( ctx.right )
        op = ctx.op.text
        return template.render( left = left, right = right, op = op )

    # Visit a parse tree produced by TestSuiteParser#signExpr.
    def visitSignExpr( self, ctx: TestSuiteParser.SignExprContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        inner = self.visit( ctx.inner )
        op = ctx.op.text
        return template.render( inner = inner, op = op )

    # Visit a parse tree produced by TestSuiteParser#numberExpr.
    def visitNumberExpr( self, ctx: TestSuiteParser.NumberExprContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        value = ctx.value.text
        return template.render( value = value )

    # Visit a parse tree produced by TestSuiteParser#strExpr.
    def visitStrExpr( self, ctx: TestSuiteParser.StrExprContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        value = ctx.value.text
        return template.render( value = value )

    # Visit a parse tree produced by TestSuiteParser#intExpr.
    def visitIntExpr( self, ctx: TestSuiteParser.IntExprContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        value = ctx.value.text
        return template.render( value = value )

    # Visit a parse tree produced by TestSuiteParser#refExpr.
    def visitRefExpr( self, ctx: TestSuiteParser.RefExprContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        value = self.visit( ctx.value )
        return template.render( value = value )