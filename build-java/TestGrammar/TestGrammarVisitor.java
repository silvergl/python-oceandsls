// Generated from TestGrammar.g4 by ANTLR 4.12.0
package TestGrammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TestGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TestGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code startProg}
	 * labeled alternative in {@link TestGrammarParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartProg(TestGrammarParser.StartProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printExprStat}
	 * labeled alternative in {@link TestGrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExprStat(TestGrammarParser.PrintExprStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link TestGrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStat(TestGrammarParser.AssignStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blankStat}
	 * labeled alternative in {@link TestGrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlankStat(TestGrammarParser.BlankStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link TestGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(TestGrammarParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funRef}
	 * labeled alternative in {@link TestGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunRef(TestGrammarParser.FunRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link TestGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpr(TestGrammarParser.NumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link TestGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExpr(TestGrammarParser.ParensExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link TestGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpr(TestGrammarParser.MulDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idRef}
	 * labeled alternative in {@link TestGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdRef(TestGrammarParser.IdRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code argList}
	 * labeled alternative in {@link TestGrammarParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(TestGrammarParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link TestGrammarParser#variableRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(TestGrammarParser.VarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link TestGrammarParser#functionRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExpr(TestGrammarParser.FuncExprContext ctx);
}