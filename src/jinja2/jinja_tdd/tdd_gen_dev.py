#!/usr/bin/env python

__author__ = 'sgu'

# TODO license

#
#  pfUnit generator using jinja2 templates to generate Fortran Unit Tests
#

from enum import Enum
from typing import List, Optional
from dataclasses import dataclass, field

from jinja2 import Environment, FileSystemLoader


## Python 3.11 alternative
# from enum import StrEnum
#
# class CallableType(StrEnum):
#     Function = 'function',
#     Subroutine = 'subroutine',
#     Procedure = 'procedure',
#     Subprogram = 'subprogram',
#     Method = 'method'
#
# @dataclass
# class Callable:
#     """
#     Subroutine for unit tests
#     """
#     name: str
#     type: CallableType


class CallableType( Enum ):
    """
    Type of callables for unit tests
    """
    Function = 'function'
    Subroutine = 'subroutine'


@dataclass
class Callable:
    """
    Subroutine for unit tests
    """
    name: str
    _type: CallableType

    @property
    def type(self) -> Optional[CallableType]:
        return self._type.value

    @type.setter
    def type(self, new_type: Optional[CallableType]) -> None:
        self._type = new_type


@dataclass
class Module:
    """
    Module for unit tests
    """
    name: str


@dataclass
class Assertion:
    """
    pFUnit assertions for unit tests
    """
    name: str
    input: int
    output: int


@dataclass
class Utest:
    """
    Unit-test
    """
    fn: str
    callable: Callable
    mods: List[Module] = field( default_factory=list )
    assertions: List[Assertion] = field( default_factory=list )

    # def __init__(self, fn: str, mods= [], assertions=[]):
    #     self.fn = fn
    #     self.mods = mods
    #     self.assertions = assertions


import os

# Define the number of variable occurrences for each test
num_files = 1
num_mods = 1
num_ass = 1
list_tests = []
for i in range( num_files ):
    list_mods = []
    for j in range( num_mods ):
        # list_mods.append( {'name': f"module_{i}_{j}"} )
        list_mods.append( Module( f"module_{i}_{j}" ) )

    list_ass = []
    for j in range( num_mods ):
        # list_ass.append( {'name': f"assertion_{i}_{j}", 'input': i, 'output': j} )
        list_ass.append( Assertion( f"assertion_{i}_{j}", i, j ) )

    # list_tests.append( {'fn': f"file_{i}", 'sub': {'name': f"sub_{i}"}, 'mods': list_mods, 'assertions': list_ass} )
    list_tests.append( Utest( f"file_{i}", Callable( f"sub_{i}", CallableType.Subroutine ), list_mods, list_ass ) )

# Load Jinja2 template
environment = Environment( loader=FileSystemLoader( 'templates/' ) )
# Use test_template.txt
template = environment.get_template( 'tdd_pf_template.txt' )

# Loop through each test
for test in list_tests:
    # Render template
    content = template.render( test=test )

    # Define the folder and filename
    path = os.path.join( os.getcwd(), 'gen', 'test' )

    # Create folder if it doesn't exist
    if not os.path.isdir( path ):
        os.makedirs( path )
        print( f'... create {path}' )

    # Create file if it doesn't exist
    # filename = f"test_{test['fn'].lower()}.pf"
    filename = f"test_{test.fn.lower()}.pf"
    path = os.path.join( os.getcwd(), path, filename )
    if not os.path.exists( path ):
        # Write rendered content to file
        with open( path, mode='w', encoding='utf-8' ) as f:
            f.write( content )
            print( f'... wrote {path}' )
