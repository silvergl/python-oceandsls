from enum import Enum
from dataclasses import dataclass


class UnitKind( Enum ):
    """
    Rough categorization of a unit from SI units.
    """
    Unknown = 0
    Second = 1
    Metre = 2
    # TODO si unit is kilogram | added to FundamentalUnit
    Gram = 3
    Ampere = 4
    Kelvin = 5
    Mole = 6
    Candela = 7
    # TODO add non si units?
    Pascal = 8
    Joule = 9
    ton = 10
    
    def s(t):
        return t
    
@dataclass
class Unit:
    """
    The root unit. Used for unit symbols
    """
    name: str
    kind: UnitKind

    
class FundamentalUnit( Unit ):
    """
    A single class for all fundamental units which are mostly SI units. They are distinguished via the kind field.
    """

    def __init__(self, name: str, baseTypes = [], unitKind=UnitKind.Unknown):
        super().__init__(name = name, kind = unitKind)

def stringToUnitType(input : str):
    for kind in UnitKind:
        if vars(kind)["_name_"].lower() == input.lower():
            return kind
    return UnitKind.Unknown

def visitSiunit():
    return FundamentalUnit(name = "Ampere", unitKind = stringToUnitType("Ampere"))

print(visitSiunit())
    