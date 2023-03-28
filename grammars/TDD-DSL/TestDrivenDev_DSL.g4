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
 *  TestDrivenDev and must match the filename: TestDrivenDev.g4
 *
 *  TODO description This grammars defines pfUnit4.0 Scripts
 *
 *  author Sven Gundlach
 */
grammar TestDrivenDev_DSL;

/** imports include all rules, imported rules are overwritten by existing rules */
//import Assertion,Typing,PhysicalUnits,TDDLexerRules;
import Assertion;

/** parser rules start with lowercase letters */
/** Top-level rule; begin parsing here */
test_suite      : test_cases+=test_case ( NEWLINE test_cases+=test_case )?
                ;

/** Rule for a test case */
test_case       : 'test' ID ':' NEWLINE?
                  assertions+=test_assertion
                  ( NEWLINE assertions+=test_assertion )*
                ;

/** Rule for a test assertion */
test_assertion  : ppDirective=directive PAR_L NEWLINE?
                    in=test_input NEWLINE
                    out=test_output
                    (
                        NEWLINE cm=COMMENT PAR_R
                      | NEWLINE? PAR_R
                    )
                ;

/** Rule for a test input */
test_input      : 'in' params+=param
                  (SEMICOLON params+=param)*
                ;

/** Rule for a test output */
test_output     : 'out' params+=param
                  ( SEMICOLON params+=param)*
                ;

param           : value=expr
//                  (decl=var)?
//                  (COMMA doc=documentation)?
                ;

//var             : name=ID
//                | type=paramType
//                | name=ID ':' type=paramType
//                ;
//
//documentation   : phyUnit=unitSpec
//                | description=COMMENT
//                | phyUnit=unitSpec description=COMMENT
//                ;

/** Expression rules */
expr            : left=expr op=(OP_MUL|OP_DIV) right=expr # mulDivExpr /** Multiplication, Division have precedence */
                | left=expr op=(OP_ADD|OP_SUB) right=expr # addSubExpr /** Addition, Subtraction have not precedence */
                | PAR_L expr PAR_R                        # parensExpr /** Parenthesized expression */
                | value=INT                               # intExpr
                | value=NUM                               # numberExpr
                | value=STRING                            # strExpr
                ;

/** overwrite imported rules */
// Identifiers
ID : [a-zA-Z][a-zA-Z0-9_]* ;  // match identifiers

// Punctuations
SEMICOLON : ';' ;

// Operators
OP_ASS   : '=' ;
OP_MUL   : '*' ;
OP_DIV   : '/' ;
OP_ADD   : '+' ;
OP_SUB   : '-' ;

// Parentheses
PAR_L    : '(' ;                                       // match left parenthesis
PAR_R    : ')' ;                                       // match right parenthesis

// String literals
STRING : '\'' (STRESC|.)*? '\'';
fragment STRESC : '\\\'' | '\\\\' ;
COMMENT : '#' (CMESC|.)*? NEWLINE;
fragment CMESC : '\\#' | '\\\\' ;

// Numeric literals
INT : '0' | [1-9] DIG* ;    // fragment match integers without leading zeros
NUM : '-'? (('.' DIG+ )| ( DIG+ ('.' DIG*)? EXP? ) ) ;    // match numbers
/** fragments generate no lexer tokens */
fragment EXP  : [eE] [+\-]? INT ;    // fragment match exponent
//fragment CHAR : [a-zA-Z_] ; // fragment match characters
fragment DIG  : [0-9] ; // fragment match digits


// Newlines, whitespace and comments
TDD_COMMENT :   '//' .*? NEWLINE -> channel(HIDDEN) ; // hide comments from parser, match '//' until newline optionally preceded by a carriage return
NEWLINE :   '\r'? '\n' ;    // return newlines wiht optional carriage return to parser (is end-statement signal)
WS :        [ \t]+ -> channel(HIDDEN) ; // hide spaces and tabs from the parser but generate tokens aka toss out whitespace