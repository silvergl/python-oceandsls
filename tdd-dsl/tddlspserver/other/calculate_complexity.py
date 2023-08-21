""" Demo implementation for cyclomatic complexity calculation"""

__author__ = 'sgu'

import xml.etree.ElementTree as ET
from dataclasses import dataclass, field
from typing import Dict, List, Self, Set


@dataclass
class Scope:
    """
    Scope for cyclomatic complexity
    """
    name: str = field(default='')
    type : str = field(default='')

    conditionals : List[ET.Element] = field(default_factory=lambda: [])
    loops : List[ET.Element] = field(default_factory=lambda: [])
    branches : List[ET.Element] = field(default_factory=lambda: [])
    declarations : List[ET.Element] = field(default_factory=lambda: [])
    scopes : List[Self] = field(default_factory=lambda: [])

    __n_conditionals : int = 0
    __n_loops : int = 0
    __n_branches : int = 0
    __loc : int = 0

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
    def loc(self) -> int:
        return len(self.declarations)


# Set the namespace as Fxtran for XPath expressions
ns = {'fx': 'http://fxtran.net/#syntax'}

def calculate_cyclomatic_complexity(n_predicate_variables, n_loops, n_branches):
    """
    Cyclomatic complexity function for structures with only one entry point and one exit point.
     Number of predicate variables involved plus decision points ("if" statements and loops) plus one.
    :param n_predicate_variables:
    :param n_loops:
    :param n_branches:
    :return:
    """
    return n_predicate_variables + n_loops + n_branches + 1

def calculate_metrics(xml_path: str = None):
    # Get the root element
    tree = ET.parse(xml_path)
    root = tree.getroot()

    # Dynamically extracted scope-changing elements
    dyn_scope_elements = set()
    dyn_end_scope_elements = set()

    # Filters
    conditionals_elements : Set =  {'condition-E'}
    loop_elements : Set =  {'do-stmt'}
    branch_elements : Set =  {'if-then-stmt', 'else-stmt'}
    declaration_elements : Set =  {'a-stmt'}

    # Stack to track the current scope
    scope_stack = []
    # Routines defined in scope
    scope_routines: Dict[str, Scope] = {}

    for element in root.iter():
        # Check if element is scope-changing by searching for scope-ending element
        # Extract the tag name without the namespace
        tag = element.tag.rsplit('}', 1)[-1]

        if tag.endswith('-stmt'):
            # Extract the statement name
            stmt_name = tag.rsplit('-', 1)[0]
            # Find scope name element
            name_element = element.find(f".//fx:{stmt_name}-N", ns)

            if tag not in dyn_scope_elements and name_element is not None:
                end_tag = 'end-' + tag
                if root.find(f".//fx:{end_tag}", ns) is not None:
                    dyn_scope_elements.add(tag)
                    dyn_end_scope_elements.add(end_tag)

        # Set scope
        current_scope: Scope = scope_stack[-1] if scope_stack else None

        # Reduce the scope stack when leaving scopes
        if element.tag.endswith(tuple(dyn_end_scope_elements)):

            name = '.'.join(list(map(lambda scope : scope.name , scope_stack)))

            scope_routines[name]=scope_stack.pop()

        # Extend the scope stack when entering scopes
        elif element.tag.endswith(tuple(dyn_scope_elements)):

            # Extract scope name
            scope_name = name_element.find('.//fx:n', ns).text

            scope_type = element.tag.split(ns['fx']+"}",1)[1]

            routine = Scope(name = scope_name, type = scope_type)

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

    for scope_name, scope in scope_routines.items():

        cyclomatic_complexity = calculate_cyclomatic_complexity(scope.n_conditionals, scope.n_loops, scope.n_branches)

        print(f"Scope: {scope_name}")
        print(f"Cyclomatic Complexity: {cyclomatic_complexity}")
        print(f"Lines of Code: {scope.loc}\n")

def python_docs():
    """
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