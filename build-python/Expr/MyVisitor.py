__author__ = 'sgu'

if __name__ is not None and "." in __name__:
    from .ExprVisitor import ExprVisitor
    from .ExprParser import ExprParser
else:
    from ExprVisitor import ExprVisitor
    from ExprParser import ExprParser



class MyVisitor(ExprVisitor):
    def __init__(self):
        self.memory = {}                # initialize  internal memory

    def visitAssign(self, ctx):
        name = ctx.ID().getText()       # id is left-hand side of '='
        value = self.visit(ctx.expr())  # compute value of expression on right
        self.memory[name] = value       # store it in memory
        return value

    def visitPrintExpr(self, ctx):
        value = self.visit(ctx.expr())  # evaluate the expr child
        print(value)                    # print the result
        return 0                        # return dummy value

    def visitInt(self, ctx):
        return ctx.INT().getText()      # INT is Token with right-hand value

    def visitId(self, ctx):
        name = ctx.ID().getText()       # ID is Token with right-hand value
        if name in self.memory:         # find in memory
            return self.memory[name]    # return stored value
        return 0

    def visitMulDiv(self, ctx):
        left = int(self.visit(ctx.expr(0)))     # get value of left subexpression
        right = int(self.visit(ctx.expr(1)))    # get value of right subexpression
        if ctx.op.type == ExprParser.MUL:       # evaluate expr based on Token Type of op
            return left * right
        return left / right

    def visitAddSub(self, ctx):
        left = int(self.visit(ctx.expr(0)))     # get value of left subexpression
        right = int(self.visit(ctx.expr(1)))    # get value of right subexpression
        if ctx.op.type == ExprParser.ADD:       # evaluate expr based on Token Type of op
            return left + right
        return left - right

    def visitParens(self, ctx):
        return self.visit(ctx.expr())           # return child's expression value
