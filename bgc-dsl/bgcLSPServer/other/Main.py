"""Parses from a file (according to BgcDsl.g4) and saves its variables and nodes (context objects) in a SymbolTable."""

__author__ = 'stu90642'

#  Copyright (c) 2023.  OceanDSL (https://oceandsl.uni-kiel.de)
#
#  Licensed under the Apache License, Version 2.0 (the "License");
#  you may not use this file except in compliance with the License.
#  You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.

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
