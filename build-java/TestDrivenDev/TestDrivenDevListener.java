// Generated from java-escape by ANTLR 4.11.1
package TestDrivenDev;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestDrivenDevParser}.
 */
public interface TestDrivenDevListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#sut}.
	 * @param ctx the parse tree
	 */
	void enterSut(TestDrivenDevParser.SutContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#sut}.
	 * @param ctx the parse tree
	 */
	void exitSut(TestDrivenDevParser.SutContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(TestDrivenDevParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(TestDrivenDevParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#output}.
	 * @param ctx the parse tree
	 */
	void enterOutput(TestDrivenDevParser.OutputContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#output}.
	 * @param ctx the parse tree
	 */
	void exitOutput(TestDrivenDevParser.OutputContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(TestDrivenDevParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(TestDrivenDevParser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(TestDrivenDevParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(TestDrivenDevParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#assertion}.
	 * @param ctx the parse tree
	 */
	void enterAssertion(TestDrivenDevParser.AssertionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#assertion}.
	 * @param ctx the parse tree
	 */
	void exitAssertion(TestDrivenDevParser.AssertionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#documentation}.
	 * @param ctx the parse tree
	 */
	void enterDocumentation(TestDrivenDevParser.DocumentationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#documentation}.
	 * @param ctx the parse tree
	 */
	void exitDocumentation(TestDrivenDevParser.DocumentationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link TestDrivenDevParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(TestDrivenDevParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link TestDrivenDevParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(TestDrivenDevParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link TestDrivenDevParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(TestDrivenDevParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link TestDrivenDevParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(TestDrivenDevParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link TestDrivenDevParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(TestDrivenDevParser.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link TestDrivenDevParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(TestDrivenDevParser.ParensExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link TestDrivenDevParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(TestDrivenDevParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link TestDrivenDevParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(TestDrivenDevParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#directive}.
	 * @param ctx the parse tree
	 */
	void enterDirective(TestDrivenDevParser.DirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#directive}.
	 * @param ctx the parse tree
	 */
	void exitDirective(TestDrivenDevParser.DirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#paramType}.
	 * @param ctx the parse tree
	 */
	void enterParamType(TestDrivenDevParser.ParamTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#paramType}.
	 * @param ctx the parse tree
	 */
	void exitParamType(TestDrivenDevParser.ParamTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void enterTypeRef(TestDrivenDevParser.TypeRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void exitTypeRef(TestDrivenDevParser.TypeRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#enumType}.
	 * @param ctx the parse tree
	 */
	void enterEnumType(TestDrivenDevParser.EnumTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#enumType}.
	 * @param ctx the parse tree
	 */
	void exitEnumType(TestDrivenDevParser.EnumTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#enum}.
	 * @param ctx the parse tree
	 */
	void enterEnum(TestDrivenDevParser.EnumContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#enum}.
	 * @param ctx the parse tree
	 */
	void exitEnum(TestDrivenDevParser.EnumContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(TestDrivenDevParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(TestDrivenDevParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#dim}.
	 * @param ctx the parse tree
	 */
	void enterDim(TestDrivenDevParser.DimContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#dim}.
	 * @param ctx the parse tree
	 */
	void exitDim(TestDrivenDevParser.DimContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#sizeDim}.
	 * @param ctx the parse tree
	 */
	void enterSizeDim(TestDrivenDevParser.SizeDimContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#sizeDim}.
	 * @param ctx the parse tree
	 */
	void exitSizeDim(TestDrivenDevParser.SizeDimContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#rangeDim}.
	 * @param ctx the parse tree
	 */
	void enterRangeDim(TestDrivenDevParser.RangeDimContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#rangeDim}.
	 * @param ctx the parse tree
	 */
	void exitRangeDim(TestDrivenDevParser.RangeDimContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#unitSpec}.
	 * @param ctx the parse tree
	 */
	void enterUnitSpec(TestDrivenDevParser.UnitSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#unitSpec}.
	 * @param ctx the parse tree
	 */
	void exitUnitSpec(TestDrivenDevParser.UnitSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void enterBasicUnit(TestDrivenDevParser.BasicUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void exitBasicUnit(TestDrivenDevParser.BasicUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#siUnit}.
	 * @param ctx the parse tree
	 */
	void enterSiUnit(TestDrivenDevParser.SiUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#siUnit}.
	 * @param ctx the parse tree
	 */
	void exitSiUnit(TestDrivenDevParser.SiUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#customUnit}.
	 * @param ctx the parse tree
	 */
	void enterCustomUnit(TestDrivenDevParser.CustomUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#customUnit}.
	 * @param ctx the parse tree
	 */
	void exitCustomUnit(TestDrivenDevParser.CustomUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#composedUnit}.
	 * @param ctx the parse tree
	 */
	void enterComposedUnit(TestDrivenDevParser.ComposedUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#composedUnit}.
	 * @param ctx the parse tree
	 */
	void exitComposedUnit(TestDrivenDevParser.ComposedUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterUnitPrefix(TestDrivenDevParser.UnitPrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitUnitPrefix(TestDrivenDevParser.UnitPrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDevParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterSiType(TestDrivenDevParser.SiTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDevParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitSiType(TestDrivenDevParser.SiTypeContext ctx);
}