#!/usr/bin/env python3
import sys
import importlib


def get_args(dsl_args):
    """return args, kvargs"""
    args = []
    kvargs = {}
    for dsl_arg in dsl_args:
        if '=' in dsl_arg:
            k, v = dsl_arg.split('=', 1)
            kvargs[k] = v
        else:
            args.append(dsl_arg)
    return args, kvargs


def get_help(module_name):
    mod = importlib.import_module(module_name)
    print(mod.__doc__ or '')
    for name in dir(mod):
        if not name.startswith('_'):
            attr = getattr(mod, name)
            print(attr.__name__)
            print(attr.__doc__ or '', '\n')


# The source file is the 1st argument to the script
if len(sys.argv) != 2:
    print('usage 0: %s <src.dsl>' % sys.argv[0])
    print('usage 1: %s help=<module name>' % sys.argv[0])
    sys.exit(1)

sys.path.insert(0, '/home/sgu/IdeaProjects/test-dsl/dsl_modules')

if sys.argv[1].startswith('help='):
    # passing module name excluding help=
    get_help(sys.argv[1][5:])
else:
    with open(sys.argv[1], 'r') as file:
        for line in file:
            line = line.strip()
            if not line or line[0] == '#':
                continue
            parts = line.split()
            print(parts)

            mod = importlib.import_module(parts[0])
            args, kvargs = get_args(parts[2:])
            getattr(mod, parts[1])(*args, **kvargs)
