#!/usr/bin/env python3
__author__ = 'sgu'

import sys
sys.path.insert(0, '..')
from antlr4 import *
from antlr4.InputStream import InputStream
from TestExprCore.TestExprCoreLexer import TestExprCoreLexer
from TestExprCore.TestExprCoreParser import TestExprCoreParser
from TestExprCore.TestExprCoreVisitor import TestExprCoreVisitor
from CodeCompletionCore import CodeCompletionCore

if __name__ == "__main__":
    # create input stream of characters for lexer
    if len(sys.argv) > 1:
        input_stream = FileStream(sys.argv[1])
    else:
        # TODO move parameters into file
        input_stream = InputStream("var c = a + b()")
        # input_stream = InputStream(sys.stdin.readline())

    # create lexer and parser objects and token stream pipe between them
    lexer = TestExprCoreLexer(input_stream)
    tokenStream = CommonTokenStream(lexer)
    parser = TestExprCoreParser(tokenStream)

    parser.addErrorListener(DiagnosticErrorListener)

    # launch parser by invoking rule 'expression'
    ast = parser.expression()

    # print parse tree
    #lisp_tree_str = tree.toStringTree(recog=parser)
    #print(lisp_tree_str)

    # launch c3 core with parser:Parser, preferredRules:tuple, ignoredTokens:tuple
    core = CodeCompletionCore(parser)

    candidates = core.collectCandidates(0)

    print(candidates)

    # evaluator - walk parse tree
    # visitor = TestExprCoreVisitor
    # output = visitor.visit(ast)

    # print(output)
