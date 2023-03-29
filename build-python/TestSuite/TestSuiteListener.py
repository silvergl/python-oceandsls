# Generated from TestSuite.g4 by ANTLR 4.12.0
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .TestSuiteParser import TestSuiteParser
else:
    from TestSuiteParser import TestSuiteParser

# This class defines a complete listener for a parse tree produced by TestSuiteParser.
class TestSuiteListener(ParseTreeListener):

    # Enter a parse tree produced by TestSuiteParser#test_suite.
    def enterTest_suite(self, ctx:TestSuiteParser.Test_suiteContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#test_suite.
    def exitTest_suite(self, ctx:TestSuiteParser.Test_suiteContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#test_case.
    def enterTest_case(self, ctx:TestSuiteParser.Test_caseContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#test_case.
    def exitTest_case(self, ctx:TestSuiteParser.Test_caseContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#test_vars.
    def enterTest_vars(self, ctx:TestSuiteParser.Test_varsContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#test_vars.
    def exitTest_vars(self, ctx:TestSuiteParser.Test_varsContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#test_var.
    def enterTest_var(self, ctx:TestSuiteParser.Test_varContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#test_var.
    def exitTest_var(self, ctx:TestSuiteParser.Test_varContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#varDeclaration.
    def enterVarDeclaration(self, ctx:TestSuiteParser.VarDeclarationContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#varDeclaration.
    def exitVarDeclaration(self, ctx:TestSuiteParser.VarDeclarationContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#test_scope.
    def enterTest_scope(self, ctx:TestSuiteParser.Test_scopeContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#test_scope.
    def exitTest_scope(self, ctx:TestSuiteParser.Test_scopeContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#test_files.
    def enterTest_files(self, ctx:TestSuiteParser.Test_filesContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#test_files.
    def exitTest_files(self, ctx:TestSuiteParser.Test_filesContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#test_modules.
    def enterTest_modules(self, ctx:TestSuiteParser.Test_modulesContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#test_modules.
    def exitTest_modules(self, ctx:TestSuiteParser.Test_modulesContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#test_module.
    def enterTest_module(self, ctx:TestSuiteParser.Test_moduleContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#test_module.
    def exitTest_module(self, ctx:TestSuiteParser.Test_moduleContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#test_assertion.
    def enterTest_assertion(self, ctx:TestSuiteParser.Test_assertionContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#test_assertion.
    def exitTest_assertion(self, ctx:TestSuiteParser.Test_assertionContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#test_input.
    def enterTest_input(self, ctx:TestSuiteParser.Test_inputContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#test_input.
    def exitTest_input(self, ctx:TestSuiteParser.Test_inputContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#test_output.
    def enterTest_output(self, ctx:TestSuiteParser.Test_outputContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#test_output.
    def exitTest_output(self, ctx:TestSuiteParser.Test_outputContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#parameter.
    def enterParameter(self, ctx:TestSuiteParser.ParameterContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#parameter.
    def exitParameter(self, ctx:TestSuiteParser.ParameterContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#emptyDesc.
    def enterEmptyDesc(self, ctx:TestSuiteParser.EmptyDescContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#emptyDesc.
    def exitEmptyDesc(self, ctx:TestSuiteParser.EmptyDescContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#specDesc.
    def enterSpecDesc(self, ctx:TestSuiteParser.SpecDescContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#specDesc.
    def exitSpecDesc(self, ctx:TestSuiteParser.SpecDescContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#emptyComment.
    def enterEmptyComment(self, ctx:TestSuiteParser.EmptyCommentContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#emptyComment.
    def exitEmptyComment(self, ctx:TestSuiteParser.EmptyCommentContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#specComment.
    def enterSpecComment(self, ctx:TestSuiteParser.SpecCommentContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#specComment.
    def exitSpecComment(self, ctx:TestSuiteParser.SpecCommentContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#nameDecl.
    def enterNameDecl(self, ctx:TestSuiteParser.NameDeclContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#nameDecl.
    def exitNameDecl(self, ctx:TestSuiteParser.NameDeclContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#typeDecl.
    def enterTypeDecl(self, ctx:TestSuiteParser.TypeDeclContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#typeDecl.
    def exitTypeDecl(self, ctx:TestSuiteParser.TypeDeclContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#combinedDecl.
    def enterCombinedDecl(self, ctx:TestSuiteParser.CombinedDeclContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#combinedDecl.
    def exitCombinedDecl(self, ctx:TestSuiteParser.CombinedDeclContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#arraySpec.
    def enterArraySpec(self, ctx:TestSuiteParser.ArraySpecContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#arraySpec.
    def exitArraySpec(self, ctx:TestSuiteParser.ArraySpecContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#argSpecInput.
    def enterArgSpecInput(self, ctx:TestSuiteParser.ArgSpecInputContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#argSpecInput.
    def exitArgSpecInput(self, ctx:TestSuiteParser.ArgSpecInputContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#argSpecInOutput.
    def enterArgSpecInOutput(self, ctx:TestSuiteParser.ArgSpecInOutputContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#argSpecInOutput.
    def exitArgSpecInOutput(self, ctx:TestSuiteParser.ArgSpecInOutputContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#argSpecOutput.
    def enterArgSpecOutput(self, ctx:TestSuiteParser.ArgSpecOutputContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#argSpecOutput.
    def exitArgSpecOutput(self, ctx:TestSuiteParser.ArgSpecOutputContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#constantSpec.
    def enterConstantSpec(self, ctx:TestSuiteParser.ConstantSpecContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#constantSpec.
    def exitConstantSpec(self, ctx:TestSuiteParser.ConstantSpecContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#custom.
    def enterCustom(self, ctx:TestSuiteParser.CustomContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#custom.
    def exitCustom(self, ctx:TestSuiteParser.CustomContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#directive.
    def enterDirective(self, ctx:TestSuiteParser.DirectiveContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#directive.
    def exitDirective(self, ctx:TestSuiteParser.DirectiveContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#paramType.
    def enterParamType(self, ctx:TestSuiteParser.ParamTypeContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#paramType.
    def exitParamType(self, ctx:TestSuiteParser.ParamTypeContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#typeRef.
    def enterTypeRef(self, ctx:TestSuiteParser.TypeRefContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#typeRef.
    def exitTypeRef(self, ctx:TestSuiteParser.TypeRefContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#enumType.
    def enterEnumType(self, ctx:TestSuiteParser.EnumTypeContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#enumType.
    def exitEnumType(self, ctx:TestSuiteParser.EnumTypeContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#enum.
    def enterEnum(self, ctx:TestSuiteParser.EnumContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#enum.
    def exitEnum(self, ctx:TestSuiteParser.EnumContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#arrayType.
    def enterArrayType(self, ctx:TestSuiteParser.ArrayTypeContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#arrayType.
    def exitArrayType(self, ctx:TestSuiteParser.ArrayTypeContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#dim.
    def enterDim(self, ctx:TestSuiteParser.DimContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#dim.
    def exitDim(self, ctx:TestSuiteParser.DimContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#sizeDim.
    def enterSizeDim(self, ctx:TestSuiteParser.SizeDimContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#sizeDim.
    def exitSizeDim(self, ctx:TestSuiteParser.SizeDimContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#rangeDim.
    def enterRangeDim(self, ctx:TestSuiteParser.RangeDimContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#rangeDim.
    def exitRangeDim(self, ctx:TestSuiteParser.RangeDimContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#strExpr.
    def enterStrExpr(self, ctx:TestSuiteParser.StrExprContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#strExpr.
    def exitStrExpr(self, ctx:TestSuiteParser.StrExprContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#intExpr.
    def enterIntExpr(self, ctx:TestSuiteParser.IntExprContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#intExpr.
    def exitIntExpr(self, ctx:TestSuiteParser.IntExprContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#addSubExpr.
    def enterAddSubExpr(self, ctx:TestSuiteParser.AddSubExprContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#addSubExpr.
    def exitAddSubExpr(self, ctx:TestSuiteParser.AddSubExprContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#refExpr.
    def enterRefExpr(self, ctx:TestSuiteParser.RefExprContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#refExpr.
    def exitRefExpr(self, ctx:TestSuiteParser.RefExprContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#numberExpr.
    def enterNumberExpr(self, ctx:TestSuiteParser.NumberExprContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#numberExpr.
    def exitNumberExpr(self, ctx:TestSuiteParser.NumberExprContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#parensExpr.
    def enterParensExpr(self, ctx:TestSuiteParser.ParensExprContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#parensExpr.
    def exitParensExpr(self, ctx:TestSuiteParser.ParensExprContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#mulDivExpr.
    def enterMulDivExpr(self, ctx:TestSuiteParser.MulDivExprContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#mulDivExpr.
    def exitMulDivExpr(self, ctx:TestSuiteParser.MulDivExprContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#funRef.
    def enterFunRef(self, ctx:TestSuiteParser.FunRefContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#funRef.
    def exitFunRef(self, ctx:TestSuiteParser.FunRefContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#varRef.
    def enterVarRef(self, ctx:TestSuiteParser.VarRefContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#varRef.
    def exitVarRef(self, ctx:TestSuiteParser.VarRefContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#argList.
    def enterArgList(self, ctx:TestSuiteParser.ArgListContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#argList.
    def exitArgList(self, ctx:TestSuiteParser.ArgListContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#unitSpec.
    def enterUnitSpec(self, ctx:TestSuiteParser.UnitSpecContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#unitSpec.
    def exitUnitSpec(self, ctx:TestSuiteParser.UnitSpecContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#composedUnit.
    def enterComposedUnit(self, ctx:TestSuiteParser.ComposedUnitContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#composedUnit.
    def exitComposedUnit(self, ctx:TestSuiteParser.ComposedUnitContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#basicUnit.
    def enterBasicUnit(self, ctx:TestSuiteParser.BasicUnitContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#basicUnit.
    def exitBasicUnit(self, ctx:TestSuiteParser.BasicUnitContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#siUnit.
    def enterSiUnit(self, ctx:TestSuiteParser.SiUnitContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#siUnit.
    def exitSiUnit(self, ctx:TestSuiteParser.SiUnitContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#customUnit.
    def enterCustomUnit(self, ctx:TestSuiteParser.CustomUnitContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#customUnit.
    def exitCustomUnit(self, ctx:TestSuiteParser.CustomUnitContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#unitPrefix.
    def enterUnitPrefix(self, ctx:TestSuiteParser.UnitPrefixContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#unitPrefix.
    def exitUnitPrefix(self, ctx:TestSuiteParser.UnitPrefixContext):
        pass


    # Enter a parse tree produced by TestSuiteParser#siType.
    def enterSiType(self, ctx:TestSuiteParser.SiTypeContext):
        pass

    # Exit a parse tree produced by TestSuiteParser#siType.
    def exitSiType(self, ctx:TestSuiteParser.SiTypeContext):
        pass



del TestSuiteParser