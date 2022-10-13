# Generated from TestGrammar.g4 by ANTLR 4.11.1
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
        4,1,12,60,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,1,0,5,0,10,8,0,10,0,12,
        0,13,9,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,1,24,8,1,1,2,1,2,
        1,2,1,2,3,2,30,8,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,3,2,39,8,2,1,2,1,
        2,1,2,1,2,1,2,1,2,5,2,47,8,2,10,2,12,2,50,9,2,1,3,1,3,1,3,5,3,55,
        8,3,10,3,12,3,58,9,3,1,3,0,1,4,4,0,2,4,6,0,2,1,0,1,2,1,0,3,4,65,
        0,11,1,0,0,0,2,23,1,0,0,0,4,38,1,0,0,0,6,51,1,0,0,0,8,10,3,2,1,0,
        9,8,1,0,0,0,10,13,1,0,0,0,11,9,1,0,0,0,11,12,1,0,0,0,12,1,1,0,0,
        0,13,11,1,0,0,0,14,15,3,4,2,0,15,16,5,12,0,0,16,24,1,0,0,0,17,18,
        5,10,0,0,18,19,5,7,0,0,19,20,3,4,2,0,20,21,5,12,0,0,21,24,1,0,0,
        0,22,24,5,12,0,0,23,14,1,0,0,0,23,17,1,0,0,0,23,22,1,0,0,0,24,3,
        1,0,0,0,25,26,6,2,-1,0,26,27,5,10,0,0,27,29,5,5,0,0,28,30,3,6,3,
        0,29,28,1,0,0,0,29,30,1,0,0,0,30,31,1,0,0,0,31,39,5,6,0,0,32,33,
        5,5,0,0,33,34,3,4,2,0,34,35,5,6,0,0,35,39,1,0,0,0,36,39,5,11,0,0,
        37,39,5,10,0,0,38,25,1,0,0,0,38,32,1,0,0,0,38,36,1,0,0,0,38,37,1,
        0,0,0,39,48,1,0,0,0,40,41,10,6,0,0,41,42,7,0,0,0,42,47,3,4,2,7,43,
        44,10,5,0,0,44,45,7,1,0,0,45,47,3,4,2,6,46,40,1,0,0,0,46,43,1,0,
        0,0,47,50,1,0,0,0,48,46,1,0,0,0,48,49,1,0,0,0,49,5,1,0,0,0,50,48,
        1,0,0,0,51,56,3,4,2,0,52,53,5,8,0,0,53,55,3,4,2,0,54,52,1,0,0,0,
        55,58,1,0,0,0,56,54,1,0,0,0,56,57,1,0,0,0,57,7,1,0,0,0,58,56,1,0,
        0,0,7,11,23,29,38,46,48,56
    ]

class TestGrammarParser ( Parser ):

    grammarFileName = "TestGrammar.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ "<INVALID>", "'*'", "'/'", "'+'", "'-'", "'('", "')'", 
                     "'='", "','" ]

    symbolicNames = [ "<INVALID>", "OP_MUL", "OP_DIV", "OP_ADD", "OP_SUB", 
                      "PAR_L", "PAR_R", "EQUAL", "SEP", "WS", "ID", "NUM", 
                      "NEWLINE" ]

    RULE_prog = 0
    RULE_stat = 1
    RULE_expr = 2
    RULE_exprList = 3

    ruleNames =  [ "prog", "stat", "expr", "exprList" ]

    EOF = Token.EOF
    OP_MUL=1
    OP_DIV=2
    OP_ADD=3
    OP_SUB=4
    PAR_L=5
    PAR_R=6
    EQUAL=7
    SEP=8
    WS=9
    ID=10
    NUM=11
    NEWLINE=12

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
            return TestGrammarParser.RULE_prog

     
        def copyFrom(self, ctx:ParserRuleContext):
            super().copyFrom(ctx)



    class StartProgContext(ProgContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a TestGrammarParser.ProgContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def stat(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(TestGrammarParser.StatContext)
            else:
                return self.getTypedRuleContext(TestGrammarParser.StatContext,i)


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

        localctx = TestGrammarParser.ProgContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_prog)
        self._la = 0 # Token type
        try:
            localctx = TestGrammarParser.StartProgContext(self, localctx)
            self.enterOuterAlt(localctx, 1)
            self.state = 11
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while ((_la) & ~0x3f) == 0 and ((1 << _la) & 7200) != 0:
                self.state = 8
                self.stat()
                self.state = 13
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
            return TestGrammarParser.RULE_stat

     
        def copyFrom(self, ctx:ParserRuleContext):
            super().copyFrom(ctx)



    class PrintExprStatContext(StatContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a TestGrammarParser.StatContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def expr(self):
            return self.getTypedRuleContext(TestGrammarParser.ExprContext,0)

        def NEWLINE(self):
            return self.getToken(TestGrammarParser.NEWLINE, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterPrintExprStat" ):
                listener.enterPrintExprStat(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitPrintExprStat" ):
                listener.exitPrintExprStat(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitPrintExprStat" ):
                return visitor.visitPrintExprStat(self)
            else:
                return visitor.visitChildren(self)


    class BlankStatContext(StatContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a TestGrammarParser.StatContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def NEWLINE(self):
            return self.getToken(TestGrammarParser.NEWLINE, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterBlankStat" ):
                listener.enterBlankStat(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitBlankStat" ):
                listener.exitBlankStat(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitBlankStat" ):
                return visitor.visitBlankStat(self)
            else:
                return visitor.visitChildren(self)


    class AssignStatContext(StatContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a TestGrammarParser.StatContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def ID(self):
            return self.getToken(TestGrammarParser.ID, 0)
        def EQUAL(self):
            return self.getToken(TestGrammarParser.EQUAL, 0)
        def expr(self):
            return self.getTypedRuleContext(TestGrammarParser.ExprContext,0)

        def NEWLINE(self):
            return self.getToken(TestGrammarParser.NEWLINE, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterAssignStat" ):
                listener.enterAssignStat(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitAssignStat" ):
                listener.exitAssignStat(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitAssignStat" ):
                return visitor.visitAssignStat(self)
            else:
                return visitor.visitChildren(self)



    def stat(self):

        localctx = TestGrammarParser.StatContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_stat)
        try:
            self.state = 23
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,1,self._ctx)
            if la_ == 1:
                localctx = TestGrammarParser.PrintExprStatContext(self, localctx)
                self.enterOuterAlt(localctx, 1)
                self.state = 14
                self.expr(0)
                self.state = 15
                self.match(TestGrammarParser.NEWLINE)
                pass

            elif la_ == 2:
                localctx = TestGrammarParser.AssignStatContext(self, localctx)
                self.enterOuterAlt(localctx, 2)
                self.state = 17
                self.match(TestGrammarParser.ID)
                self.state = 18
                self.match(TestGrammarParser.EQUAL)
                self.state = 19
                self.expr(0)
                self.state = 20
                self.match(TestGrammarParser.NEWLINE)
                pass

            elif la_ == 3:
                localctx = TestGrammarParser.BlankStatContext(self, localctx)
                self.enterOuterAlt(localctx, 3)
                self.state = 22
                self.match(TestGrammarParser.NEWLINE)
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


        def getRuleIndex(self):
            return TestGrammarParser.RULE_expr

     
        def copyFrom(self, ctx:ParserRuleContext):
            super().copyFrom(ctx)


    class FuncExprContext(ExprContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a TestGrammarParser.ExprContext
            super().__init__(parser)
            self.func = None # Token
            self.copyFrom(ctx)

        def PAR_L(self):
            return self.getToken(TestGrammarParser.PAR_L, 0)
        def PAR_R(self):
            return self.getToken(TestGrammarParser.PAR_R, 0)
        def ID(self):
            return self.getToken(TestGrammarParser.ID, 0)
        def exprList(self):
            return self.getTypedRuleContext(TestGrammarParser.ExprListContext,0)


        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterFuncExpr" ):
                listener.enterFuncExpr(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitFuncExpr" ):
                listener.exitFuncExpr(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitFuncExpr" ):
                return visitor.visitFuncExpr(self)
            else:
                return visitor.visitChildren(self)


    class AddSubExprContext(ExprContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a TestGrammarParser.ExprContext
            super().__init__(parser)
            self.left = None # ExprContext
            self.op = None # Token
            self.right = None # ExprContext
            self.copyFrom(ctx)

        def expr(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(TestGrammarParser.ExprContext)
            else:
                return self.getTypedRuleContext(TestGrammarParser.ExprContext,i)

        def OP_ADD(self):
            return self.getToken(TestGrammarParser.OP_ADD, 0)
        def OP_SUB(self):
            return self.getToken(TestGrammarParser.OP_SUB, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterAddSubExpr" ):
                listener.enterAddSubExpr(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitAddSubExpr" ):
                listener.exitAddSubExpr(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitAddSubExpr" ):
                return visitor.visitAddSubExpr(self)
            else:
                return visitor.visitChildren(self)


    class NumberExprContext(ExprContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a TestGrammarParser.ExprContext
            super().__init__(parser)
            self.value = None # Token
            self.copyFrom(ctx)

        def NUM(self):
            return self.getToken(TestGrammarParser.NUM, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterNumberExpr" ):
                listener.enterNumberExpr(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitNumberExpr" ):
                listener.exitNumberExpr(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitNumberExpr" ):
                return visitor.visitNumberExpr(self)
            else:
                return visitor.visitChildren(self)


    class ParensExprContext(ExprContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a TestGrammarParser.ExprContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def PAR_L(self):
            return self.getToken(TestGrammarParser.PAR_L, 0)
        def expr(self):
            return self.getTypedRuleContext(TestGrammarParser.ExprContext,0)

        def PAR_R(self):
            return self.getToken(TestGrammarParser.PAR_R, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterParensExpr" ):
                listener.enterParensExpr(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitParensExpr" ):
                listener.exitParensExpr(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitParensExpr" ):
                return visitor.visitParensExpr(self)
            else:
                return visitor.visitChildren(self)


    class MulDivExprContext(ExprContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a TestGrammarParser.ExprContext
            super().__init__(parser)
            self.left = None # ExprContext
            self.op = None # Token
            self.right = None # ExprContext
            self.copyFrom(ctx)

        def expr(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(TestGrammarParser.ExprContext)
            else:
                return self.getTypedRuleContext(TestGrammarParser.ExprContext,i)

        def OP_MUL(self):
            return self.getToken(TestGrammarParser.OP_MUL, 0)
        def OP_DIV(self):
            return self.getToken(TestGrammarParser.OP_DIV, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterMulDivExpr" ):
                listener.enterMulDivExpr(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitMulDivExpr" ):
                listener.exitMulDivExpr(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitMulDivExpr" ):
                return visitor.visitMulDivExpr(self)
            else:
                return visitor.visitChildren(self)


    class IdExprContext(ExprContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a TestGrammarParser.ExprContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def ID(self):
            return self.getToken(TestGrammarParser.ID, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterIdExpr" ):
                listener.enterIdExpr(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitIdExpr" ):
                listener.exitIdExpr(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitIdExpr" ):
                return visitor.visitIdExpr(self)
            else:
                return visitor.visitChildren(self)



    def expr(self, _p:int=0):
        _parentctx = self._ctx
        _parentState = self.state
        localctx = TestGrammarParser.ExprContext(self, self._ctx, _parentState)
        _prevctx = localctx
        _startState = 4
        self.enterRecursionRule(localctx, 4, self.RULE_expr, _p)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 38
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,3,self._ctx)
            if la_ == 1:
                localctx = TestGrammarParser.FuncExprContext(self, localctx)
                self._ctx = localctx
                _prevctx = localctx

                self.state = 26
                localctx.func = self.match(TestGrammarParser.ID)
                self.state = 27
                self.match(TestGrammarParser.PAR_L)
                self.state = 29
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if ((_la) & ~0x3f) == 0 and ((1 << _la) & 3104) != 0:
                    self.state = 28
                    self.exprList()


                self.state = 31
                self.match(TestGrammarParser.PAR_R)
                pass

            elif la_ == 2:
                localctx = TestGrammarParser.ParensExprContext(self, localctx)
                self._ctx = localctx
                _prevctx = localctx
                self.state = 32
                self.match(TestGrammarParser.PAR_L)
                self.state = 33
                self.expr(0)
                self.state = 34
                self.match(TestGrammarParser.PAR_R)
                pass

            elif la_ == 3:
                localctx = TestGrammarParser.NumberExprContext(self, localctx)
                self._ctx = localctx
                _prevctx = localctx
                self.state = 36
                localctx.value = self.match(TestGrammarParser.NUM)
                pass

            elif la_ == 4:
                localctx = TestGrammarParser.IdExprContext(self, localctx)
                self._ctx = localctx
                _prevctx = localctx
                self.state = 37
                self.match(TestGrammarParser.ID)
                pass


            self._ctx.stop = self._input.LT(-1)
            self.state = 48
            self._errHandler.sync(self)
            _alt = self._interp.adaptivePredict(self._input,5,self._ctx)
            while _alt!=2 and _alt!=ATN.INVALID_ALT_NUMBER:
                if _alt==1:
                    if self._parseListeners is not None:
                        self.triggerExitRuleEvent()
                    _prevctx = localctx
                    self.state = 46
                    self._errHandler.sync(self)
                    la_ = self._interp.adaptivePredict(self._input,4,self._ctx)
                    if la_ == 1:
                        localctx = TestGrammarParser.MulDivExprContext(self, TestGrammarParser.ExprContext(self, _parentctx, _parentState))
                        localctx.left = _prevctx
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_expr)
                        self.state = 40
                        if not self.precpred(self._ctx, 6):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 6)")
                        self.state = 41
                        localctx.op = self._input.LT(1)
                        _la = self._input.LA(1)
                        if not(_la==1 or _la==2):
                            localctx.op = self._errHandler.recoverInline(self)
                        else:
                            self._errHandler.reportMatch(self)
                            self.consume()
                        self.state = 42
                        localctx.right = self.expr(7)
                        pass

                    elif la_ == 2:
                        localctx = TestGrammarParser.AddSubExprContext(self, TestGrammarParser.ExprContext(self, _parentctx, _parentState))
                        localctx.left = _prevctx
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_expr)
                        self.state = 43
                        if not self.precpred(self._ctx, 5):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 5)")
                        self.state = 44
                        localctx.op = self._input.LT(1)
                        _la = self._input.LA(1)
                        if not(_la==3 or _la==4):
                            localctx.op = self._errHandler.recoverInline(self)
                        else:
                            self._errHandler.reportMatch(self)
                            self.consume()
                        self.state = 45
                        localctx.right = self.expr(6)
                        pass

             
                self.state = 50
                self._errHandler.sync(self)
                _alt = self._interp.adaptivePredict(self._input,5,self._ctx)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.unrollRecursionContexts(_parentctx)
        return localctx


    class ExprListContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser


        def getRuleIndex(self):
            return TestGrammarParser.RULE_exprList

     
        def copyFrom(self, ctx:ParserRuleContext):
            super().copyFrom(ctx)



    class ArgListContext(ExprListContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a TestGrammarParser.ExprListContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def expr(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(TestGrammarParser.ExprContext)
            else:
                return self.getTypedRuleContext(TestGrammarParser.ExprContext,i)

        def SEP(self, i:int=None):
            if i is None:
                return self.getTokens(TestGrammarParser.SEP)
            else:
                return self.getToken(TestGrammarParser.SEP, i)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterArgList" ):
                listener.enterArgList(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitArgList" ):
                listener.exitArgList(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitArgList" ):
                return visitor.visitArgList(self)
            else:
                return visitor.visitChildren(self)



    def exprList(self):

        localctx = TestGrammarParser.ExprListContext(self, self._ctx, self.state)
        self.enterRule(localctx, 6, self.RULE_exprList)
        self._la = 0 # Token type
        try:
            localctx = TestGrammarParser.ArgListContext(self, localctx)
            self.enterOuterAlt(localctx, 1)
            self.state = 51
            self.expr(0)
            self.state = 56
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==8:
                self.state = 52
                self.match(TestGrammarParser.SEP)
                self.state = 53
                self.expr(0)
                self.state = 58
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx



    def sempred(self, localctx:RuleContext, ruleIndex:int, predIndex:int):
        if self._predicates == None:
            self._predicates = dict()
        self._predicates[2] = self.expr_sempred
        pred = self._predicates.get(ruleIndex, None)
        if pred is None:
            raise Exception("No predicate with index:" + str(ruleIndex))
        else:
            return pred(localctx, predIndex)

    def expr_sempred(self, localctx:ExprContext, predIndex:int):
            if predIndex == 0:
                return self.precpred(self._ctx, 6)
         

            if predIndex == 1:
                return self.precpred(self._ctx, 5)
         




