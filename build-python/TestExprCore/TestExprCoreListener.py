# Generated from TestExprCore.g4 by ANTLR 4.11.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .TestExprCoreParser import TestExprCoreParser
else:
    from TestExprCoreParser import TestExprCoreParser

# This class defines a complete listener for a parse tree produced by TestExprCoreParser.
class TestExprCoreListener(ParseTreeListener):

    # Enter a parse tree produced by TestExprCoreParser#expression.
    def enterExpression(self, ctx:TestExprCoreParser.ExpressionContext):
        pass

    # Exit a parse tree produced by TestExprCoreParser#expression.
    def exitExpression(self, ctx:TestExprCoreParser.ExpressionContext):
        pass


    # Enter a parse tree produced by TestExprCoreParser#assignment.
    def enterAssignment(self, ctx:TestExprCoreParser.AssignmentContext):
        pass

    # Exit a parse tree produced by TestExprCoreParser#assignment.
    def exitAssignment(self, ctx:TestExprCoreParser.AssignmentContext):
        pass


    # Enter a parse tree produced by TestExprCoreParser#simpleExpression.
    def enterSimpleExpression(self, ctx:TestExprCoreParser.SimpleExpressionContext):
        pass

    # Exit a parse tree produced by TestExprCoreParser#simpleExpression.
    def exitSimpleExpression(self, ctx:TestExprCoreParser.SimpleExpressionContext):
        pass


    # Enter a parse tree produced by TestExprCoreParser#variableRef.
    def enterVariableRef(self, ctx:TestExprCoreParser.VariableRefContext):
        pass

    # Exit a parse tree produced by TestExprCoreParser#variableRef.
    def exitVariableRef(self, ctx:TestExprCoreParser.VariableRefContext):
        pass


    # Enter a parse tree produced by TestExprCoreParser#functionRef.
    def enterFunctionRef(self, ctx:TestExprCoreParser.FunctionRefContext):
        pass

    # Exit a parse tree produced by TestExprCoreParser#functionRef.
    def exitFunctionRef(self, ctx:TestExprCoreParser.FunctionRefContext):
        pass


    # Enter a parse tree produced by TestExprCoreParser#identifier.
    def enterIdentifier(self, ctx:TestExprCoreParser.IdentifierContext):
        pass

    # Exit a parse tree produced by TestExprCoreParser#identifier.
    def exitIdentifier(self, ctx:TestExprCoreParser.IdentifierContext):
        pass



del TestExprCoreParser