# Generated from /home/sgu/IdeaProjects/antlr4-python/grammars/dev/TestExpr.g4 by ANTLR 4.10.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .TestExprParser import TestExprParser
else:
    from TestExprParser import TestExprParser

# This class defines a complete generic visitor for a parse tree produced by TestExprParser.

class TestExprVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by TestExprParser#prog.
    def visitProg(self, ctx:TestExprParser.ProgContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestExprParser#printExpr.
    def visitPrintExpr(self, ctx:TestExprParser.PrintExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestExprParser#assign.
    def visitAssign(self, ctx:TestExprParser.AssignContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestExprParser#blank.
    def visitBlank(self, ctx:TestExprParser.BlankContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestExprParser#parens.
    def visitParens(self, ctx:TestExprParser.ParensContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestExprParser#MulDiv.
    def visitMulDiv(self, ctx:TestExprParser.MulDivContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestExprParser#AddSub.
    def visitAddSub(self, ctx:TestExprParser.AddSubContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestExprParser#id.
    def visitId(self, ctx:TestExprParser.IdContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestExprParser#int.
    def visitInt(self, ctx:TestExprParser.IntContext):
        return self.visitChildren(ctx)



del TestExprParser