# Generated from C:/Users/Sven/workspace/python/antlr4-python/grammars/dev\SimpleGrammar.g4 by ANTLR 4.11.1
# encoding: utf-8
from antlr4 import *
from io import StringIO
import sys
if sys.version_info[1] > 5:
	from typing import TextIO
else:
	from typing.io import TextIO

def serializedATN():
    return [
        4,1,5,16,2,0,7,0,2,1,7,1,1,0,5,0,6,8,0,10,0,12,0,9,9,0,1,1,1,1,1,
        1,1,1,1,1,1,1,0,0,2,0,2,0,0,14,0,7,1,0,0,0,2,10,1,0,0,0,4,6,3,2,
        1,0,5,4,1,0,0,0,6,9,1,0,0,0,7,5,1,0,0,0,7,8,1,0,0,0,8,1,1,0,0,0,
        9,7,1,0,0,0,10,11,5,1,0,0,11,12,5,2,0,0,12,13,5,1,0,0,13,14,5,4,
        0,0,14,3,1,0,0,0,1,7
    ]

class SimpleGrammarParser ( Parser ):

    grammarFileName = "SimpleGrammar.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [  ]

    symbolicNames = [ "<INVALID>", "FOO", "BAR", "SGU", "NEWLINE", "WS" ]

    RULE_prog = 0
    RULE_stat = 1

    ruleNames =  [ "prog", "stat" ]

    EOF = Token.EOF
    FOO=1
    BAR=2
    SGU=3
    NEWLINE=4
    WS=5

    def __init__(self, input:TokenStream, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.11.1")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None




    class ProgContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser


        def getRuleIndex(self):
            return SimpleGrammarParser.RULE_prog

     
        def copyFrom(self, ctx:ParserRuleContext):
            super().copyFrom(ctx)



    class StartProgContext(ProgContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a SimpleGrammarParser.ProgContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def stat(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SimpleGrammarParser.StatContext)
            else:
                return self.getTypedRuleContext(SimpleGrammarParser.StatContext,i)


        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterStartProg" ):
                listener.enterStartProg(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitStartProg" ):
                listener.exitStartProg(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitStartProg" ):
                return visitor.visitStartProg(self)
            else:
                return visitor.visitChildren(self)



    def prog(self):

        localctx = SimpleGrammarParser.ProgContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_prog)
        self._la = 0 # Token type
        try:
            localctx = SimpleGrammarParser.StartProgContext(self, localctx)
            self.enterOuterAlt(localctx, 1)
            self.state = 7
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==1:
                self.state = 4
                self.stat()
                self.state = 9
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class StatContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser


        def getRuleIndex(self):
            return SimpleGrammarParser.RULE_stat

     
        def copyFrom(self, ctx:ParserRuleContext):
            super().copyFrom(ctx)



    class StatLabelContext(StatContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a SimpleGrammarParser.StatContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def FOO(self, i:int=None):
            if i is None:
                return self.getTokens(SimpleGrammarParser.FOO)
            else:
                return self.getToken(SimpleGrammarParser.FOO, i)
        def BAR(self):
            return self.getToken(SimpleGrammarParser.BAR, 0)
        def NEWLINE(self):
            return self.getToken(SimpleGrammarParser.NEWLINE, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterStatLabel" ):
                listener.enterStatLabel(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitStatLabel" ):
                listener.exitStatLabel(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitStatLabel" ):
                return visitor.visitStatLabel(self)
            else:
                return visitor.visitChildren(self)



    def stat(self):

        localctx = SimpleGrammarParser.StatContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_stat)
        try:
            localctx = SimpleGrammarParser.StatLabelContext(self, localctx)
            self.enterOuterAlt(localctx, 1)
            self.state = 10
            self.match(SimpleGrammarParser.FOO)
            self.state = 11
            self.match(SimpleGrammarParser.BAR)
            self.state = 12
            self.match(SimpleGrammarParser.FOO)
            self.state = 13
            self.match(SimpleGrammarParser.NEWLINE)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx





