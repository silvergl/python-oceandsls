""" Testing input testing grammar file"""

from confLSPServer.gen.python.Configuration.ConfigurationLexer import ConfigurationLexer
from confLSPServer.gen.python.Configuration.ConfigurationParser import ConfigurationParser
from antlr4 import InputStream, CommonTokenStream
from confLSPServer.symbolTable.SymbolTable import VariableSymbol
from confLSPServer.cst.SymbolTableVisitor import SymbolTableVisitor
from confLSPServer.utils.calc import DeclarationCalculator, ConfigurationCalculator


## arrays:
def testingArrays():
    def rangeArrayTest(elem) -> bool:
        shouldArray = [None, None, None, None]
        for i in elem.toArray():
            if not i == shouldArray:
                return False
        return True

    tableVisitor = SymbolTableVisitor("testConf")
    with open("../input/arrays/array.oconf") as conf_file:
        data = conf_file.read()
        input_stream = InputStream(data)
        lexer = ConfigurationLexer(input_stream)
        stream = CommonTokenStream(lexer)
        dcl_parsed = ConfigurationParser(stream).configurationModel()
        tableVisitor.visit(dcl_parsed)
        tableCalc = DeclarationCalculator(tableVisitor.symbolTable)
        table = ConfigurationCalculator(tableCalc.calculate()).calculate()
        succesful = True
        for elem in table.getAllNestedSymbolsSync():
            if elem.name == "range_array":
                succesful = rangeArrayTest()
        if succesful:
            print("TESTING: Array Test was successful")
        else:
            print("TESTING: Array Test was unsuccesful")

## BASIC ##
def testBasic():
    tableVisitor = SymbolTableVisitor("testConf")
    with open("../input/basic/global.oconf") as conf_file:
        data = conf_file.read()
        input_stream = InputStream(data)
        lexer = ConfigurationLexer(input_stream)
        stream = CommonTokenStream(lexer)
        dcl_parsed = ConfigurationParser(stream).configurationModel()
        tableVisitor.visit(dcl_parsed)
        tableCalc = DeclarationCalculator(tableVisitor.symbolTable)
        table = ConfigurationCalculator(tableCalc.calculate()).calculate()
        succesful = True
        for elem in table.getAllNestedSymbolsSync():
            if elem.name == "pipe":
                succesful = elem.is_activated
        if succesful:
            print("TESTING: Basic Test was successful")
        else:
            print("TESTING: Basic Test was unsuccesful")
        
## conditions ##
def testConditions():
    tableVisitor = SymbolTableVisitor("testConf")
    with open("../input/conditions/configuration.oconf") as conf_file:
        data = conf_file.read()
        input_stream = InputStream(data)
        lexer = ConfigurationLexer(input_stream)
        stream = CommonTokenStream(lexer)
        dcl_parsed = ConfigurationParser(stream).configurationModel()
        tableVisitor.visit(dcl_parsed)
        tableCalc = DeclarationCalculator(tableVisitor.symbolTable)
        table = ConfigurationCalculator(tableCalc.calculate()).calculate()
        succesful = True
        for elem in table.getAllNestedSymbolsSync():
            if elem.name == "param":
                succesful = elem.value
        if succesful:
            print("TESTING: Conditions Test was successful")
        else:
            print("TESTING: Conditions Test was unsuccesful")

testBasic()
testConditions()
testingArrays()




