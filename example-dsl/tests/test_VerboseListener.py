"""exampleDsl test."""

__author__ = 'sgu'

# pytest
from unittest import main, TestCase, SkipTest

#utils
import sys, os

# debug import
# from pprint import pprint
# pprint(sys.path)

# antlr
from antlr4.error.ErrorListener import ErrorListener
from antlr4.Recognizer import Recognizer, RecognitionException
from antlr4.InputStream import InputStream
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.Token import Token

# user relative imports
try:
    # fail relative import beyond top-level package
    from ..exampleLSPServer.gen.python.exampleDsl.exampleDslLexer import exampleDslLexer, ParserRuleContext
    from ..exampleLSPServer.gen.python.exampleDsl.exampleDslParser import exampleDslParser
    from ..exampleLSPServer.gen.python.exampleDsl.exampleDslVisitor import exampleDslVisitor
except Exception as inst:
    # debug import
    import sys, os
    from pprint import pprint
    pprint(sys.path)
    raise SkipTest("Skipping all tests in test_feature.py")



class VerboseListener(ErrorListener):
    def __init__(self):
        super().__init__()

    def test(self=None, msg:str="bar"):
        print(msg)

    def syntaxError(self, recognizer:Recognizer, offendingSymbol:Token, line:int, column:int, msg:str, e:RecognitionException = None):
        print("ERROR: when parsing line %d column %d: %s\n" % (line, column, msg), file=sys.stderr)
        # raise Exception("ERROR: when parsing line %d column %d: %s\n" % (line, column, msg))


class TestMyParser(TestCase):
    def test_with_testfile(self):
        # set listener
        error_listener = VerboseListener()
        # create input stream of characters for lexer
        input_stream = InputStream( "c = + b()\n" )

        # create lexer and parser objects and token stream pipe between them
        lexer = exampleDslLexer(input_stream)
        lexer.removeErrorListeners()
        lexer.addErrorListener(error_listener)

        tokenStream = CommonTokenStream(lexer)

        parser = exampleDslParser(tokenStream)
        parser.removeErrorListeners()
        parser.addErrorListener(error_listener)

        # launch parser by invoking rule 'prog'
        ast = parser.prog()


if __name__ == '__main__':
    main()