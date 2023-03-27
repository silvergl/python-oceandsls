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
import Assertion,Typing,PhysicalUnits,TDDLexerRules;

/** parser rules start with lowercase letters */
/** Top-level rule; begin parsing here */
test_suite      : test_case+
                ;

/** Rule for a test case */
test_case       : TEST ID ':' NEWLINE
                  assertions+=test_assertion
                  ( NEWLINE assertions+=test_assertion )*
                ;

/** Rule for a test assertion */
test_assertion  : ppDirective=directive PAR_L
                    in=test_input NEWLINE
                    out=test_output NEWLINE
                    msg=STRING
                    PAR_R
                  NEWLINE
                ;

/** Rule for a test input */
test_input      : (IN)? params+=var
                  (SEMICOLON params+=var)*
                ;

/** Rule for a test output */
test_output     : (OUT)? params+=var
                  ( SEMICOLON params+=var)*
                ;

var             : value=expr
                  (name=ID)?
                  (COLON type=param)?
                  (COMMA doc=documentation)?
                ;

param           : name=ID
                | type=paramType
                | name=ID COLON type=paramType
                ;

documentation   : phyUnit=unitSpec
                | description=STRING
                | phyUnit=unitSpec HASH description=STRING
                ;

/** Expression rules */
expr            : left=expr op=(OP_MUL|OP_DIV) right=expr # mulDivExpr /** Multiplication, Division have precedence */
                | left=expr op=(OP_ADD|OP_SUB) right=expr # addSubExpr /** Addition, Subtraction have not precedence */
                | PAR_L expr PAR_R                        # parensExpr /** Parenthesized expression */
                | value=NUM                               # numberExpr
                | value=INT                               # intExpr
                | value=STRING                            # strExpr
                ;

/** overwrite imported rules */
