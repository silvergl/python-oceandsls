"""Elements for Fortran statements from fxtran parsing"""

__author__ = 'sgu'

from EDirection import EDirection


class FortranVariable:
    """ source for class FortranVariable """

    @property
    def name( self ) -> str:
        return self._name

    @property
    def type( self ) -> str:
        return self._type

    @type.setter
    def type( self, type_ ):
        self._type = type_

    @property
    def direction( self ) -> EDirection:
        return self._direction

    @direction.setter
    def direction( self, direction ):
        self._direction = direction

    @property
    def parent( self ) -> object:
        return self._parent

    @parent.setter
    def parent( self, parent ):
        self._parent = parent

    # @property
    # def sources (self) -> Set[IDataflowEndpoint]:
    #     return self._sources

    def __init__( self, name ):
        # self._sources = set ()
        self._direction = EDirection.NONE
        self._name = name

        self._parent = None
        self._type = None

    def addDirection( self, value ):
        match self._direction:
            case EDirection.NONE:
                self.direction = value
            case EDirection.BOTH:
                self._direction = EDirection.BOTH
            case EDirection.READ:
                match value:
                    case EDirection.NONE:
                        self._direction = EDirection.READ
                    case EDirection.BOTH:
                        self._direction = EDirection.BOTH
                    case EDirection.READ:
                        self._direction = EDirection.READ
                    case EDirection.WRITE:
                        self._direction = EDirection.BOTH
            case EDirection.WRITE:
                match value:
                    case EDirection.NONE:
                        self._direction = EDirection.READ
                    case EDirection.BOTH:
                        self._direction = EDirection.BOTH
                    case EDirection.READ:
                        self._direction = EDirection.BOTH
                    case EDirection.WRITE:
                        self._direction = EDirection.WRITE
