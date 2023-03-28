// Generated from TestSuite.g4 by ANTLR 4.12.0
package TestSuite;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestSuiteParser}.
 */
public interface TestSuiteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_suite}.
	 * @param ctx the parse tree
	 */
	void enterTest_suite(TestSuiteParser.Test_suiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_suite}.
	 * @param ctx the parse tree
	 */
	void exitTest_suite(TestSuiteParser.Test_suiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_case}.
	 * @param ctx the parse tree
	 */
	void enterTest_case(TestSuiteParser.Test_caseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_case}.
	 * @param ctx the parse tree
	 */
	void exitTest_case(TestSuiteParser.Test_caseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_assertion}.
	 * @param ctx the parse tree
	 */
	void enterTest_assertion(TestSuiteParser.Test_assertionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_assertion}.
	 * @param ctx the parse tree
	 */
	void exitTest_assertion(TestSuiteParser.Test_assertionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_input}.
	 * @param ctx the parse tree
	 */
	void enterTest_input(TestSuiteParser.Test_inputContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_input}.
	 * @param ctx the parse tree
	 */
	void exitTest_input(TestSuiteParser.Test_inputContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_output}.
	 * @param ctx the parse tree
	 */
	void enterTest_output(TestSuiteParser.Test_outputContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_output}.
	 * @param ctx the parse tree
	 */
	void exitTest_output(TestSuiteParser.Test_outputContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(TestSuiteParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(TestSuiteParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyDesc}
	 * labeled alternative in {@link TestSuiteParser#optionalParDesc}.
	 * @param ctx the parse tree
	 */
	void enterEmptyDesc(TestSuiteParser.EmptyDescContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyDesc}
	 * labeled alternative in {@link TestSuiteParser#optionalParDesc}.
	 * @param ctx the parse tree
	 */
	void exitEmptyDesc(TestSuiteParser.EmptyDescContext ctx);
	/**
	 * Enter a parse tree produced by the {@code specDesc}
	 * labeled alternative in {@link TestSuiteParser#optionalParDesc}.
	 * @param ctx the parse tree
	 */
	void enterSpecDesc(TestSuiteParser.SpecDescContext ctx);
	/**
	 * Exit a parse tree produced by the {@code specDesc}
	 * labeled alternative in {@link TestSuiteParser#optionalParDesc}.
	 * @param ctx the parse tree
	 */
	void exitSpecDesc(TestSuiteParser.SpecDescContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyComment}
	 * labeled alternative in {@link TestSuiteParser#optionalComment}.
	 * @param ctx the parse tree
	 */
	void enterEmptyComment(TestSuiteParser.EmptyCommentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyComment}
	 * labeled alternative in {@link TestSuiteParser#optionalComment}.
	 * @param ctx the parse tree
	 */
	void exitEmptyComment(TestSuiteParser.EmptyCommentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code specComment}
	 * labeled alternative in {@link TestSuiteParser#optionalComment}.
	 * @param ctx the parse tree
	 */
	void enterSpecComment(TestSuiteParser.SpecCommentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code specComment}
	 * labeled alternative in {@link TestSuiteParser#optionalComment}.
	 * @param ctx the parse tree
	 */
	void exitSpecComment(TestSuiteParser.SpecCommentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nameDecl}
	 * labeled alternative in {@link TestSuiteParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNameDecl(TestSuiteParser.NameDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nameDecl}
	 * labeled alternative in {@link TestSuiteParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNameDecl(TestSuiteParser.NameDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeDecl}
	 * labeled alternative in {@link TestSuiteParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDecl(TestSuiteParser.TypeDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeDecl}
	 * labeled alternative in {@link TestSuiteParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDecl(TestSuiteParser.TypeDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code combinedDecl}
	 * labeled alternative in {@link TestSuiteParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCombinedDecl(TestSuiteParser.CombinedDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code combinedDecl}
	 * labeled alternative in {@link TestSuiteParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCombinedDecl(TestSuiteParser.CombinedDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code strExpr}
	 * labeled alternative in {@link TestSuiteParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterStrExpr(TestSuiteParser.StrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code strExpr}
	 * labeled alternative in {@link TestSuiteParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitStrExpr(TestSuiteParser.StrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link TestSuiteParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(TestSuiteParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link TestSuiteParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(TestSuiteParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link TestSuiteParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(TestSuiteParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link TestSuiteParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(TestSuiteParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link TestSuiteParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(TestSuiteParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link TestSuiteParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(TestSuiteParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link TestSuiteParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(TestSuiteParser.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link TestSuiteParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(TestSuiteParser.ParensExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link TestSuiteParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(TestSuiteParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link TestSuiteParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(TestSuiteParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#directive}.
	 * @param ctx the parse tree
	 */
	void enterDirective(TestSuiteParser.DirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#directive}.
	 * @param ctx the parse tree
	 */
	void exitDirective(TestSuiteParser.DirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#paramType}.
	 * @param ctx the parse tree
	 */
	void enterParamType(TestSuiteParser.ParamTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#paramType}.
	 * @param ctx the parse tree
	 */
	void exitParamType(TestSuiteParser.ParamTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void enterTypeRef(TestSuiteParser.TypeRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void exitTypeRef(TestSuiteParser.TypeRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#enumType}.
	 * @param ctx the parse tree
	 */
	void enterEnumType(TestSuiteParser.EnumTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#enumType}.
	 * @param ctx the parse tree
	 */
	void exitEnumType(TestSuiteParser.EnumTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#enum}.
	 * @param ctx the parse tree
	 */
	void enterEnum(TestSuiteParser.EnumContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#enum}.
	 * @param ctx the parse tree
	 */
	void exitEnum(TestSuiteParser.EnumContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(TestSuiteParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(TestSuiteParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#dim}.
	 * @param ctx the parse tree
	 */
	void enterDim(TestSuiteParser.DimContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#dim}.
	 * @param ctx the parse tree
	 */
	void exitDim(TestSuiteParser.DimContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#sizeDim}.
	 * @param ctx the parse tree
	 */
	void enterSizeDim(TestSuiteParser.SizeDimContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#sizeDim}.
	 * @param ctx the parse tree
	 */
	void exitSizeDim(TestSuiteParser.SizeDimContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#rangeDim}.
	 * @param ctx the parse tree
	 */
	void enterRangeDim(TestSuiteParser.RangeDimContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#rangeDim}.
	 * @param ctx the parse tree
	 */
	void exitRangeDim(TestSuiteParser.RangeDimContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#unitSpec}.
	 * @param ctx the parse tree
	 */
	void enterUnitSpec(TestSuiteParser.UnitSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#unitSpec}.
	 * @param ctx the parse tree
	 */
	void exitUnitSpec(TestSuiteParser.UnitSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#composedUnit}.
	 * @param ctx the parse tree
	 */
	void enterComposedUnit(TestSuiteParser.ComposedUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#composedUnit}.
	 * @param ctx the parse tree
	 */
	void exitComposedUnit(TestSuiteParser.ComposedUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void enterBasicUnit(TestSuiteParser.BasicUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void exitBasicUnit(TestSuiteParser.BasicUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#siUnit}.
	 * @param ctx the parse tree
	 */
	void enterSiUnit(TestSuiteParser.SiUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#siUnit}.
	 * @param ctx the parse tree
	 */
	void exitSiUnit(TestSuiteParser.SiUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#customUnit}.
	 * @param ctx the parse tree
	 */
	void enterCustomUnit(TestSuiteParser.CustomUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#customUnit}.
	 * @param ctx the parse tree
	 */
	void exitCustomUnit(TestSuiteParser.CustomUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterUnitPrefix(TestSuiteParser.UnitPrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitUnitPrefix(TestSuiteParser.UnitPrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterSiType(TestSuiteParser.SiTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitSiType(TestSuiteParser.SiTypeContext ctx);
}