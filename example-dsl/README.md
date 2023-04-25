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
  - `python -m pip install antlr4-python3-runtime pygls Jinja2`

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

- Goto extension directory `antlr4-python`
- Install the dependencies to the local node_modules 
  - `npm install`

## Run Example using VSCode

- Open `json-vscode-extension` in VSCode
  - ![Screenshot](uploads/f4a729acfaeff7fba98674b08550a531/Screenshot_from_2023-04-18_15-59-12.png)
- Trust author files in `json-vscode-extension`
  - ![Screenshot](uploads/be6b85e4dbecc95b8f433f67a0b223c1/Screenshot_from_2023-04-18_12-27-02.png)
- Goto Run and Debug
  - `Ctrl/Cmd+Shift+D`
- Select `Server + Client`
  - ![Screenshot](uploads/9e2362f519ddf9f3b40b72d7f4288dfb/Screenshot_from_2023-04-18_15-56-53.png)
- Start Debugging via `F5` or GUI
- Open a `*.json` file
- If server is working correctly notification shows `Text Document Did Open`
  - ![Screenshot](uploads/b879416c6a36484acc5943230814042a/Screenshot_from_2023-04-18_12-32-48.png)

## Troubleshooting

- If VS Code doesn`t automatically locate the interpreter of the virtual environment. [Set it manually](https://code.visualstudio.com/docs/python/environments#_manually-specify-an-interpreter)
  - Open Command prompt
  `Ctrl/Cmd+Shift+P`
    - Run select interpreter command
  `Python: Select Interpreter`
  - Alternative create `.vscode/settings.json` file in `json-vscode-extension` directory and set `python.defaultInterpreterPath` to point to the virtual environment
    - [settings.json]([settings.json](uploads/7aba21af411551c0ac867bc713eb9766/settings.json)

          {
              "python.defaultInterpreterPath": "${workspaceFolder}/.venv/bin/python"
          }

- If npm version conflicts exists change npm to the required version
  - E.g. reset npm version to 9.2.0
    - `sudo npm install -g npm@9.2.0`