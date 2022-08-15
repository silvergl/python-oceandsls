# Generated from TestGrammar.g4 by ANTLR 4.10.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .TestGrammarParser import TestGrammarParser
else:
    from TestGrammarParser import TestGrammarParser

# This class defines a complete listener for a parse tree produced by TestGrammarParser.
class TestGrammarListener(ParseTreeListener):

    # Enter a parse tree produced by TestGrammarParser#FooExpr.
    def enterFooExpr(self, ctx:TestGrammarParser.FooExprContext):
        pass

    # Exit a parse tree produced by TestGrammarParser#FooExpr.
    def exitFooExpr(self, ctx:TestGrammarParser.FooExprContext):
        pass


    # Enter a parse tree produced by TestGrammarParser#BarExpr.
    def enterBarExpr(self, ctx:TestGrammarParser.BarExprContext):
        pass

    # Exit a parse tree produced by TestGrammarParser#BarExpr.
    def exitBarExpr(self, ctx:TestGrammarParser.BarExprContext):
        pass


    # Enter a parse tree produced by TestGrammarParser#NumberExpr.
    def enterNumberExpr(self, ctx:TestGrammarParser.NumberExprContext):
        pass

    # Exit a parse tree produced by TestGrammarParser#NumberExpr.
    def exitNumberExpr(self, ctx:TestGrammarParser.NumberExprContext):
        pass


    # Enter a parse tree produced by TestGrammarParser#ParenExpr.
    def enterParenExpr(self, ctx:TestGrammarParser.ParenExprContext):
        pass

    # Exit a parse tree produced by TestGrammarParser#ParenExpr.
    def exitParenExpr(self, ctx:TestGrammarParser.ParenExprContext):
        pass


    # Enter a parse tree produced by TestGrammarParser#InfixExpr.
    def enterInfixExpr(self, ctx:TestGrammarParser.InfixExprContext):
        pass

    # Exit a parse tree produced by TestGrammarParser#InfixExpr.
    def exitInfixExpr(self, ctx:TestGrammarParser.InfixExprContext):
        pass



del TestGrammarParser