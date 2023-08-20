"""CodeCompletionCore example module."""

__author__ = 'sgu'

# TODO license

# utils
import sys
import os
import logging

# antlr4
from antlr4 import CommonTokenStream
from antlr4.InputStream import InputStream

# antlr4-c3
from codeCompletionCore.CodeCompletionCore import CodeCompletionCore

# user relative imports
from ..gen.python.TestExprCore.TestExprCoreLexer import TestExprCoreLexer
from ..gen.python.TestExprCore.TestExprCoreParser import TestExprCoreParser
from ..gen.python.TestExprCore.TestExprCoreVisitor import TestExprCoreVisitor
from ..cst.DiagnosticListener import DiagnosticListener

# debug import
from pprint import pprint

pprint(sys.path)

if __name__ == "__main__":
    # create input stream of characters for lexer
    if len(sys.argv) > 1:
        # input_stream = FileStream(sys.argv[1])
        input_stream = InputStream("var c = a + b()")
    else:
        # TODO move parameters into file
        input_stream = InputStream(sys.stdin.readline())

    # create lexer and parser objects and token stream pipe between them
    lexer = TestExprCoreLexer(input_stream)
    tokenStream = CommonTokenStream(lexer)
    parser = TestExprCoreParser(tokenStream)

    parser.removeErrorListeners()
    parser.addErrorListener(DiagnosticListener)

    listener = parser.getErrorListenerDispatch()

    # launch parser by invoking rule 'expression'
    try:
        ast = parser.expression()
    except SyntaxError as syn_inst:
        logging.exception("parser raised syntax exception")
    except Exception as inst:
        # print(type(inst))    # the exception instance
        # print(inst.args)     # arguments stored in .args
        # print(inst)          # __str__ allows args to be printed directly,
        # but may be overridden in exception subclasses
        # x, y = inst.args     # unpack args
        # print('x =', x)
        # print('y =', y)

        logging.exception("parser raised exception")
        # logging.exception("the exception instance '" + str(type(inst)) + "'")
        # logging.exception("arguments stored in .args '" + str(inst.args) + "'")
        # logging.exception("__str__ allows args to be printed directly '" + str(inst) + "'")

    # print parse tree
    lisp_tree_str = ast.toStringTree(recog=parser)
    print(lisp_tree_str)

    # launch c3 core with parser:Parser, preferredRules:tuple, ignoredTokens:tuple
    core = CodeCompletionCore(parser)

    candidates = core.collectCandidates(0)

    print(candidates)

    # evaluator - walk parse tree
    # visitor = TestExprCoreVisitor
    # output = visitor.visit(ast)

    # print(output)
