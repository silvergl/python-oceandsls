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
        test_vars = self.visitChildren( ctx.test_vars() )
        # TODO get assertions
        assertions = self.visitChildren( ctx.test_assertion() )
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
        # TODO add template
        return template.render( vars=ctx.vars )

    # Visit a parse tree produced by TestSuiteParser#test_assertion.
    def visitTest_assertion(self, ctx:TestSuiteParser.Test_assertionContext):
        # TODO note case.assertions[0].test_input().parameter()[0].expr().value.ID()
        return 'assertion'