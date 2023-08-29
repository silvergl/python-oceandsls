
import jinja2 as j
import os

from symbolTable.SymbolTable import SymbolTable, VariableSymbol, Enum, CompartmentSymbol
from gen.python.BgcDsl.BgcDslParser import BgcDslParser

class BgcCodeGenerator():
   
    def __init__(self, symbolTable : SymbolTable, outputPath : str) -> None:
        self._symbolTable : SymbolTable = symbolTable
       # self.templateLoader = j.PackageLoader(str(self.__module__), "fileWriter/jinja-templates")
       # print(str(self.__module__))
       # self.templateEnv = j.Environment(loader=self.templateLoader)

        self.templateLoader = j.FileSystemLoader(searchpath="/home/serafim/Desktop/python-oceandsls/bgc-dsl/bgcLSPServer/fileWriter/jinja-templates")
        self.templateEnv = j.Environment(loader=self.templateLoader)

        self.outputPath = outputPath


    def generate(self) -> None:

      #  print(self._symbolTable.children())
        for c in self._symbolTable.children():
            if c.name:
                print(c.name)
            else:
                print("ff")
        symbols = list(filter(lambda x : type(x) is CompartmentSymbol is CompartmentSymbol,self._symbolTable.children()))
        print(symbols)
#    filter( lambda x : x is CompartmentSymbol, self._symbolTable.children())) # Get Compartments
     #   print(symbols)
        for e in symbols:
            mainTemplate = self.templateEnv.get_template('fun_group.txt')  # Entry Template
            classname = e.name #
            parameters = e.value.constants
            module = e.name
            fungroup_path = os.path.join(self.outputPath, f'{module}')
            control = open(fungroup_path, "w")
            control.write(mainTemplate.render(classname = classname, parameters = parameters, modulname = module))
            control.close()




