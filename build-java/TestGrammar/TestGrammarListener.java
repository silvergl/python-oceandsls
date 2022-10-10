// Generated from TestGrammar.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestGrammarParser}.
 */
public interface TestGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code FooExpr}
	 * labeled alternative in {@link TestGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFooExpr(TestGrammarParser.FooExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FooExpr}
	 * labeled alternative in {@link TestGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFooExpr(TestGrammarParser.FooExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BarExpr}
	 * labeled alternative in {@link TestGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBarExpr(TestGrammarParser.BarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BarExpr}
	 * labeled alternative in {@link TestGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBarExpr(TestGrammarParser.BarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberExpr}
	 * labeled alternative in {@link TestGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(TestGrammarParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberExpr}
	 * labeled alternative in {@link TestGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(TestGrammarParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link TestGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(TestGrammarParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link TestGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(TestGrammarParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InfixExpr}
	 * labeled alternative in {@link TestGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInfixExpr(TestGrammarParser.InfixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InfixExpr}
	 * labeled alternative in {@link TestGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInfixExpr(TestGrammarParser.InfixExprContext ctx);
}