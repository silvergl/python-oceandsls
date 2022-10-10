// Define a grammar called TestGrammar
grammar TestGrammar;

/** Parser rules (start lowercase)*/
expr
    : '(' expr ')'                              # ParenExpr
    | left=expr op=('*'|'/') right=expr         # InfixExpr
    | left=expr op=('+'|'-') right=expr         # InfixExpr
    | atom=INT                                  # NumberExpr
    | atom=FOO                                  # FooExpr
    | atmo=BAR                                  # BarExpr
    ;

/** Tokens (start uppercase)*/
FOO: ('foo'|'foo ');         // match keyword or 'foo '
BAR: ('bar'|' bar');         // match keyword or 'bar '
INT: [0-9]+        ;         // match number identifiers
WS : [ \t\r\n]+ -> skip ;    // skip spaces, tabs, newlines