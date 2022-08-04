# Generated from Expression.g4 by ANTLR 4.10
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .ExpressionParser import ExpressionParser
else:
    from ExpressionParser import ExpressionParser

# This class defines a complete generic visitor for a parse tree produced by ExpressionParser.

class ExpressionVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by ExpressionParser#arithmeticExpression.
    def visitArithmeticExpression(self, ctx:ExpressionParser.ArithmeticExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExpressionParser#eAdditionOperator.
    def visitEAdditionOperator(self, ctx:ExpressionParser.EAdditionOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExpressionParser#multiplicationExpression.
    def visitMultiplicationExpression(self, ctx:ExpressionParser.MultiplicationExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExpressionParser#eMultiplicationOperator.
    def visitEMultiplicationOperator(self, ctx:ExpressionParser.EMultiplicationOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExpressionParser#valueExpression.
    def visitValueExpression(self, ctx:ExpressionParser.ValueExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExpressionParser#literalExpression.
    def visitLiteralExpression(self, ctx:ExpressionParser.LiteralExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExpressionParser#literal.
    def visitLiteral(self, ctx:ExpressionParser.LiteralContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExpressionParser#parenthesisExpression.
    def visitParenthesisExpression(self, ctx:ExpressionParser.ParenthesisExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExpressionParser#arrayExpression.
    def visitArrayExpression(self, ctx:ExpressionParser.ArrayExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExpressionParser#namedElementReference.
    def visitNamedElementReference(self, ctx:ExpressionParser.NamedElementReferenceContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExpressionParser#stringValue.
    def visitStringValue(self, ctx:ExpressionParser.StringValueContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExpressionParser#longValue.
    def visitLongValue(self, ctx:ExpressionParser.LongValueContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExpressionParser#doubleValue.
    def visitDoubleValue(self, ctx:ExpressionParser.DoubleValueContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ExpressionParser#booleanValue.
    def visitBooleanValue(self, ctx:ExpressionParser.BooleanValueContext):
        return self.visitChildren(ctx)



del ExpressionParser