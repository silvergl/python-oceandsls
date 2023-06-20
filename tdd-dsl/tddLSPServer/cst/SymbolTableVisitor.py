"""SymbolTableVisitor module."""

__author__ = 'sgu'

import os
# util imports
from typing import Callable, Generic

# antlr4
from antlr4.tree.Tree import ParseTree

# user relative imports
from ..fxca.util.FxtranUtils import filterXML, getFiles, writeDecorateSrcXml
from ..gen.python.TestSuite.TestSuiteParser import TestSuiteParser
from ..gen.python.TestSuite.TestSuiteVisitor import TestSuiteVisitor
from ..symbolTable.SymbolTable import BlockSymbol, P, ScopedSymbol, SymbolTable, SymbolTableOptions, T, VariableSymbol


class SymbolTableVisitor( TestSuiteVisitor, Generic[ T ] ):
    _symbolTable: SymbolTable
    testPath: str

    def __init__( self, name: str = '', testWorkPath: str = 'tdd-dsl/output' ):
        super( ).__init__( )
        self._symbolTable = SymbolTable( name, SymbolTableOptions( False ) )
        # TODO scope marker
        # self._scope = self._symbolTable.addNewSymbolOfType( ScopedSymbol, None )
        self._scope = None
        self.testPath = testWorkPath

    @property
    def symbolTable( self ) -> SymbolTable:
        return self._symbolTable

    def defaultResult( self ) -> SymbolTable:
        return self._symbolTable

    # Visit a parse tree produced by TestSuiteParser#test_case.
    def visitTest_case( self, ctx: TestSuiteParser.Test_caseContext ):
        return self.withScope( ctx, BlockSymbol, lambda: self.visitChildren( ctx ), ctx.ID( ).getText( ) )

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

    # Save the source path to scan for existing variables
    def visitSrc_path( self, ctx: TestSuiteParser.Src_pathContext ):
        # Strip string terminals
        # TODO document
        # If the given path is an absolute path, then self.testPath is ignored and the joining is only the given path
        self.testPath = os.path.join( self.testPath, ctx.path.text.strip( '\'' ) )

    # Get rendered list of used modules
    def visitUse_modules( self, ctx: TestSuiteParser.Use_modulesContext ):
        # TODO hc
        xmlPath = os.path.join( self.testPath, 'tmp' )
        # TODO hc
        # Write XML files
        writeDecorateSrcXml( self.testPath, xmlPath, '/home/sgu/IdeaProjects/fxtran/bin/fxtran' )

        # TODO hc, specify modules
        # Get Fortran files
        xmlFiles = getFiles( xmlPath, "*.[fF]90.xml" )

        for path, filename in xmlFiles:
            variables = filterXML( os.path.join( path, filename ), True )
            for variable, variable_type, scope in variables:
                # Get scope from symboltable, add the scope if it does not exist
                scopeSym: ScopedSymbol = self._symbolTable.resolveSync( scope )
                if scopeSym is None:
                    # Set Module scope as enclosing scope
                    scopeSym = self._symbolTable.addNewSymbolOfType( BlockSymbol, self._scope.parent(), scope )
                    scopeSym.addSymbol(self._scope)

                # TODO add value, convert type
                # Add the variable to the symboltable
                self._symbolTable.addNewSymbolOfType( VariableSymbol, scopeSym, variable, None, variable_type )

        # TODO Debug
        # Print the list of variable names with their respective types and scopes
        # for variable, variable_type, scope in variables:
        #     print( f"Variable: {variable}\t Type: {variable_type}\t Scope: {scope}" )

        return self.visitChildren( ctx )

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
