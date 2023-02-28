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
import CommonLexerRules;

/** parser rules start with lowercase letters */
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