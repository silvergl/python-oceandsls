from typing import TypeVar, Generic, Dict, Optional, Callable, Any

from antlr4.tree.Tree import ParseTree

from SymbolTable.SymbolTable import SymbolTable, P, T, BlockSymbol, RoutineSymbol, SymbolTableOptions, VariableSymbol, FundamentalUnit, UnitPrefix, UnitKind
from Declaration.DeclarationParser import DeclarationParser
from Declaration.DeclarationVisitor import DeclarationVisitor


class CP_DSLSymbolTableVisitor( DeclarationVisitor, Generic[T] ):
    _symbolTable: SymbolTable

    def __init__(self, name: str = '', ):
        super().__init__()
        # creates a new symboltable with no duplicate symbols
        self._symbolTable = SymbolTable( name, SymbolTableOptions( False ) )
        # TODO scope marker
        # self._scope = self._symbolTable.addNewSymbolOfType( ScopedSymbol, None )
        self._scope = None

    @property
    def symbolTable(self) -> SymbolTable:
        return self._symbolTable

    def defaultResult(self) -> SymbolTable:
        return self._symbolTable

    # Visit a parse tree produced by DeclarationParser#paramAssignStat.
    # 'def' name=ID type=paramType ':' unit=unitSpecification (',' description=STRING)? ('=' defaultValue=arithmeticExpression)?
    def visitParamAssignStat(self, ctx:DeclarationParser.ParamAssignStatContext):
        
        # define the given Parameter
        # TODO merge UnitSymbol from main and change t to UnitSymbol
        t = VariableSymbol # set and get the type of param here
        varName = ctx.name.text # set and get the variable name here
        unit = self.visit(ctx.unit)
        description = ctx.description.text
        scope = self._symbolTable.addNewSymbolOfType(VariableSymbol, varName, ctx, unit)


        # TODO add defaultValue and unit see
        #  The_Definitive_ANTLR_4_Reference.pdf 56/322 bzw 40
        #       https://git.se.informatik.uni-kiel.de/oceandsl/organization/-/wikis/uploads/30c8a43db807b74d17147b69360e1566/The_Definitive_ANTLR_4_Reference.pdf
        #  or example : media.pragprog.com/titles/tpantlr2/code/tour/EvalVisitor.java
        # TODO backlog add description as comment to SymbolTable?
        return scope
    
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
    
    # sIUnit                      :   (prefix=ePrefix)? type=eSIUnitType #siUnit; 
    def visitSiunit(self, ctx:DeclarationParser.sIUnitContext):
        return FundamentalUnit(name = ctx.type.text, unitPrefix = stringToPrefix(ctx.prefix.text), unitKind = stringToUnitType(ctx.type.text))
    
    # customUnit                  :   name=STRING #customunit;
    def visitCustomunit(self, ctx:DeclarationParser.customUnit):
        # TODO: Set Prefix and type in customUnit also
        return FundamentalUnit(name = ctx.name.text)
    
        

    # TODO backlog visitParamGroupAssignStat as BlockSymbol is not implemented and do we need it?
    # def visitParamGroupAssignStat(self, ctx: DeclarationParser.ParamGroupAssignStatContext):
    #     return self.withScope(ctx, BlockSymbol, lambda: self.visitChildren(ctx), ctx.ID().getText())

    # CHANGES sgu:
    #   featureDeclaration ID is saved as attribute 'name'

    def visitFeatureAssignStat(self, ctx: DeclarationParser.FeatureAssignStatContext):
        return self.withScope(ctx, RoutineSymbol, lambda: self.visitChildren(ctx), ctx.name.text)

    # TODO backlog visitFeatureGroupAssignStat as BlockSymbol is not implemented and do we need it?
    # def visitFeatureGroupAssignStat(self, ctx: DeclarationParser.FeatureGroupAssignStatContext):
    #     return self.withScope(ctx, BlockSymbol, lambda: self.visitChildren(ctx), ctx.ID().getText())

    # def visitAssignStat(self, ctx: TestGrammarParser.AssignStatContext):
    #     self._symbolTable.addNewSymbolOfType( VariableSymbol, self._scope, ctx.ID().getText() )
    #     return self.visitChildren( ctx )

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