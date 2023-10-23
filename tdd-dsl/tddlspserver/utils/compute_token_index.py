"""computeTokenIndex module."""

__author__ = "sgu"

#  Copyright (c) 2023.  OceanDSL (https://oceandsl.uni-kiel.de)
#
#  Licensed under the Apache License, Version 2.0 (the "License");
#  you may not use this file except in compliance with the License.
#  You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.

# utils
import logging
from dataclasses import dataclass
from typing import Any, List, Optional

# antlr4
from antlr4 import BufferedTokenStream, TerminalNode, Token
from antlr4.ParserRuleContext import ParserRuleContext
from antlr4.tree.Tree import ErrorNodeImpl, ParseTree

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


def compute_token_index_of_terminal_node(terminal_node: TerminalNode, caret_position: CaretPosition) -> Optional[Any]:
    start = terminal_node.symbol.column
    stop = terminal_node.symbol.column + len(terminal_node.getText())
    if terminal_node.symbol.line == caret_position.line and start <= caret_position.column <= stop:
        return terminal_node.symbol.tokenIndex
    else:
        return None


def compute_token_index_of_child_node(parser_rule_context: ParserRuleContext, caret_position: CaretPosition) -> Optional[int]:
    i = 0
    while i < parser_rule_context.getChildCount():
        index = compute_token_index(parser_rule_context.getChild(i), caret_position)
        if index is not None:
            return index
        i += 1
    return None


def compute_token_index(parse_tree: ParseTree, caret_position: CaretPosition) -> int:
    if isinstance(parse_tree, TerminalNode):
        return compute_token_index_of_terminal_node(parse_tree, caret_position)
    else:
        parser_rule_context: ParserRuleContext = parse_tree
        return compute_token_index_of_child_node(parser_rule_context, caret_position)


def position_of_token(
    token: Token, text: str, caret_position: CaretPosition, identifier_token_types: List[int], parse_tree: ParseTree
):
    start = token.column
    stop = token.column + len(text)
    if token.line == caret_position.line and start <= caret_position.column <= stop and 0 <= token.tokenIndex :
        index = token.tokenIndex
        if token.type in identifier_token_types:
            index -= 1

        # TODO check to choose complete token text or substring
        # result: TokenPosition = tokenPosition(index, parseTree, text)
        parser_rule_context: ParserRuleContext = parse_tree
        # TODO check for error nodes
        text = text[0: caret_position.column - start] if not isinstance(parse_tree, ErrorNodeImpl) else ""
        result: TokenPosition = TokenPosition(index, parser_rule_context, text)

        return result
    else:
        return None


def compute_token_position_of_terminal(
    terminal_node: TerminalNode, token_stream: BufferedTokenStream, caret_position: CaretPosition, identifier_token_types: List[int]
):
    token: Token = terminal_node.symbol
    text: str = terminal_node.getText()
    return position_of_token(token, text, caret_position, identifier_token_types, terminal_node)


def compute_token_position_of_child_node(
    parser_rule_context: ParserRuleContext, tokens: BufferedTokenStream, caret_position: CaretPosition, identifier_token_types: List[int]
):
    if (
        (parser_rule_context.start is not None and parser_rule_context.start.line > caret_position.line) or
        (parser_rule_context.stop is not None and parser_rule_context.stop.line < caret_position.line)
    ):
        return None
    if parser_rule_context.start is not None and parser_rule_context.stop is not None:
        i = parser_rule_context.start.tokenIndex
        while i <= parser_rule_context.stop.tokenIndex:
            pos = position_of_token(
                    tokens.tokens[i], tokens.tokens[i].text, caret_position, identifier_token_types, parser_rule_context
            )
            if pos:
                return pos
            i += 1
    i = 0
    while i < parser_rule_context.getChildCount():
        position = compute_token_position(parser_rule_context.getChild(i), tokens, caret_position, identifier_token_types)
        if position is not None:
            return position
        i += 1
    return None


def compute_token_position(
    parse_tree: ParseTree, tokens: BufferedTokenStream, caret_position: CaretPosition, identifier_token_types: List[int] = []
) -> Optional[TokenPosition]:
    if isinstance(parse_tree, TerminalNode):
        return compute_token_position_of_terminal(parse_tree, tokens, caret_position, identifier_token_types)
    else:
        parser_rule_context: ParserRuleContext = parse_tree
        return compute_token_position_of_child_node(parser_rule_context, tokens, caret_position, identifier_token_types)
