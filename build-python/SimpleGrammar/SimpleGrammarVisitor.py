# Generated from C:/Users/Sven/workspace/python/antlr4-python/grammars/dev\SimpleGrammar.g4 by ANTLR 4.11.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .SimpleGrammarParser import SimpleGrammarParser
else:
    from SimpleGrammarParser import SimpleGrammarParser

# This class defines a complete generic visitor for a parse tree produced by SimpleGrammarParser.

class SimpleGrammarVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by SimpleGrammarParser#startProg.
    def visitStartProg(self, ctx:SimpleGrammarParser.StartProgContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimpleGrammarParser#statLabel.
    def visitStatLabel(self, ctx:SimpleGrammarParser.StatLabelContext):
        return self.visitChildren(ctx)



del SimpleGrammarParser