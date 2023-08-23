"""Elements for Fortran statements from fxtran parsing"""

__author__ = "sgu"

from functools import reduce
from typing import Dict, List, Tuple, final

from containment_hash_map import ContainmentHashMap
from fortran_module import FortranModule
from fortran_operation import FortranOperation


class FortranProject:
    """ source for class FortranProject """

    @final
    @property
    def modules(self) -> Dict[str, FortranModule]:
        """Actual list to which List-calls are delegated."""
        return self._modules

    # TODO remove if no further needed
    # def getModules(self) -> Dict[str, FortranModule]:
    #     return self._modules

    #  note this is a temporary hack until dataflow properly supports a default module.
    @property
    def default_module(self) -> FortranModule:
        return self._default_module

    @default_module.setter
    def default_module(self, default_module):
        self._default_module = default_module

    @final
    @property
    def calls(self) -> List[Tuple[Tuple[FortranModule, FortranOperation], Tuple[FortranModule, FortranOperation]]]:
        return self._calls

    # TODO add if dataflow is needed
    # @final
    # @property
    # def dataflows (self) -> List[Tuple[Tuple[FortranModule, IDataflowEndpoint], Tuple[FortranModule, IDataflowEndpoint]]]:
    #     return self._dataflows

    def __init__(self):
        """Constructs Project Model with empty content."""
        self._modules = ContainmentHashMap(self)
        self._calls = []

        self._default_module = None

    def __str__(self):
        """ toString method """
        return reduce((lambda projectStr, moduleStr: f"{projectStr}, {moduleStr}"), map((lambda module: module.file_name), self._modules.values()))
