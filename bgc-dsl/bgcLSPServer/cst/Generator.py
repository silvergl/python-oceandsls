
import jinja2 as j
import os

from ..symbolTable.SymbolTable import SymbolTable, VariableSymbol, Enum
from ..gen.python.BgcDsl.BgcDslParser import BgcDslParser

class BgcCodeGenerator():
   
    def __init__(self, symbolTable : SymbolTable, outputPath : str) -> None:
        self._symbolTable : SymbolTable = symbolTable
        self.templateLoader = j.PackageLoader(str(self.__module__), "jinja-templates")
        self.templateEnv = j.Environment(loader=self.templateLoader)
        self.outputPath = outputPath


    def generate(self) -> None:


        symbols = filter(self._symbolTable, lambda x : x.value is BgcDslParser.CompartmentContext) # Get Compartments

        for e in symbols:
            mainTemplate = self.templateEnv.get_template('fun_group')  # Entry Template
            classname = e.name.txt #
            parameters = e.constants()
            module = e.name.text
            fungroup_path = os.path.join(self.outputPath, f'{module}')
            control = open(fungroup_path, "w")
            control.write(mainTemplate.render(classname = classname, parameters = parameters, modulname = module))
            control.close()




