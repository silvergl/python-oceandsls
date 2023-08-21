""" Demo implementation for cyclomatic complexity calculation"""

__author__ = 'sgu'

import xml.etree.ElementTree as ET
from dataclasses import dataclass, field
from typing import Dict, List, Set


@dataclass
class Scope:
    """
    Scope for cyclomatic complexity
    """
    name: str = field(default='')
    type: str = field(default='')

    routine_types: Set = field(default_factory=lambda: {"function-stmt", "subroutine-stmt"})

    conditionals: List[ET.Element] = field(default_factory=lambda: [])
    loops: List[ET.Element] = field(default_factory=lambda: [])
    branches: List[ET.Element] = field(default_factory=lambda: [])
    declarations: List[ET.Element] = field(default_factory=lambda: [])
    other_stmt: List[ET.Element] = field(default_factory=lambda: [])
    arguments: List[ET.Element] = field(default_factory=lambda: [])
    scopes: List = field(default_factory=lambda: [])

    __n_conditionals: int = 0
    __n_loops: int = 0
    __n_branches: int = 0
    __loc: int = 0

    @property
    def n_conditionals(self) -> int:
        return len(self.conditionals)

    @property
    def n_loops(self) -> int:
        return len(self.loops)

    @property
    def n_branches(self) -> int:
        return len(self.branches)

    @property
    def cyclomatic_complexity(self) -> int | None:
        """
        Cyclomatic complexity function for structures with only one entry point and one exit point.
        Number of predicate variables involved plus decision points ("if" statements and loops) plus one.
        :return:
        """
        # Check if type is a simple structure
        if self.type in self.routine_types:
            return self.n_conditionals + self.n_loops + self.n_branches + 1
        else:
            return None

    @property
    def loc(self) -> int:
        """
        :return: Lines of codes in a scope as number of statements
        """
        return len(self.loops) + len(self.branches) + len(self.declarations) + len(self.other_stmt)


# Set the namespace as Fxtran for XPath expressions
ns = {'fx': 'http://fxtran.net/#syntax'}


def calculate_metrics(xml_path: str = None):
    """
    Calculate cyclomatic complexity from fxtran formatted xml file for Fortran code
    :param xml_path:
    :return: None
    """
    # Get the root element
    tree = ET.parse(xml_path)
    root = tree.getroot()

    # Filters
    conditionals_elements: Set = {'condition-E'}
    loop_elements: Set = {'do-stmt'}
    branch_elements: Set = {'if-then-stmt', 'else-stmt'}
    declaration_elements: Set = {'a-stmt'}
    other_stmt_elements: Set = {'-stmt'}

    # Dynamically extracted scope-changing elements
    dyn_scope_elements = set()
    dyn_end_scope_elements = set()
    # Stack to track the current scope
    scope_stack = []
    # Routines defined in scope
    scope_routines: Dict[str, Scope] = {}

    for element in root.iter():
        # Check if element is scope-changing by searching for scope-ending element

        # Extract the tag name without the namespace
        tag = element.tag.rsplit(sep='}', maxsplit=1)[-1]

        if tag.endswith('-stmt'):
            # Extract the statement name
            stmt_name = tag.rsplit(sep='-', maxsplit=1)[0]
            # Find scope name element
            name_element = element.find(path=f".//fx:{stmt_name}-N", namespaces=ns)

            if tag not in dyn_scope_elements and name_element is not None:
                end_tag = 'end-' + tag
                if root.find(path=f".//fx:{end_tag}", namespaces=ns) is not None:
                    dyn_scope_elements.add(tag)
                    dyn_end_scope_elements.add(end_tag)

        # Set scope
        current_scope: Scope = scope_stack[-1] if scope_stack else None

        # Reduce the scope stack when leaving scopes
        if element.tag.endswith(tuple(dyn_end_scope_elements)):

            name = '.'.join(list(map(lambda scope: scope.name, scope_stack)))

            scope_routines[name] = scope_stack.pop()

        # Extend the scope stack when entering scopes
        elif element.tag.endswith(tuple(dyn_scope_elements)):

            # Extract scope name
            scope_name = name_element.find(path='.//fx:n', namespaces=ns).text

            scope_type = element.tag.split(ns['fx'] + "}", maxsplit=1)[1]

            scope_arguments = element.findall(path='.//fx:arg-N', namespaces=ns)

            routine = Scope(name=scope_name, type=scope_type, arguments=scope_arguments)

            # Update scope stack
            scope_stack.append(routine)

        # Extract conditional statements
        elif element.tag.endswith(tuple(conditionals_elements)):
            current_scope.conditionals.append(element)

        # Extract loop statements
        elif element.tag.endswith(tuple(loop_elements)):
            current_scope.loops.append(element)

        # Extract branching statements
        elif element.tag.endswith(tuple(branch_elements)):
            current_scope.branches.append(element)

        # Extract declaration statements
        elif element.tag.endswith(tuple(declaration_elements)):
            current_scope.declarations.append(element)

        # Extract declaration statements
        elif element.tag.endswith(tuple(other_stmt_elements)):
            current_scope.other_stmt.append(element)

    # TODO debug output
    for scope_name, scope in scope_routines.items():
        print(f"Scope: {scope_name}")
        print(f"Cyclomatic Complexity: {scope.cyclomatic_complexity}")
        print(f"Lines of Code: {scope.loc}\n")


def python_docs():
    """
    TODO rm
    xml Path example from https://docs.python.org/3.10/library/xml.etree.elementtree.html#elementtree-xpath
    """
    tree = ET.parse('/home/sgu/IdeaProjects/python-oceandsls/tdd-dsl/input/fxtran/opem/country_data.xml')
    root = tree.getroot()

    # Top-level elements
    top_level = root.findall(".")

    function_name = root.find("./function-stmt/function-N/N/n").text

    print(function_name)


# Read and process the XML file
xml_file_path = '/home/sgu/IdeaProjects/python-oceandsls/tdd-dsl/input/fxtran/opem/cfo_sut_example.f90.xml'

calculate_metrics(xml_file_path)
