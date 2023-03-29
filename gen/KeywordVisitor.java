// Generated from /home/sgu/IdeaProjects/antlr4-python/grammars/TDD-DSL/Keyword.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link KeywordParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface KeywordVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code arraySpec}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySpec(KeywordParser.ArraySpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code argSpecInput}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgSpecInput(KeywordParser.ArgSpecInputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code argSpecInOutput}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgSpecInOutput(KeywordParser.ArgSpecInOutputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code argSpecOutput}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgSpecOutput(KeywordParser.ArgSpecOutputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constantSpec}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantSpec(KeywordParser.ConstantSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code custom}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustom(KeywordParser.CustomContext ctx);
	/**
	 * Visit a parse tree produced by {@link KeywordParser#directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirective(KeywordParser.DirectiveContext ctx);
}