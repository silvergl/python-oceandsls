// Generated from TestExprCore.g4 by ANTLR 4.12.0
package TestExprCore;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestExprCoreParser}.
 */
public interface TestExprCoreListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TestExprCoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(TestExprCoreParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestExprCoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(TestExprCoreParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestExprCoreParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(TestExprCoreParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestExprCoreParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(TestExprCoreParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestExprCoreParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpression(TestExprCoreParser.SimpleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestExprCoreParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpression(TestExprCoreParser.SimpleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestExprCoreParser#variableRef}.
	 * @param ctx the parse tree
	 */
	void enterVariableRef(TestExprCoreParser.VariableRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestExprCoreParser#variableRef}.
	 * @param ctx the parse tree
	 */
	void exitVariableRef(TestExprCoreParser.VariableRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestExprCoreParser#functionRef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionRef(TestExprCoreParser.FunctionRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestExprCoreParser#functionRef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionRef(TestExprCoreParser.FunctionRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestExprCoreParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(TestExprCoreParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestExprCoreParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(TestExprCoreParser.IdentifierContext ctx);
}