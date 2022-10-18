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

def getChildNodes(node):
	result = []
	for i in ast.iter_child_nodes(node):
		if type(i).__name__ == "Terminal": 
			result.append(i)
		result.append(getChildNodes(i))
	return [ele for ele in result if ele != []]

def writeOutList(lisT):
	#TODO: Fix some cases where the reading out of the ast is broken: i.e. 13+11*15+1
	res = ""
	first_number = True
	for i in range(len(lisT) - 1):
		if isinstance(lisT[i], list):
			res = res + writeOutList(lisT[i])
		else:
			if(first_number):
				res = str(res) + str(lisT[i]) + str(lisT[len(lisT) - 1])
				first_number = False
			else:
				res = str(res) + str(lisT[i])
	return res

NAMES = ["AssignStat"] #TODO: How do we know what we are seaching for?
FILE_PATH = "/home/armin/Dokumente/antlr4/test.testGrammar"
FIRST_GRAMMAR_RULE = "prog"
scope = dictScope.dictScope()
scope.__init__()

with open(FILE_PATH) as file:
	antlr_tree = parse(grammar, file.read(), FIRST_GRAMMAR_RULE)
	simple_tree = process_tree(antlr_tree)
	#prints out the AST in pretty print
	print(astunparse.dump(simple_tree))
	for line in simple_tree:
		astDepth = depth_ast(line)
		prevNodeDepth = astDepth
		for node in ast.walk(line):
			thisNodeDepth = depth_ast(node)
			#TODO: What are we searching for?
			#Block Scope build: global -> funktionVar -> blocks : Means everytime -1 in the depth of the node
			if type(node).__name__ in NAMES:
				if thisNodeDepth >= astDepth - 1:
					#TODO: What do we write inside the disctScope? (Name, Value)
					print("add Global " + type(node).__name__ + " with value: " + str(node))
					for value in ast.iter_fields(node):
						if(value[0] == "ID"):
							node_name = value[1]
						elif(value[0] == "expr"):
							if depth_ast(value[1]) == 1:
								node_value = value[1]
							else:
								res = writeOutList(getChildNodes(value[1]))
								node_value = res
					scope.addFunctionOrGlobalVar(str(node_name), node_value)
				else:
					try:
						node_function, block = find_function(simple_tree,node,thisNodeDepth)
						for value in ast.iter_fields(node):
							if(value[0] == "ID"):
								node_name = value[1]
							elif(value[0] == "expr"):
								node_value = value
						print("Found function: " + node_function + " and add: " + type(node).__name__ + " with value: " + str(node) + " in block " + str(block))
						scope.addLocal(str(node_name),value = node_value , funcI = node_function, block=block)
					except:
						print("Something went wrong, the node " + astunparse.dump(node) + " could not be added to block scope")
	print(scope)