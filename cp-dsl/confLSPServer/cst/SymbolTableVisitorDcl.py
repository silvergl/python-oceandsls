"""SymbolTableVisitor module."""

__author__ = 'stu222808'

# util imports
from typing import TypeVar, Generic, Dict, Optional, Callable, Any

# antlr4
from antlr4.tree.Tree import ParseTree

# user relative imports
from ..symbolTable.SymbolTable import SymbolTable, P, T, GroupSymbol, RoutineSymbol, SymbolTableOptions, VariableSymbol, FundamentalUnit, UnitPrefix, UnitKind
from ..gen.python.Declaration.DeclarationParser import DeclarationParser
from ..gen.python.Declaration.DeclarationVisitor import DeclarationVisitor


class SymbolTableVisitorDecl( DeclarationVisitor, Generic[T] ):
    _symbolTable: SymbolTable

    def __init__(self, name: str = '', ):
        super().__init__()
        # creates a new symboltable with no duplicate symbols
        self._symbolTable = SymbolTable( name, SymbolTableOptions( False ) )
        # TODO scope marker
        # self._scope = self._symbolTable.addNewSymbolOfType( ScopedSymbol, None )
        self._scope = None

    @property
    def symbolTable(self) -> SymbolTable:
        return self._symbolTable

    def defaultResult(self) -> SymbolTable:
        return self._symbolTable

    # Visit a parse tree produced by DeclarationParser#paramAssignStat.
    # 'def' name=ID type=paramType ':' unit=unitSpecification (',' description=STRING)? ('=' defaultValue=arithmeticExpression)?
    def visitParamAssignStat(self, ctx:DeclarationParser.ParamAssignStatContext):
        
        # define the given Parameter
        varName = ctx.name.text if ctx.name else "" # set and get the variable name here
        unit = self.visit(ctx.unit)
        description = ctx.description.text if ctx.description else ""
        scope = self._symbolTable.addNewSymbolOfType(VariableSymbol, self._scope, varName, description, ctx, unit)
        # TODO backlog add description as comment to SymbolTable?
        return scope
    
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
    
    # sIUnit                      :   (prefix=ePrefix)? type=eSIUnitType #siUnit; 
    def visitSiunit(self, ctx:DeclarationParser.SIUnitContext):
        return FundamentalUnit(name = ctx.type.text if ctx.type.text else "", unitPrefix = self.stringToPrefix(ctx.prefix.text if ctx.prefix else ""), unitKind = self.stringToUnitType(ctx.type.text if ctx.type else ""))
    
    # customUnit                  :   name=STRING #customunit;
    def visitCustomunit(self, ctx:DeclarationParser.customUnit):
        # TODO: Set Prefix and type in customUnit either
        return FundamentalUnit(name = ctx.name.text if ctx.name.text else "")
    
        
    def visitParamGroupAssignStat(self, ctx: DeclarationParser.ParamGroupAssignStatContext):
        description = ctx.description.text if ctx.description else ""
        return self.withScope(ctx, GroupSymbol, lambda: self.visitChildren(ctx), ctx.name.text if ctx.name else "", VariableSymbol, description)

    # CHANGES sgu:
    #   featureDeclaration ID is saved as attribute 'name'

    def visitFeatureAssignStat(self, ctx: DeclarationParser.FeatureAssignStatContext):
        return self.withScope(ctx, RoutineSymbol, lambda: self.visitChildren(ctx), ctx.name.text if ctx.name else "")

    def visitFeatureGroupAssignStat(self, ctx: DeclarationParser.FeatureGroupAssignStatContext):
        return self.withScope(ctx, GroupSymbol, lambda: self.visitChildren(ctx), "", RoutineSymbol, "")

    # def visitAssignStat(self, ctx: TestGrammarParser.AssignStatContext):
    #     self._symbolTable.addNewSymbolOfType( VariableSymbol, self._scope, ctx.ID().getText() )
    #     return self.visitChildren( ctx )

    # def visitFuncExpr(self, ctx: TestGrammarParser.FuncExprContext):
    #     return self.withScope( ctx, RoutineSymbol, lambda: self.visitChildren( ctx ), ctx.ID().getText() )
    
    def withScope(self, tree: ParseTree, t: type, action: Callable, *my_args: P.args or None,
                  **my_kwargs: P.kwargs or None) -> T:
        scope = self._symbolTable.addNewSymbolOfType( t, self._scope, *my_args, **my_kwargs )
        scope.context = tree
        self._scope = scope
        try:
            return action()
        finally:
            self._scope = scope.parent()
