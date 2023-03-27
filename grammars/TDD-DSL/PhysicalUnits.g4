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
 *  PhysicalUnits and must match the filename: PhysicalUnits.g4
 *
 *  TODO description This grammar defines the units for physical values.
 *
 *  author Sven Gundlach
 */
grammar PhysicalUnits;

/** imports include all rules, imported rules are overwritten by existing rules */
import TDDLexerRules;

/** parser rules start with lowercase letters */
unitSpec        : units+=composedUnit ( '*' units+=composedUnit)*
                ;

composedUnit    : numerator=basicUnit (
                      ('/' denominator=basicUnit)
                    | ('**' exponent=INT)
                  )
                | basicUnit
                ;

basicUnit       : siUnit
                | customUnit
                | '(' unitSpec ')'
                ;

siUnit          : (prefix=unitPrefix)? type=siType
                ;

customUnit      : name=STRING
                ;



/** SI prefixes */
unitPrefix      : noP = 'noP'
                | quetta = 'Q'
                | ronna = 'R'
                | yotta = 'Y'
                | zetta = 'Z'
                | exa   = 'E'
                | peta  = 'P'
                | tera  = 'T'
                | giga  = 'G'
                | mega  = 'M'
                | kilo  = 'k'
                | hecto = 'h'
                | deca  = 'da'
                | deci  = 'd'
                | centi = 'c'
                | mili  = 'm'
                | micro = 'μ'
                | nano  = 'n'
                | pico  = 'p'
                | femto = 'f'
                | atto  = 'a'
                | zepto = 'z'
                | yocto = 'y'
                | ronto = 'r'
                | quecto = 'q'
                ;

/** SI Unit symbols */
siType          : second    = 's'
                | metre     = 'm'
                | gram      = 'g'
                | ampere    = 'A'
                | kelvin    = 'K'
                | mole      = 'mol'
                | candela   = 'cd'
                | pascal    = 'Pa'
                | joule     = 'J'
                | ton       = 't'
                ;
