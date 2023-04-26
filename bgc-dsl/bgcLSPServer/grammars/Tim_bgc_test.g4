// das ist eine versuchs-grammatik.

grammar Tim_bgc_test;	// grammar name

// regeln

regel1: ding*
      ;	// regeln müssen klein sein

ding: '#' regel1
    | INT
    | CHAR
    ;	// hier muss '#' oder was anderes stehen, sonst gibts n problem mit left recursive.


// Token

INT:  [0-9]+;	// muss hier def werden; keine Ahnung warum das außerhalb muss
CHAR: [a-z]+;

Ignore: [ \n]+ -> skip;	// ignores spaces (here is one explicit space char) and next lines