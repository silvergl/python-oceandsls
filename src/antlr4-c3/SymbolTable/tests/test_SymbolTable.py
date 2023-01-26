import asyncio
import os, sys, time
from typing import List, Optional
from unittest import TestCase

from antlr4 import TerminalNode
from antlr4.Token import CommonToken
from antlr4.tree.Tree import TerminalNodeImpl

from SymbolTable import SymbolTable, NamespaceSymbol, ClassSymbol, InterfaceSymbol, FieldSymbol, MethodSymbol, \
    BlockSymbol, VariableSymbol, FundamentalType, LiteralSymbol, DuplicateSymbolError

if not os.path.join( sys.path[0], 'build-python' ) in sys.path:
    sys.path.append( os.path.join( sys.path[0], 'build-python' ) )

dummyNode: TerminalNode = TerminalNodeImpl( CommonToken( (None, None), -2, 0, 10, 20 ) )


async def createClassSymbolTable(name: str, counts: List[int], namespaces: Optional[List[str]] = None) -> SymbolTable:
    symbolTable = SymbolTable( name, False )

    nsSymbols: List[Optional[NamespaceSymbol]] = [None]
    nsIndex = 0
    nsCount = 1
    if namespaces is not None and len( namespaces ) > 0:
        nsCount = len( namespaces )
        for i in range( nsCount ):
            nsSymbols.append( symbolTable.addNewNamespaceFromPath( None, namespaces[i] ) )

    for i in range( counts[0] ):
        classSymbol = symbolTable.addNewSymbolOfType( ClassSymbol, nsSymbols[nsIndex], 'class%s' % i, [], [] )
        interfaceSymbol = symbolTable.addNewSymbolOfType( InterfaceSymbol, None, 'interface%s' % i, [] )

        for j in range( counts[2] ):
            symbolTable.addNewSymbolOfType( FieldSymbol, classSymbol, 'field%s' % j )
            symbolTable.addNewSymbolOfType( FieldSymbol, interfaceSymbol, 'field%s' % j )

        for j in range( counts[1] ):
            method = symbolTable.addNewSymbolOfType( MethodSymbol, classSymbol, 'method%s' % j )
            symbolTable.addNewSymbolOfType( MethodSymbol, interfaceSymbol, 'method%s' % j )

            # Blocks are created and added in an alternative way (only for classes).
            block1 = symbolTable.addNewSymbolOfType( BlockSymbol, None, 'block1' )  # Block at top level.
            symbolTable.addNewSymbolOfType( VariableSymbol, block1, "var1", 17, FundamentalType.integerType )
            block2 = symbolTable.addNewSymbolOfType( BlockSymbol, None, 'block2' )
            symbol = symbolTable.addNewSymbolOfType( VariableSymbol, block2, 'var1', 3.142, FundamentalType.floatType )
            if j == 1:
                symbol.context == dummyNode

            # Now move the blocks from global level to the method.
            method.addSymbol( block1 )
            method.addSymbol( block2 )

        nsIndex += 1
        if nsIndex == nsCount:
            nsIndex = 0

    for i in range( counts[3] ):
        symbolTable.addNewSymbolOfType( VariableSymbol, None, 'globalVar%s' % i, 42, FundamentalType.integerType )

    for i in range( counts[4] ):
        symbolTable.addNewSymbolOfType( LiteralSymbol, None, 'globalConst%s' % i, "string constant",
                                        FundamentalType.stringType )

    return symbolTable

async def main() -> SymbolTable:
    return await createClassSymbolTable("main", [3, 3, 4, 5, 5])

class SymbolTableTest( TestCase ):
    def setUp(self) -> None:
        dummyNode.text = 'Dummy'

        # print(f"started at {time.strftime('%X')}")
        self.symbolTable: SymbolTable = asyncio.run(main())
        # print(f"finished at {time.strftime('%X')}")

        self.info = self.symbolTable.info()

    def test_Single_table_base(self):
        self.assertEqual(self.info.dependencyCount, 0)
        self.assertEqual(self.info.symbolCount, 16) # 5 + 5 top level symbols + 3 classes + 3 interfaces.

        try:
            self.symbolTable.addNewSymbolOfType(VariableSymbol, None, "globalVar3")
            self.assertFalse( True, 'Test 3')
        except Exception as err:
            if isinstance(err, DuplicateSymbolError):
                self.assertEqual(err.msg, "Attempt to add duplicate symbol 'globalVar3'")
            else:
                self.assertFalse( True, 'Test 3')
