// Generated from Declaration.g4 by ANTLR 4.12.0
package Declaration;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DeclarationParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DeclarationVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#declarationModel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationModel(DeclarationParser.DeclarationModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#namedElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedElement(DeclarationParser.NamedElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#parameterGroupDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterGroupDeclaration(DeclarationParser.ParameterGroupDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(DeclarationParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#featureDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatureDeclaration(DeclarationParser.FeatureDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#featureGroupDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatureGroupDeclaration(DeclarationParser.FeatureGroupDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#eKind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEKind(DeclarationParser.EKindContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#paramType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamType(DeclarationParser.ParamTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#inlineEnumerationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineEnumerationType(DeclarationParser.InlineEnumerationTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#typeReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeReference(DeclarationParser.TypeReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(DeclarationParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#dimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimension(DeclarationParser.DimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#sizeDimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeDimension(DeclarationParser.SizeDimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#rangeDimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeDimension(DeclarationParser.RangeDimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#declaredType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaredType(DeclarationParser.DeclaredTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#rangeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeType(DeclarationParser.RangeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#enumerationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerationType(DeclarationParser.EnumerationTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#enumeral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumeral(DeclarationParser.EnumeralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#unitSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitSpecification(DeclarationParser.UnitSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#basicUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicUnit(DeclarationParser.BasicUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#sIUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSIUnit(DeclarationParser.SIUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#customUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomUnit(DeclarationParser.CustomUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#composedUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposedUnit(DeclarationParser.ComposedUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#ePrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEPrefix(DeclarationParser.EPrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#eSIUnitType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitESIUnitType(DeclarationParser.ESIUnitTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpression(DeclarationParser.ArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#eAdditionOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEAdditionOperator(DeclarationParser.EAdditionOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpression(DeclarationParser.MultiplicationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#eMultiplicationOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEMultiplicationOperator(DeclarationParser.EMultiplicationOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#valueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpression(DeclarationParser.ValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#literalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(DeclarationParser.LiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(DeclarationParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#parenthesisExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisExpression(DeclarationParser.ParenthesisExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#arrayExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpression(DeclarationParser.ArrayExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#namedElementReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedElementReference(DeclarationParser.NamedElementReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#stringValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(DeclarationParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#longValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLongValue(DeclarationParser.LongValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#doubleValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleValue(DeclarationParser.DoubleValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclarationParser#booleanValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanValue(DeclarationParser.BooleanValueContext ctx);
}