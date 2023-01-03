from dataclasses import dataclass
from typing import List, Optional, Any

from antlr4 import TerminalNode, Token, BufferedTokenStream
from antlr4.tree.Tree import ParseTree
from antlr4.ParserRuleContext import ParserRuleContext

# util imports
import logging

logger = logging.getLogger(__name__)

@dataclass
class CaretPosition:
    line: int
    column: int

@dataclass
class TokenPosition:
    index: int
    context: ParseTree
    text: str

def computeTokenIndexOfTerminalNode(terminalNode: TerminalNode, caretPosition: CaretPosition) -> Optional[Any]:
    start = terminalNode.symbol.column
    stop = terminalNode.symbol.column + len(terminalNode.getText())
    if terminalNode.symbol.line == caretPosition.line and start <= caretPosition.column <= stop:
        return  terminalNode.symbol.tokenIndex
    else:
        return None

def computeTokenIndexOfChildNode(parserRuleContext: ParserRuleContext, caretPosition: CaretPosition) -> Optional[int]:
    i = 0
    while i < parserRuleContext.getChildCount():
        index = computeTokenIndex( parserRuleContext.getChild( i ), caretPosition )
        if index is not None:
            return index
        i += 1
    return None

def computeTokenIndex (parseTree: ParseTree, caretPosition: CaretPosition) -> int :
    if isinstance(parseTree, TerminalNode):
        return computeTokenIndexOfTerminalNode(parseTree, caretPosition)
    else:
        parserRuleContext: ParserRuleContext = parseTree
        return computeTokenIndexOfChildNode(parserRuleContext, caretPosition)



def positionOfToken(token: Token, text: str, caretPosition: CaretPosition, identifierTokenTypes: List[int], parseTree: ParseTree):
    start = token.column
    stop = token.column + len(text)
    if token.line == caretPosition.line and start <= caretPosition.column <= stop:
        index = token.tokenIndex
        if token.type in identifierTokenTypes:
            index -= 1

        # TODO check to choose complete token text or substring
        # result: TokenPosition = tokenPosition(index, parseTree, text)
        result: TokenPosition = TokenPosition(index, parseTree, text[0 : caretPosition.column - start])

        return result
    else:
        return None

def computeTokenPositionOfTerminal(terminalNode: TerminalNode, tokenStream: BufferedTokenStream, caretPosition: CaretPosition, identifierTokenTypes: List[int]):
    token: Token = terminalNode.symbol
    text: str = terminalNode.getText()
    return positionOfToken( token, text, caretPosition, identifierTokenTypes, terminalNode )

def computeTokenPositionOfChildNode(parserRuleContext: ParserRuleContext, tokens: BufferedTokenStream, caretPosition: CaretPosition, identifierTokenTypes: List[int]):
    logger.info('start: %s, stop: %s, caret: %s', parserRuleContext.start.line,parserRuleContext.stop.line,caretPosition.line)
    if (parserRuleContext.start is not None and parserRuleContext.start.line > caretPosition.line) or (parserRuleContext.stop is not None and parserRuleContext.stop.line < caretPosition.line):
        return None
    i = 0
    while i < parserRuleContext.getChildCount():
        position = computeTokenPosition( parserRuleContext.getChild( i ), tokens, caretPosition, identifierTokenTypes )
        if position is not None:
            return position
        i += 1
    if parserRuleContext.start is not None and parserRuleContext.stop is not None:
        i = parserRuleContext.start.tokenIndex
        while i <= parserRuleContext.stop.tokenIndex:
            pos = positionOfToken( tokens.tokens[i], tokens.tokens[i].text, caretPosition, identifierTokenTypes, parserRuleContext )
            if pos:
                return pos
            i += 1
    return None

def computeTokenPosition(parseTree: ParseTree, tokens: BufferedTokenStream, caretPosition: CaretPosition, identifierTokenTypes: List[int] = []) -> Optional[TokenPosition]:
    if isinstance(parseTree, TerminalNode):
        return computeTokenPositionOfTerminal(parseTree, tokens, caretPosition, identifierTokenTypes)
    else:
        parserRuleContext: ParserRuleContext = parseTree
        return computeTokenPositionOfChildNode(parserRuleContext, tokens, caretPosition, identifierTokenTypes)