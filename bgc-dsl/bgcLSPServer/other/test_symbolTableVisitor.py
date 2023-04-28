
from antlr4 import *
from BgcDslLexer import BgcDslLexer
from BgcDslParser import BgcDslParser
from My_SymbolTableVisitor import My_SymbolTableVisitor
from SymbolTable_copy import ScopedSymbol, SymbolTable, P, T, VariableSymbol, Symbol, RoutineSymbol, SymbolTableOptions
import unittest

# tests My_SymbolTableVisitor
def prepare():
    input_stream = FileStream('example1_shortened.bgc')
    lexer = BgcDslLexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = BgcDslParser(stream)     # returns object of class "Parser"

    tree = parser.bgcModel()  # tree ist ein ctx-objekt
    my_SymbolTableVisitor = My_SymbolTableVisitor('SymbolTableVisitor_1')  # parse tree an My_SymbolTableVisitor übergeben
    symbolTable = my_SymbolTableVisitor.visit(tree)
    return symbolTable

# # tests SymbolTable
# def prepare():
#     st1 = SymbolTable('SymbolTable_1', SymbolTableOptions( allowDuplicateSymbols = False ))
#     st1.addNewSymbolOfType(VariableSymbol, None, 'A', 123)
#     st1.addNewSymbolOfType(VariableSymbol, None, 'B', 111)
#     return st1

class TestSTVisitor(unittest.TestCase):    # wenn ich eine klasse verwende, dann muss ihr name mit "Test" beginnen.

    def test_amount(self):   # namen von test-funktionen müssen mit "test_" beginnen, oder auf "_test" enden.
        symbolTable = prepare()
        self.assertEqual(len(symbolTable.getAllSymbolsSync(Symbol)), 2)

    # tests whether this variable is in the ST
    def test_variable1(self):
        symbolTable = prepare()
        self.assertIsNotNone(symbolTable.resolveSync('N'))  # resolveSync returns a VariableSymbol object

    def test_variable2(self):
        symbolTable = prepare()
        self.assertIsNotNone(symbolTable.resolveSync('C'))  # resolveSync returns a VariableSymbol object


    # def test_variableC(self):
    #     symbolTable = prepare()
    #     self.assertIsNotNone(symbolTable.resolveSync('C'))
