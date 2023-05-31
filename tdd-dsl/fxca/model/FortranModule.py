"""Elements for Fortran statements from fxtran parsing"""

__author__ = 'sgu'

from typing import Set, final

from CommonBlock import CommonBlock
from ContainmentHashMap import ContainmentHashMap
from FortranOperation import FortranOperation
from FortranVariable import FortranVariable


class FortranModule:
    """ source for class Module statement """

    # TODO use dependencies?
    # TODO Subroutine?
    # TODO Function?
    # TODO Program?

    @final
    @property
    def usedModules( self ) -> Set:
        return self._usedModules

    @final
    @property
    def operations( self ) -> ContainmentHashMap[ str, FortranOperation ]:
        return self._operations

    @final
    @property
    def moduleName( self ) -> str:
        return self._moduleName

    @final
    @property
    def namedModule( self ) -> bool:
        return self._namedModule

    # TODO add Document if needed
    # @final
    # @property
    # def document (self) -> Document:
    #     return self._document

    @final
    @property
    def fileName( self ) -> str:
        return self._fileName

    @final
    @property
    def commonBlocks( self ) -> ContainmentHashMap[ str, CommonBlock ]:
        return self._commonBlocks

    @final
    @property
    def variables( self ) -> ContainmentHashMap[ str, FortranVariable ]:
        return self._variables

    @property
    def parent( self ) -> object:
        return self._parent

    @parent.setter
    def parent( self, parent ):
        self._parent = parent

    def __init__( self, moduleName, fileName, namedModule, document ):
        self._moduleName = moduleName
        self._namedModule = namedModule
        self._fileName = fileName
        # self._document = document

        self._usedModules = set( )
        self._operations = ContainmentHashMap( self )
        self._commonBlocks = ContainmentHashMap( self )
        self._variables = ContainmentHashMap( self )

        self._parent = object( )

    def __str__( self ):
        """ toString method """
        return self.fileName + ":" + self.moduleName
