"""Elements for Fortran statements from fxtran parsing"""

__author__ = 'sgu'


class ContainmentHashMap(dict):
    """ HashMap containing variables """

    def __init__(self, parent, mapping=None, *my_args, **kwargs):
        self.parent = parent
        super().__init__(mapping)

    def __setitem__(self, key, value):
        value.set_parent(self.parent)
        super().__setitem__(key, value)
