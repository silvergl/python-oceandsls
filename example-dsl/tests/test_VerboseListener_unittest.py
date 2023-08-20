"""exampleDsl test."""

__author__ = 'sgu'

# unittest
from unittest import SkipTest, TestCase

# antlr
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.InputStream import InputStream

# user relative imports
from cst.VerboseListener import VerboseListener
from gen.python.exampleDsl.exampleDslLexer import exampleDslLexer
from gen.python.exampleDsl.exampleDslParser import exampleDslParser

# fail relative import beyond top-level package
# try:
#     from ..exampleLSPServer.cst.VerboseListener import VerboseListener
#     from ..exampleLSPServer.gen.python.exampleDsl.exampleDslLexer import exampleDslLexer
#     from ..exampleLSPServer.gen.python.exampleDsl.exampleDslParser import exampleDslParser
# except Exception as inst:
#     # debug import
#     import sys, os
#     from pprint import pprint
#
#     pprint( sys.path )
#     raise SkipTest( "Skipping all tests in test_feature.py" )


class TestVerboseListener(TestCase):

    def setup(self, msg: str = "") -> exampleDslParser:
        # set listener
        self.errorListener = VerboseListener()
        # create input stream of characters for lexer
        inputStream = InputStream(msg)

        # create lexer and parser objects and token stream pipe between them
        lexer = exampleDslLexer(inputStream)
        lexer.removeErrorListeners()
        lexer.addErrorListener(self.errorListener)

        tokenStream = CommonTokenStream(lexer)

        parser = exampleDslParser(tokenStream)
        parser.removeErrorListeners()
        parser.addErrorListener(self.errorListener)

        return parser

    def test_valid_input(self):
        # launch parser by invoking rule 'prog'
        parser = self.setup("c = a + b()\n")
        ast = parser.prog()

        # check for no symbols in errorListener
        self.assertEqual(len(self.errorListener.symbol), 0)

    def test_invalid_input(self):
        parser = self.setup("c = + b()\n")
        ast = parser.prog()

        # check for '+' symbol in errorListener
        self.assertEqual(self.errorListener.symbol, '+')
