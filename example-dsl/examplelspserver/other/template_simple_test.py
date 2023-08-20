"""test example for using the Jinja2 template engine"""

__author__ = 'sgu'

# TODO license

# jinja2
from jinja2 import Environment, FileSystemLoader

# direct string template
environment = Environment()
template = environment.from_string("string0 '{{ str0 }}'")
template.render(str0="Foobar")

# use test_template.txt
int_1 = -1
str_1 = "str_1"
list_dict = [
    {"str_0": "Test str_0_0", "int_0": 0},
    {"str_0": "Test str_0_1", "int_0": 1},
    {"str_0": "Test str_0_2", "int_0": 2},
]

environment = Environment(loader=FileSystemLoader("templates/"))
template = environment.get_template("test_template.txt")

for dict in list_dict:
    filename = f"gen/plain_{dict['str_0'].lower()}.txt"
    content = template.render(
        dict,
        int_1=int_1,
        str_1=str_1
    )
    with open(filename, mode="w", encoding="utf-8") as message:
        message.write(content)
        print(f"... wrote {filename}")
