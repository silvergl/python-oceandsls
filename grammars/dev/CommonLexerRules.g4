/** Grammars always start with a grammar header. This grammar is called
 *  CommonLexerRules and must match the filename: CommonLexerRules.g4
 */
grammar CommonLexerRules;

// lexer rules with uppercase letters
ID  :   [a-zA-Z]+ ;      // match identifiers <label id="code.tour.expr.3"/>
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace