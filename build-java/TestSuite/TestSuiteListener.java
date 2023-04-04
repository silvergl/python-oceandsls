// Generated from TestSuite.g4 by ANTLR 4.12.0
package TestSuite;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestSuiteParser}.
 */
public interface TestSuiteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_suite}.
	 * @param ctx the parse tree
	 */
	void enterTest_suite(TestSuiteParser.Test_suiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_suite}.
	 * @param ctx the parse tree
	 */
	void exitTest_suite(TestSuiteParser.Test_suiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_case}.
	 * @param ctx the parse tree
	 */
	void enterTest_case(TestSuiteParser.Test_caseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_case}.
	 * @param ctx the parse tree
	 */
	void exitTest_case(TestSuiteParser.Test_caseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_vars}.
	 * @param ctx the parse tree
	 */
	void enterTest_vars(TestSuiteParser.Test_varsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_vars}.
	 * @param ctx the parse tree
	 */
	void exitTest_vars(TestSuiteParser.Test_varsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_var}.
	 * @param ctx the parse tree
	 */
	void enterTest_var(TestSuiteParser.Test_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_var}.
	 * @param ctx the parse tree
	 */
	void exitTest_var(TestSuiteParser.Test_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(TestSuiteParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(TestSuiteParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_scope}.
	 * @param ctx the parse tree
	 */
	void enterTest_scope(TestSuiteParser.Test_scopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_scope}.
	 * @param ctx the parse tree
	 */
	void exitTest_scope(TestSuiteParser.Test_scopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_files}.
	 * @param ctx the parse tree
	 */
	void enterTest_files(TestSuiteParser.Test_filesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_files}.
	 * @param ctx the parse tree
	 */
	void exitTest_files(TestSuiteParser.Test_filesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_modules}.
	 * @param ctx the parse tree
	 */
	void enterTest_modules(TestSuiteParser.Test_modulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_modules}.
	 * @param ctx the parse tree
	 */
	void exitTest_modules(TestSuiteParser.Test_modulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_module}.
	 * @param ctx the parse tree
	 */
	void enterTest_module(TestSuiteParser.Test_moduleContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_module}.
	 * @param ctx the parse tree
	 */
	void exitTest_module(TestSuiteParser.Test_moduleContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_assertion}.
	 * @param ctx the parse tree
	 */
	void enterTest_assertion(TestSuiteParser.Test_assertionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_assertion}.
	 * @param ctx the parse tree
	 */
	void exitTest_assertion(TestSuiteParser.Test_assertionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#pubAttributes}.
	 * @param ctx the parse tree
	 */
	void enterPubAttributes(TestSuiteParser.PubAttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#pubAttributes}.
	 * @param ctx the parse tree
	 */
	void exitPubAttributes(TestSuiteParser.PubAttributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_input}.
	 * @param ctx the parse tree
	 */
	void enterTest_input(TestSuiteParser.Test_inputContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_input}.
	 * @param ctx the parse tree
	 */
	void exitTest_input(TestSuiteParser.Test_inputContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_output}.
	 * @param ctx the parse tree
	 */
	void enterTest_output(TestSuiteParser.Test_outputContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_output}.
	 * @param ctx the parse tree
	 */
	void exitTest_output(TestSuiteParser.Test_outputContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_parameter}.
	 * @param ctx the parse tree
	 */
	void enterTest_parameter(TestSuiteParser.Test_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_parameter}.
	 * @param ctx the parse tree
	 */
	void exitTest_parameter(TestSuiteParser.Test_parameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyDesc}
	 * labeled alternative in {@link TestSuiteParser#optionalDesc}.
	 * @param ctx the parse tree
	 */
	void enterEmptyDesc(TestSuiteParser.EmptyDescContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyDesc}
	 * labeled alternative in {@link TestSuiteParser#optionalDesc}.
	 * @param ctx the parse tree
	 */
	void exitEmptyDesc(TestSuiteParser.EmptyDescContext ctx);
	/**
	 * Enter a parse tree produced by the {@code specDesc}
	 * labeled alternative in {@link TestSuiteParser#optionalDesc}.
	 * @param ctx the parse tree
	 */
	void enterSpecDesc(TestSuiteParser.SpecDescContext ctx);
	/**
	 * Exit a parse tree produced by the {@code specDesc}
	 * labeled alternative in {@link TestSuiteParser#optionalDesc}.
	 * @param ctx the parse tree
	 */
	void exitSpecDesc(TestSuiteParser.SpecDescContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyComment}
	 * labeled alternative in {@link TestSuiteParser#optionalComment}.
	 * @param ctx the parse tree
	 */
	void enterEmptyComment(TestSuiteParser.EmptyCommentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyComment}
	 * labeled alternative in {@link TestSuiteParser#optionalComment}.
	 * @param ctx the parse tree
	 */
	void exitEmptyComment(TestSuiteParser.EmptyCommentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code specComment}
	 * labeled alternative in {@link TestSuiteParser#optionalComment}.
	 * @param ctx the parse tree
	 */
	void enterSpecComment(TestSuiteParser.SpecCommentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code specComment}
	 * labeled alternative in {@link TestSuiteParser#optionalComment}.
	 * @param ctx the parse tree
	 */
	void exitSpecComment(TestSuiteParser.SpecCommentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nameDecl}
	 * labeled alternative in {@link TestSuiteParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNameDecl(TestSuiteParser.NameDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nameDecl}
	 * labeled alternative in {@link TestSuiteParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNameDecl(TestSuiteParser.NameDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeDecl}
	 * labeled alternative in {@link TestSuiteParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDecl(TestSuiteParser.TypeDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeDecl}
	 * labeled alternative in {@link TestSuiteParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDecl(TestSuiteParser.TypeDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code combinedDecl}
	 * labeled alternative in {@link TestSuiteParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCombinedDecl(TestSuiteParser.CombinedDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code combinedDecl}
	 * labeled alternative in {@link TestSuiteParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCombinedDecl(TestSuiteParser.CombinedDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arraySpec}
	 * labeled alternative in {@link TestSuiteParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void enterArraySpec(TestSuiteParser.ArraySpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arraySpec}
	 * labeled alternative in {@link TestSuiteParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void exitArraySpec(TestSuiteParser.ArraySpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code argSpecInput}
	 * labeled alternative in {@link TestSuiteParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void enterArgSpecInput(TestSuiteParser.ArgSpecInputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code argSpecInput}
	 * labeled alternative in {@link TestSuiteParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void exitArgSpecInput(TestSuiteParser.ArgSpecInputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code argSpecInOutput}
	 * labeled alternative in {@link TestSuiteParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void enterArgSpecInOutput(TestSuiteParser.ArgSpecInOutputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code argSpecInOutput}
	 * labeled alternative in {@link TestSuiteParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void exitArgSpecInOutput(TestSuiteParser.ArgSpecInOutputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code argSpecOutput}
	 * labeled alternative in {@link TestSuiteParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void enterArgSpecOutput(TestSuiteParser.ArgSpecOutputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code argSpecOutput}
	 * labeled alternative in {@link TestSuiteParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void exitArgSpecOutput(TestSuiteParser.ArgSpecOutputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantSpec}
	 * labeled alternative in {@link TestSuiteParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void enterConstantSpec(TestSuiteParser.ConstantSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantSpec}
	 * labeled alternative in {@link TestSuiteParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void exitConstantSpec(TestSuiteParser.ConstantSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code customKey}
	 * labeled alternative in {@link TestSuiteParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void enterCustomKey(TestSuiteParser.CustomKeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code customKey}
	 * labeled alternative in {@link TestSuiteParser#f90StdKey}.
	 * @param ctx the parse tree
	 */
	void exitCustomKey(TestSuiteParser.CustomKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#test_directive}.
	 * @param ctx the parse tree
	 */
	void enterTest_directive(TestSuiteParser.Test_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#test_directive}.
	 * @param ctx the parse tree
	 */
	void exitTest_directive(TestSuiteParser.Test_directiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ref}
	 * labeled alternative in {@link TestSuiteParser#paramType}.
	 * @param ctx the parse tree
	 */
	void enterRef(TestSuiteParser.RefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ref}
	 * labeled alternative in {@link TestSuiteParser#paramType}.
	 * @param ctx the parse tree
	 */
	void exitRef(TestSuiteParser.RefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code enm}
	 * labeled alternative in {@link TestSuiteParser#paramType}.
	 * @param ctx the parse tree
	 */
	void enterEnm(TestSuiteParser.EnmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code enm}
	 * labeled alternative in {@link TestSuiteParser#paramType}.
	 * @param ctx the parse tree
	 */
	void exitEnm(TestSuiteParser.EnmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code array}
	 * labeled alternative in {@link TestSuiteParser#paramType}.
	 * @param ctx the parse tree
	 */
	void enterArray(TestSuiteParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code array}
	 * labeled alternative in {@link TestSuiteParser#paramType}.
	 * @param ctx the parse tree
	 */
	void exitArray(TestSuiteParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void enterTypeRef(TestSuiteParser.TypeRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void exitTypeRef(TestSuiteParser.TypeRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#enumType}.
	 * @param ctx the parse tree
	 */
	void enterEnumType(TestSuiteParser.EnumTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#enumType}.
	 * @param ctx the parse tree
	 */
	void exitEnumType(TestSuiteParser.EnumTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#enum}.
	 * @param ctx the parse tree
	 */
	void enterEnum(TestSuiteParser.EnumContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#enum}.
	 * @param ctx the parse tree
	 */
	void exitEnum(TestSuiteParser.EnumContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(TestSuiteParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(TestSuiteParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code size}
	 * labeled alternative in {@link TestSuiteParser#dim}.
	 * @param ctx the parse tree
	 */
	void enterSize(TestSuiteParser.SizeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code size}
	 * labeled alternative in {@link TestSuiteParser#dim}.
	 * @param ctx the parse tree
	 */
	void exitSize(TestSuiteParser.SizeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code range}
	 * labeled alternative in {@link TestSuiteParser#dim}.
	 * @param ctx the parse tree
	 */
	void enterRange(TestSuiteParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code range}
	 * labeled alternative in {@link TestSuiteParser#dim}.
	 * @param ctx the parse tree
	 */
	void exitRange(TestSuiteParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#sizeDim}.
	 * @param ctx the parse tree
	 */
	void enterSizeDim(TestSuiteParser.SizeDimContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#sizeDim}.
	 * @param ctx the parse tree
	 */
	void exitSizeDim(TestSuiteParser.SizeDimContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#rangeDim}.
	 * @param ctx the parse tree
	 */
	void enterRangeDim(TestSuiteParser.RangeDimContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#rangeDim}.
	 * @param ctx the parse tree
	 */
	void exitRangeDim(TestSuiteParser.RangeDimContext ctx);
	/**
	 * Enter a parse tree produced by the {@code strExpr}
	 * labeled alternative in {@link TestSuiteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStrExpr(TestSuiteParser.StrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code strExpr}
	 * labeled alternative in {@link TestSuiteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStrExpr(TestSuiteParser.StrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link TestSuiteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(TestSuiteParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link TestSuiteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(TestSuiteParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link TestSuiteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(TestSuiteParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link TestSuiteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(TestSuiteParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code refExpr}
	 * labeled alternative in {@link TestSuiteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRefExpr(TestSuiteParser.RefExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code refExpr}
	 * labeled alternative in {@link TestSuiteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRefExpr(TestSuiteParser.RefExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link TestSuiteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(TestSuiteParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link TestSuiteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(TestSuiteParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code testExpr}
	 * labeled alternative in {@link TestSuiteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTestExpr(TestSuiteParser.TestExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code testExpr}
	 * labeled alternative in {@link TestSuiteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTestExpr(TestSuiteParser.TestExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link TestSuiteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(TestSuiteParser.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link TestSuiteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(TestSuiteParser.ParensExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link TestSuiteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(TestSuiteParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link TestSuiteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(TestSuiteParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funRef}
	 * labeled alternative in {@link TestSuiteParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterFunRef(TestSuiteParser.FunRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funRef}
	 * labeled alternative in {@link TestSuiteParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitFunRef(TestSuiteParser.FunRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varRef}
	 * labeled alternative in {@link TestSuiteParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(TestSuiteParser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varRef}
	 * labeled alternative in {@link TestSuiteParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(TestSuiteParser.VarRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#unitSpec}.
	 * @param ctx the parse tree
	 */
	void enterUnitSpec(TestSuiteParser.UnitSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#unitSpec}.
	 * @param ctx the parse tree
	 */
	void exitUnitSpec(TestSuiteParser.UnitSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#composedUnit}.
	 * @param ctx the parse tree
	 */
	void enterComposedUnit(TestSuiteParser.ComposedUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#composedUnit}.
	 * @param ctx the parse tree
	 */
	void exitComposedUnit(TestSuiteParser.ComposedUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code siUnitType}
	 * labeled alternative in {@link TestSuiteParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void enterSiUnitType(TestSuiteParser.SiUnitTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code siUnitType}
	 * labeled alternative in {@link TestSuiteParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void exitSiUnitType(TestSuiteParser.SiUnitTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code customUnitType}
	 * labeled alternative in {@link TestSuiteParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void enterCustomUnitType(TestSuiteParser.CustomUnitTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code customUnitType}
	 * labeled alternative in {@link TestSuiteParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void exitCustomUnitType(TestSuiteParser.CustomUnitTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code composedUnitType}
	 * labeled alternative in {@link TestSuiteParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void enterComposedUnitType(TestSuiteParser.ComposedUnitTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code composedUnitType}
	 * labeled alternative in {@link TestSuiteParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void exitComposedUnitType(TestSuiteParser.ComposedUnitTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#siUnit}.
	 * @param ctx the parse tree
	 */
	void enterSiUnit(TestSuiteParser.SiUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#siUnit}.
	 * @param ctx the parse tree
	 */
	void exitSiUnit(TestSuiteParser.SiUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestSuiteParser#customUnit}.
	 * @param ctx the parse tree
	 */
	void enterCustomUnit(TestSuiteParser.CustomUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestSuiteParser#customUnit}.
	 * @param ctx the parse tree
	 */
	void exitCustomUnit(TestSuiteParser.CustomUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noP}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterNoP(TestSuiteParser.NoPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noP}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitNoP(TestSuiteParser.NoPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quetta}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterQuetta(TestSuiteParser.QuettaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quetta}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitQuetta(TestSuiteParser.QuettaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ronna}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterRonna(TestSuiteParser.RonnaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ronna}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitRonna(TestSuiteParser.RonnaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code yotta}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterYotta(TestSuiteParser.YottaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code yotta}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitYotta(TestSuiteParser.YottaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code zetta}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterZetta(TestSuiteParser.ZettaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code zetta}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitZetta(TestSuiteParser.ZettaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exa}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterExa(TestSuiteParser.ExaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exa}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitExa(TestSuiteParser.ExaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code peta}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterPeta(TestSuiteParser.PetaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code peta}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitPeta(TestSuiteParser.PetaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tera}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterTera(TestSuiteParser.TeraContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tera}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitTera(TestSuiteParser.TeraContext ctx);
	/**
	 * Enter a parse tree produced by the {@code giga}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterGiga(TestSuiteParser.GigaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code giga}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitGiga(TestSuiteParser.GigaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mega}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterMega(TestSuiteParser.MegaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mega}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitMega(TestSuiteParser.MegaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code kilo}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterKilo(TestSuiteParser.KiloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code kilo}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitKilo(TestSuiteParser.KiloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hecto}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterHecto(TestSuiteParser.HectoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hecto}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitHecto(TestSuiteParser.HectoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code deca}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterDeca(TestSuiteParser.DecaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code deca}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitDeca(TestSuiteParser.DecaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code deci}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterDeci(TestSuiteParser.DeciContext ctx);
	/**
	 * Exit a parse tree produced by the {@code deci}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitDeci(TestSuiteParser.DeciContext ctx);
	/**
	 * Enter a parse tree produced by the {@code centi}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterCenti(TestSuiteParser.CentiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code centi}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitCenti(TestSuiteParser.CentiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mili}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterMili(TestSuiteParser.MiliContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mili}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitMili(TestSuiteParser.MiliContext ctx);
	/**
	 * Enter a parse tree produced by the {@code micro}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterMicro(TestSuiteParser.MicroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code micro}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitMicro(TestSuiteParser.MicroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nano}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterNano(TestSuiteParser.NanoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nano}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitNano(TestSuiteParser.NanoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pico}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterPico(TestSuiteParser.PicoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pico}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitPico(TestSuiteParser.PicoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code femto}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterFemto(TestSuiteParser.FemtoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code femto}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitFemto(TestSuiteParser.FemtoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atto}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterAtto(TestSuiteParser.AttoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atto}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitAtto(TestSuiteParser.AttoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code zepto}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterZepto(TestSuiteParser.ZeptoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code zepto}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitZepto(TestSuiteParser.ZeptoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code yocto}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterYocto(TestSuiteParser.YoctoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code yocto}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitYocto(TestSuiteParser.YoctoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ronto}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterRonto(TestSuiteParser.RontoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ronto}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitRonto(TestSuiteParser.RontoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quecto}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterQuecto(TestSuiteParser.QuectoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quecto}
	 * labeled alternative in {@link TestSuiteParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitQuecto(TestSuiteParser.QuectoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code second}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterSecond(TestSuiteParser.SecondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code second}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitSecond(TestSuiteParser.SecondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code metre}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterMetre(TestSuiteParser.MetreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code metre}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitMetre(TestSuiteParser.MetreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gram}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterGram(TestSuiteParser.GramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gram}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitGram(TestSuiteParser.GramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ampere}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterAmpere(TestSuiteParser.AmpereContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ampere}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitAmpere(TestSuiteParser.AmpereContext ctx);
	/**
	 * Enter a parse tree produced by the {@code kelvin}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterKelvin(TestSuiteParser.KelvinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code kelvin}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitKelvin(TestSuiteParser.KelvinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mole}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterMole(TestSuiteParser.MoleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mole}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitMole(TestSuiteParser.MoleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code candela}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterCandela(TestSuiteParser.CandelaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code candela}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitCandela(TestSuiteParser.CandelaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pascal}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterPascal(TestSuiteParser.PascalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pascal}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitPascal(TestSuiteParser.PascalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code joule}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterJoule(TestSuiteParser.JouleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code joule}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitJoule(TestSuiteParser.JouleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ton}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterTon(TestSuiteParser.TonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ton}
	 * labeled alternative in {@link TestSuiteParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitTon(TestSuiteParser.TonContext ctx);
}