// Generated from /home/sgu/IdeaProjects/python-oceandsls/tdd-dsl/tddLSPServer/grammars/Typing.g4 by ANTLR 4.12.0
package grammars;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TypingParser}.
 */
public interface TypingListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by the {@code ref}
     * labeled alternative in {@link TypingParser#paramType}.
     *
     * @param ctx the parse tree
     */
    void enterRef(TypingParser.RefContext ctx);

    /**
     * Exit a parse tree produced by the {@code ref}
     * labeled alternative in {@link TypingParser#paramType}.
     *
     * @param ctx the parse tree
     */
    void exitRef(TypingParser.RefContext ctx);

    /**
     * Enter a parse tree produced by the {@code enm}
     * labeled alternative in {@link TypingParser#paramType}.
     *
     * @param ctx the parse tree
     */
    void enterEnm(TypingParser.EnmContext ctx);

    /**
     * Exit a parse tree produced by the {@code enm}
     * labeled alternative in {@link TypingParser#paramType}.
     *
     * @param ctx the parse tree
     */
    void exitEnm(TypingParser.EnmContext ctx);

    /**
     * Enter a parse tree produced by the {@code array}
     * labeled alternative in {@link TypingParser#paramType}.
     *
     * @param ctx the parse tree
     */
    void enterArray(TypingParser.ArrayContext ctx);

    /**
     * Exit a parse tree produced by the {@code array}
     * labeled alternative in {@link TypingParser#paramType}.
     *
     * @param ctx the parse tree
     */
    void exitArray(TypingParser.ArrayContext ctx);

    /**
     * Enter a parse tree produced by {@link TypingParser#typeRef}.
     *
     * @param ctx the parse tree
     */
    void enterTypeRef(TypingParser.TypeRefContext ctx);

    /**
     * Exit a parse tree produced by {@link TypingParser#typeRef}.
     *
     * @param ctx the parse tree
     */
    void exitTypeRef(TypingParser.TypeRefContext ctx);

    /**
     * Enter a parse tree produced by {@link TypingParser#enumType}.
     *
     * @param ctx the parse tree
     */
    void enterEnumType(TypingParser.EnumTypeContext ctx);

    /**
     * Exit a parse tree produced by {@link TypingParser#enumType}.
     *
     * @param ctx the parse tree
     */
    void exitEnumType(TypingParser.EnumTypeContext ctx);

    /**
     * Enter a parse tree produced by {@link TypingParser#enum}.
     *
     * @param ctx the parse tree
     */
    void enterEnum(TypingParser.EnumContext ctx);

    /**
     * Exit a parse tree produced by {@link TypingParser#enum}.
     *
     * @param ctx the parse tree
     */
    void exitEnum(TypingParser.EnumContext ctx);

    /**
     * Enter a parse tree produced by {@link TypingParser#arrayType}.
     *
     * @param ctx the parse tree
     */
    void enterArrayType(TypingParser.ArrayTypeContext ctx);

    /**
     * Exit a parse tree produced by {@link TypingParser#arrayType}.
     *
     * @param ctx the parse tree
     */
    void exitArrayType(TypingParser.ArrayTypeContext ctx);

    /**
     * Enter a parse tree produced by the {@code size}
     * labeled alternative in {@link TypingParser#dim}.
     *
     * @param ctx the parse tree
     */
    void enterSize(TypingParser.SizeContext ctx);

    /**
     * Exit a parse tree produced by the {@code size}
     * labeled alternative in {@link TypingParser#dim}.
     *
     * @param ctx the parse tree
     */
    void exitSize(TypingParser.SizeContext ctx);

    /**
     * Enter a parse tree produced by the {@code range}
     * labeled alternative in {@link TypingParser#dim}.
     *
     * @param ctx the parse tree
     */
    void enterRange(TypingParser.RangeContext ctx);

    /**
     * Exit a parse tree produced by the {@code range}
     * labeled alternative in {@link TypingParser#dim}.
     *
     * @param ctx the parse tree
     */
    void exitRange(TypingParser.RangeContext ctx);

    /**
     * Enter a parse tree produced by {@link TypingParser#sizeDim}.
     *
     * @param ctx the parse tree
     */
    void enterSizeDim(TypingParser.SizeDimContext ctx);

    /**
     * Exit a parse tree produced by {@link TypingParser#sizeDim}.
     *
     * @param ctx the parse tree
     */
    void exitSizeDim(TypingParser.SizeDimContext ctx);

    /**
     * Enter a parse tree produced by {@link TypingParser#rangeDim}.
     *
     * @param ctx the parse tree
     */
    void enterRangeDim(TypingParser.RangeDimContext ctx);

    /**
     * Exit a parse tree produced by {@link TypingParser#rangeDim}.
     *
     * @param ctx the parse tree
     */
    void exitRangeDim(TypingParser.RangeDimContext ctx);

    /**
     * Enter a parse tree produced by the {@code strExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterStrExpr(TypingParser.StrExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code strExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitStrExpr(TypingParser.StrExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code intExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterIntExpr(TypingParser.IntExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code intExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitIntExpr(TypingParser.IntExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code addSubExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterAddSubExpr(TypingParser.AddSubExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code addSubExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitAddSubExpr(TypingParser.AddSubExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code signExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterSignExpr(TypingParser.SignExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code signExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitSignExpr(TypingParser.SignExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code refExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterRefExpr(TypingParser.RefExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code refExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitRefExpr(TypingParser.RefExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code numberExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterNumberExpr(TypingParser.NumberExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code numberExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitNumberExpr(TypingParser.NumberExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code parensExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterParensExpr(TypingParser.ParensExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code parensExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitParensExpr(TypingParser.ParensExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code mulDivExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterMulDivExpr(TypingParser.MulDivExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code mulDivExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitMulDivExpr(TypingParser.MulDivExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code funRef}
     * labeled alternative in {@link TypingParser#reference}.
     *
     * @param ctx the parse tree
     */
    void enterFunRef(TypingParser.FunRefContext ctx);

    /**
     * Exit a parse tree produced by the {@code funRef}
     * labeled alternative in {@link TypingParser#reference}.
     *
     * @param ctx the parse tree
     */
    void exitFunRef(TypingParser.FunRefContext ctx);

    /**
     * Enter a parse tree produced by the {@code varRef}
     * labeled alternative in {@link TypingParser#reference}.
     *
     * @param ctx the parse tree
     */
    void enterVarRef(TypingParser.VarRefContext ctx);

    /**
     * Exit a parse tree produced by the {@code varRef}
     * labeled alternative in {@link TypingParser#reference}.
     *
     * @param ctx the parse tree
     */
    void exitVarRef(TypingParser.VarRefContext ctx);
}