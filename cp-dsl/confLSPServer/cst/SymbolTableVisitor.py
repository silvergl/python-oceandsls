"""SymbolTableVisitor module."""

__author__ = 'stu222808'

# util imports
from typing import TypeVar, Generic, Dict, Optional, Callable, Any

# antlr4
from antlr4.tree.Tree import ParseTree
from antlr4 import InputStream, CommonTokenStream

from ..gen.python.Configuration.ConfigurationParser import ConfigurationParser
from ..gen.python.Declaration.DeclarationParser import DeclarationParser
from ..gen.python.Declaration.DeclarationLexer import DeclarationLexer
# user relative imports
from .SymbolTableVisitorDcl import SymbolTableVisitorDecl as DeclSymbolTableVisitor
from ..symbolTable.SymbolTable import SymbolTable, P, T, GroupSymbol, RoutineSymbol, SymbolTableOptions, VariableSymbol, FundamentalUnit, UnitPrefix, UnitKind
from ..gen.python.Configuration.ConfigurationParser import ConfigurationParser
from ..gen.python.Configuration.ConfigurationVisitor import ConfigurationVisitor


class SymbolTableVisitor( ConfigurationVisitor, Generic[T] ):
    _symbolTable: SymbolTable

    def __init__(self, name: str = '', ):
        super().__init__()
        # creates a new symboltable with no duplicate symbols
        self._symbolTable = SymbolTable( name, SymbolTableOptions( False ) )
        # TODO scope marker
        # self._scope = self._symbolTable.addNewSymbolOfType( ScopedSymbol, None )
        self._scope = None
        self.declVisitor = DeclSymbolTableVisitor(name + "_ConfDeclVisit")

    @property
    def symbolTable(self) -> SymbolTable:
        return self._symbolTable

    def defaultResult(self) -> SymbolTable:
        return self._symbolTable

    def visitConfigurationModel(self, ctx: ConfigurationParser.ConfigurationModelContext):
        # Symboltable has to be filled with Declaration Defaults
        # TODO: How do we know where the dcl file is placed?
        with open("/home/armin/Dokumente/cp-dsl/examples/testing/basic/" + ctx.declarationModel.text + ".decl") as dcl_file:
            data = dcl_file.read()
            input_stream = InputStream(data)
            lexer = DeclarationLexer(input_stream)
            stream = CommonTokenStream(lexer)
            dcl_parsed = DeclarationParser(stream).declarationModel()
            self.declVisitor.visit(dcl_parsed)
        self.symbolTable.addDependencies(self.declVisitor.symbolTable)
        return super().visitConfigurationModel(ctx)

    # Visit a parse tree produced by DeclarationParser#paramAssignStat.
    # 'def' name=ID type=paramType ':' unit=unitSpecification (',' description=STRING)? ('=' defaultValue=arithmeticExpression)?
    def visitParameterAssignment(self, ctx: ConfigurationParser.parameterAssignment):
        
        # define the given Parameter
        varName = ctx.declaration.text # set and get the variable name here
        #unit = self.visit(ctx.unit) if unit != None else UnitKind.Unknown
        checkForParamAndEdit(varName, ctx)
                
        def checkForParamAndEdit(searchedParamName : str, ctx : ConfigurationParser.parameterAssignment):
            for param in self._symbolTable.getSymbolsOfType(VariableSymbol):
                if param.name == searchedParamName:
                    param.configuration.append(ctx)
                    return
            # TODO: add new symbol if not found in SymbolTable?
    
    def visitParameterGroup(self, ctx: ConfigurationParser.parameterGroup):
        return self.withScope(ctx, GroupSymbol, lambda: self.visitChildren(ctx), ctx.declaration.text, VariableSymbol)

    def visitUnitSpecification(self, ctx : ConfigurationParser.unitSpecification):
        return self.stringToUnitType(ctx.name.text)

    def visitFeatureConfiguration(self, ctx: ConfigurationParser.featureConfiguration):
        return self.withScope(ctx, RoutineSymbol, lambda: self.visitChildren(ctx), ctx.declaration.text)

    def visitFeatureActivation(self, ctx : ConfigurationParser.featureActivation):
        def checkForFeatureAndSetActivation(feature : RoutineSymbol, searchedFeatureName : str, activate : bool):
            if feature.name == searchedFeatureName:
                feature.is_activated = activate
                # TODO: Do we have to add the element again, or does it just save the changes?
                return
            for feature in feature.getFeatures():
                checkForFeatureAndSetActivation(feature, searchedFeatureName)


        for feature in self._scope.getFeatures():
            #TODO: Scopeing how to ge the correct feature/parameter, when names and scope is out of bound with decl and conf?
            try:
                checkForFeatureAndSetActivation(feature, ctx.declaration.text, True if ctx.deactivated.text else False)
            except AttributeError:
                pass
            
            

    def visitInclude(self, ctx: ConfigurationParser.include):
        self.declVisitor.visit(ctx)
        self.symbolTable.addDependencies(self.declVisitor.symbolTable)

    
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
    
    def withScope(self, tree: ParseTree, t: type, action: Callable, *my_args: P.args or None,
                  **my_kwargs: P.kwargs or None) -> T:
        scope = self._symbolTable.addNewSymbolOfType( t, self._scope, *my_args, **my_kwargs )
        scope.context = tree
        self._scope = scope
        try:
            return action()
        finally:
            self._scope = scope.parent()
