"""CMake test generate"""

__author__ = "sgu"

import logging
import os

from jinja2 import Environment, FileSystemLoader

# debug
logger = logging.getLogger(__name__)
# TODO debug flag
show_debug_output: bool = True

# Define the template variables
template_vars = {
    "PROJECTNAME": "MyProject",
    "SUTNAME": "MySUT",
    "SUTFILENAME": "sut_source.f90",
    "TESTFOLDER": "test",
    "TESTNAME": "MyTest",
    "TESTFILENAME": "test_source.f90"
}

# Initialize Jinja2 environment
# Assuming your templates are in a 'templates' folder
template_env = Environment(loader=FileSystemLoader("/home/sgu/IdeaProjects/python-oceandsls/tdd-dsl/tddlspserver/filewriter/jinjatemplates/cmake"))

# Load the templates
cmakelists_template = template_env.get_template("CMakeLists_template.txt")
test_cmakelists_template = template_env.get_template("test_CMakeLists_template.txt")

# Render the templates with the provided variables
cmakelists_content = cmakelists_template.render(template_vars)
test_cmakelists_content = test_cmakelists_template.render(template_vars)

file_path = "test0/CMakeLists.txt"

path = os.path.dirname(file_path)

# Create folder if it doesn't exist
if not os.path.isdir(path):
    os.makedirs(path)
    if show_debug_output and logger.isEnabledFor(logging.DEBUG):
        logger.debug(f"... create {path}")

# Write the rendered content to files
with open(file_path, "w") as f:
    f.write(cmakelists_content)

file_path = os.path.join(path, template_vars["TESTFOLDER"], "CMakeLists.txt")
path = os.path.dirname(file_path)

# Create folder if it doesn't exist
if not os.path.isdir(path):
    os.makedirs(path)
    if show_debug_output and logger.isEnabledFor(logging.DEBUG):
        logger.debug(f"... create {path}")

with open(file_path, "w") as f:
    f.write(test_cmakelists_content)

print("CMake setup files generated successfully.")
