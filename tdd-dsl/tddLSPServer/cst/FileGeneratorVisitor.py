'''FileGeneratorVisitor module.'''

# util
import os
from typing import Dict

# jinja2
from jinja2 import Environment, FileSystemLoader

# user relative imports
from ..fileWriter.fileWriter import write_file
from ..gen.python.TestSuite.TestSuiteParser import TestSuiteParser
from ..gen.python.TestSuite.TestSuiteVisitor import TestSuiteVisitor


class FileGeneratorVisitor( TestSuiteVisitor ):
    fileTemplates: Dict[ int, str ]
    templatePath: str
    testPath: str
    testFolder: str
    testFilePredicate: str
    environment: Environment

    def __init__( self, templatePath: str = 'tdd-dsl/tddLSPServer/fileWriter/jinja-templates', testRootPath: str = 'tdd-dsl/output', testFolder: str = 'tests' ):
        '''
        Build template file dictionary from TestSuiteParser.ruleNames

        Write/merge pFUnit-file to :test_path:/:test_folder:/:filename:.pf

        :param templatePath: relative filepath for jinja templates
        :param testRootPath: relative path to generate test suite
        :param testFolder: relative path under :testPath: to save pfUnit tests
        '''
        super( ).__init__( )
        self.templatePath = templatePath
        self.testPath = testRootPath
        self.testFolder = testFolder
        # Load Jinja2 templates
        self.environment = Environment( loader = FileSystemLoader( templatePath ) )

        self.fileTemplates = {}
        # Get template file names from grammar
        i: int = 0
        for rule in TestSuiteParser.ruleNames:
            self.fileTemplates[ i ] = f'{rule}_template.txt'
            i += 1

    # Visit a parse tree produced by TestSuiteParser#test_case.
    def visitTest_case( self, ctx: TestSuiteParser.Test_caseContext ):
        # Load Jinja2 template
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        # Render template
        name = ctx.name.text
        scope = self.visit( ctx.scope )
        vars_ = self.visit( ctx.vars_ )
        assertions = [ ]
        for assertion in ctx.assertions:
            assertions.append( self.visit( assertion ) )
        content = template.render( name = name, scope = scope, vars_ = vars_, assertions = assertions )
        write_file( self.testPath, self.testFolder, name, content )
        # TODO find test cases in children?
        return self.visitChildren( ctx )

    # Visit a parse tree produced by TestSuiteParser#test_scope.
    def visitTest_scope( self, ctx: TestSuiteParser.Test_scopeContext ):
        return self.visit( ctx.test_modules( ) )

    # Visit a parse tree produced by TestSuiteParser#test_files.
    def visitTest_files( self, ctx: TestSuiteParser.Test_filesContext ):
        # TODO forward filepath
        return self.visitChildren( ctx )

    # Get rendered list of used modules
    def visitTest_modules( self, ctx: TestSuiteParser.Test_modulesContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        return template.render( modules = ctx.modules )

    # Visit a parse tree produced by TestSuiteParser#test_vars.
    def visitTest_vars( self, ctx: TestSuiteParser.Test_varsContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        vars = [ ]
        for var in ctx.vars_:
            vars.append( self.visit( var ) )
        return template.render( vars = vars )

    # Visit a parse tree produced by TestSuiteParser#test_vars.
    def visitTest_var( self, ctx: TestSuiteParser.Test_varContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        decl = self.visit( ctx.varDeclaration( ) )
        value = self.visit( ctx.expr( ) )
        comment = self.visit( ctx.optionalDesc( ) )
        # match comment:
        #     case None:
        #         template.render( decl=decl, value=value)
        #     case _:
        #         template.render( decl=decl, value=value, comment=comment )
        if comment:
            return template.render( decl = decl, value = value, comment = comment )
        else:
            return template.render( decl = decl, value = value )

    # Visit a parse tree produced by TestSuiteParser#varDeclaration.
    def visitVarDeclaration( self, ctx: TestSuiteParser.VarDeclarationContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        name = ctx.ID( ).getText( )
        type = self.visit( ctx.type_ )
        keys = [ ]
        for key in ctx.keys:
            keys.append( key.keyword.text )
        # match keys:
        #     case []:
        #         return template.render( name=name, type=type )
        #     case _:
        #         return template.render( name=name, type=type, keys=keys )
        if keys:
            return template.render( name = name, type = type, keys = keys )
        else:
            return template.render( name = name, type = type )

    # Visit a parse tree produced by TestSuiteParser#ref.
    def visitRef( self, ctx: TestSuiteParser.RefContext ):
        return self.visitChildren( ctx )

    # Visit a parse tree produced by TestSuiteParser#funRef.
    def visitFunRef( self, ctx: TestSuiteParser.FunRefContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        name = ctx.ID( ).getText( )
        args = [ ]
        for arg in ctx.args:
            args.append( self.visit( arg ) )
        return template.render( name = name, args = args )

    # Visit a parse tree produced by TestSuiteParser#varRef.
    def visitVarRef( self, ctx: TestSuiteParser.VarRefContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        name = ctx.ID( ).getText( )
        return template.render( name = name )

    # Visit a parse tree produced by TestSuiteParser#enm.
    def visitEnm( self, ctx: TestSuiteParser.EnmContext ):
        # TODO type ENUM
        return self.visitChildren( ctx )

    # Visit a parse tree produced by TestSuiteParser#array.
    def visitArray( self, ctx: TestSuiteParser.ArrayContext ):
        # TODO type ARRAY
        return self.visitChildren( ctx )

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

    # Visit a parse tree produced by TestSuiteParser#emptyDesc.
    def visitEmptyDesc( self, ctx: TestSuiteParser.EmptyDescContext ):
        return None

    # Visit a parse tree produced by TestSuiteParser#specDesc.
    def visitSpecDesc( self, ctx: TestSuiteParser.SpecDescContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        type = self.visit( ctx.value )
        comment = self.visit( ctx.value )
        return template.render( type = type, comment = comment )

    # Visit a parse tree produced by TestSuiteParser#emptyComment.
    def visitEmptyComment( self, ctx: TestSuiteParser.EmptyCommentContext ):
        return None

    # Visit a parse tree produced by TestSuiteParser#specComment.
    def visitSpecComment( self, ctx: TestSuiteParser.SpecCommentContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        comment = ctx.comment.text
        return template.render( comment = comment )

    # Visit a parse tree produced by TestSuiteParser#test_assertion.
    def visitTest_assertion( self, ctx: TestSuiteParser.Test_assertionContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        directive = self.visit( ctx.directive )
        input_ = self.visit( ctx.input_ )
        output = self.visit( ctx.output )
        pubAttributes = self.visit( ctx.attr )
        comment = ctx.comment.text.rstrip( '\n' ) if ctx.comment is not None else None
        match (pubAttributes, comment):
            case [ None, None ]:
                return template.render( directive = directive, input_ = input_, output = output )
            case [ None, _ ]:
                return template.render( directive = directive, input_ = input_, output = output, comment = comment )
            case [ _, None ]:
                return template.render( directive = directive, input_ = input_, output = output, pubAttributes = pubAttributes )
            case _:
                return template.render(
                    directive = directive, input_ = input_, output = output, pubAttributes = pubAttributes,
                    comment = comment
                    )

    # Visit a parse tree produced by TestSuiteParser#test_directive.
    def visitTest_directive( self, ctx: TestSuiteParser.Test_directiveContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        ppDirective = ctx.ppDirective.text
        return template.render( ppDirective = ppDirective )

    # Visit a parse tree produced by TestSuiteParser#test_parameter.
    def visitTest_parameter( self, ctx: TestSuiteParser.Test_parameterContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        # TODO use decl and comment in upper template
        value = self.visit( ctx.value )
        return template.render( value = value )

    # Visit a parse tree produced by TestSuiteParser#pubAttributes.
    def visitPubAttributes( self, ctx: TestSuiteParser.PubAttributesContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        msg = ctx.msg.text if ctx.msg is not None else None
        tol = self.visit( ctx.tol ) if ctx.tol is not None else None
        match (msg, tol):
            case [ None, None ]:
                return None
            case [ None, _ ]:
                return template.render( tol = tol )
            case [ _, None ]:
                return template.render( msg = msg )
            case _:
                return template.render( msg = msg, tol = tol )

    def writefile( self, path = None, filename = None ):
        path = os.path.join( os.getcwd( ), path, filename )
        if not os.path.exists( path ):
            # Write rendered and optional merged content to file
            with open( path, mode = 'w', encoding = 'utf-8' ) as f:
                f.write( )
                # TODO add to debug info
                print( f'... wrote {path}' )
