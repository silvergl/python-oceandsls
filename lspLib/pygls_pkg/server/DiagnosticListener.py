#!/usr/bin/env python3
__author__ = 'sgu'

# debug logging
import logging
logging.basicConfig( level = logging.DEBUG )
#antlr4
from antlr4.error.ErrorListener import ErrorListener
from antlr4.Recognizer import Recognizer
from antlr4.Token import Token
from antlr4.error.Errors import RecognitionException
# pygls
from typing import List
# Deprecated from 0.13
# from pygls.lsp.types import (Diagnostic, Range, Position)
# Migrating to pygls v1.0
# https://pygls.readthedocs.io/en/latest/pages/migrating-to-v1.html
from lsprotocol.types import (Diagnostic, Range, Position)

class DiagnosticListener( ErrorListener ):
    def __init__(self):
        self.diagnostics: List[Diagnostic] = []
        super().__init__()

    logger = logging.getLogger( __name__ )
    # Enables printing ATN state info to terminal.
    showDebugOutput: bool = False

    # reset the listener's state
    def reset(self):
        self.diagnostics = []

    def syntaxError(self, recognizer:Recognizer, offendingSymbol:Token, line:int, column:int, msg:str, e:RecognitionException = None):
        self.diagnostics.append(
            Diagnostic(
                range = Range(
                    start= Position(
                        line = line - 1,
                        character = column - 1),
                    end = Position(
                        line = line - 1,
                        character = column)
                ),
                message = msg
            )
        )

        if self.showDebugOutput and self.logger.isEnabledFor( logging.DEBUG ):
            self.logger.debug( 'ERROR: when parsing line %d column %d: %s\n' % (line, column, msg))
        # dev alternatives
        # print('ERROR: when parsing line %d column %d: %s\n' % (line, column, msg), file=sys.stderr)
        # raise Exception("ERROR: when parsing line %d column %d: %s\n" % (line, column, msg))