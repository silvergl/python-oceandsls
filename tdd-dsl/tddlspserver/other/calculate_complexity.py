""" Demo implementation for cyclomatic complexity calculation"""

__author__ = "sgu"

import xml.etree.ElementTree as ET
from dataclasses import dataclass, field
from typing import Dict, List, Set


class UniqueList(list):
    """
    List with unique elements. Resets if added to closed list.
    """
    __closed: bool = False

    def close(self):
        # Close list
        self.__closed = True

    def extend(self, elements: List):
        # Reset if closed
        if self.__closed:
            self.clear()
            __close = False

        # Add elements if not in list
        for element in elements:
            self.append(element)

    def append(self, element):
        # Reset if closed
        if self.__closed:
            self.clear()
            __close = False

        # Add element if not in list
        if not self.__contains__(element):
            super().append(element)


@dataclass
class Scope:
    """
    Scope for cyclomatic complexity
    """
    name: str = field(default="")
    type: str = field(default="")

    routine_types: Set = field(default_factory=lambda: {"function-stmt", "subroutine-stmt"})

    conditionals: List[ET.Element] = field(default_factory=lambda: [])
    loops: List[ET.Element] = field(default_factory=lambda: [])
    branches: List[ET.Element] = field(default_factory=lambda: [])
    declarations: List[ET.Element] = field(default_factory=lambda: [])
    other_stmt: List[ET.Element] = field(default_factory=lambda: [])
    arguments: List[ET.Element] = field(default_factory=lambda: [])
    external_calls: List[ET.Element] = field(default_factory=lambda: [])
    sub_scopes: List = field(default_factory=lambda: [])
    scope_result_names: List[str] = field(default_factory=lambda: [])

    # List of last result declarations
    __scope_result_decl: UniqueList = field(default_factory=lambda: UniqueList())

    @property
    def n_results(self) -> int:
        return len(self.__scope_result_decl)

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
    def n_declarations(self) -> int:
        return len(self.declarations)

    @property
    def n_other_stmts(self) -> int:
        return len(self.other_stmt)

    @property
    def n_arguments(self) -> int:
        return len(self.arguments)

    @property
    def n_external_calls(self) -> int:
        return len(self.external_calls)

    @property
    def cyclomatic_complexity(self) -> int | None:
        """
        Cyclomatic complexity function for structures with only one entry point and one exit point.
        Number of predicate variables involved plus decision points ("if" statements and loops) plus one.
        :return:
        """
        # Check if type is a simple structure
        if self.is_routine:
            return self.n_conditionals + self.n_loops + self.n_branches + 1
        else:
            # TODO add more types
            return None

    @property
    def loc(self) -> int:
        """
        :return: Lines of codes in a scope as number of statements
        """
        return self.n_loops + self.n_branches + self.n_declarations + self.n_other_stmts

    @property
    def n_decision_points(self) -> int:
        """
        :return: Number of decision points in scope
        """
        return self.n_loops + self.n_branches

    @property
    def depth_of_nesting(self) -> int:
        """
        :return: Maximum depth of nesting of scope
        """
        depth_of_nesting: int = 0
        for sub_scope in self.sub_scopes:
            depth_of_nesting = max(depth_of_nesting, 1 + sub_scope.depth_of_nesting)
        return depth_of_nesting

    @property
    def is_routine(self) -> bool:
        return self.type in self.routine_types

    def close_result(self):
        self.__scope_result_decl.close()

    def extend_result(self, elements):
        for element in elements:
            self.append_result(element)

    def append_result(self, element):
        element_name = element.find(".//fx:n", ns)
        element_name = element_name.text if element_name is not None else None
        if self.is_routine and (element_name in self.scope_result_names or not self.scope_result_names):
            self.__scope_result_decl.append(element)

    def __str__(self):
        """ toString method """
        return (f"Scope: {self.name}\n"
                f"Cyclomatic Complexity: {self.cyclomatic_complexity}\n"
                f"Depth of Nesting: {self.depth_of_nesting}\n"
                f"Lines of Code (LOC): {self.loc}\n"
                f"Number of Parameters: {self.n_arguments}\n"
                f"Number of Conditionals: {self.n_conditionals}\n"
                f"Number of Loops: {self.n_loops}\n"
                f"Number of Branches: {self.n_branches}\n"
                f"Number of Variables: {self.n_declarations}\n"
                f"Number of Return Statements: {self.n_results} \n"
                f"Number of Calls to External Functions/Procedures: {self.n_external_calls} \n"
                f"Number of Decision Points: {self.n_decision_points}\n"
                f"Halstead Complexity Metrics: TODO\n")


# Set the namespace as Fxtran for XPath expressions
ns = {"fx": "http://fxtran.net/#syntax"}


def is_external_call(a_stmt_element):
    # check if an element contains a routine call
    return a_stmt_element.find(path=f".//fx:parens-R", namespaces=ns) is not None


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
    conditionals_elements: Set = {"condition-E"}
    loop_elements: Set = {"do-stmt"}
    branch_elements: Set = {"if-then-stmt", "else-stmt"}
    branch_end_elements: Set = {"end-if-stmt"}
    declaration_elements: Set = {"a-stmt"}
    other_stmt_elements: Set = {"-stmt"}

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
        tag = element.tag.rsplit(sep="}", maxsplit=1)[-1]

        if tag.endswith("-stmt"):
            # Extract the statement name
            stmt_name = tag.rsplit(sep="-", maxsplit=1)[0]
            # Find scope name element
            name_element = element.find(path=f".//fx:{stmt_name}-N", namespaces=ns)

            if tag not in dyn_scope_elements and name_element is not None:
                end_tag = "end-" + tag
                if root.find(path=f".//fx:{end_tag}", namespaces=ns) is not None:
                    dyn_scope_elements.add(tag)
                    dyn_end_scope_elements.add(end_tag)

        # Set scope
        current_scope: Scope = scope_stack[-1] if scope_stack else None

        # Reduce the scope stack when leaving scopes
        if element.tag.endswith(tuple(dyn_end_scope_elements)):

            name = ".".join(list(map(lambda scope: scope.name, scope_stack)))

            scope_routines[name] = scope_stack.pop()

        # Extend the scope stack when entering scopes
        elif element.tag.endswith(tuple(dyn_scope_elements)):

            # Extract scope name
            scope_name = name_element.find(path=".//fx:n", namespaces=ns).text

            # Extract scope type
            scope_type = element.tag.split(ns["fx"] + "}", maxsplit=1)[1]

            # Extract scope parameters
            scope_arguments = element.findall(path=".//fx:arg-N", namespaces=ns)

            # Extract names of scope return statements in scope declaration
            scope_result_elements = element.findall(path=".//fx:result-spec", namespaces=ns)
            scope_results: List[str] = []
            for result_element in scope_result_elements:
                scope_results.extend(list(map(lambda element: element.text, result_element.findall(".//fx:n", ns))))

            # Build new scope
            new_scope = Scope(name=scope_name, type=scope_type, arguments=scope_arguments, scope_result_names=scope_results)

            # Add scope to parent
            if current_scope:
                current_scope.sub_scopes.append(new_scope)

            # Update scope stack
            scope_stack.append(new_scope)

        # Extract conditional statements
        elif element.tag.endswith(tuple(conditionals_elements)):
            current_scope.conditionals.append(element)

        # Extract loop statements
        elif element.tag.endswith(tuple(loop_elements)):
            current_scope.loops.append(element)

        # Extract branching statements
        elif element.tag.endswith(tuple(branch_end_elements)):
            current_scope.close_result()

        # Extract branching statements
        elif element.tag.endswith(tuple(branch_elements)):
            current_scope.branches.append(element)

            # TODO depr included in assignment statements  # # Extract optional return statements  # branch_assignments = element.findall(path='.//fx:a-stmt', namespaces=ns)  # current_scope.extend_result(branch_assignments)

        # Extract declaration statements
        elif element.tag.endswith(tuple(declaration_elements)):
            current_scope.declarations.append(element)

            # Add as result statement if it is the last call of the return statement
            current_scope.append_result(element)

            # Check for external calls
            named_elements = element.findall(path=".//fx:named-E", namespaces=ns)
            for named_element in named_elements:
                if is_external_call(named_element):
                    current_scope.external_calls.append(named_element)

        # Extract declaration statements
        elif element.tag.endswith(tuple(other_stmt_elements)):
            current_scope.other_stmt.append(element)

    # TODO debug output
    for scope_name, scope in scope_routines.items():
        print(
            scope
        )  # print(f"Scope: {scope_name}")  # print(f"Cyclomatic Complexity: {scope.cyclomatic_complexity}")  # print(f"Lines of Code: {scope.loc}\n")


def python_docs():
    """
    TODO rm
    xml Path example from https://docs.python.org/3.10/library/xml.etree.elementtree.html#elementtree-xpath
    """
    tree = ET.parse("/home/sgu/IdeaProjects/python-oceandsls/tdd-dsl/input/fxtran/opem/country_data.xml")
    root = tree.getroot()

    # Top-level elements
    top_level = root.findall(".")

    function_name = root.find("./function-stmt/function-N/N/n").text

    print(function_name)


# Read and process the XML file
xml_file_path = "/home/sgu/IdeaProjects/python-oceandsls/tdd-dsl/input/fxtran/opem/cfo_sut_example.f90.xml"

calculate_metrics(xml_file_path)
