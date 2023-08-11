"""pfUnit generator using jinja2 templates to generate Fortran Unit Tests"""

__author__ = 'sgu'

# TODO license

# utils
import difflib
import os
from dataclasses import dataclass, field
from enum import Enum
from typing import List, Optional

# jinja2
from jinja2 import Environment, FileSystemLoader


# Python 3.11 alternative
# from enum import StrEnum
#
# class CallableType(StrEnum):
#     Function = 'function',
#     Subroutine = 'subroutine',
#     Procedure = 'procedure',
#     Subprogram = 'subprogram',
#     Method = 'method'
#
# @dataclass
# class Callable:
#     """
#     Subroutine for unit test case
#     """
#     name: str
#     type: CallableType


class CallableType(Enum):
    """
    Types of callable for unit test case
    """
    Function = 'function'
    Subroutine = 'subroutine'


@dataclass
class Callable:
    """
    Subroutine for unit test case
    """
    name: str
    _type: CallableType

    @property
    def type(self) -> Optional[CallableType]:
        return self._type.value

    @type.setter
    def type(self, new_type: Optional[CallableType]) -> None:
        self._type = new_type


@dataclass
class Module:
    """
    Module for unit test case
    """
    name: str


@dataclass
class Assertion:
    """
    pFUnit assertions for unit test case
    """
    name: str
    input: int
    output: int


@dataclass
class TestCase:
    """
    Test Case for a Unit-test
    """
    fn: str
    callable: Callable
    mods: List[Module] = field(default_factory=list)
    assertions: List[Assertion] = field(default_factory=list)


def merge_file_content(file_content_0: str, file_content_1: str) -> str:
    '''
    Merge two file contents based on difflib.

    :param file_content_0: Content of first file
    :param file_content_1: Content of second file
    :return: 3-way merge of comparing the first file and second file
    '''
    return "\n".join(
        lines[2:] for lines in difflib.Differ().compare(
            file_content_0.split("\n"),
            file_content_1.split("\n")
        )
        if not lines.startswith("?")
    )


def gen_test_data(num_files: int = 1, num_mods: int = 1, num_ass: int = 1) -> List[TestCase]:
    '''
    Generate test data for jinja_tdd

    :param num_files: number of test files
    :param num_mods: number of modules in each file
    :param num_ass: number of assertions in each file
    :return: list of unit tests
    '''
    list_tests = []
    for i in range(num_files):
        list_mods = []
        for j in range(num_mods):
            # list_mods.append( {'name': f"module_{i}_{j}"} )
            list_mods.append(Module(f"module_{i}_{j}"))

        list_ass = []
        for j in range(num_ass):
            # list_ass.append( {'name': f"assertion_{i}_{j}", 'input': i, 'output': j} )
            list_ass.append(Assertion(f"assertion_{i}_{j}", i, j))

        # list_tests.append( {'fn': f"file_{i}", 'sub': {'name': f"sub_{i}"}, 'mods': list_mods, 'assertions':
        # list_ass} )
        list_tests.append(
            TestCase(f"file_{i}", Callable(f"sub_{i}", CallableType.Subroutine), list_mods, list_ass)
        )

    return list_tests


def write_tdd(
        list_tests: List[TestCase], template_path: str = 'tdd-dsl/tdd_lsp_server/fileWriter/dev',
        template_files: List[str] = ['tdd_pf_template.txt', 'tdd_module_template.txt',
                                     'tdd_assertion_template.txt'],
        test_path: str = 'gen', test_folder: str = 'test', test_file_pr: str = 'test_'
) -> None:
    '''
    Write pFUnit files using Jinja2 Template files.

    :param list_tests: List of unit test data
    :param template_path: system path to template file
    :param template_file: template file
    :param test_path: system path to store pFUnit tests
    :param test_folder: test folder under system path for *.pf files
    :param test_files: prefix_name of *.pf files
    :return:
    '''
    # Load Jinja2 template
    environment = Environment(loader=FileSystemLoader(template_path))
    # Use test_template.txt
    template = environment.get_template(template_files[0])
    template_mod = environment.get_template(template_files[1])
    template_ass = environment.get_template(template_files[2])

    # Loop through each test
    for test in list_tests:
        # Render template
        modules = template_mod.render(test=test)
        assertions = template_ass.render(test=test)
        content = template.render(test=test, modules=modules, assertions=assertions)

        # Define the folder and filename
        path = os.path.join(os.getcwd(), test_path, test_folder)

        # Create folder if it doesn't exist
        if not os.path.isdir(path):
            os.makedirs(path)
            # TODO add to debug info
            print(f'... create {path}')

        # Create file if it doesn't exist else merge with existing file
        # filename = f"test_{test['fn'].lower()}.pf"
        filename = f"{test_file_pr}{test.fn.lower( )}.pf"
        path = os.path.join(os.getcwd(), path, filename)
        if os.path.exists(path):
            with open(path, mode='r', encoding='utf-8') as f:
                content_org = f.read()
            content = merge_file_content(content, content_org)

        # Write rendered and optional merged content to file
        with open(path, mode='w', encoding='utf-8') as f:
            f.write(content)
            # TODO add to debug info
            print(f'... wrote {path}')


# test function
# TODO mv to pytest
write_tdd(gen_test_data(num_mods=2))

assert_operands = {
    'fail': 0, 'equal': 2, 'notequal': 2, 'true': 1, 'false': 1,
    'lessthan': 2, 'lessthanorequal': 2, 'greaterthan': 2,
    'greaterthanorequal': 2, 'notequal': 2,
    'relativelyequal': 2, 'isinfinite': 1, 'isfinite': 1,
    'isnan': 1, 'ismemberof': 2, 'contains': 2, 'any': 1,
    'all': 1, 'notall': 1, 'none': 1, 'ispermutationof': 2,
    'exceptionraised': 0, 'sameshape': 2, 'that': 2, '_that': 2
}

assert_variants = '|'.join(assert_operands.keys())
