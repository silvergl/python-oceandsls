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
 *  TestGrammar and must match the filename: TestGrammar.g4
 *
 *  This grammar serves as a test grammar for development.
 *
 *  author Sven Gundlach
 */
grammar TestDrivenDev;

/** imports include all rules, imported rules are overwritten by existing rules */
unit            : 'SUT' name=ID
                  inputs+=input*
                  outputs+=output*
                  subUnits+=unit*
                ;

input           : 'IN' param
                ;

output          : 'OUT' param
                ;

param           :  name=ID type=paramType ':' documentation? ('=' defaultValue=expr)?
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

/**
 * Typing
 */
paramType       : typeRef
                | enumType
                | arrayType
                ;

typeRef         : type=ID
                ;

enumType        : '(' values+=enum ( ',' values+=enum)* ')'
                ;

enum            : name=ID ('=' value=INT)?
                ;

arrayType       : type=ID '[' dimensions+=dim (',' dimensions+=dim)* ']'
                ;

dim             : sizeDim
                | rangeDim
                ;

sizeDim         : (size=INT)?
                ;

rangeDim        : lowerBound=INT ':'
                |                ':' upperBound=INT
                | lowerBound=INT ':' upperBound=INT
                ;

/**
 * Physical Units
 */

unitSpec        : units+=composedUnit ( '*' units+=composedUnit)*
                ;

basicUnit       : siUnit
                | customUnit
                | '(' unitSpec ')'
                ;

siUnit          : (prefix=unitPrefix)? type=siType
                ;

customUnit      : name=STRING
                ;

composedUnit    : numerator=basicUnit (('/' denominator=basicUnit) | ('**' exponent=INT))
                | basicUnit
                ;

unitPrefix      : noP = 'noP'
                | yotta = 'yotta'
                | zetta = 'zetta'
                | exa   = 'exa'
                | peta  = 'peta'
                | tera  = 'tera'
                | giga  = 'giga'
                | mega  = 'mega'
                | kilo  = 'kilo'
                | hecto = 'hecto'
                | deca  = 'deca'
                | deci  = 'deci'
                | centi = 'centi'
                | mili  = 'mili'
                | micro = 'micro'
                | nano  = 'nano'
                | pico  = 'pico'
                | femto = 'femto'
                | atto  = 'atto'
                | zepto = 'zepto'
                | yocto = 'yocto'
                ;

siType          : meter   = 'meter'
                | gram    = 'gram'
                | ton     = 'ton'
                | second  = 'second'
                | ampere  = 'ampere'
                | kelvin  = 'kelvin'
                | mole    = 'mole'
                | candela = 'candela'
                | pascal  = 'pascal'
                | joul    = 'Joul'
                ;

/** parser rules start with lowercase letters */

/** The start rule; begin parsing here */


/** lexer rules start with uppercase letters */
OP_MUL : '*' ;                                       // assigns token name to '*' used above in grammar
OP_DIV : '/' ;
OP_ADD : '+' ;
OP_SUB : '-' ;
PAR_L  : '(' ;                                       // match left parenthesis
PAR_R  : ')' ;                                       // match right parenthesis

ID     : '^'? [a-zA-Z_] [a-zA-Z0-9_]* ;      // match identifiers
STRING : CHAR+ ;                             // match strings

NUM    : '-'? ('.' DIG+ | DIG+ ('.' DIG*)? EXP? ) ;  // match numbers
INT    : '0' | [1-9] DIG* ;                     // fragment match integers without leading zeros
/** fragments generate no lexer tokens */
fragment EXP  : [eE] [+\-]? INT ;                      // fragment match exponent
fragment CHAR : [a-zA-Z] ;                             // fragment match characters
fragment DIG  : [0-9] ;                                // fragment match digits

/** overwrite imported rules */
