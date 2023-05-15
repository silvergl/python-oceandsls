"""cpdslLSPServer package."""

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
import re
import time
import uuid
import sys, os, logging
from typing import List, Optional

# antlr4
from antlr4.IntervalSet import IntervalSet
from antlr4 import InputStream, CommonTokenStream, Token, ParseTreeWalker

# antlr4-c3
from .cst.CodeCompletionCore import CodeCompletionCore, CandidatesCollection

# pygls
# Deprecated from 0.13
# from pygls.lsp.methods import (COMPLETION, TEXT_DOCUMENT_DID_CHANGE, TEXT_DOCUMENT_DID_CLOSE,
# TEXT_DOCUMENT_DID_OPEN, TEXT_DOCUMENT_SEMANTIC_TOKENS_FULL)
# from pygls.lsp.types import (CompletionItem, CompletionList, CompletionOptions, CompletionParams,
# ConfigurationItem, ConfigurationParams, Diagnostic, DidChangeTextDocumentParams,
#                              DidCloseTextDocumentParams, DidOpenTextDocumentParams, MessageType, Position, Range,
#                              Registration, RegistrationParams, SemanticTokens,
#                              SemanticTokensLegend, SemanticTokensParams, Unregistration, UnregistrationParams)
# from pygls.lsp.types.basic_structures import (WorkDoneProgressBegin, WorkDoneProgressEnd, WorkDoneProgressReport)
from pygls.server import LanguageServer
from pygls.workspace import Document
# Migrating to pygls v1.0
# https://pygls.readthedocs.io/en/latest/pages/migrating-to-v1.html
from lsprotocol.types import (TEXT_DOCUMENT_COMPLETION, TEXT_DOCUMENT_DID_CHANGE, TEXT_DOCUMENT_DID_CLOSE,
                              TEXT_DOCUMENT_DID_OPEN, TEXT_DOCUMENT_SEMANTIC_TOKENS_FULL, CompletionItem,
                              CompletionList, CompletionOptions, CompletionParams, ConfigurationItem,
                              ConfigurationParams, Diagnostic, DidChangeTextDocumentParams, DidCloseTextDocumentParams,
                              DidOpenTextDocumentParams, MessageType, Registration, RegistrationParams, SemanticTokens,
                              SemanticTokensLegend, SemanticTokensParams, Unregistration, UnregistrationParams,
                              WorkDoneProgressBegin, WorkDoneProgressEnd, WorkDoneProgressReport,
                              TEXT_DOCUMENT_DID_SAVE, DidSaveTextDocumentParams)

# user relative imports
from .utils.computeTokenIndex import computeTokenPosition, computeTokenIndex, CaretPosition, TokenPosition
from .utils.suggestVariables import suggestVariables

from .cst.SymbolTableVisitor import SymbolTableVisitor
from .cst.DiagnosticListener import DiagnosticListener

from .gen.python.Declaration.DeclarationLexer import DeclarationLexer
from .gen.python.Declaration.DeclarationParser import DeclarationParser

COUNT_DOWN_START_IN_SECONDS = 10
COUNT_DOWN_SLEEP_IN_SECONDS = 1


class dclLSPServer( LanguageServer ):
    CMD_PROGRESS = 'progress'
    CMD_REGISTER_COMPLETIONS = 'registerCompletions'
    CMD_UNREGISTER_COMPLETIONS = 'unregisterCompletions'

    CONFIGURATION_SECTION = 'ODslDCLServer'

    def __init__(self, *args):
        super().__init__( *args )
        # set ErrorListener
        self.error_listener: DiagnosticListener = DiagnosticListener()
        # set empty input stream
        input_stream: InputStream = InputStream( str() )

        # set lexer
        self.lexer: DeclarationLexer = DeclarationLexer( input_stream )
        # set ErrorListener for diagnostics
        self.lexer.removeErrorListeners()
        self.lexer.addErrorListener( self.error_listener )

        # set token stream pipe between lexer and parser
        self.tokenStream: CommonTokenStream = CommonTokenStream( self.lexer )

        # set parser
        self.parser: DeclarationParser = DeclarationParser( self.tokenStream )
        # set ErrorListener for diagnostics
        self.parser.removeErrorListeners()
        self.parser.addErrorListener( self.error_listener )


dcl_server = dclLSPServer( 'pygls-odsl-dcl-prototype', 'v0.1' )

logger = logging.getLogger( __name__ )


def _validate(ls: dclLSPServer, params):
    # msg to debug console
    # TODO setup debug logger
    # ls.show_message_log( 'Validating file...' )

    # get file content for lexer input stream
    text_doc: Document = ls.workspace.get_document( params.text_document.uri )
    source: str = text_doc.source
    # validate format if source is determined
    diagnostics: List[Diagnostic] = _validate_format( ls, source ) if source is not None else []
    # return diagnostics
    ls.publish_diagnostics( text_doc.uri, diagnostics )


def _validate_format(ls: dclLSPServer, source: str):
    """Validates file format."""
    # get input stream of characters for lexer
    input_stream: InputStream = InputStream( source )

    # set the input stream and reset the lexer/parser/listener
    ls.error_listener.reset()
    ls.lexer.inputStream = input_stream
    ls.tokenStream = CommonTokenStream( ls.lexer )
    ls.parser.setInputStream( ls.tokenStream )

    try:
        # launch parser by invoking top-level rule
        ls.parser.configurationModel()
    except OSError as err:
        # TODO add exception
        msg = err.filename.msg

        ls.error_listener.diagnostics.append( msg )

    # return diagnostics
    return ls.error_listener.diagnostics


def get_symbol_name_at_position(uri, position):
    logger.info( 'uri: %s\n', uri, 'position: %s\n', position )


def lookup_symbol(uri, name):
    logger.info( 'uri: %s\n', uri, 'name: %s\n', name )


@dcl_server.feature( TEXT_DOCUMENT_COMPLETION, CompletionOptions( trigger_characters=[','] ) )
def completions(params: Optional[CompletionParams] = None) -> CompletionList:
    """Returns completion items."""

    # set input stream of characters for lexer
    text_doc: Document = dcl_server.workspace.get_document( params.text_document.uri )
    source: str = text_doc.source
    input_stream: InputStream = InputStream( source )

    # reset the lexer/parser
    dcl_server.error_listener.reset()
    dcl_server.lexer.inputStream = input_stream
    dcl_server.tokenStream = CommonTokenStream( dcl_server.lexer )
    dcl_server.parser.setInputStream( dcl_server.tokenStream )


    # launches parser by invoking top-level rule
    Top_levelContext = DeclarationParser.DeclarationModelContext
    parseTree: Top_levelContext = dcl_server.parser.configurationModel()

    # get token index under caret position
    # params.position.line + 1 as lsp line counts from 0 and antlr4 line counts from 1
    tokenIndex: TokenPosition = computeTokenPosition( parseTree, dcl_server.tokenStream,
                                                      CaretPosition( params.position.line + 1,
                                                                     params.position.character ) )

    # set emtpy return list
    completionList: CompletionList = CompletionList( is_incomplete=False, items=[] )

    # return if no index could be determined
    if tokenIndex is None:
        # TODO add exception
        return completionList

    # launch c3 core with parser
    core: CodeCompletionCore = CodeCompletionCore( dcl_server.parser )

    core.ignoredTokens = {Token.EPSILON}
    core.preferredRules = {DeclarationParser, DeclarationParser}

    # get completion candidates
    candidates: CandidatesCollection = core.collectCandidates( tokenIndex.index )

    # TODO add interesting rules

    if any( rule in candidates.rules for rule in [None] ):

        symbolTableVisitor: SymbolTableVisitor = SymbolTableVisitor( 'completions' )

        symbolTable = symbolTableVisitor.visit( parseTree )

        variables = suggestVariables( symbolTable, tokenIndex )

        for variable in variables:
            completionList.items.append( CompletionItem( label=variable ) )

    # get labels of completion candidates to return
    labels_list: List[str] = []
    for key, _ in candidates.tokens.items():
        completionList.items.append( CompletionItem(
            label=IntervalSet.elementName( IntervalSet, dcl_server.parser.literalNames,
                                           dcl_server.parser.symbolicNames, key ) ) )

    # return completion candidates labels
    return completionList


@dcl_server.feature( TEXT_DOCUMENT_DID_CHANGE )
def did_change(ls, params: DidChangeTextDocumentParams):
    """Text document did change notification."""
    _validate( ls, params )


@dcl_server.feature( TEXT_DOCUMENT_DID_CLOSE )
def did_close(server: dclLSPServer, params: DidCloseTextDocumentParams):
    """Text document did close notification."""
    server.show_message( 'Text Document Did Close' )


@dcl_server.feature( TEXT_DOCUMENT_DID_SAVE )
def did_save(server: dclLSPServer, params: DidSaveTextDocumentParams):
    """Text document did save notification."""

    # set input stream of characters for lexer
    text_doc: Document = dcl_server.workspace.get_document( params.text_document.uri )
    source: str = text_doc.source
    input_stream: InputStream = InputStream( source )

    # reset the lexer/parser
    dcl_server.error_listener.reset()
    dcl_server.lexer.inputStream = input_stream
    dcl_server.tokenStream = CommonTokenStream( dcl_server.lexer )
    dcl_server.parser.setInputStream( dcl_server.tokenStream )

    Top_levelContext = DeclarationParser.DeclarationModelContext
    parseTree: Top_levelContext = dcl_server.parser.configurationModel()

    # TODO

    server.show_message( 'Text Document Did Save' )


@dcl_server.feature( TEXT_DOCUMENT_DID_OPEN )
async def did_open(ls, params: DidOpenTextDocumentParams):
    """Text document did open notification."""
    ls.show_message( 'Text Document Did Open' )
    _validate( ls, params )


@dcl_server.feature( TEXT_DOCUMENT_SEMANTIC_TOKENS_FULL,
                     SemanticTokensLegend( token_types=["operator"], token_modifiers=[] ) )
def semantic_tokens(ls: dclLSPServer, params: SemanticTokensParams):
    """See https://microsoft.github.io/language-server-protocol/specification#textDocument_semanticTokens
    for details on how semantic tokens are encoded."""

    TOKENS = re.compile( '".*"(?=:)' )

    uri = params.text_document.uri
    doc = ls.workspace.get_document( uri )

    last_line = 0
    last_start = 0

    data = []

    for lineno, line in enumerate( doc.lines ):
        last_start = 0

        for match in TOKENS.finditer( line ):
            start, end = match.span()
            data += [(lineno - last_line), (start - last_start), (end - start), 0, 0]

            last_line = lineno
            last_start = start

    return SemanticTokens( data=data )


@dcl_server.command( dclLSPServer.CMD_PROGRESS )
async def progress(ls: dclLSPServer, *args):
    """Create and start the progress on the client."""
    token = 'token'
    # Create
    await ls.progress.create_async( token )
    # Begin
    ls.progress.begin( token, WorkDoneProgressBegin( title='Indexing', percentage=0 ) )
    # Report
    for i in range( 1, 10 ):
        ls.progress.report( token, WorkDoneProgressReport( message=f'{i * 10}%', percentage=i * 10 ), )
        await asyncio.sleep( 2 )
    # End
    ls.progress.end( token, WorkDoneProgressEnd( message='Finished' ) )


@dcl_server.command( dclLSPServer.CMD_REGISTER_COMPLETIONS )
async def register_completions(ls: dclLSPServer, *args):
    """Register completions method on the client."""
    params = RegistrationParams( registrations=[Registration( id=str( uuid.uuid4() ), method=TEXT_DOCUMENT_COMPLETION,
                                                              register_options={"triggerCharacters": "[':']"} )] )
    response = await ls.register_capability_async( params )
    if response is None:
        ls.show_message( 'Successfully registered completions method' )
    else:
        ls.show_message( 'Error happened during completions registration.', MessageType.Error )


@dcl_server.command( dclLSPServer.CMD_UNREGISTER_COMPLETIONS )
async def unregister_completions(ls: dclLSPServer, *args):
    """Unregister completions method on the client."""
    params = UnregistrationParams(
        unregisterations=[Unregistration( id=str( uuid.uuid4() ), method=TEXT_DOCUMENT_COMPLETION )] )
    response = await ls.unregister_capability_async( params )
    if response is None:
        ls.show_message( 'Successfully unregistered completions method' )
    else:
        ls.show_message( 'Error happened during completions unregistration.', MessageType.Error )
