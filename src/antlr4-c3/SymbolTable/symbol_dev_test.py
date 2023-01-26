#!/usr/bin/env python3
__author__ = 'sgu'

import sys
import time
import types
from typing import Callable, Optional, ParamSpec, TypeVar, Generic, List

import asyncio

from antlr4 import TerminalNode
from antlr4.Token import CommonToken
from antlr4.tree.Tree import TerminalNodeImpl

from SymbolTable import Symbol, SymbolTable, NamespaceSymbol, ClassSymbol, InterfaceSymbol, FieldSymbol, MethodSymbol, \
    BlockSymbol, FundamentalType, VariableSymbol, LiteralSymbol

class Symbol:
    name : str

    def __init__(self, name : str = "", *args, **kwargs ):
        self.args = args
        self.kwargs = kwargs
        self.name = name


P = ParamSpec("P")

class Foobar:
    pass

class Bar(Foobar):

    def __init__(self, args: str = "", kwargs: str = "", name : str = "" ):
        self.args = args
        self.kwargs = kwargs

class Foo(Foobar):
    pass

T = TypeVar('T', bound=Symbol)

class ScopedSymbol(Symbol, Generic[T]):

    def __init__(self, name : str = "", *args, **kwargs ):
        super().__init__(name)
        self.args = args
        self.kwargs = kwargs




class SymbolTable(ScopedSymbol, Generic[T]):

    def addNewSymbolOfType(self, t: type, parent: ScopedSymbol = None, *my_args: P.args or None,
                           **my_kwargs: P.kwargs or None ) -> T:
        # ItemClass = self.__orig_bases__[0].__args__[0]
        result = t(*my_args, **my_kwargs)
        symbol = ScopedSymbol()
        if isinstance(symbol , type(result)):
            print("isinstance true")
        else:
            print("isinstance false")
        if issubclass(t , ScopedSymbol):
            print("issubclass true")
        else:
            print("issubclass false")
        if type(t) is ScopedSymbol:
            print("type true")
        else:
            print("type false")

        # if parent is None or parent is self:
        #     self.addSymbol(result)
        # else:
        #     parent.addSymbol(result)

        return result

async def recursive(n: int) -> str :
    if n > 0:
        return await recursive( n-1 )
    else:
        return ' done'

async def main():
    print(f"started at {time.strftime('%X')}")
    await recursive(10)
    print(f"finished at {time.strftime('%X')}")

if __name__ == "__main__":

    symbolTable = SymbolTable(Bar)
    parent = Foobar()

    scope = symbolTable.addNewSymbolOfType(ScopedSymbol, parent, "name", 'zero', 'one', 'two', zero = 'zeroArg', one = 'oneArg')

    result: List[T] = []

    print(scope)

    #########################################

    # print(sys.getrecursionlimit())
    asyncio.run(main())

    #########################################

    for x in range(3):
        print("We're on time %d" % (x))
