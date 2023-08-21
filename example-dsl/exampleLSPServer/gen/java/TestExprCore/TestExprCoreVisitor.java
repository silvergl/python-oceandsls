// Generated from TestExprCore.g4 by ANTLR 4.13.0
package TestExprCore;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TestExprCoreParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TestExprCoreVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TestExprCoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(TestExprCoreParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestExprCoreParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(TestExprCoreParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestExprCoreParser#simpleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpression(TestExprCoreParser.SimpleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestExprCoreParser#variableRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableRef(TestExprCoreParser.VariableRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestExprCoreParser#functionRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionRef(TestExprCoreParser.FunctionRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestExprCoreParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(TestExprCoreParser.IdentifierContext ctx);
}