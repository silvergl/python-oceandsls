"""SymbolTableVisitor module."""

__author__ = 'stu222808'

# util imports
from typing import TypeVar, Generic, Dict, Optional, Callable, Any

# antlr4
from antlr4.tree.Tree import ParseTree
from antlr4.Token import CommonToken

from confLSPServer.gen.python.Declaration.DeclarationParser import DeclarationParser

# user relative imports
from ..symbolTable.SymbolTable import SymbolTable, P, T, GroupSymbol, FeatureSymbol, SymbolTableOptions, VariableSymbol, FundamentalUnit, UnitPrefix, UnitKind, EnumSymbol, ArraySymbol, RangeSymbol, ComposedUnit, UnitSpecification
from ..gen.python.Declaration.DeclarationParser import DeclarationParser
from ..gen.python.Declaration.DeclarationVisitor import DeclarationVisitor


class SymbolTableVisitorDecl( DeclarationVisitor, Generic[T] ):
    _symbolTable: SymbolTable

    def __init__(self, name: str = '', ):
        super().__init__()
        # creates a new symboltable with no duplicate symbols
        self._symbolTable = SymbolTable(name, SymbolTableOptions(False))
        # TODO scope marker
        # self._scope = self._symbolTable.addNewSymbolOfType( ScopedSymbol, None )
        self._scope = None
        self._enumIndex = 0

    @property
    def symbolTable(self) -> SymbolTable:
        return self._symbolTable

    def defaultResult(self) -> SymbolTable:
        return self._symbolTable

    # Visit a parse tree produced by DeclarationParser#paramAssignStat.
    # 'def' name=ID type=paramType ':' unit=unitSpecification (',' description=STRING)? ('=' defaultValue=arithmeticExpression)?
    def visitParamAssignStat(self, ctx:DeclarationParser.ParamAssignStatContext):
        
        # define the given Parameter
        varName = ctx.name.text if ctx.name else "" # set and get the variable name here
        unit = self.visit(ctx.unit)
        varType = self._scope.resolveSync(ctx.type_.getText())
        varType = varType if varType else self.visit(ctx.type_)
        description = ctx.description.text if ctx.description else ""
        # if it is a Array, it was already created, so no need for a variable Symbol
        if isinstance(varType, ArraySymbol):
            varType.name = ctx.name.text
            varType.unit = unit
            varType.context = ctx
            varType.description = description
            return varType
        symbol = self._symbolTable.addNewSymbolOfType(VariableSymbol, self._scope, varName, description, ctx, unit, varType)
        symbol.context = ctx
        return symbol
    
    def stringToPrefix(self, input : str):
            for prefix in UnitPrefix:
                if vars(prefix)["_name_"].lower() == input.lower():
                    return prefix
            return UnitPrefix.NoP
    
    
    def stringToUnitType(self, input : str):
        for kind in UnitKind:
            if vars(kind)["_name_"].lower() == input.lower():
                return kind
        return UnitKind.Unknown
    
    # sIUnit                      :   (prefix=ePrefix)? type=eSIUnitType #siUnit; 
    def visitSiunit(self, ctx:DeclarationParser.SIUnitContext):
        return FundamentalUnit(name = ctx.type_.getText() if ctx.type_ else "", unitPrefix = self.stringToPrefix(ctx.prefix.getText() if ctx.prefix else ""), unitKind = self.stringToUnitType(ctx.type_.getText() if ctx.type_ else ""))
    
    # customUnit                  :   name=STRING #customunit;
    def visitCustomunit(self, ctx:DeclarationParser.CustomUnitContext):
        # TODO: Set Prefix and type in customUnit either
        return FundamentalUnit(name = ctx.name.text if ctx.name.text else "")
    
    def visitBasicUnit(self, ctx:DeclarationParser.BasicUnitContext):
        return self.visitChildren(ctx)
    
    def visitUnitSpecification(self, ctx:DeclarationParser.UnitSpecificationContext):
        retVal = UnitSpecification()
        for elem in ctx.units:
            retVal.add(self.visit(elem))
        return retVal

    def visitComposedUnit(self, ctx:DeclarationParser.ComposedUnitContext):
        if ctx.denominator:
            return ComposedUnit(numerator = self.visitBasicUnit(ctx.numerator), denominator = self.visitBasicUnit(ctx.denominator))
        if ctx.exponent:
            return ComposedUnit(numerator = self.visitBasicUnit(ctx.numerator), exponent = self.visitBasicUnit(ctx.exponent))
        return ComposedUnit(basicUnit = self.visitChildren(ctx))    
        
    def visitParamGroupAssignStat(self, ctx: DeclarationParser.ParamGroupAssignStatContext):
        description = ctx.description.text if ctx.description else ""
        return self.withScope(ctx, GroupSymbol, lambda: self.visitChildren(ctx), ctx.name.text if ctx.name else "", VariableSymbol, description)

    # CHANGES sgu:
    #   featureDeclaration ID is saved as attribute 'name'

    def visitFeatureAssignStat(self, ctx: DeclarationParser.FeatureAssignStatContext):
        return self.withScope(ctx, FeatureSymbol, lambda: self.visitChildren(ctx), ctx.name.text if ctx.name else "")

    def visitFeatureGroupAssignStat(self, ctx: DeclarationParser.FeatureGroupAssignStatContext):
        return self.withScope(ctx, GroupSymbol, lambda: self.visitChildren(ctx), "", FeatureSymbol, "")
    
    def visitEnumerationType(self, ctx: DeclarationParser.EnumerationTypeContext):
        enumName = ctx.name.text if ctx.name else ""
        enumList = []
        self._enumIndex = 0
        for i in ctx.enumeral():
            #enumList representation: [(id, value),...]
            enumList.append(self.visitEnumeral(i))
            self._enumIndex += 1
        symbol = self._symbolTable.addNewSymbolOfType(EnumSymbol, self._scope, enumName, enumList)
        symbol.context = ctx
    
    def visitEnumeral(self, ctx: DeclarationParser.EnumeralContext):
        if ctx.value:
            #return a tuple of id and value
            return (ctx.name.text, int(ctx.value.text))
        else:
            return (ctx.name.text, self._enumIndex)

    
    def visitInlineEnumerationType(self, ctx: DeclarationParser.InlineEnumerationTypeContext):
        enumName = ""
        enumList = []
        self.inlineInt += 1
        self._enumIndex = 0
        for i in ctx.enumeral():
            #enumList representation: [(id, value),...]
            enumList.append(self.visitEnumeral(i))
            self._enumIndex += 1
        symbol = self._symbolTable.addNewSymbolOfType(EnumSymbol, self._scope, enumName, enumList)
        symbol.context = ctx
        return symbol
    
    def visitTypeReference(self, ctx: DeclarationParser.TypeReferenceContext):
        return ctx.type_.text
    
    def visitArrayType(self, ctx: DeclarationParser.ArrayTypeContext):
        bounds = []
        for i in ctx.dimensions:
            bounds.append(self.visit(i))
        print(bounds)
        symbol = self._symbolTable.addNewSymbolOfType(ArraySymbol, self._scope, "array_temp", bounds[0][1], bounds[0][0])
        # context will be set in visitparameterassignement
        # symbol.context = ctx
        symbol.type = self._scope.resolveSync(ctx.type_.text)
        return symbol

    def visitSizeDimension(self, ctx: DeclarationParser.SizeDimensionContext):
        return (0, int(ctx.size.text) if ctx.size else 0)

    def visitRangeDimension(self, ctx: DeclarationParser.RangeDimensionContext):
        return ((int(ctx.lowerBound.text) if ctx.lowerBound else 0), (int(ctx.upperBound.text) if ctx.upperBound else 0))
    
    def visitRangeType(self, ctx: DeclarationParser.RangeTypeContext):
        symbol = self._symbolTable.addNewSymbolOfType(RangeSymbol, self._scope, ctx.name.text, type(ctx.type_), ctx.minimum, ctx.maximum)
        symbol.context = ctx
    
    def withScope(self, tree: ParseTree, t: type, action: Callable, *my_args: P.args or None,
                  **my_kwargs: P.kwargs or None) -> T:
        scope = self._symbolTable.addNewSymbolOfType( t, self._scope, *my_args, **my_kwargs )
        scope.context = tree
        self._scope = scope
        try:
            return action()
        finally:
            self._scope = scope.parent()
