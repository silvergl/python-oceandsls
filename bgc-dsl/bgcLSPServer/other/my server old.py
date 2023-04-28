# altered, to react to bgc-file opening (not done, yet)

import asyncio
import json
import re
import time
import uuid
from json import JSONDecodeError
from typing import Optional
from antlr4 import InputStream, CommonTokenStream     

from lsprotocol.types import (TEXT_DOCUMENT_COMPLETION, TEXT_DOCUMENT_DID_CHANGE,
                               TEXT_DOCUMENT_DID_CLOSE, TEXT_DOCUMENT_DID_OPEN,
                               TEXT_DOCUMENT_SEMANTIC_TOKENS_FULL)
from lsprotocol.types import (CompletionItem, CompletionList, CompletionOptions,
                              CompletionParams, ConfigurationItem,
                              Diagnostic,
                              DidChangeTextDocumentParams,
                              DidCloseTextDocumentParams,
                              DidOpenTextDocumentParams, MessageType, Position,
                              Range, Registration, RegistrationParams,
                              SemanticTokens, SemanticTokensLegend, SemanticTokensParams,
                              Unregistration, UnregistrationParams,
                              WorkDoneProgressBegin, WorkDoneProgressEnd,
                              WorkDoneProgressReport,
                              WorkspaceConfigurationParams)
from pygls.server import LanguageServer

COUNT_DOWN_START_IN_SECONDS = 10
COUNT_DOWN_SLEEP_IN_SECONDS = 1


class BgcDslLanguageServer(LanguageServer):
    CMD_COUNT_DOWN_BLOCKING = 'countDownBlocking'
    CMD_COUNT_DOWN_NON_BLOCKING = 'countDownNonBlocking'
    CMD_PROGRESS = 'progress'
    CMD_REGISTER_COMPLETIONS = 'registerCompletions'
    CMD_SHOW_CONFIGURATION_ASYNC = 'showConfigurationAsync'
    CMD_SHOW_CONFIGURATION_CALLBACK = 'showConfigurationCallback'
    CMD_SHOW_CONFIGURATION_THREAD = 'showConfigurationThread'
    CMD_UNREGISTER_COMPLETIONS = 'unregisterCompletions'

    CONFIGURATION_SECTION = 'BgcDslServer'

    def __init__(self, *args):
        super().__init__(*args)

#######

def main():
    print('###########test')
    # a = BgcDslLanguageServer()
    # _validate_bgc(a, params)

######

bgcDsl_server = BgcDslLanguageServer('pygls-BgcDsl-example', 'v0.1')

# ls steht für BgcDslLanguageServer (siehe main branch)
def _validate(ls, params):
    ls.show_message_log('Validating bgc-file...')

    text_doc = ls.workspace.get_document(params.text_document.uri)

    source = text_doc.source
    diagnostics = _validate_bgc(ls, source) if source else []

    ls.publish_diagnostics(text_doc.uri, diagnostics)

# copied from example from main branch
def _validate_bgc(ls: BgcDslLanguageServer, source: str):
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
        ls.parser.stat()
    except OSError as err:
        # TODO add exception
        msg = err.filename.msg

        ls.error_listener.diagnostics.append( msg )

    # return diagnostics
    return ls.error_listener.diagnostics

# def _validate_bgc(source):
#     """Validates bgc-file."""
#     diagnostics = []

#     try:
#         # hier muss noch an bgc angepasst werden, incl parser
#         # alt: json.loads(source)
#         # hinweis: ls.parser.stat()

#         input_stream = InputStream(source)   # old: FileStream('example2.bgc')
#         lexer = BgcDslLexer(input_stream)
#         stream = CommonTokenStream(lexer)
#         parser = BgcDslParser(stream)     # returns object of class "Parser"

#         tree = parser.bgcModel()  # tree ist ein ctx-objekt
#         # symbolTable = My_SymbolTableVisitor('SymbolTableVisitor_1').visit(tree)

#     # unnötig?
#     except OSError as err:
#         msg = err.msg
#         col = err.colno
#         line = err.lineno

#         d = Diagnostic(
#             range=Range(
#                 start=Position(line=line - 1, character=col - 1),
#                 end=Position(line=line - 1, character=col)
#             ),
#             message=msg,
#             source=type(bgcDsl_server).__name__
#         )

#         diagnostics.append(d)

#     return diagnostics


@bgcDsl_server.feature(TEXT_DOCUMENT_DID_CHANGE)
def did_change(ls, params: DidChangeTextDocumentParams):
    """Text document did change notification."""
    _validate(ls, params)


@bgcDsl_server.feature(TEXT_DOCUMENT_DID_CLOSE)
def did_close(server: BgcDslLanguageServer, params: DidCloseTextDocumentParams):
    """Text document did close notification."""
    server.show_message('Text Document Did Close')


@bgcDsl_server.feature(TEXT_DOCUMENT_DID_OPEN)
async def did_open(ls, params: DidOpenTextDocumentParams):
    """Text document did open notification."""
    ls.show_message('Text Document Did Open')
    _validate(ls, params)

main()