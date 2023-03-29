// Generated from /home/sgu/IdeaProjects/antlr4-python/grammars/TDD-DSL/Keyword.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KeywordParser}.
 */
public interface KeywordListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code arraySpec}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void enterArraySpec(KeywordParser.ArraySpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arraySpec}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void exitArraySpec(KeywordParser.ArraySpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code argSpecInput}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void enterArgSpecInput(KeywordParser.ArgSpecInputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code argSpecInput}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void exitArgSpecInput(KeywordParser.ArgSpecInputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code argSpecInOutput}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void enterArgSpecInOutput(KeywordParser.ArgSpecInOutputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code argSpecInOutput}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void exitArgSpecInOutput(KeywordParser.ArgSpecInOutputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code argSpecOutput}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void enterArgSpecOutput(KeywordParser.ArgSpecOutputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code argSpecOutput}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void exitArgSpecOutput(KeywordParser.ArgSpecOutputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantSpec}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void enterConstantSpec(KeywordParser.ConstantSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantSpec}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void exitConstantSpec(KeywordParser.ConstantSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code custom}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void enterCustom(KeywordParser.CustomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code custom}
	 * labeled alternative in {@link KeywordParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void exitCustom(KeywordParser.CustomContext ctx);
	/**
	 * Enter a parse tree produced by {@link KeywordParser#directive}.
	 * @param ctx the parse tree
	 */
	void enterDirective(KeywordParser.DirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeywordParser#directive}.
	 * @param ctx the parse tree
	 */
	void exitDirective(KeywordParser.DirectiveContext ctx);
}