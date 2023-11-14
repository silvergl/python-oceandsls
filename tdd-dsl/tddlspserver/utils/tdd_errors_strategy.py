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
from antlr4.error.ErrorStrategy import DefaultErrorStrategy
from antlr4.error.Errors import InputMismatchException
from antlr4.Parser import Parser


class TDDErrorStrategy(DefaultErrorStrategy):

    def reportInputMismatch( self, recognizer: Parser, e: InputMismatchException ):
        msg = " expecting " + e.getExpectedTokens().toString(recognizer.literalNames, recognizer.symbolicNames)

        recognizer.notifyErrorListeners(msg, e.offendingToken, e)