# Generated from TestGrammar.g4 by ANTLR 4.11.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .TestGrammarParser import TestGrammarParser
else:
    from TestGrammarParser import TestGrammarParser

# This class defines a complete listener for a parse tree produced by TestGrammarParser.
class TestGrammarListener(ParseTreeListener):

    # Enter a parse tree produced by TestGrammarParser#startProg.
    def enterStartProg(self, ctx:TestGrammarParser.StartProgContext):
        pass

    # Exit a parse tree produced by TestGrammarParser#startProg.
    def exitStartProg(self, ctx:TestGrammarParser.StartProgContext):
        pass


    # Enter a parse tree produced by TestGrammarParser#printExprStat.
    def enterPrintExprStat(self, ctx:TestGrammarParser.PrintExprStatContext):
        pass

    # Exit a parse tree produced by TestGrammarParser#printExprStat.
    def exitPrintExprStat(self, ctx:TestGrammarParser.PrintExprStatContext):
        pass


    # Enter a parse tree produced by TestGrammarParser#assignStat.
    def enterAssignStat(self, ctx:TestGrammarParser.AssignStatContext):
        pass

    # Exit a parse tree produced by TestGrammarParser#assignStat.
    def exitAssignStat(self, ctx:TestGrammarParser.AssignStatContext):
        pass


    # Enter a parse tree produced by TestGrammarParser#blankStat.
    def enterBlankStat(self, ctx:TestGrammarParser.BlankStatContext):
        pass

    # Exit a parse tree produced by TestGrammarParser#blankStat.
    def exitBlankStat(self, ctx:TestGrammarParser.BlankStatContext):
        pass


    # Enter a parse tree produced by TestGrammarParser#funcExpr.
    def enterFuncExpr(self, ctx:TestGrammarParser.FuncExprContext):
        pass

    # Exit a parse tree produced by TestGrammarParser#funcExpr.
    def exitFuncExpr(self, ctx:TestGrammarParser.FuncExprContext):
        pass


    # Enter a parse tree produced by TestGrammarParser#addSubExpr.
    def enterAddSubExpr(self, ctx:TestGrammarParser.AddSubExprContext):
        pass

    # Exit a parse tree produced by TestGrammarParser#addSubExpr.
    def exitAddSubExpr(self, ctx:TestGrammarParser.AddSubExprContext):
        pass


    # Enter a parse tree produced by TestGrammarParser#numberExpr.
    def enterNumberExpr(self, ctx:TestGrammarParser.NumberExprContext):
        pass

    # Exit a parse tree produced by TestGrammarParser#numberExpr.
    def exitNumberExpr(self, ctx:TestGrammarParser.NumberExprContext):
        pass


    # Enter a parse tree produced by TestGrammarParser#parensExpr.
    def enterParensExpr(self, ctx:TestGrammarParser.ParensExprContext):
        pass

    # Exit a parse tree produced by TestGrammarParser#parensExpr.
    def exitParensExpr(self, ctx:TestGrammarParser.ParensExprContext):
        pass


    # Enter a parse tree produced by TestGrammarParser#mulDivExpr.
    def enterMulDivExpr(self, ctx:TestGrammarParser.MulDivExprContext):
        pass

    # Exit a parse tree produced by TestGrammarParser#mulDivExpr.
    def exitMulDivExpr(self, ctx:TestGrammarParser.MulDivExprContext):
        pass


    # Enter a parse tree produced by TestGrammarParser#idExpr.
    def enterIdExpr(self, ctx:TestGrammarParser.IdExprContext):
        pass

    # Exit a parse tree produced by TestGrammarParser#idExpr.
    def exitIdExpr(self, ctx:TestGrammarParser.IdExprContext):
        pass


    # Enter a parse tree produced by TestGrammarParser#argList.
    def enterArgList(self, ctx:TestGrammarParser.ArgListContext):
        pass

    # Exit a parse tree produced by TestGrammarParser#argList.
    def exitArgList(self, ctx:TestGrammarParser.ArgListContext):
        pass



del TestGrammarParser