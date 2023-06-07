/*******************************************************************************
 * TODO License

 Grammars always start with a grammar header. This grammer is called Terminals
 and must match the filename: Terminals.g4
 *******************************************************************************/
lexer grammar Terminals;    // note "lexer grammar"

//TODO generate Metamodel PyCore

/** Lexer rules (start uppercase)*/
ID          : '^'? ( [a-zA-Z] | '_' ) ( [a-zA-Z] | '_' | [0-9] )* ; // match identifiers
// TODO ecore::EInt
INT         : [0-9]+ ;                                              // define token INT as one or more digits

STRING      : '"' ( '\\' . /* 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' */
            | ~('\\'|'"') )* '"'
            | '\'' ( '\\' . /* 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' */
            | ~('\\'|'\'') )* '\''
            ;

WS      : [ \r\t\n]+ -> skip ;                              // skip whitespaces, carriage returns, tabs and newlines
// -----------------------------------------------------------------------
// ANTLR p.281 lexical modes are only allowed in lexer. Not in combined grammars via import
// -----------------------------------------------------------------------
/*
LQUOTE  : '"'   -> more, mode(STR) ;

mode STR;

STRING  : '"'   -> mode(DEFAULT_MODE) ; // token we want the parser to see
TEXT    : .     -> more ;               // collect more text for string
*/
// -----------------------------------------------------------------------

ML_COMMENT  :  '/*' .*? '*/' -> skip ;  // .*? matches anything until the first */
SL_COMMENT  :  '//' ~[\r|\n]* [\r?\n]? -> skip ;    // skip single line comments optional end with beginning of the next line

// TODO check necessity
ANY_OTHER   : . ;
