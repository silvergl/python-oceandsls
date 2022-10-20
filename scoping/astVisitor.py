import string
from antlr_ast.ast import parse, process_tree
import buildpython as grammar
import ast
import astunparse
import dictScope
import itertools

def depth_ast(root):
    return 1 + max(map(depth_ast, ast.iter_child_nodes(root)),
                   default = 0)

#way to compare two ast wich each other
def compare_ast(node1, node2):
    if type(node1) is not type(node2):
        return False
    if isinstance(node1, ast.AST):
        for k, v in vars(node1).iteritems():
            if k in ('lineno', 'col_offset', 'ctx'):
                continue
            if not compare_ast(v, getattr(node2, k)):
                return False
        return True
    elif isinstance(node1, list):
        return all(itertools.starmap(compare_ast, itertools.izip(node1, node2)))
    else:
        return node1 == node2
			
def find_function(root, node, depth):
	last_function = root
	curr_depth = depth_ast(root)
	root_depth = depth
	for nod in ast.walk(root):
		curr_depth = depth_ast(nod)
		if compare_ast(nod, node) and depth == curr_depth:
			block = depth_ast(last_function) - curr_depth
			return (last_function, block) 
		else:
			if curr_depth == root_depth - 1:
				last_function = nod
	raise

#reads out the child notes and export it as a list
def getChildNodes(node):
	result = []
	for i in ast.iter_child_nodes(node):
		if type(i).__name__ == "Terminal": 
			result.append(i)
		result.append(getChildNodes(i))
	return [ele for ele in result if ele != []]

#We assume that only have two values, variables or calculations combined with one Terminal-symbol, like +, which is at the end of the list
def writeOutListAsList(lisT):
	if isinstance(lisT[0], list) and isinstance(lisT[1], list):
		return [writeOutListAsList(lisT[0]), lisT[len(lisT) - 1], writeOutListAsList(lisT[1])]
	elif isinstance(lisT[1], list) and not isinstance(lisT[0], list):
		return [lisT[0], lisT[len(lisT) - 1], writeOutListAsList(lisT[1])]
	elif not isinstance(lisT[1], list) and isinstance(lisT[0], list):
		return [writeOutListAsList(lisT[0]), lisT[len(lisT) - 1], lisT[1]]
	else:
		return [lisT[0], lisT[len(lisT) - 1], lisT[1]]

def writeOutList(lisT):
	if isinstance(lisT[0], list) and isinstance(lisT[1], list):
		return writeOutList(lisT[0]) + str(lisT[len(lisT) - 1]) + writeOutList(lisT[1])
	elif isinstance(lisT[1], list) and not isinstance(lisT[0], list):
		return str(lisT[0]) + str(lisT[len(lisT) - 1]) + writeOutList(lisT[1])
	elif not isinstance(lisT[1], list) and isinstance(lisT[0], list):
		return writeOutList(lisT[0]) + str(lisT[len(lisT) - 1]) + str(lisT[1])
	else:
		return str(lisT[0]) + str(lisT[len(lisT) - 1]) + str(lisT[1])

def createAst(grammar, grammar_input, first_grammar_rule):
	antlr_tree = parse(grammar, grammar_input, first_grammar_rule)
	return process_tree(antlr_tree)

def insertVariablesInScope(grammar, grammar_input : string, first_grammar_rule : string, track_names : list, scope : dictScope = None, id_name : string = "ID", expr_name : string = "expr"):
	if scope is None:
		scope = dictScope.dictScope()
		scope.__init__()
	simple_tree = createAst(grammar, grammar_input, first_grammar_rule)
	for line in simple_tree:
		astDepth = depth_ast(line)
		for node in ast.walk(line):
			thisNodeDepth = depth_ast(node)
			#Block Scope build: global -> funktionVar -> blocks : Means everytime -1 in the depth of the node
			if type(node).__name__ in track_names:
				if thisNodeDepth >= astDepth - 1:
					print("add Global " + type(node).__name__ + " with value: " + str(node))
					for value in ast.iter_fields(node):
						if(value[0] == id_name):
							node_name = value[1]
						elif(value[0] == expr_name):
							if depth_ast(value[1]) == 1:
								node_value = value[1]
							else:
								res = writeOutListAsList(getChildNodes(value[1]))
								node_value = res
					scope.addFunctionOrGlobalVar(str(node_name), node_value)
				else:
					try:
						node_function, block = find_function(simple_tree,node,thisNodeDepth)
						for value in ast.iter_fields(node):
							if(value[0] == id_name):
								node_name = value[1]
							elif(value[0] == expr_name):
								node_value = value
						print("Found function: " + node_function + " and add: " + type(node).__name__ + " with value: " + str(node) + " in block " + str(block))
						scope.addLocal(str(node_name),value = node_value , funcI = node_function, block = block)
					except:
						print("Something went wrong, the node " + astunparse.dump(node) + " could not be added to block scope")
	return scope

NAMES = ["AssignStat"] #TODO: How do we know what we are seaching for?
FILE_PATH = "/home/armin/Dokumente/antlr4/test.testGrammar"
FIRST_GRAMMAR_RULE = "prog"
ID_NAME = "ID"
EXPR_NAME = "expr"
scope = dictScope.dictScope()
scope.__init__()

with open(FILE_PATH) as file:
	print(insertVariablesInScope(grammar,file.read(),FIRST_GRAMMAR_RULE,NAMES,scope))