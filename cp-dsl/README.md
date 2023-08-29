# cp-dsl for biogeochemical models

## Install
### Check python packages (optional)
- update package manager tools
  - `python -m pip install --upgrade pip setuptools wheel`
- check if python package `virtualenv` is installed if Python < 3.3 is used else a subset of it has been integrated into the standard library under `venv`
  - `python -m pip show virtualenv`
  - if not install package `virtualenv` into global system environment
    - `python -m pip install virtualenv`

#### Install Server Dependencies
- generate virtual environment in directory `.venv` using the standard library `venv`
  - `python -m venv .venv`
  - alternative use `virtualenv`, see optional python packages
- activate virtual environment `.venv`
  - `source .venv/bin/activate`
- install `antlr4-python3-runtime`, `Jinja2`, `mock`, `pygls` and `pytest` package into virtual environment `.venv`
  - `python -m pip install antlr4-python3-runtime Jinja2 mock pygls pytest`


### Update npm and node (optional)
- check `npm` version
  - `npm --version`
- install latest `npm` version globally (`-g` or `--global`)
  - `sudo npm install -g npm@latest`
- install latest `node` version
  - `sudo n latest`
- Install the dependencies to the global mode (`-g` or `--global`)
  - `sudo npm update -g`

### Install Client Dependencies

- Goto extension directory `python-oceandsls/cp-dsl`
- Install the dependencies to the local node_modules 
  - `npm install`

## Run Example using VSCode

- Open `python-oceandsls/cp-dsl/confLSPServer` or `python-oceandsls/cp-dsl/declLSPServer` in VSCode
- Trust author files in `python-oceandsls/cp-dsl`
- Goto Run and Debug
  - `Ctrl/Cmd+Shift+D`
- Select `Server + Client`
- Start Debugging via `F5` or GUI
- Open a `*.oconf`/`*.decl` file
- If server is working correctly notification shows `Text Document Did Open`

### Troubleshooting

- If VS Code doesn`t automatically locate the interpreter of the virtual environment. [Set it manually](https://code.visualstudio.com/docs/python/environments#_manually-specify-an-interpreter)
  - Open Command prompt
  `Ctrl/Cmd+Shift+P`
    - Run select interpreter command
  `Python: Select Interpreter`
  - Alternative create `.vscode/settings.json` file in `python-oceandsls/cp-dsl` directory and set `python.defaultInterpreterPath` to point to the virtual environment
    - settings.json

          {
              // set Python Interpreter relative to workspaceFolder to virtual environment '.venv'
              "python.defaultInterpreterPath": "${workspaceFolder}/../.venv/bin/python",
              // alternative
              //"python.defaultInterpreterPath": "../.venv",
              // deprecated
              // "python.pythonPath": "${workspaceFolder}/../.venv/bin/python",

              // Pylance VSCode code analysis and auto-completion using Python 3.10
              "python.analysis.extraPaths": [
                  "{workspaceFolder}/../.venv/lib/python3.10/site-packages/:${workspaceFolder}/../antlrLib/"
              ],


              // Object with environment variables that will be added to the VS Code process to be used by the terminal on OS X
              "terminal.integrated.env.osx": {"PYTHONPATH": "${workspaceFolder}/.."},

              // Object with environment variables that will be added to the VS Code process to be used by the terminal on Linux
              "terminal.integrated.env.linux": {"PYTHONPATH": "${workspaceFolder}/.."},

              // Object with environment variables that will be added to the VS Code process to be used by the terminal on Windows
              "terminal.integrated.env.windows": {"PYTHONPATH": "${workspaceFolder}/.."},
          }

- If npm version conflicts exists change npm to the required version
  - E.g. reset npm version to 9.2.0
    - `sudo npm install -g npm@9.2.0`

# Compile and generate code

## Using console compiler
- open a terminal and type `python -m cp-dsl -f <path-to-oconf-file>`
- there are two different file generator available atm
  - mitgcm: to generate for mitgcm, use flag `-m`
  - uvic: to generate for uvic, use flag `-u`
- the compiler writes the generated files in the `gen` folder in your cwd
  - with flag `-o <path-to-your-output-folder>` it is possible to define a sepcific output folder
- IMPORTANT: make sure the `.decl` file for your `.oconf` file is in the same directory (different pathes are not yet supported)

the compiler can throw different errors and warnings while compiling the files:
- Warnings are only a info for the user, i.e. to inform the user that in the declaration a parameter has no default value
- Errors are mostly thrown by pythons `AttributeError` or by array index errors so make sure you dont use a operator between a string and a integer

## Using language-server
not yet supported

# Change or add templates

## Change a template (uvic, mitgcm):
- go to folder `/confLSPServer/fileWriter/jinja-templates`
- edit the files as you wish, the templates are named as the files they generate added by a `.template`

## Add a template
- go to folder `/confLSPServer/fileWriter/jinja-templates`
  - create your templates using [jinja-template-language](https://jinja.palletsprojects.com/en/3.1.x/)
  - example for a instance splitter:
    ```jinja
    {% macro typeDeciderTemplate(elem, lastSymbol) -%}
    {% if isinstance(elem, featureSymbol) -%}
        {{ featureTemplate(elem) }}
    {%- elif isinstance(elem, groupSymbol) -%}
        {{ groupTemplate(elem) }}
    {%- elif isinstance(elem, enumSymbol) -%}
    {%- else -%}
        {{parameterTemplate(elem, lastSymbol)}}
    {%- endif %}
    {%- endmacro -%}
    ```
- create a code-generator
  - navigate to `/confLSPServer/fileWriter/`
  - open `CodeGenerator.py` you will find a superclass for a code generator:
    ```python
    class StandartCodeGenerator():
      def __init__(self, symbolTable : SymbolTable, outputPath : str, templatePath = "") -> None:
          self._symbolTable : SymbolTable = symbolTable
          self.outputPath = outputPath
          if templatePath == "":
              self.templateLoader = j.PackageLoader(str(self.__module__), "<your_path>")
              self.templateEnv = j.Environment(loader=self.templateLoader)
          
      def writeFile(self, content : str, filename : str):
          path = os.path.join(self.outputPath, filename)
          f = open(path, "w")
          f.write(content)
          f.close()
      
      def generate(self) -> None:
          print("GIVE THE GENERATOR A TEMPLATE AND DATA TO WORK WITH")
    ```
  - use this superclass to create a generator
  - add the option to compile to this generator in the main method
    - `parser.add_argument("<your_flag>", action="store_true", dest=<your_language>)`
  - check for the argument:
    ```python
    if args.your_language:
      generator = yourCodeGenerator(table, outputPath)
      generator.generate()
    ```
