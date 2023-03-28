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
grammar TestSuite;

/** imports include all rules, imported rules are overwritten by existing rules */
import Assertion, Typing, PhysicalUnits, CommonLexerRules;

/** test_suite ; top-level rule; begin parsing here */
test_suite              : test_cases+=test_case
                          (NEWLINE test_cases+=test_case+)*
                        ;

/** test case*/
test_case               : 'test' ID ':' NEWLINE
                          test_assertions+=test_assertion
                          (NEWLINE test_assertions+=test_assertion)*
                        ;

/** test assertion ends on newline */
test_assertion          : directive '(' NEWLINE
                          test_input test_output (COMMENT)?     /** ends on newline */
                          ')'
                        ;

/** test input ends on newline*/
test_input              : 'in' ':' NEWLINE
                          parameter+    /** ends on newline */
                        ;

/** test output ends on newline */
test_output             : 'out' ':' NEWLINE
                          parameter+     /** ends on newline */
                        ;

/** IO parameter ends on newline */
parameter               : arithmeticExpression (parameterDeclaration)? optionalParDesc  /** ends on newline */
                        ;

/** ensure non description to be newline */
optionalParDesc         : NEWLINE                                                               # emptyDesc
                        | ',' unitSpec optionalComment                                          # specDesc      /** ends on newline */
                        ;

/** ensure non comment to be newline */
optionalComment         : NEWLINE                                                               # emptyComment
                        | COMMENT                                                               # specComment   /** ends on newline */
                        ;

/** optional IO parameter declaration */
parameterDeclaration    : name=ID                                                               # nameDecl
                        | type=paramType                                                        # typeDecl
                        | name=ID ':' type=paramType                                            # combinedDecl
                        ;

/** arithmetic expression for value calculation */
arithmeticExpression    : '(' inner=arithmeticExpression ')'                                    # parensExpr    /** Parenthesized expression */
                        | left=arithmeticExpression op=('*' | '/') right=arithmeticExpression   # mulDivExpr    /** Multiplication, Division have precedence */
                        | left=arithmeticExpression op=('+' | '-') right=arithmeticExpression   # addSubExpr    /** Addition, Subtraction have not precedence */
                        | value=NUM                                                             # numberExpr
                        | value=STRING                                                          # strExpr
                        | value=INT                                                             # intExpr
                        ;