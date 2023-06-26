"""This visitor collects variables and nodes in a SymbolTable."""

__author__ = 'stu90642'

# util imports
from typing import TypeVar, Generic, Dict, Optional, Callable, Any

from bgc-dsl.bgcLSPServer.gen.python.BgcDsl.BgcDslParser import BgcDslParser

from bgc-dsl.bgcLSPServer.gen.python.BgcDsl.BgcDslParser import BgcDslParser

from bgc-dsl.bgcLSPServer.gen.python.BgcDsl.BgcDslParser import BgcDslParser

from bgc-dsl.bgcLSPServer.gen.python.BgcDsl.BgcDslParser import BgcDslParser

# antlr4
from antlr4.tree.Tree import ParseTree

# user relative imports
from ..symbolTable.SymbolTable import (ScopedSymbol, SymbolTable, P, T, VariableSymbol, RoutineSymbol, 
                                       SymbolTableOptions, UnitSymbol, FundamentalUnit, FundamentalType
                                       )
from ..gen.python.BgcDsl.BgcDslParser import BgcDslParser
from ..gen.python.BgcDsl.BgcDslVisitor import BgcDslVisitor


class SymbolTableVisitor( BgcDslVisitor, Generic[T] ):
    _symbolTable: SymbolTable

    def __init__(self, name: str = '', ):
        super().__init__()
        self._symbolTable = SymbolTable( name, SymbolTableOptions( False ) )
        # TODO scope marker
        # self._scope = self._symbolTable.addNewSymbolOfType( ScopedSymbol, None )
        self._scope = None

    @property
    def symbolTable(self) -> SymbolTable:
        return self._symbolTable

    def defaultResult(self) -> SymbolTable:
        return self._symbolTable


    

    def visitArithmeticExpression(self, ctx: BgcDslParser.ArithmeticExpressionContext):
        return super().visitArithmeticExpression(ctx)
    

    def visitUnit(self, ctx:BgcDslParser.UnitContext):
        element=self.visit(ctx.unitElement)
        element_node = self.visitUnitElement(element)
        return FundamentalUnit(ctx.)

    def visitUnitElement(self, ctx: BgcDslParser.UnitElementContext):
        prefix = self.visit(ctx.prefixUnit)
        group = self.visit(ctx.groupUnit)

        prefix_ctx = self.visitPrefixUnit(prefix)
        group_ctx = self.visitGroupUnit(group)

        return super().visitUnitElement(ctx)
    
    def visitPrefixUnit(self, ctx: BgcDslParser.PrefixUnitContext):
         prefix = extract_prefix(ctx.UNIT_STRING.txt)
         unit = extract_unit(ctx.UNIT_STRING.txt)
         return FundamentalUnit(ctx, unit_name, []. )
    
    def stringToPrefix(input : str):
        for prefix in UnitPrefix:
            if vars(prefix)["_name_"].lower() == input.lower():
                return prefix
        return UnitPrefix.NoP
    
    
    def stringToUnitType(input : str):
        for kind in UnitKind:
            if vars(kind)["_name_"].lower() == input.lower():
                return kind
        return UnitKind.Unknown


    def visitGroupUnit(self, ctx: BgcDslParser.GroupUnitContext):
        return super().visitGroupUnit(ctx)

    # Visit a parse tree produced by BgcDslParser#substanceDeclaration.
    def visitSubstanceDeclaration(self, ctx:BgcDslParser.SubstanceDeclarationContext):
        # TODO
        # save type
        # save unit as node
        unit =self.visit(ctx.unit)
        ctx.
        unit_node = self.visit_unit(unit)
        self._symbolTable.addNewSymbolOfType( VariableSymbol, self._scope, ctx.name, ctx=None, unit=unit_node, type=ctx.type_)
        return self.visitChildren( ctx )

    def visitParameterDeclaration(self, ctx:BgcDslParser.ParameterDeclarationContext):
        # TODO
        # save type
        # save unit, expression as node
        ctx.ID
        unit = ctx.unit()
        unit_node = self.visit_unit()
        expr = ctx.arithmeticExpression()
        expr_node = self.visit_arithmeticExpression()
        self._symbolTable.addNewSymbolOfType( VariableSymbol, self._scope, ctx.name.text, ctx )
        return self.visitChildren( ctx )

    def visitEnvironmentVariableDeclaration(self, ctx:BgcDslParser.EnvironmentVariableDeclarationContext):
        # TODO
        # save type
        # save unit, expression as node
        self._symbolTable.addNewSymbolOfType( VariableSymbol, self._scope, ctx, ctx.name, ctx )
        return self.visitChildren( ctx )

    # Visit a parse tree produced by BgcDslParser#compartment.
    def visitCompartment(self, ctx:BgcDslParser.CompartmentContext):
        # TODO
        # save node as expression
        self._symbolTable.addNewSymbolOfType( VariableSymbol, self._scope, ctx.name.text, ctx )
        return self.visitChildren(ctx)

    # Visit a parse tree produced by BgcDslParser#connection.
    def visitConnection(self, ctx:BgcDslParser.ConnectionContext):
        # TODO
        # save name
        # save node as expression
        # the name needs to be more complex, here:
        name = ctx.name.text + ' from ' + ctx.sourceCompartment.text + ' to ' + ctx.targetCompartment.text
        self._symbolTable.addNewSymbolOfType( VariableSymbol, self._scope, name, ctx )
        return self.visitChildren(ctx)

    # def visitFuncExpr(self, ctx: TestGrammarParser.FuncExprContext):
    #     return self.withScope( ctx, RoutineSymbol, lambda: self.visitChildren( ctx ), ctx.ID().getText() )

    def withScope(self, tree: ParseTree, t: type, action: Callable, *my_args: P.args or None,
                  **my_kwargs: P.kwargs or None) -> T:
        scope = self._symbolTable.addNewSymbolOfType( t, self._scope, *my_args, **my_kwargs )
        scope.context = tree
        self._scope = scope
        try:
            return action()
        finally:
            self._scope = scope.parent()
