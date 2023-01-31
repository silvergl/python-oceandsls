from typing import List

from antlr4 import ParserRuleContext

from TestGrammar.TestGrammarParser import TestGrammarParser

StatContext = TestGrammarParser.StatContext
del TestGrammarParser

from SymbolTable.SymbolTable import SymbolTable, Symbol, ScopedSymbol, VariableSymbol, T
from utils.computeTokenIndex import TokenPosition


def getScope(context: ParserRuleContext, symbolTable: SymbolTable):
    if context is None:
        return None
    scope = symbolTable.symbolWithContext( context )
    if scope is not None:
        return scope
    else:
        return getScope( context.parentCtx, symbolTable )


def getAllSymbolsOfType(scope: ScopedSymbol, symbolType: type):
    symbols: List[Symbol] = await scope.getSymbolsOfType( symbolType )
    parent = scope.parent()
    while parent is not None and not isinstance( parent, ScopedSymbol ):
        parent = parent.parent()
    if parent is not None:
        symbols.extend( getAllSymbolsOfType( parent, symbolType ) )
    return symbols


def suggestVariables(symbolTable: SymbolTable, position: TokenPosition):
    context = position.context
    scope = getScope( context, symbolTable )
    symbols: List[Symbol]
    if isinstance( scope, ScopedSymbol ):  # Local scope
        symbols = getAllSymbolsOfType( scope, VariableSymbol )
    else:  # Global scope
        symbols = await symbolTable.getSymbolsOfType( VariableSymbol )

    variable = position.context
    while not isinstance( variable, StatContext ) and variable.parentCtx is not None:
        variable = variable.parentCtx

    return filterTokens( position.text if variable is not None else '', list( map( lambda s: s.name, symbols ) ) )


def filterTokens(text: str, candidates: List[str]):
    if len( text.strip() ) == 0:
        return candidates
    else:
        return filter( lambda c: c.lower().startswith( text.lower() ), candidates )
