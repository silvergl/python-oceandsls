'''utils for the Fxtran parser'''

__author__ = 'sgu'

import fnmatch
import os
import pathlib
import subprocess
# TODO license

import xml.etree.ElementTree as ET
from dataclasses import dataclass, field
from typing import Dict, List, Tuple

from symbolTable.SymbolTable import ModuleSymbol


@dataclass
class PublicObj:
    """
    Test Case for a Unit-test
    """

    # Require public entities
    needPublic: bool = False
    # By default, entities are public unless general private statement
    defaultPrivate: bool = False
    # Entities specifically mentioned as public optionally with attributes
    pubElements: Dict[str, List[str]] = field(default_factory=dict)
    # Entities specifically mentioned as private optionally with attributes
    prElements: Dict[str, List[str]] = field(default_factory=dict)

    def isPublic(self, name: str) -> bool:
        # Entity is considered public if public is not needed or entities are public by default and entity is not specifically marked as private or entity is specifically marked as public
        if not self.needPublic or not self.defaultPrivate and not name in self.prElements or name in self.pubElements:
            return True
        else:
            return False


# TODO hc
# Set the namespace as Fxtran for XPath expressions
ns = {'fx': 'http://fxtran.net/#syntax'}


# TODO hc
def filterXML(
    xmlPath: str = '/home/sgu/Documents/python-oceandsls/tdd-dsl/input/fxtran/standaloneXML/subfolder/cfo_sut_example.xml', need_public: bool = False,
    modules: List[ModuleSymbol] = []
    ) -> Tuple[List[Tuple[str]], List[Tuple[str, str, List[str]]]]:
    """
    XML filter for Fxtran output files (http://fxtran.net/#syntax) using XPath expressions
    """

    # extract names of module symbols for scope filter
    moduleNames = list(map(lambda s: s.name, modules))
    # extract filename of original file
    basename = os.path.splitext(os.path.basename(xmlPath))[0]
    baseModule: ModuleSymbol = None

    # Get the root element
    tree = ET.parse(xmlPath)
    root = tree.getroot()

    # Are filtered modules in scope
    isFilteredScope: bool = False

    # Variables to return (EN-decl elements within T-decl-stmt elements)
    variables = []
    # Scopes to return
    scopes = []
    # Stack to track the current scope
    scopeStack = []
    # Variables defined in scope
    scopeStackVar: Dict[str, Dict[str, str]] = {}
    pubElement: PublicObj = PublicObj(needPublic=need_public)  # Elements declared as public

    # TODO deprecated
    # Scope-changing elements
    scope_elements = ['subroutine-stmt', 'program-stmt', 'function-stmt']
    scope_block_statement = ['do-stmt']
    end_scope_elements = ['end-subroutine-stmt', 'end-program-stmt', 'end-function-stmt']
    contain_statement = ['contains-stmt']

    # last defined value
    lastVariableType: str = ''

    # Dynamically extracted scope-changing elements
    dyn_scope_elements = set()
    dyn_end_scope_elements = set()

    # Iterate over all elements in the XML tree
    for element in root.iter():

        # TODO functions / subroutines

        # Check if element is scope-changing by searching for scope-ending element
        # Extract the tag name without the namespace
        tag = element.tag.rsplit('}', 1)[-1]

        if tag.endswith('-stmt'):
            # Extract the statement name
            stmtName = tag.rsplit('-', 1)[0]
            # Find scope name element
            nameElement = element.find(f".//fx:{stmtName}-N", ns)

            if not tag in dyn_scope_elements and nameElement is not None:
                end_tag = 'end-' + tag
                if root.find(f".//fx:{end_tag}", ns) is not None:
                    dyn_scope_elements.add(tag)
                    dyn_end_scope_elements.add(end_tag)

        # Reduce the scope stack when leaving scopes
        if element.tag.endswith(tuple(dyn_end_scope_elements)):

            # Update return name of first functions without result statement
            scopeName = element.find('.//fx:n', ns).text

            # Dereference returnType for functions
            if isFilteredScope and element.tag.endswith('function-stmt') and pubElement.isPublic(scopeName):

                # Get the current scope from the scope stack
                currentScope = '.'.join(scopeStack)
                # Get return name
                resultID = scopeStackVar.get(currentScope).get('-1')
                # Get return type
                resultType = lastVariableType if resultID == -1 else scopeStackVar.get(currentScope).get(resultID, 'None')
                # Set return type for corresponding scope
                for scope in reversed(scopes):
                    if scopeStack[-1] == scope[1] and scope[3] == resultID:
                        scope[3] = resultType
                        break

            scopeStack.pop()

            # Check scope is filtered and top level scope ended
            if not scopeStack:
                isFilteredScope = False

        # Extend the scope stack when entering scopes
        elif element.tag.endswith(tuple(dyn_scope_elements)):
            # Extract scope name logical sector size zero
            scopeName = nameElement.find('.//fx:n', ns).text

            if stmtName == 'module':

                # TODO depr rm
                # # set top level module as scope if filtered scope is empty
                # if not moduleNames:
                #     moduleNames.append(scopeName)

                # TODO hc module
                # Check if top level scope is in filtered scope or if filtered scope is empty
                if not scopeStack and scopeName in moduleNames:
                    isFilteredScope = True
                    module: ModuleSymbol = next(filter(lambda module: module.name == scopeName, modules))

                    # get filename of original file
                    module.file = basename

                    baseModule = module

            # Update scope stack
            scopeStack.append(scopeName)

            # Check scope is filtered and is in filtered scope
            if isFilteredScope:
                # Extract arguments
                argumentNames = []
                for itm in element.findall('.//fx:arg-N', ns):
                    argumentNames.append(itm.find('.//fx:n', ns).text)

                # Get the current scope from the scope stack
                currentScope = '.'.join(scopeStack)

                # Extract resultId for functions
                resultID = None
                if element.tag.endswith('function-stmt'):
                    resultElement = element.find('.//fx:result-spec', ns)
                    if resultElement:
                        resultID = resultElement.find('.//fx:n', ns).text
                    else:
                        resultID = -1

                # Add type, name and arguments to returning scopes
                # Check public availability
                if pubElement.isPublic(scopeName):
                    scopes.append([stmtName, scopeName, argumentNames, resultID, currentScope])

                # save resultID for dereference
                scopeStackVar['.'.join(scopeStack)] = {'-1': resultID} if resultID else {}

        # Store assignment statements for optional return values of functions
        elif element.tag.endswith('a-stmt'):
            # Check scope is filtered and is in filtered scope
            if isFilteredScope:
                # Get current variable name
                variableName = element.find('.//fx:n', ns).text

                # Get the current scope from the scope stack
                currentScope = '.'.join(scopeStack)

                # Type for return type of functions, None if not found
                lastVariableType = scopeStackVar.get(currentScope).get(variableName, None)

        # Store public available ids
        elif element.tag.endswith('public-stmt'):
            pubIds = list(map((lambda itm: itm.text), element.findall('.//fx:n', ns)))
            for item in pubIds:
                pubElement.pubElements[item] = pubElement.pubElements.get(item, [])

        # Store private available ids
        elif element.tag.endswith('private-stmt'):
            prIds = list(map((lambda itm: itm.text), element.findall('.//fx:n', ns)))

            # Elements are private by default if no variable is given. Else extract private elements.
            if not prIds:
                pubElement.defaultPrivate = True
            else:
                for item in prIds:
                    pubElement.prElements[item] = pubElement.prElements.get(item, [])

        # Extract variables, public only, if needed
        elif element.tag.endswith('contains-stmt'):
            # Check if top level scope is in filtered scope or if filtered scope is empty
            if isFilteredScope and len(scopeStack) == 1 and scopeStack[0] == baseModule.name:
                baseModule.containsFunction = True

        # Extract variables, public only, if needed
        elif element.tag.endswith('T-decl-stmt'):

            # Check scope is filtered and is in filtered scope
            if isFilteredScope:
                attributes = list(map(lambda itm: itm.text, element.findall('.//fx:attribute-N', ns)))

                # TODO deprecated?
                # Check if variable is not an output
                # intentSpec = element.find( './/fx:intent-spec', ns )
                # if intentSpec is None or intentSpec.text != 'out':

                # Get the current scope from the scope stack
                currentScope = '.'.join(scopeStack)

                # Get the type of the variable if it exists
                tSpecElement = element.findall('.//fx:T-N', ns)

                # Extract variable type
                if tSpecElement:
                    if tSpecElement[0].text:
                        # Direct type name
                        variableType = tSpecElement[0].text
                    else:
                        # Derived type name
                        derivedElement: str = element.find('.//fx:derived-T-spec', ns)
                        # TODO hc default ''
                        derivedType: str = derivedElement.text if derivedElement else ''
                        variableType = ''.join([derivedType, tSpecElement[0].find('.//fx:n', ns).text, ')'])
                else:
                    # TODO check no type value
                    # No type found
                    variableType = ''

                for enDecl in element.findall('.//fx:EN-decl', ns):
                    # Get the name of the variable from the named element
                    variableName = enDecl.find('.//fx:n', ns).text

                    # Add element to public object if Public attribute is found or extend attributes if element is already public
                    pubElementEntry = pubElement.pubElements.get(item, attributes)
                    # TODO hc Public
                    if pubElementEntry or 'PUBLIC' in attributes:
                        pubElement.pubElements[variableName] = pubElementEntry

                    # Save name for return type of functions
                    variable = (variableName, variableType, currentScope)

                    # Add variable with type to current scope
                    scopeStackVar.get(currentScope)[variableName] = variableType

                    # Check public availability
                    if pubElement.isPublic(variableName):
                        # Save the variable names with their respective types and scopes
                        variables.append(variable)

    # TODO Debug
    # Print the list of found named scopes
    # for scopeName in dyn_scope_elements:
    #     print( f"Named scope element: {scopeName}" )

    return variables, scopes


def getFiles(path: str = "", pattern: str = "*.[fF]90"):
    '''
    return files from directory and subdirectories matching a pattern
    :param path: path to directory
    :param pattern: pattern of files to return
    :return: pattern matching files in directory and subdirectories
    '''
    files = []
    for root, dirNames, fileNames in os.walk(path):
        for fileName in fnmatch.filter(fileNames, pattern):
            files.append((root, fileName))

    return files


def getSubdirectories(path: str = "", recursive: bool = False, followSymlinks: bool = False):
    """
    Returns subdirectory names not starting with '.' under given path.

    :param path: root path
    :param recursive: return subdirectories recursively
    :param followSymlinks: follow symlinks
    :return: subdirectories
    """
    subDirs: List[str] = [entry.path for entry in os.scandir(path) if not entry.name.startswith('.') and entry.is_dir(follow_symlinks=followSymlinks)]
    if recursive:
        for path in subDirs:
            subDirs.extend(getSubdirectories(path))
    return subDirs


def getSubdirectoriesGen(path: str = "", recursive: bool = False, followSymlinks: bool = False):
    """
    Yield subdirectory names not starting with '.' under given path. Does not follow symlinks.

    :param path: root path
    :param recursive: yield subdirectories recursively
    :param followSymlinks: follow symlinks
    :return: yielded subdirectories
    """
    for entry in os.scandir(path):
        if not entry.name.startswith('.') and entry.is_dir(follow_symlinks=followSymlinks):
            yield entry
            if recursive:
                yield from getSubdirectoriesGen(entry.path, recursive)


# TODO hc
def writeDecorateSrcXml(srcDir: str = "", outDir: str = "foo", fxtranPath: str = '/home/sgu/IdeaProjects/fxtran/bin/fxtran'):
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
        [fxtranPath,  # "-line-length 200",
         "-no-cpp", "-strip-comments", "-name-attr",  # "-code-tag",
         # "-no-include",
         # "-construct-tag",
         "-o"]
    )

    # Get Fortran files
    fortranFiles = getFiles(srcDir, "*.[fF]90")

    for filepath, filename in fortranFiles:

        try:
            # create output directory relativ to source directory if it doesn't exist
            # TODO cm subdirectories
            relPath = os.path.relpath(filepath, srcDir)
            relOutDir = os.path.join(outDir, relPath) if relPath != '.' else outDir
            pathlib.Path(relOutDir).mkdir(mode=0o750, parents=True, exist_ok=True)
        except PermissionError as e:
            raise RuntimeError(f"Permission denied for output directory '{outDir}'. Error (code {e.errno}): {e.strerror} '{e.filename}'")

        # TODO deprecated
        # set file ending to xml
        # outFilename = filename.rsplit( '.', 1 )[ 0 ] + ".xml"

        # Build output path for xml file
        outFilePath = os.path.join(relOutDir, filename + ".xml")
        # Build the fxtran command
        fxtranCmd = " ".join([fxtranCmdOps, outFilePath, filename])

        try:
            # Call fxtran via subprocess with filepath as working directory
            subprocess.check_output(fxtranCmd, shell=True, stderr=subprocess.STDOUT, cwd=filepath)
        except subprocess.CalledProcessError as e:
            # TODO continue
            # raise RuntimeError( f"command '{e.cmd}' return with error (code {e.returncode}): {e.output}" )
            pass
        except PermissionError as e:
            # TODO continue without parsing
            raise RuntimeError(f"Permission denied for calling fxtran parser '{fxtranPath}'. Error (code {e.errno}): {e.strerror} '{e.filename}'")


def read_decorate_src_xml(xmlFilepath: str = "", xmlFilename: str = ""):
    '''
    read an XML-File and return the root element of the parse tree

    TODO deprecated
    :param xmlFilepath: path to xml file
    :param xmlFilename: xml file name
    :return: root element of parse tree
    '''

    # parse the XML-File directly into an Element, which is the root element of the parsed tree
    # https://docs.python.org/library/xml.etree.elementtree.html#parsing-xml
    root = ET.parse(os.path.join(xmlFilepath, xmlFilename)).getroot()

    # TODO Debug
    # print(ET.tostring(root).decode())

    return root

# variables = filterXML()
#
# # TODO Debug
# # Print the list of variable names with their respective types and scopes
# for variable, variable_type, scope in variables:
#     print( f"Variable: {variable}\t Type: {variable_type}\t Scope: {scope}" )
