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

# class Symbol:
#     name : str
#
#     def __init__(self, name : str = "", *args, **kwargs ):
#         self.args = args
#         self.kwargs = kwargs
#         self.name = name
#
#
# P = ParamSpec("P")
#
# class Foobar:
#     pass
#
# class Bar(Foobar):
#
#     def __init__(self, args: str = "", kwargs: str = "", name : str = "" ):
#         self.args = args
#         self.kwargs = kwargs
#
# class Foo(Foobar):
#     pass

T = TypeVar('T', bound=Symbol)
    
# class ScopedSymbol(Symbol, Generic[T]):
#
#     def __init__(self, name : str = "", *args, **kwargs ):
#         super().__init__(name)
#         self.args = args
#         self.kwargs = kwargs
#
#
#
#
# class SymbolTable(ScopedSymbol, Generic[T]):
#
#     def addNewSymbolOfType(self, t: type, parent: ScopedSymbol = None, *my_args: P.args or None,
#                            **my_kwargs: P.kwargs or None ) -> T:
#         # ItemClass = self.__orig_bases__[0].__args__[0]
#         result = t(*my_args, **my_kwargs)
#         symbol = ScopedSymbol()
#         if isinstance(symbol , type(result)):
#             print("isinstance true")
#         else:
#             print("isinstance false")
#         if issubclass(t , ScopedSymbol):
#             print("issubclass true")
#         else:
#             print("issubclass false")
#         if type(t) is ScopedSymbol:
#             print("type true")
#         else:
#             print("type false")
#
#         # if parent is None or parent is self:
#         #     self.addSymbol(result)
#         # else:
#         #     parent.addSymbol(result)
#
#         return result

# dummyNode: TerminalNode = TerminalNodeImpl(CommonToken(-2, "Dummy", None, 0, 10, 20))

dummyNode: TerminalNode = TerminalNodeImpl(CommonToken((None, None), -2, 0, 10, 20))


async def createClassSymbolTable(name: str, counts: List[int], namespaces: Optional[List[str]] = None) -> SymbolTable:
    symbolTable = SymbolTable(name, False)

    nsSymbols: List[Optional[NamespaceSymbol]] = [None]
    nsIndex = 0
    nsCount = 1
    if namespaces is not None and len(namespaces) > 0:
        nsCount = len(namespaces)
        for i in range(nsCount):
            nsSymbols.append(symbolTable.addNewNamespaceFromPath(None, namespaces[i]))

    for i in range(counts[0]):
        classSymbol = symbolTable.addNewSymbolOfType(ClassSymbol, nsSymbols[nsIndex], 'class%s' % i, [], [])
        interfaceSymbol = symbolTable.addNewSymbolOfType(InterfaceSymbol, None, 'interface%s' % i, [])

        for j in range(counts[2]):
            symbolTable.addNewSymbolOfType(FieldSymbol, classSymbol, 'field%s' % j)
            symbolTable.addNewSymbolOfType(FieldSymbol, interfaceSymbol, 'field%s' % j)

        for j in range(counts[1]):
            method = symbolTable.addNewSymbolOfType(MethodSymbol, classSymbol, 'method%s' % j)
            symbolTable.addNewSymbolOfType(MethodSymbol, interfaceSymbol, 'method%s' % j)

            # Blocks are created and added in an alternative way (only for classes).
            block1 = symbolTable.addNewSymbolOfType(BlockSymbol, None, 'block1') # Block at top level.
            symbolTable.addNewSymbolOfType(VariableSymbol, block1, "var1", 17, FundamentalType.integerType)
            block2 = symbolTable.addNewSymbolOfType(BlockSymbol, None, 'block2')
            symbol = symbolTable.addNewSymbolOfType(VariableSymbol, block2, 'var1', 3.142, FundamentalType.floatType)
            if j == 1:
                symbol.context == dummyNode

            # Now move the blocks from global level to the method.
            method.addSymbol(block1)
            method.addSymbol(block2)

        nsIndex += 1
        if nsIndex == nsCount:
            nsIndex = 0

    for i in range(counts[3]):
        symbolTable.addNewSymbolOfType(VariableSymbol, None, 'globalVar%s' % i, 42, FundamentalType.integerType)

    for i in range(counts[4]):
        symbolTable.addNewSymbolOfType(LiteralSymbol, None, 'globalConst%s' % i, "string constant", FundamentalType.stringType)

    return symbolTable

async def recursive(n: int) -> str :
    if n > 0:
        return await recursive( n-1 )
    else:
        return ' done'

async def main():
    print(f"started at {time.strftime('%X')}")
    print(await createClassSymbolTable("main", [3, 3, 4, 5, 5]))
    print(f"finished at {time.strftime('%X')}")

if __name__ == "__main__":

    # symbolTable = SymbolTable(Bar)
    # parent = Foobar()
    #
    # scope = symbolTable.addNewSymbolOfType(ScopedSymbol, parent, "name", 'apple', 'banana', 'cabbage', apple = 'fruit', cabbage = 'vegetable')
    #
    # result: List[T] = []
    #
    # print(scope)

    #########################################

    dummyNode.text = 'Dummy'

    # print(sys.getrecursionlimit())
    asyncio.run(main())

    #########################################

    for x in range(3):
        print("We're on time %d" % (x))
