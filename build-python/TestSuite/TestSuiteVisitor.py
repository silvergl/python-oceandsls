# Generated from TestSuite.g4 by ANTLR 4.12.0
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .TestSuiteParser import TestSuiteParser
else:
    from TestSuiteParser import TestSuiteParser

# This class defines a complete generic visitor for a parse tree produced by TestSuiteParser.

class TestSuiteVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by TestSuiteParser#test_suite.
    def visitTest_suite(self, ctx:TestSuiteParser.Test_suiteContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#test_case.
    def visitTest_case(self, ctx:TestSuiteParser.Test_caseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#test_assertion.
    def visitTest_assertion(self, ctx:TestSuiteParser.Test_assertionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#test_input.
    def visitTest_input(self, ctx:TestSuiteParser.Test_inputContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#test_output.
    def visitTest_output(self, ctx:TestSuiteParser.Test_outputContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#parameter.
    def visitParameter(self, ctx:TestSuiteParser.ParameterContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#emptyDesc.
    def visitEmptyDesc(self, ctx:TestSuiteParser.EmptyDescContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#specDesc.
    def visitSpecDesc(self, ctx:TestSuiteParser.SpecDescContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#emptyComment.
    def visitEmptyComment(self, ctx:TestSuiteParser.EmptyCommentContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#specComment.
    def visitSpecComment(self, ctx:TestSuiteParser.SpecCommentContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#nameDecl.
    def visitNameDecl(self, ctx:TestSuiteParser.NameDeclContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#typeDecl.
    def visitTypeDecl(self, ctx:TestSuiteParser.TypeDeclContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#combinedDecl.
    def visitCombinedDecl(self, ctx:TestSuiteParser.CombinedDeclContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#strExpr.
    def visitStrExpr(self, ctx:TestSuiteParser.StrExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#intExpr.
    def visitIntExpr(self, ctx:TestSuiteParser.IntExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#addSubExpr.
    def visitAddSubExpr(self, ctx:TestSuiteParser.AddSubExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#numberExpr.
    def visitNumberExpr(self, ctx:TestSuiteParser.NumberExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#parensExpr.
    def visitParensExpr(self, ctx:TestSuiteParser.ParensExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#mulDivExpr.
    def visitMulDivExpr(self, ctx:TestSuiteParser.MulDivExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#directive.
    def visitDirective(self, ctx:TestSuiteParser.DirectiveContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#paramType.
    def visitParamType(self, ctx:TestSuiteParser.ParamTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#typeRef.
    def visitTypeRef(self, ctx:TestSuiteParser.TypeRefContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#enumType.
    def visitEnumType(self, ctx:TestSuiteParser.EnumTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#enum.
    def visitEnum(self, ctx:TestSuiteParser.EnumContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#arrayType.
    def visitArrayType(self, ctx:TestSuiteParser.ArrayTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#dim.
    def visitDim(self, ctx:TestSuiteParser.DimContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#sizeDim.
    def visitSizeDim(self, ctx:TestSuiteParser.SizeDimContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#rangeDim.
    def visitRangeDim(self, ctx:TestSuiteParser.RangeDimContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#unitSpec.
    def visitUnitSpec(self, ctx:TestSuiteParser.UnitSpecContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#composedUnit.
    def visitComposedUnit(self, ctx:TestSuiteParser.ComposedUnitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#basicUnit.
    def visitBasicUnit(self, ctx:TestSuiteParser.BasicUnitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#siUnit.
    def visitSiUnit(self, ctx:TestSuiteParser.SiUnitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#customUnit.
    def visitCustomUnit(self, ctx:TestSuiteParser.CustomUnitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#unitPrefix.
    def visitUnitPrefix(self, ctx:TestSuiteParser.UnitPrefixContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestSuiteParser#siType.
    def visitSiType(self, ctx:TestSuiteParser.SiTypeContext):
        return self.visitChildren(ctx)



del TestSuiteParser