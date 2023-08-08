"""pfUnit generator utils to generate *.pf Fortran unit tests files"""

__author__ = 'sgu'

# TODO license

import difflib
import hashlib
# utils
import logging
import re
import os
from typing import Tuple

# debug
logger = logging.getLogger( __name__ )
# TODO debug flag
showDebugOutput: bool = True


def difflib_merge( fileContent0: str, fileContent1: str ) -> str:
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

def mergeFortranFunction( fileContent, functionCode, functionName: str = '', moduleName: str = '' ):
    """
    Merge function code into fortran code after function name, contain statement or at the module end.

    :param fileContent: File content in which to be merged
    :param functionCode: Code to be merged
    :param functionName: Optional function name after which to be merged
    :param moduleName: Optional module name in which to be merged
    :return: Merged content
    """

    containsPattern = r'\n *contains *\n'
    functionEndPattern = r'(\n *end +(?:subroutine|function) +' + functionName + ' *\n)'
    moduleEndPattern = r'(\n *end +module +' + moduleName + ' *\n?)'

    # Find the position to insert the new code
    matchContains = re.search(containsPattern, fileContent, flags=re.IGNORECASE)
    matchFunction = re.search(functionEndPattern, fileContent, flags=re.IGNORECASE)
    matchModule = re.search(moduleEndPattern, fileContent, flags=re.IGNORECASE)

    if matchFunction:
        # Insert the new code after the function/subroutine
        insertPosition = matchFunction.end()
    elif matchContains:
        # Insert the new code after the "contains" statement
        insertPosition = matchContains.end()
    elif matchModule:
        # Insert the new code at the module end
        insertPosition = matchModule.start()
    else:
        # If neither "contains" nor the function/subroutine is found, raise an error
        raise ValueError(f'Function, Module or "contains" statement not found. Function: {functionName}, Module: {moduleName}' )
    # Insert the new code at the determined position
    mergedContent = fileContent[:insertPosition] + functionCode + '\n' + fileContent[ insertPosition: ]

    return mergedContent

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


def write_file( test_path: str = 'tdd-dsl/output', test_folder: str = 'tests', filename: str = 'test', fileSuffix: str = '', content: str = '', fileAttr: tuple[ float, str, str ] = None ) -> tuple[ float, str, str ]:
    """
    Write/merge pFUnit-file under :test_path:/:test_folder:/:filename:.pf for test-case.
    Merges file if it exists using difflib.

    :param test_path: system path to store pFUnit-tests
    :param test_folder: test-folder under system path for *.pf-files
    :param filename: filename  of *.pf-file
    :param fileSuffix: suffix of file
    :param content: test-case content
    :param fileHash: hash if file should exist
    :param mtime: modification time if file should exist
    :param content_org: original content
    :return: hast and modification time of file
    """

    # Define the folder and filename. Current working directory is ignored for absolut test_path
    path = os.path.join( os.getcwd( ), test_path, test_folder )

    # Create folder if it doesn't exist
    if not os.path.isdir( path ):
        os.makedirs( path )
        if showDebugOutput and logger.isEnabledFor( logging.DEBUG ):
            logger.debug( f'... create {path}' )

    # TODO hc
    # Create file if it doesn't exist else merge with existing file
    filename = f"{filename.lower( )}{fileSuffix}"
    path = os.path.join( path, filename )
    if os.path.exists( path ):
        # check if file is known or was modified
        if fileAttr is None or fileModified( path, fileAttr[0], fileAttr[1] ):
            # reload file from disk if it is unknown or modified
            with open( path, mode = 'r', encoding = 'utf-8' ) as f:
                content_org = f.read( )
        else:
            # keep original file content
            content_org = fileAttr[2]

        if showDebugOutput and logger.isEnabledFor( logging.DEBUG ):
            logger.debug( f'...try merge {path}' )
        # merge current content with original file content
        content = merge_file_content( content, content_org )
    else:
        # dismiss current content if saved again
        content_org = ''

    # Write rendered and optional merged content to file
    with open( path, mode = 'w', encoding = 'utf-8' ) as f:
        f.write( content )
        if showDebugOutput and logger.isEnabledFor( logging.DEBUG ):
            logger.debug( f'... create {path}' )

    return os.path.getmtime( path ), hash_file( path ), content_org
