# Code Generation

The CP-DSL comprises a declaration, a configuration and a template DSL.
The declaration DSL declares features, parameter groups, parameters, default 
values for parameters and dependencies between features. The default values
can use expressions to compute their values, which is helpful when parameters
depend on each other. The configuration DSL allows to select features and
assign values to parameters. Here, defaults can be replaced by actual
assignments.
To provide the template DSL with an easy-to-access data model, we compute an
interim model containing all resolved values and type descriptors. The
current implementation uses X stages to compose the interim model and generate
template output.

Initially, we create a model containing all parameters groups, parameters and
features. The latter all in a deactivated state. Then the parameters get their 
assigned default expressions or values. This is necessary, as the expression 
might need (re-)evaluation after configuration values have been assigned.
In case there are circular references between parameters, the declaration DSL
editor would have reported them.

Secondly, the configuration is applied to the interim model. Here,
parameter become their configured values or expressions. These can also include
references to other parameters, and this may also cause circular dependencies.
The generator checks this and reports an error if circular dependencies are found.

Thirdly, the expressions for each parameter are evaluated and only the resulting
value is stored in the interim model.

Fourthly, all templates related to the declaration model are processed based on
the interim model.

# Interim Model

InterimModel

- name : String // experiment name from the configuration model
- declaration : DeclarationModel 
- parameterGroups : ParameterGroup[]
- features : Feature[]

ParameterGroup

- name : String
- declaration : ParameterGroupDeclaration
- parameters : Parameter[]

Feature

- name : String
- parameterGroups : ParameterGroup[]
- features : Feature[]
- declaration : FeatureDeclaration
- active : Boolean

Parameter

- name : String
- declaration : ParameterDeclaration
- computedValue: ValueContainer
- dataEntries : ParameterEntry
- specifiedType : TypeAssignment // type including the restrictions due to
                                    the selector used in the configuration. This
                                    is used to support the type cast during
                                    computation of the value for the parameter

ParameterEntry

- expression : Expression
- selectors : Selector

ValueContainer (generic type)
+ ScalarValue
+ ArrayValue

ScalarValue
- value : Value

ArrayValue

- values : IndexToValueContainerMap
- lowerBound : long
- upperBound : long

IndexToValueContainerMap

- key : long
- value : ValueContainer

# Processing Declaration Model

- InterimModel is created and the back reference (DeclarationModel) is set
- for each ParameterGroupDeclaration a interim:ParameterGroup is created and
  the back reference (ParameterGroupDeclaration) is set.
- for each Parameter in each ParameterGroupDeclaration a corresponding entry
  is created and linked back
- the same applies to all Features

Each interim::Parameter will have set 
- name
- declaration
- dataEntries (one entry from the Declaration model)
- specifiedType (??)

# Processing Configuration Model

- Walk over the InterimModel and 
  - add parameter values from the configuration and add them to dataEntries
  - activate and deactivate features
  
# Computing Values in the Interim Model

In this task, all value expression must be computed. This is done for each
parameter.





  
