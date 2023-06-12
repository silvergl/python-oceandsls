/*******************************************************************************
 * TODO License

 Grammars always start with a grammar header. This grammer is called Configuration
 and must match the filename: Configuration.g4
 *******************************************************************************/
grammar Configuration; //
import Expression;   // include all rules from Expression.g4

//TODO generate Metamodel PyCore

//TODO add DeclarationModel reference for declaration = ID
configurationModel          :   'configuration' name=ID ':' declarationModel=ID
                                includes+=include*
                                ('activate' featureActivations+=featureActivation (',' featureActivations+=featureActivation)*)?
                                (parameterGroups+=parameterGroup|featureConfigurations+=featureConfiguration)*
                            ;


include                     :   'include' importedNamespace = QualifiedName #includeDecl;

//TODO deactivated? set deactivated to true if '!' else to false
//TODO add FeatureDeclaration reference for declaration = ID
featureActivation           :   (deactivated='!')?
                                declaration=ID
                            #featureActivate
                            ;

//TODO add FeatureDeclaration reference for declaration = ID
featureConfiguration        :   'feature' declaration=ID '{'
                                ('activate' featureActivations+=featureActivation (',' featureActivations+=featureActivation)*)?
                                (parameterGroups+=parameterGroup|featureConfigurations+=featureConfiguration)*
                                '}'
                            #featureConfig
                            ;

// Generic parameter group setup
//TODO add ParameterGroupDeclaration reference for declaration = ID
parameterGroup              :   'group' declaration=ID '{'
                                (parameters+=parameterAssignment)*
                                '}'
                            #paramGroup
                            ;

//TODO add ParameterDeclaration reference for declaration = QualifiedName
parameterAssignment         :   declaration= QualifiedName ('[' selectors+=selector (',' selectors+=selector)*  ']')? ':' value=arithmeticExpression (unit=unitSpecification)? 
                            #parameterAssign
                            ;

selector                    :   elementSelector | rangeSelector;
elementSelector             :   element=ELONG;
rangeSelector               :   lowerBound=ELONG ':' upperBound=ELONG;

unitSpecification                        : unit=ID
                            #unitSpec
                            ;

/** Lexer rules (start uppercase)*/

ID                          : ( [a-zA-Z] | '_') ( [a-zA-Z] | '_' | [0-9] | '^' | '-' | '*' | '/' )* ; // override identifiers

QualifiedName               : ID ('.' ID)* ;
