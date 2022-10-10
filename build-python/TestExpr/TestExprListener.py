# Generated from /home/sgu/IdeaProjects/antlr4-python/grammars/dev/TestExpr.g4 by ANTLR 4.10.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .TestExprParser import TestExprParser
else:
    from TestExprParser import TestExprParser

# This class defines a complete listener for a parse tree produced by TestExprParser.
class TestExprListener(ParseTreeListener):

    # Enter a parse tree produced by TestExprParser#prog.
    def enterProg(self, ctx:TestExprParser.ProgContext):
        pass

    # Exit a parse tree produced by TestExprParser#prog.
    def exitProg(self, ctx:TestExprParser.ProgContext):
        pass


    # Enter a parse tree produced by TestExprParser#printExpr.
    def enterPrintExpr(self, ctx:TestExprParser.PrintExprContext):
        pass

    # Exit a parse tree produced by TestExprParser#printExpr.
    def exitPrintExpr(self, ctx:TestExprParser.PrintExprContext):
        pass


    # Enter a parse tree produced by TestExprParser#assign.
    def enterAssign(self, ctx:TestExprParser.AssignContext):
        pass

    # Exit a parse tree produced by TestExprParser#assign.
    def exitAssign(self, ctx:TestExprParser.AssignContext):
        pass


    # Enter a parse tree produced by TestExprParser#blank.
    def enterBlank(self, ctx:TestExprParser.BlankContext):
        pass

    # Exit a parse tree produced by TestExprParser#blank.
    def exitBlank(self, ctx:TestExprParser.BlankContext):
        pass


    # Enter a parse tree produced by TestExprParser#parens.
    def enterParens(self, ctx:TestExprParser.ParensContext):
        pass

    # Exit a parse tree produced by TestExprParser#parens.
    def exitParens(self, ctx:TestExprParser.ParensContext):
        pass


    # Enter a parse tree produced by TestExprParser#MulDiv.
    def enterMulDiv(self, ctx:TestExprParser.MulDivContext):
        pass

    # Exit a parse tree produced by TestExprParser#MulDiv.
    def exitMulDiv(self, ctx:TestExprParser.MulDivContext):
        pass


    # Enter a parse tree produced by TestExprParser#AddSub.
    def enterAddSub(self, ctx:TestExprParser.AddSubContext):
        pass

    # Exit a parse tree produced by TestExprParser#AddSub.
    def exitAddSub(self, ctx:TestExprParser.AddSubContext):
        pass


    # Enter a parse tree produced by TestExprParser#id.
    def enterId(self, ctx:TestExprParser.IdContext):
        pass

    # Exit a parse tree produced by TestExprParser#id.
    def exitId(self, ctx:TestExprParser.IdContext):
        pass


    # Enter a parse tree produced by TestExprParser#int.
    def enterInt(self, ctx:TestExprParser.IntContext):
        pass

    # Exit a parse tree produced by TestExprParser#int.
    def exitInt(self, ctx:TestExprParser.IntContext):
        pass



del TestExprParser