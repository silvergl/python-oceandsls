"""pygls json feature test"""
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

# TODO add src

############################################################################
############################################################################

# utils import
import json

# pytest
import pytest
from unittest import SkipTest
from mock import Mock

# pygls
# Deprecated from 0.13
# from pygls.lsp.types import (DidCloseTextDocumentParams,
#                              DidOpenTextDocumentParams, TextDocumentIdentifier,
#                              TextDocumentItem)
# Migrating to pygls v1.0
# https://pygls.readthedocs.io/en/latest/pages/migrating-to-v1.html
from lsprotocol.types import (DidCloseTextDocumentParams, DidOpenTextDocumentParams, TextDocumentIdentifier, TextDocumentItem)
from pygls.workspace import Document, Workspace

# user relative imports
from server import completions, did_close, did_open


# fail relative import beyond top-level package
# try:
#     from ..exampleLSPServer.server import completions, did_close, did_open
# except Exception as inst:
#     # debug import
#     import sys, os
#     from pprint import pprint
#     pprint(sys.path)
#     raise SkipTest("Skipping all tests in test_feature.py")


class FakeServer():
    """We don't need real server to unit test features."""
    publish_diagnostics = None
    show_message = None
    show_message_log = None

    def __init__(self):
        self.workspace = Workspace('', None)


fake_document_uri = 'file://fake_doc.txt'
fake_document_content = 'text'
fake_document = Document(fake_document_uri, fake_document_content)

server = FakeServer()
server.publish_diagnostics = Mock()
server.show_message = Mock()
server.show_message_log = Mock()
server.workspace.get_document = Mock(return_value=fake_document)


def _reset_mocks():
    server.publish_diagnostics.reset_mock()
    server.show_message.reset_mock()
    server.show_message_log.reset_mock()


def test_completions():
    completion_list = completions()
    labels = [i.label for i in completion_list.items]

    assert '"' in labels
    assert '[' in labels
    assert ']' in labels
    assert '{' in labels
    assert '}' in labels


def test_did_close():
    _reset_mocks()

    params = DidCloseTextDocumentParams(
        text_document=TextDocumentIdentifier(uri=fake_document_uri)
    )

    did_close(server, params)

    # Check if show message is called
    server.show_message.assert_called_once()


@pytest.mark.asyncio
async def test_did_open():
    _reset_mocks()

    expected_msg = None

    # Get expected error message
    try:
        json.loads(fake_document_content)
    except json.JSONDecodeError as err:
        expected_msg = err.msg

    params = DidOpenTextDocumentParams(
        text_document=TextDocumentItem(
            uri=fake_document_uri,
            language_id='json',
            version=1,
            text=fake_document_content
        )
    )

    await did_open(server, params)

    # Check publish diagnostics is called
    server.publish_diagnostics.assert_called_once()

    # Check publish diagnostics args message
    args = server.publish_diagnostics.call_args
    assert args[0][1][0].message is expected_msg

    # Check other methods are called
    server.show_message.assert_called_once()
    server.show_message_log.assert_called_once()
