// Generated from /home/sgu/IdeaProjects/antlr4-python/grammars/TDD-DSL/Reference.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ReferenceParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, ID=8, STRING=9, 
		COMMENT=10, INT=11, NUM=12, DP=13, TDD_COMMENT=14, NEWLINE=15, WS=16;
	public static final int
		RULE_expr = 0, RULE_reference = 1, RULE_exprList = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"expr", "reference", "exprList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'*'", "'/'", "'+'", "'-'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "ID", "STRING", "COMMENT", 
			"INT", "NUM", "DP", "TDD_COMMENT", "NEWLINE", "WS"
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
	public String getGrammarFileName() { return "Reference.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ReferenceParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
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
	public static class StrExprContext extends ExprContext {
		public Token value;
		public TerminalNode STRING() { return getToken(ReferenceParser.STRING, 0); }
		public StrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).enterStrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).exitStrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReferenceVisitor ) return ((ReferenceVisitor<? extends T>)visitor).visitStrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntExprContext extends ExprContext {
		public Token value;
		public TerminalNode INT() { return getToken(ReferenceParser.INT, 0); }
		public IntExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).enterIntExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).exitIntExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReferenceVisitor ) return ((ReferenceVisitor<? extends T>)visitor).visitIntExpr(this);
			else return visitor.visitChildren(this);
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
		public AddSubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).enterAddSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).exitAddSubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReferenceVisitor ) return ((ReferenceVisitor<? extends T>)visitor).visitAddSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RefExprContext extends ExprContext {
		public ReferenceContext value;
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public RefExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).enterRefExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).exitRefExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReferenceVisitor ) return ((ReferenceVisitor<? extends T>)visitor).visitRefExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberExprContext extends ExprContext {
		public Token value;
		public TerminalNode NUM() { return getToken(ReferenceParser.NUM, 0); }
		public TerminalNode DP() { return getToken(ReferenceParser.DP, 0); }
		public NumberExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).enterNumberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).exitNumberExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReferenceVisitor ) return ((ReferenceVisitor<? extends T>)visitor).visitNumberExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensExprContext extends ExprContext {
		public ExprContext inner;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).enterParensExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).exitParensExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReferenceVisitor ) return ((ReferenceVisitor<? extends T>)visitor).visitParensExpr(this);
			else return visitor.visitChildren(this);
		}
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
		public MulDivExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).enterMulDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).exitMulDivExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReferenceVisitor ) return ((ReferenceVisitor<? extends T>)visitor).visitMulDivExpr(this);
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
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(7);
				match(T__0);
				setState(8);
				((ParensExprContext)_localctx).inner = expr(0);
				setState(9);
				match(T__1);
				}
				break;
			case NUM:
			case DP:
				{
				_localctx = new NumberExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(11);
				((NumberExprContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NUM || _la==DP) ) {
					((NumberExprContext)_localctx).value = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case STRING:
				{
				_localctx = new StrExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(12);
				((StrExprContext)_localctx).value = match(STRING);
				}
				break;
			case INT:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(13);
				((IntExprContext)_localctx).value = match(INT);
				}
				break;
			case ID:
				{
				_localctx = new RefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(14);
				((RefExprContext)_localctx).value = reference();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(25);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(23);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivExprContext(new ExprContext(_parentctx, _parentState));
						((MulDivExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(17);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(18);
						((MulDivExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==T__3) ) {
							((MulDivExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(19);
						((MulDivExprContext)_localctx).right = expr(7);
						}
						break;
					case 2:
						{
						_localctx = new AddSubExprContext(new ExprContext(_parentctx, _parentState));
						((AddSubExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(20);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(21);
						((AddSubExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
							((AddSubExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(22);
						((AddSubExprContext)_localctx).right = expr(6);
						}
						break;
					}
					} 
				}
				setState(27);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ReferenceContext extends ParserRuleContext {
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
	 
		public ReferenceContext() { }
		public void copyFrom(ReferenceContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunRefContext extends ReferenceContext {
		public TerminalNode ID() { return getToken(ReferenceParser.ID, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public FunRefContext(ReferenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).enterFunRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).exitFunRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReferenceVisitor ) return ((ReferenceVisitor<? extends T>)visitor).visitFunRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarRefContext extends ReferenceContext {
		public TerminalNode ID() { return getToken(ReferenceParser.ID, 0); }
		public VarRefContext(ReferenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).enterVarRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).exitVarRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReferenceVisitor ) return ((ReferenceVisitor<? extends T>)visitor).visitVarRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_reference);
		int _la;
		try {
			setState(35);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new FunRefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				match(ID);
				setState(29);
				match(T__0);
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << ID) | (1L << STRING) | (1L << INT) | (1L << NUM) | (1L << DP))) != 0)) {
					{
					setState(30);
					exprList();
					}
				}

				setState(33);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new VarRefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				match(ID);
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
		public ArgListContext(ExprListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).enterArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReferenceListener ) ((ReferenceListener)listener).exitArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReferenceVisitor ) return ((ReferenceVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_exprList);
		int _la;
		try {
			_localctx = new ArgListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			expr(0);
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(38);
				match(T__6);
				setState(39);
				expr(0);
				}
				}
				setState(44);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
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
		"\u0004\u0001\u0010.\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000\u0010"+
		"\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0005\u0000\u0018\b\u0000\n\u0000\f\u0000\u001b\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001 \b\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001$\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		")\b\u0002\n\u0002\f\u0002,\t\u0002\u0001\u0002\u0000\u0001\u0000\u0003"+
		"\u0000\u0002\u0004\u0000\u0003\u0001\u0000\f\r\u0001\u0000\u0003\u0004"+
		"\u0001\u0000\u0005\u00063\u0000\u000f\u0001\u0000\u0000\u0000\u0002#\u0001"+
		"\u0000\u0000\u0000\u0004%\u0001\u0000\u0000\u0000\u0006\u0007\u0006\u0000"+
		"\uffff\uffff\u0000\u0007\b\u0005\u0001\u0000\u0000\b\t\u0003\u0000\u0000"+
		"\u0000\t\n\u0005\u0002\u0000\u0000\n\u0010\u0001\u0000\u0000\u0000\u000b"+
		"\u0010\u0007\u0000\u0000\u0000\f\u0010\u0005\t\u0000\u0000\r\u0010\u0005"+
		"\u000b\u0000\u0000\u000e\u0010\u0003\u0002\u0001\u0000\u000f\u0006\u0001"+
		"\u0000\u0000\u0000\u000f\u000b\u0001\u0000\u0000\u0000\u000f\f\u0001\u0000"+
		"\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000\u000f\u000e\u0001\u0000\u0000"+
		"\u0000\u0010\u0019\u0001\u0000\u0000\u0000\u0011\u0012\n\u0006\u0000\u0000"+
		"\u0012\u0013\u0007\u0001\u0000\u0000\u0013\u0018\u0003\u0000\u0000\u0007"+
		"\u0014\u0015\n\u0005\u0000\u0000\u0015\u0016\u0007\u0002\u0000\u0000\u0016"+
		"\u0018\u0003\u0000\u0000\u0006\u0017\u0011\u0001\u0000\u0000\u0000\u0017"+
		"\u0014\u0001\u0000\u0000\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019"+
		"\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a"+
		"\u0001\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001c"+
		"\u001d\u0005\b\u0000\u0000\u001d\u001f\u0005\u0001\u0000\u0000\u001e "+
		"\u0003\u0004\u0002\u0000\u001f\u001e\u0001\u0000\u0000\u0000\u001f \u0001"+
		"\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!$\u0005\u0002\u0000\u0000"+
		"\"$\u0005\b\u0000\u0000#\u001c\u0001\u0000\u0000\u0000#\"\u0001\u0000"+
		"\u0000\u0000$\u0003\u0001\u0000\u0000\u0000%*\u0003\u0000\u0000\u0000"+
		"&\'\u0005\u0007\u0000\u0000\')\u0003\u0000\u0000\u0000(&\u0001\u0000\u0000"+
		"\u0000),\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001\u0000"+
		"\u0000\u0000+\u0005\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000"+
		"\u0006\u000f\u0017\u0019\u001f#*";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}