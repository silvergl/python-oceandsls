// Generated from java-escape by ANTLR 4.11.1
package TestDrivenDev_DSL;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TestDrivenDev_DSLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TestDrivenDev_DSLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#sut}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSut(TestDrivenDev_DSLParser.SutContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(TestDrivenDev_DSLParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput(TestDrivenDev_DSLParser.OutputContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScope(TestDrivenDev_DSLParser.ScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(TestDrivenDev_DSLParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#assertion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertion(TestDrivenDev_DSLParser.AssertionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#documentation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocumentation(TestDrivenDev_DSLParser.DocumentationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(TestDrivenDev_DSLParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpr(TestDrivenDev_DSLParser.NumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExpr(TestDrivenDev_DSLParser.ParensExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpr(TestDrivenDev_DSLParser.MulDivExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirective(TestDrivenDev_DSLParser.DirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#paramType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamType(TestDrivenDev_DSLParser.ParamTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#typeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRef(TestDrivenDev_DSLParser.TypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#enumType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumType(TestDrivenDev_DSLParser.EnumTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#enum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnum(TestDrivenDev_DSLParser.EnumContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(TestDrivenDev_DSLParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#dim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDim(TestDrivenDev_DSLParser.DimContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#sizeDim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeDim(TestDrivenDev_DSLParser.SizeDimContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#rangeDim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeDim(TestDrivenDev_DSLParser.RangeDimContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#unitSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitSpec(TestDrivenDev_DSLParser.UnitSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#basicUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicUnit(TestDrivenDev_DSLParser.BasicUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#siUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiUnit(TestDrivenDev_DSLParser.SiUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#customUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomUnit(TestDrivenDev_DSLParser.CustomUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#composedUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposedUnit(TestDrivenDev_DSLParser.ComposedUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitPrefix(TestDrivenDev_DSLParser.UnitPrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDev_DSLParser#siType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiType(TestDrivenDev_DSLParser.SiTypeContext ctx);
}