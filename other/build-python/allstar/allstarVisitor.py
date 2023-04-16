# Generated from allstar.g4 by ANTLR 4.11.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .allstarParser import allstarParser
else:
    from allstarParser import allstarParser

# This class defines a complete generic visitor for a parse tree produced by allstarParser.

class allstarVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by allstarParser#stat.
    def visitStat(self, ctx:allstarParser.StatContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by allstarParser#expr.
    def visitExpr(self, ctx:allstarParser.ExprContext):
        return self.visitChildren(ctx)



del allstarParser