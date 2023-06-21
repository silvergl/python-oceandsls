"""Verbose Error Listener for ANTLR"""
__author__ = 'sgu'

import sys

from antlr4.Recognizer import Recognizer
from antlr4.Token import Token
# antlr
from antlr4.error.ErrorListener import ErrorListener
from antlr4.error.Errors import RecognitionException


class VerboseListener( ErrorListener ):
    def __init__( self ):
        self._symbol = ''
        super( ).__init__( )

    @property
    def symbol( self ):
        return self._symbol

    def test( self, msg: str = "bar" ):
        print( msg )

    def syntaxError( self, recognizer: Recognizer, offendingSymbol: Token, line: int, column: int, msg: str, e: RecognitionException = None ):
        stack = recognizer.getRuleInvocationStack( )
        stack.reverse( )

        self._symbol = offendingSymbol.text

        print( "ERROR: when parsing line %d column %d: %s\n" % (line, column, msg), file = sys.stderr )
        # Alternative
        # raise Exception("ERROR: when parsing line %d column %d: %s\n" % (line, column, msg))

        print( "rule stack: ", str( stack ), file = sys.stderr )
        print( "line", line, ":", column, "at", offendingSymbol, ":", msg, file = sys.stderr )
