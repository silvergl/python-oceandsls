from unittest import main, TestCase

import sys
sys.path.append( '../../../../build-python' )

from antlr4 import *
from TestGrammar.TestGrammarLexer import TestGrammarLexer, ParserRuleContext
from TestGrammar.TestGrammarParser import TestGrammarParser
from TestGrammar.TestGrammarVisitor import TestGrammarVisitor
from antlr4.error.ErrorListener import ErrorListener
from antlr4.Recognizer import Recognizer

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
        lexer = TestGrammarLexer(input_stream)
        lexer.removeErrorListeners()
        lexer.addErrorListener(error_listener)

        tokenStream = CommonTokenStream(lexer)

        parser = TestGrammarParser(tokenStream)
        parser.removeErrorListeners()
        parser.addErrorListener(error_listener)

        # launch parser by invoking rule 'prog'
        ast = parser.prog()


if __name__ == '__main__':
    main()