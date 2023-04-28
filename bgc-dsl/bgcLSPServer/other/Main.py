# Parses from a file (according to BgcDsl.g4)
# and saves its variables and nodes (context objects) in a SymbolTable.

import sys
from antlr4 import *
from BgcDslLexer import BgcDslLexer
from BgcDslParser import BgcDslParser
from My_SymbolTableVisitor import My_SymbolTableVisitor
from SymbolTable import ScopedSymbol, SymbolTable, P, T, VariableSymbol, Symbol, RoutineSymbol, SymbolTableOptions

def main(argv):
    input_stream = FileStream('example2.bgc')
    lexer = BgcDslLexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = BgcDslParser(stream)     # returns object of class "Parser"

    tree = parser.bgcModel()  # tree ist ein ctx-objekt
    symbolTable = My_SymbolTableVisitor('SymbolTableVisitor_1').visit(tree)

    # shows the SymbolTable contents
    for e in symbolTable.getAllSymbolsSync(Symbol):
        print('#', e.name, '=', e.value)

main(sys.argv)
