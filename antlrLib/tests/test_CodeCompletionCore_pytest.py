"""pytest example for CodeCompletionCore"""

__author__ = 'sgu'

# util imports
import pytest
from typing import Set

# antlr4
from antlr4 import InputStream, CommonTokenStream, DiagnosticErrorListener

# antlr4-c3
from codeCompletionCore.CodeCompletionCore import CodeCompletionCore

# grammar imports (example-DSL module dependency)
from exampleLSPServer.gen.python.TestExprCore.TestExprCoreLexer import TestExprCoreLexer
from exampleLSPServer.gen.python.TestExprCore.TestExprCoreParser import TestExprCoreParser

# tokenIndexes for collect_candidates test parameterization
inputTokenIndex: Set[ int ] = {0, 1, 2, 4, 6, 8}


# Core set up
@pytest.fixture
def tester( streamInput: str = "var c = a + b()" ) -> CodeCompletionCore:
    # create input stream of characters for lexer
    # most simple setup
    print( streamInput )
    input_stream = InputStream( streamInput )

    # create lexer and parser objects and token stream pipe between them
    lexer = TestExprCoreLexer( input_stream )
    tokenStream = CommonTokenStream( lexer )

    parser = TestExprCoreParser( tokenStream )
    parser.addErrorListener( DiagnosticErrorListener )

    # launch parser by invoking rule 'expression'
    ast = parser.expression( )

    # launch c3 core with parser
    return CodeCompletionCore( parser )


class CodeCompletionCoreTest:
    @pytest.mark.parametrize( "tokenIndex", inputTokenIndex )
    @pytest.mark.parametrize( 'tester', {"var c = + b()"}, indirect = True )
    def test_collect_candidates( self, tester, tokenIndex ) -> None:
        """
        Test collected candidates for 'var c = a + b()' at tokenIndex

        :param tester: test fixture
        :param tokenIndex: tokenIndex from caret
        :return:
        """
        candidates = tester.collectCandidates( tokenIndex )
        match tokenIndex:
            # At the input start.
            case 0:
                assert 3 == len( candidates.tokens )
                assert TestExprCoreLexer.VAR in candidates.tokens
                assert TestExprCoreLexer.LET in candidates.tokens
                assert TestExprCoreLexer.ID in candidates.tokens
                assert [ TestExprCoreLexer.ID, TestExprCoreLexer.EQUAL ] == candidates.tokens.get( TestExprCoreLexer.VAR )
                assert [ TestExprCoreLexer.ID, TestExprCoreLexer.EQUAL ] == candidates.tokens.get( TestExprCoreLexer.LET )
                assert [ ] == candidates.tokens.get( TestExprCoreLexer.ID )
            # On the first whitespace. In real implementations you would do some additional checks where in the whitespace
            # the caret is, as the outcome is different depending on that position.
            case 1:
                assert 1 == len( candidates.tokens )
                assert TestExprCoreLexer.ID in candidates.tokens
            # On the variable name ('c').
            case 2:
                assert 1 == len( candidates.tokens )
                assert TestExprCoreLexer.ID in candidates.tokens
            # On the equal sign (ignoring whitespace positions from now on).
            case 4:
                assert 1 == len( candidates.tokens )
                assert TestExprCoreLexer.EQUAL in candidates.tokens
            # On the variable reference 'a'. But since we have not configured the c3 engine to return us var refs (or
            # function refs for that matter) we only get an ID here.
            case 6:
                assert 1 == len( candidates.tokens )
                assert TestExprCoreLexer.ID in candidates.tokens
            # On the '+' operator. Usually you would not show operators as candidates, but we have not set up the c3 engine
            # yet to not return them.
            case 8:
                assert 5 == len( candidates.tokens )
                assert TestExprCoreLexer.PLUS in candidates.tokens
                assert TestExprCoreLexer.MINUS in candidates.tokens
                assert TestExprCoreLexer.MULTIPLY in candidates.tokens
                assert TestExprCoreLexer.DIVIDE in candidates.tokens
                assert TestExprCoreLexer.OPEN_PAR in candidates.tokens
