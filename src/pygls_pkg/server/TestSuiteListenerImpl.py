from antlr4 import *

# util imports
import sys, os, logging


# antlr4
if not os.path.join( sys.path[0], 'build-python' ) in sys.path:
    sys.path.append( os.path.join( sys.path[0], 'build-python' ) )
from antlr4 import InputStream, CommonTokenStream, Token
from TestSuite.TestSuiteLexer import TestSuiteLexer
from TestSuite.TestSuiteParser import TestSuiteParser
from jinja_tdd.tdd_gen_dev import TestCase

from TestSuite.TestSuiteListener import TestSuiteListener


class TestSuiteListenerImpl(TestSuiteListener):
    def __init__(self):
        self.test_case_stack = []

    # Exit a parse tree produced by TestSuiteParser#test_suite.
    def exitTest_suite(self, ctx:TestSuiteParser.Test_suiteContext):
        for case in ctx.cases:
            id = case.ID().getText()
            case.scope
        # TODO case.assertions[0].test_input().parameter()[0].expr().value.ID()
        # in tdd_pf_template_from_Test_caseContext

    # Exit a parse tree produced by TestSuiteParser#test_case.
    def exitTest_case(self, ctx:TestSuiteParser.Test_caseContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#test_vars.
    def exitTest_vars(self, ctx:TestSuiteParser.Test_varsContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#test_var.
    def exitTest_var(self, ctx:TestSuiteParser.Test_varContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#varDeclaration.
    def exitVarDeclaration(self, ctx:TestSuiteParser.VarDeclarationContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#test_files.
    def exitTest_files(self, ctx:TestSuiteParser.Test_filesContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#test_scope.
    def exitTest_scope(self, ctx:TestSuiteParser.Test_scopeContext):
        pass