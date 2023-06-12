"""SymbolTableVisitor module."""

__author__ = 'stu222808'

# util imports
from typing import TypeVar, Generic, Dict, Optional, Callable, Any


# antlr4
from antlr4.tree.Tree import ParseTree

# user relative imports
from ...dclLSPServer.cst.SymbolTableVisitor import SymbolTableVisitor as DeclSymbolTableVisitor
from ..symbolTable.SymbolTable import SymbolTable, P, T, GroupSymbol, RoutineSymbol, SymbolTableOptions, VariableSymbol, FundamentalUnit, UnitPrefix, UnitKind
from ..gen.python.Configuration.ConfigurationParser import ConfigurationParser
from ..gen.python.Configuration.ConfigurationVisitor import ConfigurationVisitor


class SymbolTableVisitor( ConfigurationVisitor, Generic[T] ):
    _symbolTable: SymbolTable

    def __init__(self, name: str = '', ):
        super().__init__()
        # creates a new symboltable with no duplicate symbols
        self._symbolTable = SymbolTable( name, SymbolTableOptions( False ) )
        # TODO scope marker
        # self._scope = self._symbolTable.addNewSymbolOfType( ScopedSymbol, None )
        self._scope = None
        self.declVisitor = DeclSymbolTableVisitor(name + "_ConfDeclVisit")

    @property
    def symbolTable(self) -> SymbolTable:
        return self._symbolTable

    def defaultResult(self) -> SymbolTable:
        return self._symbolTable

    # Visit a parse tree produced by DeclarationParser#paramAssignStat.
    # 'def' name=ID type=paramType ':' unit=unitSpecification (',' description=STRING)? ('=' defaultValue=arithmeticExpression)?
    def visitParameterAssign(self, ctx: ConfigurationParser.ParameterAssign):
        
        # define the given Parameter
        varName = ctx.name.text # set and get the variable name here
        unit = self.visit(ctx.unit)
        description = ctx.description.text
        scope = self._symbolTable.addNewSymbolOfType(VariableSymbol, varName, description, ctx, unit)
        # TODO backlog add description as comment to SymbolTable?
        return scope
    
    def visitParamGroup(self, ctx: ConfigurationParser.ParamGroup):
        pass

    def visitUnitSpec(self, ctx : ConfigurationParser.UnitSpec):
        return self.stringToUnitType(ctx.name.text)

    def visitFeatureConfig(self, ctx: ConfigurationParser.FeatureConfig):
        pass

    def visitFeatureActivate(self, ctx : ConfigurationParser.FeatureActivate):
        self._symbolTable.addSymbol(VariableSymbol(name= ctx.declaration, value=ctx, attached_unit=self.visitUnitSpec(ctx.unit)))

    def visitIncludeDecl(self, ctx: ConfigurationParser.includeDecl):
        self.declVisitor.visit(ctx)
        self.symbolTable.addDependencies(self.declVisitor.symbolTable)

    
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
