"""Elements for Fortran statements from fxtran parsing"""

__author__ = 'sgu'

from ContainmentHashMap import ContainmentHashMap


class CommonBlock:
    """ source for class CommonBlock """

    @final
    @property
    def name( self ) -> str:
        return self._name

    @final
    @property
    def variables( self ) -> ContainmentHashMap[ str, FortranVariable ]:
        return self._variables

    @final
    @property
    def node( self ):
        return self._node

    @property
    def parent( self ) -> object:
        return self._parent

    @parent.setter
    def parent( self, parent ):
        self._parent = parent

    def __init__( self, name, node ):
        self._name = name
        self._node = node

        self._variables = ContainmentHashMap( self )
        self._parent = object( )
