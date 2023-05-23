'''fxtran wrapper using XPath Expression to parse Fortran source code into xml(http://fxtran.net/#syntax)'''

__author__ = 'sgu'

# TODO license

import xml.etree.ElementTree as ET

# Load the XML file
tree = ET.parse( '/home/sgu/IdeaProjects/python-oceandsls/tdd-dsl/input/fxtran/standalone/example.f90.xml' )

# Find the root element
root = tree.getroot( )

# Define the namespace dictionary
# Define the namespace
ns = {'fx': 'http://fxtran.net/#syntax'}

# Find all variables
# EN-decl elements within T-decl-stmt elements
variables = [ ]
scope_stack = [ ]  # Stack to track the current scope

# Iterate over all elements in the XML tree
for element in root.iter( ):

    # Reduce the scope stack when leaving scopes
    if element.tag.endswith( 'end-subroutine-stmt' ) or element.tag.endswith( 'end-program-stmt' ) or element.tag.endswith( 'end-function-stmt' ):
        scope_stack.pop( )
    else:

        # Extend the scope stack when encountering new scopes
        if element.tag.endswith( 'subroutine-stmt' ) or element.tag.endswith( 'program-stmt' ) or element.tag.endswith( 'function-stmt' ):
            # Find named element
            scope_name = element.find( './/fx:n', ns ).text
            scope_stack.append( scope_name )
        else:

            if element.tag.endswith( 'T-decl-stmt' ):
                # Check if variable is not an output
                intent_spec = element.find( './/fx:intent-spec', ns )
                if intent_spec is None or intent_spec.text != 'out':
                    # Get the current scope from the scope stack
                    current_scope = '.'.join( scope_stack )

                    # Get the type of the variable if it exists
                    t_spec_element = element.find( './/fx:T-N', ns )
                    variable_type = t_spec_element.text if t_spec_element is not None else ''

                    for en_decl in element.findall( './/fx:EN-decl', ns ):
                        # Get the name of the variable from the named element
                        variable_name = en_decl.find( './/fx:n', ns ).text

                        # Save the variable names with their respective types and scopes
                        variables.append( (variable_name, variable_type, current_scope) )

# TODO Debug
# Print the list of variable names with their respective types and scopes
for variable, variable_type, scope in variables:
    print( f"Variable: {variable}\t Type: {variable_type}\t Scope: {scope}" )
