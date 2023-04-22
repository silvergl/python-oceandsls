# Generated from allstar.g4 by ANTLR 4.11.1
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
        4,1,6,20,2,0,7,0,2,1,7,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,3,0,12,8,0,
        1,1,1,1,1,1,1,1,3,1,18,8,1,1,1,0,0,2,0,2,0,0,19,0,11,1,0,0,0,2,17,
        1,0,0,0,4,5,3,2,1,0,5,6,5,1,0,0,6,12,1,0,0,0,7,8,5,4,0,0,8,9,5,2,
        0,0,9,10,5,3,0,0,10,12,5,1,0,0,11,4,1,0,0,0,11,7,1,0,0,0,12,1,1,
        0,0,0,13,14,5,4,0,0,14,15,5,2,0,0,15,18,5,3,0,0,16,18,5,6,0,0,17,
        13,1,0,0,0,17,16,1,0,0,0,18,3,1,0,0,0,2,11,17
    ]

class allstarParser ( Parser ):

    grammarFileName = "allstar.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ "<INVALID>", "';'", "'('", "')'" ]

    symbolicNames = [ "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                      "ID", "NUM", "INT" ]

    RULE_stat = 0
    RULE_expr = 1

    ruleNames =  [ "stat", "expr" ]

    EOF = Token.EOF
    T__0=1
    T__1=2
    T__2=3
    ID=4
    NUM=5
    INT=6

    def __init__(self, input:TokenStream, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.11.1")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None




    class StatContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def expr(self):
            return self.getTypedRuleContext(allstarParser.ExprContext,0)


        def ID(self):
            return self.getToken(allstarParser.ID, 0)

        def getRuleIndex(self):
            return allstarParser.RULE_stat

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterStat" ):
                listener.enterStat(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitStat" ):
                listener.exitStat(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitStat" ):
                return visitor.visitStat(self)
            else:
                return visitor.visitChildren(self)




    def stat(self):

        localctx = allstarParser.StatContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_stat)
        try:
            self.state = 11
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,0,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 4
                self.expr()
                self.state = 5
                self.match(allstarParser.T__0)
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 7
                self.match(allstarParser.ID)
                self.state = 8
                self.match(allstarParser.T__1)
                self.state = 9
                self.match(allstarParser.T__2)
                self.state = 10
                self.match(allstarParser.T__0)
                pass


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class ExprContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def ID(self):
            return self.getToken(allstarParser.ID, 0)

        def INT(self):
            return self.getToken(allstarParser.INT, 0)

        def getRuleIndex(self):
            return allstarParser.RULE_expr

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterExpr" ):
                listener.enterExpr(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitExpr" ):
                listener.exitExpr(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitExpr" ):
                return visitor.visitExpr(self)
            else:
                return visitor.visitChildren(self)




    def expr(self):

        localctx = allstarParser.ExprContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_expr)
        try:
            self.state = 17
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [4]:
                self.enterOuterAlt(localctx, 1)
                self.state = 13
                self.match(allstarParser.ID)
                self.state = 14
                self.match(allstarParser.T__1)
                self.state = 15
                self.match(allstarParser.T__2)
                pass
            elif token in [6]:
                self.enterOuterAlt(localctx, 2)
                self.state = 16
                self.match(allstarParser.INT)
                pass
            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx





