# Template Language

The template language allows to define file templates based on a declaration
model. It supports two template types:
- File templates which will generate files
- Text templates which allow to produce text and allow to subdivide the file
  generation
  
## Basic File Structure

Each template file starts with a preamble specifying the declaration model to
use.

```
for DeclarationModelName
```

After that any number of file and sub templates can be specified.

## File Template

A file template starts with the keyword *file*.

```
file "filename expression" : "body expression"
file "filename expression" when exists(exampleGroup) : "body expression"
```

The first example produces a file regardless of the content of the configuration
file. The second example requests that an element *exampleGroup* exists.

## Text Template

A text template starts with the keyword *template* followed by a list of
optional parameters and a template body.

```
template basic "body expression"
template withParameters (ParameterGroup group) "body expression"
```

## Expressions

File names, conditionals and template bodys are expressions in the template
language. In text and file templates the expression must be a text string for
file names and bodys and a boolean for conditionals.

The language supports richstrings starting and ending with '''.
Rich strings can be interupted with « » and between these french quotes, other
expressions and commands can be inserted.

```
'''«for group.parameters join "," it.name»'''
```

## List of Expression Elements

- *, /, %  *multiply, divide, modulo*
- +, -  *add, subtract*
- if boolean text-expression (then text-expression)?
- for variable (join string)? text-expression
- switch variable cases end
- cases
  - case case-text-expression text-expression  *case for expression*
  - is type-name text-expression  *type case expression*
- and, or  *logical ops*
- ==, >, <, >=, <=, !=  *compare ops*
- !  (not)
- use template-name (parameters)  *use another template*
- exists(variable), isEmpty(list), size(list) *built-in functions*
- it *referencing the loop variable*

## How to get 

- « and » in the editor?
- CTRL-< and SHIFT-CTRL-< (lower left corner on the keyboard)

