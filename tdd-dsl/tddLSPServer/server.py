"""exampleLSPServer package."""

############################################################################
# Copyright(c) Open Law Library. All rights reserved.                      #
# See ThirdPartyNotices.txt in the project root for additional notices.    #
#                                                                          #
# Licensed under the Apache License, Version 2.0 (the "License")           #
# you may not use this file except in compliance with the License.         #
# You may obtain a copy of the License at                                  #
#                                                                          #
#     http: // www.apache.org/licenses/LICENSE-2.0                         #
#                                                                          #
# Unless required by applicable law or agreed to in writing, software      #
# distributed under the License is distributed on an "AS IS" BASIS,        #
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. #
# See the License for the specific language governing permissions and      #
# limitations under the License.                                           #
############################################################################

# util imports
import asyncio
import logging
import re
import sys
import uuid
import os.path
# debug import
from pprint import pprint
from typing import List, Optional, Tuple

# antlr4
from antlr4 import CommonTokenStream, InputStream, Token
from antlr4.IntervalSet import IntervalSet
# pygls
from lsprotocol.types import (
    CompletionItem, CompletionList, CompletionOptions, CompletionParams, Diagnostic, DidChangeTextDocumentParams, DidCloseTextDocumentParams, DidOpenTextDocumentParams, DidSaveTextDocumentParams, MessageType, Registration, RegistrationParams,
    SemanticTokens, SemanticTokensLegend, SemanticTokensParams, TEXT_DOCUMENT_COMPLETION, TEXT_DOCUMENT_DID_CHANGE, TEXT_DOCUMENT_DID_CLOSE, TEXT_DOCUMENT_DID_OPEN, TEXT_DOCUMENT_DID_SAVE, TEXT_DOCUMENT_SEMANTIC_TOKENS_FULL, Unregistration,
    UnregistrationParams, WorkDoneProgressBegin, WorkDoneProgressEnd, WorkDoneProgressReport
)
from pygls.server import LanguageServer
from pygls.workspace import Document

# antlr4-c3
# TODO fail relative import beyond top-level package
# from ...antlrLib.CodeCompletionCore.CodeCompletionCore import CodeCompletionCore, CandidatesCollection
from codeCompletionCore.CodeCompletionCore import CandidatesCollection, CodeCompletionCore
# user relative imports
from .cst.DiagnosticListener import DiagnosticListener
from .cst.PFFileGeneratorVisitor import PFFileGeneratorVisitor
from .cst.SystemFileVisitor import SystemFileVisitor
from .cst.SymbolTableVisitor import SymbolTableVisitor
from .gen.python.TestSuite.TestSuiteLexer import TestSuiteLexer
from .gen.python.TestSuite.TestSuiteParser import TestSuiteParser
from .symbolTable.SymbolTable import FunctionSymbol, ModuleSymbol, PathSymbol, RoutineSymbol, Symbol, SymbolTable, VariableSymbol
from .utils.computeTokenIndex import CaretPosition, TokenPosition, computeTokenPosition
from .utils.suggestVariables import suggestSymbols

# TODO rm or move to debug logger
# python path hacking / DO NOT USE for live code
# if not os.path.join(sys.path[0], 'example-dsl', 'lspExampleServer') in sys.path:
#     sys.path.append(os.path.join( sys.path[0], 'example-dsl', 'lspExampleServer') )
# pprint( f'sys.path {sys.path}' )

COUNT_DOWN_START_IN_SECONDS = 10
COUNT_DOWN_SLEEP_IN_SECONDS = 1


class tddLSPServer( LanguageServer ):
    CMD_PROGRESS = 'progress'
    CMD_REGISTER_COMPLETIONS = 'registerCompletions'
    CMD_UNREGISTER_COMPLETIONS = 'unregisterCompletions'

    CONFIGURATION_SECTION = 'ODslExampleServer'

    def __init__( self, *args ):
        super( ).__init__( *args )
        # set ErrorListener
        self.error_listener: DiagnosticListener = DiagnosticListener( )
        # set empty input stream
        input_stream: InputStream = InputStream( str( ) )

        # set lexer
        self.lexer: TestSuiteLexer = TestSuiteLexer( input_stream )
        # set ErrorListener for diagnostics
        self.lexer.removeErrorListeners( )
        self.lexer.addErrorListener( self.error_listener )

        # set token stream pipe between lexer and parser
        self.tokenStream: CommonTokenStream = CommonTokenStream( self.lexer )

        # set parser
        self.parser: TestSuiteParser = TestSuiteParser( self.tokenStream )
        # set ErrorListener for diagnostics
        self.parser.removeErrorListeners( )
        self.parser.addErrorListener( self.error_listener )

        # attributes of generated files
        self.files: dict[ str, Tuple[ float, str, str ] ] = {}


tdd_server = tddLSPServer( 'pygls-odsl-tdd-prototype', 'v0.1' )

logger = logging.getLogger( __name__ )


def _validate( ls: tddLSPServer, params ):
    # msg to debug console
    # TODO setup debug logger
    # ls.show_message_log( 'Validating file...' )

    # get file content for lexer input stream
    text_doc: Document = ls.workspace.get_document( params.text_document.uri )
    source: str = text_doc.source
    # validate format if source is determined
    diagnostics: List[ Diagnostic ] = _validate_format( ls, source ) if source is not None else [ ]
    # return diagnostics
    ls.publish_diagnostics( text_doc.uri, diagnostics )


def _validate_format( ls: tddLSPServer, source: str ):
    """Validates file format."""
    # get input stream of characters for lexer
    input_stream: InputStream = InputStream( source )

    # set the input stream and reset the lexer/parser/listener
    ls.error_listener.reset( )
    ls.lexer.inputStream = input_stream
    ls.tokenStream = CommonTokenStream( ls.lexer )
    ls.parser.setInputStream( ls.tokenStream )

    try:
        # launch parser by invoking top-level rule
        ls.parser.test_suite( )
    except OSError as err:
        # TODO add exception
        msg = err.filename.msg

        ls.error_listener.diagnostics.append( msg )

    # return diagnostics
    return ls.error_listener.diagnostics


def get_symbol_name_at_position( uri, position ):
    logger.info( 'uri: %s\n', uri, 'position: %s\n', position )


def lookup_symbol( uri, name ):
    logger.info( 'uri: %s\n', uri, 'name: %s\n', name )


@tdd_server.feature( TEXT_DOCUMENT_COMPLETION, CompletionOptions( trigger_characters = [ ',' ] ) )
def completions( params: Optional[ CompletionParams ] = None ) -> CompletionList:
    """Returns completion items."""

    # set input stream of characters for lexer
    text_doc: Document = tdd_server.workspace.get_document( params.text_document.uri )
    source: str = text_doc.source
    input_stream: InputStream = InputStream( source )

    # reset the lexer/parser
    tdd_server.error_listener.reset( )
    tdd_server.lexer.inputStream = input_stream
    tdd_server.tokenStream = CommonTokenStream( tdd_server.lexer )
    tdd_server.parser.setInputStream( tdd_server.tokenStream )

    # launches parser by invoking top-level rule
    Top_levelContext = TestSuiteParser.Test_suiteContext
    parseTree: Top_levelContext = tdd_server.parser.test_suite( )

    # get token index under caret position
    # params.position.line + 1 as lsp line counts from 0 and antlr4 line counts from 1
    tokenIndex: TokenPosition = computeTokenPosition(
            parseTree, tdd_server.tokenStream,
            CaretPosition(
                    params.position.line + 1,
                    params.position.character
            )
    )

    # set emtpy return list
    completionList: CompletionList = CompletionList( is_incomplete = False, items = [ ] )

    # return if no index could be determined
    if tokenIndex is None:
        # TODO add exception
        return completionList

    # launch c3 core with parser
    core: CodeCompletionCore = CodeCompletionCore( tdd_server.parser )

    core.ignoredTokens = {Token.EPSILON}
    core.preferredRules = {TestSuiteParser.RULE_reference, TestSuiteParser.RULE_src_path, TestSuiteParser.RULE_test_module}

    # get completion candidates
    candidates: CandidatesCollection = core.collectCandidates( tokenIndex.index )

    # Resolve candidates for preferred rules
    if len( candidates.rules ) != 0:

        symbolTypes: List[ Symbol ] = [ ]

        if any( rule in candidates.rules for rule in [ TestSuiteParser.RULE_reference ] ):

            symbolTableVisitor: SymbolTableVisitor = SymbolTableVisitor( 'completions', os.getcwd( ) )
            symbolTable = symbolTableVisitor.visit( parseTree )
            # FunctionSymbol is derived from RoutineSymbol
            symbolTypes.extend( [ VariableSymbol, RoutineSymbol] )

        elif any( rule in candidates.rules for rule in [ TestSuiteParser.RULE_test_module ] ):

            symbolTableVisitor: SymbolTableVisitor = SymbolTableVisitor( 'completions', os.getcwd( ) )
            symbolTable = symbolTableVisitor.visit( parseTree )
            symbolTypes.append( ModuleSymbol )

        elif any( rule in candidates.rules for rule in [ TestSuiteParser.RULE_src_path ] ):

            symbolTableVisitor: SystemFileVisitor = SystemFileVisitor( 'paths', os.getcwd( ) )
            symbolTable = symbolTableVisitor.visit( parseTree )
            symbolTypes.append( PathSymbol )

        symbols: List[ str ] = [ ]
        for symbolType in symbolTypes:
            symbols.extend( suggestSymbols( symbolTable, tokenIndex, symbolType ) )

        for symbol in symbols:
            completionList.items.append( CompletionItem( label = symbol ) )

    # TODO modules, type check, asserts, functions, subroutines

    # add tokens to completion candidates
    for key, valueList in candidates.tokens.items( ):
        completionList.items.append(
                CompletionItem(
                        label = IntervalSet.elementName(
                                IntervalSet, tdd_server.parser.literalNames,
                                tdd_server.parser.symbolicNames, key
                        )
                )
        )

    # return completion candidates labels
    return completionList


@tdd_server.feature( TEXT_DOCUMENT_DID_CHANGE )
def did_change( ls, params: DidChangeTextDocumentParams ):
    """Text document did change notification."""
    _validate( ls, params )


@tdd_server.feature( TEXT_DOCUMENT_DID_CLOSE )
def did_close( server: tddLSPServer, params: DidCloseTextDocumentParams ):
    """Text document did close notification."""
    server.show_message( 'Text Document Did Close' )


@tdd_server.feature( TEXT_DOCUMENT_DID_SAVE )
def did_save( server: tddLSPServer, params: DidSaveTextDocumentParams ):
    """Text document did save notification."""

    # set input stream of characters for lexer
    textURI = params.text_document.uri
    text_doc: Document = tdd_server.workspace.get_document( textURI )
    source: str = text_doc.source
    input_stream: InputStream = InputStream( source )

    # reset the lexer/parser
    tdd_server.error_listener.reset( )
    tdd_server.lexer.inputStream = input_stream
    tdd_server.tokenStream = CommonTokenStream( tdd_server.lexer )
    tdd_server.parser.setInputStream( tdd_server.tokenStream )

    Top_levelContext = TestSuiteParser.Test_suiteContext
    parseTree: Top_levelContext = tdd_server.parser.test_suite( )

    # set current working directory as working directory for test files
    fileGeneratorVisitor: PFFileGeneratorVisitor = PFFileGeneratorVisitor( testWorkPath = os.getcwd( ), files = tdd_server.files )

    # TODO add arguments templatePath testPath testFolder
    # write files and save attributes
    tdd_server.files = fileGeneratorVisitor.visit( parseTree )

    server.show_message( 'Text Document Did Save' )


@tdd_server.feature( TEXT_DOCUMENT_DID_OPEN )
async def did_open( ls, params: DidOpenTextDocumentParams ):
    """Text document did open notification."""
    ls.show_message( 'Text Document Did Open' )
    _validate( ls, params )


@tdd_server.feature(
        TEXT_DOCUMENT_SEMANTIC_TOKENS_FULL,
        SemanticTokensLegend( token_types = [ "operator" ], token_modifiers = [ ] )
)
def semantic_tokens( ls: tddLSPServer, params: SemanticTokensParams ):
    """See https://microsoft.github.io/language-server-protocol/specification#textDocument_semanticTokens
    for details on how semantic tokens are encoded."""

    TOKENS = re.compile( '".*"(?=:)' )

    uri = params.text_document.uri
    doc = ls.workspace.get_document( uri )

    last_line = 0
    last_start = 0

    data = [ ]

    for lineno, line in enumerate( doc.lines ):
        last_start = 0

        for match in TOKENS.finditer( line ):
            start, end = match.span( )
            data += [ (lineno - last_line), (start - last_start), (end - start), 0, 0 ]

            last_line = lineno
            last_start = start

    return SemanticTokens( data = data )


@tdd_server.command( tddLSPServer.CMD_PROGRESS )
async def progress( ls: tddLSPServer, *args ):
    """Create and start the progress on the client."""
    token = 'token'
    # Create
    await ls.progress.create_async( token )
    # Begin
    ls.progress.begin( token, WorkDoneProgressBegin( title = 'Indexing', percentage = 0 ) )
    # Report
    for i in range( 1, 10 ):
        ls.progress.report( token, WorkDoneProgressReport( message = f'{i * 10}%', percentage = i * 10 ), )
        await asyncio.sleep( 2 )
    # End
    ls.progress.end( token, WorkDoneProgressEnd( message = 'Finished' ) )


@tdd_server.command( tddLSPServer.CMD_REGISTER_COMPLETIONS )
async def register_completions( ls: tddLSPServer, *args ):
    """Register completions method on the client."""
    params = RegistrationParams(
            registrations = [ Registration(
                    id = str( uuid.uuid4( ) ), method = TEXT_DOCUMENT_COMPLETION,
                    register_options = {"triggerCharacters": "[':']"}
            ) ]
    )
    response = await ls.register_capability_async( params )
    if response is None:
        ls.show_message( 'Successfully registered completions method' )
    else:
        ls.show_message( 'Error happened during completions registration.', MessageType.Error )


@tdd_server.command( tddLSPServer.CMD_UNREGISTER_COMPLETIONS )
async def unregister_completions( ls: tddLSPServer, *args ):
    """Unregister completions method on the client."""
    params = UnregistrationParams(
            unregisterations = [ Unregistration( id = str( uuid.uuid4( ) ), method = TEXT_DOCUMENT_COMPLETION ) ]
    )
    response = await ls.unregister_capability_async( params )
    if response is None:
        ls.show_message( 'Successfully unregistered completions method' )
    else:
        ls.show_message( 'Error happened during completions unregistration.', MessageType.Error )
