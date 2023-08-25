from antlr4 import InputStream, CommonTokenStream
import argparse
import os

#relative imports
from .confLSPServer.gen.python.Configuration.ConfigurationLexer import ConfigurationLexer
from .confLSPServer.gen.python.Configuration.ConfigurationParser import ConfigurationParser
from .confLSPServer.symbolTable.SymbolTable import VariableSymbol
from .confLSPServer.cst.SymbolTableVisitor import SymbolTableVisitor
from .confLSPServer.utils.calc import DeclarationCalculator, ConfigurationCalculator
from .confLSPServer.fileWriter.CodeGenerator import UvicCodeGenerator, mitGcmCodeGenerator

if __name__ == '__main__':
    parser = argparse.ArgumentParser(
        prog = "CP-DSL Compiler",
        description = "A compiler for the CP-DSL",
        epilog = "CP-DomainSpecificLanguage Compiler"
    )
    parser.add_argument(
        "-f", "--File", dest="path", help="path to the main configuration file"
    )
    parser.add_argument(
        "-o", "--out", dest="out", help="path to generated files"
    )
    parser.add_argument(
        "-u", "--uvic", dest="uvic", action="store_true", help="flag to generate for uvic"
    )
    parser.add_argument(
        "-m", "--mitgcm", dest="mitgcm", action="store_true", help="flag to generate for mitgcm"
    )
    args = parser.parse_args()
    if not args.path:
        print("ERROR: Please give a configuration file as argument!")
        parser.print_help()
    else:
        currPath = args.path if os.path.isabs(args.path) else os.path.join(os.getcwd(), args.path)
        if not os.path.exists(currPath) and os.path.isfile(currPath):
            print("ERROR: wether no file or no correct path given!")
        estimatedcwd = ""
        for i in currPath.split(os.sep):
            if i and not i.endswith(".oconf"):
                estimatedcwd += os.sep
                estimatedcwd += i
        tableVisitor = SymbolTableVisitor("user_conf_1", estimatedcwd)
        outputPath = args.out if args.out else os.path.join(estimatedcwd, "gen")
        if not os.path.isdir(outputPath):
            os.mkdir(outputPath)
        with open(currPath) as conf_file:
            data = conf_file.read()
            input_stream = InputStream(data)
            lexer = ConfigurationLexer(input_stream)
            stream = CommonTokenStream(lexer)
            dcl_parsed = ConfigurationParser(stream).configurationModel()
            tableVisitor.visit(dcl_parsed)
            try:
                tableCalc = DeclarationCalculator(tableVisitor.symbolTable)
            except AttributeError as e:
                print("ERROR: Could not parse Declaration-File correctly")
                print(e)
            #try:
            table = ConfigurationCalculator(tableCalc.calculate(), tableVisitor.configurationList).calculate()
            #except AttributeError as e:
            #     print("ERROR: Could not parse Configuration-File")
            #     print(e)
            if args.uvic:
                try:
                    generator = UvicCodeGenerator(table, outputPath)
                    generator.generate()
                except AttributeError as e:
                    print("ERROR: Could not generate uvic files")
                    print(e)
            if args.mitgcm:
                try:
                    generator = mitGcmCodeGenerator(table, outputPath)
                    generator.generate()
                except AttributeError as e:
                    print("ERROR: could not generate mitgcm files")
                    print(e)