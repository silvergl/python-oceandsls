'''fxtran wrapper using XPath Expression to parse Fortran source code into xml(http://fxtran.net/#syntax)'''

__author__ = 'sgu'

# TODO license

import xml.etree.ElementTree as ET

# Load the XML file
# tree = ET.parse( '/home/sgu/IdeaProjects/python-oceandsls/tdd-dsl/input/fxtran/standalone/example.f90.xml' )
# tree = ET.parse( '/home/sgu/IdeaProjects/python-oceandsls/tdd-dsl/input/fxtran/standaloneXML/subfolder/cfo_sut_example.xml' )
tree = ET.parse('/home/sgu/IdeaProjects/python-oceandsls/tdd-dsl/input/fxtran/standaloneXML/subfolder/cfo_sut_example.xml')

# Find the root element
root = tree.getroot()

# Define the namespace dictionary
# Define the namespace
ns = {'fx': 'http://fxtran.net/#syntax'}

# Find all variables
# EN-decl elements within T-decl-stmt elements
variables = []
scope_stack = []  # Stack to track the current scope

# # on-off match guard syntax https://peps.python.org/pep-0622/#one-off-syntax-variant
# # Iterate over all elements in the XML tree
# for element in root.iter( ):
#     match element:
#         case element if element.tag.endswith( 'end-subroutine-stmt' ) | element.tag.endswith( 'end-program-stmt' )
#         | element.tag.endswith( 'end-function-stmt' ):
#             scope_stack.pop( )
#         case element if element.tag.endswith( 'subroutine-stmt' ) | element.tag.endswith( 'program-stmt' ) | element.tag.endswith( 'function-stmt' ):
#             scope_name = element.find( './/fx:n', ns ).text
#             scope_stack.append( scope_name )
#         case element if element.tag.endswith( 'T-decl-stmt' ):
#             # Check if variable is not an output
#             intent_spec = element.find( './/fx:intent-spec', ns )
#             if intent_spec is None or intent_spec.text != 'out':
#                 # Get the current scope from the scope stack
#                 current_scope = '.'.join( scope_stack )
#
#                 # Get the type of the variable if it exists
#                 t_spec_element = element.find( './/fx:T-N', ns )
#                 variable_type = t_spec_element.text if t_spec_element is not None else ''
#
#                 for en_decl in element.findall( './/fx:EN-decl', ns ):
#                     # Get the name of the variable from the named element
#                     variable_name = en_decl.find( './/fx:n', ns ).text
#
#                     # Save the variable names with their respective types and scopes
#                     variables.append( (variable_name, variable_type, current_scope) )

# scope-changing elements
scope_elements = ['subroutine-stmt', 'program-stmt', 'function-stmt']
scope_block_statement = ['do-stmt']
end_scope_elements = ['end-subroutine-stmt', 'end-program-stmt', 'end-function-stmt']


# dynamically extracted scope-changing elements
dyn_scope_elements = set()
dyn_end_scope_elements = set()

# Iterate over all elements in the XML tree
for element in root.iter():

    # TODO
    # check for element is a scope-changing by searching for scope-ending element
    # Extract the tag name without the namespace
    tag = element.tag.rsplit('}', 1)[-1]

    if tag.endswith('-stmt'):
        # Find scope name element
        ltag = tag.rsplit('-', 1)[0]
        name_element = element.find(f".//fx:{ltag}-N", ns)

        if tag not in dyn_scope_elements and name_element is not None:
            end_tag = 'end-' + tag
            if root.find(f".//fx:{end_tag}", ns) is not None:
                dyn_scope_elements.add(tag)
                dyn_end_scope_elements.add(end_tag)

    # Reduce the scope stack when leaving scopes
    if element.tag.endswith(tuple(dyn_end_scope_elements)):
        scope_stack.pop()
    # Extend the scope stack when entering scopes
    elif element.tag.endswith(tuple(dyn_scope_elements)):
        # Find scope name
        scope_name = name_element.find('.//fx:n', ns).text
        scope_stack.append(scope_name)
    elif element.tag.endswith('T-decl-stmt'):
        # Check if variable is not an output
        intent_spec = element.find('.//fx:intent-spec', ns)
        if intent_spec is None or intent_spec.text != 'out':
            # Get the current scope from the scope stack
            current_scope = '.'.join(scope_stack)

            # Get the type of the variable if it exists
            t_spec_element = element.find('.//fx:T-N', ns)
            variable_type = t_spec_element.text if t_spec_element is not None else ''

            for en_decl in element.findall('.//fx:EN-decl', ns):
                # Get the name of the variable from the named element
                variable_name = en_decl.find('.//fx:n', ns).text

                # Save the variable names with their respective types and scopes
                variables.append((variable_name, variable_type, current_scope))

# TODO Debug
# Print the list of variable names with their respective types and scopes
for variable, variable_type, scope in variables:
    print(f"Variable: {variable}\t Type: {variable_type}\t Scope: {scope}")
# Print the list of found named scopes
for scope_name in dyn_scope_elements:
    print(f"Named scope element: {scope_name}")
