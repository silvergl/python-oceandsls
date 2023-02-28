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
 *  Typing and must match the filename: Typing.g4
 *
 *  TODO description This grammar defines types of preprocessing directives for pfUnit 4.0.
 *
 *  author Sven Gundlach
 */
grammar Assertion;

/** imports include all rules, imported rules are overwritten by existing rules */

/** parser rules start with lowercase letters */
directive       : ppDirective  = 'assertEqual'
                | ppDirective  = 'assertTrue'
                | ppDirective  = 'assertEqualUserDefined'
                | ppDirective  = 'assertFalse'
                | ppDirective  = 'assertLessThan'
                | ppDirective  = 'assertLessThanOrEqual'
                | ppDirective  = 'assertGreaterThan'
                | ppDirective  = 'assertGreaterThanOrEqual'
                | ppDirective  = 'assertIsMemberOf'
                | ppDirective  = 'assertContains'
                | ppDirective  = 'assertAny'
                | ppDirective  = 'assertAll'
                | ppDirective  = 'assertNotAll'
                | ppDirective  = 'assertNone'
                | ppDirective  = 'assertIsPermutationOf'
                | ppDirective  = 'assertExceptionRaised'
                | ppDirective  = 'assertSameShape'
                | ppDirective  = 'assertIsNaN'
                | ppDirective  = 'assertIsFinite'
                | ppDirective  = 'assertAssociated'
                | ppDirective  = 'assertNotAssociated'
                | ppDirective  = 'assertEquivalent'
                ;
