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
lexer grammar CommonLexerRules;

// Identifiers
ID: [a-zA-Z][a-zA-Z0-9_]*;                                      // match identifiers

// TODO comment
// Strings and comments
STRING          : '\'' (ESC|.)*? '\'';
COMMENT         : '#' (ESC|.)*? NEWLINE;
fragment ESC    : '\\' [btnr'"\\];

// Numeric literals
INT             : '0' | [1-9] DIG* ;                            // fragment match integers without leading zeros
NUM             : '-'? (('.' DIG+)| (DIG+ ('.' DIG*)? EXP?));   // match numbers
DP              : '-'? (('.' DIG+)| (DIG+ ('.' DIG*)? DEXP?));  // match numbers
fragment EXP    : [eE] [+\-]? DIG+;                             // fragment match exponent
fragment DEXP   : 'D' [+\-]? DIG+;                              // fragment match double precision exponent
fragment DIG    : [0-9];                                        // fragment match digits

// Newlines, whitespace and comments
TDD_COMMENT     :   '//' .*? NEWLINE -> channel(HIDDEN);        // hide comments from parser, match '//' until newline optionally preceded by a carriage return
NEWLINE         : '\r'? '\n';                                   // return newlines wiht optional carriage return to parser (is end-statement signal)
WS              : [ \t]+ -> channel(HIDDEN);                    // hide spaces and tabs from the parser but generate tokens aka toss out whitespace