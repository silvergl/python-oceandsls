"""Elements for Fortran statements from fxtran parsing"""

__author__ = 'sgu'


class ContainmentHashMap( dict ):
    """ HashMap containing variables """

    def __init__( self, parent, mapping = None, /, **kwargs ):
        self.parent = parent
        super( ).__init__( mapping )

    def __setitem__( self, key, value ):
        value.setParent( self.parent )
        super( ).__setitem__( key, value )
