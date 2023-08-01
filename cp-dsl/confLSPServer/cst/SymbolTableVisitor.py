"""SymbolTableVisitor module."""

__author__ = 'stu222808'

# util imports
from typing import TypeVar, Generic, Dict, Optional, Callable, Any

# antlr4
from antlr4.tree.Tree import ParseTree
from antlr4 import InputStream, CommonTokenStream

from confLSPServer.gen.python.Configuration.ConfigurationLexer import ConfigurationLexer
from confLSPServer.gen.python.Configuration.ConfigurationParser import ConfigurationParser

from ..gen.python.Configuration.ConfigurationParser import ConfigurationParser
from ..gen.python.Declaration.DeclarationParser import DeclarationParser
from ..gen.python.Declaration.DeclarationLexer import DeclarationLexer
# user relative imports
from .SymbolTableVisitorDcl import SymbolTableVisitorDecl as DeclSymbolTableVisitor
from ..symbolTable.SymbolTable import SymbolTable, P, T, GroupSymbol, FeatureSymbol, SymbolTableOptions, VariableSymbol, FundamentalUnit, UnitPrefix, UnitKind, EnumSymbol, ArraySymbol
from ..gen.python.Configuration.ConfigurationParser import ConfigurationParser
from ..gen.python.Configuration.ConfigurationVisitor import ConfigurationVisitor

import os


class SymbolTableVisitor( ConfigurationVisitor, Generic[T] ):
    _symbolTable: SymbolTable

    def __init__(self, name: str = '', ):
        super().__init__()
        # creates a new symboltable with no duplicate symbols
        self._symbolTable = SymbolTable(name, SymbolTableOptions(False))
        # TODO scope marker
        # self._scope = self._symbolTable.addNewSymbolOfType( ScopedSymbol, None )
        self._scope = self._symbolTable

    @property
    def symbolTable(self) -> SymbolTable:
        return self._symbolTable

    def defaultResult(self) -> SymbolTable:
        return self._symbolTable

    def visitConfigurationModel(self, ctx: ConfigurationParser.ConfigurationModelContext):
        # Symboltable has to be filled with Declaration Defaults
        table = self.visitDeclarationTable(ctx.declarationModel.text)
        # add all symbols to symboltable
        self._symbolTable = table
        return super().visitConfigurationModel(ctx)
    
    def visitDeclarationTable(self, declarationName : str):
        declVisitor = DeclSymbolTableVisitor(declarationName + "_ConfDeclVisit")
        # TODO: How do we know where the dcl file is placed?
        # TODO: Maybe: Copy TDD-DSL Pattern for os paths
        with open(os.path.join(os.getcwd(),declarationName + ".decl")) as dcl_file:
            data = dcl_file.read()
            input_stream = InputStream(data)
            lexer = DeclarationLexer(input_stream)
            stream = CommonTokenStream(lexer)
            dcl_parsed = DeclarationParser(stream).declarationModel()
            declVisitor.visit(dcl_parsed)
        return declVisitor.symbolTable

    def visitParameterAssignment(self, ctx: ConfigurationParser.ParameterAssignmentContext):
        # define the given Parameter
        print("ENDLICH HATS GEFUNZT!!!!")
        varName = ctx.declaration.text # set and get the variable name here
        unit = self.visit(ctx.unit) if ctx.unit != None else UnitPrefix.NoP
        #isArray = True if len(ctx.selectors) > 0 else False
        symbol = self._scope.getAllNestedSymbolsSync(varName)[0]
        if unit != UnitPrefix.NoP:
            symbol.attached_unit.prefix = unit
        symbol.configuration.append(ctx)
        
    def visitParameterGroup(self, ctx: ConfigurationParser.ParameterGroupContext):
        self.withScope(GroupSymbol, ctx, ctx.declaration.text, lambda: self.visitChildren(ctx))
        print("paramGroup", ctx.declaration.text)
        print([i.getText() for i in ctx.children])
        print(ctx.children)
    
    def visitSelector(self, ctx: ConfigurationParser.SelectorContext):
        vector = []
        vector.append(self.visitChildren(ctx))
        return vector
    
    def visitElementSelector(self, ctx: ConfigurationParser.ElementSelectorContext):
        return int(ctx.element.text)
    
    def visitRangeSelector(self, ctx: ConfigurationParser.RangeSelectorContext):
        return (int(ctx.lowerBound.text), int(ctx.upperBound.text))

    def visitUnitSpecification(self, ctx : ConfigurationParser.UnitSpecificationContext):
        return self.stringToPrefix(ctx.name.text)

    def visitFeatureConfiguration(self, ctx: ConfigurationParser.FeatureConfigurationContext):
        self.withScope(FeatureSymbol, ctx, ctx.declaration.text, lambda: self.visitChildren(ctx))

    def visitFeatureActivation(self, ctx : ConfigurationParser.FeatureActivationContext):
        for feature in self._scope.getFeatures():
            if feature.name == ctx.declaration.text:
                try:
                    # if is_activated is set to false it is not none
                    feature.is_activated = True if ctx.deactivated else False
                except AttributeError:
                    print("WARNING: There was a None in Feature Configuration of " + str(feature.name))
                    pass
                
    def visitInclude(self, ctx: ConfigurationParser.IncludeContext):
        info = ctx.importedNamespace.text.split(".")
        #visit configuration table
        confVisitor = SymbolTableVisitor(info[0] + "_ConfVisit")
        # TODO: Maybe: Copy TDD-DSL Pattern for os paths
        with open(os.path.join(os.getcwd(),info[0] + ".oconf")) as conf_file:
            data = conf_file.read()
            input_stream = InputStream(data)
            lexer = ConfigurationLexer(input_stream)
            stream = CommonTokenStream(lexer)
            dcl_parsed = ConfigurationParser(stream).configurationModel()
            confVisitor.visit(dcl_parsed)
            table = confVisitor._symbolTable
        #TODO: Not sure if this is gonna work
        scope = None
        #go through all symbols
        for i in range(1,len(info)):
            scope = table.getAllNestedSymbolsSync(info[i])[0]
        self._symbolTable.addSymbol(scope)

    def stringToPrefix(input : str):
            for prefix in UnitPrefix:
                if vars(prefix)["_name_"].lower() == input.lower():
                    return prefix
            return UnitPrefix.NoP
    
    
    def stringToUnitType(input : str):
        for kind in UnitKind:
            if vars(kind)["_name_"].lower() == input.lower():
                return kind
        return UnitKind.Unknown
    
    def withScope(self, type : T, tree: ParseTree, name: str, action: Callable) -> T:
        print("With Scope, by:", name, tree.getText(), str(type))
        scope = self._symbolTable.getAllNestedSymbolsSync(name)
        if len(scope) < 1:
            print("Symbol with name " + str(name) + " could not be found")
            return
        elif len(scope) > 1:
            for elem in scope:
                if isinstance(elem, type):
                    scope = elem
                    break
        else:
            scope = scope[0]
        if type == FeatureSymbol:
            scope.is_activated = True
        scope.configuration.append(tree)
        self._scope = scope
        try:
            return action()
        finally:
            if self._scope:
                self._scope = scope.parent()
            else:
                print("scope not set")