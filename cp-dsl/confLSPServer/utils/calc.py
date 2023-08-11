"""Declaration Calculator Module"""

__author__ = "stu222808"

import operator as op

from confLSPServer.symbolTable.SymbolTable import ArraySymbol

# Relative Imports
from ..symbolTable.SymbolTable import SymbolTable, VariableSymbol, ArraySymbol, ScopedSymbol, EnumSymbol
from confLSPServer.gen.python.Configuration.ConfigurationParser import ConfigurationParser
from confLSPServer.gen.python.Declaration.DeclarationParser import DeclarationParser

class DeclarationCalculator():
    def __init__(self, symbolTable : SymbolTable) -> None:
        self._symbolTable = symbolTable
        self._scope = None

    def calcVariable(self, variableSymbol : VariableSymbol):
        # check if the context is a Array or a simple Value
        ctx = variableSymbol.context
        if variableSymbol.is_array:
            # Array
            if ctx.defaultValue:
                self.calcArithmeticExpressionArray(ctx, ctx.defaultValue, variableSymbol)
                variableSymbol.is_tree = False
            else:
                print("WARNING: no default value defined for Array", variableSymbol.name)
        else:
            # simple Value
            if ctx.defaultValue:
                variableSymbol.value = self.calcArithmeticExpression(ctx.defaultValue, variableSymbol)
                variableSymbol.is_tree = False
            else:
                print("WARNING: no default value defined for Variable", variableSymbol.name)

    def calcArithmeticExpressionArray(self, varctx : DeclarationParser.ParamAssignStatContext, ctx : DeclarationParser.ArithmeticExpressionContext, arraySymbol : ArraySymbol):
        #tupleList representation: list[2:4,5] = [range(2,4), range(5)]
        #wanted: list[2,4:8] = [[(4,1),(5,2),(6,3),(7,4),(8,5)],[(4,1),(5,2),(6,3),(7,4),(8,5)],[(4,1),(5,2),(6,3),(7,4),(8,5)]]
        def convertToTupleList(rangeList : list, calcList, vector : list, depht : int) -> None:
            if len(vector) < depht+1:
                vector.append(0)
            else: 
                vector[depht] = 0
            print(rangeList)
            #rangeList is empty so there is no given range
            if len(rangeList) == 0:
                for i in range(len(calcList)):
                    vector[depht] = i
                    print(vector)
                    if isinstance(calcList[i], list):
                        convertToTupleList(rangeList, calcList[i], vector.copy(), depht + 1)
                    arraySymbol.add(vector, calcList[i])
                return
            index = 0
            if not isinstance(calcList, list):
                print("Warning: Array Value is not a list, proceed to convert it in to one")
                calcList = [calcList for _ in range(len(rangeList[0]))]
            if len(rangeList[0]) < len(calcList) and isinstance(calcList, list):
                rangeList[0] = range(rangeList[0].start, len(calcList) + rangeList[0].start)
            for i in rangeList[0]:
                vector[depht] = i
                if isinstance(calcList[index], list):
                    convertToTupleList(rangeList[1:], calcList[index], vector.copy(), depht + 1)
                else:
                    arraySymbol.add(vector, calcList[index])
                index += 1
            return

        calcList = self.calcArithmeticExpression(ctx, arraySymbol)

        rangeList = []
        for i in varctx.type_.arrayType().dimensions:
            if i.rangeDimension():
                j = i.rangeDimension()
                rangeList.append(range(int(j.lowerBound.text), int(j.upperBound.text) + 1))
            else:
                j = i.sizeDimension()
                size = int(j.size.text) if j.size else 0
                rangeList.append(range(size))
        vector = []
        convertToTupleList(rangeList, calcList, vector, 0)
        

    def calcArithmeticExpression(self, ctx: DeclarationParser.ArithmeticExpressionContext, variableSymbol : VariableSymbol):
        if ctx.getChildCount() == 1:
            # must be a multiplication Expression
            return self.calcMultiplicationExpression(ctx.multiplicationExpression(), variableSymbol)
        else:
            # has 3 children: left, operator and right
            leftValue = self.calcMultiplicationExpression(ctx.left, variableSymbol)
            # is enum
            leftValue = leftValue[1] if isinstance(leftValue, tuple) else leftValue
            operator = ctx.op.getText()
            if operator == "+":
                operator = op.add
            else:
                operator = op.sub
            rightValue = self.calcArithmeticExpression(ctx.right, variableSymbol)
            # is enum
            rightValue = rightValue[1] if isinstance(rightValue, tuple) else rightValue
            return operator(leftValue, rightValue)
        
    def calcMultiplicationExpression(self, ctx : DeclarationParser.MultiplicationExpressionContext, variableSymbol : VariableSymbol):
        if ctx.getChildCount() == 1:
            return self.calcValueExpression(ctx.valueExpression(), variableSymbol)
        else:
            # has 3 children: left, operator, right
            leftValue = self.calcValueExpression(ctx.left, variableSymbol)
            leftValue = leftValue[1] if isinstance(leftValue, tuple) else leftValue
            operator = ctx.op.getText()
            rightValue = self.calcMultiplicationExpression(ctx.right, variableSymbol)
            # is enum
            rightValue = rightValue[1] if isinstance(rightValue, tuple) else rightValue
            if operator == "*":
                operator = op.mul
            # if int then //
            elif operator == "/":
                if isinstance(leftValue, int) and isinstance(rightValue, int):
                    operator = op.floordiv
                else:
                    operator = op.truediv
            else:
                operator = op.mod
            return operator(leftValue, rightValue)
        
    def calcValueExpression(self, ctx : DeclarationParser.ValueExpressionContext, variableSymbol : VariableSymbol):
        if ctx.parenthesisExpression():
            return self.calcParenthesisExpression(ctx.parenthesisExpression(), variableSymbol)
        if ctx.namedElementReference():
            return self.calcNamedElementReference(ctx.namedElementReference(), variableSymbol)
        if ctx.arrayExpression():
            return self.calcArrayExpression(ctx.arrayExpression(), variableSymbol)
        if ctx.literalExpression():
            return self.calcLiteralExpression(ctx.literalExpression())
        print("ValueExpressionError: No given Token to proceed in calculation")
        return None

    def calcParenthesisExpression(self, ctx : DeclarationParser.ParenthesisExpressionContext, variableSymbol : VariableSymbol):
        return self.calcArithmeticExpression(ctx.expression, variableSymbol)

    def calcNamedElementReference(self, ctx : DeclarationParser.NamedElementReferenceContext, variableSymbol : VariableSymbol):
        #what is attribute? element is maybe a group
        elementAttribute = ctx.attribute.text if ctx.attribute else None
        elementValue = self._scope.resolveSync(ctx.element.text)
        if elementValue:
            #just return the value here should work due to scopeing
            if elementAttribute:
                if isinstance(elementValue, EnumSymbol):
                    for index, value in elementValue.enums:
                        if index == elementAttribute:
                            return value
                    print("EnumError: Enum definition could not be found")
                    return 0
                for i in elementValue.children():
                    if i.name == elementAttribute:
                        return i.value
            else:
                return elementValue.value
        else:
            if isinstance(variableSymbol.type, EnumSymbol):
                for i,j in variableSymbol.type.enums:
                    if i == ctx.element.text:
                        #just return the enums value
                        return i,j
            else:
                for elem in self._symbolTable.getAllNestedSymbolsSync():
                    if isinstance(elem, EnumSymbol):
                        for i,j in elem.enums:
                            if i == ctx.element.text:
                                print("WARNING: EnumType not given for variable", variableSymbol.name,"resolving may result in wrong reference")
                                return i,j
        print("Named Element", ctx.element.text, "could not be resolved")

    def calcArrayExpression(self, ctx : DeclarationParser.ArrayExpressionContext, variableSymbol : VariableSymbol):
        valueList = []
        for i in ctx.elements:
            valueList.append(self.calcArithmeticExpression(i, variableSymbol))
        return valueList
    
    def calcLiteralExpression(self, ctx : DeclarationParser.LiteralExpressionContext):
        return self.calcLiteral(ctx.value)
    
    def calcLiteral(self, ctx : DeclarationParser.LiteralContext):
        if ctx.stringValue():
            return ctx.stringValue().value.text.strip('"')
        if ctx.longValue():
            return int(ctx.longValue().value.text)
        if ctx.doubleValue():
            return float(ctx.doubleValue().value.text)
        if ctx.booleanValue():
            return bool(ctx.booleanValue().value.text)
    
    def calculate(self) -> SymbolTable:
        def recursionHelper(elem):
            if isinstance(elem, VariableSymbol):
                self.calcVariable(elem)
            elif not hasattr(elem, "children"):
                pass
            else:
                for i in elem.children():
                    if isinstance(i, ScopedSymbol):
                        self._scope = i
                    recursionHelper(i)

        recursionHelper(self._symbolTable)
        return self._symbolTable



class ConfigurationCalculator(DeclarationCalculator):
    def __init__(self, symbolTable : SymbolTable):
        super().__init__(symbolTable)

    def calcVariable(self, variableSymbol : VariableSymbol):
        for ctx in variableSymbol.configuration:
            # check if the context is a Array or a simple Value
            if variableSymbol.is_array:
                # Array
                self.calcArithmeticExpressionArray(ctx, ctx.value, variableSymbol)
            else:
                # simple Value
                variableSymbol.value = self.calcArithmeticExpression(ctx.value, variableSymbol)
                variableSymbol.is_tree = False

    def calcArithmeticExpressionArray(self, varctx : ConfigurationParser.ParameterAssignmentContext, ctx : ConfigurationParser.ArithmeticExpressionContext, arraySymbol: ArraySymbol):
        #tupleList representation: list[2:4,5] = [range(2,4), range(5)]
        #wanted: list[2,4:8] = [[(4,1),(5,2),(6,3),(7,4),(8,5)],[(4,1),(5,2),(6,3),(7,4),(8,5)],[(4,1),(5,2),(6,3),(7,4),(8,5)]]
        def convertToTupleList(rangeList : list, calcList, vector : list, depht : int) -> list:
            if len(vector) < depht+1:
                vector.append(0)
            else: 
                vector[depht] = 0
            print(rangeList)
            #rangeList is empty so there is no given range
            if len(rangeList) == 0:
                for i in range(len(calcList)):
                    vector[depht] = i
                    print(vector)
                    if isinstance(calcList[i], list):
                        convertToTupleList(rangeList, calcList[i], vector.copy(), depht + 1)
                    arraySymbol.add(vector, calcList[i])
                return
            index = 0
            if not isinstance(calcList, list):
                print("Warning: Array Value is not a list, proceed to convert it in to one")
                calcList = [calcList for _ in range(len(rangeList[0]))]
            if len(rangeList[0]) < len(calcList) and isinstance(calcList, list):
                rangeList[0] = range(rangeList[0].start, len(calcList) + rangeList[0].start)
            for i in rangeList[0]:
                vector[depht] = i
                if isinstance(calcList[index], list):
                    convertToTupleList(rangeList[1:], calcList[index], vector.copy(), depht + 1)
                else:
                    arraySymbol.add(vector, calcList[index])
                index += 1
            return

        calcList = self.calcArithmeticExpression(ctx, arraySymbol)

        rangeList = []
        for i in varctx.selectors:
            if i.rangeSelector():
                j : ConfigurationParser.RangeSelectorContext = i.rangeSelector()
                rangeList.append(range(int(j.lowerBound.text), int(j.upperBound.text) + 1))
            else:
                j : ConfigurationParser.ElementSelectorContext = i.elementSelector()
                element = int(j.element.text)
                rangeList.append(range(element, element + 1))
        vector = []
        convertToTupleList(rangeList, calcList, vector, 0)
        
