# Generated from TestDrivenDev.g4 by ANTLR 4.11.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .TestDrivenDevParser import TestDrivenDevParser
else:
    from TestDrivenDevParser import TestDrivenDevParser

# This class defines a complete generic visitor for a parse tree produced by TestDrivenDevParser.

class TestDrivenDevVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by TestDrivenDevParser#sut.
    def visitSut(self, ctx:TestDrivenDevParser.SutContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#input.
    def visitInput(self, ctx:TestDrivenDevParser.InputContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#output.
    def visitOutput(self, ctx:TestDrivenDevParser.OutputContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#scope.
    def visitScope(self, ctx:TestDrivenDevParser.ScopeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#var.
    def visitVar(self, ctx:TestDrivenDevParser.VarContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#assertion.
    def visitAssertion(self, ctx:TestDrivenDevParser.AssertionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#documentation.
    def visitDocumentation(self, ctx:TestDrivenDevParser.DocumentationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#addSubExpr.
    def visitAddSubExpr(self, ctx:TestDrivenDevParser.AddSubExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#numberExpr.
    def visitNumberExpr(self, ctx:TestDrivenDevParser.NumberExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#parensExpr.
    def visitParensExpr(self, ctx:TestDrivenDevParser.ParensExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#mulDivExpr.
    def visitMulDivExpr(self, ctx:TestDrivenDevParser.MulDivExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#directive.
    def visitDirective(self, ctx:TestDrivenDevParser.DirectiveContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#paramType.
    def visitParamType(self, ctx:TestDrivenDevParser.ParamTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#typeRef.
    def visitTypeRef(self, ctx:TestDrivenDevParser.TypeRefContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#enumType.
    def visitEnumType(self, ctx:TestDrivenDevParser.EnumTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#enum.
    def visitEnum(self, ctx:TestDrivenDevParser.EnumContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#arrayType.
    def visitArrayType(self, ctx:TestDrivenDevParser.ArrayTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#dim.
    def visitDim(self, ctx:TestDrivenDevParser.DimContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#sizeDim.
    def visitSizeDim(self, ctx:TestDrivenDevParser.SizeDimContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#rangeDim.
    def visitRangeDim(self, ctx:TestDrivenDevParser.RangeDimContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#unitSpec.
    def visitUnitSpec(self, ctx:TestDrivenDevParser.UnitSpecContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#basicUnit.
    def visitBasicUnit(self, ctx:TestDrivenDevParser.BasicUnitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#siUnit.
    def visitSiUnit(self, ctx:TestDrivenDevParser.SiUnitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#customUnit.
    def visitCustomUnit(self, ctx:TestDrivenDevParser.CustomUnitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#composedUnit.
    def visitComposedUnit(self, ctx:TestDrivenDevParser.ComposedUnitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#unitPrefix.
    def visitUnitPrefix(self, ctx:TestDrivenDevParser.UnitPrefixContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by TestDrivenDevParser#siType.
    def visitSiType(self, ctx:TestDrivenDevParser.SiTypeContext):
        return self.visitChildren(ctx)



del TestDrivenDevParser