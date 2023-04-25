# OceanDSL Python-based DSL Implementation

## Name

oceandsl-languages

## Description

This project contains multiple DSLs for ocean and earth system models.

- CP-DSL including Declaration-DSL, Configuration-DSL and Template-DSL
- TDD-DSL testing DSL for test-driven development
- BGC-DSL language to specify biogeochemical models

## License

Apache 2.0

## Install

### Optional: check python packages
- update package manager tools
  - `python -m pip install --upgrade pip setuptools wheel`
- check if python package `virtualenv` is installed if Python < 3.3 is used else a subset of it has been integrated into the standard library under the venv
  - `python -m pip show virtualenv`
  - if not install package `virtualenv` into global system environment
    - `python -m pip install virtualenv`

### Install Server Dependencies
- generate virtual environment in directory `.venv` using the standard library 'venv'
  - `python -m venv .venv`
  - alternative use `virtualenv`, see optional python packages
- activate virtual environment `.venv`
  - `source .venv/bin/activate`
- install `antlr4-python3-runtime`, `pygls` and `Jinja2` package into virtual environment `.venv`
  - `python -m pip install antlr4-python3-runtime Jinja2 mock pygls pytest`

### Optional: update npm and node
- check npm version
  - `npm --version`
- install latest npm version globally (-g or --global)
  - `sudo npm install -g npm@latest`
- install latest node version
  - `sudo n latest`
- Install the dependencies to the global mode (-g or --global)
  - `sudo npm update -g`

### Install Client Dependencies

- Goto extension directory `python-oceandsls/cp-dsl`
- Install the dependencies to the local node_modules 
  - `npm install`

### Run Example using VSCode

- Open `python-oceandsls/cp-dsl` in VSCode
- Trust author files in `python-oceandsls/cp-dsl`
- Goto Run and Debug
  - `Ctrl/Cmd+Shift+D`
- Select `Server + Client`
- Start Debugging via `F5` or GUI
- Open a `*.odsl` file
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

        // Pylance VSCode code analysis and auto-completion
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

***

# Editing this README

When you're ready to make this README your own, just edit this file and use the handy template below (or feel free to structure it however you want - this is just a starting point!). Thank you to [makeareadme.com](https://www.makeareadme.com/) for this template.

## Suggestions for a good README
Every project is different, so consider which of these sections apply to yours. The sections used in the template are suggestions for most open source projects. Also keep in mind that while a README can be too long and detailed, too long is better than too short. If you think your README is too long, consider utilizing another form of documentation rather than cutting out information.

## Name
Choose a self-explaining name for your project.

## Description
Let people know what your project can do specifically. Provide context and add a link to any reference visitors might be unfamiliar with. A list of Features or a Background subsection can also be added here. If there are alternatives to your project, this is a good place to list differentiating factors.

## Badges
On some READMEs, you may see small images that convey metadata, such as whether or not all the tests are passing for the project. You can use Shields to add some to your README. Many services also have instructions for adding a badge.

## Visuals
Depending on what you are making, it can be a good idea to include screenshots or even a video (you'll frequently see GIFs rather than actual videos). Tools like ttygif can help, but check out Asciinema for a more sophisticated method.

## Installation
Within a particular ecosystem, there may be a common way of installing things, such as using Yarn, NuGet, or Homebrew. However, consider the possibility that whoever is reading your README is a novice and would like more guidance. Listing specific steps helps remove ambiguity and gets people to using your project as quickly as possible. If it only runs in a specific context like a particular programming language version or operating system or has dependencies that have to be installed manually, also add a Requirements subsection.

## Usage
Use examples liberally, and show the expected output if you can. It's helpful to have inline the smallest example of usage that you can demonstrate, while providing links to more sophisticated examples if they are too long to reasonably include in the README.

## Support
Tell people where they can go to for help. It can be any combination of an issue tracker, a chat room, an email address, etc.

## Roadmap
If you have ideas for releases in the future, it is a good idea to list them in the README.

## Contributing
State if you are open to contributions and what your requirements are for accepting them.

For people who want to make changes to your project, it's helpful to have some documentation on how to get started. Perhaps there is a script that they should run or some environment variables that they need to set. Make these steps explicit. These instructions could also be useful to your future self.

You can also document commands to lint the code or run tests. These steps help to ensure high code quality and reduce the likelihood that the changes inadvertently break something. Having instructions for running tests is especially helpful if it requires external setup, such as starting a Selenium server for testing in a browser.

## Authors and acknowledgment
Show your appreciation to those who have contributed to the project.

## License
For open source projects, say how it is licensed.

## Project status
If you have run out of energy or time for your project, put a note at the top of the README saying that development has slowed down or stopped completely. Someone may choose to fork your project or volunteer to step in as a maintainer or owner, allowing your project to keep going. You can also make an explicit request for maintainers.
