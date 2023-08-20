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
import Keyword, Typing, Reference, PhysicalUnits, CommonLexerRules;

/** test_suite ; top-level rule; begin parsing here */
test_suite              : 'suite' name=ID ':' NEWLINE
                          cases+=test_case
                          (NEWLINE cases+=test_case+)*
                        ;

/** test case*/
test_case               : 'test' name=ID ':' NEWLINE
                          'srcpath' ':' srcpath=src_path
                          scope=test_scope
                          vars=test_vars
                          assertions+=test_assertion
                          (NEWLINE assertions+=test_assertion)*
                        ;

// TODO use special literal for filepath eg FILEPATH : [-.a-zA-Z0-9:/\\]+ ;
/** Placeholder for code completion of system path to source code files*/
src_path                : path=STRING NEWLINE
                        ;

/** variables used in test case; ends on newline*/
test_vars               : 'var' ':' NEWLINE
                          vars+=test_var+
                        ;

/** variables used in test case*/
test_var                : decl=varDeclaration ('=' value=expr)? comment=optionalDesc  /** ends on newline */
                        ;

/** declaration of variables used in test cases  */
varDeclaration          : name=ID ':' type=paramType (',' keys+=f90StdKey (',' keys+=f90StdKey)*)?
                        ;

/** scope of test case*/
test_scope              : 'scope' ':' NEWLINE
                          modules=use_modules
                        ;

/** modules used in the test; ends on newline*/
use_modules            : 'modules' ':'  NEWLINE
                          modules+=test_module+
                        ;

/** modules names; ends on newline*/
test_module             : name=ID NEWLINE
                        ;

/** test assertion; ends on newline */
test_assertion          : 'assert' directive=test_directive '(' NEWLINE
                          'in' ':' NEWLINE input=test_parameter     /** ends on newline */
                          'out' ':' NEWLINE output=test_parameter   /** ends on newline */
                          attr=pubAttributes (comment=COMMENT)?     /** ends on newline */
                          ')'
                        ;

/** arguments of pfUnit prepparser rules start with lowercase letters */
pubAttributes           : ('tolerance' ':' tol=expr NEWLINE)?
                          ('failmessage' ':' msg=STRING NEWLINE)?
                          ('whitespace' '=' ign='IGNORE_DIFFERENCES')?       /** option for assertEqual */
                        ;

/** IO parameter; ends on newline */
test_parameter          : (decl=parameterDeclaration '=')? value=expr comment=optionalDesc  /** ends on newline */
                        ;

/** optional description for declarations; ensures non description to be newline */
optionalDesc            : NEWLINE                               # emptyDesc
                        | ',' type=unitSpec comment=optionalComment          # specDesc      /** ends on newline */
                        ;

/** ensure non comment to be newline */
optionalComment         : NEWLINE                               # emptyComment
                        | comment=COMMENT                               # specComment   /** ends on newline */
                        ;

/** optional IO parameter declaration */
parameterDeclaration    : name=reference                        # nameDecl
                        | type=paramType                        # typeDecl
                        | name=reference ':' type=paramType     # combinedDecl
                        ;