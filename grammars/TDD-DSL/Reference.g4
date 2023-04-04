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
 *  TODO description This grammars defines referenceable rules
 *
 *  author Sven Gundlach
 */
grammar Reference;

/** imports include all rules, imported rules are overwritten by existing rules */
import CommonLexerRules;

/** arithmetic expression for value calculation */
expr                    : '(' inner=expr ')'                    # parensExpr    /** Parenthesized expression */
                        | left=expr op=('*' | '/') right=expr   # mulDivExpr    /** Multiplication, Division have precedence */
                        | left=expr op=('+' | '-') right=expr   # addSubExpr    /** Addition, Subtraction have not precedence */
                        | op=('+' | '-') right=expr             # testExpr
                        | value=(NUM | DP)                      # numberExpr
                        | value=STRING                          # strExpr
                        | value=INT                             # intExpr
                        | value=reference                       # refExpr
                        ;

/** function or variables to lookup in the symboltable */
reference               : name=ID '(' (args+=expr(',' args+=expr)*)? ')'  # funRef        /** function call like f(), f(x), f(1,2) */
                        | name=ID                                           # varRef
                        ;