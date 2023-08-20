"""computeTokenIndex module."""

__author__ = 'sgu'

# utils
import logging
from dataclasses import dataclass
from typing import List, Optional, Any

# antlr4
from antlr4 import TerminalNode, Token, BufferedTokenStream
from antlr4.tree.Tree import ParseTree, ErrorNodeImpl
from antlr4.ParserRuleContext import ParserRuleContext

# debug
logger = logging.getLogger(__name__)
logger.disabled = True


@dataclass
class CaretPosition:
    line: int
    column: int


@dataclass
class TokenPosition:
    index: int
    context: ParserRuleContext
    text: str


def computeTokenIndexOfTerminalNode(terminalNode: TerminalNode, caretPosition: CaretPosition) -> Optional[Any]:
    start = terminalNode.symbol.column
    stop = terminalNode.symbol.column + len(terminalNode.getText())
    if terminalNode.symbol.line == caretPosition.line and start <= caretPosition.column <= stop:
        return terminalNode.symbol.tokenIndex
    else:
        return None


def computeTokenIndexOfChildNode(parserRuleContext: ParserRuleContext, caretPosition: CaretPosition) -> Optional[int]:
    i = 0
    while i < parserRuleContext.getChildCount():
        index = computeTokenIndex(parserRuleContext.getChild(i), caretPosition)
        if index is not None:
            return index
        i += 1
    return None


def computeTokenIndex(parseTree: ParseTree, caretPosition: CaretPosition) -> int:
    if isinstance(parseTree, TerminalNode):
        return computeTokenIndexOfTerminalNode(parseTree, caretPosition)
    else:
        parserRuleContext: ParserRuleContext = parseTree
        return computeTokenIndexOfChildNode(parserRuleContext, caretPosition)


def positionOfToken(token: Token, text: str, caretPosition: CaretPosition, identifierTokenTypes: List[int],
                    parseTree: ParseTree):
    start = token.column
    stop = token.column + len(text)
    logger.info(
        'token.line: %s == caretPosition.line: %s = %s, start: %s <= caretPosition.column: %s <= stop: %s = %s, '
        'token.column: %s , len(text): %s, text: %s, index: %s',
        token.line, caretPosition.line, token.line == caretPosition.line, start, caretPosition.column, stop,
        start <= caretPosition.column <= stop, token.column, len(text), text, token.tokenIndex)
    if token.line == caretPosition.line and start <= caretPosition.column <= stop:
        index = token.tokenIndex
        if token.type in identifierTokenTypes:
            index -= 1

        # TODO check to choose complete token text or substring
        # result: TokenPosition = tokenPosition(index, parseTree, text)
        parserRuleContext: ParserRuleContext = parseTree
        # TODO check for error nodes
        text = text[0: caretPosition.column - start] if not isinstance(parseTree, ErrorNodeImpl) else ''
        result: TokenPosition = TokenPosition(index, parserRuleContext, text)

        logger.info('positionOfToken return result = %s', result)
        return result
    else:
        logger.info('positionOfToken return None')
        return None


def computeTokenPositionOfTerminal(terminalNode: TerminalNode, tokenStream: BufferedTokenStream,
                                   caretPosition: CaretPosition, identifierTokenTypes: List[int]):
    token: Token = terminalNode.symbol
    text: str = terminalNode.getText()
    logger.info('computeTokenPositionOfTerminal')
    return positionOfToken(token, text, caretPosition, identifierTokenTypes, terminalNode)


def computeTokenPositionOfChildNode(parserRuleContext: ParserRuleContext, tokens: BufferedTokenStream,
                                    caretPosition: CaretPosition, identifierTokenTypes: List[int]):
    logger.info('start: %s > caret: %s = %s, stop: %s < caret: %s = %s', parserRuleContext.start.line,
                caretPosition.line, parserRuleContext.start.line > caretPosition.line, parserRuleContext.stop.line,
                caretPosition.line, parserRuleContext.stop.line < caretPosition.line)
    logger.info('parserRuleContext.start is not None = %s, parserRuleContext.stop is not None = %s',
                parserRuleContext.start is not None, parserRuleContext.stop is not None)
    if (parserRuleContext.start is not None and parserRuleContext.start.line > caretPosition.line) or (
            parserRuleContext.stop is not None and parserRuleContext.stop.line < caretPosition.line):
        logger.info('return None\n')
        return None
    i = 0
    logger.info('parserRuleContext.getChildCount() = %s', parserRuleContext.getChildCount())
    while i < parserRuleContext.getChildCount():
        position = computeTokenPosition(parserRuleContext.getChild(i), tokens, caretPosition, identifierTokenTypes)
        logger.info('Child computeTokenPosition = %s', position)
        if position is not None:
            logger.info('return position = %s\n', position)
            return position
        i += 1
    logger.info('parserRuleContext.start is not None = %s, parserRuleContext.stop is not None = %s',
                parserRuleContext.start is not None, parserRuleContext.stop is not None)
    if parserRuleContext.start is not None and parserRuleContext.stop is not None:
        logger.info('parserRuleContext.start.tokenIndex: %s <= parserRuleContext.stop.tokenIndex: %s = %s',
                    parserRuleContext.start.tokenIndex, parserRuleContext.stop.tokenIndex,
                    parserRuleContext.start.tokenIndex <= parserRuleContext.stop.tokenIndex)
        i = parserRuleContext.start.tokenIndex
        logger.info('while parserRuleContext start.tokenIndex: %s, stop.tokenIndex: %s',
                    parserRuleContext.start.tokenIndex, parserRuleContext.stop.tokenIndex)
        while i <= parserRuleContext.stop.tokenIndex:
            pos = positionOfToken(tokens.tokens[i], tokens.tokens[i].text, caretPosition, identifierTokenTypes,
                                  parserRuleContext)
            logger.info('positionOfToken = %s', pos)
            if pos:
                logger.info('return position = %s\n', pos)
                return pos
            i += 1
    logger.info('final return None\n')
    return None


def computeTokenPosition(parseTree: ParseTree, tokens: BufferedTokenStream, caretPosition: CaretPosition,
                         identifierTokenTypes: List[int] = []) -> Optional[TokenPosition]:
    if isinstance(parseTree, TerminalNode):
        return computeTokenPositionOfTerminal(parseTree, tokens, caretPosition, identifierTokenTypes)
    else:
        parserRuleContext: ParserRuleContext = parseTree
        return computeTokenPositionOfChildNode(parserRuleContext, tokens, caretPosition, identifierTokenTypes)
