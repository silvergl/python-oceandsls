"""SymbolTable example"""

__author__ = 'sgu'

# utils
import sys
import time
import types
from typing import Callable, Optional, ParamSpec, TypeVar, Generic, List, Set
import asyncio

# antlr4
from antlr4 import TerminalNode
from antlr4.Token import CommonToken
from antlr4.tree.Tree import TerminalNodeImpl

# user relative imports
from ..symboltable.symbol_table import Symbol, SymbolTable, NamespaceSymbol, ClassSymbol, InterfaceSymbol, FieldSymbol, \
    MethodSymbol, BlockSymbol, FundamentalType, VariableSymbol, LiteralSymbol, ScopedSymbol, SymbolTableOptions, \
    UnitSymbol, FundamentalUnit, UnitPrefix, UnitKind

# class Symbol:
#     name: str
#
#     def __init__(self, name: str = "", *args, **kwargs):
#         self.args = args
#         self.kwargs = kwargs
#         self.name = name


P = ParamSpec("P")


class Foobar:
    def addSymbol(self, *my_args: P.args or None, **my_kwargs: P.kwargs or None):
        pass

    pass


class Bar(Foobar):

    def __init__(self, args: str = "", kwargs: str = "", name: str = ""):
        self.args = args
        self.kwargs = kwargs


class Foo(Foobar):
    pass


T = TypeVar('T', bound=Symbol)


# class ScopedSymbol( Symbol, Generic[T] ):
#
#     def __init__(self, name: str = "", *args, **kwargs):
#         super().__init__( name )
#         self.args = args
#         self.kwargs = kwargs
#
#
# class SymbolTable( ScopedSymbol, Generic[T] ):
#
#     def addNewSymbolOfType(self, t: type, parent: ScopedSymbol = None, *my_args: P.args or None,
#                            **my_kwargs: P.kwargs or None) -> T:
#         # ItemClass = self.__orig_bases__[0].__args__[0]
#         result = t( *my_args, **my_kwargs )
#         symbol = ScopedSymbol()
#         if isinstance( symbol, type( result ) ):
#             print( "isinstance true" )
#         else:
#             print( "isinstance false" )
#         if issubclass( t, ScopedSymbol ):
#             print( "issubclass true" )
#         else:
#             print( "issubclass false" )
#         if type( t ) is ScopedSymbol:
#             print( "type true" )
#         else:
#             print( "type false" )
#
#         # if parent is None or parent is self:
#         #     self.addSymbol(result)
#         # else:
#         #     parent.addSymbol(result)
#
#         return result


async def recursive(n: int) -> str:
    if n > 0:
        return await recursive(n - 1)
    else:
        return ' done'


async def main():
    print(f"started at {time.strftime( '%X' )}")
    await recursive(10)
    print(f"finished at {time.strftime( '%X' )}")


async def asyncWrapper(t: Callable, *my_args: P.args or None, **my_kwargs: P.kwargs or None):
    '''
    pre 3.8 async def and await syntax for call asyncio.run()

    :return:
    '''
    return await t(*my_args, **my_kwargs)


def getAllSymbolsOfType(scope: ScopedSymbol, symbolType: type):
    # symbols: List[Symbol] = asyncio.run( asyncWrapper( scope.getSymbolsOfType, symbolType ) )
    symbols: List[Symbol] = asyncio.run(scope.get_symbols_of_type(symbolType))
    parent = scope.parent()
    while parent is not None and not isinstance(parent, ScopedSymbol):
        parent = parent.parent()
    if parent is not None:
        symbols.extend(getAllSymbolsOfType(parent, symbolType))
    return symbols


if __name__ == "__main__":
    # symbolTable = SymbolTable( Bar, SymbolTableOptions( False ) )
    # parent = Foobar()
    #
    # scope = symbolTable.addNewSymbolOfType( ScopedSymbol, parent, "my_name")
    # # scope = symbolTable.addNewSymbolOfType( ScopedSymbol, parent, "name", 'zero', 'one', 'two', zero='zeroArg',
    #
    # result: List[T] = []
    #
    # print( scope )

    #########################################

    # print(sys.getrecursionlimit())
    # asyncio.run( main() )

    #########################################

    # result = getAllSymbolsOfType( ScopedSymbol( "foo" ), VariableSymbol )

    #########################################

    # for x in range( 3 ):
    #     print( "We're on time %d" % (x) )

    #########################################

    # preferredRules: Set[int] = set([1])
    #
    # # preferredRules = {2}
    #
    # # preferredRules.add(False)
    #
    # # PEP 8 https://peps.python.org/pep-0008/
    # if not preferredRules:
    #     print ("preferredRules is empty")
    # else:
    #     print ("preferredRules is not empty %s" % preferredRules)
    #
    #     print(type(preferredRules))
    #
    #     for i in preferredRules:
    #         print(i)
    #
    # # explicit plus type error
    # if len(preferredRules) == 0:
    #     print ("preferredRules is empty")
    # else:
    #     print ("preferredRules is not empty")

    #########################################

    # Test singleton

    integerType = FundamentalType.integerType

    secondUnit = FundamentalUnit.secondUnit

    custom_kilogram = FundamentalUnit(name="my_kilogram", unitPrefix=UnitPrefix.Kilo, unitKind=UnitKind.Gram)

    #########################################

    l1 = [1, 2, 3, 4]
    l2 = [2, 7]

    print(any(x in l1 for x in l2))

    for x in l2:
        print("%d in l1 %s" % (x, x in l1))
