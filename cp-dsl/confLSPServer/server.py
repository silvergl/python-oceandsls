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
from typing import List, Optional, Union

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
from lsprotocol.types import (TEXT_DOCUMENT_COMPLETION, TEXT_DOCUMENT_DID_CHANGE, TEXT_DOCUMENT_DID_CLOSE, TEXT_DOCUMENT_DOCUMENT_SYMBOL,
                              TEXT_DOCUMENT_DID_OPEN, TEXT_DOCUMENT_SEMANTIC_TOKENS_FULL, DocumentSymbol, CompletionItem,
                              CompletionList, CompletionOptions, CompletionParams, ConfigurationItem,
                              ConfigurationParams, Diagnostic, DidChangeTextDocumentParams, DidCloseTextDocumentParams,
                              DidOpenTextDocumentParams, MessageType, Registration, RegistrationParams, SemanticTokens,
                              SemanticTokensLegend, SemanticTokensParams, Unregistration, UnregistrationParams,
                              WorkDoneProgressBegin, WorkDoneProgressEnd, WorkDoneProgressReport, CompletionItemKind,
                              TEXT_DOCUMENT_DID_SAVE, DidSaveTextDocumentParams, DocumentSymbolParams, SymbolInformation, Range, Position, Location)

# user relative imports
from .utils.computeTokenIndex import computeTokenPosition, computeTokenIndex, CaretPosition, TokenPosition
from .utils.suggestVariables import suggestVariables

from .cst.SymbolTableVisitor import SymbolTableVisitor
from .cst.DiagnosticListener import DiagnosticListener

from .gen.python.Configuration.ConfigurationLexer import ConfigurationLexer
from .gen.python.Configuration.ConfigurationParser import ConfigurationParser


from pygls.capabilities import get_capability

COUNT_DOWN_START_IN_SECONDS = 10
COUNT_DOWN_SLEEP_IN_SECONDS = 1


class confLSPServer( LanguageServer ):
    CMD_PROGRESS = 'progress'
    CMD_REGISTER_COMPLETIONS = 'registerCompletions'
    CMD_UNREGISTER_COMPLETIONS = 'unregisterCompletions'

    CONFIGURATION_SECTION = 'ODslCONFServer'

    def __init__(self, *args):
        super().__init__( *args )
        # set ErrorListener
        self.error_listener: DiagnosticListener = DiagnosticListener()
        # set empty input stream
        input_stream: InputStream = InputStream( str() )

        # set lexer
        self.lexer: ConfigurationLexer = ConfigurationLexer( input_stream )
        # set ErrorListener for diagnostics
        self.lexer.removeErrorListeners()
        self.lexer.addErrorListener( self.error_listener )

        # set token stream pipe between lexer and parser
        self.tokenStream: CommonTokenStream = CommonTokenStream( self.lexer )

        # set parser
        self.parser: ConfigurationParser = ConfigurationParser( self.tokenStream )
        # set ErrorListener for diagnostics
        self.parser.removeErrorListeners()
        self.parser.addErrorListener( self.error_listener )


conf_server = confLSPServer( 'pygls-odsl-conf-prototype', 'v0.1' )

logger = logging.getLogger( __name__ )


def _validate(ls: confLSPServer, params):
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


def _validate_format(ls: confLSPServer, source: str):
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


@conf_server.feature( TEXT_DOCUMENT_COMPLETION, CompletionOptions( trigger_characters=[','] ) )
def completions(params: Optional[CompletionParams] = None) -> CompletionList:
    """Returns completion items."""

    # set input stream of characters for lexer
    text_doc: Document = conf_server.workspace.get_document( params.text_document.uri )
    source: str = text_doc.source
    input_stream: InputStream = InputStream( source )

    # reset the lexer/parser
    conf_server.error_listener.reset()
    conf_server.lexer.inputStream = input_stream
    conf_server.tokenStream = CommonTokenStream( conf_server.lexer )
    conf_server.parser.setInputStream( conf_server.tokenStream )


    # launches parser by invoking top-level rule
    Top_levelContext = ConfigurationParser.DeclarationModelContext
    parseTree: Top_levelContext = conf_server.parser.configurationModel()

    # get token index under caret position
    # params.position.line + 1 as lsp line counts from 0 and antlr4 line counts from 1
    tokenIndex: TokenPosition = computeTokenPosition( parseTree, conf_server.tokenStream,
                                                      CaretPosition( params.position.line + 1,
                                                                     params.position.character ) )

    # set emtpy return list
    completionList: CompletionList = CompletionList( is_incomplete=False, items=[] )

    # return if no index could be determined
    if tokenIndex is None:
        # TODO add exception
        return completionList

    # launch c3 core with parser
    core: CodeCompletionCore = CodeCompletionCore( conf_server.parser )

    core.ignoredTokens = {Token.EPSILON}
    core.preferredRules = {ConfigurationParser, ConfigurationParser}

    # get completion candidates
    candidates: CandidatesCollection = core.collectCandidates( tokenIndex.index )

    calcVariables = False

    def calcLitAndSymbNames(literalNames):
        literalNames = []
        symbolic_names = []
        for i in literalNames:
            if i in conf_server.parser.literalNames:
                literalNames.append(i)
            else:
                symbolic_names.append(i)
        return (literalNames, symbolic_names)

    def addToCompletionList(literalNames):
        #get labels of completion candidates to return
        symbolic_names, literal_names = calcLitAndSymbNames(literalNames)
        for key, _ in candidates.tokens.items():
            completionList.items.append(CompletionItem(
                label=IntervalSet.elementName(IntervalSet, literal_names,
                                           symbolic_names, key)))

    

    # Variables finding
    if any( rule in candidates.rules for rule in [ ConfigurationParser.configurationModel ] ):

        symbolTableVisitor: SymbolTableVisitor = SymbolTableVisitor( 'completions' )

        symbolTable = symbolTableVisitor.visit( parseTree )

        variables = suggestVariables( symbolTable, tokenIndex )

        for variable in variables:
            completionList.items.append( CompletionItem( label=variable, kind = CompletionItemKind.Variable ) )

    # return completion candidates labels
    return completionList

def get_lsp_symbol_type(nameOfType : str):
    # predefine some module and function keywords
    #TODO: Edit for ConfigurationDSL
    module = ['model', 'types', 'group', 'required', 'requires', 'excludes', 'sub', 'alternative', 'enum']
    function = ['feature', 'multiple', 'def']
    # Define a regex pattern for literalNames of the parser
    # regex_pattern = DeclarationParser.literalNames
    # regex_pattern = '|'.join(regex_pattern)
    # regexReplaceChars = "()[]*/+."
    # ignoreToken = ["'", "<INVALID>|"]
    # for elem in ignoreToken:
    #     regex_pattern = regex_pattern.replace(elem, "")
    # for elem in regexReplaceChars:
    #     regex_pattern = regex_pattern.replace(elem, "\\" + elem)

    # TOKENS = re.compile(regex_pattern)

    if nameOfType in [x.replace("'", "") for x in ConfigurationParser.literalNames]:
        if nameOfType in module:
            return CompletionItemKind.Module
        if nameOfType in function:
            return CompletionItemKind.Function
        return CompletionItemKind.Keyword
    if nameOfType in ConfigurationParser.symbolicNames:
        return CompletionItemKind.Constructor
    if nameOfType.isdigit():
        return CompletionItemKind.Value
    return CompletionItemKind.Variable

def get_position_and_item_val(inp : str):
    from itertools import groupby

    ret_val = []

    for k, g in groupby(enumerate(inp), lambda x: not x[1].isspace() or x[1] in [",", ":"]):
        if k:
            pos, first_item = next(g)
            item = first_item + ''.join([x for _, x in g])
            ret_val.append([pos, pos + len(item) - 1, item])
    return ret_val


@conf_server.feature(TEXT_DOCUMENT_DOCUMENT_SYMBOL)
def document_symbol(
    server: confLSPServer, params: DocumentSymbolParams
) -> Optional[Union[List[DocumentSymbol], List[SymbolInformation]]]:
    # get the document
    uri = params.text_document.uri
    doc = server.workspace.get_document( uri )

    data = []

    #For capturing strings
    string_entity = False
    string_ident = ""
    start_string = (0,0) # tuple for (lineno, linepos)

    for lineno, line in enumerate( doc.lines ):
        for start, end, word in get_position_and_item_val(line):
            if str(word).startswith(("'", '"')):
                string_entity = True
                string_ident = word[0]
                if str(word).endswith(("'", '"')) and word[-1] == string_ident:
                    pos_range = Range(
                    start = Position(line=lineno, character=start),
                    end = Position(line=lineno, character=end) 
                    )
                    string_entity = False
                    data.append(SymbolInformation(
                        name = "STRING",
                        kind = CompletionItemKind.Text,
                        location = Location(uri=uri, range=pos_range)
                    ))
                start_string = (lineno, start)
            elif string_entity and str(word).endswith(("'", '"')) and word[-1] == string_ident:
                pos_range = Range(
                start = Position(line=start_string[0], character=start_string[1]),
                end = Position(line=lineno, character=end) 
                )
                string_entity = False
                data.append(SymbolInformation(
                    name = "STRING",
                    kind = CompletionItemKind.Text,
                    location = Location(uri=uri, range=pos_range)
                ))
            elif not string_entity:
                pos_range = Range(
                    start = Position(line=lineno, character=start),
                    end = Position(line=lineno, character=end) 
                )
                # for now its only covering keywords, no variables
                data.append(SymbolInformation(
                    name = word,
                    kind = get_lsp_symbol_type(word),
                    location = Location(uri=uri, range=pos_range)
                ))
                print("added SymbolItem:")
                print(str(word) + " " + str(get_lsp_symbol_type(word)))
            else:
                continue
    return data if data else None


@conf_server.feature( TEXT_DOCUMENT_DID_CHANGE )
def did_change(ls, params: DidChangeTextDocumentParams):
    """Text document did change notification."""
    _validate( ls, params )


@conf_server.feature( TEXT_DOCUMENT_DID_CLOSE )
def did_close(server: confLSPServer, params: DidCloseTextDocumentParams):
    """Text document did close notification."""
    server.show_message( 'Text Document Did Close' )


@conf_server.feature( TEXT_DOCUMENT_DID_SAVE )
def did_save(server: confLSPServer, params: DidSaveTextDocumentParams):
    """Text document did save notification."""

    # set input stream of characters for lexer
    text_doc: Document = conf_server.workspace.get_document( params.text_document.uri )
    source: str = text_doc.source
    input_stream: InputStream = InputStream( source )

    # reset the lexer/parser
    conf_server.error_listener.reset()
    conf_server.lexer.inputStream = input_stream
    conf_server.tokenStream = CommonTokenStream( conf_server.lexer )
    conf_server.parser.setInputStream( conf_server.tokenStream )

    Top_levelContext = ConfigurationParser.DeclarationModelContext
    parseTree: Top_levelContext = conf_server.parser.declarationModel()

    # TODO

    server.show_message( 'Text Document Did Save' )


@conf_server.feature( TEXT_DOCUMENT_DID_OPEN )
async def did_open(ls, params: DidOpenTextDocumentParams):
    """Text document did open notification."""
    ls.show_message( 'Text Document Did Open' )
    _validate( ls, params )


@conf_server.feature( TEXT_DOCUMENT_SEMANTIC_TOKENS_FULL,
                     SemanticTokensLegend( token_types=["operator"], token_modifiers=[] ) )
def semantic_tokens(ls: confLSPServer, params: SemanticTokensParams):
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


@conf_server.command( confLSPServer.CMD_PROGRESS )
async def progress(ls: confLSPServer, *args):
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


@conf_server.command( confLSPServer.CMD_REGISTER_COMPLETIONS )
async def register_completions(ls: confLSPServer, *args):
    """Register completions method on the client."""
    params = RegistrationParams( registrations=[Registration( id=str( uuid.uuid4() ), method=TEXT_DOCUMENT_COMPLETION,
                                                              register_options={"triggerCharacters": "[':']"} )] )
    response = await ls.register_capability_async( params )
    if response is None:
        ls.show_message( 'Successfully registered completions method' )
    else:
        ls.show_message( 'Error happened during completions registration.', MessageType.Error )


@conf_server.command( confLSPServer.CMD_UNREGISTER_COMPLETIONS )
async def unregister_completions(ls: confLSPServer, *args):
    """Unregister completions method on the client."""
    params = UnregistrationParams(
        unregisterations=[Unregistration( id=str( uuid.uuid4() ), method=TEXT_DOCUMENT_COMPLETION )] )
    response = await ls.unregister_capability_async( params )
    if response is None:
        ls.show_message( 'Successfully unregistered completions method' )
    else:
        ls.show_message( 'Error happened during completions unregistration.', MessageType.Error )
