# Json Language Server

## Install Server Dependencies


1. add virtual environment
1. update pip and setuptools
  - `python -m pip install --upgrade pip`
  - `pip install -U setuptools`
1. `python -m pip install pygls`
1. Create `.vscode/settings.json` file and set `python.pythonPath` to point to your python environment where `pygls` is installed

## Install Client Dependencies

Open terminal and execute following commands:

1. `npm install`
1. `cd client/ && npm install`

## Run Example

1. Open this directory in VS Code
1. Open debug view (`ctrl + shift + D`)
1. Select `Server + Client` and press `F5`
