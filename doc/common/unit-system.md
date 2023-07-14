# OceanDSL Unit System

Units in OceanDSL can be any combination of SI or custom units using
standard prefixes, such as k for kilo or m for milli. They can have
exponents to express areas, volumes or other higher dimensions.

As some values can be unit-less, it is possible to specify a variable,
function or value without a unit. To express more complex unit, it
is necessary to create composite units, such as kg m² / s².

Units are used to ensure that only valid numbers are assigned to values.
The OceanDSL DSLs allow to convert compatible units. That means if a parameter
is declared as using meter, but the assigned value is specified with the unit
km, the value is automatically converted to meter.
Similarly, Celsius and Kelvin are converted accordingly.

## Grammar

```antlr

// ----------------------
// Units
// ----------------------

// substance is of type substanceDeclaration
unit:
	':' units=unitElement+ (substance=ID)? |
	'::'
;

unitElement:
	prefixUnit | groupUnit | exponentUnit
;

// removed unit-label for UNIT_STRING, here
prefixUnit:
	(UNIT_STRING | custom=CUSTOM_STRING)
;

groupUnit:
	'(' elements+=unitElement+ ')'
;

exponentUnit:
    unit=unitElement '^' exponent=NUMBER

```

The rule `unit` allows to compose a unit out of one or more unit
elements, or skip the unit with `::`.
The ability to have a sequence of units in `groupUnit` and `unit`
seems to be unnecessary complicated, but from a users point of view, it
allows you to avoid braces for more basic composites, such as Nm and kg m²/s².
The former would be two `prefixUnit`s and the latter one with `kg` followed by
two `exponentUnit`s, i.e., `m ^ 2` and `s ^-2`.
The negative index value expresses the fraction (/).

Each unit can have an substance identifier. This is used in BGC-DSL to ensure
that substances are not mixed.
In future, this could be extended to allow certain mixtures to create new
kind of substances.

A unit is comprised at least of one `unitElement`. Each `unitElement` is either
a `prefixUnit`, an `groupUnit` or an `exponentUnit`.

A `prefixUnit` is either an SI unit with or without an SI prefix, or a
custom unit identifier. It can be used to specify simple units of measurement.

`groupUnit` allows to group `unitElement`s together. This can be helpful to
express more complex units which may arose during calculations. For example, the
kg m^2 s^2 unit can also be written as kg (m s^-1)^2. While this might not
seem to be necessary in many cases, we have found examples in the literature
that required grouping.

`exponentUnit` is used to express any unit with an exponent, e.g., m^2.
The exponent numbers can be positive or negative.

## SI Unit Parsing

SI units comprise of an optional prefix and one or more character to define a base unit.

Prefixes are: https://www.nist.gov/pml/owm/metric-si-prefixes
- Q R Y Z E P T G M k h da d c m my n p f a z y r q
Units are: https://en.wikipedia.org/wiki/International_System_of_Units
- s m g A K mol cd Hz J C W rad sr N Pa V F Ohm S Wb T H °C lm lx Bq Gy Sv kat

**Rules**
Here is a list of mapping rules for SI unit string. ($ indicates line end)
m -> meter
mm -> milli mmeter
mmol -> milli mol
my -> micro

**Note:** The original Java code can be found here. However, it is more complicated as it is also able to process exponents and other symbols.
https://git.se.informatik.uni-kiel.de/oceandsl/cp-dsl/-/blob/master/bundles/org.oceandsl.configuration/src/org/oceandsl/configuration/parser/UnitParser.java


## Representation

The grammar implies a specific CST structure for units. Here we go beyond this,
as it better represents basic units and prefixes.

```
class Unit
  units : List<UnitElement>

abstract class UnitElement

class PrefixUnit extends UnitElement

class PrefixSIUnit extends PrefixUnit
  basicUnit : EUnit
  prefix : EPRefix

class PrefixCustomUnit extends PrefixUnit
  unitName : String

```

Discuss: Should custom units also have a prefix and how do we process these?

```
class ExponentUnit extends UnitElement
  unit : UnitElement
  exponent : integer
  
class GroupUnit extends UnitElement
  units : List<UnitElement>
```

## Semantics

Unit semantics are similar to normal type system semantics, however, there are
also some subtle differences. Therefore, we explain basic semantic rules here.
Please note that units can be much more complicated (see normalization).

T,R,S are unit type placeholders
t,r,s are variables, functions or values

### Expression: t + r

```
t : T + r : T
-------------
  t + r : T
```

This expresses that in an addition both need to have the same unit.
Regarding substances, the substance can be different, as it is possible that
different substances are mixed. They can even create new substances.

### Expression: t - r

```
t : T - r : T
-------------
  t - r : T
```

This expresses that in a subtraction both need to have the same unit.

### Expression: t * r

```
t : T * r : R
-------------
t * r : T * R
```

In case the base type of T and R are the same, the unit can be merged, e.g.,
when multiplying two length (m), the result is area (m^2).

```
                    t * r : T * R and base(T) == base(R)
----------------------------------------------------------------------------
t * r : S and base(S) == base(T) and exponent(S) = exponent(T) + exponent(R)
```

In other cases the unit expression becomes more complex.

### Expression: t / r

Analog the the multiplication, the division leads to a new composite type which
could be merged when both types have the same base unit.

```
t : T / r : R
-------------
t / r : T / R
```

### Expression: f(x_1,...,x_n)

Functions have already a unit type assigned or it can be derived from their
expression. Furthermore, each parameter has a unit assigned.
For mathematical built-in functions, they do not have a type and assume the
type specified by the input type.
Therefore, all input units must be the same unit or without a unit.

### expression: t^i

Exponents require that t has a unit or no unit, but i is a unit less integer
value.

```
                        t : T ^ i : I
------------------------------------------------------------------
t ^ i : S with base(S) = base(T) and exponent(S) = exponent(T) * i
```

## Normalization

Based on the syntax, the same unit can be expressed in different ways. This
can happen due to the sequence of basic units and grouping. The goal of the
normalization is to have one sequence of exponent units which is sorted in
the same order.

Discuss: Shall we do unit normalization in expression, e.g.,
1 m^3 + 1 l would be codes as 1 m^3 + 0.001 m^3.

The normalization works therefore in two phases.
1. All groups get removed.
2. Merge nested `exponentUnit`s.
3. The remaining units are sorted.
4. Units with the same base unit get combined.

### Group elimination

There are two cases of groups.
(a) Group which is the child of an `exponentUnit`
(b) Group which is the child of another `groupUnit` or `unit`

In case (a) each child of the group element, is embedded by a `exponentUnit`.
For example, kg (m s^-1)^2 becomes kg m^2 s^-1^2.
In case (b) the `groupUnit` can be merged directly with the parent `groupUnit` 
or `unit`.

### Exponent Merging

For all `exponentUnit`s in the unit sequence, it is checked whether there is
a nested `exponentUnit`. To eliminate one nesting the outer `exponentUnit`'s 
exponent is multiplied with the exponent of the inner `exponentUnit` and the
inner `exponentUnit`'s unit becomes the outer `exponentUnit`'s unit.
This is repeated until all `exponentUnit`s only contain one `prefixUnit`.

### Sort Units

We iterate over the remaining sequence and replace every `prefixUnit` for an
`exponentUnit` with the exponent value of 1 and set the `prefixUnit` as its 
`unit`.
Then we sort the units on the basis of `prefixUnit`s, i.e., in case in a
sequence, we find a m and a m^2 they are sorted next to each other.

Discuss: Do we ignore prefixes at this point or must we consider prefixes as
well?

### Merge Base Units

Finally, we run over the sequence and look for each value whether the next
value is of the same `prefixUnit` and merge their exponent accordingly, i.e.,
we create the sum of the exponents.
We then replace the two `exponentUnit`s by one with the same `prefixUnit` as
the original and the sum of both exponents.
Then we repeat this with the next `exponentUnit`.
In case the exponent becomes zero both `exponentUnit`s are removed and nothing
is added.




