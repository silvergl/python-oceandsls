from dataclasses import field
from typing import Generic, Callable, List, Dict

# util imports
import sys, os, logging

# antlr4
if not os.path.join( sys.path[0], 'build-python' ) in sys.path:
    sys.path.append( os.path.join( sys.path[0], 'build-python' ) )

from TestSuite.TestSuiteVisitor import TestSuiteVisitor
from TestSuite.TestSuiteParser import TestSuiteParser

from jinja2 import Environment, FileSystemLoader


class FileGeneratorVisitor( TestSuiteVisitor ):
    fileTemplates: Dict[int, str]
    templatePath: str
    testPath: str
    testFolder: str
    testFilePredicate: str
    environment: Environment

    def __init__(self, templatePath: str = 'templates/tdd', testPath: str = 'gen', testFolder: str = 'test',
                 testFilePredicate: str = 'test_'):
        '''
        Build template file dictionary from TestSuiteParser.ruleNames

        :param templatePath: relative filepath for jinja templates
        :param testPath: relative path to generate test suite
        :param testFolder: relative path under :testPath: to save pfUnit tests
        :param testFilePredicate: predicate for pfUnit tests filenames
        '''
        super().__init__()
        self.templatePath = templatePath
        self.testPath = testPath
        self.testFolder = testFolder
        self.testFilePredicate = testFilePredicate
        self.fileTemplates = {}
        # Load Jinja2 templates
        self.environment = Environment( loader=FileSystemLoader( templatePath ) )

        i: int = 0
        for rule in TestSuiteParser.ruleNames:
            self.fileTemplates[i] = f'{rule}_template.txt'
            i += 1
            pass

    # Visit a parse tree produced by TestSuiteParser#test_case.
    def visitTest_case(self, ctx: TestSuiteParser.Test_caseContext):
        # Load Jinja2 template
        template = self.environment.get_template( self.fileTemplates[ctx.getRuleIndex()] )
        # Render template
        name = ctx.ID().getText()
        scope = self.visit( ctx.test_scope() )
        test_vars = self.visit( ctx.test_vars() )
        # TODO get assertions
        assertions = self.visit( ctx.test_assertion() )
        # TODO get comment
        content = template.render( name=name, scope=scope, vars=test_vars, assertions=assertions )
        return self.visitChildren( ctx )

    # Visit a parse tree produced by TestSuiteParser#test_scope.
    def visitTest_scope(self, ctx:TestSuiteParser.Test_scopeContext):
        return self.visit( ctx.test_modules() )

    # Visit a parse tree produced by TestSuiteParser#test_files.
    def visitTest_files(self, ctx:TestSuiteParser.Test_filesContext):
        # TODO forward filepath
        return self.visitChildren(ctx)

    # Get rendered list of used modules
    def visitTest_modules(self, ctx:TestSuiteParser.Test_modulesContext):
        template = self.environment.get_template( self.fileTemplates[ctx.getRuleIndex()] )
        return template.render( modules=ctx.modules )

    # Visit a parse tree produced by TestSuiteParser#test_vars.
    def visitTest_vars(self, ctx:TestSuiteParser.Test_varsContext):
        template = self.environment.get_template( self.fileTemplates[ctx.getRuleIndex()] )
        vars = []
        for var in ctx.vars_:
            vars.append(self.visit(var))
        return template.render( vars=vars )

    # Visit a parse tree produced by TestSuiteParser#test_vars.
    def visitTest_var(self, ctx:TestSuiteParser.Test_varContext):
        template = self.environment.get_template( self.fileTemplates[ctx.getRuleIndex()] )
        decl = self.visit(ctx.varDeclaration())
        value = self.visit(ctx.expr())
        comment = self.visit(ctx.optionalDesc())
        return template.render( decl=decl, value=value, comment=comment )

    # Visit a parse tree produced by TestSuiteParser#varDeclaration.
    def visitVarDeclaration(self, ctx:TestSuiteParser.VarDeclarationContext):
        template = self.environment.get_template( self.fileTemplates[ctx.getRuleIndex()] )
        name = ctx.ID().getText()
        type = self.visit(ctx.type_)
        keys = []
        for key in ctx.keys:
            key.append(key.keyword.text)
        return template.render( name=name, type=type, keys=keys )

    # Visit a parse tree produced by TestSuiteParser#ref.
    def visitRef(self, ctx:TestSuiteParser.RefContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by TestSuiteParser#funRef.
    def visitFunRef(self, ctx:TestSuiteParser.FunRefContext):
        template = self.environment.get_template( self.fileTemplates[ctx.getRuleIndex()] )
        name = ctx.ID().getText()
        args = []
        for arg in ctx.args:
            args.append(self.visit(arg))
        return template.render( name= name, args = args)


    # Visit a parse tree produced by TestSuiteParser#varRef.
    def visitVarRef(self, ctx:TestSuiteParser.VarRefContext):
        template = self.environment.get_template( self.fileTemplates[ctx.getRuleIndex()] )
        name = ctx.ID().getText()
        return template.render( name= name )



    # Visit a parse tree produced by TestSuiteParser#enm.
    def visitEnm(self, ctx:TestSuiteParser.EnmContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#array.
    def visitArray(self, ctx:TestSuiteParser.ArrayContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by TestSuiteParser#strExpr.
    def visitStrExpr(self, ctx:TestSuiteParser.StrExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#intExpr.
    def visitIntExpr(self, ctx:TestSuiteParser.IntExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#addSubExpr.
    def visitAddSubExpr(self, ctx:TestSuiteParser.AddSubExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#refExpr.
    def visitRefExpr(self, ctx:TestSuiteParser.RefExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#numberExpr.
    def visitNumberExpr(self, ctx:TestSuiteParser.NumberExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#testExpr.
    def visitTestExpr(self, ctx:TestSuiteParser.TestExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#parensExpr.
    def visitParensExpr(self, ctx:TestSuiteParser.ParensExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#mulDivExpr.
    def visitMulDivExpr(self, ctx:TestSuiteParser.MulDivExprContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by TestSuiteParser#emptyDesc.
    def visitEmptyDesc(self, ctx:TestSuiteParser.EmptyDescContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#specDesc.
    def visitSpecDesc(self, ctx:TestSuiteParser.SpecDescContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by TestSuiteParser#test_assertion.
    def visitTest_assertion(self, ctx:TestSuiteParser.Test_assertionContext):
        # TODO note case.assertions[0].test_input().parameter()[0].expr().value.ID()
        return 'assertion'

    def writefile(self, path=None, filename=None):
        path = os.path.join( os.getcwd(), path, filename )
        if not os.path.exists( path ):
            # Write rendered and optional merged content to file
            with open( path, mode='w', encoding='utf-8' ) as f:
                f.write()
                # TODO add to debug info
                print( f'... wrote {path}' )