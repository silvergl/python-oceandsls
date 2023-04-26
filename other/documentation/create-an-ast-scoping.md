# python-stack-ast
A Repo to create an ast outta Antlr4 Gramma

#### Test Grammar

```antlr4
grammar Math;

compileUnit
    :   expr EOF
    ;

expr
    :   '(' expr ')'                         # parensExpr
    |   op=('+'|'-') expr                    # unaryExpr
    |   left=expr op=('*'|'/') right=expr    # infixExpr
    |   left=expr op=('+'|'-') right=expr    # infixExpr
    |   func=ID '(' expr ')'                 # funcExpr
    |   value=NUM                            # numberExpr
    ;

OP_ADD: '+';
OP_SUB: '-';
OP_MUL: '*';
OP_DIV: '/';

NUM :   [0-9]+ ('.' [0-9]+)? ([eE] [+-]? [0-9]+)?;
ID  :   [a-zA-Z]+;
WS  :   [ \t\r\n] -> channel(HIDDEN);
```

#### Create an AST

1. parse the grammar with `antlr4` i.e. into `buildpython`

2. install `antlr_ast` with `pip`

3. create an `__init__.py` file:

   1. ```
      from .NameLexer import NameLexer as Lexer
      from .NameParser import NameParser as Parser
      from .NameVisitor import NameVisitor as Visitor
      ```

4. run the `astVisitor` with your given global Parameters (view Code)
5. The visitor will print all current Values in the AST

#### TODO

- (finished) Search for Values in AST
- (finished) how we know the scope of nodes?
- Where do we know what to search for?
- How do we combine it with the python-block-scope by me?
