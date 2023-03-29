// Generated from /home/sgu/IdeaProjects/antlr4-python/grammars/TDD-DSL/Reference.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ReferenceParser}.
 */
public interface ReferenceListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code strExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStrExpr(ReferenceParser.StrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code strExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStrExpr(ReferenceParser.StrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(ReferenceParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(ReferenceParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(ReferenceParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(ReferenceParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code refExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRefExpr(ReferenceParser.RefExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code refExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRefExpr(ReferenceParser.RefExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(ReferenceParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(ReferenceParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(ReferenceParser.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(ReferenceParser.ParensExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(ReferenceParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link ReferenceParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(ReferenceParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funRef}
	 * labeled alternative in {@link ReferenceParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterFunRef(ReferenceParser.FunRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funRef}
	 * labeled alternative in {@link ReferenceParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitFunRef(ReferenceParser.FunRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varRef}
	 * labeled alternative in {@link ReferenceParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(ReferenceParser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varRef}
	 * labeled alternative in {@link ReferenceParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(ReferenceParser.VarRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code argList}
	 * labeled alternative in {@link ReferenceParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(ReferenceParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code argList}
	 * labeled alternative in {@link ReferenceParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(ReferenceParser.ArgListContext ctx);
}