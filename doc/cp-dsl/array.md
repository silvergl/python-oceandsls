# Arrays in CP-DSL

Arrays are a common element of programming languages and are widely used to
configure functions in earth system models. In the past, arrays were merely
blocks of memory split in identical elements of one type. They could be
multidimensional which then require a more complex way to map indices to
memory location, e.g., `int[2][4]` would either require two blocks of 4
integers or 4 blocks of 2 integers. The location function would be

```location(i_0,i_1) = (i_0*4+i_1)*sizeof(int)```

This becomes more complex when arrays are dynamic, i.e., they are defined
with dimensions `d_0 ... d_n-1`, but the respective sizes for each dimension are
unknown at compile time. For two dimensions, this would look like

```location(i_0,i_1) = (i_0*d_1+i_1)*sizeof(int)```

This implies an order where the second dimension (d_1) has scalar elements, and
the first dimension (d_0) is a list of array of dimension d_1. Thus, the index
must be multiplied by the length of d_1.

```math
location(i_0,...,i_n) = sizeof(int) * \sum_{j=0}^{n} i_j * \prod_{k=j+1}^{n} d_k
```

The CP-DSL supports dynamic arrays. Thus, dimension sizes can change and are
not fixed in size in the declaration model. Therefore, we can use lists or maps
to implement them. 

## Features of Arrays

Arrays can have multiple dimensions. These dimensions can be declared as fixed
in size or dynamic in size in the declaration model. The fixed size can be
defined as size or range.
- size, e.g., `int[5]`, which defines an integer array with values for
  0 to 4. 
- range, e.g., `int[2:6]`, which defines an array with elements from
  2 to 6.

Dynamic arrays start if not specified differently with the index 0. However,
there can also be constraints: 
- `int[]`, starts its values from index 0 upwards
- `int[2:]`, starts its values from index 2 upwards
- `int [:4]`, limits the indices to 4 starting from 0, e.g., '[0,1,2,3,4]'

The declaration model declares the dimensions, size constraints and base type of
an array. In the configuration model, an array element selector can select a
subset of an array, e.g., declaration model `int[1:10] data` declares the
attribute data as an integer array with the indices 1 to 10. There is no
element at index 0. The configuration model assignment

```
data[2:5] = [ 1,2,3,4 ]
```

assigns to the attribute **data** 4 values to the indices 2 to 5 of the declared
array. This implies elements 1,6,7,8,9 and 10 are uninitialized.

The specified **values** (here 1,2,3,4) in the configuration model must match
the **sizes** of the remaining dimensions based on the configuration model
modifiers (here the range from 2:5). There the values are moved in the
assignment to the correct indices. The above example
`data[2:5] = [ 1,2,3,4 ]` creates a value array with 4 numbers that are
internally a list of values starting at index 0 up to 3.
`data[2:5]` is an array selector on data, which selects the indices 2 to 5
from the data array. The assignment then places the values 2 to 5 accordingly,
i.e., the element with index 0 of the value array is assigned to `data[2]`,
element 1 is assigned to `data[3]` and so on.

In addition to ranges, element selectors can also select single elements. For
example, `data[2] = 4` assigns the scalar value 4 to the element with the index
number 2 of the data array. Thus, it is possible in our DSL to initialize 
arrays in CP-DSL as follows:

- `data[2] = 1`
- `data[3] = 2`
- `data[5:6] = [ 3, 4 ]`

This allows for empty elements in arrays. Not all programming languages
allow for empty cells in arrays, especially not with primitive data
types. Thus, this generates a information indicator in the editor. As some
configurations use this feature, we cannot prohibit such specifications.

## Implementation

The template compiler needs a model for arrays that retains the ranges and
indices to each value. Therefore, the internal representation of arrays
follow the concept of an associative array or map, where indices are map
keys. This has also an impact on for-loops. The template DSL implements a
for-loop that iterates over an array initializing three values available in the
expression of the loop. These are `it` containing one element value of the
array, `icount` containing the loop counter (starting always with 0), and the
index number 'i#'.

Here, the loop iterates over all elements declared in declarations. However,
*it* will only contain a value for those that have a value assigned, *i#* will
contain the respective index value, and *icount* the relevant loop counter.

Array values can also be accessed directly in a template by parameter name and
an index, e.g., `data[4]`. Here, this would return the element with the index 4
from the array data. Using our example above, `data[4]` has no assigned value.
Thus, it would be undefined. When converted to string, this produces the value
`undef`. However, to be able to distinguish whether a value exists or is
undefined, the user can use the function exists, which returns `true` in case a
value is present.

