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
lexer grammar TDDLexerRules;
/** lexer rules start with uppercase letters */

// Identifiers
ID : [a-zA-Z][a-zA-Z0-9_]* ;  // match identifiers
FILEPATH : [-.a-zA-Z0-9:/\\]+ ;    // match filepath

// Case insensitive keywords
TEST: T E S T;
IN : I N;
OUT : O U T;
/** fragments generate no lexer tokens */
fragment A : [aA]; // match either an 'a' or 'A'
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];

// String literals
STRING : '"' [^"]* '"' ;    // match strings

// Numeric literals
INT : '0' | [1-9] DIG* ;    // fragment match integers without leading zeros
NUM : '-'? ('.' DIG+ | DIG+ ('.' DIG*)? EXP? ) ;    // match numbers
/** fragments generate no lexer tokens */
fragment EXP  : [eE] [+\-]? INT ;    // fragment match exponent
fragment CHAR : [a-zA-Z] ; // fragment match characters
fragment DIG  : [0-9] ; // fragment match digits

// Unit symbols
METER : 'm' ;
SECOND : 's' ;
KILOGRAM : 'kg' ;
AMP : 'A' ;
KELVIN : 'K' ;
MOLE : 'mol' ;
CANDELA : 'cd' ;

// Operators
OP_ASS   : '=' ;
OP_MUL   : '*' ;
OP_DIV   : '/' ;
OP_ADD   : '+' ;
OP_SUB   : '-' ;

// Parentheses
PAR_L    : '(' ;                                       // match left parenthesis
PAR_R    : ')' ;                                       // match right parenthesisPAR_L
SPAR_L    : '[' ;                                       // match left square brackets
SPAR_R      : ']' ;                                       // match right square brackets


// Punctuations
COMMA : ',' ;
SEMICOLON : ';' ;
COLON : ':' ;
HASH : '#' ;
ATSIGN : '@' ;
UNDERSCRORE: '_' ;
QUESTIONMARK: '?' ;
DQUOTATIONMARK : '"' ;
SQUOTATIONMARK: '\'' ;

// Newlines, whitespace and comments
COMMENT :   '//' .*? NEWLINE -> channel(HIDDEN) ; // hide comments from parser, match '//' until newline optionally preceded by a carriage return
NEWLINE :   '\r'? '\n' ;    // return newlines wiht optional carriage return to parser (is end-statement signal)
WS :        [ \t]+ -> channel(HIDDEN) ; // hide spaces and tabs from the parser but generate tokens aka toss out whitespace
