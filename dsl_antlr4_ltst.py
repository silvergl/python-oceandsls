#!/usr/bin/env python3
import sys
from antlr4 import *
from antlr4_ltst.TestGrammarLexer import TestGrammarLexer
from antlr4_ltst.TestGrammarParser import TestGrammarParser
from antlr4_ltst.TestGrammarVisitor import TestGrammarVisitor


def get_username():
    from pwd import getpwuid
    from os import getuid
    return getpwuid(getuid())[0]


class TestVisitor(TestGrammarVisitor):
    def visitNumberExpr(self, ctx):
        value = ctx.getText()
        return int(value)

    def visitParenExpr(self, ctx):
        return self.visitNumberExpr(ctx.expr())

    def visitInfixExpr(self, ctx):
        left = self.visit(ctx.left)
        right = self.visit(ctx.right)

        op = ctx.op.text

        operation = {
            '+': lambda: left + right,
            '-': lambda: left - right,
            '*': lambda: left * right,
            '/': lambda: left / right,
        }
        return operation.get(op, lambda: None)()

    def visitBarExpr(self, ctx):
        print(f"bar {get_username()}")
        sys.exit(0)

    def visitFooExpr(self, ctx):
        return f"{ctx.getText()} {get_username()}"


if __name__ == "__main__":
    while 1:
        data = InputStream(input(">>> "))
        # lexer
        lexer = TestGrammarLexer(data)
        stream = CommonTokenStream(lexer)
        # parser
        parser = TestGrammarParser(stream)
        ast = parser.expr()
        # evaluator
        visitor = TestVisitor()
        output = visitor.visit(ast)
        print(output)
