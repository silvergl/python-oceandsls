'''utils for the Fxtran parser'''

__author__ = 'sgu'

import fnmatch
import os
import pathlib
import subprocess
# TODO license

import xml.etree.ElementTree as ET
from typing import List, Tuple

from symbolTable.SymbolTable import ModuleSymbol

# TODO hc
# Set the namespace as Fxtran for XPath expressions
ns = {'fx': 'http://fxtran.net/#syntax'}

# TODO hc
def filterXML( xmlPath: str = '/home/sgu/Documents/python-oceandsls/tdd-dsl/input/fxtran/standaloneXML/subfolder/cfo_sut_example.xml', need_public: bool = False, modules: List[ ModuleSymbol ] = [ ] ) -> Tuple[
    List[ Tuple[ str ] ], List[ Tuple[ str, str, List[ str ] ] ] ]:
    """
    XML filter for Fxtran output files (http://fxtran.net/#syntax) using XPath expressions
    """

    # extract names of module symbols for scope filter
    moduleNames = list( map( lambda s: s.name, modules ) )
    # extract filename of original file
    basename = os.path.splitext(os.path.basename(xmlPath))[0]
    baseModule: ModuleSymbol = None

    # Get the root element
    tree = ET.parse( xmlPath )
    root = tree.getroot( )

    # Are filtered modules in scope
    isFilteredScope: bool = False

    variables = [ ]  # Variables to return (EN-decl elements within T-decl-stmt elements)
    scopes = [ ]  # Scopes to return
    scopeStack = [ ]  # Stack to track the current scope
    pubElements = [ ]  # Elements declared public

    # TODO deprecated
    # Scope-changing elements
    scope_elements = [ 'subroutine-stmt', 'program-stmt', 'function-stmt' ]
    scope_block_statement = [ 'do-stmt' ]
    end_scope_elements = [ 'end-subroutine-stmt', 'end-program-stmt', 'end-function-stmt' ]
    contain_statement = [ 'contains-stmt' ]

    # Dynamically extracted scope-changing elements
    dyn_scope_elements = set( )
    dyn_end_scope_elements = set( )

    # Iterate over all elements in the XML tree
    for element in root.iter( ):

        # TODO functions / subroutines

        # Check if element is scope-changing by searching for scope-ending element
        # Extract the tag name without the namespace
        tag = element.tag.rsplit( '}', 1 )[ -1 ]

        if tag.endswith( '-stmt' ):
            # Extract the statement name
            stmtName = tag.rsplit( '-', 1 )[ 0 ]
            # Find scope name element
            nameElement = element.find( f".//fx:{stmtName}-N", ns )

            if not tag in dyn_scope_elements and nameElement is not None:
                end_tag = 'end-' + tag
                if root.find( f".//fx:{end_tag}", ns ) is not None:
                    dyn_scope_elements.add( tag )
                    dyn_end_scope_elements.add( end_tag )

        # Reduce the scope stack when leaving scopes
        if element.tag.endswith( tuple( dyn_end_scope_elements ) ):
            scopeStack.pop( )

            # Check scope is filtered and top level scope ended
            if not moduleNames or not scopeStack:
                isFilteredScope = False

        # Extend the scope stack when entering scopes
        elif element.tag.endswith( tuple( dyn_scope_elements ) ):
            # Extract scope name
            scopeName = nameElement.find( './/fx:n', ns ).text

            # TODO hc module
            # Check if top level scope is in filtered scope or if filtered scope is empty
            if not moduleNames or not scopeStack and stmtName == 'module' and scopeName in moduleNames:
                isFilteredScope = True
                module: ModuleSymbol = next(filter ( lambda module: module.name == scopeName, modules))

                # get filename of original file
                module.file = basename

                baseModule = module

            # Check scope is filtered and is in filtered scope
            if isFilteredScope:
                # Extract arguments
                argumentNames = [ ]
                for itm in element.findall( './/fx:arg-N', ns ):
                    argumentNames.append( itm.find( './/fx:n', ns ).text )

                # Get the current scope from the scope stack
                currentScope = '.'.join( scopeStack )

                # Add type, name and arguments to returning scopes
                scopes.append( (stmtName, scopeName, argumentNames, currentScope) )

            # Update scope stack
            scopeStack.append( scopeName )

        # Store public available ids
        elif element.tag.endswith( 'public-stmt' ):
            pubIds = list( map( (lambda itm: itm.text), element.findall( './/fx:n', ns ) ) )
            pubElements.extend( pubIds )

        # Extract variables, public only, if needed
        elif element.tag.endswith( 'contains-stmt' ):
            # Check if top level scope is in filtered scope or if filtered scope is empty
            if len(scopeStack) == 1 and scopeStack[0] == baseModule.name:
                baseModule.containsFunction = True

        # Extract variables, public only, if needed
        elif element.tag.endswith( 'T-decl-stmt' ):

            # Check scope is filtered and is in filtered scope
            if isFilteredScope:
                attributes = list( map( lambda itm: itm.text, element.findall( './/fx:attribute-N', ns ) ) )

                # Check if variable is not an output
                intentSpec = element.find( './/fx:intent-spec', ns )
                if intentSpec is None or intentSpec.text != 'out':
                    # Get the current scope from the scope stack
                    currentScope = '.'.join( scopeStack )

                    # Get the type of the variable if it exists
                    tSpecElement = element.find( './/fx:T-N', ns )
                    variableType = tSpecElement.text if tSpecElement is not None else ''

                    for enDecl in element.findall( './/fx:EN-decl', ns ):
                        # Get the name of the variable from the named element
                        variableName = enDecl.find( './/fx:n', ns ).text

                        # TODO check hc PUBLIC
                        # Check public availability
                        if variableName in pubElements or 'PUBLIC' in attributes or not need_public:
                            # Save the variable names with their respective types and scopes
                            variables.append( (variableName, variableType, currentScope) )

    # TODO Debug
    # Print the list of found named scopes
    # for scopeName in dyn_scope_elements:
    #     print( f"Named scope element: {scopeName}" )

    return variables, scopes


def getFiles( path: str = "", pattern: str = "*.[fF]90" ):
    '''
    return files from directory and subdirectories matching a pattern
    :param path: path to directory
    :param pattern: pattern of files to return
    :return: pattern matching files in directory and subdirectories
    '''
    files = [ ]
    for root, dirNames, fileNames in os.walk( path ):
        for fileName in fnmatch.filter( fileNames, pattern ):
            files.append( (root, fileName) )

    return files


def getSubdirectories( path: str = "", recursive: bool = False, followSymlinks: bool = False ):
    """
    Returns subdirectory names not starting with '.' under given path.

    :param path: root path
    :param recursive: return subdirectories recursively
    :param followSymlinks: follow symlinks
    :return: subdirectories
    """
    subDirs: List[ str ] = [ entry.path for entry in os.scandir( path ) if not entry.name.startswith( '.' ) and entry.is_dir( follow_symlinks = followSymlinks ) ]
    if recursive:
        for path in subDirs:
            subDirs.extend( getSubdirectories( path ) )
    return subDirs


def getSubdirectoriesGen( path: str = "", recursive: bool = False, followSymlinks: bool = False ):
    """
    Yield subdirectory names not starting with '.' under given path. Does not follow symlinks.

    :param path: root path
    :param recursive: yield subdirectories recursively
    :param followSymlinks: follow symlinks
    :return: yielded subdirectories
    """
    for entry in os.scandir( path ):
        if not entry.name.startswith( '.' ) and entry.is_dir( follow_symlinks = followSymlinks ):
            yield entry
            if recursive:
                yield from getSubdirectoriesGen( entry.path, recursive )


# TODO hc
def writeDecorateSrcXml( srcDir: str = "", outDir: str = "foo", fxtranPath: str = '/home/sgu/IdeaProjects/fxtran/bin/fxtran' ):
    '''
    run Fxtran decorating source code with XML tags

    :param srcDir: input source code path
    :param outDir: output xml path
    :param fxtranPath: fxtran binary path
    :return:
    '''
    # TODO hc
    # Define the fxtran command
    fxtranCmdOps = " ".join(
            [
                    fxtranPath,
                    # "-line-length 200",
                    "-no-cpp",
                    "-strip-comments",
                    "-name-attr",
                    # "-code-tag",
                    # "-no-include",
                    # "-construct-tag",
                    "-o"
            ]
    )

    # Get Fortran files
    fortranFiles = getFiles( srcDir, "*.[fF]90" )

    for filepath, filename in fortranFiles:

        try:
            # create output directory relativ to source directory if it doesn't exist
            # TODO cm subdirectories
            relPath = os.path.relpath( filepath, srcDir )
            relOutDir = os.path.join( outDir, relPath ) if relPath != '.' else outDir
            pathlib.Path( relOutDir ).mkdir( mode = 0o750, parents = True, exist_ok = True )
        except PermissionError as e:
            raise RuntimeError( f"Permission denied for output directory '{outDir}'. Error (code {e.errno}): {e.strerror} '{e.filename}'" )

        # TODO deprecated
        # set file ending to xml
        # outFilename = filename.rsplit( '.', 1 )[ 0 ] + ".xml"

        # Build output path for xml file
        outFilePath = os.path.join( relOutDir, filename + ".xml" )
        # Build the fxtran command
        fxtranCmd = " ".join( [ fxtranCmdOps, outFilePath, filename ] )

        try:
            # Call fxtran via subprocess with filepath as working directory
            subprocess.check_output( fxtranCmd, shell = True, stderr = subprocess.STDOUT, cwd = filepath )
        except subprocess.CalledProcessError as e:
            # TODO continue
            # raise RuntimeError( f"command '{e.cmd}' return with error (code {e.returncode}): {e.output}" )
            pass
        except PermissionError as e:
            # TODO continue without parsing
            raise RuntimeError( f"Permission denied for calling fxtran parser '{fxtranPath}'. Error (code {e.errno}): {e.strerror} '{e.filename}'" )


def read_decorate_src_xml( xmlFilepath: str = "", xmlFilename: str = "" ):
    '''
    read an XML-File and return the root element of the parse tree

    TODO deprecated
    :param xmlFilepath: path to xml file
    :param xmlFilename: xml file name
    :return: root element of parse tree
    '''

    # parse the XML-File directly into an Element, which is the root element of the parsed tree
    # https://docs.python.org/library/xml.etree.elementtree.html#parsing-xml
    root = ET.parse( os.path.join( xmlFilepath, xmlFilename ) ).getroot( )

    # TODO Debug
    # print(ET.tostring(root).decode())

    return root

# variables = filterXML()
#
# # TODO Debug
# # Print the list of variable names with their respective types and scopes
# for variable, variable_type, scope in variables:
#     print( f"Variable: {variable}\t Type: {variable_type}\t Scope: {scope}" )
