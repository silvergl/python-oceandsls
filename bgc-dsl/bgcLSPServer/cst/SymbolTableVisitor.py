"""SymbolTableVisitor module."""

__author__ = 'sgu'

# util imports
from typing import TypeVar, Generic, Dict, Optional, Callable, Any

# antlr4
from antlr4.tree.Tree import ParseTree

# user relative imports
from ..symbolTable.SymbolTable import ScopedSymbol, SymbolTable, P, T, VariableSymbol, RoutineSymbol, SymbolTableOptions
from ..gen.python.BgcDsl.BgcDslParser import BgcDslParser
from ..gen.python.BgcDsl.BgcDslVisitor import BgcDslVisitor


class SymbolTableVisitor( BgcDslVisitor, Generic[T] ):
    pass
