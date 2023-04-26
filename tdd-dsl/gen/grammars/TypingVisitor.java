// Generated from /home/sgu/IdeaProjects/python-oceandsls/tdd-dsl/tddLSPServer/grammars/Typing.g4 by ANTLR 4.12.0
package grammars;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TypingParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface TypingVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by the {@code ref}
     * labeled alternative in {@link TypingParser#paramType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRef(TypingParser.RefContext ctx);

    /**
     * Visit a parse tree produced by the {@code enm}
     * labeled alternative in {@link TypingParser#paramType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEnm(TypingParser.EnmContext ctx);

    /**
     * Visit a parse tree produced by the {@code array}
     * labeled alternative in {@link TypingParser#paramType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitArray(TypingParser.ArrayContext ctx);

    /**
     * Visit a parse tree produced by {@link TypingParser#typeRef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTypeRef(TypingParser.TypeRefContext ctx);

    /**
     * Visit a parse tree produced by {@link TypingParser#enumType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEnumType(TypingParser.EnumTypeContext ctx);

    /**
     * Visit a parse tree produced by {@link TypingParser#enum}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEnum(TypingParser.EnumContext ctx);

    /**
     * Visit a parse tree produced by {@link TypingParser#arrayType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitArrayType(TypingParser.ArrayTypeContext ctx);

    /**
     * Visit a parse tree produced by the {@code size}
     * labeled alternative in {@link TypingParser#dim}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSize(TypingParser.SizeContext ctx);

    /**
     * Visit a parse tree produced by the {@code range}
     * labeled alternative in {@link TypingParser#dim}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRange(TypingParser.RangeContext ctx);

    /**
     * Visit a parse tree produced by {@link TypingParser#sizeDim}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSizeDim(TypingParser.SizeDimContext ctx);

    /**
     * Visit a parse tree produced by {@link TypingParser#rangeDim}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRangeDim(TypingParser.RangeDimContext ctx);

    /**
     * Visit a parse tree produced by the {@code strExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStrExpr(TypingParser.StrExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code intExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIntExpr(TypingParser.IntExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code addSubExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAddSubExpr(TypingParser.AddSubExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code signExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSignExpr(TypingParser.SignExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code refExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRefExpr(TypingParser.RefExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code numberExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNumberExpr(TypingParser.NumberExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code parensExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParensExpr(TypingParser.ParensExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code mulDivExpr}
     * labeled alternative in {@link TypingParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMulDivExpr(TypingParser.MulDivExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code funRef}
     * labeled alternative in {@link TypingParser#reference}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunRef(TypingParser.FunRefContext ctx);

    /**
     * Visit a parse tree produced by the {@code varRef}
     * labeled alternative in {@link TypingParser#reference}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVarRef(TypingParser.VarRefContext ctx);
}