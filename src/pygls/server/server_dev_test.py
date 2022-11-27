#!/usr/bin/env python3
__author__ = 'sgu'

import sys
sys.path.insert( 0, '../../../../build-python' )

from antlr4 import *
from TestGrammar.TestGrammarLexer import TestGrammarLexer, ParserRuleContext
from TestGrammar.TestGrammarParser import TestGrammarParser
from TestGrammar.TestGrammarVisitor import TestGrammarVisitor
from antlr4.error.ErrorListener import ErrorListener
from antlr4.Recognizer import Recognizer

# from typing import List, Union
import logging
# from pygls.lsp.types import (Diagnostic, Range, Position)
# def user_repr(error: Union[UnexpectedToken]):
#     if isinstance(error, UnexpectedToken):
#         expected = ', '.join(error.accepts or error.expected)
#         return f"Unexpected token {str(error.token)!r}. Expected one of:\n{{{expected}}}"
#     else:
#         return str(error)
#
#
# def get_diagnostics(doctext: str):
#     diagnostics: List[Diagnostic] = []
#
#     def on_error(e: UnexpectedToken):
#         diagnostics.append(Diagnostic(
#             Range(
#                 Position(e.line - 1, e.column - 1),
#                 Position(e.line - 1, e.column)
#             ),
#             user_repr(e)))
#         return True
#
#     try:
#         lark_grammar_parser.parse(doctext, on_error=on_error)
#     except Exception:
#         logging.exception("parser raised exception")
#     return diagnostics

class VerboseListener(ErrorListener):
    def __init__(self):
        super().__init__()

    def test(self=None, msg:str="bar"):
        print(msg)

    def syntaxError(self, recognizer:Recognizer, offendingSymbol:Token, line:int, column:int, msg:str, e:RecognitionException = None):
        print('ERROR: when parsing line %d column %d: %s\n' % (line, column, msg), file=sys.stderr)
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
    lexer = TestGrammarLexer(input_stream)
    lexer.removeErrorListeners()
    lexer.addErrorListener(error_listener)

    tokenStream = CommonTokenStream(lexer)

    parser = TestGrammarParser(tokenStream)
    parser.removeErrorListeners()
    parser.addErrorListener(error_listener)

    # launch parser by invoking rule 'prog'
    try:
        ast = parser.prog()
    except SyntaxError as syn_inst:
        logging.exception("parser raised syntax exception")
    except Exception as inst:
        # print(type(inst))    # the exception instance
        # print(inst.args)     # arguments stored in .args
        # print(inst)          # __str__ allows args to be printed directly,
        # but may be overridden in exception subclasses
        # x, y = inst.args     # unpack args
        # print('x =', x)
        # print('y =', y)

        logging.exception("parser raised exception")
        # logging.exception("the exception instance '" + str(type(inst)) + "'")
        # logging.exception("arguments stored in .args '" + str(inst.args) + "'")
        # logging.exception("__str__ allows args to be printed directly '" + str(inst) + "'")


