""" Demo implementation for cyclomatic complexity calculation"""

__author__ = "sgu"

import xml.etree.ElementTree as ET
from dataclasses import dataclass, field
from math import log2
from typing import Dict, List, Optional, Set


class UniqueList( list ):
    """
    List with unique elements. Resets if added to closed list.
    """
    __closed: bool = False

    def close( self ):
        # Close list
        self.__closed = True

    def extend( self, elements: List ):
        # Reset if closed
        if self.__closed:
            self.clear( )
            __close = False

        # Add elements if not in list
        for element in elements:
            self.append( element )

    def append( self, element ):
        # Reset if closed
        if self.__closed:
            self.clear( )
            __close = False

        # Add element if not in list
        if not self.__contains__( element ):
            super( ).append( element )


@dataclass
class Scope:
    """
    Scope for cyclomatic complexity
    """
    name: str = field( default = "" )
    type: str = field( default = "" )
    src: str = field( default = "" )

    routine_types: Set = field( default_factory = lambda: {"function-stmt", "subroutine-stmt"} )
    module_types: Set = field( default_factory = lambda: {"module-stmt"} )

    conditionals: List[ ET.Element ] = field( default_factory = lambda: [ ] )
    loops: List[ ET.Element ] = field( default_factory = lambda: [ ] )
    branches: List[ ET.Element ] = field( default_factory = lambda: [ ] )
    assignment: List[ ET.Element ] = field( default_factory = lambda: [ ] )
    declarations: List[ ET.Element ] = field( default_factory = lambda: [ ] )
    other_stmt: List[ ET.Element ] = field( default_factory = lambda: [ ] )
    arguments: List[ ET.Element ] = field( default_factory = lambda: [ ] )
    external_calls: List[ ET.Element ] = field( default_factory = lambda: [ ] )
    sub_scopes: List = field( default_factory = lambda: [ ] )
    scope_result_names: List[ str ] = field( default_factory = lambda: [ ] )

    # List of last result declarations
    __scope_result_decl: UniqueList = field( default_factory = lambda: UniqueList( ) )

    # List of operands, operators and their occurrences
    __operands: Dict[ str, int ] = field( default_factory = lambda: {} )
    __operators: Dict[ str, int ] = field( default_factory = lambda: {} )

    # Set of operators pairs
    __operator_pairs: Set = field( default_factory = lambda: {"()", "{}", "<>", "[]"} )

    ###############################
    # Halstead Complexity Measures
    ###############################

    @property
    def operators( self ) -> Dict[ str, int ]:
        # Recalc pair operator counts
        operators: Dict[ str, int ] = dict( self.__operators )
        for operator_pair in self.__operator_pairs:
            cnt: int = operators.get( operator_pair, None )
            if cnt:
                cnt: int = int( cnt / 2 ) + (cnt % 2)
                operators[ operator_pair ] = cnt

        for sub_scope in self.sub_scopes:
            s_operators: Dict[ str, int ] = sub_scope.operators




            for key, value in s_operators.items( ):
                operators[ key ] = operators.get( key, 0 ) + value
        return operators

    @property
    def operands( self ) -> Dict[ str, int ]:
        operands: Dict[ str, int ] = dict( self.__operands )

        for sub_scope in self.sub_scopes:
            s_operands: Dict[ str, int ] = sub_scope.operands

            decl_elements = sub_scope.declarations
            decl_names: List[ str] = []
            for decl_element in decl_elements:
                name_element = decl_element.find( f"{search_global}{name_tag}", ns )
                if name_element is not None:
                    decl_names.append(name_element.text.lower())

            for key, value in s_operands.items( ):
                if key in decl_names:
                    key = f"{sub_scope.name}.{key}"
                operands[ key ] = operands.get( key, 0 ) + value
        return operands

    @property
    def n_operators( self ) -> int:
        """
        Number of distinct operators : η1
        :return: η1
        """
        return len( self.operators )

    @property
    def n_operands( self ) -> int:
        """
        Number of distinct operands : η2
        :return: η2
        """
        return len( self.operands )

    @property
    def sum_operators( self ) -> int:
        """
        Total number of operators : N1
        :return: N1
        """
        return sum( self.operators.values( ) )

    @property
    def sum_operands( self ) -> int:
        """
        Total number of operands : N2
        :return: N2
        """
        return sum( self.operands.values( ) )

    @property
    def vocabulary( self ) -> int:
        """
        Program vocabulary: η = η1 + η2
        :return: η
        """
        return self.n_operators + self.n_operands

    @property
    def program_length( self ) -> int:
        """
        Program length: N = N1 + N2
        :return: N
        """
        return self.sum_operators + self.sum_operands

    @property
    def calculated_length( self ) -> float:
        """
        Calculated estimated program length: N^ = η1 log2 η1 + η2 log2 η2
        :return:  N^
        """
        n1: int = self.n_operators
        n2: int = self.n_operands

        operator_lenght : int = n1 * log2( n1 ) if n1 > 0 else 0
        operands_lenght : int = n2 * log2( n2 ) if n2 > 0 else 0

        return operator_lenght + operands_lenght

    @property
    def volume( self ) -> float:
        """
        Volume: V = N × log2(η)
        :return: V
        """
        return self.program_length * log2( self.vocabulary ) if self.vocabulary > 0 else 0

    @property
    def difficulty( self ) -> float:
        """
        Difficulty : D = η1/2 × N2/η2
        :return: D
        """
        n1: int = self.n_operators
        n2: int = self.n_operands
        N2: int = self.sum_operands
        return (n1 / 2) * (N2 / n2) if n2 > 0 else 0

    @property
    def effort( self ) -> float:
        """
        Effort: E = D × V
        :return: E
        """
        return self.difficulty * self.volume

    @property
    def time_required_to_program( self ) -> float:
        """
        Time required to program: T = E/18
        :return: T
        """
        return self.effort / 18

    @property
    def n_bugs( self ) -> float:
        """
        Number of delivered bugs : B = E^{2/3}/3000
        :return: B
        """
        return self.effort ** (2 / 3) / 3000

    ###############################
    # Cyclomatic complexity
    ###############################

    @property
    def n_results( self ) -> int:
        n_results: int = len( self.__scope_result_decl )
        for sub_scope in self.sub_scopes:
            n_results += sub_scope.n_results
        return n_results

    @property
    def n_conditionals( self ) -> int:
        n_conditionals: int = len( self.conditionals )
        for sub_scope in self.sub_scopes:
            n_conditionals += sub_scope.n_conditionals
        return n_conditionals

    @property
    def n_loops( self ) -> int:
        n_loops: int = len( self.loops )
        for sub_scope in self.sub_scopes:
            n_loops += sub_scope.n_loops
        return n_loops

    @property
    def n_branches( self ) -> int:
        n_branches: int = len( self.branches )
        for sub_scope in self.sub_scopes:
            n_branches += sub_scope.n_branches
        return n_branches

    @property
    def n_assignment( self ) -> int:
        n_assignment: int = len( self.assignment )
        for sub_scope in self.sub_scopes:
            n_assignment += sub_scope.n_assignment
        return n_assignment

    @property
    def n_declarations( self ) -> int:
        n_declarations: int = len( self.declarations )
        for sub_scope in self.sub_scopes:
            n_declarations += sub_scope.n_declarations
        return n_declarations

    @property
    def n_other_stmts( self ) -> int:
        n_other_stmts: int = len( self.other_stmt )
        for sub_scope in self.sub_scopes:
            n_other_stmts += sub_scope.n_other_stmts
        return n_other_stmts

    @property
    def n_arguments( self ) -> int:
        n_arguments: int = len( self.arguments )
        for sub_scope in self.sub_scopes:
            n_arguments += sub_scope.n_arguments
        return n_arguments

    @property
    def n_external_calls( self ) -> int:
        n_external_calls: int = len( self.external_calls )
        for sub_scope in self.sub_scopes:
            n_external_calls += sub_scope.n_external_calls
        return n_external_calls

    @property
    def cyclomatic_complexity( self ) -> int | None:
        """
        Cyclomatic complexity function for structures with only one entry point and one exit point.
        Number of predicate variables involved plus decision points ("if" statements and loops) plus one : CC
        :return: CC
        """
        # Check structure
        if self.is_routine or self.is_module:
            # Simple structure
            return self.n_conditionals + self.n_loops + self.n_branches + 1
        else:
            # Unsupported structure
            return None

    @property
    def loc( self ) -> int:
        """
        :return: Lines of codes in a scope as number of statements
        """
        return self.n_loops + self.n_branches + self.n_assignment + self.n_other_stmts

    @property
    def n_decision_points( self ) -> int:
        """
        :return: Number of decision points in scope
        """
        return self.n_loops + self.n_branches

    @property
    def depth_of_nesting( self ) -> int:
        """
        :return: Maximum depth of nesting of scope
        """
        depth_of_nesting: int = 0
        for sub_scope in self.sub_scopes:
            depth_of_nesting = max( depth_of_nesting, 1 + sub_scope.depth_of_nesting )
        return depth_of_nesting

    @property
    def is_testable( self ) -> bool:
        return self.is_routine or self.is_module

    @property
    def is_routine( self ) -> bool:
        return self.type in self.routine_types

    @property
    def is_module( self ) -> bool:
        return self.type in self.module_types

    ###############################
    # Utils
    ###############################

    def close_result( self ):
        self.__scope_result_decl.close( )

    def extend_result( self, elements ):
        for element in elements:
            self.append_result( element )

    def append_result( self, element ):
        name_element = element.find( f"{search_global}{name_tag}", ns )
        name_element = name_element.text if name_element is not None else None
        if self.is_routine and (name_element in self.scope_result_names or not self.scope_result_names):
            self.__scope_result_decl.append( element )

    def add_operand( self, operand: str ):
        operand = operand.lower( )
        self.__operands[ operand ] = self.__operands.get( operand, 0 ) + 1

    def add_operator( self, operator: str ):
        operator = operator.lower( )
        for operator_pair in self.__operator_pairs:
            if operator in operator_pair:
                operator = operator_pair
                break

        self.__operators[ operator ] = self.__operators.get( operator, 0 ) + 1

    def __str__( self ):
        """ toString method """
        return (f"Scope: {self.name}\n"
                f"Source: {self.src}\n"
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
                f"Halstead Complexity Measures:\n"
                f"Number of distinct Operators η1: {self.n_operators}\n"
                f"Number of distinct Operands η2: {self.n_operands}\n"
                f"Number of total Operators N1: {self.sum_operators}\n"
                f"Number of total Operands N2: {self.sum_operands}\n"
                f"Vocabulary (η1 + η2): {self.vocabulary}\n"
                f"Program Length (N1 + N2): {self.program_length}\n"
                f"Calculated Length: {self.calculated_length}\n"
                f"Volume: {self.volume}\n"
                f"Difficulty: {self.difficulty}\n"
                f"Effort: {self.effort}\n"
                f"Time required to program: {self.time_required_to_program}\n"
                f"Number of delivered bugs: {self.n_bugs}\n"
                # f"Distinct Operators: {self.operators}\n"
                # f"Distinct Operands: {self.operands}\n"
                )


# Set the namespace as Fxtran for XPath expressions
ns = {"fx": "http://fxtran.net/#syntax"}

# Filters
name_tag : str = "n"
literal_tag: str = "l"
code_tag : str = "c"
external_paren_tag = "parens-R"
parameter_tag :str = "arg-N"
result_tag : str = "result-spec"
name_element_tag : str = "named-E"
operand_tags: Set = {name_tag, literal_tag}
operator_tags: Set = {code_tag}

search_global : str = ".//fx:"
search_local : str = "./fx:"

def is_external_call( a_stmt_element: ET.Element ):
    # check if an element contains a routine call
    return a_stmt_element.find( path = f"{search_global}{external_paren_tag}", namespaces = ns ) is not None


def add_operands_to( scope: Scope, element: ET.Element ):
    for tag in operand_tags:
        operands = element.findall( path = f"{search_global}{tag}", namespaces = ns )
        for operand in operands:
            if operand.text:
                scope.add_operand( operand.text.strip( ) )


def add_operators_to( scope: Scope, element: ET.Element ):
    for tag in operator_tags:
        operators = element.findall( path = f"{search_local}{tag}", namespaces = ns )
        for operator in operators:
            if operator.text:
                scope.add_operator( operator.text.strip( ) )


def calculate_metrics( xml_path: str = None, src : str = None ):
    """
    Calculate cyclomatic complexity and halstead complexity measures from fxtran formatted xml file for Fortran code
    :param xml_path:
    :return: None
    """
    # Get the root element
    tree = ET.parse( xml_path )
    root = tree.getroot( )

    # Filters
    conditionals_elements: Set = {"condition-E"}
    loop_elements: Set = {"do-stmt"}
    branch_elements: Set = {"if-then-stmt", "else-stmt"}
    branch_end_elements: Set = {"end-if-stmt"}
    assignment_elements: Set = {"a-stmt"}
    declaration_elements: Set = {"EN-decl"}
    other_stmt_elements: Set = {"-stmt"}

    # Dynamically extracted scope-changing elements
    dyn_scope_elements = set( )
    dyn_end_scope_elements = set( )
    # Stack to track the current scope
    scope_stack = [ ]
    # Routines defined in scope
    scopes: Dict[ str, Scope ] = {}

    for element in root.iter( ):
        # Check if element is scope-changing by searching for scope-ending element

        # Extract the tag name without the namespace
        tag = element.tag.rsplit( sep = "}", maxsplit = 1 )[ -1 ]

        if tag.endswith( "-stmt" ):
            # Extract the statement name
            stmt_name = tag.rsplit( sep = "-", maxsplit = 1 )[ 0 ]
            # Find scope name element
            name_element = element.find( path = f"{search_global}{stmt_name}-N", namespaces = ns )

            if tag not in dyn_scope_elements and name_element is not None:
                end_tag = "end-" + tag
                if root.find( path = f"{search_global}{end_tag}", namespaces = ns ) is not None:
                    dyn_scope_elements.add( tag )
                    dyn_end_scope_elements.add( end_tag )

        # Set scope
        current_scope: Scope = scope_stack[ -1 ] if scope_stack else None

        # Reduce the scope stack when leaving scopes
        if element.tag.endswith( tuple( dyn_end_scope_elements ) ):

            name = ".".join( list( map( lambda scope: scope.name, scope_stack ) ) )

            scopes[ name ] = scope_stack.pop( )

            if current_scope:
                # Check for operators
                add_operators_to( current_scope, element )

        # Extend the scope stack when entering scopes
        elif element.tag.endswith( tuple( dyn_scope_elements ) ):

            # Extract scope name
            scope_name = name_element.find( path = f"{search_global}{name_tag}", namespaces = ns )
            scope_name = scope_name.text if scope_name is not None else ""

            # Extract scope type
            scope_type = element.tag.split( ns[ "fx" ] + "}", maxsplit = 1 )[ 1 ]

            # Extract scope parameters
            scope_arguments = element.findall( path = f"{search_global}{parameter_tag}", namespaces = ns )

            # Extract names of scope return statements in scope declaration
            scope_result_elements = element.findall( path = f"{search_global}{result_tag}", namespaces = ns )
            scope_results: List[ str ] = [ ]
            for result_element in scope_result_elements:
                scope_results.extend( list( map( lambda element: element.text, result_element.findall( f"{search_global}{name_tag}", namespaces = ns ) ) ) )

            # Build new scope
            new_scope = Scope( name = scope_name, type = scope_type, arguments = scope_arguments, scope_result_names = scope_results, src = src )

            # Add scope to parent
            if current_scope:
                current_scope.sub_scopes.append( new_scope )

            # Update scope stack
            scope_stack.append( new_scope )

            # Check new scope for operators
            add_operators_to( new_scope, element )

        else:
            # Non-scope elements

            if current_scope:
                # Check for operators
                add_operators_to( current_scope, element )

            # Extract conditional statements
            if element.tag.endswith( tuple( conditionals_elements ) ):
                current_scope.conditionals.append( element )

            # Extract loop statements
            elif element.tag.endswith( tuple( loop_elements ) ):
                current_scope.loops.append( element )

            # Extract branching statements
            elif element.tag.endswith( tuple( branch_end_elements ) ):
                current_scope.close_result( )

            # Extract branching statements
            elif element.tag.endswith( tuple( branch_elements ) ):
                current_scope.branches.append( element )

            # Extract assignment statements
            elif element.tag.endswith( tuple( assignment_elements ) ):
                current_scope.assignment.append( element )

                # Add as result statement if it is the last call of the return statement
                current_scope.append_result( element )

                # Check for external calls
                named_elements = element.findall( path = f"{search_global}{name_element_tag}", namespaces = ns )
                for named_element in named_elements:
                    if is_external_call( named_element ):
                        current_scope.external_calls.append( named_element )

                # Check for operands
                add_operands_to( current_scope, element )
            # Extract declaration statements
            elif element.tag.endswith( tuple( declaration_elements ) ):
                current_scope.declarations.append( element )

                # Check for operands
                add_operands_to( current_scope, element )

            # Extract other statements
            elif element.tag.endswith( tuple( other_stmt_elements ) ):
                current_scope.other_stmt.append( element )

    # TODO debug output
    # for scope_name, scope in scopes.items( ):
    #     print( scope )

    return scopes
