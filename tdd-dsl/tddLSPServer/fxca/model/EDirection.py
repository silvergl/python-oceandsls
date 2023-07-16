"""Elements for Fortran statements from fxtran parsing"""

__author__ = 'sgu'

from enum import Enum


class EDirection( Enum ):
    """ FortranVariable directions """
    READ = 1
    WRITE = 2
    BOTH = 3
    NONE = 4

    def merge( self, direction ):
        match self:
            case self.NONE:
                return direction

            case self.BOTH:
                return self.BOTH

            case self.READ:
                match direction:
                    case self.NONE:
                        return self.READ
                    case self.BOTH:
                        return self.BOTH
                    case self.READ:
                        return self.READ
                    case self.WRITE:
                        return self.BOTH

            case self.WRITE:
                match direction:
                    case self.NONE:
                        return self.READ
                    case self.BOTH:
                        return self.BOTH
                    case self.READ:
                        return self.BOTH
                    case self.WRITE:
                        return self.READ
