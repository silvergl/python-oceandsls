"""Elements for Fortran statements from fxtran parsing"""

__author__ = "sgu"

from typing import final


class FortranParameter:
    """ source for class FortranParameter """

    @final
    @property
    def name(self) -> str:
        return self._name

    @property
    def type(self) -> str:
        return self._type

    @type.setter
    def type(self, type_):
        self._type = type_

    @property
    def direction(self) -> EDirection:
        return self._direction

    @direction.setter
    def direction(self, direction):
        self._direction = direction

    @property
    def parent(self) -> object:
        return self._parent

    @parent.setter
    def parent(self, parent):
        self._parent = parent

    @property
    def position(self) -> int:
        return self._position

    @position.setter
    def position(self, position):
        self._position = position

    def __init__(self, name, position):
        self._direction = EDirection.NONE
        self._name = name
        self._position = position

        self._parent = None
        self._type = None

    def add_direction(self, value):
        match self._direction:
            case EDirection.NONE:
                self._direction = value
            case EDirection.READ:
                if value == EDirection.WRITE or value == EDirection.BOTH:
                    self._direction = EDirection.BOTH
                else:
                    self._direction = EDirection.READ
            case EDirection.WRITE:
                if value == EDirection.READ or value == EDirection.BOTH:
                    self._direction = EDirection.BOTH
                else:
                    self._direction = EDirection.WRITE
            case EDirection.BOTH:
                self._direction = EDirection.BOTH
