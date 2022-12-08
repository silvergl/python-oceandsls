# Generated from allstar.g4 by ANTLR 4.11.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .allstarParser import allstarParser
else:
    from allstarParser import allstarParser

# This class defines a complete listener for a parse tree produced by allstarParser.
class allstarListener(ParseTreeListener):

    # Enter a parse tree produced by allstarParser#stat.
    def enterStat(self, ctx:allstarParser.StatContext):
        pass

    # Exit a parse tree produced by allstarParser#stat.
    def exitStat(self, ctx:allstarParser.StatContext):
        pass


    # Enter a parse tree produced by allstarParser#expr.
    def enterExpr(self, ctx:allstarParser.ExprContext):
        pass

    # Exit a parse tree produced by allstarParser#expr.
    def exitExpr(self, ctx:allstarParser.ExprContext):
        pass



del allstarParser