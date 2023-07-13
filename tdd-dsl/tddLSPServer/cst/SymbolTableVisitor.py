"""SymbolTableVisitor module."""

__author__ = 'sgu'

import os
import shutil
# util imports
from typing import Callable, Generic, List

# antlr4
from antlr4.tree.Tree import ParseTree

# user relative imports
from ..utils.suggestVariables import getAllSymbolsOfType
from ..fxca.util.FxtranUtils import filterXML, getFiles, writeDecorateSrcXml
from ..gen.python.TestSuite.TestSuiteParser import TestSuiteParser
from ..gen.python.TestSuite.TestSuiteVisitor import TestSuiteVisitor
from ..symbolTable.SymbolTable import BlockSymbol, FunctionSymbol, ModuleSymbol, ParameterSymbol, RoutineSymbol, ScopedSymbol, SymbolTable, SymbolTableOptions, VariableSymbol, P, T


class SymbolTableVisitor( TestSuiteVisitor, Generic[ T ] ):
    _symbolTable: SymbolTable
    _testPath: str

    def __init__( self, name: str = '', testWorkPath: str = 'tdd-dsl/output' ):
        super( ).__init__( )
        self._symbolTable = SymbolTable( name, SymbolTableOptions( False ) )
        # TODO scope marker
        # self._scope = self._symbolTable.addNewSymbolOfType( ScopedSymbol, None )
        self._scope = None
        self._testPath = testWorkPath

    @property
    def symbolTable( self ) -> SymbolTable:
        return self._symbolTable

    @property
    def testPath( self ) -> str:
        return self._testPath

    def defaultResult( self ) -> SymbolTable:
        return self._symbolTable

    # Visit a parse tree produced by TestSuiteParser#test_case.
    def visitTest_case( self, ctx: TestSuiteParser.Test_caseContext ):
        return self.withScope( ctx, False, BlockSymbol, lambda: self.visitChildren( ctx ), ctx.ID( ).getText( ) )

    # Visit a parse tree produced by TestSuiteParser#test_var.
    def visitTest_var( self, ctx: TestSuiteParser.Test_varContext ):
        # TODO add comment (symbolTable Class and instance)
        decl = self.visit( ctx.varDeclaration( ) )
        self._symbolTable.addNewSymbolOfType( VariableSymbol, self._scope, decl[ 0 ], ctx.value, decl[ 1 ], decl[ 2 ] )
        return self.visitChildren( ctx )

    # Visit a parse tree produced by TestSuiteParser#varDeclaration.
    def visitVarDeclaration( self, ctx: TestSuiteParser.VarDeclarationContext ):
        name = ctx.name.text
        varType = self.visit( ctx.type_ )
        keys = [ ]
        for key in ctx.keys:
            keys.append( key.keyword.text )
        return name, varType, keys

    # Visit a parse tree produced by TestSuiteParser#ref.
    def visitRef( self, ctx: TestSuiteParser.RefContext ):
        return self.visitChildren( ctx )

    # Visit a parse tree produced by TestSuiteParser#funRef.
    def visitFunRef( self, ctx: TestSuiteParser.FunRefContext ):
        name = ctx.ID( ).getText( )
        args = [ ]
        for arg in ctx.args:
            args.append( self.visit( arg ) )
        return name, args

    # Visit a parse tree produced by TestSuiteParser#varRef.
    def visitVarRef( self, ctx: TestSuiteParser.VarRefContext ):
        name = ctx.ID( ).getText( )
        return name

    # Visit a parse tree produced by TestSuiteParser#enm.
    def visitEnm( self, ctx: TestSuiteParser.EnmContext ):
        # TODO type ENUM
        return self.visitChildren( ctx )

    # Visit a parse tree produced by TestSuiteParser#array.
    def visitArray( self, ctx: TestSuiteParser.ArrayContext ):
        # TODO type ARRAY
        return self.visitChildren( ctx )

    # Save the source path to scan for existing variables
    def visitSrc_path( self, ctx: TestSuiteParser.Src_pathContext ):
        # Strip string terminals
        userPath: str = ctx.path.text.strip( '\'' )

        # TODO document
        # Update source directory
        # If the given path is an absolute path, then self._testPath is ignored and the joining is only the given path
        self._testPath: str = os.path.join( self._testPath, userPath )

    # Get rendered list of used modules
    def visitUse_modules( self, ctx: TestSuiteParser.Use_modulesContext ):

        # Add module symbols to symboltable for XML scope filter
        moduleSymbols: List[ ModuleSymbol ] = []
        for module in ctx.modules:
            self.visit(module)
        moduleSymbols = getAllSymbolsOfType( self._scope, ModuleSymbol )

        # TODO hc
        xmlPath = os.path.join( self._testPath, 'tmp' )
        # TODO hc
        # Write XML files
        writeDecorateSrcXml( self._testPath, xmlPath, '/home/sgu/IdeaProjects/fxtran/bin/fxtran' )  # /home/sgu/Documents/fxtran/bin/fxtran

        # TODO hc, specify modules
        # Get Fortran files
        xmlFiles = getFiles( xmlPath, "*.[fF]90.xml" )

        for path, filename in xmlFiles:
            # TODO add key for variables
            xmlElements = filterXML( os.path.join( path, filename ), True, moduleSymbols )

            # Add scopes
            for scopeType, scopeName, scopeArgs, parentScopes in xmlElements[ 1 ]:
                scopeSym: ScopedSymbol

                # Top level symbols are omitted as they are only filtered modules in the current test case.
                # Get scope from symboltable, add the scope if it does not exist
                if parentScopes:
                    scopeSym = self._scope.resolveSync( parentScopes )

                    match scopeType:
                        case 'module':
                            self._symbolTable.addNewSymbolOfType( ModuleSymbol, scopeSym, scopeName )
                        case 'subroutine':
                            currentScope = self._scope
                            self._scope = scopeSym
                            self.withScope( ctx, False, RoutineSymbol, lambda: list( map( lambda arg: self.addRoutineParams( arg ), scopeArgs ) ), scopeName )
                            self._scope = currentScope
                        case 'function':
                            currentScope = self._scope
                            self._scope = scopeSym
                            self.withScope( ctx, False, FunctionSymbol, lambda: list( map( lambda arg: self.addRoutineParams( arg ), scopeArgs ) ), scopeName )
                            self._scope = currentScope
                        case _:
                            # TODO Types?
                            continue

            # Add variables
            for variableName, variableType, variableScope in xmlElements[ 0 ]:
                # Get scope from symboltable
                # TODO differentiate same scopes in different files -> error as unclear scoping
                scopeSym: ScopedSymbol = self._scope.parent().resolveSync( variableScope )

                # TODO add value, convert type
                # Add the variable to the symboltable
                self._symbolTable.addNewSymbolOfType( VariableSymbol, scopeSym, variableName, None, variableType )
        try:
            # remove temporary xml files
            shutil.rmtree( xmlPath )
        except OSError as e:
            # TODO error
            print( "Error: %s - %s." % (e.filename, e.strerror) )


    # Visit a parse tree produced by TestSuiteParser#test_module.
    def visitTest_module( self, ctx: TestSuiteParser.Test_moduleContext ):
        return self.withScope( ctx, True, ModuleSymbol, lambda: self.visitChildren( ctx ), ctx.name.text )

    def addRoutineParams( self, paramName: str = None ):
        self._symbolTable.addNewSymbolOfType( ParameterSymbol, self._scope, paramName )

    def withScope( self, tree: ParseTree, above: bool, t: type, action: Callable, *my_args: P.args or None, **my_kwargs: P.kwargs or None ) -> T:
        """
        Add a scoped symbol to the symboltable and recursively add all symbols inside this scope the symboltable
        :param tree: Context of the scoped symbol
        :param above: Add scoped symbol above current scope
        :param t: Symbol type
        :param action: Lambda function to add children symbols to symboltable
        :param my_args: Arguments of symbol type
        :param my_kwargs: k_arguments of symbol type
        :return: Current scope
        """
        # Add scoped symbol to symboltable
        if above:
            scope = self._symbolTable.addNewSymbolOfType( t, self._scope.parent(), *my_args, **my_kwargs )
            scope.addSymbol( self._scope )
        else:
            scope = self._symbolTable.addNewSymbolOfType( t, self._scope, *my_args, **my_kwargs )
        scope.context = tree
        # Update Scope to the new symbol and save the old scope (mihgt be changed if scope is inserted above current scope)
        currentScope = self._scope
        self._scope = scope
        try:
            # Add children symbols inside this scope
            return action( )
        finally:
            # Restore to scope of newly added scoped symbol
            self._scope = currentScope
