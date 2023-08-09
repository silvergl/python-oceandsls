"""pfUnit generator utils to generate *.pf Fortran unit tests files"""

__author__ = 'sgu'

# TODO license

import difflib
import hashlib
# utils
import logging
import re
import os
from typing import List, Tuple

# debug
logger = logging.getLogger( __name__ )
# TODO debug flag
showDebugOutput: bool = True


def difflibMerge( fileContent0: str, fileContent1: str ) -> str:
    '''
    Merge two file-contents based on difflib.

    :param fileContent0: Content of first file
    :param fileContent1: Content of second file
    :return: 3-way merge of comparing the first file and second file
    '''
    mergedContent = "\n".join(
            lines[ 2: ] for lines in difflib.Differ( ).compare(
                    fileContent0.split( "\n" ),
                    fileContent1.split( "\n" )
            )
            if not lines.startswith( "?" )
    )

    return mergedContent

def insertFortranOperation( insertContentList: List[str ], fileContent ):
    """
    Insert operation into fortran code at the module end.

    :param insertContentList: List of code to be merged
    :param fileContent: File content in which to be merged
    :param moduleName: Optional module name in which to be merged
    :return: Merged content
    """

    functionName: str = insertContentList[0]
    functionCode: str = insertContentList[1]
    moduleName: str = insertContentList[2]

    publicPattern = r'\n(( *)public(?: *\:\:.*)?\n)+'
    privatePattern = r'\n(( *)private(?: *\:\:.*)?\n)+'
    implicitPattern = r'\n( *)implicit none *\n'

    moduleStartPattern = r'(\n( *)module +' + moduleName + ' *\n?)'
    moduleEndPattern = r'(\n( *)end +module +' + moduleName + ' *\n?)'

    # Find the position to insert the new code
    matchPublic = re.search(publicPattern, fileContent, flags=re.IGNORECASE)
    matchPrivate = re.search(privatePattern, fileContent, flags=re.IGNORECASE)
    matchImplicit = re.search(implicitPattern, fileContent, flags=re.IGNORECASE)
    matchModuleStart = re.search(moduleStartPattern,fileContent, flags=re.IGNORECASE)

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
        raise ValueError(f'Private/Public, Module or "Implicit" statement not found. Module: {moduleName}')

    # Insert public statement with line insertion
    fileContent = fileContent[:insertPosition] + fileContent[lineInsertion[0]:lineInsertion[1]] + f'PUBLIC :: {functionName}' + '\n' + fileContent[insertPosition:]

    matchModuleEnd = re.search(moduleEndPattern, fileContent, flags=re.IGNORECASE)

    # Insert function code
    if matchModuleEnd:
        # Insert before the module end
        insertPosition = matchModuleEnd.start()
        lineInsertion = matchModuleEnd.regs[-1]
    else:
        # If neither "contains" nor the module is found, raise an error
        raise ValueError(f'Module statement not found. Module: {moduleName}')

    # Insert function code with line insertion
    fileContent = fileContent[:insertPosition] + '\n' + fileContent[lineInsertion[0]:lineInsertion[1]] + functionCode + '\n' + fileContent[ insertPosition: ]

    return fileContent

def hash_file( path: str = None ) -> str:
    """
    Hash file using MD5

    :param path: system file path
    :return: MD5 hash of file
    """

    with open( path, "rb" ) as f:
        return hashlib.md5( f.read( ) ).hexdigest( )


def fileModified( path = None, mtime: float = 0, fileHash: str = None ) -> bool:
    """
    Check hash and modification time of file.

    :param path: system path to file
    :param mtime: last modification time
    :param fileHash: last md5 file hash
    :return: If modification time or file hash is changed
    """
    if os.path.getmtime( path ) > mtime or fileHash != hash_file( path ):
        logger.debug( f'... modified {path}' )
        return True
    else:
        logger.debug( f'... not modified {path}' )
        return False


def writeFile( filePath: str = 'tdd-dsl/output/tests/test.pf', content: List[str] = '', fileAttr: tuple[ float, str, str ] = None, insert: bool = False ) -> tuple[ float, str, str ]:
    """
    Write/merge pFUnit-file under :test_path:/:test_folder:/:filename:.pf for test-case.
    Merges file if it exists using difflib.

    :param filePath: system path to file
    :param content: test-case content
    :param fileHash: hash if file should exist
    :param mtime: modification time if file should exist
    :param contentOrg: original content
    :return: hast and modification time of file
    """

    # Define the folder and filename. Current working directory is ignored for absolut test_path
    path = os.path.dirname(filePath)

    # Create folder if it doesn't exist
    if not os.path.isdir( path ):
        os.makedirs( path )
        if showDebugOutput and logger.isEnabledFor( logging.DEBUG ):
            logger.debug( f'... create {path}' )

    # Join content when it is written in one place.
    if not insert:
        content = ''.join( content )

    # TODO hc
    # Create file if it doesn't exist else merge with existing file
    if os.path.exists( filePath ):
        # check if file is known or was modified
        if fileAttr is None or fileModified( filePath, fileAttr[0], fileAttr[1] ):
            # reload file from disk if it is unknown or modified
            with open( filePath, mode = 'r', encoding = 'utf-8' ) as f:
                contentOrg = f.read( )
        else:
            # keep original file content
            contentOrg = fileAttr[2]

        # Log
        if showDebugOutput and logger.isEnabledFor( logging.DEBUG ):
            logger.debug( f'...try merge {filePath}' )

        # merge current content with original file content
        if insert:
            content = insertFortranOperation( content, contentOrg )
        else:
            content = difflibMerge( content, contentOrg )
    else:
        # dismiss current content if saved again
        contentOrg = ''

    # Write rendered and optional merged content to file
    with open( filePath, mode = 'w', encoding = 'utf-8' ) as f:
        f.write( content )
        if showDebugOutput and logger.isEnabledFor( logging.DEBUG ):
            logger.debug( f'... create {filePath}' )

    return os.path.getmtime( filePath ), hash_file( filePath ), contentOrg
