#!/usr/bin/env python3
__author__ = 'sgu'

import sys, os
if not os.path.join(sys.path[0],'..','..','..','build-python') in sys.path:
    sys.path.append(os.path.join(sys.path[0],'..','..','..','build-python'))

# debug import
from pprint import pprint
pprint(sys.path)

import logging

from antlr4 import *
from antlr4.InputStream import InputStream
from TestExprCore.TestExprCoreLexer import TestExprCoreLexer, ParserRuleContext
from TestExprCore.TestExprCoreParser import TestExprCoreParser
from TestExprCore.TestExprCoreVisitor import TestExprCoreVisitor

from CodeCompletionCore import CodeCompletionCore

if __name__ == "__main__":
    # create input stream of characters for lexer
    if len( sys.argv ) > 1:
        # input_stream = FileStream(sys.argv[1])
        input_stream = InputStream( "var c = a + b()" )
    else:
        # TODO move parameters into file
        input_stream = InputStream(sys.stdin.readline())

    # create lexer and parser objects and token stream pipe between them
    lexer = TestExprCoreLexer(input_stream)
    tokenStream = CommonTokenStream(lexer)
    parser = TestExprCoreParser(tokenStream)

    parser.removeErrorListeners()
    parser.addErrorListener(DiagnosticErrorListener)

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

    cls_list = ParserRuleContext.__subclasses__()

    print(cls_list)

    # evaluator - walk parse tree
    # visitor = TestExprCoreVisitor
    # output = visitor.visit(ast)

    # print(output)
