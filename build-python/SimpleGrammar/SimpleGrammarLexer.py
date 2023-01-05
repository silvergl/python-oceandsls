# Generated from C:/Users/Sven/workspace/python/antlr4-python/grammars/dev\SimpleGrammar.g4 by ANTLR 4.11.1
from antlr4 import *
from io import StringIO
import sys
if sys.version_info[1] > 5:
    from typing import TextIO
else:
    from typing.io import TextIO


def serializedATN():
    return [
        4,0,5,35,6,-1,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,1,0,1,0,1,
        0,1,0,1,1,1,1,1,1,1,1,1,2,1,2,1,2,1,2,1,3,3,3,25,8,3,1,3,1,3,1,4,
        4,4,30,8,4,11,4,12,4,31,1,4,1,4,0,0,5,1,1,3,2,5,3,7,4,9,5,1,0,9,
        1,0,102,102,1,0,111,111,1,0,98,98,1,0,97,97,1,0,114,114,1,0,115,
        115,1,0,103,103,1,0,117,117,2,0,9,9,32,32,36,0,1,1,0,0,0,0,3,1,0,
        0,0,0,5,1,0,0,0,0,7,1,0,0,0,0,9,1,0,0,0,1,11,1,0,0,0,3,15,1,0,0,
        0,5,19,1,0,0,0,7,24,1,0,0,0,9,29,1,0,0,0,11,12,7,0,0,0,12,13,7,1,
        0,0,13,14,7,1,0,0,14,2,1,0,0,0,15,16,7,2,0,0,16,17,7,3,0,0,17,18,
        7,4,0,0,18,4,1,0,0,0,19,20,7,5,0,0,20,21,7,6,0,0,21,22,7,7,0,0,22,
        6,1,0,0,0,23,25,5,13,0,0,24,23,1,0,0,0,24,25,1,0,0,0,25,26,1,0,0,
        0,26,27,5,10,0,0,27,8,1,0,0,0,28,30,7,8,0,0,29,28,1,0,0,0,30,31,
        1,0,0,0,31,29,1,0,0,0,31,32,1,0,0,0,32,33,1,0,0,0,33,34,6,4,0,0,
        34,10,1,0,0,0,3,0,24,31,1,0,1,0
    ]

class SimpleGrammarLexer(Lexer):

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    FOO = 1
    BAR = 2
    SGU = 3
    NEWLINE = 4
    WS = 5

    channelNames = [ u"DEFAULT_TOKEN_CHANNEL", u"HIDDEN" ]

    modeNames = [ "DEFAULT_MODE" ]

    literalNames = [ "<INVALID>",
 ]

    symbolicNames = [ "<INVALID>",
            "FOO", "BAR", "SGU", "NEWLINE", "WS" ]

    ruleNames = [ "FOO", "BAR", "SGU", "NEWLINE", "WS" ]

    grammarFileName = "SimpleGrammar.g4"

    def __init__(self, input=None, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.11.1")
        self._interp = LexerATNSimulator(self, self.atn, self.decisionsToDFA, PredictionContextCache())
        self._actions = None
        self._predicates = None


