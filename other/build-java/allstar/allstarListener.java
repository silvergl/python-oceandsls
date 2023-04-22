// Generated from java-escape by ANTLR 4.11.1
package allstar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link allstarParser}.
 */
public interface allstarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link allstarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(allstarParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link allstarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(allstarParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link allstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(allstarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link allstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(allstarParser.ExprContext ctx);
}