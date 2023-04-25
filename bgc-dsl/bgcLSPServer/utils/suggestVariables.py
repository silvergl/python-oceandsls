"""computeTokenIndex module."""

__author__ = 'sgu'

# utils
import asyncio
import threading
from typing import List, ParamSpec

# antlr4
from antlr4 import ParserRuleContext

# user relative imports
from ..gen.python.BgcDsl.BgcDslParser import BgcDslParser

Top_levelContext = BgcDslParser.BgcModelContext
del BgcDslParser
from ..symbolTable.SymbolTable import SymbolTable, Symbol, ScopedSymbol, VariableSymbol
from .computeTokenIndex import TokenPosition

P = ParamSpec( 'P' )


class RunThread( threading.Thread ):
    def __init__(self, func, *args: P.args or None, **kwargs: P.kwargs or None):
        self.func = func
        self.args = args
        self.kwargs = kwargs
        self.result = None
        super().__init__()

    def run(self):
        self.result = asyncio.run( self.func( *self.args, **self.kwargs ) )


def run_async(func, *args: P.args or None, **kwargs: P.kwargs or None):
    try:
        loop = asyncio.get_running_loop()
    except RuntimeError:  # 'RuntimeError: There is no current event loop...'
        loop = None
    if loop and loop.is_running():
        thread = RunThread( func, *args, **kwargs )
        thread.start()
        thread.join()
        return thread.result

        # print('Async event loop already running. Adding coroutine to the event loop.')
        # tsk = loop.create_task(symbolTable.symbolWithContext( context ))
        # ^-- https://docs.python.org/3/library/asyncio-task.html#task-object
        # Optionally, a callback function can be executed when the coroutine completes
        # tsk.add_done_callback( lambda t: print(f'Task done with result={t.result()}  << return val of main()'))
    else:
        return asyncio.run( func( *args, **kwargs ) )


def getScope(context: ParserRuleContext, symbolTable: SymbolTable):
    if context is None:
        return None

    scope = run_async( symbolTable.symbolWithContext, context )

    if scope is not None:
        return scope
    else:
        return getScope( context.parentCtx, symbolTable )


def getAllSymbolsOfType(scope: ScopedSymbol, symbolType: type):
    symbols: List[Symbol] = run_async( scope.getSymbolsOfType, symbolType )
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
        symbols = run_async( symbolTable.getSymbolsOfType, VariableSymbol )

    variable = position.context
    while not isinstance( variable, Top_levelContext ) and variable.parentCtx is not None:
        variable = variable.parentCtx

    return filterTokens( position.text if variable is not None else '', list( map( lambda s: s.name, symbols ) ) )


def filterTokens(text: str, candidates: List[str]):
    if len( text.strip() ) == 0:
        return candidates
    else:
        return list( filter( lambda c: c.lower().startswith( text.lower() ), candidates ) )
