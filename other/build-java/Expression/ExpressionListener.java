// Generated from Expression.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionParser}.
 */
public interface ExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpression(ExpressionParser.ArithmeticExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpression(ExpressionParser.ArithmeticExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#eAdditionOperator}.
	 * @param ctx the parse tree
	 */
	void enterEAdditionOperator(ExpressionParser.EAdditionOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#eAdditionOperator}.
	 * @param ctx the parse tree
	 */
	void exitEAdditionOperator(ExpressionParser.EAdditionOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpression(ExpressionParser.MultiplicationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpression(ExpressionParser.MultiplicationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#eMultiplicationOperator}.
	 * @param ctx the parse tree
	 */
	void enterEMultiplicationOperator(ExpressionParser.EMultiplicationOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#eMultiplicationOperator}.
	 * @param ctx the parse tree
	 */
	void exitEMultiplicationOperator(ExpressionParser.EMultiplicationOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpression(ExpressionParser.ValueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpression(ExpressionParser.ValueExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(ExpressionParser.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(ExpressionParser.LiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ExpressionParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ExpressionParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#parenthesisExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisExpression(ExpressionParser.ParenthesisExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#parenthesisExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisExpression(ExpressionParser.ParenthesisExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#arrayExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpression(ExpressionParser.ArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#arrayExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpression(ExpressionParser.ArrayExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#namedElementReference}.
	 * @param ctx the parse tree
	 */
	void enterNamedElementReference(ExpressionParser.NamedElementReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#namedElementReference}.
	 * @param ctx the parse tree
	 */
	void exitNamedElementReference(ExpressionParser.NamedElementReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#stringValue}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(ExpressionParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#stringValue}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(ExpressionParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#longValue}.
	 * @param ctx the parse tree
	 */
	void enterLongValue(ExpressionParser.LongValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#longValue}.
	 * @param ctx the parse tree
	 */
	void exitLongValue(ExpressionParser.LongValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#doubleValue}.
	 * @param ctx the parse tree
	 */
	void enterDoubleValue(ExpressionParser.DoubleValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#doubleValue}.
	 * @param ctx the parse tree
	 */
	void exitDoubleValue(ExpressionParser.DoubleValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void enterBooleanValue(ExpressionParser.BooleanValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void exitBooleanValue(ExpressionParser.BooleanValueContext ctx);
}