"""Visitor extracting system file information from the cst"""

__author__ = 'sgu'

import os
# util imports
from typing import Any, Callable, Generic, List

# antlr4
from antlr4.tree.Tree import ParseTree

# user relative imports
from ..fxca.util.FxtranUtils import getSubdirectoriesGen
from ..gen.python.TestSuite.TestSuiteParser import TestSuiteParser
from ..gen.python.TestSuite.TestSuiteVisitor import TestSuiteVisitor
from ..symbolTable.SymbolTable import SymbolTable, BlockSymbol, PathSymbol, SymbolTableOptions, P, T


class SystemFileVisitor( TestSuiteVisitor, Generic[ T ] ):
    _symbolTable: SymbolTable
    _testPath: str

    def __init__( self, name: str = '', testWorkPath: str = 'tdd-dsl/output' ):
        super( ).__init__( )
        self._symbolTable = SymbolTable( name, SymbolTableOptions( False ) )
        self._scope = None
        self._testPath = testWorkPath

    @property
    def testPath( self ) -> str:
        return self._testPath

    def defaultResult( self ) -> SymbolTable:
        return self._symbolTable

    # Visit a parse tree produced by TestSuiteParser#test_case.
    def visitTest_case( self, ctx: TestSuiteParser.Test_caseContext ):
        return self.withScope( ctx, BlockSymbol, lambda: self.visitChildren( ctx ), ctx.ID( ).getText( ) )

    # Return subdirectories under working path or user entered path
    def visitSrc_path( self, ctx: TestSuiteParser.Src_pathContext ):
        # Strip string terminals
        userPath: str = ctx.path.text.strip( '\'' )
        # candidates = list( map( lambda c: f"{os.sep}{c}" , candidates ) )

        # Remove incomplete basename from path
        if not userPath.endswith( os.sep ):
            userPath = userPath.rpartition( "/" )[ 0 ]

        # TODO document
        # Update source directory
        # If the given path is an absolute path, then self._testPath is ignored and the joining is only the given path
        self._testPath: str = os.path.join( self._testPath, userPath )

        # TODO document
        # get direct subdirectories without following symlinks or directories starting with '.'
        subDirectories = getSubdirectoriesGen( self._testPath, False, False )

        # Add subdirectories under current scope to symboltable
        for subDirectory in subDirectories:
            # Filter subdirectory path to be relative to user path
            relSubUserPath = os.path.relpath( subDirectory.path, userPath )
            self._symbolTable.addNewSymbolOfType( PathSymbol, self._scope, subDirectory.name, relSubUserPath )

    def withScope( self, tree: ParseTree, t: type, action: Callable, *my_args: P.args or None, **my_kwargs: P.kwargs or None ) -> T:
        scope = self._symbolTable.addNewSymbolOfType( t, self._scope, *my_args, **my_kwargs )
        scope.context = tree
        self._scope = scope
        try:
            return action( )
        finally:
            self._scope = scope.parent( )
