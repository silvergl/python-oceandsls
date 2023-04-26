"""SymbolTableVisitor module."""

__author__ = 'sgu'

# util imports
from typing import Callable, Generic

# antlr4
from antlr4.tree.Tree import ParseTree

# user relative imports
from ..gen.python.TestSuite.TestSuiteParser import TestSuiteParser
from ..gen.python.TestSuite.TestSuiteVisitor import TestSuiteVisitor
from ..symbolTable.SymbolTable import P, SymbolTable, SymbolTableOptions, T, VariableSymbol


class SymbolTableVisitor( TestSuiteVisitor, Generic[ T ] ):
    _symbolTable: SymbolTable

    def __init__( self, name: str = '', ):
        super( ).__init__( )
        self._symbolTable = SymbolTable( name, SymbolTableOptions( False ) )
        # TODO scope marker
        # self._scope = self._symbolTable.addNewSymbolOfType( ScopedSymbol, None )
        self._scope = None

    @property
    def symbolTable( self ) -> SymbolTable:
        return self._symbolTable

    def defaultResult( self ) -> SymbolTable:
        return self._symbolTable

    # Visit a parse tree produced by TestSuiteParser#test_var.
    def visitTest_var( self, ctx: TestSuiteParser.Test_varContext ):
        # TODO add comment and type (symbolTable Class and instance)
        name = ctx.decl.name.text
        if ctx.value:
            self._symbolTable.addNewSymbolOfType( VariableSymbol, self._scope, name, ctx.value )
        else:
            self._symbolTable.addNewSymbolOfType( VariableSymbol, self._scope, name, )

        return self.visitChildren( ctx )

    # Visit a parse tree produced by TestSuiteParser#varDeclaration.
    def visitVarDeclaration( self, ctx: TestSuiteParser.VarDeclarationContext ):
        return ctx.name.text

    def withScope(
            self, tree: ParseTree, t: type, action: Callable, *my_args: P.args or None,
            **my_kwargs: P.kwargs or None
            ) -> T:
        scope = self._symbolTable.addNewSymbolOfType( t, self._scope, *my_args, **my_kwargs )
        scope.context = tree
        self._scope = scope
        try:
            return action( )
        finally:
            self._scope = scope.parent( )
