from asyncio.windows_events import NULL
from antlr_ast.ast import parse, process_tree
import buildpython as grammar
import ast
import astunparse
import dictscope

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

NAMES = [] #TODO: How do we know what we are seaching for?
FILE_PATH = "/home/armin/Dokumente/antlr4/python-stack-ast/test.graph"
FIRST_GRAMMAR_RULE = "compileUnit"
scope = dictScope.dictScope()
scope.__init__()

with open(FILE_PATH) as file:
	antlr_tree = parse(grammar, file.read(), FIRST_GRAMMAR_RULE)
	simple_tree = process_tree(antlr_tree)
	simple_tree = ast.fix_missing_locations(simple_tree)
	#prints out the AST in pretty print
	print(astunparse.dump(simple_tree))
	astDepth = depth_ast(simple_tree)
	prevNodeDepth = astDepth
	for node in ast.walk(simple_tree):
		thisNodeDepth = depth_ast(node)
		#TODO: What are we searching for?
		#Block Scope build: global -> funktionVar -> blocks : Means everytime -1 in the depth of the node
		if type(node).__name__ in NAMES:
			if thisNodeDepth >= astDepth - 1:
				#TODO: What do we write inside the disctScope? (Name, Value)
				scope.addFunctionOrGlobalVar(type(node).__name__, node)
			else:
				try:
					node_function, block = find_function(simple_tree,node,thisNodeDepth)
					scope.addLocal(type(node).__name__,value = node , funcI = node_function, block=block)
				except:
					print("Something went wrong, the node " + astunparse.dump(node) + " could not be added to block scope")
		if type(node).__name__ == "Terminal":
			print("Value of Terminal: " + str(node))
		prevNodeDepth = thisNodeDepth