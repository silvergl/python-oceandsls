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
 *  SimpleGrammar and must match the filename: SimpleGrammar.g4
 *
 *  This grammar serves as a test grammar for development.
 *
 *  author Sven Gundlach
 */
grammar SimpleGrammar;

/** parser rules start with lowercase letters */

/** The start rule; begin parsing here */
prog:   stat*                                   # startProg // possible empty statement
    ;

stat:   FOO BAR FOO NEWLINE                     # statLabel /** label can be any identifier that doesn't collide with a rule name */
    ;

// lexer rules with uppercase letters
FOO     :   [f][o][o] ;
BAR     :   [b][a][r] ;
SGU     :   [s][g][u] ;
NEWLINE :   '\r'? '\n' ;                                // return newlines to parser (is end-statement signal)
WS      :   [ \t]+ -> channel(HIDDEN) ;                 // hide spaces and tabs from the parser but generate tokens