from confLSPServer.cst.SymbolTableVisitor import SymbolTableVisitor
from confLSPServer.gen.python.Configuration.ConfigurationLexer import ConfigurationLexer
from confLSPServer.gen.python.Configuration.ConfigurationParser import ConfigurationParser
from antlr4 import InputStream, CommonTokenStream
tableVisitor = SymbolTableVisitor("testConf")

with open("/home/armin/Dokumente/cp-dsl/examples/testing/basic/global.oconf") as conf_file:
    data = conf_file.read()
    input_stream = InputStream(data)
    lexer = ConfigurationLexer(input_stream)
    stream = CommonTokenStream(lexer)
    dcl_parsed = ConfigurationParser(stream).declarationModel()
    tableVisitor.visit(dcl_parsed)
    print(tableVisitor.symbolTable)

