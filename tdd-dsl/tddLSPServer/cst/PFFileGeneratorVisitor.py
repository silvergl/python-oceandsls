'''FileGeneratorVisitor module for pFunit pf files.'''

# util
import os
from typing import Dict, List, Tuple

# jinja2
from jinja2 import Environment, FileSystemLoader

# user relative imports
from ..fileWriter.fileWriter import write_file
from ..gen.python.TestSuite.TestSuiteParser import TestSuiteParser
from ..gen.python.TestSuite.TestSuiteVisitor import TestSuiteVisitor


class PFFileGeneratorVisitor( TestSuiteVisitor ):
    fileTemplates: Dict[ int, str ]
    templatePath: str
    testPath: str
    testFolder: str
    testFilePredicate: str
    environment: Environment

    # TODO hc
    def __init__( self, templatePath: str = 'tdd-dsl/tddLSPServer/fileWriter/jinja-templates/pf', files: dict[ str, Tuple[ float, str, str ] ] = {}, testWorkPath: str = 'tdd-dsl/output', testFolder: str = 'tests' ):
        '''
        pfUnit test file generator. Builds template file dictionary from TestSuiteParser.ruleNames.

        Write/merge pFUnit-file to :test_path:/:test_folder:/:filename:.pf

        :param templatePath: relative filepath for jinja templates
        :param testWorkPath: relative path to generate test suite
        :param testFolder: relative path under :testWorkPath: to save pfUnit tests
        '''
        super( ).__init__( )
        self.files: dict[ str, Tuple[ float, str, str ] ] = files
        self.templatePath = templatePath
        self.testPath = testWorkPath
        # TODO add test directory option
        self.testFolder = testFolder
        # Load Jinja2 templates
        self.environment = Environment( loader = FileSystemLoader( templatePath ) )

        # variable flags
        self.foundRef: bool = False
        self.foundPar: bool = False

        self.fileTemplates = {}
        # Get template file names from grammar
        i: int = 0
        for rule in TestSuiteParser.ruleNames:
            self.fileTemplates[ i ] = f'{rule}_template.txt'
            i += 1

    # Visit a parse tree produced by TestSuiteParser#test_case.
    def visitTest_case( self, ctx: TestSuiteParser.Test_caseContext ) -> dict[ str, Tuple[ float, str, str ] ]:
        # Load Jinja2 template
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        # Render template
        name = ctx.name.text
        scope = self.visit( ctx.scope )
        vars_ = self.visit( ctx.vars_ )
        self.testPath = self.visit( ctx.src_path( ) )
        assertions = [ ]
        for assertion in ctx.assertions:
            assertions.append( self.visit( assertion ) )
        content = template.render( name = name, scope = scope, vars_ = vars_, assertions = assertions )

        absPath: str = os.path.join( os.getcwd( ), self.testPath, self.testFolder, name, )
        fileAttr = self.files.get( absPath )
        if fileAttr:
            self.files[ absPath ] = write_file( self.testPath, self.testFolder, name, content, fileAttr)
        else:
            self.files[ absPath ] = write_file( self.testPath, self.testFolder, name, content)

        # TODO find test cases in children?
        self.visitChildren( ctx )
        return self.files

    # Visit a parse tree produced by TestSuiteParser#src_path.
    def visitSrc_path( self, ctx: TestSuiteParser.Src_pathContext ):
        # Strip string terminals
        # TODO document
        # If the given path is an absolute path, then self.testPath is ignored and the joining is only the given path
        return os.path.join( self.testPath, ctx.path.text.strip( '\'' ) )

    # Visit a parse tree produced by TestSuiteParser#test_scope.
    def visitTest_scope( self, ctx: TestSuiteParser.Test_scopeContext ):
        # get explicitly only used modules. Path to modules is only for src analysis
        return self.visit( ctx.use_modules( ) )

    # Get rendered list of used modules
    def visitUse_modules( self, ctx: TestSuiteParser.Use_modulesContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        return template.render( modules = ctx.modules )

    # Visit a parse tree produced by TestSuiteParser#test_vars.
    def visitTest_vars( self, ctx: TestSuiteParser.Test_varsContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )

        parm = [ ]
        decl = [ ]
        vars = [ ]
        for var in ctx.vars_:
            templates: List[ str ] = self.visit( var )
            # Is the variable initialized with a reference?
            match (self.foundPar, self.foundRef):
                case [ True, _ ]:
                    # Add parameter to top of declaration
                    parm.append( templates[ 0 ] )
                case [ _, False ]:
                    # Append declaration with constant expression as normal
                    vars.append( templates[ 0 ] )
                case [ False, True ]:
                    # Split declaration and initialization separately
                    vars.append( templates[ 0 ] )
                    decl.append( templates[ 1 ] )

                    # Reset found flags
                    self.foundRef = False
                    self.foundPar = False
                case _:
                    # TODO error
                    pass

        # set declaration list to None if empty
        # decl = decl if decl else None

        return template.render( parm = parm, decl = decl, vars = vars )

    # Visit a parse tree produced by TestSuiteParser#test_vars.
    def visitTest_var( self, ctx: TestSuiteParser.Test_varContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        comment = self.visit( ctx.optionalDesc( ) )

        # reset foundPar flag for left side
        self.foundPar = False
        decl = self.visit( ctx.varDeclaration( ) )
        name = ctx.decl.name.text

        self.foundRef = False
        # reset foundRef flag for right side
        value = self.visit( ctx.expr( ) )

        templates: List[ str ] = [ ]

        # TODO deprecated
        # if self.foundRef:
        #     templates.extend( [ decl, template.render( decl = None, name = name, value = value, comment = comment ) ] )
        # else:
        #     templates.extend( [ None, template.render( decl = decl, name = None, value = value, comment = comment ) ] )

        match (self.foundPar, self.foundRef):
            case [ True, _ ] | [ _, False ]:
                # TODO put parameters at the top
                # Found Parameter no reference on right side: Add declaration with constant expression
                templates.extend( [ template.render( decl = decl, name = None, value = value, comment = comment ), None ] )
            case [ False, True ]:
                # Found reference on right side: Separate declaration and initialization
                templates.extend( [ template.render( decl = None, name = name, value = value, comment = comment ), decl ] )
            case _:
                # TODO error
                pass

        return templates

    # Visit a parse tree produced by TestSuiteParser#varDeclaration.
    def visitVarDeclaration( self, ctx: TestSuiteParser.VarDeclarationContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        name = ctx.ID( ).getText( )
        type = self.visit( ctx.type_ )
        keys = [ ]
        for key in ctx.keys:
            # TODO check for parameter
            keyText: str = key.keyword.text
            # flag parameter
            if keyText.lower( ) == 'parameter':
                self.foundPar = True
            keys.append( keyText )
        # match keys:
        #     case []:
        #         return template.render( name=name, type=type )
        #     case _:
        #         return template.render( name=name, type=type, keys=keys )

        return template.render( name = name, type = type, keys = keys )

        # if keys:
        #     return template.render( name = name, type = type, keys = keys )
        # else:
        #     return template.render( name = name, type = type )

    # Visit a parse tree produced by TestSuiteParser#funRef.
    def visitFunRef( self, ctx: TestSuiteParser.FunRefContext ):
        self.foundRef = True
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        name = ctx.ID( ).getText( )
        args = [ ]
        for arg in ctx.args:
            args.append( self.visit( arg ) )
        return template.render( name = name, args = args )

    # Visit a parse tree produced by TestSuiteParser#varRef.
    def visitVarRef( self, ctx: TestSuiteParser.VarRefContext ):
        self.foundRef = True
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        name = ctx.ID( ).getText( )
        return template.render( name = name )

    # Visit a parse tree produced by TestSuiteParser#enm.
    def visitEnm( self, ctx: TestSuiteParser.EnmContext ):
        # TODO type ENUM
        return self.visitChildren( ctx )

    # Visit a parse tree produced by TestSuiteParser#array.
    def visitArray( self, ctx: TestSuiteParser.ArrayContext ):
        # TODO type ARRAY
        return self.visitChildren( ctx )

    # Visit a parse tree produced by TestSuiteParser#parensExpr.
    def visitParensExpr( self, ctx: TestSuiteParser.ParensExprContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        inner = self.visit( ctx.inner )
        return template.render( inner = inner )

    # Visit a parse tree produced by TestSuiteParser#mulDivExpr.
    def visitMulDivExpr( self, ctx: TestSuiteParser.MulDivExprContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        left = self.visit( ctx.left )
        right = self.visit( ctx.right )
        op = ctx.op.text
        return template.render( left = left, right = right, op = op )

    # Visit a parse tree produced by TestSuiteParser#addSubExpr.
    def visitAddSubExpr( self, ctx: TestSuiteParser.AddSubExprContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        left = self.visit( ctx.left )
        right = self.visit( ctx.right )
        op = ctx.op.text
        return template.render( left = left, right = right, op = op )

    # Visit a parse tree produced by TestSuiteParser#signExpr.
    def visitSignExpr( self, ctx: TestSuiteParser.SignExprContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        inner = self.visit( ctx.inner )
        op = ctx.op.text
        return template.render( inner = inner, op = op )

    # Visit a parse tree produced by TestSuiteParser#numberExpr.
    def visitNumberExpr( self, ctx: TestSuiteParser.NumberExprContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        value = ctx.value.text
        return template.render( value = value )

    # Visit a parse tree produced by TestSuiteParser#strExpr.
    def visitStrExpr( self, ctx: TestSuiteParser.StrExprContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        value = ctx.value.text
        return template.render( value = value )

    # Visit a parse tree produced by TestSuiteParser#intExpr.
    def visitIntExpr( self, ctx: TestSuiteParser.IntExprContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        value = ctx.value.text
        return template.render( value = value )

    # Visit a parse tree produced by TestSuiteParser#refExpr.
    def visitRefExpr( self, ctx: TestSuiteParser.RefExprContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        value = self.visit( ctx.value )
        return template.render( value = value )

    # Visit a parse tree produced by TestSuiteParser#emptyDesc.
    def visitEmptyDesc( self, ctx: TestSuiteParser.EmptyDescContext ):
        return None

    # Visit a parse tree produced by TestSuiteParser#specDesc.
    def visitSpecDesc( self, ctx: TestSuiteParser.SpecDescContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        type = self.visit( ctx.value )
        comment = self.visit( ctx.value )
        return template.render( type = type, comment = comment )

    # Visit a parse tree produced by TestSuiteParser#emptyComment.
    def visitEmptyComment( self, ctx: TestSuiteParser.EmptyCommentContext ):
        return None

    # Visit a parse tree produced by TestSuiteParser#specComment.
    def visitSpecComment( self, ctx: TestSuiteParser.SpecCommentContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        comment = ctx.comment.text
        return template.render( comment = comment )

    # Visit a parse tree produced by TestSuiteParser#test_assertion.
    def visitTest_assertion( self, ctx: TestSuiteParser.Test_assertionContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        directive = self.visit( ctx.directive )
        input_ = self.visit( ctx.input_ )
        output = self.visit( ctx.output )
        pubAttributes = self.visit( ctx.attr )
        comment = ctx.comment.text.rstrip( '\n' ) if ctx.comment is not None else None
        match (pubAttributes, comment):
            case [ None, None ]:
                return template.render( directive = directive, input_ = input_, output = output )
            case [ None, _ ]:
                return template.render( directive = directive, input_ = input_, output = output, comment = comment )
            case [ _, None ]:
                return template.render( directive = directive, input_ = input_, output = output, pubAttributes = pubAttributes )
            case _:
                return template.render( directive = directive, input_ = input_, output = output, pubAttributes = pubAttributes, comment = comment )

    # Visit a parse tree produced by TestSuiteParser#test_directive.
    def visitTest_directive( self, ctx: TestSuiteParser.Test_directiveContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        ppDirective = ctx.ppDirective.text
        return template.render( ppDirective = ppDirective )

    # Visit a parse tree produced by TestSuiteParser#test_parameter.
    def visitTest_parameter( self, ctx: TestSuiteParser.Test_parameterContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        # TODO use decl and comment in upper template
        value = self.visit( ctx.value )
        return template.render( value = value )

    # Visit a parse tree produced by TestSuiteParser#pubAttributes.
    def visitPubAttributes( self, ctx: TestSuiteParser.PubAttributesContext ):
        template = self.environment.get_template( self.fileTemplates[ ctx.getRuleIndex( ) ] )
        msg = ctx.msg.text if ctx.msg is not None else None
        tol = self.visit( ctx.tol ) if ctx.tol is not None else None
        match (msg, tol):
            case [ None, None ]:
                return None
            case [ None, _ ]:
                return template.render( tol = tol )
            case [ _, None ]:
                return template.render( msg = msg )
            case _:
                return template.render( msg = msg, tol = tol )

    def writefile( self, path = None, filename = None ):
        path = os.path.join( os.getcwd( ), path, filename )
        if not os.path.exists( path ):
            # Write rendered and optional merged content to file
            with open( path, mode = 'w', encoding = 'utf-8' ) as f:
                f.write( )
                # TODO add to debug info
                print( f'... wrote {path}' )
