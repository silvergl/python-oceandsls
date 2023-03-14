// Generated from java-escape by ANTLR 4.11.1
package TestDrivenDev;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TestDrivenDevParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TestDrivenDevVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#sut}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSut(TestDrivenDevParser.SutContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(TestDrivenDevParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput(TestDrivenDevParser.OutputContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScope(TestDrivenDevParser.ScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(TestDrivenDevParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#assertion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertion(TestDrivenDevParser.AssertionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#documentation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocumentation(TestDrivenDevParser.DocumentationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link TestDrivenDevParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(TestDrivenDevParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link TestDrivenDevParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpr(TestDrivenDevParser.NumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link TestDrivenDevParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExpr(TestDrivenDevParser.ParensExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link TestDrivenDevParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpr(TestDrivenDevParser.MulDivExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirective(TestDrivenDevParser.DirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#paramType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamType(TestDrivenDevParser.ParamTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#typeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRef(TestDrivenDevParser.TypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#enumType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumType(TestDrivenDevParser.EnumTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#enum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnum(TestDrivenDevParser.EnumContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(TestDrivenDevParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#dim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDim(TestDrivenDevParser.DimContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#sizeDim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeDim(TestDrivenDevParser.SizeDimContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#rangeDim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeDim(TestDrivenDevParser.RangeDimContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#unitSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitSpec(TestDrivenDevParser.UnitSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#basicUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicUnit(TestDrivenDevParser.BasicUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#siUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiUnit(TestDrivenDevParser.SiUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#customUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomUnit(TestDrivenDevParser.CustomUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#composedUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposedUnit(TestDrivenDevParser.ComposedUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitPrefix(TestDrivenDevParser.UnitPrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestDrivenDevParser#siType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiType(TestDrivenDevParser.SiTypeContext ctx);
}