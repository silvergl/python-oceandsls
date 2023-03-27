# Generated from TestDrivenDev_DSL.g4 by ANTLR 4.12.0
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .TestDrivenDev_DSLParser import TestDrivenDev_DSLParser
else:
    from TestDrivenDev_DSLParser import TestDrivenDev_DSLParser

# This class defines a complete listener for a parse tree produced by TestDrivenDev_DSLParser.
class TestDrivenDev_DSLListener(ParseTreeListener):

    # Enter a parse tree produced by TestDrivenDev_DSLParser#test_suite.
    def enterTest_suite(self, ctx:TestDrivenDev_DSLParser.Test_suiteContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#test_suite.
    def exitTest_suite(self, ctx:TestDrivenDev_DSLParser.Test_suiteContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#test_case.
    def enterTest_case(self, ctx:TestDrivenDev_DSLParser.Test_caseContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#test_case.
    def exitTest_case(self, ctx:TestDrivenDev_DSLParser.Test_caseContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#test_assertion.
    def enterTest_assertion(self, ctx:TestDrivenDev_DSLParser.Test_assertionContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#test_assertion.
    def exitTest_assertion(self, ctx:TestDrivenDev_DSLParser.Test_assertionContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#test_input.
    def enterTest_input(self, ctx:TestDrivenDev_DSLParser.Test_inputContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#test_input.
    def exitTest_input(self, ctx:TestDrivenDev_DSLParser.Test_inputContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#test_output.
    def enterTest_output(self, ctx:TestDrivenDev_DSLParser.Test_outputContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#test_output.
    def exitTest_output(self, ctx:TestDrivenDev_DSLParser.Test_outputContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#var.
    def enterVar(self, ctx:TestDrivenDev_DSLParser.VarContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#var.
    def exitVar(self, ctx:TestDrivenDev_DSLParser.VarContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#param.
    def enterParam(self, ctx:TestDrivenDev_DSLParser.ParamContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#param.
    def exitParam(self, ctx:TestDrivenDev_DSLParser.ParamContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#documentation.
    def enterDocumentation(self, ctx:TestDrivenDev_DSLParser.DocumentationContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#documentation.
    def exitDocumentation(self, ctx:TestDrivenDev_DSLParser.DocumentationContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#strExpr.
    def enterStrExpr(self, ctx:TestDrivenDev_DSLParser.StrExprContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#strExpr.
    def exitStrExpr(self, ctx:TestDrivenDev_DSLParser.StrExprContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#intExpr.
    def enterIntExpr(self, ctx:TestDrivenDev_DSLParser.IntExprContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#intExpr.
    def exitIntExpr(self, ctx:TestDrivenDev_DSLParser.IntExprContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#addSubExpr.
    def enterAddSubExpr(self, ctx:TestDrivenDev_DSLParser.AddSubExprContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#addSubExpr.
    def exitAddSubExpr(self, ctx:TestDrivenDev_DSLParser.AddSubExprContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#numberExpr.
    def enterNumberExpr(self, ctx:TestDrivenDev_DSLParser.NumberExprContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#numberExpr.
    def exitNumberExpr(self, ctx:TestDrivenDev_DSLParser.NumberExprContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#parensExpr.
    def enterParensExpr(self, ctx:TestDrivenDev_DSLParser.ParensExprContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#parensExpr.
    def exitParensExpr(self, ctx:TestDrivenDev_DSLParser.ParensExprContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#mulDivExpr.
    def enterMulDivExpr(self, ctx:TestDrivenDev_DSLParser.MulDivExprContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#mulDivExpr.
    def exitMulDivExpr(self, ctx:TestDrivenDev_DSLParser.MulDivExprContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#directive.
    def enterDirective(self, ctx:TestDrivenDev_DSLParser.DirectiveContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#directive.
    def exitDirective(self, ctx:TestDrivenDev_DSLParser.DirectiveContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#paramType.
    def enterParamType(self, ctx:TestDrivenDev_DSLParser.ParamTypeContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#paramType.
    def exitParamType(self, ctx:TestDrivenDev_DSLParser.ParamTypeContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#typeRef.
    def enterTypeRef(self, ctx:TestDrivenDev_DSLParser.TypeRefContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#typeRef.
    def exitTypeRef(self, ctx:TestDrivenDev_DSLParser.TypeRefContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#enumType.
    def enterEnumType(self, ctx:TestDrivenDev_DSLParser.EnumTypeContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#enumType.
    def exitEnumType(self, ctx:TestDrivenDev_DSLParser.EnumTypeContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#enum.
    def enterEnum(self, ctx:TestDrivenDev_DSLParser.EnumContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#enum.
    def exitEnum(self, ctx:TestDrivenDev_DSLParser.EnumContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#arrayType.
    def enterArrayType(self, ctx:TestDrivenDev_DSLParser.ArrayTypeContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#arrayType.
    def exitArrayType(self, ctx:TestDrivenDev_DSLParser.ArrayTypeContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#dim.
    def enterDim(self, ctx:TestDrivenDev_DSLParser.DimContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#dim.
    def exitDim(self, ctx:TestDrivenDev_DSLParser.DimContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#sizeDim.
    def enterSizeDim(self, ctx:TestDrivenDev_DSLParser.SizeDimContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#sizeDim.
    def exitSizeDim(self, ctx:TestDrivenDev_DSLParser.SizeDimContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#rangeDim.
    def enterRangeDim(self, ctx:TestDrivenDev_DSLParser.RangeDimContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#rangeDim.
    def exitRangeDim(self, ctx:TestDrivenDev_DSLParser.RangeDimContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#unitSpec.
    def enterUnitSpec(self, ctx:TestDrivenDev_DSLParser.UnitSpecContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#unitSpec.
    def exitUnitSpec(self, ctx:TestDrivenDev_DSLParser.UnitSpecContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#basicUnit.
    def enterBasicUnit(self, ctx:TestDrivenDev_DSLParser.BasicUnitContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#basicUnit.
    def exitBasicUnit(self, ctx:TestDrivenDev_DSLParser.BasicUnitContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#siUnit.
    def enterSiUnit(self, ctx:TestDrivenDev_DSLParser.SiUnitContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#siUnit.
    def exitSiUnit(self, ctx:TestDrivenDev_DSLParser.SiUnitContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#customUnit.
    def enterCustomUnit(self, ctx:TestDrivenDev_DSLParser.CustomUnitContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#customUnit.
    def exitCustomUnit(self, ctx:TestDrivenDev_DSLParser.CustomUnitContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#composedUnit.
    def enterComposedUnit(self, ctx:TestDrivenDev_DSLParser.ComposedUnitContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#composedUnit.
    def exitComposedUnit(self, ctx:TestDrivenDev_DSLParser.ComposedUnitContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#unitPrefix.
    def enterUnitPrefix(self, ctx:TestDrivenDev_DSLParser.UnitPrefixContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#unitPrefix.
    def exitUnitPrefix(self, ctx:TestDrivenDev_DSLParser.UnitPrefixContext):
        pass


    # Enter a parse tree produced by TestDrivenDev_DSLParser#siType.
    def enterSiType(self, ctx:TestDrivenDev_DSLParser.SiTypeContext):
        pass

    # Exit a parse tree produced by TestDrivenDev_DSLParser#siType.
    def exitSiType(self, ctx:TestDrivenDev_DSLParser.SiTypeContext):
        pass



del TestDrivenDev_DSLParser