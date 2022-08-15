# Generated from Expression.g4 by ANTLR 4.10.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .ExpressionParser import ExpressionParser
else:
    from ExpressionParser import ExpressionParser

# This class defines a complete listener for a parse tree produced by ExpressionParser.
class ExpressionListener(ParseTreeListener):

    # Enter a parse tree produced by ExpressionParser#arithmeticExpression.
    def enterArithmeticExpression(self, ctx:ExpressionParser.ArithmeticExpressionContext):
        pass

    # Exit a parse tree produced by ExpressionParser#arithmeticExpression.
    def exitArithmeticExpression(self, ctx:ExpressionParser.ArithmeticExpressionContext):
        pass


    # Enter a parse tree produced by ExpressionParser#eAdditionOperator.
    def enterEAdditionOperator(self, ctx:ExpressionParser.EAdditionOperatorContext):
        pass

    # Exit a parse tree produced by ExpressionParser#eAdditionOperator.
    def exitEAdditionOperator(self, ctx:ExpressionParser.EAdditionOperatorContext):
        pass


    # Enter a parse tree produced by ExpressionParser#multiplicationExpression.
    def enterMultiplicationExpression(self, ctx:ExpressionParser.MultiplicationExpressionContext):
        pass

    # Exit a parse tree produced by ExpressionParser#multiplicationExpression.
    def exitMultiplicationExpression(self, ctx:ExpressionParser.MultiplicationExpressionContext):
        pass


    # Enter a parse tree produced by ExpressionParser#eMultiplicationOperator.
    def enterEMultiplicationOperator(self, ctx:ExpressionParser.EMultiplicationOperatorContext):
        pass

    # Exit a parse tree produced by ExpressionParser#eMultiplicationOperator.
    def exitEMultiplicationOperator(self, ctx:ExpressionParser.EMultiplicationOperatorContext):
        pass


    # Enter a parse tree produced by ExpressionParser#valueExpression.
    def enterValueExpression(self, ctx:ExpressionParser.ValueExpressionContext):
        pass

    # Exit a parse tree produced by ExpressionParser#valueExpression.
    def exitValueExpression(self, ctx:ExpressionParser.ValueExpressionContext):
        pass


    # Enter a parse tree produced by ExpressionParser#literalExpression.
    def enterLiteralExpression(self, ctx:ExpressionParser.LiteralExpressionContext):
        pass

    # Exit a parse tree produced by ExpressionParser#literalExpression.
    def exitLiteralExpression(self, ctx:ExpressionParser.LiteralExpressionContext):
        pass


    # Enter a parse tree produced by ExpressionParser#literal.
    def enterLiteral(self, ctx:ExpressionParser.LiteralContext):
        pass

    # Exit a parse tree produced by ExpressionParser#literal.
    def exitLiteral(self, ctx:ExpressionParser.LiteralContext):
        pass


    # Enter a parse tree produced by ExpressionParser#parenthesisExpression.
    def enterParenthesisExpression(self, ctx:ExpressionParser.ParenthesisExpressionContext):
        pass

    # Exit a parse tree produced by ExpressionParser#parenthesisExpression.
    def exitParenthesisExpression(self, ctx:ExpressionParser.ParenthesisExpressionContext):
        pass


    # Enter a parse tree produced by ExpressionParser#arrayExpression.
    def enterArrayExpression(self, ctx:ExpressionParser.ArrayExpressionContext):
        pass

    # Exit a parse tree produced by ExpressionParser#arrayExpression.
    def exitArrayExpression(self, ctx:ExpressionParser.ArrayExpressionContext):
        pass


    # Enter a parse tree produced by ExpressionParser#namedElementReference.
    def enterNamedElementReference(self, ctx:ExpressionParser.NamedElementReferenceContext):
        pass

    # Exit a parse tree produced by ExpressionParser#namedElementReference.
    def exitNamedElementReference(self, ctx:ExpressionParser.NamedElementReferenceContext):
        pass


    # Enter a parse tree produced by ExpressionParser#stringValue.
    def enterStringValue(self, ctx:ExpressionParser.StringValueContext):
        pass

    # Exit a parse tree produced by ExpressionParser#stringValue.
    def exitStringValue(self, ctx:ExpressionParser.StringValueContext):
        pass


    # Enter a parse tree produced by ExpressionParser#longValue.
    def enterLongValue(self, ctx:ExpressionParser.LongValueContext):
        pass

    # Exit a parse tree produced by ExpressionParser#longValue.
    def exitLongValue(self, ctx:ExpressionParser.LongValueContext):
        pass


    # Enter a parse tree produced by ExpressionParser#doubleValue.
    def enterDoubleValue(self, ctx:ExpressionParser.DoubleValueContext):
        pass

    # Exit a parse tree produced by ExpressionParser#doubleValue.
    def exitDoubleValue(self, ctx:ExpressionParser.DoubleValueContext):
        pass


    # Enter a parse tree produced by ExpressionParser#booleanValue.
    def enterBooleanValue(self, ctx:ExpressionParser.BooleanValueContext):
        pass

    # Exit a parse tree produced by ExpressionParser#booleanValue.
    def exitBooleanValue(self, ctx:ExpressionParser.BooleanValueContext):
        pass



del ExpressionParser