"""pfUnit generator using to generate Fortran Unit Tests"""

__author__ = 'sgu'

# TODO license

import difflib
# utils
import logging
import os

# debug
logger = logging.getLogger( __name__ )
# TODO debug flag
showDebugOutput: bool = True


def merge_file_content( file_content_0: str, file_content_1: str ) -> str:
    '''
    Merge two file-contents based on difflib.

    :param file_content_0: Content of first file
    :param file_content_1: Content of second file
    :return: 3-way merge of comparing the first file and second file
    '''
    return "\n".join(
            lines[ 2: ] for lines in difflib.Differ( ).compare(
                    file_content_0.split( "\n" ),
                    file_content_1.split( "\n" )
            )
            if not lines.startswith( "?" )
    )


def write_file( test_path: str = 'tdd-dsl/output', test_folder: str = 'tests', filename: str = 'test', content: str = '' ) -> None:
    '''
    Write/merge pFUnit-file under :test_path:/:test_folder:/:filename:.pf for test-case.
    Merges file if it exists using difflib.

    :param test_path: system path to store pFUnit-tests
    :param test_folder: test-folder under system path for *.pf-files
    :param filename: filename  of *.pf-file
    :param content: test-case content
    :return: None
    '''

    # Define the folder and filename. Current working directory is ignored for absolut test_path
    path = os.path.join( os.getcwd( ), test_path, test_folder )

    # Create folder if it doesn't exist
    if not os.path.isdir( path ):
        os.makedirs( path )
        if showDebugOutput and logger.isEnabledFor( logging.DEBUG ):
            logger.debug( f'... create {path}' )

    # Create file if it doesn't exist else merge with existing file
    filename = f"{filename.lower( )}.pf"
    path = os.path.join( os.getcwd( ), path, filename )
    if os.path.exists( path ):
        if showDebugOutput and logger.isEnabledFor( logging.DEBUG):
            logger.debug(f'...try merge {path}')
        with open( path, mode = 'r', encoding = 'utf-8' ) as f:
            content_org = f.read( )
        content = merge_file_content( content, content_org )

    # Write rendered and optional merged content to file
    with open( path, mode = 'w', encoding = 'utf-8' ) as f:
        f.write( content )
        if showDebugOutput and logger.isEnabledFor( logging.DEBUG ):
            logger.debug( f'... create {path}' )
