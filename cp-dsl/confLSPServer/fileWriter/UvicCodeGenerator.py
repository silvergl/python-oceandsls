import jinja2 as j
import os

#Relative imports
from ..symbolTable.SymbolTable import SymbolTable, GroupSymbol, VariableSymbol, FeatureSymbol, EnumSymbol

class UvicCodeGenerator():
    def __init__(self, symbolTable : SymbolTable, outputPath : str) -> None:
        self._symbolTable : SymbolTable = symbolTable
        self.templateLoader = j.PackageLoader(str(self.__module__), "jinja-templates")
        self.templateEnv = j.Environment(loader=self.templateLoader)
        self.outputPath = outputPath

    def generate(self) -> None:
        #control in template
        templatecontr = self.templateEnv.get_template("control.in.template")
        controlPath = os.path.join(self.outputPath, "control.in")
        control = open(controlPath, "w")
        control.write(templatecontr.render(symbols = self._symbolTable.children(), groupSymbol=GroupSymbol, paramSymbol=VariableSymbol, featureSymbol = FeatureSymbol, isinstance=isinstance, enumSymbol = EnumSymbol, enumerate = enumerate))
        control.close()
        #mk in template
        templatemk = self.templateEnv.get_template("mk.in.template")
        #get source and general group
        generalObj = {}
        sourceObj = {}
        profilingObj = {}
        for elem in self._symbolTable.children():
            if elem.name == "general":
                for i in elem.children():
                    if i.is_array:
                        generalObj[i.name] = i.toNormalizedArray()
                    else:
                        # could be an enum so we need the string here
                        generalObj[i.name] = i.value[0] if isinstance(i.value, tuple) else i.value
            if elem.name == "source":
                for i in elem.children():
                    if i.is_array:
                        sourceObj[i.name] = i.toNormalizedArray()
                    else:
                        generalObj[i.name] = i.value[0] if isinstance(i.value, tuple) else i.value
        mkPath = os.path.join(self.outputPath, "mk.in")
        mk = open(mkPath, "w")
        mk.write(templatemk.render(general = generalObj, source = sourceObj, features = self._symbolTable.getNestedSymbolsOfTypeSync(FeatureSymbol), isinstance = isinstance, tuple = tuple))
        mk.close()

        
