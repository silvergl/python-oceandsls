import jinja2 as j
import os

from ..symbolTable.SymbolTable import SymbolTable, VariableSymbol, Enum


class BgcCodeGenerator():
   
    def __init__(self, symbolTable : SymbolTable, outputPath : str) -> None:
        self._symbolTable : SymbolTable = symbolTable
        self.templateLoader = j.PackageLoader(str(self.__module__), "jinja-templates")
        self.templateEnv = j.Environment(loader=self.templateLoader)
        self.outputPath = outputPath
    
    def generate(self) -> None:

        mainTemplate = self.templateEnv.get_template('fun_group') # TODO None-> Template!
        
        module = "42"
        fungroup_path = os.path.join(self.outputPath, f'{module}')
        control = open(fungroup_path, "w")
        control.write(mainTemplate.render(classname = module, parameters = param))

