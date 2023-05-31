''' enum test file'''

__author__ = 'sgu'

from enum import Enum
from typing import final

class Foobar:
    def __init__( self ):
        self._fileName = 'Foobar'

    @final
    @property
    def fileName (self) -> str:
        return self._fileName

foobar = Foobar()

print(foobar.fileName)

class Mood(Enum):

    FUNKY = 1

    HAPPY = 3


    def describe(self):

        # self is the member here

        return self.name, self.value


    def __str__(self):

        return 'my custom str! {0}'.format(self.name)

    def merge(self, direction):
        match self:
            case self.FUNKY:
                # return 'merge FUNKY: {0}'.format(self.name)
                match direction:
                    case self.FUNKY:
                        return 'merge FUNKY FUNKY: {0}'.format(self.name)

                    case self.HAPPY:
                        return 'merge FUNKY HAPPY: {0}'.format(self.name)

            case self.HAPPY:
                # return 'merge HAPPY: {0}'.format(self.name)
                match direction:
                    case self.FUNKY:
                        return 'merge HAPPY FUNKY: {0}'.format(self.name)

                    case self.HAPPY:
                        return 'merge HAPPY HAPPY: {0}'.format(self.name)

    @classmethod

    def favorite_mood(cls):

        # cls here is the enumeration

        return cls.HAPPY

print(Mood.favorite_mood())

print(Mood.HAPPY.describe())

print(str(Mood.FUNKY))

print(Mood.HAPPY.merge(Mood.FUNKY))
