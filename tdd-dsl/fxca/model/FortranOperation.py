"""Elements for Fortran statements from fxtran parsing"""

__author__ = 'sgu'

from typing import Set, final

from CommonBlock import CommonBlock
from ContainmentHashMap import ContainmentHashMap
from FortranModule import FortranModule
from FortranParameter import FortranParameter
from FortranVariable import FortranVariable


class FortranOperation:
    """ source for class FortranOperation """

    @final
    @property
    def name( self ) -> str:
        return self._name

    @final
    @property
    def commonBlocks( self ) -> ContainmentHashMap[ str, CommonBlock ]:
        return self._commonBlocks

    @final
    @property
    def variables( self ) -> ContainmentHashMap[ str, FortranVariable ]:
        return self._variables

    @final
    @property
    def parameters( self ) -> ContainmentHashMap[ str, FortranParameter ]:
        return self._parameters

    @final
    @property
    def usedModules( self ) -> Set[ str ]:
        return self._usedModules

    # TODO add node if needed
    # @final
    # @property
    # def node (self) -> Node:
    #     return self._node

    @property
    def module( self ) -> FortranModule:
        return self._module

    @module.setter
    def module( self, module ):
        self._module = module

    @property
    def parent( self ):
        return self._parent

    @parent.setter
    def parent( self, parent ):
        self._parent = parent

    @property
    def implicit( self ) -> bool:
        return self._implicit

    @implicit.setter
    def implicit( self, implicit ):
        self._implicit = implicit

    @final
    @property
    def variableArguments( self ) -> bool:
        return self._variableArguments

    @final
    @property
    def function( self ) -> bool:
        return self._function

    def __init__( self, name, node, function, variableArguments = False ):
        self._name = name
        # self._node = node
        self._variableArguments = variableArguments
        self._function = function

        self._commonBlocks = ContainmentHashMap( self )
        self._variables = ContainmentHashMap( self )
        self._parameters = ContainmentHashMap( self )
        self._usedModules = set( )

        self._implicit = None
        self._module = None
        self._parent = None

    def __str__( self ):
        """ toString method """
        return f"op {self.name}"
