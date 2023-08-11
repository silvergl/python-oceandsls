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


def get_files(root_dir: str = "", pattern: str = "*.[fF]90"):
    files = []
    for root, dir_names, file_names in os.walk(root_dir):
        for file_name in fnmatch.filter(file_names, pattern):
            files.append((root, file_name))
    return files


def write_decorate_src_xml(src_dir: str = "", out_dir: str = "foo", fxtran_path: str = ""):
    # Define the fxtran command
    fxtran_cmd_ops = " ".join(
        [
            fxtran_path,
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
    fortran_files = get_files(src_dir, "*.[fF]90")

    for filepath, filename in fortran_files:

        try:
            # create output directory if it doesn't exist
            rel_path = os.path.relpath(filepath, src_dir)
            rel_out_dir = os.path.join(out_dir, rel_path) if rel_path != '.' else out_dir
            pathlib.Path(rel_out_dir).mkdir(mode=0o750, parents=True, exist_ok=True)
        except PermissionError as e:
            raise RuntimeError(f"Permission denied for output directory '{out_dir}'. Error (code {e.errno}): {e.strerror} '{e.filename}'")

        # Exchange the output name ending with xml
        out_filename = filename.rsplit('.', 1)[0] + ".xml"
        # Build output path for xml file
        out_file_path = os.path.join(rel_out_dir, out_filename)
        # Build the fxtran command
        fxtran_cmd = " ".join([fxtran_cmd_ops, out_file_path, filename])

        try:
            # Call fxtran via subprocess with filepath as working directory
            subprocess.check_output(fxtran_cmd, shell=True, stderr=subprocess.STDOUT, cwd=filepath)
        except subprocess.CalledProcessError as e:
            raise RuntimeError(f"command '{e.cmd}' return with error (code {e.returncode}): {e.output}")
        except PermissionError as e:
            raise RuntimeError(f"Permission denied for calling fxtran parser '{fxtran_path}'. Error (code {e.errno}): {e.strerror} '{e.filename}'")


def read_decorate_src_xml(xml_filepath: str = "", xml_filename: str = ""):
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
    root = ET.parse(os.path.join(xml_filepath, xml_filename)).getroot()

    # Debug
    # print(ET.tostring(root).decode())

    return root


# TODO rm debug
# srcDir: str = "/home/sgu/IdeaProjects/python-oceandsls/tdd-dsl/input/fxtran/standalone"
# fxtranPath: str = "/home/sgu/IdeaProjects/fxtran/bin/fxtran"
# outDir: str = "/home/sgu/IdeaProjects/python-oceandsls/tdd-dsl/input/fxtran/standaloneXML"

src_dir: str = "/home/sgu/Documents/python-oceandsls/tdd-dsl/input/fxtran/standalone"
fxtran_path: str = "/home/sgu/Documents/fxtran/bin/fxtran"
out_dir: str = "/home/sgu/Documents/python-oceandsls/tdd-dsl/input/fxtran/standaloneXML"

# Fxtran syntax xml namespace
ns = {'fx': 'http://fxtran.net/#syntax'}

# Write XML files
write_decorate_src_xml(src_dir, out_dir, fxtran_path)

# Get Fortran files
xml_files = get_files(src_dir, "*.[fF]90.xml")

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

for path, xml_filename in xml_files:
    root_element = read_decorate_src_xml(path, xml_filename)

    en_decl_lt_elems = root_element.findall(".//fx:EN-decl-LT", ns)
    en_n_elems = root_element.findall('.//fx:EN-N', ns)

    en_n_text_list = []
    for en_decl_lt_elem in en_decl_lt_elems:
        en_n_elems = en_decl_lt_elem.findall(".//fx:EN-N", ns)
        for en_n_elem in en_n_elems:
            en_n_text_list.append(en_n_elem.text)

    en_decl_lt_content = [elem.text for elem in en_decl_lt_elems]
    en_n_content = [elem.text for elem in en_n_elems]

    result = {'EN_decl_LT': en_decl_lt_content, 'EN_N': en_n_content}

    current_subroutine = []

    for item in root_element.iter():

        match item.tag:
            case 'file':
                # file path
                # '/home/sgu/IdeaProjects/antlr4-python/src/fxtran/fortrantut.f90'
                print(item.attrib['name'])
            case 'program-stmt':
                for subitem in item:
                    match subitem.tag:
                        case 'program-N':
                            # program Name
                            print(item[0][0].text)
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
                                        print(subsubitem[0][0].text)
                                    case 'array-spec':
                                        # upper-bound
                                        print(subsubitem[0][0][0][0][0][0].text)
                                        # TODO lower-bound
                                        print(subsubitem[0][1][0])
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
