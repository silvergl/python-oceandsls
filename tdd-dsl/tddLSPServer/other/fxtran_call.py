'''fxtran wrapper using XPath Expression to parse Fortran source code into xml(http://fxtran.net/#syntax)'''

__author__ = 'sgu'

# TODO license

# utils
import fnmatch
import os.path
import pathlib
import re
import subprocess
# xml
import xml.etree.ElementTree as ET


def getFiles( root_dir: str = "", pattern: str = "*.[fF]90" ):
    files = [ ]
    for root, dirNames, fileNames in os.walk( root_dir ):
        for fileName in fnmatch.filter( fileNames, pattern ):
            files.append( (root, fileName) )
    return files


def writeDecorateSrcXml( srcDir: str = "", outDir: str = "foo", fxtranPath: str = "" ):
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
            # create output directory if it doesn't exist
            relPath = os.path.relpath( filepath, srcDir )
            relOutDir = os.path.join( outDir, relPath ) if relPath != '.' else outDir
            pathlib.Path( relOutDir ).mkdir( mode = 0o750, parents = True, exist_ok = True )
        except PermissionError as e:
            raise RuntimeError( f"Permission denied for output directory '{outDir}'. Error (code {e.errno}): {e.strerror} '{e.filename}'" )

        # Exchange the output name ending with xml
        outFilename = filename.rsplit( '.', 1 )[ 0 ] + ".xml"
        # Build output path for xml file
        outFilePath = os.path.join( relOutDir, outFilename )
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
    # Manually parse the xml from a string.
    # Allows to remove the xml namespace.

    # TODO rm
    # manual method - can modify xml
    #
    # fin = open( fxtran_filepath, 'r' )
    # input_lines = fin.read( )
    # fin.close( )
    #
    # # Remove xmlns attribute (xml namespace) as we only use fxtran syntax
    # xml_string = re.sub( ' xmlns="[^"]+"', '', input_lines, count = 1 )
    #
    # root_manual = ET.fromstring( xml_string )

    # parse the XML-File directly into an Element, which is the root element of the parsed tree
    # https://docs.python.org/library/xml.etree.elementtree.html#parsing-xml
    root = ET.parse( os.path.join( xmlFilepath, xmlFilename ) ).getroot( )

    # Debug
    # print(ET.tostring(root).decode())

    return root


# TODO rm debug
#srcDir: str = "/home/sgu/IdeaProjects/python-oceandsls/tdd-dsl/input/fxtran/standalone"
#fxtranPath: str = "/home/sgu/IdeaProjects/fxtran/bin/fxtran"
#outDir: str = "/home/sgu/IdeaProjects/python-oceandsls/tdd-dsl/input/fxtran/standaloneXML"

srcDir: str = "/home/sgu/Documents/python-oceandsls/tdd-dsl/input/fxtran/standalone"
fxtranPath: str = "/home/sgu/Documents/fxtran/bin/fxtran"
outDir: str = "/home/sgu/Documents/python-oceandsls/tdd-dsl/input/fxtran/standaloneXML"

# Fxtran syntax xml namespace
ns = {'fx': 'http://fxtran.net/#syntax'}

# Write XML files
writeDecorateSrcXml( srcDir, outDir, fxtranPath )

# Get Fortran files
xmlFiles = getFiles( srcDir, "*.[fF]90.xml" )

# local decl
#   EN-decl-LT
#
# glb decl
#
#
# call stmt
#   call-stmt
#
#   procedure-designator
#        name callee
#   arg-spec
#
# module
#   module-stmt
#       module-N

for path, xml_filename in xmlFiles:
    root_element = read_decorate_src_xml( path, xml_filename )

    en_decl_lt_elems = root_element.findall( ".//fx:EN-decl-LT", ns )
    en_n_elems = root_element.findall( './/fx:EN-N', ns )

    en_n_text_list = [ ]
    for en_decl_lt_elem in en_decl_lt_elems:
        en_n_elems = en_decl_lt_elem.findall( ".//fx:EN-N", ns )
        for en_n_elem in en_n_elems:
            en_n_text_list.append( en_n_elem.text )

    en_decl_lt_content = [ elem.text for elem in en_decl_lt_elems ]
    en_n_content = [ elem.text for elem in en_n_elems ]

    result = {'EN_decl_LT': en_decl_lt_content, 'EN_N': en_n_content}

    current_subroutine = [ ]

    for item in root_element.iter( ):

        match item.tag:
            case 'file':
                # file path
                # '/home/sgu/IdeaProjects/antlr4-python/src/fxtran/fortrantut.f90'
                print( item.attrib[ 'name' ] )
            case 'program-stmt':
                for subitem in item:
                    match subitem.tag:
                        case 'program-N':
                            # program Name
                            print( item[ 0 ][ 0 ].text )
            case 'EN-decl-LT':
                for subitem in item:
                    match subitem.tag:
                        case 'EN-decl':
                            # local variable name
                            # print(subitem[0][0][0].text)
                            for subsubitem in subitem:
                                match subsubitem.tag:
                                    case 'EN-N':
                                        # local variable name
                                        print( subsubitem[ 0 ][ 0 ].text )
                                    case 'array-spec':
                                        # upper-bound
                                        print( subsubitem[ 0 ][ 0 ][ 0 ][ 0 ][ 0 ][ 0 ].text )
                                        # TODO lower-bound
                                        print( subsubitem[ 0 ][ 1 ][ 0 ] )
            case 'subroutine-stmt':
                for subitem in item:
                    match subitem.tag:
                        case 'subroutine-N':
                            pass
            case 'end-subroutine-stmt':
                pass
            case 'call-stmt':
                pass

# graphviz
# requires sudo apt install libgraphviz-dev
#
# subroutine_calls = {}
# for xml_file in xml_files:
#     root_element = read_decorate_src_xml( xml_file )
#     current_subroutine = []
#
#     for item in root_element.iter():
#         if item.tag == "subroutine-stmt":
#             for subsubroutine in item:
#                 if subsubroutine.tag == 'subroutine-N':
#                     nom = subsubroutine[0][0].text
#                     current_subroutine.append( nom )
#                     subroutine_calls[current_subroutine[-1]] = []
#         if item.tag == "end-subroutine-stmt":
#             current_subroutine.pop( -1 )
#         if item.tag == "call-stmt":
#             if len( current_subroutine ):
#                 subroutine_calls[current_subroutine[-1]].append( item[0][0][0][0].text )
#
# callgraph = gv.Digraph( format="pdf", strict=True )
# for subroutine in subroutine_calls:
#     if subroutine_calls[subroutine]:
#         callgraph.node( subroutine.upper(), color="black", shape="diamond", fillcolor="limegreen", style="rounded,
#         filled" )
#
# for subroutine in subroutine_calls:
#     for called in subroutine_calls[subroutine]:
#         callgraph.edge( subroutine.upper(), called.upper() )
#
# callgraph.render( root_dir + "gv", view=False )
