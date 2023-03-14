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
import Assertion,Typing,PhysicalUnits,CommonLexerRules;

/** parser rules start with lowercase letters */

/** The start rule; begin parsing here */
sut            : 'SUT' name=ID
                  ('GLB' vars+=var ( ',' vars+=var)*)?
                  systemScope=scope
                  subSystems+=sut ( ',' subSystems+=sut)*
                  assertions+=assertion ( ',' assertions+=assertion)*
                ;

input           : 'IN' params+=var ( ',' params+=var)*
                ;

output          : 'OUT' params+=var ( ',' params+=var)*
                ;

scope           : 'SCOPE'
                  (path=FILEPATH)?
                  (module=ID | program=ID)?
                ;

var           :  value=expr (type=paramType)? ':' (name=ID)? (',' doc=documentation)?
                ;

assertion       : 'ASSERT'
                  ppDirective=directive
                  inputs+=input
                  outputs+=output
                  message=STRING
                ;

documentation   : phyUnit=unitSpec
                | description=STRING
                | phyUnit=unitSpec ',' description=STRING
                ;

expr            : left=expr op=(OP_MUL|OP_DIV) right=expr # mulDivExpr /** token attributes (e.g. left and right) are reference labels to distinguish ambiguous token instances references */
                | left=expr op=(OP_ADD|OP_SUB) right=expr # addSubExpr
                | PAR_L expr PAR_R                        # parensExpr
                | value=NUM                               # numberExpr
                ;

/** lexer rules start with uppercase letters */
OP_MUL   : '*' ;                                       // assigns token name to '*' used above in grammar
OP_DIV   : '/' ;
OP_ADD   : '+' ;
OP_SUB   : '-' ;
PAR_L    : '(' ;                                       // match left parenthesis
PAR_R    : ')' ;                                       // match right parenthesis

/** overwrite imported rules */
