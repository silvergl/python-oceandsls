## Optional: check python packages
- update package manager tools
  - `python -m pip install --upgrade pip setuptools wheel`
- check if python package `virtualenv` is installed if Python < 3.3 is used else a subset of it has been integrated into the standard library under the venv
  - `python -m pip show virtualenv`
  - if not install package `virtualenv` into global system environment
    - `python -m pip install virtualenv`

## Install Server Dependencies
- generate virtual environment in directory `.venv` using the standard library 'venv'
  - `python -m venv .venv`
  - alternative use `virtualenv`, see optional python packages
- activate virtual environment `.venv`
  - `source .venv/bin/activate`
- install `antlr4-python3-runtime`, `pygls` and `Jinja2` package into virtual environment `.venv`
  - `python -m pip install antlr4-python3-runtime Jinja2 mock pygls pytest`

## Optional: update npm and node
- check npm version
  - `npm --version`
- install latest npm version globally (-g or --global)
  - `sudo npm install -g npm@latest`
- install latest node version
  - `sudo n latest`
- Install the dependencies to the global mode (-g or --global)
  - `sudo npm update -g`

## Install Client Dependencies

- Goto extension directory `antlr4-python/example-dsl`
- Install the dependencies to the local node_modules 
  - `npm install`

## Run Example using VSCode

- Open `json-vscode-extension` in VSCode
- Trust author files in `json-vscode-extension`
- Goto Run and Debug
  - `Ctrl/Cmd+Shift+D`
- Select `Server + Client`
- Start Debugging via `F5` or GUI
- Open a `*.json` file
- If server is working correctly notification shows `Text Document Did Open`

## Troubleshooting

- If VS Code doesn`t automatically locate the interpreter of the virtual environment. [Set it manually](https://code.visualstudio.com/docs/python/environments#_manually-specify-an-interpreter)
  - Open Command prompt
  `Ctrl/Cmd+Shift+P`
    - Run select interpreter command
  `Python: Select Interpreter`
  - Alternative create `.vscode/settings.json` file in `antlr4-python/example-dsl` directory and set `python.defaultInterpreterPath` to point to the virtual environment
    - settings.json

          {
              "python.defaultInterpreterPath": "${workspaceFolder}/.venv/bin/python"
          }

- If npm version conflicts exists change npm to the required version
  - E.g. reset npm version to 9.2.0
    - `sudo npm install -g npm@9.2.0`