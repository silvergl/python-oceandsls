import asyncio
import os, sys, time
from typing import List, Optional
from unittest import IsolatedAsyncioTestCase

from antlr4 import TerminalNode
from antlr4.Token import CommonToken
from antlr4.tree.Tree import TerminalNodeImpl

from SymbolTable import SymbolTable, NamespaceSymbol, ClassSymbol, InterfaceSymbol, FieldSymbol, MethodSymbol, \
    BlockSymbol, VariableSymbol, FundamentalType, LiteralSymbol, DuplicateSymbolError, ScopedSymbol

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

# async def symTable() -> SymbolTable:
#     '''
#     pre 3.8 async def and await syntax for call asyncio.run(symTable())
#
#     :return:
#     '''
#     print(f"started at {time.strftime('%X')}")
#     result = await createClassSymbolTable("main", [3, 3, 4, 5, 5])
#     print(f"finished at {time.strftime('%X')}")
#     return result

class SymbolTableTest( IsolatedAsyncioTestCase ):
    async def asyncSetUp(self) -> None:
        dummyNode.text = 'Dummy'

        self.symbolTable: SymbolTable = await createClassSymbolTable("main", [3, 3, 4, 5, 5])
        self.info = self.symbolTable.info()

    async def test_Single_table_base(self):
        self.assertEqual(self.info.dependencyCount, 0)
        self.assertEqual(self.info.symbolCount, 16) # 5 + 5 top level symbols + 3 classes + 3 interfaces.

        with self.assertRaises(DuplicateSymbolError) as ctx:
            self.symbolTable.addNewSymbolOfType(VariableSymbol, None, "globalVar3")
        self.assertEqual(ctx.exception.args[0]["message"], "Attempt to add duplicate symbol 'globalVar3'")

        class1 = await self.symbolTable.resolve("class1")
        self.assertIsInstance(class1, ClassSymbol)
        method2 = await class1.resolve("method2")
        self.assertIsInstance(method2, MethodSymbol)
        scopes = await method2.directScopes()
        self.assertEqual(len(scopes),2) # 2 anonymous blocks.
        block1 = scopes[0]
        self.assertIsInstance(block1,ScopedSymbol)

        with self.assertRaises(DuplicateSymbolError) as ctx:
            duplicateMethod = self.symbolTable.addNewSymbolOfType(MethodSymbol, None, "method2")
            class1.addSymbol(duplicateMethod) # Must throw.
        self.assertEqual(ctx.exception.args[0]["message"], "Attempt to add duplicate symbol 'method2'")

        variable = await block1.resolve("globalVar3") # Resolves to the global var 3.
        self.assertIsInstance(variable, VariableSymbol)
        self.assertEqual(variable.root(), self.symbolTable)

        variable = await block1.resolve("globalVar3", True) # Try only local vars.

        self.assertEqual(variable, None)
        
        variable = await block1.resolve("var1") # Now resolves to local var.
        self.assertEqual(variable.root(),class1)
        self.assertEqual(variable.getParentOfType(MethodSymbol),method2)
        
        methods = await class1.getSymbolsOfType(MethodSymbol)
        self.assertEqual(len(methods),3)
        symbols = await method2.getSymbolsOfType(ScopedSymbol)
        self.assertEqual(len(symbols),2)
        self.assertEqual(await block1.resolve("class1", False),class1)
        
        symbolPaths = variable.symbolPath()
        self.assertEqual(len(symbolPaths),5)
        self.assertEqual(symbolPaths[0].name,"var1")
        self.assertEqual(symbolPaths[1].name,"block1")
        self.assertEqual(symbolPaths[2].name,"method2")
        self.assertEqual(symbolPaths[3].name,"class1")
        self.assertEqual(symbolPaths[4].name,"main")
        
        self.assertEqual(method2.qualifiedName(),"class1.method2")
        self.assertEqual(method2.qualifiedName("-", True),"main-class1-method2")
        self.assertEqual(variable.qualifiedName(),"block1.var1")
        self.assertEqual(variable.qualifiedName("#"),"block1#var1")
        self.assertEqual(variable.qualifiedName(".", False, True),"block1.var1")
        self.assertEqual(variable.qualifiedName(".", True, False),"main.class1.method2.block1.var1")
        self.assertEqual(variable.qualifiedName(".", True, True),"main.class1.method2.block1.var1")
        
        allSymbols = await self.symbolTable.getAllNestedSymbols()
        self.assertEqual(len(allSymbols),94)
        
        symbolPath = allSymbols[59].qualifiedName(".", True)
        self.assertEqual(symbolPath,"main.class1.method2.block1.var1")
        
        foundSymbol = self.symbolTable.symbolFromPath("main.class2.method0.block2.var1")
        self.assertEqual(foundSymbol,allSymbols[78])
        
        self.assertEqual(self.symbolTable, self.symbolTable.symbolTable())