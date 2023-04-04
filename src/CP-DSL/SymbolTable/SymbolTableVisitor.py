from typing import TypeVar, Generic, Dict, Optional, Callable, Any

from antlr4.tree.Tree import ParseTree

from SymbolTable.SymbolTable import ScopedSymbol, SymbolTable, P, T, BlockSymbol, RoutineSymbol, SymbolTableOptions, ParameterSymbol
from Configuration.DeclarationParser import DeclarationParser
from Configuration.DeclarationVisitor import DeclarationVisitor


class SymbolTableVisitor( DeclarationVisitor, Generic[T] ):
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

    def visitParamAssignStat(self, ctx: DeclarationParser.ParamAssignStatContext):
        
        # define the given Parameter
        t = ParameterSymbol # set and get the type of param here
        varName = ctx.ID().getText() # set and get the variable name here
        
        scope = self._symbolTable.addNewSymbolOfType(t, self._scope, varName)
        scope.context = ctx
        self._scope = scope
        self._scope = scope.parent()
        return scope
        
    def visitParamGroupAssignStat(self, ctx: DeclarationParser.ParamGroupAssignStatContext):
        return self.withScope(ctx, BlockSymbol, lambda: self.visitChildren(ctx), ctx.ID().getText())
        
    def visitFeatureAssignStat(self, ctx: DeclarationParser.FeatureAssignStatContext):
        return self.withScope(ctx, RoutineSymbol, lambda: self.visitChildren(ctx), ctx.ID().getText())
        
    def visitFeatureGroupAssignStat(self, ctx: DeclarationParser.FeatureGroupAssignStatContext):
        return self.withScope(ctx, BlockSymbol, lambda: self.visitChildren(ctx), ctx.ID().getText())

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