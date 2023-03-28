// Generated from TestDrivenDev_DSL.g4 by ANTLR 4.12.0
package TestDrivenDev_DSL;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestDrivenDev_DSLParser}.
 */
public interface TestDrivenDev_DSLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#test_suite}.
	 * @param ctx the parse tree
	 */
	void enterTest_suite(TestDrivenDev_DSLParser.Test_suiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#test_suite}.
	 * @param ctx the parse tree
	 */
	void exitTest_suite(TestDrivenDev_DSLParser.Test_suiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#test_case}.
	 * @param ctx the parse tree
	 */
	void enterTest_case(TestDrivenDev_DSLParser.Test_caseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#test_case}.
	 * @param ctx the parse tree
	 */
	void exitTest_case(TestDrivenDev_DSLParser.Test_caseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#test_assertion}.
	 * @param ctx the parse tree
	 */
	void enterTest_assertion(TestDrivenDev_DSLParser.Test_assertionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#test_assertion}.
	 * @param ctx the parse tree
	 */
	void exitTest_assertion(TestDrivenDev_DSLParser.Test_assertionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#test_input}.
	 * @param ctx the parse tree
	 */
	void enterTest_input(TestDrivenDev_DSLParser.Test_inputContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#test_input}.
	 * @param ctx the parse tree
	 */
	void exitTest_input(TestDrivenDev_DSLParser.Test_inputContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#test_output}.
	 * @param ctx the parse tree
	 */
	void enterTest_output(TestDrivenDev_DSLParser.Test_outputContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#test_output}.
	 * @param ctx the parse tree
	 */
	void exitTest_output(TestDrivenDev_DSLParser.Test_outputContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(TestDrivenDev_DSLParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(TestDrivenDev_DSLParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code strExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStrExpr(TestDrivenDev_DSLParser.StrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code strExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStrExpr(TestDrivenDev_DSLParser.StrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(TestDrivenDev_DSLParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(TestDrivenDev_DSLParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(TestDrivenDev_DSLParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(TestDrivenDev_DSLParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(TestDrivenDev_DSLParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(TestDrivenDev_DSLParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(TestDrivenDev_DSLParser.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(TestDrivenDev_DSLParser.ParensExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(TestDrivenDev_DSLParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link TestDrivenDev_DSLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(TestDrivenDev_DSLParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestDrivenDev_DSLParser#directive}.
	 * @param ctx the parse tree
	 */
	void enterDirective(TestDrivenDev_DSLParser.DirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestDrivenDev_DSLParser#directive}.
	 * @param ctx the parse tree
	 */
	void exitDirective(TestDrivenDev_DSLParser.DirectiveContext ctx);
}