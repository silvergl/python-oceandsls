from typing import TypeVar, Generic, Dict, Optional, Callable, Any

from antlr4.tree.Tree import ParseTree

from SymbolTable.SymbolTable import ScopedSymbol, SymbolTable, P, T, VariableSymbol, RoutineSymbol
from TestGrammar.TestGrammarParser import TestGrammarParser
from TestGrammar.TestGrammarVisitor import TestGrammarVisitor


class SymbolTableVisitor( TestGrammarVisitor, Generic[T] ):
    _symbolTable: SymbolTable

    def __init__(self, symbolTable: SymbolTable):
        super().__init__()
        self._symbolTable = symbolTable
        self._scope = self._symbolTable.addNewSymbolOfType( ScopedSymbol, None )

    @property
    def symbolTable(self) -> SymbolTable:
        return self._symbolTable

    def defaultResult(self) -> SymbolTable:
        return self._symbolTable

    def visitAssignStat(self, ctx: TestGrammarParser.AssignStatContext):
        self._symbolTable.addNewSymbolOfType( VariableSymbol, self._scope, ctx.ID() )
        return self.visitChildren(ctx)

    def visitFuncExpr(self, ctx: TestGrammarParser.FuncExprContext):
        return self.withScope( ctx, RoutineSymbol, self.visitChildren(ctx), [ctx.ID()] )

    def withScope(self, tree: ParseTree, t: type, action: Callable, *my_args: P.args or None,
                  **my_kwargs: P.kwargs or None) -> T:
        scope = self._symbolTable.addNewSymbolOfType( t, self._scope, *my_args, **my_kwargs )
        scope.context = tree
        self._scope = scope
        try:
            return action()
        finally:
            self._scope = scope.parent()
