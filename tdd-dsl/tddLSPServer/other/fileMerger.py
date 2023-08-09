"""Fortran F90 generator utils to generate *.f90 Fortran files"""

__author__ = 'sgu'

import re
import os

def mergeFortranOperation( fortranFile, functionCode, functionName: str = '', moduleName: str = '' ):
    # Read the contents of the Fortran file
    with open( fortranFile, mode = 'r', encoding = 'utf-8' ) as f:
        content = f.read( )

    # Define the patterns to match the "contains" statement and the function/subroutine
    # containsPattern = r'^\s*contains\s*$'
    # functionPattern = r'(^\s*(?:subroutine|function)\s+' + functionName + r'\s*\(.*?\))'

    publicPattern = r'\n(( *)public(?: *\:\:.*)?\n)+'
    privatePattern = r'\n(( *)private(?: *\:\:.*)?\n)+'
    implicitPattern = r'\n( *)implicit none *\n'

    containsPattern = r'\n( *)contains *\n'
    # functionEndPattern = r'(\n *end +(?:subroutine|function) +' + functionFindName + ' *\n)'
    moduleStartPattern = r'(\n( *)module +' + moduleName + ' *\n?)'
    moduleEndPattern = r'(\n( *)end +module +' + moduleName + ' *\n?)'


    # Find the position to insert the new code
    matchPublic = re.search(publicPattern, content, flags=re.IGNORECASE)
    matchPrivate = re.search(privatePattern, content, flags=re.IGNORECASE)
    matchImplicit = re.search(implicitPattern, content, flags=re.IGNORECASE)
    matchModuleStart = re.search(moduleStartPattern,content, flags=re.IGNORECASE)

    # Insert code accessible
    if matchPublic:
        # Insert after the "public" statement
        insertPosition = matchPublic.end()
        lineInsertion = matchPublic.regs[-1]
    elif matchPrivate:
        # Insert after the "private" statement
        insertPosition = matchPrivate.end()
        lineInsertion = matchPrivate.regs[-1]
    elif matchImplicit:
        # Insert after the "implicit" statement
        insertPosition = matchImplicit.end()
        lineInsertion = matchImplicit.regs[-1]
    elif matchModuleStart:
        # Insert after the module start
        insertPosition = matchModuleStart.end()
        lineInsertion = matchModuleStart.regs[-1]
    else:
        # If neither "contains" nor the function/subroutine is found, raise an error
        raise ValueError(f'Private/Public, Module or "Implicit" statement not found. File: {fortranFile}, Module: {moduleName}')

    # Insert function  at the determined position
    content = content[:insertPosition] + content[lineInsertion[0]:lineInsertion[1]] + f'PUBLIC :: {functionName}' + '\n' + content[insertPosition:]

    # TODO 8.8
    matchContains = re.search(containsPattern, content, flags=re.IGNORECASE)
    # matchFunction = re.search(functionEndPattern, content, flags=re.IGNORECASE)
    matchModule = re.search(moduleEndPattern, content, flags=re.IGNORECASE)

    # Insert function code
    if matchContains:
        # Insert after the "contains" statement
        insertPosition = matchContains.end()
        lineInsertion = matchContains.regs[-1]
    elif matchModule:
        # Insert before the module end
        insertPosition = matchModule.start()
        lineInsertion = matchModule.regs[-1]
    else:
        # If neither "contains" nor the function/subroutine is found, raise an error
        raise ValueError(f'Module or "contains" statement not found. File: {fortranFile}, Module: {moduleName}')

    # Insert function code at the determined position
    content = content[:insertPosition] + content[lineInsertion[0]:lineInsertion[1]] + functionCode + '\n' + content[insertPosition:]

    # Write the modified content back to the Fortran file
    with open(fortranFile, 'w') as file:
        file.write(content)


# debug usage
fortranFile = 'cfo_sut_example.f90'
functionName = 'my_function'
moduleName = 'cfo_example'
functionCode = '''
  subroutine my_function(arg1, arg2)
    ! Fortran function code goes here
  end subroutine my_function'''

mergeFortranOperation( fortranFile, functionCode, functionName, moduleName )