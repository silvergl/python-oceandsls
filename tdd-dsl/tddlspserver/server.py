"""tddlspserver package."""

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

# util imports
import asyncio
import logging
import re
import uuid
import os.path
from builtins import range
# debug import
from pprint import pprint
from typing import List, Optional, Tuple

# antlr4
from antlr4 import CommonTokenStream, InputStream, Token
from antlr4.IntervalSet import IntervalSet
# pygls
from lsprotocol.types import (
    CompletionItem, CompletionList, CompletionOptions, CompletionParams, Diagnostic, DidChangeTextDocumentParams, DidCloseTextDocumentParams,
    DidOpenTextDocumentParams, DidSaveTextDocumentParams, MessageType, Position, Range, Registration, RegistrationParams, SemanticTokens, SemanticTokensLegend,
    SemanticTokensParams, TEXT_DOCUMENT_COMPLETION, TEXT_DOCUMENT_DID_CHANGE, TEXT_DOCUMENT_DID_CLOSE, TEXT_DOCUMENT_DID_OPEN, TEXT_DOCUMENT_DID_SAVE,
    TEXT_DOCUMENT_SEMANTIC_TOKENS_FULL, Unregistration, UnregistrationParams, WorkDoneProgressBegin, WorkDoneProgressEnd, WorkDoneProgressReport
)
from pygls.server import LanguageServer
from pygls.workspace import Document

# antlr4-c3
# TODO fail relative import beyond top-level package
# from ...antlrLib.CodeCompletionCore.CodeCompletionCore import CodeCompletionCore, CandidatesCollection
from codeCompletionCore.CodeCompletionCore import CandidatesCollection, CodeCompletionCore
from .cst.calculate_complexity_visitor import CalculateComplexityVisitor
# user relative imports
from .cst.cmake_file_generator_visitor import CMakeFileGeneratorVisitor
from .cst.f90_file_generator_visitor import F90FileGeneratorVisitor
from .cst.diagnostic_listener import DiagnosticListener
from .cst.pf_file_generator_visitor import PFFileGeneratorVisitor
from .cst.system_file_visitor import SystemFileVisitor
from .cst.symbol_table_visitor import SymbolTableVisitor
from .gen.python.TestSuite.TestSuiteLexer import TestSuiteLexer
from .gen.python.TestSuite.TestSuiteParser import TestSuiteParser
from .symboltable.symbol_table import FunctionSymbol, MetricSymbol, ModuleSymbol, PathSymbol, RoutineSymbol, Symbol, SymbolTable, VariableSymbol
from .utils.compute_token_index import CaretPosition, TokenPosition, compute_token_position
from .utils.suggest_variables import suggest_symbols


# TODO rm or move to debug logger
# python path hacking / DO NOT USE for live code
# if not os.path.join(sys.path[0], "example-dsl", "lspExampleServer") in sys.path:
#     sys.path.append(os.path.join( sys.path[0], "example-dsl", "lspExampleServer") )
# pprint( f"sys.path {sys.path}" )

class TDDLSPServer( LanguageServer ):
    CMD_REGISTER_COMPLETIONS = "registerCompletions"
    CMD_UNREGISTER_COMPLETIONS = "unregisterCompletions"
    CMD_CALCULATE_COMPLEXITY_BLOCKING = "calculateComplexity"

    CONFIGURATION_SECTION = "ODsl-TDD-DSL-Server"

    def __init__( self, *args ):
        super( ).__init__( *args )
        # Set error listener
        self.error_listener: DiagnosticListener = DiagnosticListener( )
        # Set empty input stream
        input_stream: InputStream = InputStream( str( ) )

        # Set lexer
        self.lexer: TestSuiteLexer = TestSuiteLexer( input_stream )
        # Set error listener for diagnostics
        self.lexer.removeErrorListeners( )
        self.lexer.addErrorListener( self.error_listener )

        # Set token stream pipe between lexer and parser
        self.token_stream: CommonTokenStream = CommonTokenStream( self.lexer )

        # Set parser
        self.parser: TestSuiteParser = TestSuiteParser( self.token_stream )
        # Set error listener for diagnostics
        self.parser.removeErrorListeners( )
        self.parser.addErrorListener( self.error_listener )

        # Attributes of generated files
        self.files: dict[ str, Tuple[ float, str, str ] ] = {}

        # Fxtran system file path
        self.fxtran_path = "fxtran"


tdd_server = TDDLSPServer( "pygls-odsl-tdd-prototype", "v0.8" )

logger = logging.getLogger( __name__ )


def _validate( ls: TDDLSPServer, params ):
    # msg to debug console
    # TODO setup debug logger
    # ls.show_message_log( "Validating file..." )

    # get file content for lexer input stream
    text_doc: Document = ls.workspace.get_document( params.text_document.uri )
    source: str = text_doc.source
    # validate format if source is determined
    diagnostics: List[ Diagnostic ] = _validate_format( ls, source ) if source is not None else [ ]
    # return diagnostics
    ls.publish_diagnostics( text_doc.uri, diagnostics )


def _validate_format( ls: TDDLSPServer, source: str ):
    """Validates file format."""
    # get input stream of characters for lexer
    input_stream: InputStream = InputStream( source )

    # set the input stream and reset the lexer/parser/listener
    ls.error_listener.reset( )
    ls.lexer.inputStream = input_stream
    ls.token_stream = CommonTokenStream( ls.lexer )
    ls.parser.setInputStream( ls.token_stream )

    try:
        # Launch parser by invoking top-level rule
        top_level_context = TestSuiteParser.Test_suiteContext
        parse_tree: Optional[ top_level_context ] = ls.parser.test_suite( )

        if not tdd_server.token_stream.fetchedEOF:
            end: Position = Position( parse_tree.stop.line, parse_tree.stop.column )
            eof_range: Range = Range( start = end, end = end )
            eof_msg = Diagnostic( message = "Parser stopped before end of file.", range = eof_range )
            ls.error_listener.diagnostics.append( eof_msg )

    except OSError as err:
        msg = err.filename.msg

        ls.error_listener.diagnostics.append( msg )

    # return diagnostics
    return ls.error_listener.diagnostics


def get_symbol_name_at_position( uri, position ):
    logger.info( "uri: %s\n", uri, "position: %s\n", position )


def lookup_symbol( uri, name ):
    logger.info( "uri: %s\n", uri, "name: %s\n", name )


@tdd_server.feature( TEXT_DOCUMENT_COMPLETION, CompletionOptions( trigger_characters = [ "," ] ) )
def completions( params: Optional[ CompletionParams ] = None ) -> CompletionList:
    """Returns completion items."""

    # Set input stream of characters for lexer
    text_doc: Document = tdd_server.workspace.get_text_document( params.text_document.uri )
    source: str = text_doc.source
    input_stream: InputStream = InputStream( source )

    # Reset the lexer/parser
    tdd_server.error_listener.reset( )
    tdd_server.lexer.inputStream = input_stream
    tdd_server.token_stream = CommonTokenStream( tdd_server.lexer )
    tdd_server.parser.setTokenStream( tdd_server.token_stream )

    # Launches parser by invoking top-level rule
    top_level_context = TestSuiteParser.Test_suiteContext
    parse_tree: Optional[ top_level_context ] = None

    token_index: Optional[ TokenPosition ] = None

    # Parse until fetched
    while not tdd_server.token_stream.fetchedEOF:
        parse_tree = tdd_server.parser.test_suite( )

        # Get token index under caret position
        # params.position.line + 1 as lsp line counts from 0 and antlr4 line counts from 1
        if token_index is None:
            token_index = compute_token_position(
                    parse_tree, tdd_server.token_stream, CaretPosition(
                            params.position.line + 1, params.position.character
                    )
            )

    # Init emtpy return list
    completion_list: CompletionList = CompletionList( is_incomplete = False, items = [ ] )

    # Return if no index could be determined
    if token_index is None:
        # TODO add warning
        return completion_list

    # Launch c3 core with parser
    core: CodeCompletionCore = CodeCompletionCore( tdd_server.parser )

    core.ignoredTokens = {Token.EPSILON}
    core.preferredRules = {TestSuiteParser.RULE_reference, TestSuiteParser.RULE_src_path, TestSuiteParser.RULE_test_module}

    # Get completion candidates
    candidates: CandidatesCollection = core.collectCandidates( token_index.index )

    # Resolve candidates for preferred rules
    if len( candidates.rules ) != 0:

        symbol_types: List[ Symbol ] = [ ]

        if any( rule in candidates.rules for rule in [ TestSuiteParser.RULE_reference ] ):

            symbol_table_visitor: SymbolTableVisitor = SymbolTableVisitor( "completions", os.getcwd( ), tdd_server.fxtran_path )
            symbol_table = symbol_table_visitor.visit( parse_tree )
            # FunctionSymbol is derived from RoutineSymbol
            symbol_types.extend( [ VariableSymbol, RoutineSymbol ] )

        elif any( rule in candidates.rules for rule in [ TestSuiteParser.RULE_test_module ] ):

            symbol_table_visitor: SymbolTableVisitor = SymbolTableVisitor( "completions", os.getcwd( ), tdd_server.fxtran_path )
            symbol_table = symbol_table_visitor.visit( parse_tree )
            symbol_types.append( ModuleSymbol )

        elif any( rule in candidates.rules for rule in [ TestSuiteParser.RULE_src_path ] ):

            symbol_table_visitor: SystemFileVisitor = SystemFileVisitor( "paths", os.getcwd( ) )
            symbol_table = symbol_table_visitor.visit( parse_tree )
            symbol_types.append( PathSymbol )

        symbols: List[ str ] = [ ]
        for symbol_type in symbol_types:
            symbols.extend( suggest_symbols( symbol_table, token_index, symbol_type ) )

        for symbol in symbols:
            completion_list.items.append( CompletionItem( label = symbol ) )

    # TODO modules, type check, asserts, functions, subroutines

    # Add tokens to completion candidates
    for key, valueList in candidates.tokens.items( ):
        completion_list.items.append(
                CompletionItem(
                        label = IntervalSet.elementName(
                                IntervalSet, stripTerminals( elements = tdd_server.parser.literalNames, terminal = "\'" ), tdd_server.parser.symbolicNames, key
                        )
                )
        )

    # Return completion candidates labels
    return completion_list


def stripTerminals( elements: List[ str ] = None, terminal: str = "\'" ) -> List[ str ]:
    """
     Strip string terminals from list elements.

    :param elements: List of elements
    :return: List of striped elements
    """
    return [ e.strip( terminal ) for e in elements ]


@tdd_server.feature( TEXT_DOCUMENT_DID_CHANGE )
def did_change( ls, params: DidChangeTextDocumentParams ):
    """Text document did change notification."""
    _validate( ls, params )


@tdd_server.feature( TEXT_DOCUMENT_DID_CLOSE )
def did_close( server: TDDLSPServer, params: DidCloseTextDocumentParams ):
    """Text document did close notification."""
    server.show_message( "Text Document Did Close" )


@tdd_server.feature( TEXT_DOCUMENT_DID_SAVE )
def did_save( server: TDDLSPServer, params: DidSaveTextDocumentParams ):
    """Text document did save notification."""

    # set input stream of characters for lexer
    textURI = params.text_document.uri
    text_doc: Document = tdd_server.workspace.get_document( textURI )
    source: str = text_doc.source
    file_path: str = os.path.abspath( text_doc.path )
    rel_file_path: str = os.path.relpath( file_path, os.getcwd( ) )
    input_stream: InputStream = InputStream( source )

    # reset the lexer/parser
    tdd_server.error_listener.reset( )
    tdd_server.lexer.inputStream = input_stream
    tdd_server.token_stream = CommonTokenStream( tdd_server.lexer )
    tdd_server.parser.setInputStream( tdd_server.token_stream )

    top_level_context = TestSuiteParser.Test_suiteContext
    parse_tree: top_level_context = tdd_server.parser.test_suite( )

    # get symboltable for f90 generator
    symbol_table_visitor: SymbolTableVisitor = SymbolTableVisitor( "variables", os.getcwd( ), tdd_server.fxtran_path )
    symbol_table = symbol_table_visitor.visit( parse_tree )

    # Generate pf files
    pf_file_generator_visitor: PFFileGeneratorVisitor = PFFileGeneratorVisitor( work_path = os.getcwd( ), files = tdd_server.files, symbol_table = symbol_table, rel_file_path = rel_file_path )
    # write pf files and save generated files
    tdd_server.files = pf_file_generator_visitor.visit( parse_tree )

    # Generate F90 files
    f90_file_generator_visitor: F90FileGeneratorVisitor = F90FileGeneratorVisitor( work_path = os.getcwd( ), files = tdd_server.files, symbol_table = symbol_table, rel_file_path = rel_file_path )
    # update fortran file and save generated files
    tdd_server.files = f90_file_generator_visitor.visit( parse_tree )

    # Generate CMake files
    cmake_file_generator_visitor: CMakeFileGeneratorVisitor = CMakeFileGeneratorVisitor(
            work_path = os.getcwd( ), files = tdd_server.files, symbol_table = symbol_table
    )
    # update CMake files and save generated files
    tdd_server.files = cmake_file_generator_visitor.visit( parse_tree )

    server.show_message( "Text Document Did Save" )


@tdd_server.feature( TEXT_DOCUMENT_DID_OPEN )
async def did_open( ls, params: DidOpenTextDocumentParams ):
    """Text document did open notification."""
    ls.show_message( "Text Document Did Open" )

    # set input stream of characters for lexer
    textURI = params.text_document.uri
    text_doc: Document = tdd_server.workspace.get_document( textURI )
    source: str = text_doc.source
    file_path: str = os.path.abspath( text_doc.path )
    rel_file_path: str = os.path.relpath( file_path, os.getcwd( ) )
    input_stream: InputStream = InputStream( source )

    # reset the lexer/parser
    tdd_server.error_listener.reset( )
    tdd_server.lexer.inputStream = input_stream
    tdd_server.token_stream = CommonTokenStream( tdd_server.lexer )
    tdd_server.parser.setInputStream( tdd_server.token_stream )

    top_level_context = TestSuiteParser.Test_suiteContext
    parse_tree: top_level_context = tdd_server.parser.test_suite( )

    calculate_complexity_visitor: CalculateComplexityVisitor = CalculateComplexityVisitor( name = "paths", test_work_path =  os.getcwd( ), fxtran_path = tdd_server.fxtran_path)
    metric_table = calculate_complexity_visitor.visit( parse_tree )

    suggest_symbols( metric_table, None, MetricSymbol )

    print(metric_table)

    _validate( ls, params )


@tdd_server.feature(
        TEXT_DOCUMENT_SEMANTIC_TOKENS_FULL, SemanticTokensLegend( token_types = [ "operator" ], token_modifiers = [ ] )
)
def semantic_tokens( ls: TDDLSPServer, params: SemanticTokensParams ):
    """See https://microsoft.github.io/language-server-protocol/specification#textDocument_semanticTokens
    for details on how semantic tokens are encoded."""

    TOKENS = re.compile( "\".*\"(?=:)" )

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

@tdd_server.command(TDDLSPServer.CMD_CALCULATE_COMPLEXITY_BLOCKING)
def calculate_complexity(ls, *args):
    """Starts counting down and showing message synchronously.
    It will `block` the main thread, which can be tested by trying to show
    completion items.
    """
    ls.show_message(f"calculate_complexity... ")

@tdd_server.command( TDDLSPServer.CMD_REGISTER_COMPLETIONS )
async def register_completions( ls: TDDLSPServer, *args ):
    """Register completions method on the client."""
    params = RegistrationParams(
            registrations = [ Registration(
                    id = str( uuid.uuid4( ) ), method = TEXT_DOCUMENT_COMPLETION, register_options = {"triggerCharacters": ","}
            ) ]
    )
    response = await ls.register_capability_async( params )
    if response is None:
        ls.show_message( "Successfully registered completions method" )
    else:
        ls.show_message( "Error happened during completions registration.", MessageType.Error )


@tdd_server.command( TDDLSPServer.CMD_UNREGISTER_COMPLETIONS )
async def unregister_completions( ls: TDDLSPServer, *args ):
    """Unregister completions method on the client."""
    params = UnregistrationParams(
            unregisterations = [ Unregistration( id = str( uuid.uuid4( ) ), method = TEXT_DOCUMENT_COMPLETION ) ]
    )
    response = await ls.unregister_capability_async( params )
    if response is None:
        ls.show_message( "Successfully unregistered completions method" )
    else:
        ls.show_message( "Error happened during completions unregistration.", MessageType.Error )
