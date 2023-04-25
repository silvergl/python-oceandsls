"""anlr4 Listener example"""

__author__ = 'sgu'

# utils
import sys, os
import logging
from typing import List, Union

from antlr4.error.ErrorListener import ErrorListener
from antlr4.Recognizer import Recognizer, RecognitionException
from antlr4.InputStream import InputStream
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.Token import Token

# user relative imports
from ..gen.python.exampleDsl.exampleDslLexer import exampleDslLexer, ParserRuleContext
from ..gen.python.exampleDsl.exampleDslParser import exampleDslParser
from ..gen.python.exampleDsl.exampleDslVisitor import exampleDslVisitor

# pygls
from lsprotocol.types import (Diagnostic, Range, Position)

# debug import
from pprint import pprint

pprint( sys.path )


class VerboseListener( ErrorListener ):
    def __init__(self):
        self.diagnostics: List[Diagnostic] = []
        super().__init__()

    def test(self=None, msg: str = "bar"):
        print( msg )

    def syntaxError(self, recognizer: Recognizer, offendingSymbol: Token, line: int, column: int, msg: str,
                    e: RecognitionException = None):
        self.diagnostics.append(
            Diagnostic(
                range=Range(
                    start=Position(
                        line=line - 1,
                        character=column - 1 ),
                    end=Position(
                        line=line - 1,
                        character=column )
                ),
                message=msg
            )
        )
        print( 'ERROR: when parsing line %d column %d: %s\n' % (line, column, msg), file=sys.stderr )
        # raise Exception("ERROR: when parsing line %d column %d: %s\n" % (line, column, msg))


if __name__ == '__main__':
    # set listener
    error_listener = VerboseListener()
    # create input stream of characters for lexer
    input_stream = InputStream( "c = + b()\n" )
    # if len(sys.argv) > 1:
    #     pass
    #     # input_stream = FileStream(sys.argv[1])
    # else:
    #     # TODO move parameters into file
    #     input_stream = InputStream(sys.stdin.readline())

    # create lexer and parser objects and token stream pipe between them
    lexer = exampleDslLexer( input_stream )
    lexer.removeErrorListeners()
    lexer.addErrorListener( error_listener )

    tokenStream = CommonTokenStream( lexer )

    parser = exampleDslParser( tokenStream )
    parser.removeErrorListeners()
    parser.addErrorListener( error_listener )

    # launch parser by invoking rule 'prog'
    try:
        ast = parser.prog()
    except SyntaxError as syn_inst:
        logging.exception( "parser raised syntax exception" )
    except Exception as inst:
        # print(type(inst))    # the exception instance
        # print(inst.args)     # arguments stored in .args
        # print(inst)          # __str__ allows args to be printed directly,
        # but may be overridden in exception subclasses
        # x, y = inst.args     # unpack args
        # print('x =', x)
        # print('y =', y)

        logging.exception( "parser raised exception" )
        # logging.exception("the exception instance '" + str(type(inst)) + "'")
        # logging.exception("arguments stored in .args '" + str(inst.args) + "'")
        # logging.exception("__str__ allows args to be printed directly '" + str(inst) + "'")
