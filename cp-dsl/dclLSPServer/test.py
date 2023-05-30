import re

literalNames = [ "<INVALID>", "'model'", "'types'", "'group'", "':'", 
                 "'{'", "'}'", "'def'", "','", "'='", "'required'", 
                 "'feature'", "'requires'", "'excludes'", "'sub'", "'alternative'", 
                 "'multiple'", "'('", "')'", "'['", "']'", "'range'", 
                 "'enum'", "'*'", "'/'", "'**'", "'noP'", "'yotta'", 
                 "'zetta'", "'exa'", "'peta'", "'tera'", "'giga'", "'mega'", 
                 "'kilo'", "'hecto'", "'deca'", "'deci'", "'centi'", 
                 "'mili'", "'micro'", "'nano'", "'pico'", "'femto'", 
                 "'atto'", "'zepto'", "'yocto'", "'meter'", "'gram'", 
                 "'ton'", "'second'", "'ampere'", "'kelvin'", "'mole'", 
                 "'candela'", "'pascal'", "'Joul'", "'+'", "'-'", "'%'", 
                 "'.'" ]

symbolicNames = [ "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                  "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                  "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                  "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                  "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                  "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                  "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                  "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                  "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                  "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                  "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                  "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                  "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                  "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                  "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                  "<INVALID>", "ELONG", "EDOUBLE", "EBoolean", "ID", 
                  "INT", "STRING", "WS", "ML_COMMENT", "SL_COMMENT", 
                  "ANY_OTHER" ]


def get_position_and_item_val(inp : str):
    from itertools import groupby

    ret_val = []

    for k, g in groupby(enumerate(inp), lambda x: not x[1].isspace()):
        if k:
            pos, first_item = next(g)
            item = first_item + ''.join([x for _, x in g])
            ret_val.append([pos, pos + len(item) - 1, item])
    return ret_val

string = "lelelelelelel def oder not def of model"

print(get_position_and_item_val(string))