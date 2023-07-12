"""Fortran F90 generator utils to generate *.f90 Fortran files"""

__author__ = 'sgu'

import re
import os

def merge_fortran_function(fortran_file, function_name, function_code, module_name: str = ''):
    # Read the contents of the Fortran file
    with open( fortran_file, mode = 'r', encoding = 'utf-8' ) as f:
        content = f.read( )

    # Define the patterns to match the "contains" statement and the function/subroutine
    # contains_pattern = r'^\s*contains\s*$'
    # function_pattern = r'(^\s*(?:subroutine|function)\s+' + function_name + r'\s*\(.*?\))'

    contains_pattern = r'\n *contains *\n'
    function_end_pattern = r'(\n *end +(?:subroutine|function) +' + function_name + ' *\n)'

    module_end_pattern = r'(\n *end +module +' + module_name + ' *\n?)'

    # Find the position to insert the new code
    match_contains = re.search(contains_pattern, content, flags=re.IGNORECASE)
    match_function = re.search(function_end_pattern, content, flags=re.IGNORECASE)

    if match_function:
        # Insert the new code after the "contains" statement
        insert_position = match_function.end()
    elif match_contains:
        # Insert the new code after the function/subroutine
        insert_position = match_contains.end()
    else:
        # If neither "contains" nor the function/subroutine is found, raise an error
        raise ValueError(f'Function or "contains" statement not found: {function_name}')

    # Insert the new code at the determined position
    modified_content = content[:insert_position] + function_code + '\n' + content[insert_position:]

    # Write the modified content back to the Fortran file
    with open(fortran_file, 'w') as file:
        file.write(modified_content)


# debug usage
fortran_file = 'cfo_sut_example.f90'
function_name = 'fT_ME'
module_name = 'fT_ME'
function_code = '''
  subroutine my_function(arg1, arg2)
    ! Fortran function code goes here
  end subroutine my_function'''

merge_fortran_function(fortran_file, function_name, function_code)