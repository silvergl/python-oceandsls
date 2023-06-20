'''utils for the Fxtran parser'''

__author__ = 'sgu'

import fnmatch
import os
import pathlib
import subprocess
# TODO license

import xml.etree.ElementTree as ET
from typing import List, Tuple

# TODO hc
# Set the namespace as Fxtran for XPath expressions
ns = {'fx': 'http://fxtran.net/#syntax'}


# TODO hc
def filterXML( xmlPath: str = '/home/sgu/Documents/python-oceandsls/tdd-dsl/input/fxtran/standaloneXML/subfolder/cfo_sut_example.xml', need_public: bool = False ) -> List[ Tuple[ str ] ]:
    '''
    XML filter for Fxtran output files (http://fxtran.net/#syntax) using XPath expressions
    '''

    # Get the root element
    tree = ET.parse( xmlPath )
    root = tree.getroot( )

    # reduce to public elements if needed
    # root = root.findall( ".//fx:public-stmt", ns ) if public else root

    # Find all variables
    # EN-decl elements within T-decl-stmt elements
    variables = [ ]
    scope_stack = [ ]  # Stack to track the current scope
    pub_elements = [ ]

    # scope-changing elements
    scope_elements = [ 'subroutine-stmt', 'program-stmt', 'function-stmt' ]
    scope_block_statement = [ 'do-stmt' ]
    end_scope_elements = [ 'end-subroutine-stmt', 'end-program-stmt', 'end-function-stmt' ]

    # dynamically extracted scope-changing elements
    dyn_scope_elements = set( )
    dyn_end_scope_elements = set( )

    # Iterate over all elements in the XML tree
    for element in root.iter( ):

        # TODO functions / subroutines

        # check if element is scope-changing by searching for scope-ending element
        # Extract the tag name without the namespace
        tag = element.tag.rsplit( '}', 1 )[ -1 ]

        if tag.endswith( '-stmt' ):
            # Find scope name element
            ltag = tag.rsplit( '-', 1 )[ 0 ]
            name_element = element.find( f".//fx:{ltag}-N", ns )

            if not tag in dyn_scope_elements and name_element is not None:
                end_tag = 'end-' + tag
                if root.find( f".//fx:{end_tag}", ns ) is not None:
                    dyn_scope_elements.add( tag )
                    dyn_end_scope_elements.add( end_tag )

        # Reduce the scope stack when leaving scopes
        if element.tag.endswith( tuple( dyn_end_scope_elements ) ):
            scope_stack.pop( )
        # Extend the scope stack when entering scopes
        elif element.tag.endswith( tuple( dyn_scope_elements ) ):
            # Find scope name
            scope_name = name_element.find( './/fx:n', ns ).text
            scope_stack.append( scope_name )

        # Store public available ids
        elif element.tag.endswith( 'public-stmt' ):
            pubElements = element.findall( './/fx:n', ns )
            pubIds = list( map( (lambda element: element.text), pubElements ) )
            pub_elements.extend( pubIds )

        # Extract variables, public only, if needed
        elif element.tag.endswith( 'T-decl-stmt' ):
            attributes = list( map( lambda itm: itm.text, element.findall( './/fx:attribute-N', ns ) ) )

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

                    # TODO check hc PUBLIC
                    # Check public availability
                    if variable_name in pub_elements or 'PUBLIC' in attributes or not need_public:
                        # Save the variable names with their respective types and scopes
                        variables.append( (variable_name, variable_type, current_scope) )

    # TODO Debug
    # Print the list of found named scopes
    # for scope_name in dyn_scope_elements:
    #     print( f"Named scope element: {scope_name}" )

    return variables


def getFiles( directory: str = "", pattern: str = "*.[fF]90" ):
    '''
    return files from directory and subdirectories matching a pattern
    :param directory: path to directory
    :param pattern: pattern of files to return
    :return: pattern matching files in directory and subdirectories
    '''
    files = [ ]
    for root, dirNames, fileNames in os.walk( directory ):
        for fileName in fnmatch.filter( fileNames, pattern ):
            files.append( (root, fileName) )
    return files


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
            raise RuntimeError( f"command '{e.cmd}' return with error (code {e.returncode}): {e.output}" )
        except PermissionError as e:
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
