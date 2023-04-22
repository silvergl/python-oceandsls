/** Grammars always start with a grammar header. This grammar is called
 *  CommonLexerRules and must match the filename: CommonLexerRules.g4
 */
grammar CommonLexerRules;

// lexer rules with uppercase letters
ID      :   [a-zA-Z_0-9]+ ;                                 // added id-characters; before: match identifiers <label id="code.tour.expr.3"/>
NUM     :   '-'? ('.' DIG+ | DIG+ ('.' DIG*)? EXP? ) ;  // match numbers
/** fragments generate no lexer tokens */
fragment INT :   '0' | [1-9] DIG* ;                     // fragment match integers without leading zeros
fragment EXP :   [eE] [+\-]? INT ;                      // fragment match exponent
fragment DIG :   [0-9] ;                                // fragment match digits

//NEWLINE :   '\r'? '\n' ;                                // causes errors: return newlines to parser (is end-statement signal)
WS      :   [ \t\n]+ -> skip ;                            // suppress the generation of the spaces and tabs token
COMMENT : '//' .*? '\n'-> channel(HIDDEN) ;               // hide / ignore comments
