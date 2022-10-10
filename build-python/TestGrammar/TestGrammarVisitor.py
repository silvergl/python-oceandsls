# Generated from TestGrammar.g4 by ANTLR 4.10.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .TestGrammarParser import TestGrammarParser
else:
    from TestGrammarParser import TestGrammarParser

# This class defines a complete generic visitor for a parse tree produced by TestGrammarParser.

class TestGrammarVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by TestGrammarParser#FooExpr.
    def visitFooExpr(self, ctx:TestGrammarParser.FooExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestGrammarParser#BarExpr.
    def visitBarExpr(self, ctx:TestGrammarParser.BarExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestGrammarParser#NumberExpr.
    def visitNumberExpr(self, ctx:TestGrammarParser.NumberExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestGrammarParser#ParenExpr.
    def visitParenExpr(self, ctx:TestGrammarParser.ParenExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestGrammarParser#InfixExpr.
    def visitInfixExpr(self, ctx:TestGrammarParser.InfixExprContext):
        return self.visitChildren(ctx)



del TestGrammarParser