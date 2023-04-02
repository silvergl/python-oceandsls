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
    fileTemplates: Dict[int,str]
    templatePath: str
    testPath: str
    testFolder: str
    testFilePredicate: str
    environment :Environment


    def __init__(self, templatePath: str = 'templates/tdd', testPath: str = 'gen', testFolder: str = 'test', testFilePredicate: str = 'test_'):
        '''
        Build template file dictionary from TestSuiteParser.ruleNames

        :param templatePath: relative filepath for jinja templates
        :param testPath: relative path to generate test suite
        :param testFolder: relative path under :testPath: to save pfUnit tests
        :param testFilePredicate: predicate for pfUnit tests filenames
        '''
        super().__init__()
        self.templatePath =templatePath
        self.testPath =testPath
        self.testFolder =testFolder
        self.testFilePredicate =testFilePredicate
        self.environment = Environment( loader=FileSystemLoader( templatePath ) )

        i : int = 0
        for rule in TestSuiteParser.ruleNames:
            self.fileTemplates[i] = f'{rule}_template.txt'
            i += 1
            pass

    # Visit a parse tree produced by TestSuiteParser#test_case.
    def visitTest_case(self, ctx:TestSuiteParser.Test_caseContext):

        template = self.environment.get_template( self.fileTemplates[1] )
        return self.visitChildren(ctx)