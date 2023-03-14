# Generated from TestDrivenDev.g4 by ANTLR 4.11.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .TestDrivenDevParser import TestDrivenDevParser
else:
    from TestDrivenDevParser import TestDrivenDevParser

# This class defines a complete listener for a parse tree produced by TestDrivenDevParser.
class TestDrivenDevListener(ParseTreeListener):

    # Enter a parse tree produced by TestDrivenDevParser#sut.
    def enterSut(self, ctx:TestDrivenDevParser.SutContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#sut.
    def exitSut(self, ctx:TestDrivenDevParser.SutContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#input.
    def enterInput(self, ctx:TestDrivenDevParser.InputContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#input.
    def exitInput(self, ctx:TestDrivenDevParser.InputContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#output.
    def enterOutput(self, ctx:TestDrivenDevParser.OutputContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#output.
    def exitOutput(self, ctx:TestDrivenDevParser.OutputContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#scope.
    def enterScope(self, ctx:TestDrivenDevParser.ScopeContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#scope.
    def exitScope(self, ctx:TestDrivenDevParser.ScopeContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#var.
    def enterVar(self, ctx:TestDrivenDevParser.VarContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#var.
    def exitVar(self, ctx:TestDrivenDevParser.VarContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#assertion.
    def enterAssertion(self, ctx:TestDrivenDevParser.AssertionContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#assertion.
    def exitAssertion(self, ctx:TestDrivenDevParser.AssertionContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#documentation.
    def enterDocumentation(self, ctx:TestDrivenDevParser.DocumentationContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#documentation.
    def exitDocumentation(self, ctx:TestDrivenDevParser.DocumentationContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#addSubExpr.
    def enterAddSubExpr(self, ctx:TestDrivenDevParser.AddSubExprContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#addSubExpr.
    def exitAddSubExpr(self, ctx:TestDrivenDevParser.AddSubExprContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#numberExpr.
    def enterNumberExpr(self, ctx:TestDrivenDevParser.NumberExprContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#numberExpr.
    def exitNumberExpr(self, ctx:TestDrivenDevParser.NumberExprContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#parensExpr.
    def enterParensExpr(self, ctx:TestDrivenDevParser.ParensExprContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#parensExpr.
    def exitParensExpr(self, ctx:TestDrivenDevParser.ParensExprContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#mulDivExpr.
    def enterMulDivExpr(self, ctx:TestDrivenDevParser.MulDivExprContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#mulDivExpr.
    def exitMulDivExpr(self, ctx:TestDrivenDevParser.MulDivExprContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#directive.
    def enterDirective(self, ctx:TestDrivenDevParser.DirectiveContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#directive.
    def exitDirective(self, ctx:TestDrivenDevParser.DirectiveContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#paramType.
    def enterParamType(self, ctx:TestDrivenDevParser.ParamTypeContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#paramType.
    def exitParamType(self, ctx:TestDrivenDevParser.ParamTypeContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#typeRef.
    def enterTypeRef(self, ctx:TestDrivenDevParser.TypeRefContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#typeRef.
    def exitTypeRef(self, ctx:TestDrivenDevParser.TypeRefContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#enumType.
    def enterEnumType(self, ctx:TestDrivenDevParser.EnumTypeContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#enumType.
    def exitEnumType(self, ctx:TestDrivenDevParser.EnumTypeContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#enum.
    def enterEnum(self, ctx:TestDrivenDevParser.EnumContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#enum.
    def exitEnum(self, ctx:TestDrivenDevParser.EnumContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#arrayType.
    def enterArrayType(self, ctx:TestDrivenDevParser.ArrayTypeContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#arrayType.
    def exitArrayType(self, ctx:TestDrivenDevParser.ArrayTypeContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#dim.
    def enterDim(self, ctx:TestDrivenDevParser.DimContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#dim.
    def exitDim(self, ctx:TestDrivenDevParser.DimContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#sizeDim.
    def enterSizeDim(self, ctx:TestDrivenDevParser.SizeDimContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#sizeDim.
    def exitSizeDim(self, ctx:TestDrivenDevParser.SizeDimContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#rangeDim.
    def enterRangeDim(self, ctx:TestDrivenDevParser.RangeDimContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#rangeDim.
    def exitRangeDim(self, ctx:TestDrivenDevParser.RangeDimContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#unitSpec.
    def enterUnitSpec(self, ctx:TestDrivenDevParser.UnitSpecContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#unitSpec.
    def exitUnitSpec(self, ctx:TestDrivenDevParser.UnitSpecContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#basicUnit.
    def enterBasicUnit(self, ctx:TestDrivenDevParser.BasicUnitContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#basicUnit.
    def exitBasicUnit(self, ctx:TestDrivenDevParser.BasicUnitContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#siUnit.
    def enterSiUnit(self, ctx:TestDrivenDevParser.SiUnitContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#siUnit.
    def exitSiUnit(self, ctx:TestDrivenDevParser.SiUnitContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#customUnit.
    def enterCustomUnit(self, ctx:TestDrivenDevParser.CustomUnitContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#customUnit.
    def exitCustomUnit(self, ctx:TestDrivenDevParser.CustomUnitContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#composedUnit.
    def enterComposedUnit(self, ctx:TestDrivenDevParser.ComposedUnitContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#composedUnit.
    def exitComposedUnit(self, ctx:TestDrivenDevParser.ComposedUnitContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#unitPrefix.
    def enterUnitPrefix(self, ctx:TestDrivenDevParser.UnitPrefixContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#unitPrefix.
    def exitUnitPrefix(self, ctx:TestDrivenDevParser.UnitPrefixContext):
        pass


    # Enter a parse tree produced by TestDrivenDevParser#siType.
    def enterSiType(self, ctx:TestDrivenDevParser.SiTypeContext):
        pass

    # Exit a parse tree produced by TestDrivenDevParser#siType.
    def exitSiType(self, ctx:TestDrivenDevParser.SiTypeContext):
        pass



del TestDrivenDevParser