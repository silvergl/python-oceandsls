/**
 *  Copyright (C) 2021 OceanDSL (https://oceandsl.uni-kiel.de)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  Grammars always start with a grammar header. This grammar is called
 *  CommonLexerRules and must match the filename: CommonLexerRules.g4
 *
 *  TODO description This grammar defines common rules for lexer tokens.
 *
 *  author Sven Gundlach
 */
grammar CommonLexerRules;

// lexer rules with uppercase letters
ID       : '^'? [a-zA-Z_] [a-zA-Z0-9_]* ;              // match identifiers
STRING   : ( CHAR | ' ' )+ ;                                     // match strings
FILEPATH : [-.a-zA-Z0-9:/\\]+ ;                        // match filepath

NUM      : '-'? ('.' DIG+ | DIG+ ('.' DIG*)? EXP? ) ;  // match numbers
INT      : '0' | [1-9] DIG* ;                          // fragment match integers without leading zeros
/** fragments generate no lexer tokens */
fragment EXP  : [eE] [+\-]? INT ;                      // fragment match exponent
fragment CHAR : [a-zA-Z] ;                             // fragment match characters
fragment DIG  : [0-9] ;                                // fragment match digits

NEWLINE :   '\r'? '\n' ;                                // return newlines to parser (is end-statement signal)
WS      :   [ \t]+ -> skip ;                            // suppress the generation of the spaces and tabs token