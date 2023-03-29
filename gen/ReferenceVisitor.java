// Generated from /home/sgu/IdeaProjects/antlr4-python/grammars/TDD-DSL/Reference.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ReferenceParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ReferenceVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code strExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrExpr(ReferenceParser.StrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(ReferenceParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(ReferenceParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code refExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefExpr(ReferenceParser.RefExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpr(ReferenceParser.NumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExpr(ReferenceParser.ParensExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpr(ReferenceParser.MulDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funRef}
	 * labeled alternative in {@link ReferenceParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunRef(ReferenceParser.FunRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varRef}
	 * labeled alternative in {@link ReferenceParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarRef(ReferenceParser.VarRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code argList}
	 * labeled alternative in {@link ReferenceParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(ReferenceParser.ArgListContext ctx);
}