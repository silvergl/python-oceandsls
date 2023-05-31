"""Elements for Fortran statements from fxtran parsing"""

__author__ = 'sgu'

from typing import List


class FortranSubroutine:
    """
    Subroutine statement
    """

    # TODO use dependencies?

    name: str
    arguments: List[ str ]
    variables: List[ str ]


class FortranFunction:
    """
    Function statement
    """

    # TODO intern variables?

    name: str
    arguments: List[ str ]
    result: str
    variables: List[ str ]


class FortranProgram:
    """
    Program statement
    """

    name: str
    variables: List[ str ]
    dependencies: List[ str ]
