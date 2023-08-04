"""Declaration Calculator Module"""

__author__ = "stu222808"

# antlr4
from antlr4.tree.Tree import ParseTree

import operator as op

# Relative Imports
from ..symbolTable.SymbolTable import SymbolTable, VariableSymbol, ArraySymbol
from confLSPServer.gen.python.Declaration.DeclarationParser import DeclarationParser

class DeclarationCalculator():
    def __init__(self, symbolTable : SymbolTable) -> None:
        self._symbolTable = symbolTable
        self._scope = None

    def calcVariable(self, variableSymbol : VariableSymbol):
        # check if the context is a Array or a simple Value
        ctx : DeclarationParser.ParamAssignStatContext = variableSymbol.context
        if variableSymbol.is_array:
            # Array
            self.calcArithmeticExpressionArray(ctx, ctx.defaultValue, variableSymbol)
        else:
            # simple Value
            variableSymbol.value = self.calcArithmeticExpression(ctx.defaultValue)

    def calcArithmeticExpressionArray(self, varctx : DeclarationParser.ParamAssignStatContext, ctx : DeclarationParser.ArithmeticExpressionContext, arraySymbol : ArraySymbol):
        # calc list: representation: []
        calcList = self.calcArithmeticExpression(ctx)

        array : DeclarationParser.ArrayTypeContext = varctx.type_.arrayType()
        rangeList = []
        for i in array.dimensions:
            if i.rangeDimension():
                j : DeclarationParser.RangeDimensionContext = i.rangeDimension()
                rangeList.append(range(int(j.lowerBound.text) if j.lowerBound else 0, int(j.upperBound.text) if j.upperBound else 0))
            else:
                j : DeclarationParser.SizeDimensionContext = i.sizeDimension()
                rangeList.append(range(int(j.size.text)) if j.size else None)
        vector = []
        convertToTupleList(rangeList, calcList, vector, 0)
        
        #tupleList representation: list[2:4,5] = [range(2,4), range(5)]
        #wanted: list[2,4:8] = [[(4,1),(5,2),(6,3),(7,4),(8,5)],[(4,1),(5,2),(6,3),(7,4),(8,5)],[(4,1),(5,2),(6,3),(7,4),(8,5)]]
        def convertToTupleList(rangeList : list, calcList, vector : list, depht : int) -> list:
            index = 0
            vector.append(0)
            if not isinstance(calcList, list):
                print("Warning: Array Value is not a list, proceed to convert it in to one")
                calcList = [calcList for i in range(len(rangeList[0]))]
            for i in rangeList[0]:
                vector[depht] = i
                if isinstance(calcList[index], list):
                    convertToTupleList(rangeList[1:], calcList[index], vector, depht + 1)
                else:
                    arraySymbol.add(vector, calcList[index])
                index += 1
            return 

    def calcArithmeticExpression(self, ctx: DeclarationParser.ArithmeticExpressionContext):
        if ctx.getChildCount() == 1:
            # must be a multiplication Expression
            return self.calcMultiplicationExpression(ctx.multiplicationExpression())
        else:
            # has 3 children: left, operator and right
            leftValue = self.calcMultiplicationExpression(ctx.left)
            operator = ctx.op.getText()
            if operator == "+":
                operator = op.add
            else:
                operator = op.sub
            rightValue = self.calcArithmeticExpression(ctx.right)
            return operator(leftValue, rightValue)
        
    def calcMultiplicationExpression(self, ctx : DeclarationParser.MultiplicationExpressionContext):
        if ctx.getChildCount() == 1:
            return self.calcValueExpression(ctx.valueExpression())
        else:
            # has 3 children: left, operator, right
            leftValue = self.calcValueExpression(ctx.left)
            operator = ctx.op.getText()
            rightValue = self.calcMultiplicationExpression(ctx.right)
            if operator == "*":
                operator = op.mul
            # if int then //
            elif operator == "/":
                operator = op.truediv
            else:
                operator = op.mod
            return operator(leftValue, rightValue)
        
    def calcValueExpression(self, ctx : DeclarationParser.ValueExpressionContext):
        if ctx.parenthesisExpression():
            return self.calcParenthesisExpression(ctx.parenthesisExpression())
        if ctx.namedElementReference():
            return self.calcNamedElementReference(ctx.namedElementReference())
        if ctx.arrayExpression():
            return self.calcArrayExpression(ctx.arrayExpression())
        if ctx.literalExpression():
            return self.calcLiteralExpression(ctx.literalExpression())
        print("ValueExpressionError: No given Token to proceed in calculation")
        return None

    def calcParenthesisExpression(self, ctx : DeclarationParser.ParenthesisExpressionContext):
        return self.calcArithmeticExpression(ctx.expression)

    def calcNamedElementReference(self, ctx : DeclarationParser.NamedElementReferenceContext):
        #what is attribute? element is maybe a group
        elementAttribute = ctx.attribute
        elementValue = self._scope.resolveSync(ctx.element.text)
        if elementValue:
            #TODO: Check for the elements type
            #just return the value here should work due to scopeing
            return elementValue.value
        print("Named Element", ctx.element.text, "could not be resolved")

    def calcArrayExpression(self, ctx : DeclarationParser.ArrayExpressionContext):
        valueList = []
        for i in ctx.getChildren():
            valueList.append(self.calcArithmeticExpression(i))
        return valueList
    
    def calcLiteralExpression(self, ctx : DeclarationParser.LiteralExpressionContext):
        return self.calcLiteral(ctx.value)
    
    def calcLiteral(self, ctx : DeclarationParser.LiteralContext):
        if ctx.stringValue():
            return ctx.stringValue().value.text
        if ctx.longValue():
            return int(ctx.longValue().value.text)
        if ctx.doubleValue():
            return float(ctx.doubleValue().value.text)
        if ctx.booleanValue():
            return bool(ctx.booleanValue().value.text)

