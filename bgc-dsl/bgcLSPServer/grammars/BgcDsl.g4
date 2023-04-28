grammar BgcDsl;

import CommonLexerRules;

bgcModel:
	'model' name=ID
	'substances' substanceDeclarations+=substanceDeclaration+
	('parameters' parameterDeclarations+=parameterDeclaration*)?
	('diagnostics' environments+=environmentVariableDeclaration*)?
	(compartments+=compartment|connections+=connection)+
;

substanceDeclaration:
	type=primitiveTypes name=ID unit
;

parameterDeclaration:
	type=primitiveTypes name=ID unit '=' expression=arithmeticExpression
;

environmentVariableDeclaration:
	type=primitiveTypes name=ID unit ('=' expression=arithmeticExpression)?
;

primitiveTypes:
	'int' | 'float' | 'string'
;

// type of label "parent": compartment
compartment:
	'abstract'? 'compartment' name=ID ('extends' parent = ID)? '{'
		'states' states+=substanceState+
		('parameters' constants+=parameterDeclaration*)?
		('diagnostics' evnironments+=environmentVariableDeclaration*)?

		calculations+=calculation*
		updateStates+=updateState+
	'}'
;

// substance type: substanceDeclaration
substanceState:
	substance=ID ('=' expression=arithmeticExpression)?
;

// state is of type substanceState
updateState:
    'update' state=ID '=' expression=arithmeticExpression
;

// sourceCompartment and targetCompartment are of type compartment
// substances and substance are of type substanceDeclaration
connection:
	'connection' name=ID ('(' substances+=ID (',' substances+=ID)* ')')?
	'from' sourceCompartment=ID 'to' targetCompartment=ID ('=' expression=arithmeticExpression |
	'{' (substanceExpressions+=substanceExpression | calculations+=calculation)* '}')
;

substanceExpression:
	substance=ID '=' expression=arithmeticExpression
;

calculation: basicCalculation | alternativeCalculation;

basicCalculation:
	'calc' name=ID '=' expression=arithmeticExpression
;

alternativeCalculation:
	'alternatives' name=ID ':' expression=arithmeticExpression '{'
		alternatives+=basicCalculation*
	'}'
;

// ----------------------
// Units
// ----------------------

unit:
	':' elements+=unitElement+ |
	'::'
;

unitElement:
	prefixUnit | groupUnit
;

groupUnit:
	'(' elements+=unitElement* ')' ('^' exponent=NUMBER)?
;

// substance is of type substanceDeclaration
// removed unit-label for UNIT_STRING, here
prefixUnit:
	(UNIT_STRING | custom=CUSTOM_STRING) (substance=ID)? ('^' exponent=NUMBER)?
;

// ----------------------
// Expression definitions
// ----------------------

// returns expression
arithmeticExpression:
	multiplicationExpression (operator=eAdditionOperator right=arithmeticExpression)?
;

// returns eAdditionOperator
eAdditionOperator:
	ADDITION = '+' |
	SUBTRACTION = '-'
;

// returns expression
multiplicationExpression:
	powerExpression (operator=eMultiplicationOperator right=multiplicationExpression)?
;

// returns eMultiplicationOperator
eMultiplicationOperator:
	MULTIPLICATION = '*' |
	DIVISION = '/' |
	MODULO = '%'
;

// returns expression
powerExpression:
	valueExpression ('^' right=valueExpression)?
;


valueExpression:
	arrayExpression |
	functionCallingExpression |
	literalExpression |
	parenthesisExpression |
	termReference
;


arrayExpression:
	'[' expressions+=arithmeticExpression (',' expressions+=arithmeticExpression)* ']'
;

functionCallingExpression: type=function '(' expressions+= arithmeticExpression (',' expressions+= arithmeticExpression)* ')';

function:
	'exp' | 'inverse' | 'max'
;

literalExpression:
	value=literal
;

literal:
	numberLiteral |
	stringLiteral
;

numberLiteral:
	value=NUMBER
;

stringLiteral:
	value='string'
;

// returns ecore::EBigDecimal
// changed pre-dot numbers from * to +
NUMBER:
	('-')? ('0'..'9')+ ('.' ('0'..'9')+)?
;

// returns ecore::EString
CUSTOM_STRING:
	'#'('A' .. 'Z'|'a'..'z')+
;

// returns ecore::EString
UNIT_STRING:
	('Q'|'R'|'Y'|'Z'|'E'|'P'|'T'|'G'|'M'|'k'|'h'|'da'|'d'|'c'|'m'|'my'|'n'|'p'|'f'|'a'|'z'|'y'|'r'|'q')?('s'|'m'|'g'|'mol'|'cd'|'W'|'J'|'K'|'A')
;

parenthesisExpression:
	'(' expression=arithmeticExpression ')'
;

// sourceCompartment and targetCompartment are of type compartment
// reference is of type term
termReference:
	(sourceCompartment=ID '>')?  (targetCompartment=ID ':')? reference=qualifiedName
;

// should be moved to documentation
subterm:
	updateState | connection | parameterDeclaration | calculation | environmentVariableDeclaration | substanceExpression | substanceState
;

qualifiedName:
	ID ('.' ID)*
;

// returns ecore::EInt
INT:
	'this one has been deactivated'
;
