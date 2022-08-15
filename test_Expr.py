#!/usr/bin/env python3
__author__ = 'sgu'

import sys
sys.path.insert(0, './build-python')
from antlr4 import *
from antlr4.InputStream import InputStream
from Expr.ExprLexer import ExprLexer
from Expr.ExprParser import ExprParser
from Expr.ExprVisitor import ExprVisitor
from Expr.MyVisitor import MyVisitor

if __name__ == '__main__':
    # create input stream of characters for lexer
    if len(sys.argv) > 1:
        input_stream = FileStream(sys.argv[1])
    else:
        input_stream = InputStream(sys.stdin.readline())

    # create lexer and parser objects and token stream pipe between them
    lexer = ExprLexer(input_stream)
    token_stream = CommonTokenStream(lexer)
    parser = ExprParser(token_stream)

    # launch parser by invoking rule 'prog'
    tree = parser.prog()

    # print parse tree
    #lisp_tree_str = tree.toStringTree(recog=parser)
    #print(lisp_tree_str)

    # walk parse tree 
    visitor = MyVisitor()
    visitor.visit(tree)
