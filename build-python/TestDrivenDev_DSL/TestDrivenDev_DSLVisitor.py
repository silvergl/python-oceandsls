# Generated from TestDrivenDev_DSL.g4 by ANTLR 4.12.0
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .TestDrivenDev_DSLParser import TestDrivenDev_DSLParser
else:
    from TestDrivenDev_DSLParser import TestDrivenDev_DSLParser

# This class defines a complete generic visitor for a parse tree produced by TestDrivenDev_DSLParser.

class TestDrivenDev_DSLVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by TestDrivenDev_DSLParser#test_suite.
    def visitTest_suite(self, ctx:TestDrivenDev_DSLParser.Test_suiteContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDev_DSLParser#test_case.
    def visitTest_case(self, ctx:TestDrivenDev_DSLParser.Test_caseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDev_DSLParser#test_assertion.
    def visitTest_assertion(self, ctx:TestDrivenDev_DSLParser.Test_assertionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDev_DSLParser#test_input.
    def visitTest_input(self, ctx:TestDrivenDev_DSLParser.Test_inputContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDev_DSLParser#test_output.
    def visitTest_output(self, ctx:TestDrivenDev_DSLParser.Test_outputContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDev_DSLParser#param.
    def visitParam(self, ctx:TestDrivenDev_DSLParser.ParamContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDev_DSLParser#strExpr.
    def visitStrExpr(self, ctx:TestDrivenDev_DSLParser.StrExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDev_DSLParser#intExpr.
    def visitIntExpr(self, ctx:TestDrivenDev_DSLParser.IntExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDev_DSLParser#addSubExpr.
    def visitAddSubExpr(self, ctx:TestDrivenDev_DSLParser.AddSubExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDev_DSLParser#numberExpr.
    def visitNumberExpr(self, ctx:TestDrivenDev_DSLParser.NumberExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDev_DSLParser#parensExpr.
    def visitParensExpr(self, ctx:TestDrivenDev_DSLParser.ParensExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDev_DSLParser#mulDivExpr.
    def visitMulDivExpr(self, ctx:TestDrivenDev_DSLParser.MulDivExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDev_DSLParser#directive.
    def visitDirective(self, ctx:TestDrivenDev_DSLParser.DirectiveContext):
        return self.visitChildren(ctx)



del TestDrivenDev_DSLParser