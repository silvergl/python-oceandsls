from antlr_ast.ast import parse, process_tree
import buildpython as grammar
import ast
import astunparse
import dictScope

def depth_ast(root):
    return 1 + max(map(depth_ast, ast.iter_child_nodes(root)),
                   default = 0)
			
def find_function(root, node, depth):
	last_function = root
	curr_depth = depth_ast(root)
	root_depth = depth
	for nod in ast.walk(root):
		curr_depth = depth_ast(nod)
		if nod == node and depth == curr_depth:
			block = depth_ast(last_function) - curr_depth
			return (last_function, block) 
		else:
			if curr_depth == root_depth - 1:
				last_function = nod
	raise

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
							node_value = value
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
						scope.addLocal(node_name,value = node_value , funcI = node_function, block=block)
					except:
						print("Something went wrong, the node " + astunparse.dump(node) + " could not be added to block scope")
	print(scope)