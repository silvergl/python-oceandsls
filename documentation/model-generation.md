# Model Generation

## Generating ECore from Antlr-Grammar

Open questions:
- How to distinguish terminals for references (aggregation) and attributes?

Process:
- Create for every grammar-rule one ECore class
- Create for every terminal with value, e.g., id, name, string, numbers, an attribute
  unless this is a reference to somewhere else.
- Create for every non-terminal a reference (composition) in the ECore class

## Generating Python Ecore Classes from ECore-file

https://github.com/pyecore/pyecore

Installation:
pip install pyecore
pip install pyecoregen

Running:
pyecoregen -e your_ecore_file.ecore -o your_output_path

Alternative:
Download the script /models/ecoreExp.py
run i.e.: `python ecoreEcp.py file1.ecore file2.ecore outputFolder/`

## Mapping AST to Model

- How to map AST to model?
- How to resolve names and handle scope?


