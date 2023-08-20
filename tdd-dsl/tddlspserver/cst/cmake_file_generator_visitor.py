"""CMake file generator visitor module."""

__author__ = 'sgu'

import os
# util
from typing import Dict, Tuple

# jinja2
from jinja2 import Environment, FileSystemLoader

# user relative imports
from ..filewriter.file_writer import write_file
from ..gen.python.TestSuite.TestSuiteParser import TestSuiteParser
from ..symboltable.symbol_table import SymbolTable
from ..gen.python.TestSuite.TestSuiteVisitor import TestSuiteVisitor
from ..utils.suggest_variables import get_scope


class CMakeFileGeneratorVisitor(TestSuiteVisitor):
    symbol_table: SymbolTable
    work_path: str

    def __init__(
        self, template_path: str = 'tdd-dsl/tddlspserver/filewriter/jinjatemplates/cmake', files: Dict[str, Tuple[float, str, str]] = {},
        symbol_table: SymbolTable = None, work_path: str = 'tdd-dsl/output'
        ):
        """
        Generate CMake files for test case

        :param template_path: system path to jinja templates
        :param files: File attributes of files generated by the tdd-dsl server
        :param symbol_table: Symbol table to resolve symbols of tdd-dsl server
        :param work_path: system path to generate test suite
        """
        super().__init__()

        self.files: dict[str, Tuple[float, str, str]] = files

        self.symbol_table = symbol_table

        self.template_path = template_path

        # Load Jinja2 templates
        self.template_env = Environment(loader=FileSystemLoader(template_path), trim_blocks=True, lstrip_blocks=True, keep_trailing_newline=False)

        self.work_path = work_path

        self.file_templates = {}
        # Get template file names from grammar
        i: int = 0
        for rule in TestSuiteParser.ruleNames:
            self.file_templates[i] = f'{rule}_template.txt'
            i += 1

    # Visit a parse tree produced by TestSuiteParser#test_suite.
    def visitTest_suite(self, ctx:TestSuiteParser.Test_suiteContext):

        # Update test case symbol
        test_case_symbol = get_scope(ctx, self.symbol_table)

        suts = {}
        sut_names = []
        sut: Tuple = ()
        for case in ctx.cases:
            sut = self.visit(case)

            # Add name
            # TODO
            sut_names.append(sut[0])

            # Extract file name

            # TODO rm depr
            # # Build folder structure from working directory
            # rel_sut_file = os.path.relpath(sut[1],self.work_path)
            # rel_sut_file = rel_sut_file if rel_sut_file != '.' else None
            # # Add name file mapping
            # suts[sut[0]] = suts.get(sut[0], rel_sut_file)

            # Add name file mapping based on source file folder
            suts[sut[0]] = os.path.split(sut[1])[1]

        # Set project_folder
        abs_prj_dir = os.path.split(sut[1])[0]

        # Set test folder
        rel_test_dir = os.path.relpath(sut[2],abs_prj_dir)

        # Set template variables
        template_vars = {
            'PROJECTNAME': ctx.name.text,
            'SUTS': suts,
            'SUTNAMES': sut_names,
            'TESTFOLDER': rel_test_dir,
            'RENDER_TEMPLATE' : ''
        }

        # Load Jinja2 template
        template = self.template_env.get_template(self.file_templates[ctx.getRuleIndex()])

        # Write CMake file into project folder
        abs_path: str = os.path.join(abs_prj_dir, "CMakeLists.txt")

        # Check if file exists and need to be merged
        if os.path.exists(abs_path):
            # Generate parts to be merged into
            insert = True

            template_vars['RENDER_TEMPLATE'] = 'add_library'

            library_statements = template.render(template_vars)

            template_vars['RENDER_TEMPLATE'] = 'target_include'

            target_include_statements = template.render(template_vars)

            content = [library_statements, target_include_statements, sut_names]

        else:
            # Generate new file
            insert = False

            template_vars['RENDER_TEMPLATE'] = 'new'

            # Render template
            content = template.render(template_vars)

        # Write the rendered content to files
        file_attr = self.files.get(abs_path)
        self.files[abs_path] = write_file(abs_path, content, file_attr, insert)

        return self.files

    # Visit a parse tree produced by TestSuiteParser#test_case.
    def visitTest_case(self, ctx: TestSuiteParser.Test_caseContext):
        # Resolve test case symbol
        test_case_symbol = get_scope(ctx, self.symbol_table)

        # Get system file paths
        test_file = os.path.split(test_case_symbol.test_file_path)

        # Get relative test directory path
        rel_test_dir = os.path.relpath(test_file[0], self.work_path)
        rel_test_dir = rel_test_dir if rel_test_dir != '.' else None

        # Set sut name according to test name
        sut_name = f'{test_case_symbol.test_name}_sut'

        # Set template variables
        template_vars = {
            'SUTNAME': sut_name,  # 'MySUT', # cfo_example
            'TESTNAME': test_case_symbol.test_name,  # 'MyTest',   # test_fT_ME
            'TESTFILENAME': test_file[1]  # 'test_source.f90'
        }

        # Load Jinja2 template
        template = self.template_env.get_template(self.file_templates[ctx.getRuleIndex()])

        # Render template
        content = template.render(template_vars)

        # Write the rendered content to files
        abs_path: str = os.path.join(test_file[0], "CMakeLists.txt")
        file_attr = self.files.get(abs_path)

        # TODO 19.08 existing file
        self.files[abs_path] = write_file(abs_path, [content], file_attr, False)

        # Return system under test details
        sut : Tuple = (sut_name,test_case_symbol.sut_file_path, rel_test_dir)

        return sut
