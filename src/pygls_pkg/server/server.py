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
import asyncio
import re
import time
import uuid
from typing import Optional

# util imports
import sys, os

# user
from src.pygls_pkg.server.utils.computeTokenIndex import computeTokenPosition, computeTokenIndex, CaretPosition, TokenPosition

if not os.path.join( sys.path[0], 'src', 'pygls_pkg', 'server' ) in sys.path:
    sys.path.append( os.path.join( sys.path[0], 'src', 'pygls_pkg', 'server' ) )
from DiagnosticListener import DiagnosticListener

# antlr4
if not os.path.join( sys.path[0], 'build-python' ) in sys.path:
    sys.path.append( os.path.join( sys.path[0], 'build-python' ) )
from antlr4 import InputStream, CommonTokenStream
from TestGrammar.TestGrammarLexer import TestGrammarLexer
from TestGrammar.TestGrammarParser import TestGrammarParser
from TestGrammar.TestGrammarVisitor import TestGrammarVisitor
#antlr4-c3
from CodeCompletionCore.CodeCompletionCore import CodeCompletionCore
# pygls
from typing import List

# debug import
# from pprint import pprint
# pprint(sys.path)

from pygls.lsp.methods import (COMPLETION, TEXT_DOCUMENT_DID_CHANGE, TEXT_DOCUMENT_DID_CLOSE, TEXT_DOCUMENT_DID_OPEN, TEXT_DOCUMENT_SEMANTIC_TOKENS_FULL)
from pygls.lsp.types import (CompletionItem, CompletionList, CompletionOptions, CompletionParams, ConfigurationItem, ConfigurationParams, Diagnostic, DidChangeTextDocumentParams,
                             DidCloseTextDocumentParams, DidOpenTextDocumentParams, MessageType, Position, Range, Registration, RegistrationParams, SemanticTokens,
                             SemanticTokensLegend, SemanticTokensParams, Unregistration, UnregistrationParams)
from pygls.lsp.types.basic_structures import (WorkDoneProgressBegin, WorkDoneProgressEnd, WorkDoneProgressReport)
from pygls.server import LanguageServer

COUNT_DOWN_START_IN_SECONDS = 10
COUNT_DOWN_SLEEP_IN_SECONDS = 1


class ODslLanguageServer( LanguageServer ):
    CMD_COUNT_DOWN_BLOCKING = 'countDownBlocking'
    CMD_COUNT_DOWN_NON_BLOCKING = 'countDownNonBlocking'
    CMD_PROGRESS = 'progress'
    CMD_REGISTER_COMPLETIONS = 'registerCompletions'
    CMD_SHOW_CONFIGURATION_ASYNC = 'showConfigurationAsync'
    CMD_SHOW_CONFIGURATION_CALLBACK = 'showConfigurationCallback'
    CMD_SHOW_CONFIGURATION_THREAD = 'showConfigurationThread'
    CMD_UNREGISTER_COMPLETIONS = 'unregisterCompletions'

    CONFIGURATION_SECTION = 'ODslServer'

    def __init__(self, *args):
        super().__init__( *args )
        # set ErrorListener
        self.error_listener: DiagnosticListener = DiagnosticListener()
        # set empty input stream
        input_stream: InputStream = InputStream( str() )

        # set lexer
        self.lexer: TestGrammarLexer = TestGrammarLexer( input_stream )
        # set ErrorListener for diagnostics
        self.lexer.removeErrorListeners()
        self.lexer.addErrorListener( self.error_listener )

        # set token stream pipe between lexer and parser
        self.tokenStream: CommonTokenStream = CommonTokenStream( self.lexer )

        # set parser
        self.parser: TestGrammarParser = TestGrammarParser( self.tokenStream )
        # set ErrorListener for diagnostics
        self.parser.removeErrorListeners()
        self.parser.addErrorListener( self.error_listener )


odsl_server = ODslLanguageServer( 'pygls-odsl-prototype', 'v0.1' )


def _validate(ls: ODslLanguageServer, params):
    ls.show_message_log( 'Validating file...' )

    text_doc = ls.workspace.get_document( params.text_document.uri )

    source = text_doc.source
    diagnostics = _validate_format( ls, source ) if source else []

    ls.publish_diagnostics( text_doc.uri, diagnostics )


def _validate_format(ls: ODslLanguageServer, source):
    """Validates file format."""
    # create input stream of characters for lexer
    input_stream = InputStream( source )

    # set the input stream and reset the lexer/parser/listener
    ls.error_listener.reset()
    ls.lexer.inputStream = input_stream
    ls.tokenStream = CommonTokenStream( ls.lexer )
    ls.parser.setInputStream( ls.tokenStream )

    try:
        # launch parser by invoking startrule
        ls.parser.prog()
    except OSError as err:
        msg = err.filename.msg

        ls.error_listener.diagnostics.append( msg )

    return ls.error_listener.diagnostics

@odsl_server.feature( COMPLETION, CompletionOptions( trigger_characters=[','] ) )
def completions(params: Optional[CompletionParams] = None) -> CompletionList:
    """Returns completion items."""

    text_doc = odsl_server.workspace.get_document( params.text_document.uri )

    source = text_doc.source

    # create input stream of characters for lexer
    input_stream = InputStream( source )

    # set the input stream and reset the lexer/parser/listener
    odsl_server.error_listener.reset()
    odsl_server.lexer.inputStream = input_stream
    odsl_server.tokenStream = CommonTokenStream( odsl_server.lexer )
    odsl_server.parser.setInputStream( odsl_server.tokenStream )

    tokenPosition: TokenPosition = computeTokenPosition(odsl_server.parser.prog(), odsl_server.tokenStream, CaretPosition(params.position.line + 1, params.position.character))

    if tokenPosition is None:
        return CompletionList( is_incomplete=False, items=[] )

    # return getSuggestionsForParseTree(parser, parseTree, () => new SymbolTableVisitor().visit(parseTree), position)

    # launch c3 core with parser:Parser, preferredRules:tuple, ignoredTokens:tuple
    core: CodeCompletionCore = CodeCompletionCore(odsl_server.parser)

    candidates = core.collectCandidates(tokenPosition.index)

    return CompletionList(
        is_incomplete=False, items=[
            CompletionItem( label='"' ),
            CompletionItem( label='[' ),
            CompletionItem( label=']' ),
            CompletionItem( label='{' ),
            CompletionItem( label='}' ),
        ]
    )


# @odsl_server.thread()
@odsl_server.command( ODslLanguageServer.CMD_COUNT_DOWN_BLOCKING )
def count_down_10_seconds_blocking(ls, *args):
    """Starts counting down and showing message synchronously.
    It will `block` the main thread, which can be tested by trying to show
    completion items.
    """
    for i in range( COUNT_DOWN_START_IN_SECONDS ):
        ls.show_message( f'Counting down... {COUNT_DOWN_START_IN_SECONDS - i}' )
        time.sleep( COUNT_DOWN_SLEEP_IN_SECONDS )


@odsl_server.command( ODslLanguageServer.CMD_COUNT_DOWN_NON_BLOCKING )
async def count_down_10_seconds_non_blocking(ls, *args):
    """Starts counting down and showing message asynchronously.
    It won't `block` the main thread, which can be tested by trying to show
    completion items.
    """
    for i in range( COUNT_DOWN_START_IN_SECONDS ):
        ls.show_message( f'Counting down... {COUNT_DOWN_START_IN_SECONDS - i}' )
        await asyncio.sleep( COUNT_DOWN_SLEEP_IN_SECONDS )


@odsl_server.feature( TEXT_DOCUMENT_DID_CHANGE )
def did_change(ls, params: DidChangeTextDocumentParams):
    """Text document did change notification."""
    _validate( ls, params )


@odsl_server.feature( TEXT_DOCUMENT_DID_CLOSE )
def did_close(server: ODslLanguageServer, params: DidCloseTextDocumentParams):
    """Text document did close notification."""
    server.show_message( 'Text Document Did Close' )


@odsl_server.feature( TEXT_DOCUMENT_DID_OPEN )
async def did_open(ls, params: DidOpenTextDocumentParams):
    """Text document did open notification."""
    ls.show_message( 'Text Document Did Open' )
    _validate( ls, params )


@odsl_server.feature( TEXT_DOCUMENT_SEMANTIC_TOKENS_FULL, SemanticTokensLegend( token_types=["operator"], token_modifiers=[] ) )
def semantic_tokens(ls: ODslLanguageServer, params: SemanticTokensParams):
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


@odsl_server.command( ODslLanguageServer.CMD_PROGRESS )
async def progress(ls: ODslLanguageServer, *args):
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


@odsl_server.command( ODslLanguageServer.CMD_REGISTER_COMPLETIONS )
async def register_completions(ls: ODslLanguageServer, *args):
    """Register completions method on the client."""
    params = RegistrationParams( registrations=[Registration( id=str( uuid.uuid4() ), method=COMPLETION, register_options={"triggerCharacters": "[':']"} )] )
    response = await ls.register_capability_async( params )
    if response is None:
        ls.show_message( 'Successfully registered completions method' )
    else:
        ls.show_message( 'Error happened during completions registration.', MessageType.Error )


@odsl_server.command( ODslLanguageServer.CMD_SHOW_CONFIGURATION_ASYNC )
async def show_configuration_async(ls: ODslLanguageServer, *args):
    """Gets exampleConfiguration from the client settings using coroutines."""
    try:
        config = await ls.get_configuration_async( ConfigurationParams( items=[ConfigurationItem( scope_uri='', section=ODslLanguageServer.CONFIGURATION_SECTION )] ) )

        example_config = config[0].get( 'exampleConfiguration' )

        ls.show_message( f'odslServer.exampleConfiguration value: {example_config}' )

    except Exception as e:
        ls.show_message_log( f'Error ocurred: {e}' )


@odsl_server.command( ODslLanguageServer.CMD_SHOW_CONFIGURATION_CALLBACK )
def show_configuration_callback(ls: ODslLanguageServer, *args):
    """Gets exampleConfiguration from the client settings using callback."""

    def _config_callback(config):
        try:
            example_config = config[0].get( 'exampleConfiguration' )

            ls.show_message( f'odslServer.exampleConfiguration value: {example_config}' )

        except Exception as e:
            ls.show_message_log( f'Error occurred: {e}' )

    ls.get_configuration( ConfigurationParams( items=[ConfigurationItem( scope_uri='', section=ODslLanguageServer.CONFIGURATION_SECTION )] ), _config_callback )


@odsl_server.thread()
@odsl_server.command( ODslLanguageServer.CMD_SHOW_CONFIGURATION_THREAD )
def show_configuration_thread(ls: ODslLanguageServer, *args):
    """Gets exampleConfiguration from the client settings using thread pool."""
    try:
        config = ls.get_configuration( ConfigurationParams( items=[ConfigurationItem( scope_uri='', section=ODslLanguageServer.CONFIGURATION_SECTION )] ) ).result( 2 )

        example_config = config[0].get( 'exampleConfiguration' )

        ls.show_message( f'odslServer.exampleConfiguration value: {example_config}' )

    except Exception as e:
        ls.show_message_log( f'Error occurred: {e}' )


@odsl_server.command( ODslLanguageServer.CMD_UNREGISTER_COMPLETIONS )
async def unregister_completions(ls: ODslLanguageServer, *args):
    """Unregister completions method on the client."""
    params = UnregistrationParams( unregisterations=[Unregistration( id=str( uuid.uuid4() ), method=COMPLETION )] )
    response = await ls.unregister_capability_async( params )
    if response is None:
        ls.show_message( 'Successfully unregistered completions method' )
    else:
        ls.show_message( 'Error happened during completions unregistration.', MessageType.Error )
