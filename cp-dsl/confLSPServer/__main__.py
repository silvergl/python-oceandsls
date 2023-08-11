"""cp-dsl LSPServer package."""

############################################################################
# Copyright(c) Open Law Library. All rights reserved.                      #
# See ThirdPartyNotices.txt in the project root for additional notices.    #
#                                                                          #
# Licensed under the Apache License, Version 2.0 (the "License")           #
# you may not use this file except in compliance with the License.         #
# You may obtain a copy of the License at                                  #
#                                                                          #
#     http: // www.apache.org/licenses/LICENSE-2.0                         #
#                                                                          #
# Unless required by applicable law or agreed to in writing, software      #
# distributed under the License is distributed on an "AS IS" BASIS,        #
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. #
# See the License for the specific language governing permissions and      #
# limitations under the License.                                           #
############################################################################
import argparse
import logging
from setuptools import setup, find_packages

from .server import conf_server

logging.basicConfig( filename="confDSL_pygls.log", level=logging.DEBUG, filemode="w" )


def main():
    parser = argparse.ArgumentParser(
        prog="CONF-Language-Server",
        description="A program for a language server based on the configuration ocean-dsl",
        epilog="ConfigurationDSL Language Server"
    )
    parser.add_argument(
        "--tcp", dest="tcp", action="store_true",
        help="Use TCP server"
    )
    parser.add_argument(
        "--ws", dest="ws", action="store_true",
        help="Use WebSocket server"
    )
    parser.add_argument(
        "--host", dest="host", default="127.0.0.1",
        help="Bind to this address"
    )
    parser.add_argument(
        "--port", dest="port", type=int, default=2087,
        help="Bind to this port"
    )
    parser.add_argument(
        "--testing", dest="test", action="store_true", help="Run the tests"
    )
    args = parser.parse_args()
    if args.test:
        import confLSPServer.test
    if args.tcp:
        conf_server.start_tcp( args.host, args.port )
    elif args.ws:
        conf_server.start_ws( args.host, args.port )
    else:
        parser.print_help()
        conf_server.start_io()


if __name__ == '__main__':
    # main()
    from confLSPServer.gen.python.Configuration.ConfigurationLexer import ConfigurationLexer
    from confLSPServer.gen.python.Configuration.ConfigurationParser import ConfigurationParser
    from antlr4 import InputStream, CommonTokenStream
    from confLSPServer.symbolTable.SymbolTable import VariableSymbol
    from confLSPServer.cst.SymbolTableVisitor import SymbolTableVisitor
    from confLSPServer.utils.calc import DeclarationCalculator, ConfigurationCalculator
    tableVisitor = SymbolTableVisitor("testConf")


    with open("/home/armin/Dokumente/cp-dsl/examples/testing/arrays/array.oconf") as conf_file:
        data = conf_file.read()
        input_stream = InputStream(data)
        lexer = ConfigurationLexer(input_stream)
        stream = CommonTokenStream(lexer)
        dcl_parsed = ConfigurationParser(stream).configurationModel()
        tableVisitor.visit(dcl_parsed)
        tableCalc = DeclarationCalculator(tableVisitor.symbolTable)
        table = ConfigurationCalculator(tableCalc.calculate()).calculate()
        for elem in table.getAllNestedSymbolsSync():
            if elem.name == "offline":
                print(elem.is_activated)
            if isinstance(elem, VariableSymbol):
                print(elem.name, elem.toArray())


    # from confLSPServer.gen.python.Declaration.DeclarationLexer import DeclarationLexer
    # from confLSPServer.gen.python.Declaration.DeclarationParser import DeclarationParser
    # from antlr4 import InputStream, CommonTokenStream
    # from confLSPServer.cst.SymbolTableVisitorDcl import SymbolTableVisitorDecl
    # tableVisitor = SymbolTableVisitorDecl("test")

    # with open("/home/armin/Dokumente/antlr4/antlr4-python/cp-dsl/eval.decl") as conf_file:
    #     data = conf_file.read()
    #     input_stream = InputStream(data)
    #     lexer = DeclarationLexer(input_stream)
    #     stream = CommonTokenStream(lexer)
    #     dcl_parsed = DeclarationParser(stream).declarationModel()
    #     tableVisitor.visit(dcl_parsed)
    #     print(tableVisitor.symbolTable.getAllNestedSymbolsSync("Temperature"))


