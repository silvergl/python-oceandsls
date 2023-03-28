// Generated from TestDrivenDev_DSL.g4 by ANTLR 4.12.0
package TestDrivenDev_DSL;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TestDrivenDev_DSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, ID=27, SEMICOLON=28, OP_ASS=29, OP_MUL=30, OP_DIV=31, 
		OP_ADD=32, OP_SUB=33, PAR_L=34, PAR_R=35, STRING=36, COMMENT=37, INT=38, 
		NUM=39, TDD_COMMENT=40, NEWLINE=41, WS=42;
	public static final int
		RULE_test_suite = 0, RULE_test_case = 1, RULE_test_assertion = 2, RULE_test_input = 3, 
		RULE_test_output = 4, RULE_param = 5, RULE_expr = 6, RULE_directive = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"test_suite", "test_case", "test_assertion", "test_input", "test_output", 
			"param", "expr", "directive"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'test'", "':'", "'in'", "'out'", "'Equal'", "'True'", "'EqualUserDefined'", 
			"'False'", "'LessThan'", "'LessThanOrEqual'", "'GreaterThan'", "'GreaterThanOrEqual'", 
			"'IsMemberOf'", "'Contains'", "'Any'", "'All'", "'NotAll'", "'None'", 
			"'IsPermutationOf'", "'ExceptionRaised'", "'SameShape'", "'IsNaN'", "'IsFinite'", 
			"'Associated'", "'NotAssociated'", "'Equivalent'", null, "';'", "'='", 
			"'*'", "'/'", "'+'", "'-'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "ID", "SEMICOLON", "OP_ASS", "OP_MUL", "OP_DIV", "OP_ADD", 
			"OP_SUB", "PAR_L", "PAR_R", "STRING", "COMMENT", "INT", "NUM", "TDD_COMMENT", 
			"NEWLINE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "TestDrivenDev_DSL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TestDrivenDev_DSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Test_suiteContext extends ParserRuleContext {
		public Test_caseContext test_case;
		public List<Test_caseContext> test_cases = new ArrayList<Test_caseContext>();
		public List<Test_caseContext> test_case() {
			return getRuleContexts(Test_caseContext.class);
		}
		public Test_caseContext test_case(int i) {
			return getRuleContext(Test_caseContext.class,i);
		}
		public TerminalNode NEWLINE() { return getToken(TestDrivenDev_DSLParser.NEWLINE, 0); }
		public Test_suiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_suite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).enterTest_suite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).exitTest_suite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestDrivenDev_DSLVisitor ) return ((TestDrivenDev_DSLVisitor<? extends T>)visitor).visitTest_suite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Test_suiteContext test_suite() throws RecognitionException {
		Test_suiteContext _localctx = new Test_suiteContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_test_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			((Test_suiteContext)_localctx).test_case = test_case();
			((Test_suiteContext)_localctx).test_cases.add(((Test_suiteContext)_localctx).test_case);
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(17);
				match(NEWLINE);
				setState(18);
				((Test_suiteContext)_localctx).test_case = test_case();
				((Test_suiteContext)_localctx).test_cases.add(((Test_suiteContext)_localctx).test_case);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Test_caseContext extends ParserRuleContext {
		public Test_assertionContext test_assertion;
		public List<Test_assertionContext> assertions = new ArrayList<Test_assertionContext>();
		public TerminalNode ID() { return getToken(TestDrivenDev_DSLParser.ID, 0); }
		public List<Test_assertionContext> test_assertion() {
			return getRuleContexts(Test_assertionContext.class);
		}
		public Test_assertionContext test_assertion(int i) {
			return getRuleContext(Test_assertionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(TestDrivenDev_DSLParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TestDrivenDev_DSLParser.NEWLINE, i);
		}
		public Test_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_case; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).enterTest_case(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).exitTest_case(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestDrivenDev_DSLVisitor ) return ((TestDrivenDev_DSLVisitor<? extends T>)visitor).visitTest_case(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Test_caseContext test_case() throws RecognitionException {
		Test_caseContext _localctx = new Test_caseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_test_case);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(T__0);
			setState(22);
			match(ID);
			setState(23);
			match(T__1);
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(24);
				match(NEWLINE);
				}
			}

			setState(27);
			((Test_caseContext)_localctx).test_assertion = test_assertion();
			((Test_caseContext)_localctx).assertions.add(((Test_caseContext)_localctx).test_assertion);
			setState(32);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(28);
					match(NEWLINE);
					setState(29);
					((Test_caseContext)_localctx).test_assertion = test_assertion();
					((Test_caseContext)_localctx).assertions.add(((Test_caseContext)_localctx).test_assertion);
					}
					} 
				}
				setState(34);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Test_assertionContext extends ParserRuleContext {
		public DirectiveContext ppDirective;
		public Test_inputContext in;
		public Test_outputContext out;
		public Token cm;
		public TerminalNode PAR_L() { return getToken(TestDrivenDev_DSLParser.PAR_L, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(TestDrivenDev_DSLParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TestDrivenDev_DSLParser.NEWLINE, i);
		}
		public DirectiveContext directive() {
			return getRuleContext(DirectiveContext.class,0);
		}
		public Test_inputContext test_input() {
			return getRuleContext(Test_inputContext.class,0);
		}
		public Test_outputContext test_output() {
			return getRuleContext(Test_outputContext.class,0);
		}
		public TerminalNode PAR_R() { return getToken(TestDrivenDev_DSLParser.PAR_R, 0); }
		public TerminalNode COMMENT() { return getToken(TestDrivenDev_DSLParser.COMMENT, 0); }
		public Test_assertionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_assertion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).enterTest_assertion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).exitTest_assertion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestDrivenDev_DSLVisitor ) return ((TestDrivenDev_DSLVisitor<? extends T>)visitor).visitTest_assertion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Test_assertionContext test_assertion() throws RecognitionException {
		Test_assertionContext _localctx = new Test_assertionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_test_assertion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			((Test_assertionContext)_localctx).ppDirective = directive();
			setState(36);
			match(PAR_L);
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(37);
				match(NEWLINE);
				}
			}

			setState(40);
			((Test_assertionContext)_localctx).in = test_input();
			setState(41);
			match(NEWLINE);
			setState(42);
			((Test_assertionContext)_localctx).out = test_output();
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(43);
				match(NEWLINE);
				setState(44);
				((Test_assertionContext)_localctx).cm = match(COMMENT);
				setState(45);
				match(PAR_R);
				}
				break;
			case 2:
				{
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(46);
					match(NEWLINE);
					}
				}

				setState(49);
				match(PAR_R);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Test_inputContext extends ParserRuleContext {
		public ParamContext param;
		public List<ParamContext> params = new ArrayList<ParamContext>();
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(TestDrivenDev_DSLParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(TestDrivenDev_DSLParser.SEMICOLON, i);
		}
		public Test_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).enterTest_input(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).exitTest_input(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestDrivenDev_DSLVisitor ) return ((TestDrivenDev_DSLVisitor<? extends T>)visitor).visitTest_input(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Test_inputContext test_input() throws RecognitionException {
		Test_inputContext _localctx = new Test_inputContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_test_input);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__2);
			setState(53);
			((Test_inputContext)_localctx).param = param();
			((Test_inputContext)_localctx).params.add(((Test_inputContext)_localctx).param);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(54);
				match(SEMICOLON);
				setState(55);
				((Test_inputContext)_localctx).param = param();
				((Test_inputContext)_localctx).params.add(((Test_inputContext)_localctx).param);
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Test_outputContext extends ParserRuleContext {
		public ParamContext param;
		public List<ParamContext> params = new ArrayList<ParamContext>();
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(TestDrivenDev_DSLParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(TestDrivenDev_DSLParser.SEMICOLON, i);
		}
		public Test_outputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_output; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).enterTest_output(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).exitTest_output(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestDrivenDev_DSLVisitor ) return ((TestDrivenDev_DSLVisitor<? extends T>)visitor).visitTest_output(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Test_outputContext test_output() throws RecognitionException {
		Test_outputContext _localctx = new Test_outputContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_test_output);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(T__3);
			setState(62);
			((Test_outputContext)_localctx).param = param();
			((Test_outputContext)_localctx).params.add(((Test_outputContext)_localctx).param);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(63);
				match(SEMICOLON);
				setState(64);
				((Test_outputContext)_localctx).param = param();
				((Test_outputContext)_localctx).params.add(((Test_outputContext)_localctx).param);
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public ExprContext value;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestDrivenDev_DSLVisitor ) return ((TestDrivenDev_DSLVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			((ParamContext)_localctx).value = expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StrExprContext extends ExprContext {
		public Token value;
		public TerminalNode STRING() { return getToken(TestDrivenDev_DSLParser.STRING, 0); }
		public StrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).enterStrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).exitStrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestDrivenDev_DSLVisitor ) return ((TestDrivenDev_DSLVisitor<? extends T>)visitor).visitStrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntExprContext extends ExprContext {
		public Token value;
		public TerminalNode INT() { return getToken(TestDrivenDev_DSLParser.INT, 0); }
		public IntExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).enterIntExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).exitIntExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestDrivenDev_DSLVisitor ) return ((TestDrivenDev_DSLVisitor<? extends T>)visitor).visitIntExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_ADD() { return getToken(TestDrivenDev_DSLParser.OP_ADD, 0); }
		public TerminalNode OP_SUB() { return getToken(TestDrivenDev_DSLParser.OP_SUB, 0); }
		public AddSubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).enterAddSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).exitAddSubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestDrivenDev_DSLVisitor ) return ((TestDrivenDev_DSLVisitor<? extends T>)visitor).visitAddSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberExprContext extends ExprContext {
		public Token value;
		public TerminalNode NUM() { return getToken(TestDrivenDev_DSLParser.NUM, 0); }
		public NumberExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).enterNumberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).exitNumberExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestDrivenDev_DSLVisitor ) return ((TestDrivenDev_DSLVisitor<? extends T>)visitor).visitNumberExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensExprContext extends ExprContext {
		public TerminalNode PAR_L() { return getToken(TestDrivenDev_DSLParser.PAR_L, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_R() { return getToken(TestDrivenDev_DSLParser.PAR_R, 0); }
		public ParensExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).enterParensExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).exitParensExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestDrivenDev_DSLVisitor ) return ((TestDrivenDev_DSLVisitor<? extends T>)visitor).visitParensExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_MUL() { return getToken(TestDrivenDev_DSLParser.OP_MUL, 0); }
		public TerminalNode OP_DIV() { return getToken(TestDrivenDev_DSLParser.OP_DIV, 0); }
		public MulDivExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).enterMulDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).exitMulDivExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestDrivenDev_DSLVisitor ) return ((TestDrivenDev_DSLVisitor<? extends T>)visitor).visitMulDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PAR_L:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(73);
				match(PAR_L);
				setState(74);
				expr(0);
				setState(75);
				match(PAR_R);
				}
				break;
			case INT:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				((IntExprContext)_localctx).value = match(INT);
				}
				break;
			case NUM:
				{
				_localctx = new NumberExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				((NumberExprContext)_localctx).value = match(NUM);
				}
				break;
			case STRING:
				{
				_localctx = new StrExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				((StrExprContext)_localctx).value = match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(90);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(88);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivExprContext(new ExprContext(_parentctx, _parentState));
						((MulDivExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(82);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(83);
						((MulDivExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_MUL || _la==OP_DIV) ) {
							((MulDivExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(84);
						((MulDivExprContext)_localctx).right = expr(7);
						}
						break;
					case 2:
						{
						_localctx = new AddSubExprContext(new ExprContext(_parentctx, _parentState));
						((AddSubExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(85);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(86);
						((AddSubExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_ADD || _la==OP_SUB) ) {
							((AddSubExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(87);
						((AddSubExprContext)_localctx).right = expr(6);
						}
						break;
					}
					} 
				}
				setState(92);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectiveContext extends ParserRuleContext {
		public Token ppDirective;
		public DirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).enterDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestDrivenDev_DSLListener ) ((TestDrivenDev_DSLListener)listener).exitDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestDrivenDev_DSLVisitor ) return ((TestDrivenDev_DSLVisitor<? extends T>)visitor).visitDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectiveContext directive() throws RecognitionException {
		DirectiveContext _localctx = new DirectiveContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_directive);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				((DirectiveContext)_localctx).ppDirective = match(T__4);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				((DirectiveContext)_localctx).ppDirective = match(T__5);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				((DirectiveContext)_localctx).ppDirective = match(T__6);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				((DirectiveContext)_localctx).ppDirective = match(T__7);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(97);
				((DirectiveContext)_localctx).ppDirective = match(T__8);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 6);
				{
				setState(98);
				((DirectiveContext)_localctx).ppDirective = match(T__9);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 7);
				{
				setState(99);
				((DirectiveContext)_localctx).ppDirective = match(T__10);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 8);
				{
				setState(100);
				((DirectiveContext)_localctx).ppDirective = match(T__11);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 9);
				{
				setState(101);
				((DirectiveContext)_localctx).ppDirective = match(T__12);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 10);
				{
				setState(102);
				((DirectiveContext)_localctx).ppDirective = match(T__13);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 11);
				{
				setState(103);
				((DirectiveContext)_localctx).ppDirective = match(T__14);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 12);
				{
				setState(104);
				((DirectiveContext)_localctx).ppDirective = match(T__15);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 13);
				{
				setState(105);
				((DirectiveContext)_localctx).ppDirective = match(T__16);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 14);
				{
				setState(106);
				((DirectiveContext)_localctx).ppDirective = match(T__17);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 15);
				{
				setState(107);
				((DirectiveContext)_localctx).ppDirective = match(T__18);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 16);
				{
				setState(108);
				((DirectiveContext)_localctx).ppDirective = match(T__19);
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 17);
				{
				setState(109);
				((DirectiveContext)_localctx).ppDirective = match(T__20);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 18);
				{
				setState(110);
				((DirectiveContext)_localctx).ppDirective = match(T__21);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 19);
				{
				setState(111);
				((DirectiveContext)_localctx).ppDirective = match(T__22);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 20);
				{
				setState(112);
				((DirectiveContext)_localctx).ppDirective = match(T__23);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 21);
				{
				setState(113);
				((DirectiveContext)_localctx).ppDirective = match(T__24);
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 22);
				{
				setState(114);
				((DirectiveContext)_localctx).ppDirective = match(T__25);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001*v\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0003\u0000\u0014\b\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\u001a\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001\u001f\b\u0001\n\u0001\f\u0001\"\t\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002\'\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u00020\b\u0002\u0001\u0002\u0003\u00023\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u00039\b\u0003\n\u0003\f\u0003<\t\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004B\b\u0004"+
		"\n\u0004\f\u0004E\t\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006Q\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006Y\b\u0006\n\u0006\f\u0006\\\t\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007t\b\u0007"+
		"\u0001\u0007\u0000\u0001\f\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000"+
		"\u0002\u0001\u0000\u001e\u001f\u0001\u0000 !\u008f\u0000\u0010\u0001\u0000"+
		"\u0000\u0000\u0002\u0015\u0001\u0000\u0000\u0000\u0004#\u0001\u0000\u0000"+
		"\u0000\u00064\u0001\u0000\u0000\u0000\b=\u0001\u0000\u0000\u0000\nF\u0001"+
		"\u0000\u0000\u0000\fP\u0001\u0000\u0000\u0000\u000es\u0001\u0000\u0000"+
		"\u0000\u0010\u0013\u0003\u0002\u0001\u0000\u0011\u0012\u0005)\u0000\u0000"+
		"\u0012\u0014\u0003\u0002\u0001\u0000\u0013\u0011\u0001\u0000\u0000\u0000"+
		"\u0013\u0014\u0001\u0000\u0000\u0000\u0014\u0001\u0001\u0000\u0000\u0000"+
		"\u0015\u0016\u0005\u0001\u0000\u0000\u0016\u0017\u0005\u001b\u0000\u0000"+
		"\u0017\u0019\u0005\u0002\u0000\u0000\u0018\u001a\u0005)\u0000\u0000\u0019"+
		"\u0018\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a"+
		"\u001b\u0001\u0000\u0000\u0000\u001b \u0003\u0004\u0002\u0000\u001c\u001d"+
		"\u0005)\u0000\u0000\u001d\u001f\u0003\u0004\u0002\u0000\u001e\u001c\u0001"+
		"\u0000\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000 \u001e\u0001\u0000"+
		"\u0000\u0000 !\u0001\u0000\u0000\u0000!\u0003\u0001\u0000\u0000\u0000"+
		"\" \u0001\u0000\u0000\u0000#$\u0003\u000e\u0007\u0000$&\u0005\"\u0000"+
		"\u0000%\'\u0005)\u0000\u0000&%\u0001\u0000\u0000\u0000&\'\u0001\u0000"+
		"\u0000\u0000\'(\u0001\u0000\u0000\u0000()\u0003\u0006\u0003\u0000)*\u0005"+
		")\u0000\u0000*2\u0003\b\u0004\u0000+,\u0005)\u0000\u0000,-\u0005%\u0000"+
		"\u0000-3\u0005#\u0000\u0000.0\u0005)\u0000\u0000/.\u0001\u0000\u0000\u0000"+
		"/0\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u000013\u0005#\u0000\u0000"+
		"2+\u0001\u0000\u0000\u00002/\u0001\u0000\u0000\u00003\u0005\u0001\u0000"+
		"\u0000\u000045\u0005\u0003\u0000\u00005:\u0003\n\u0005\u000067\u0005\u001c"+
		"\u0000\u000079\u0003\n\u0005\u000086\u0001\u0000\u0000\u00009<\u0001\u0000"+
		"\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;\u0007"+
		"\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=>\u0005\u0004\u0000"+
		"\u0000>C\u0003\n\u0005\u0000?@\u0005\u001c\u0000\u0000@B\u0003\n\u0005"+
		"\u0000A?\u0001\u0000\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000"+
		"\u0000\u0000CD\u0001\u0000\u0000\u0000D\t\u0001\u0000\u0000\u0000EC\u0001"+
		"\u0000\u0000\u0000FG\u0003\f\u0006\u0000G\u000b\u0001\u0000\u0000\u0000"+
		"HI\u0006\u0006\uffff\uffff\u0000IJ\u0005\"\u0000\u0000JK\u0003\f\u0006"+
		"\u0000KL\u0005#\u0000\u0000LQ\u0001\u0000\u0000\u0000MQ\u0005&\u0000\u0000"+
		"NQ\u0005\'\u0000\u0000OQ\u0005$\u0000\u0000PH\u0001\u0000\u0000\u0000"+
		"PM\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PO\u0001\u0000\u0000"+
		"\u0000QZ\u0001\u0000\u0000\u0000RS\n\u0006\u0000\u0000ST\u0007\u0000\u0000"+
		"\u0000TY\u0003\f\u0006\u0007UV\n\u0005\u0000\u0000VW\u0007\u0001\u0000"+
		"\u0000WY\u0003\f\u0006\u0006XR\u0001\u0000\u0000\u0000XU\u0001\u0000\u0000"+
		"\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000"+
		"\u0000\u0000[\r\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]t\u0005"+
		"\u0005\u0000\u0000^t\u0005\u0006\u0000\u0000_t\u0005\u0007\u0000\u0000"+
		"`t\u0005\b\u0000\u0000at\u0005\t\u0000\u0000bt\u0005\n\u0000\u0000ct\u0005"+
		"\u000b\u0000\u0000dt\u0005\f\u0000\u0000et\u0005\r\u0000\u0000ft\u0005"+
		"\u000e\u0000\u0000gt\u0005\u000f\u0000\u0000ht\u0005\u0010\u0000\u0000"+
		"it\u0005\u0011\u0000\u0000jt\u0005\u0012\u0000\u0000kt\u0005\u0013\u0000"+
		"\u0000lt\u0005\u0014\u0000\u0000mt\u0005\u0015\u0000\u0000nt\u0005\u0016"+
		"\u0000\u0000ot\u0005\u0017\u0000\u0000pt\u0005\u0018\u0000\u0000qt\u0005"+
		"\u0019\u0000\u0000rt\u0005\u001a\u0000\u0000s]\u0001\u0000\u0000\u0000"+
		"s^\u0001\u0000\u0000\u0000s_\u0001\u0000\u0000\u0000s`\u0001\u0000\u0000"+
		"\u0000sa\u0001\u0000\u0000\u0000sb\u0001\u0000\u0000\u0000sc\u0001\u0000"+
		"\u0000\u0000sd\u0001\u0000\u0000\u0000se\u0001\u0000\u0000\u0000sf\u0001"+
		"\u0000\u0000\u0000sg\u0001\u0000\u0000\u0000sh\u0001\u0000\u0000\u0000"+
		"si\u0001\u0000\u0000\u0000sj\u0001\u0000\u0000\u0000sk\u0001\u0000\u0000"+
		"\u0000sl\u0001\u0000\u0000\u0000sm\u0001\u0000\u0000\u0000sn\u0001\u0000"+
		"\u0000\u0000so\u0001\u0000\u0000\u0000sp\u0001\u0000\u0000\u0000sq\u0001"+
		"\u0000\u0000\u0000sr\u0001\u0000\u0000\u0000t\u000f\u0001\u0000\u0000"+
		"\u0000\f\u0013\u0019 &/2:CPXZs";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}