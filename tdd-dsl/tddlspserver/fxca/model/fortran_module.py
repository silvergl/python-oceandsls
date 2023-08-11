"""Elements for Fortran statements from fxtran parsing"""

__author__ = 'sgu'

from typing import Set, final

from common_block import CommonBlock
from containment_hash_map import ContainmentHashMap
from fortran_operation import FortranOperation
from fortran_variable import FortranVariable


class FortranModule:
    """ source for class Module statement """

    # TODO use dependencies?
    # TODO Subroutine?
    # TODO Function?
    # TODO Program?

    @final
    @property
    def used_modules(self) -> Set:
        return self._used_modules

    @final
    @property
    def operations(self) -> ContainmentHashMap[str, FortranOperation]:
        return self._operations

    @final
    @property
    def module_name(self) -> str:
        return self._module_name

    @final
    @property
    def named_module(self) -> bool:
        return self._named_module

    # TODO add Document if needed
    # @final
    # @property
    # def document (self) -> Document:
    #     return self._document

    @final
    @property
    def file_name(self) -> str:
        return self._file_name

    @final
    @property
    def common_blocks(self) -> ContainmentHashMap[str, CommonBlock]:
        return self._common_blocks

    @final
    @property
    def variables(self) -> ContainmentHashMap[str, FortranVariable]:
        return self._variables

    @property
    def parent(self) -> object:
        return self._parent

    @parent.setter
    def parent(self, parent):
        self._parent = parent

    def __init__(self, module_name, file_name, named_module, document):
        self._module_name = module_name
        self._named_module = named_module
        self._file_name = file_name
        # self._document = document

        self._used_modules = set()
        self._operations = ContainmentHashMap(self)
        self._common_blocks = ContainmentHashMap(self)
        self._variables = ContainmentHashMap(self)

        self._parent = object()

    def __str__(self):
        """ toString method """
        return self.file_name + ":" + self.module_name
