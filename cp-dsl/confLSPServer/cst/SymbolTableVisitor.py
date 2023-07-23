"""SymbolTableVisitor module."""

__author__ = 'stu222808'

# util imports
from typing import TypeVar, Generic, Dict, Optional, Callable, Any

# antlr4
from antlr4.tree.Tree import ParseTree
from antlr4 import InputStream, CommonTokenStream

from ..gen.python.Configuration.ConfigurationParser import ConfigurationParser
from ..gen.python.Declaration.DeclarationParser import DeclarationParser
from ..gen.python.Declaration.DeclarationLexer import DeclarationLexer
# user relative imports
from .SymbolTableVisitorDcl import SymbolTableVisitorDecl as DeclSymbolTableVisitor
from ..symbolTable.SymbolTable import SymbolTable, P, T, GroupSymbol, RoutineSymbol, SymbolTableOptions, VariableSymbol, FundamentalUnit, UnitPrefix, UnitKind, EnumSymbol
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
        self._scope = None

    @property
    def symbolTable(self) -> SymbolTable:
        return self._symbolTable

    def defaultResult(self) -> SymbolTable:
        return self._symbolTable

    def visitConfigurationModel(self, ctx: ConfigurationParser.ConfigurationModelContext):
        # Symboltable has to be filled with Declaration Defaults
        table = self.visitDeclaration(ctx.declarationModel.text)
        self._symbolTable.addDependencies(table)
        self._currPos = RoutineSymbol()
        return super().visitConfigurationModel(ctx)
    
    def visitDeclarationTable(self, declarationName : str):
        declVisitor = DeclSymbolTableVisitor(declarationName + "_ConfDeclVisit")
        # TODO: How do we know where the dcl file is placed?
        with open(os.path.join(os.getcwd(),declarationName)) as dcl_file:
            data = dcl_file.read()
            input_stream = InputStream(data)
            lexer = DeclarationLexer(input_stream)
            stream = CommonTokenStream(lexer)
            dcl_parsed = DeclarationParser(stream).declarationModel()
            declVisitor.visit(dcl_parsed)
        return declVisitor.symbolTable


    # Visit a parse tree produced by DeclarationParser#paramAssignStat.
    # 'def' name=ID type=paramType ':' unit=unitSpecification (',' description=STRING)? ('=' defaultValue=arithmeticExpression)?
    def visitParameterAssignment(self, ctx: ConfigurationParser.parameterAssignment):
        
        # define the given Parameter
        varName = ctx.declaration.text # set and get the variable name here
        #unit = self.visit(ctx.unit) if unit != None else UnitKind.Unknown
        checkForParamAndEdit(varName, ctx)
                
        def checkForParamAndEdit(searchedParamName : str, ctx : ConfigurationParser.parameterAssignment):
            for param in (self._scope.getParameters() if self._scope else self._symbolTable.getAllSymbolsSync(VariableSymbol, localOnly=True)):
                if param.name == searchedParamName:
                    param.configuration.append(ctx)
                    return
            print("ERROR: Couldn't find correct Symbol")
            # TODO: add new symbol if not found in SymbolTable?
    
    def visitParameterGroup(self, ctx: ConfigurationParser.parameterGroup):
        return self.withScope(ctx, GroupSymbol, lambda: self.visitChildren(ctx), ctx.declaration.text, VariableSymbol)

    def visitUnitSpecification(self, ctx : ConfigurationParser.unitSpecification):
        return self.stringToUnitType(ctx.name.text)

    def visitFeatureConfiguration(self, ctx: ConfigurationParser.featureConfiguration):
        return self.withScope(ctx, RoutineSymbol, lambda: self.visitChildren(ctx), ctx.declaration.text)

    def visitFeatureActivation(self, ctx : ConfigurationParser.featureActivation):
        for feature in self._scope.getFeatures():
            #TODO: Scopeing how to ge the correct feature/parameter, when names and scope is out of bound with decl and conf?
            if feature.name == ctx.name.text:
                try:
                    # if is_activated is set to false it is not none
                    feature.is_activated = True if ctx.deactivated else False
                except AttributeError:
                    print("WARNING: There was a None in Feature Configuration of " + str(feature.name))
                    pass
                
    def visitInclude(self, ctx: ConfigurationParser.include):
        info = ctx.importedNamespace.text.split(".")
        table = self.visitDeclarationTable(info[0])
        scope : RoutineSymbol = None
        #TODO: Not sure if this is gonna work
        for i in range(1,len(info)):
            if scope:
                for elem in scope.getAllSymbolsSync(T,True):
                    if info[i] == elem.name:
                        scope = elem
                        self._symbolTable.addSymbol(elem)
            else:
                for elem in table.getAllSymbolsSync():
                    if elem.name == info[i]:
                        scope = elem
                        self._symbolTable.addSymbol(elem)

    
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
    
    def withScope(self, tree: ParseTree, t: type, action: Callable, *my_args: P.args or None,
                  **my_kwargs: P.kwargs or None) -> T:
        scope = self._symbolTable.addNewSymbolOfType( t, self._scope, *my_args, **my_kwargs )
        scope.context = tree
        self._scope = scope
        try:
            return action()
        finally:
            self._scope = scope.parent()
