# Generated from TestGrammar.g4 by ANTLR 4.11.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .TestGrammarParser import TestGrammarParser
else:
    from TestGrammarParser import TestGrammarParser

# This class defines a complete generic visitor for a parse tree produced by TestGrammarParser.

class TestGrammarVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by TestGrammarParser#startProg.
    def visitStartProg(self, ctx:TestGrammarParser.StartProgContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestGrammarParser#printExprStat.
    def visitPrintExprStat(self, ctx:TestGrammarParser.PrintExprStatContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestGrammarParser#assignStat.
    def visitAssignStat(self, ctx:TestGrammarParser.AssignStatContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestGrammarParser#blankStat.
    def visitBlankStat(self, ctx:TestGrammarParser.BlankStatContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestGrammarParser#addSubExpr.
    def visitAddSubExpr(self, ctx:TestGrammarParser.AddSubExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestGrammarParser#funRef.
    def visitFunRef(self, ctx:TestGrammarParser.FunRefContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestGrammarParser#numberExpr.
    def visitNumberExpr(self, ctx:TestGrammarParser.NumberExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestGrammarParser#parensExpr.
    def visitParensExpr(self, ctx:TestGrammarParser.ParensExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestGrammarParser#mulDivExpr.
    def visitMulDivExpr(self, ctx:TestGrammarParser.MulDivExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestGrammarParser#idRef.
    def visitIdRef(self, ctx:TestGrammarParser.IdRefContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestGrammarParser#argList.
    def visitArgList(self, ctx:TestGrammarParser.ArgListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestGrammarParser#varExpr.
    def visitVarExpr(self, ctx:TestGrammarParser.VarExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestGrammarParser#funcExpr.
    def visitFuncExpr(self, ctx:TestGrammarParser.FuncExprContext):
        return self.visitChildren(ctx)



del TestGrammarParser