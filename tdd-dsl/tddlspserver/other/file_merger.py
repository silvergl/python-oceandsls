"""Fortran F90 generator utils to generate *.f90 Fortran files"""

__author__ = "sgu"

import re
import os


def merge_fortran_operation(fortran_file, function_code, function_name: str = "", module_name: str = ""):
    # Read the contents of the Fortran file
    with open(fortran_file, mode="r", encoding="utf-8") as f:
        content = f.read()

    # Define the patterns to match the "contains" statement and the function/subroutine
    # contains_pattern = r'^\s*contains\s*$'
    # functionPattern = r'(^\s*(?:subroutine|function)\s+' + functionName + r'\s*\(.*?\))'

    public_pattern = r"\n(( *)public(?: *\:\:.*)?\n)+"
    private_pattern = r"\n(( *)private(?: *\:\:.*)?\n)+"
    implicit_pattern = r"\n( *)implicit none *\n"

    contains_pattern = r"\n( *)contains *\n"
    # functionEndPattern = r'(\n *end +(?:subroutine|function) +' + functionFindName + ' *\n)'
    module_start_pattern = r"(\n( *)module +" + module_name + " *\n?)"
    module_end_pattern = r"(\n( *)end +module +" + module_name + " *\n?)"

    # Find the position to insert the new code
    match_public = re.search(public_pattern, content, flags=re.IGNORECASE)
    match_private = re.search(private_pattern, content, flags=re.IGNORECASE)
    match_implicit = re.search(implicit_pattern, content, flags=re.IGNORECASE)
    match_module_start = re.search(module_start_pattern, content, flags=re.IGNORECASE)

    # Insert code accessible
    if match_public:
        # Insert after the "public" statement
        insert_position = match_public.end()
        line_insertion = match_public.regs[-1]
    elif match_private:
        # Insert after the "private" statement
        insert_position = match_private.end()
        line_insertion = match_private.regs[-1]
    elif match_implicit:
        # Insert after the "implicit" statement
        insert_position = match_implicit.end()
        line_insertion = match_implicit.regs[-1]
    elif match_module_start:
        # Insert after the module start
        insert_position = match_module_start.end()
        line_insertion = match_module_start.regs[-1]
    else:
        # If neither "contains" nor the function/subroutine is found, raise an error
        raise ValueError(f'Private/Public, Module or "Implicit" statement not found. File: {fortran_file}, Module: {module_name}')

    # Insert function  at the determined position
    content = content[:insert_position] + content[line_insertion[0]:line_insertion[1]] + f"PUBLIC :: {function_name}" + "\n" + content[insert_position:]

    # TODO 8.8
    match_contains = re.search(contains_pattern, content, flags=re.IGNORECASE)
    # matchFunction = re.search(functionEndPattern, content, flags=re.IGNORECASE)
    match_module = re.search(module_end_pattern, content, flags=re.IGNORECASE)

    # Insert function code
    if match_contains:
        # Insert after the "contains" statement
        insert_position = match_contains.end()
        line_insertion = match_contains.regs[-1]
    elif match_module:
        # Insert before the module end
        insert_position = match_module.start()
        line_insertion = match_module.regs[-1]
    else:
        # If neither "contains" nor the function/subroutine is found, raise an error
        raise ValueError(f"Module or \"contains\" statement not found. File: {fortran_file}, Module: {module_name}")

    # Insert function code at the determined position
    content = content[:insert_position] + content[line_insertion[0]:line_insertion[1]] + function_code + "\n" + content[insert_position:]

    # Write the modified content back to the Fortran file
    with open(fortran_file, "w") as file:
        file.write(content)


# debug usage
fortran_file = "cfo_sut_example.f90"
function_name = "my_function"
module_name = "cfo_example"
function_code = """
  subroutine my_function(arg1, arg2)
    ! Fortran function code goes here
  end subroutine my_function"""

merge_fortran_operation(fortran_file, function_code, function_name, module_name)
