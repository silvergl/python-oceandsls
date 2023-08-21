""" Accessor functions for nodes of Fortran parse objects from xml(http://fxtran.net/#syntax)"""

__author__ = 'sgu'

from typing import Any, Callable, List


class NodeUtils():
    _ROOT_PROGRAM: str = "main"

    #  methods. 
    @classmethod
    def nameOfCalledFunction(cls, functionCallNode) -> str:
        return NodeUtils.getSuccessorNode(functionCallNode, "0,0").getTextContent().toLowerCase(Locale.getDefault())

    @classmethod
    def nameOfCalledOperation(cls, operationCallNode) -> str:
        return NodeUtils.getSuccessorNode(operationCallNode, "1").getTextContent().toLowerCase(Locale.getDefault())

    # TODO check None == ...
    @classmethod
    def hasName(cls, name: str) -> Callable[ [ Any ], bool ]:
        return lambda node : False if node is None else name == node.getNodeName( )

    @classmethod
    def hasTextContent(cls, content: str) -> Callable[ [ Any ], bool ]:
        return lambda node : content == node.getTextContent()

    # TODO predicate.test
    @classmethod
    def childSatisfies(cls, path: str, predicate: Callable[[Any], Any]) -> Callable[ [ Any ], bool ]:
        return lambda node : predicate.test(NodeUtils.getSuccessorNode(node, path))

    @classmethod
    def nodeType(cls, nodeType) -> str:
        match nodeType:
            case Node.ELEMENT_NODE:
                return "Element Node"
            case Node.ATTRIBUTE_NODE:
                return "Attribute Node"
            case Node.TEXT_NODE:
                return "Text Node"
            case Node.CDATA_SECTION_NODE:
                return "CDATA Section Node"
            case Node.ENTITY_REFERENCE_NODE:
                return "Entity Reference Node"
            case Node.ENTITY_NODE:
                return "Entity Node"
            case Node.PROCESSING_INSTRUCTION_NODE:
                return "Processing Instruction Node"
            case Node.COMMENT_NODE:
                return "Comment Node"
            case Node.DOCUMENT_NODE:
                return "Document Node"
            case Node.DOCUMENT_TYPE_NODE:
                return "Document Type Node"
            case Node.DOCUMENT_FRAGMENT_NODE:
                return "Document Fragment Node"
            case Node.NOTATION_NODE:
                return "Notation Node"
            case _:
                return "Unknown Node Type"

    @classmethod
    def printNode(cls, node, depth):
        spaces: List[str] = [" "] * depth

        numberOfPrintedNodes: int = 1
        print (''.join( spaces ) + "[node type] " + NodeUtils.nodeType(node.getNodeType()))
        print (''.join( spaces ) + "[node name] " + node.getNodeName())
        print (''.join( spaces ) + "[node value] " + node.getNodeValue())
        print (''.join( spaces ) + "[node text content] " + node.getTextContent())
        print (''.join( spaces ) + "[node #kids] " + node.getChildNodes().getLength())
        i = 0
        while i < node.getChildNodes().getLength():
            numberOfPrintedNodes += NodeUtils.printNode(child, depth + 1)
            i += 1
        return numberOfPrintedNodes

    @classmethod
    def getSuccessorNode(cls, node, path):
        """ generated source for method getSuccessorNode """
        firstNumber = StringUtils.substringBefore(path, ",")
        nextPath = StringUtils.substringAfter(path, ",")
        childIndex = Integer.parseInt(firstNumber)
        children = node.getChildNodes()
        if children.getLength() < childIndex:
            System.err.println("No children found for node " + node)
            return None
        if nextPath.isEmpty():
            return node.getChildNodes().item(childIndex)
        else:
            return NodeUtils.getSuccessorNode(node.getChildNodes().item(childIndex), nextPath)

    @classmethod
    def findChildFirst(cls, parent, condition):
        """ generated source for method findChildFirst """
        node = parent.getFirstChild()
        while node != None:
            if condition.test(node):
                return node
            node = node.getNextSibling()
        return None

    @classmethod
    @overloaded
    def findFirst(cls, parent, nextNode, condition, includeSelf):
        """ generated source for method findFirst """
        return NodeUtils.findFirst(parent, nextNode, condition, includeSelf, None)

    @classmethod
    @findFirst.register(object, Node, Function, Predicate, bool, List)
    def findFirst_0(cls, parent, nextNode, condition, includeSelf, paranthesesTypes):
        """ generated source for method findFirst_0 """
        result = NodeUtils.findAll(parent, nextNode, condition, includeSelf, paranthesesTypes, 1)
        return None if result.isEmpty() else result.get(0)

    @classmethod
    def hasConnectedWith(cls, parent, nextNode, condition, includeSelf):
        """ generated source for method hasConnectedWith """
        return NodeUtils.findFirst(parent, nextNode, condition, includeSelf) != None

    @classmethod
    def addAllDescendentsTo(cls, node, predicate, includeSelf, selectedNodes):
        """ generated source for method addAllDescendentsTo """
        if predicate.test(node) and includeSelf:
            selectedNodes.add(node)
        i = 0
        while i < node.getChildNodes().getLength():
            NodeUtils.addAllDescendentsTo(child, predicate, True, selectedNodes)
            i += 1
        return selectedNodes

    @classmethod
    @overloaded
    def getNameOfOperation(cls, node):
        """ generated source for method getNameOfOperation """
        if Predicates.isSubroutineStatement.test(node):
            return NodeUtils.getNameOfOperation(node, Predicates.isSubroutineName)
        elif Predicates.isFunctionStatement.test(node):
            return NodeUtils.getNameOfOperation(node, Predicates.isFunctionName)
        elif Predicates.isEntryStatement.test(node):
            return NodeUtils.getNameOfOperation(node, Predicates.isEntryName)
        elif Predicates.isProgramStatement.test(node):
            return NodeUtils._ROOT_PROGRAM
        raise IllegalArgumentException("Node is not a function, subroutine, entry or program statement.")

    @classmethod
    @getNameOfOperation.register(object, Node, Predicate)
    def getNameOfOperation_0(cls, node, predicate):
        """ generated source for method getNameOfOperation_0 """
        nameNodes = NodeUtils.allDescendents(node, predicate, True)
        return NodeUtils.getName(nameNodes.iterator().next())

    @classmethod
    def getName(cls, node):
        """ generated source for method getName """
        bigNNode = node.getFirstChild()
        littleNNode = bigNNode.getFirstChild()
        return littleNNode.getTextContent().toLowerCase(Locale.getDefault())

    @classmethod
    def getCalleeNameFromCall(cls, callStatementNode):
        """ generated source for method getCalleeNameFromCall """
        return NodeUtils.getName(callStatementNode.getFirstChild().getNextSibling())

    @classmethod
    def getAssignmentExpression(cls, stmt):
        """ generated source for method getAssignmentExpression """
        e = stmt
        elems = e.getElementsByTagName("E-2")
        return elems.item(0)

    @classmethod
    def getAssigmentVariable(cls, statement):
        """ generated source for method getAssigmentVariable """
        e = statement
        elems = e.getElementsByTagName("E-1")
        return elems.item(0)

    @classmethod
    def getNameOfContainingOperation(cls, node):
        """ generated source for method getNameOfContainingOperation """
        containingOperationStatement = NodeUtils.findContainingStatement(node, Predicates.isOperationStatement, Predicates.paranthesisTypes)
        return NodeUtils._ROOT_PROGRAM if containingOperationStatement == None else NodeUtils.getNameOfOperation( containingOperationStatement )

    @classmethod
    def satisfiesAssumptions(cls, node):
        """ generated source for method satisfiesAssumptions """
        if node == None:
            return True
        type_ = node.getNodeType()
        if (type_ == Node.TEXT_NODE) and (node.getChildNodes().getLength() > 0):
            raise IllegalArgumentException("text node with children")
        if "call-stmt" == node.getNodeName() and (node.getChildNodes().getLength() < 2):
            NodeUtils.printNode(node, 0)
            raise IllegalArgumentException("call statement with < 2 children")
        if Predicates.isNamedExpression.test(node):
            if not Predicates.isBigN.test(firstChild):
                raise IllegalArgumentException(String.format("Expected <N> in named expression, but found %s as first child.", firstChild.getNodeName()))
            if not Predicates.isSmallN.test(firstGrandChild):
                raise IllegalArgumentException(String.format("Expected <n> in named expression, but found %s as first gand child.", firstGrandChild.getNodeName()))
            if firstGrandChild.getChildNodes().getLength() > 1:
                NodeUtils.printNode(firstGrandChild, 0)
                raise IllegalArgumentException("named expression with unexpected chlildren length list of first grandchild.")
        return True

