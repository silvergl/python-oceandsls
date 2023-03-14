// Generated from java-escape by ANTLR 4.11.1
package TestDrivenDev_DSL;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestDrivenDev_DSLParser}.
 */
public interface TestDrivenDev_DSLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#sut}.
	 * @param ctx the parse tree
	 */
	void enterSut(TestDrivenDev_DSLParser.SutContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#sut}.
	 * @param ctx the parse tree
	 */
	void exitSut(TestDrivenDev_DSLParser.SutContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(TestDrivenDev_DSLParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(TestDrivenDev_DSLParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#output}.
	 * @param ctx the parse tree
	 */
	void enterOutput(TestDrivenDev_DSLParser.OutputContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#output}.
	 * @param ctx the parse tree
	 */
	void exitOutput(TestDrivenDev_DSLParser.OutputContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(TestDrivenDev_DSLParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(TestDrivenDev_DSLParser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(TestDrivenDev_DSLParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(TestDrivenDev_DSLParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#assertion}.
	 * @param ctx the parse tree
	 */
	void enterAssertion(TestDrivenDev_DSLParser.AssertionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#assertion}.
	 * @param ctx the parse tree
	 */
	void exitAssertion(TestDrivenDev_DSLParser.AssertionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#documentation}.
	 * @param ctx the parse tree
	 */
	void enterDocumentation(TestDrivenDev_DSLParser.DocumentationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#documentation}.
	 * @param ctx the parse tree
	 */
	void exitDocumentation(TestDrivenDev_DSLParser.DocumentationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(TestDrivenDev_DSLParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(TestDrivenDev_DSLParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(TestDrivenDev_DSLParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(TestDrivenDev_DSLParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(TestDrivenDev_DSLParser.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(TestDrivenDev_DSLParser.ParensExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(TestDrivenDev_DSLParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(TestDrivenDev_DSLParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#directive}.
	 * @param ctx the parse tree
	 */
	void enterDirective(TestDrivenDev_DSLParser.DirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#directive}.
	 * @param ctx the parse tree
	 */
	void exitDirective(TestDrivenDev_DSLParser.DirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#paramType}.
	 * @param ctx the parse tree
	 */
	void enterParamType(TestDrivenDev_DSLParser.ParamTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#paramType}.
	 * @param ctx the parse tree
	 */
	void exitParamType(TestDrivenDev_DSLParser.ParamTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void enterTypeRef(TestDrivenDev_DSLParser.TypeRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void exitTypeRef(TestDrivenDev_DSLParser.TypeRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#enumType}.
	 * @param ctx the parse tree
	 */
	void enterEnumType(TestDrivenDev_DSLParser.EnumTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#enumType}.
	 * @param ctx the parse tree
	 */
	void exitEnumType(TestDrivenDev_DSLParser.EnumTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#enum}.
	 * @param ctx the parse tree
	 */
	void enterEnum(TestDrivenDev_DSLParser.EnumContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#enum}.
	 * @param ctx the parse tree
	 */
	void exitEnum(TestDrivenDev_DSLParser.EnumContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(TestDrivenDev_DSLParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(TestDrivenDev_DSLParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#dim}.
	 * @param ctx the parse tree
	 */
	void enterDim(TestDrivenDev_DSLParser.DimContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#dim}.
	 * @param ctx the parse tree
	 */
	void exitDim(TestDrivenDev_DSLParser.DimContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#sizeDim}.
	 * @param ctx the parse tree
	 */
	void enterSizeDim(TestDrivenDev_DSLParser.SizeDimContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#sizeDim}.
	 * @param ctx the parse tree
	 */
	void exitSizeDim(TestDrivenDev_DSLParser.SizeDimContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#rangeDim}.
	 * @param ctx the parse tree
	 */
	void enterRangeDim(TestDrivenDev_DSLParser.RangeDimContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#rangeDim}.
	 * @param ctx the parse tree
	 */
	void exitRangeDim(TestDrivenDev_DSLParser.RangeDimContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#unitSpec}.
	 * @param ctx the parse tree
	 */
	void enterUnitSpec(TestDrivenDev_DSLParser.UnitSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#unitSpec}.
	 * @param ctx the parse tree
	 */
	void exitUnitSpec(TestDrivenDev_DSLParser.UnitSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void enterBasicUnit(TestDrivenDev_DSLParser.BasicUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void exitBasicUnit(TestDrivenDev_DSLParser.BasicUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#siUnit}.
	 * @param ctx the parse tree
	 */
	void enterSiUnit(TestDrivenDev_DSLParser.SiUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#siUnit}.
	 * @param ctx the parse tree
	 */
	void exitSiUnit(TestDrivenDev_DSLParser.SiUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#customUnit}.
	 * @param ctx the parse tree
	 */
	void enterCustomUnit(TestDrivenDev_DSLParser.CustomUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#customUnit}.
	 * @param ctx the parse tree
	 */
	void exitCustomUnit(TestDrivenDev_DSLParser.CustomUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#composedUnit}.
	 * @param ctx the parse tree
	 */
	void enterComposedUnit(TestDrivenDev_DSLParser.ComposedUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#composedUnit}.
	 * @param ctx the parse tree
	 */
	void exitComposedUnit(TestDrivenDev_DSLParser.ComposedUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterUnitPrefix(TestDrivenDev_DSLParser.UnitPrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitUnitPrefix(TestDrivenDev_DSLParser.UnitPrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterSiType(TestDrivenDev_DSLParser.SiTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitSiType(TestDrivenDev_DSLParser.SiTypeContext ctx);
}