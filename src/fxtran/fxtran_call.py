import os.path, fnmatch, subprocess
import xml.etree.ElementTree as ET
import re

import graphviz as gv
# requires sudo apt install libgraphviz-dev
import pygraphviz as pgv


def get_files(root_dir: str = "", pattern: str = "*.[fF]90"):
    files = []
    for root, dirnames, filenames in os.walk( root_dir ):
        for filename in fnmatch.filter( filenames, pattern ):
            files.append( os.path.join( root, filename ) )
    return files


def write_decorate_src_xml(root_dir: str = "", fxtran_path: str = ""):
    # Define the fxtran command
    fxtran_cmd_ops = [
        fxtran_path,
        "-line-length 200",
        "-no-cpp",
        "-no-include",
        "-construct-tag"
    ]

    # Get Fortran files
    fortran_files = get_files( root_dir, "*.[fF]90" )

    for fortran_file in fortran_files:
        fxtran_cmd = " ".join( map( str, fxtran_cmd_ops ) )
        try:
            # Call fxtran via subprocess
            subprocess.check_output( fxtran_cmd + " " + fortran_file, shell=True, stderr=subprocess.STDOUT )
        except subprocess.CalledProcessError as e:
            raise RuntimeError( "command '{}' return with error (code {}): {}".format( e.cmd, e.returncode, e.output ) )


def read_decorate_src_xml(fxtran_filepath: str = ""):
    # Manually parse the xml from a string.
    # Allows to remove the xml namespace.

    fin = open(fxtran_filepath, 'r')
    input_lines = fin.read()
    fin.close()

    # Remove xmlns attribute (xml namespace) as we only use fxtran syntax
    xml_string = re.sub(' xmlns="[^"]+"', '', input_lines, count=1)

    root_manual = ET.fromstring(xml_string)

    # parse the XML-File directly into an Element, which is the root element of the parsed tree
    # https://docs.python.org/library/xml.etree.elementtree.html#parsing-xml
    root = ET.parse( fxtran_filepath ).getroot()

    # print(ET.tostring(root).decode())

    return root_manual


root_dir: str = "/home/sgu/IdeaProjects/antlr4-python/src/fxtran/"
fxtran_path: str = "/home/sgu/IdeaProjects/fxtran/bin/fxtran"

ns = {'fxtran': 'http://fxtran.net/#syntax','real_person': 'http://people.example.com', 'role': 'http://characters.example.com'}

write_decorate_src_xml( root_dir, fxtran_path )

# Get Fortran files
xml_files = get_files( root_dir, "*.[fF]90.xml" )


subroutine_calls = {}
for xml_file in xml_files:
    root_element = read_decorate_src_xml( xml_file )
    current_subroutine = []

    for item in root_element.iter():
        if item.tag == "subroutine-stmt":
            for subsubroutine in item:
                if subsubroutine.tag == 'subroutine-N':
                    nom = subsubroutine[0][0].text
                    current_subroutine.append( nom )
                    subroutine_calls[current_subroutine[-1]] = []
        if item.tag == "end-subroutine-stmt":
            current_subroutine.pop( -1 )
        if item.tag == "call-stmt":
            if len( current_subroutine ):
                subroutine_calls[current_subroutine[-1]].append( item[0][0][0][0].text )

callgraph = gv.Digraph( format="pdf", strict=True )
for subroutine in subroutine_calls:
    if subroutine_calls[subroutine] != []:
        callgraph.node( subroutine.upper(), color="black", shape="diamond", fillcolor="limegreen", style="rounded,filled" )

for subroutine in subroutine_calls:
    for called in subroutine_calls[subroutine]:
        callgraph.edge( subroutine.upper(), called.upper() )

callgraph.render( root_dir + "gv", view=False )