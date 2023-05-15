"""Parses from a file (according to BgcDsl.g4) and saves its variables and nodes (context objects) in a SymbolTable."""

__author__ = 'stu90642'

import sys
from antlr4 import *
from ..gen.python.BgcDsl.BgcDslLexer import BgcDslLexer
from ..gen.python.BgcDsl.BgcDslParser import BgcDslParser
from ..cst.SymbolTableVisitor import SymbolTableVisitor
from ..symbolTable.SymbolTable import ScopedSymbol, SymbolTable, P, T, VariableSymbol, Symbol, RoutineSymbol, SymbolTableOptions

def main(argv):
    input_stream = FileStream('example1.bgc')
    lexer = BgcDslLexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = BgcDslParser(stream)     # returns object of class "Parser"
    tree = parser.bgcModel()  # tree ist ein ctx-objekt; bgcModel is the first rule
    
    symbolTable = SymbolTableVisitor('SymbolTableVisitor_1').visit(tree)

    # shows the SymbolTable contents
    for e in symbolTable.getAllSymbolsSync(Symbol):
        print('#', e.name, '=', e.value)

main(sys.argv)
