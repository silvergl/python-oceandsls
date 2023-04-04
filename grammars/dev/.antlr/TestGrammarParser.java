// Generated from e:\amack\Documents\UNI\Hiwi\antlr4-python\grammars\dev\TestGrammar.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TestGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OP_MUL=1, OP_DIV=2, OP_ADD=3, OP_SUB=4, PAR_L=5, PAR_R=6, EQUAL=7, SEP=8, 
		WS=9, ID=10, NUM=11, NEWLINE=12;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_expr = 2, RULE_exprList = 3, RULE_variableRef = 4, 
		RULE_functionRef = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "expr", "exprList", "variableRef", "functionRef"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'/'", "'+'", "'-'", "'('", "')'", "'='", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OP_MUL", "OP_DIV", "OP_ADD", "OP_SUB", "PAR_L", "PAR_R", "EQUAL", 
			"SEP", "WS", "ID", "NUM", "NEWLINE"
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
	public String getGrammarFileName() { return "TestGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TestGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StartProgContext extends ProgContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public StartProgContext(ProgContext ctx) { copyFrom(ctx); }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			_localctx = new StartProgContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PAR_L) | (1L << ID) | (1L << NUM) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(12);
				stat();
				}
				}
				setState(17);
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintExprStatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(TestGrammarParser.NEWLINE, 0); }
		public PrintExprStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class BlankStatContext extends StatContext {
		public TerminalNode NEWLINE() { return getToken(TestGrammarParser.NEWLINE, 0); }
		public BlankStatContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class AssignStatContext extends StatContext {
		public TerminalNode ID() { return getToken(TestGrammarParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(TestGrammarParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(TestGrammarParser.NEWLINE, 0); }
		public AssignStatContext(StatContext ctx) { copyFrom(ctx); }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(27);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new PrintExprStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				expr(0);
				setState(19);
				match(NEWLINE);
				}
				break;
			case 2:
				_localctx = new AssignStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				match(ID);
				setState(22);
				match(EQUAL);
				setState(23);
				expr(0);
				setState(24);
				match(NEWLINE);
				}
				break;
			case 3:
				_localctx = new BlankStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(26);
				match(NEWLINE);
				}
				break;
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
		public TerminalNode OP_ADD() { return getToken(TestGrammarParser.OP_ADD, 0); }
		public TerminalNode OP_SUB() { return getToken(TestGrammarParser.OP_SUB, 0); }
		public AddSubExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class FunRefContext extends ExprContext {
		public FunctionRefContext functionRef() {
			return getRuleContext(FunctionRefContext.class,0);
		}
		public FunRefContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class NumberExprContext extends ExprContext {
		public Token value;
		public TerminalNode NUM() { return getToken(TestGrammarParser.NUM, 0); }
		public NumberExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ParensExprContext extends ExprContext {
		public TerminalNode PAR_L() { return getToken(TestGrammarParser.PAR_L, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_R() { return getToken(TestGrammarParser.PAR_R, 0); }
		public ParensExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
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
		public TerminalNode OP_MUL() { return getToken(TestGrammarParser.OP_MUL, 0); }
		public TerminalNode OP_DIV() { return getToken(TestGrammarParser.OP_DIV, 0); }
		public MulDivExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class IdRefContext extends ExprContext {
		public VariableRefContext variableRef() {
			return getRuleContext(VariableRefContext.class,0);
		}
		public IdRefContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(30);
				match(PAR_L);
				setState(31);
				expr(0);
				setState(32);
				match(PAR_R);
				}
				break;
			case 2:
				{
				_localctx = new NumberExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(34);
				((NumberExprContext)_localctx).value = match(NUM);
				}
				break;
			case 3:
				{
				_localctx = new FunRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(35);
				functionRef();
				}
				break;
			case 4:
				{
				_localctx = new IdRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36);
				variableRef();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(45);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivExprContext(new ExprContext(_parentctx, _parentState));
						((MulDivExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(39);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(40);
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
						setState(41);
						((MulDivExprContext)_localctx).right = expr(7);
						}
						break;
					case 2:
						{
						_localctx = new AddSubExprContext(new ExprContext(_parentctx, _parentState));
						((AddSubExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(42);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(43);
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
						setState(44);
						((AddSubExprContext)_localctx).right = expr(6);
						}
						break;
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class ExprListContext extends ParserRuleContext {
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
	 
		public ExprListContext() { }
		public void copyFrom(ExprListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArgListContext extends ExprListContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SEP() { return getTokens(TestGrammarParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(TestGrammarParser.SEP, i);
		}
		public ArgListContext(ExprListContext ctx) { copyFrom(ctx); }
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_exprList);
		int _la;
		try {
			_localctx = new ArgListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			expr(0);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(51);
				match(SEP);
				setState(52);
				expr(0);
				}
				}
				setState(57);
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

	public static class VariableRefContext extends ParserRuleContext {
		public VariableRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableRef; }
	 
		public VariableRefContext() { }
		public void copyFrom(VariableRefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarExprContext extends VariableRefContext {
		public TerminalNode ID() { return getToken(TestGrammarParser.ID, 0); }
		public VarExprContext(VariableRefContext ctx) { copyFrom(ctx); }
	}

	public final VariableRefContext variableRef() throws RecognitionException {
		VariableRefContext _localctx = new VariableRefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableRef);
		try {
			_localctx = new VarExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(ID);
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

	public static class FunctionRefContext extends ParserRuleContext {
		public FunctionRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionRef; }
	 
		public FunctionRefContext() { }
		public void copyFrom(FunctionRefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncExprContext extends FunctionRefContext {
		public TerminalNode ID() { return getToken(TestGrammarParser.ID, 0); }
		public TerminalNode PAR_L() { return getToken(TestGrammarParser.PAR_L, 0); }
		public TerminalNode PAR_R() { return getToken(TestGrammarParser.PAR_R, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public FuncExprContext(FunctionRefContext ctx) { copyFrom(ctx); }
	}

	public final FunctionRefContext functionRef() throws RecognitionException {
		FunctionRefContext _localctx = new FunctionRefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionRef);
		int _la;
		try {
			_localctx = new FuncExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(ID);
			setState(61);
			match(PAR_L);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PAR_L) | (1L << ID) | (1L << NUM))) != 0)) {
				{
				setState(62);
				exprList();
				}
			}

			setState(65);
			match(PAR_R);
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
		case 2:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16F\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\7\2\20\n\2\f\2\16\2\23\13\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4(\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\60\n\4\f\4\16\4\63\13\4\3"+
		"\5\3\5\3\5\7\58\n\5\f\5\16\5;\13\5\3\6\3\6\3\7\3\7\3\7\5\7B\n\7\3\7\3"+
		"\7\3\7\2\3\6\b\2\4\6\b\n\f\2\4\3\2\3\4\3\2\5\6\2I\2\21\3\2\2\2\4\35\3"+
		"\2\2\2\6\'\3\2\2\2\b\64\3\2\2\2\n<\3\2\2\2\f>\3\2\2\2\16\20\5\4\3\2\17"+
		"\16\3\2\2\2\20\23\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\3\3\2\2\2\23"+
		"\21\3\2\2\2\24\25\5\6\4\2\25\26\7\16\2\2\26\36\3\2\2\2\27\30\7\f\2\2\30"+
		"\31\7\t\2\2\31\32\5\6\4\2\32\33\7\16\2\2\33\36\3\2\2\2\34\36\7\16\2\2"+
		"\35\24\3\2\2\2\35\27\3\2\2\2\35\34\3\2\2\2\36\5\3\2\2\2\37 \b\4\1\2 !"+
		"\7\7\2\2!\"\5\6\4\2\"#\7\b\2\2#(\3\2\2\2$(\7\r\2\2%(\5\f\7\2&(\5\n\6\2"+
		"\'\37\3\2\2\2\'$\3\2\2\2\'%\3\2\2\2\'&\3\2\2\2(\61\3\2\2\2)*\f\b\2\2*"+
		"+\t\2\2\2+\60\5\6\4\t,-\f\7\2\2-.\t\3\2\2.\60\5\6\4\b/)\3\2\2\2/,\3\2"+
		"\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\7\3\2\2\2\63\61\3\2\2"+
		"\2\649\5\6\4\2\65\66\7\n\2\2\668\5\6\4\2\67\65\3\2\2\28;\3\2\2\29\67\3"+
		"\2\2\29:\3\2\2\2:\t\3\2\2\2;9\3\2\2\2<=\7\f\2\2=\13\3\2\2\2>?\7\f\2\2"+
		"?A\7\7\2\2@B\5\b\5\2A@\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\7\b\2\2D\r\3\2\2"+
		"\2\t\21\35\'/\619A";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}