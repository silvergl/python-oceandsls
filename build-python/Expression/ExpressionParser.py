# Generated from Expression.g4 by ANTLR 4.10
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
        4,1,20,91,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,5,2,6,7,
        6,2,7,7,7,2,8,7,8,2,9,7,9,2,10,7,10,2,11,7,11,2,12,7,12,2,13,7,13,
        1,0,1,0,1,0,1,0,1,0,3,0,34,8,0,1,1,1,1,1,2,1,2,1,2,1,2,1,2,3,2,43,
        8,2,1,3,1,3,1,4,1,4,1,4,1,4,3,4,51,8,4,1,5,1,5,1,6,1,6,1,6,1,6,3,
        6,59,8,6,1,7,1,7,1,7,1,7,1,8,1,8,1,8,1,8,5,8,69,8,8,10,8,12,8,72,
        9,8,3,8,74,8,8,1,8,1,8,1,9,1,9,1,9,3,9,81,8,9,1,10,1,10,1,11,1,11,
        1,12,1,12,1,13,1,13,1,13,0,0,14,0,2,4,6,8,10,12,14,16,18,20,22,24,
        26,0,2,1,0,1,2,1,0,3,5,87,0,33,1,0,0,0,2,35,1,0,0,0,4,42,1,0,0,0,
        6,44,1,0,0,0,8,50,1,0,0,0,10,52,1,0,0,0,12,58,1,0,0,0,14,60,1,0,
        0,0,16,64,1,0,0,0,18,77,1,0,0,0,20,82,1,0,0,0,22,84,1,0,0,0,24,86,
        1,0,0,0,26,88,1,0,0,0,28,29,3,4,2,0,29,30,3,2,1,0,30,31,3,0,0,0,
        31,34,1,0,0,0,32,34,3,4,2,0,33,28,1,0,0,0,33,32,1,0,0,0,34,1,1,0,
        0,0,35,36,7,0,0,0,36,3,1,0,0,0,37,38,3,8,4,0,38,39,3,6,3,0,39,40,
        3,4,2,0,40,43,1,0,0,0,41,43,3,8,4,0,42,37,1,0,0,0,42,41,1,0,0,0,
        43,5,1,0,0,0,44,45,7,1,0,0,45,7,1,0,0,0,46,51,3,14,7,0,47,51,3,18,
        9,0,48,51,3,16,8,0,49,51,3,10,5,0,50,46,1,0,0,0,50,47,1,0,0,0,50,
        48,1,0,0,0,50,49,1,0,0,0,51,9,1,0,0,0,52,53,3,12,6,0,53,11,1,0,0,
        0,54,59,3,20,10,0,55,59,3,22,11,0,56,59,3,24,12,0,57,59,3,26,13,
        0,58,54,1,0,0,0,58,55,1,0,0,0,58,56,1,0,0,0,58,57,1,0,0,0,59,13,
        1,0,0,0,60,61,5,6,0,0,61,62,3,0,0,0,62,63,5,7,0,0,63,15,1,0,0,0,
        64,73,5,8,0,0,65,70,3,0,0,0,66,67,5,9,0,0,67,69,3,0,0,0,68,66,1,
        0,0,0,69,72,1,0,0,0,70,68,1,0,0,0,70,71,1,0,0,0,71,74,1,0,0,0,72,
        70,1,0,0,0,73,65,1,0,0,0,73,74,1,0,0,0,74,75,1,0,0,0,75,76,5,10,
        0,0,76,17,1,0,0,0,77,80,5,15,0,0,78,79,5,11,0,0,79,81,5,15,0,0,80,
        78,1,0,0,0,80,81,1,0,0,0,81,19,1,0,0,0,82,83,5,17,0,0,83,21,1,0,
        0,0,84,85,5,12,0,0,85,23,1,0,0,0,86,87,5,13,0,0,87,25,1,0,0,0,88,
        89,5,14,0,0,89,27,1,0,0,0,7,33,42,50,58,70,73,80
    ]

class ExpressionParser ( Parser ):

    grammarFileName = "Expression.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ "<INVALID>", "'+'", "'-'", "'*'", "'/'", "'%'", "'('", 
                     "')'", "'['", "','", "']'", "'.'" ]

    symbolicNames = [ "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                      "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                      "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                      "ELONG", "EDOUBLE", "EBoolean", "ID", "INT", "STRING", 
                      "ML_COMMENT", "SL_COMMENT", "ANY_OTHER" ]

    RULE_arithmeticExpression = 0
    RULE_eAdditionOperator = 1
    RULE_multiplicationExpression = 2
    RULE_eMultiplicationOperator = 3
    RULE_valueExpression = 4
    RULE_literalExpression = 5
    RULE_literal = 6
    RULE_parenthesisExpression = 7
    RULE_arrayExpression = 8
    RULE_namedElementReference = 9
    RULE_stringValue = 10
    RULE_longValue = 11
    RULE_doubleValue = 12
    RULE_booleanValue = 13

    ruleNames =  [ "arithmeticExpression", "eAdditionOperator", "multiplicationExpression", 
                   "eMultiplicationOperator", "valueExpression", "literalExpression", 
                   "literal", "parenthesisExpression", "arrayExpression", 
                   "namedElementReference", "stringValue", "longValue", 
                   "doubleValue", "booleanValue" ]

    EOF = Token.EOF
    T__0=1
    T__1=2
    T__2=3
    T__3=4
    T__4=5
    T__5=6
    T__6=7
    T__7=8
    T__8=9
    T__9=10
    T__10=11
    ELONG=12
    EDOUBLE=13
    EBoolean=14
    ID=15
    INT=16
    STRING=17
    ML_COMMENT=18
    SL_COMMENT=19
    ANY_OTHER=20

    def __init__(self, input:TokenStream, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.10")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None




    class ArithmeticExpressionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.left = None # MultiplicationExpressionContext
            self.op = None # EAdditionOperatorContext
            self.right = None # ArithmeticExpressionContext

        def multiplicationExpression(self):
            return self.getTypedRuleContext(ExpressionParser.MultiplicationExpressionContext,0)


        def eAdditionOperator(self):
            return self.getTypedRuleContext(ExpressionParser.EAdditionOperatorContext,0)


        def arithmeticExpression(self):
            return self.getTypedRuleContext(ExpressionParser.ArithmeticExpressionContext,0)


        def getRuleIndex(self):
            return ExpressionParser.RULE_arithmeticExpression

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterArithmeticExpression" ):
                listener.enterArithmeticExpression(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitArithmeticExpression" ):
                listener.exitArithmeticExpression(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitArithmeticExpression" ):
                return visitor.visitArithmeticExpression(self)
            else:
                return visitor.visitChildren(self)




    def arithmeticExpression(self):

        localctx = ExpressionParser.ArithmeticExpressionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_arithmeticExpression)
        try:
            self.state = 33
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,0,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 28
                localctx.left = self.multiplicationExpression()
                self.state = 29
                localctx.op = self.eAdditionOperator()
                self.state = 30
                localctx.right = self.arithmeticExpression()
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 32
                self.multiplicationExpression()
                pass


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class EAdditionOperatorContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser


        def getRuleIndex(self):
            return ExpressionParser.RULE_eAdditionOperator

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterEAdditionOperator" ):
                listener.enterEAdditionOperator(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitEAdditionOperator" ):
                listener.exitEAdditionOperator(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitEAdditionOperator" ):
                return visitor.visitEAdditionOperator(self)
            else:
                return visitor.visitChildren(self)




    def eAdditionOperator(self):

        localctx = ExpressionParser.EAdditionOperatorContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_eAdditionOperator)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 35
            _la = self._input.LA(1)
            if not(_la==ExpressionParser.T__0 or _la==ExpressionParser.T__1):
                self._errHandler.recoverInline(self)
            else:
                self._errHandler.reportMatch(self)
                self.consume()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class MultiplicationExpressionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.left = None # ValueExpressionContext
            self.op = None # EMultiplicationOperatorContext
            self.right = None # MultiplicationExpressionContext

        def valueExpression(self):
            return self.getTypedRuleContext(ExpressionParser.ValueExpressionContext,0)


        def eMultiplicationOperator(self):
            return self.getTypedRuleContext(ExpressionParser.EMultiplicationOperatorContext,0)


        def multiplicationExpression(self):
            return self.getTypedRuleContext(ExpressionParser.MultiplicationExpressionContext,0)


        def getRuleIndex(self):
            return ExpressionParser.RULE_multiplicationExpression

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterMultiplicationExpression" ):
                listener.enterMultiplicationExpression(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitMultiplicationExpression" ):
                listener.exitMultiplicationExpression(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitMultiplicationExpression" ):
                return visitor.visitMultiplicationExpression(self)
            else:
                return visitor.visitChildren(self)




    def multiplicationExpression(self):

        localctx = ExpressionParser.MultiplicationExpressionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 4, self.RULE_multiplicationExpression)
        try:
            self.state = 42
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,1,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 37
                localctx.left = self.valueExpression()
                self.state = 38
                localctx.op = self.eMultiplicationOperator()
                self.state = 39
                localctx.right = self.multiplicationExpression()
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 41
                self.valueExpression()
                pass


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class EMultiplicationOperatorContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser


        def getRuleIndex(self):
            return ExpressionParser.RULE_eMultiplicationOperator

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterEMultiplicationOperator" ):
                listener.enterEMultiplicationOperator(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitEMultiplicationOperator" ):
                listener.exitEMultiplicationOperator(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitEMultiplicationOperator" ):
                return visitor.visitEMultiplicationOperator(self)
            else:
                return visitor.visitChildren(self)




    def eMultiplicationOperator(self):

        localctx = ExpressionParser.EMultiplicationOperatorContext(self, self._ctx, self.state)
        self.enterRule(localctx, 6, self.RULE_eMultiplicationOperator)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 44
            _la = self._input.LA(1)
            if not((((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << ExpressionParser.T__2) | (1 << ExpressionParser.T__3) | (1 << ExpressionParser.T__4))) != 0)):
                self._errHandler.recoverInline(self)
            else:
                self._errHandler.reportMatch(self)
                self.consume()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class ValueExpressionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def parenthesisExpression(self):
            return self.getTypedRuleContext(ExpressionParser.ParenthesisExpressionContext,0)


        def namedElementReference(self):
            return self.getTypedRuleContext(ExpressionParser.NamedElementReferenceContext,0)


        def arrayExpression(self):
            return self.getTypedRuleContext(ExpressionParser.ArrayExpressionContext,0)


        def literalExpression(self):
            return self.getTypedRuleContext(ExpressionParser.LiteralExpressionContext,0)


        def getRuleIndex(self):
            return ExpressionParser.RULE_valueExpression

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterValueExpression" ):
                listener.enterValueExpression(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitValueExpression" ):
                listener.exitValueExpression(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitValueExpression" ):
                return visitor.visitValueExpression(self)
            else:
                return visitor.visitChildren(self)




    def valueExpression(self):

        localctx = ExpressionParser.ValueExpressionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 8, self.RULE_valueExpression)
        try:
            self.state = 50
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [ExpressionParser.T__5]:
                self.enterOuterAlt(localctx, 1)
                self.state = 46
                self.parenthesisExpression()
                pass
            elif token in [ExpressionParser.ID]:
                self.enterOuterAlt(localctx, 2)
                self.state = 47
                self.namedElementReference()
                pass
            elif token in [ExpressionParser.T__7]:
                self.enterOuterAlt(localctx, 3)
                self.state = 48
                self.arrayExpression()
                pass
            elif token in [ExpressionParser.ELONG, ExpressionParser.EDOUBLE, ExpressionParser.EBoolean, ExpressionParser.STRING]:
                self.enterOuterAlt(localctx, 4)
                self.state = 49
                self.literalExpression()
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


    class LiteralExpressionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.value = None # LiteralContext

        def literal(self):
            return self.getTypedRuleContext(ExpressionParser.LiteralContext,0)


        def getRuleIndex(self):
            return ExpressionParser.RULE_literalExpression

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterLiteralExpression" ):
                listener.enterLiteralExpression(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitLiteralExpression" ):
                listener.exitLiteralExpression(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitLiteralExpression" ):
                return visitor.visitLiteralExpression(self)
            else:
                return visitor.visitChildren(self)




    def literalExpression(self):

        localctx = ExpressionParser.LiteralExpressionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 10, self.RULE_literalExpression)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 52
            localctx.value = self.literal()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class LiteralContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def stringValue(self):
            return self.getTypedRuleContext(ExpressionParser.StringValueContext,0)


        def longValue(self):
            return self.getTypedRuleContext(ExpressionParser.LongValueContext,0)


        def doubleValue(self):
            return self.getTypedRuleContext(ExpressionParser.DoubleValueContext,0)


        def booleanValue(self):
            return self.getTypedRuleContext(ExpressionParser.BooleanValueContext,0)


        def getRuleIndex(self):
            return ExpressionParser.RULE_literal

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterLiteral" ):
                listener.enterLiteral(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitLiteral" ):
                listener.exitLiteral(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitLiteral" ):
                return visitor.visitLiteral(self)
            else:
                return visitor.visitChildren(self)




    def literal(self):

        localctx = ExpressionParser.LiteralContext(self, self._ctx, self.state)
        self.enterRule(localctx, 12, self.RULE_literal)
        try:
            self.state = 58
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [ExpressionParser.STRING]:
                self.enterOuterAlt(localctx, 1)
                self.state = 54
                self.stringValue()
                pass
            elif token in [ExpressionParser.ELONG]:
                self.enterOuterAlt(localctx, 2)
                self.state = 55
                self.longValue()
                pass
            elif token in [ExpressionParser.EDOUBLE]:
                self.enterOuterAlt(localctx, 3)
                self.state = 56
                self.doubleValue()
                pass
            elif token in [ExpressionParser.EBoolean]:
                self.enterOuterAlt(localctx, 4)
                self.state = 57
                self.booleanValue()
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


    class ParenthesisExpressionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.expression = None # ArithmeticExpressionContext

        def arithmeticExpression(self):
            return self.getTypedRuleContext(ExpressionParser.ArithmeticExpressionContext,0)


        def getRuleIndex(self):
            return ExpressionParser.RULE_parenthesisExpression

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterParenthesisExpression" ):
                listener.enterParenthesisExpression(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitParenthesisExpression" ):
                listener.exitParenthesisExpression(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitParenthesisExpression" ):
                return visitor.visitParenthesisExpression(self)
            else:
                return visitor.visitChildren(self)




    def parenthesisExpression(self):

        localctx = ExpressionParser.ParenthesisExpressionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 14, self.RULE_parenthesisExpression)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 60
            self.match(ExpressionParser.T__5)
            self.state = 61
            localctx.expression = self.arithmeticExpression()
            self.state = 62
            self.match(ExpressionParser.T__6)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class ArrayExpressionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self._arithmeticExpression = None # ArithmeticExpressionContext
            self.elements = list() # of ArithmeticExpressionContexts

        def arithmeticExpression(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(ExpressionParser.ArithmeticExpressionContext)
            else:
                return self.getTypedRuleContext(ExpressionParser.ArithmeticExpressionContext,i)


        def getRuleIndex(self):
            return ExpressionParser.RULE_arrayExpression

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterArrayExpression" ):
                listener.enterArrayExpression(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitArrayExpression" ):
                listener.exitArrayExpression(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitArrayExpression" ):
                return visitor.visitArrayExpression(self)
            else:
                return visitor.visitChildren(self)




    def arrayExpression(self):

        localctx = ExpressionParser.ArrayExpressionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 16, self.RULE_arrayExpression)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 64
            self.match(ExpressionParser.T__7)
            self.state = 73
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if (((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << ExpressionParser.T__5) | (1 << ExpressionParser.T__7) | (1 << ExpressionParser.ELONG) | (1 << ExpressionParser.EDOUBLE) | (1 << ExpressionParser.EBoolean) | (1 << ExpressionParser.ID) | (1 << ExpressionParser.STRING))) != 0):
                self.state = 65
                localctx._arithmeticExpression = self.arithmeticExpression()
                localctx.elements.append(localctx._arithmeticExpression)
                self.state = 70
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==ExpressionParser.T__8:
                    self.state = 66
                    self.match(ExpressionParser.T__8)
                    self.state = 67
                    localctx._arithmeticExpression = self.arithmeticExpression()
                    localctx.elements.append(localctx._arithmeticExpression)
                    self.state = 72
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)



            self.state = 75
            self.match(ExpressionParser.T__9)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class NamedElementReferenceContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.element = None # Token
            self.attribute = None # Token

        def ID(self, i:int=None):
            if i is None:
                return self.getTokens(ExpressionParser.ID)
            else:
                return self.getToken(ExpressionParser.ID, i)

        def getRuleIndex(self):
            return ExpressionParser.RULE_namedElementReference

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterNamedElementReference" ):
                listener.enterNamedElementReference(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitNamedElementReference" ):
                listener.exitNamedElementReference(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitNamedElementReference" ):
                return visitor.visitNamedElementReference(self)
            else:
                return visitor.visitChildren(self)




    def namedElementReference(self):

        localctx = ExpressionParser.NamedElementReferenceContext(self, self._ctx, self.state)
        self.enterRule(localctx, 18, self.RULE_namedElementReference)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 77
            localctx.element = self.match(ExpressionParser.ID)
            self.state = 80
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==ExpressionParser.T__10:
                self.state = 78
                self.match(ExpressionParser.T__10)
                self.state = 79
                localctx.attribute = self.match(ExpressionParser.ID)


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class StringValueContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.value = None # Token

        def STRING(self):
            return self.getToken(ExpressionParser.STRING, 0)

        def getRuleIndex(self):
            return ExpressionParser.RULE_stringValue

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterStringValue" ):
                listener.enterStringValue(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitStringValue" ):
                listener.exitStringValue(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitStringValue" ):
                return visitor.visitStringValue(self)
            else:
                return visitor.visitChildren(self)




    def stringValue(self):

        localctx = ExpressionParser.StringValueContext(self, self._ctx, self.state)
        self.enterRule(localctx, 20, self.RULE_stringValue)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 82
            localctx.value = self.match(ExpressionParser.STRING)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class LongValueContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.value = None # Token

        def ELONG(self):
            return self.getToken(ExpressionParser.ELONG, 0)

        def getRuleIndex(self):
            return ExpressionParser.RULE_longValue

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterLongValue" ):
                listener.enterLongValue(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitLongValue" ):
                listener.exitLongValue(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitLongValue" ):
                return visitor.visitLongValue(self)
            else:
                return visitor.visitChildren(self)




    def longValue(self):

        localctx = ExpressionParser.LongValueContext(self, self._ctx, self.state)
        self.enterRule(localctx, 22, self.RULE_longValue)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 84
            localctx.value = self.match(ExpressionParser.ELONG)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class DoubleValueContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.value = None # Token

        def EDOUBLE(self):
            return self.getToken(ExpressionParser.EDOUBLE, 0)

        def getRuleIndex(self):
            return ExpressionParser.RULE_doubleValue

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterDoubleValue" ):
                listener.enterDoubleValue(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitDoubleValue" ):
                listener.exitDoubleValue(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitDoubleValue" ):
                return visitor.visitDoubleValue(self)
            else:
                return visitor.visitChildren(self)




    def doubleValue(self):

        localctx = ExpressionParser.DoubleValueContext(self, self._ctx, self.state)
        self.enterRule(localctx, 24, self.RULE_doubleValue)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 86
            localctx.value = self.match(ExpressionParser.EDOUBLE)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class BooleanValueContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.value = None # Token

        def EBoolean(self):
            return self.getToken(ExpressionParser.EBoolean, 0)

        def getRuleIndex(self):
            return ExpressionParser.RULE_booleanValue

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterBooleanValue" ):
                listener.enterBooleanValue(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitBooleanValue" ):
                listener.exitBooleanValue(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitBooleanValue" ):
                return visitor.visitBooleanValue(self)
            else:
                return visitor.visitChildren(self)




    def booleanValue(self):

        localctx = ExpressionParser.BooleanValueContext(self, self._ctx, self.state)
        self.enterRule(localctx, 26, self.RULE_booleanValue)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 88
            localctx.value = self.match(ExpressionParser.EBoolean)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx





