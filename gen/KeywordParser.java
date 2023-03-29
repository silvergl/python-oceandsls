// Generated from /home/sgu/IdeaProjects/antlr4-python/grammars/TDD-DSL/Keyword.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KeywordParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, STRING=28;
	public static final int
		RULE_f90StdKey = 0, RULE_directive = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"f90StdKey", "directive"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'DIMENSION'", "'INTENT(IN)'", "'INTENT(INOUT)'", "'INTENT(OUT)'", 
			"'PARAMETER'", "'Equal'", "'True'", "'EqualUserDefined'", "'False'", 
			"'LessThan'", "'LessThanOrEqual'", "'GreaterThan'", "'GreaterThanOrEqual'", 
			"'IsMemberOf'", "'Contains'", "'Any'", "'All'", "'NotAll'", "'None'", 
			"'IsPermutationOf'", "'ExceptionRaised'", "'SameShape'", "'IsNaN'", "'IsFinite'", 
			"'Associated'", "'NotAssociated'", "'Equivalent'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "STRING"
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
	public String getGrammarFileName() { return "Keyword.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KeywordParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class F90StdKeyContext extends ParserRuleContext {
		public F90StdKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f90StdKey; }
	 
		public F90StdKeyContext() { }
		public void copyFrom(F90StdKeyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConstantSpecContext extends F90StdKeyContext {
		public Token keyword;
		public ConstantSpecContext(F90StdKeyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeywordListener ) ((KeywordListener)listener).enterConstantSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeywordListener ) ((KeywordListener)listener).exitConstantSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KeywordVisitor ) return ((KeywordVisitor<? extends T>)visitor).visitConstantSpec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArraySpecContext extends F90StdKeyContext {
		public Token keyword;
		public ArraySpecContext(F90StdKeyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeywordListener ) ((KeywordListener)listener).enterArraySpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeywordListener ) ((KeywordListener)listener).exitArraySpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KeywordVisitor ) return ((KeywordVisitor<? extends T>)visitor).visitArraySpec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CustomContext extends F90StdKeyContext {
		public Token keyword;
		public TerminalNode STRING() { return getToken(KeywordParser.STRING, 0); }
		public CustomContext(F90StdKeyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeywordListener ) ((KeywordListener)listener).enterCustom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeywordListener ) ((KeywordListener)listener).exitCustom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KeywordVisitor ) return ((KeywordVisitor<? extends T>)visitor).visitCustom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArgSpecInOutputContext extends F90StdKeyContext {
		public Token keyword;
		public ArgSpecInOutputContext(F90StdKeyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeywordListener ) ((KeywordListener)listener).enterArgSpecInOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeywordListener ) ((KeywordListener)listener).exitArgSpecInOutput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KeywordVisitor ) return ((KeywordVisitor<? extends T>)visitor).visitArgSpecInOutput(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArgSpecOutputContext extends F90StdKeyContext {
		public Token keyword;
		public ArgSpecOutputContext(F90StdKeyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeywordListener ) ((KeywordListener)listener).enterArgSpecOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeywordListener ) ((KeywordListener)listener).exitArgSpecOutput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KeywordVisitor ) return ((KeywordVisitor<? extends T>)visitor).visitArgSpecOutput(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArgSpecInputContext extends F90StdKeyContext {
		public Token keyword;
		public ArgSpecInputContext(F90StdKeyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeywordListener ) ((KeywordListener)listener).enterArgSpecInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeywordListener ) ((KeywordListener)listener).exitArgSpecInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KeywordVisitor ) return ((KeywordVisitor<? extends T>)visitor).visitArgSpecInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final F90StdKeyContext f90StdKey() throws RecognitionException {
		F90StdKeyContext _localctx = new F90StdKeyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_f90StdKey);
		try {
			setState(10);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new ArraySpecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(4);
				((ArraySpecContext)_localctx).keyword = match(T__0);
				}
				break;
			case T__1:
				_localctx = new ArgSpecInputContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(5);
				((ArgSpecInputContext)_localctx).keyword = match(T__1);
				}
				break;
			case T__2:
				_localctx = new ArgSpecInOutputContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(6);
				((ArgSpecInOutputContext)_localctx).keyword = match(T__2);
				}
				break;
			case T__3:
				_localctx = new ArgSpecOutputContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(7);
				((ArgSpecOutputContext)_localctx).keyword = match(T__3);
				}
				break;
			case T__4:
				_localctx = new ConstantSpecContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(8);
				((ConstantSpecContext)_localctx).keyword = match(T__4);
				}
				break;
			case STRING:
				_localctx = new CustomContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(9);
				((CustomContext)_localctx).keyword = match(STRING);
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

	public static class DirectiveContext extends ParserRuleContext {
		public Token ppDirective;
		public DirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeywordListener ) ((KeywordListener)listener).enterDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeywordListener ) ((KeywordListener)listener).exitDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KeywordVisitor ) return ((KeywordVisitor<? extends T>)visitor).visitDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectiveContext directive() throws RecognitionException {
		DirectiveContext _localctx = new DirectiveContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_directive);
		try {
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(12);
				((DirectiveContext)_localctx).ppDirective = match(T__5);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(13);
				((DirectiveContext)_localctx).ppDirective = match(T__6);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(14);
				((DirectiveContext)_localctx).ppDirective = match(T__7);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(15);
				((DirectiveContext)_localctx).ppDirective = match(T__8);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(16);
				((DirectiveContext)_localctx).ppDirective = match(T__9);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 6);
				{
				setState(17);
				((DirectiveContext)_localctx).ppDirective = match(T__10);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 7);
				{
				setState(18);
				((DirectiveContext)_localctx).ppDirective = match(T__11);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 8);
				{
				setState(19);
				((DirectiveContext)_localctx).ppDirective = match(T__12);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 9);
				{
				setState(20);
				((DirectiveContext)_localctx).ppDirective = match(T__13);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 10);
				{
				setState(21);
				((DirectiveContext)_localctx).ppDirective = match(T__14);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 11);
				{
				setState(22);
				((DirectiveContext)_localctx).ppDirective = match(T__15);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 12);
				{
				setState(23);
				((DirectiveContext)_localctx).ppDirective = match(T__16);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 13);
				{
				setState(24);
				((DirectiveContext)_localctx).ppDirective = match(T__17);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 14);
				{
				setState(25);
				((DirectiveContext)_localctx).ppDirective = match(T__18);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 15);
				{
				setState(26);
				((DirectiveContext)_localctx).ppDirective = match(T__19);
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 16);
				{
				setState(27);
				((DirectiveContext)_localctx).ppDirective = match(T__20);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 17);
				{
				setState(28);
				((DirectiveContext)_localctx).ppDirective = match(T__21);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 18);
				{
				setState(29);
				((DirectiveContext)_localctx).ppDirective = match(T__22);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 19);
				{
				setState(30);
				((DirectiveContext)_localctx).ppDirective = match(T__23);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 20);
				{
				setState(31);
				((DirectiveContext)_localctx).ppDirective = match(T__24);
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 21);
				{
				setState(32);
				((DirectiveContext)_localctx).ppDirective = match(T__25);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 22);
				{
				setState(33);
				((DirectiveContext)_localctx).ppDirective = match(T__26);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001c%\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003"+
		"\u0000\u000b\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001#\b\u0001\u0001\u0001\u0000\u0000\u0002\u0000\u0002\u0000\u0000"+
		"<\u0000\n\u0001\u0000\u0000\u0000\u0002\"\u0001\u0000\u0000\u0000\u0004"+
		"\u000b\u0005\u0001\u0000\u0000\u0005\u000b\u0005\u0002\u0000\u0000\u0006"+
		"\u000b\u0005\u0003\u0000\u0000\u0007\u000b\u0005\u0004\u0000\u0000\b\u000b"+
		"\u0005\u0005\u0000\u0000\t\u000b\u0005\u001c\u0000\u0000\n\u0004\u0001"+
		"\u0000\u0000\u0000\n\u0005\u0001\u0000\u0000\u0000\n\u0006\u0001\u0000"+
		"\u0000\u0000\n\u0007\u0001\u0000\u0000\u0000\n\b\u0001\u0000\u0000\u0000"+
		"\n\t\u0001\u0000\u0000\u0000\u000b\u0001\u0001\u0000\u0000\u0000\f#\u0005"+
		"\u0006\u0000\u0000\r#\u0005\u0007\u0000\u0000\u000e#\u0005\b\u0000\u0000"+
		"\u000f#\u0005\t\u0000\u0000\u0010#\u0005\n\u0000\u0000\u0011#\u0005\u000b"+
		"\u0000\u0000\u0012#\u0005\f\u0000\u0000\u0013#\u0005\r\u0000\u0000\u0014"+
		"#\u0005\u000e\u0000\u0000\u0015#\u0005\u000f\u0000\u0000\u0016#\u0005"+
		"\u0010\u0000\u0000\u0017#\u0005\u0011\u0000\u0000\u0018#\u0005\u0012\u0000"+
		"\u0000\u0019#\u0005\u0013\u0000\u0000\u001a#\u0005\u0014\u0000\u0000\u001b"+
		"#\u0005\u0015\u0000\u0000\u001c#\u0005\u0016\u0000\u0000\u001d#\u0005"+
		"\u0017\u0000\u0000\u001e#\u0005\u0018\u0000\u0000\u001f#\u0005\u0019\u0000"+
		"\u0000 #\u0005\u001a\u0000\u0000!#\u0005\u001b\u0000\u0000\"\f\u0001\u0000"+
		"\u0000\u0000\"\r\u0001\u0000\u0000\u0000\"\u000e\u0001\u0000\u0000\u0000"+
		"\"\u000f\u0001\u0000\u0000\u0000\"\u0010\u0001\u0000\u0000\u0000\"\u0011"+
		"\u0001\u0000\u0000\u0000\"\u0012\u0001\u0000\u0000\u0000\"\u0013\u0001"+
		"\u0000\u0000\u0000\"\u0014\u0001\u0000\u0000\u0000\"\u0015\u0001\u0000"+
		"\u0000\u0000\"\u0016\u0001\u0000\u0000\u0000\"\u0017\u0001\u0000\u0000"+
		"\u0000\"\u0018\u0001\u0000\u0000\u0000\"\u0019\u0001\u0000\u0000\u0000"+
		"\"\u001a\u0001\u0000\u0000\u0000\"\u001b\u0001\u0000\u0000\u0000\"\u001c"+
		"\u0001\u0000\u0000\u0000\"\u001d\u0001\u0000\u0000\u0000\"\u001e\u0001"+
		"\u0000\u0000\u0000\"\u001f\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000"+
		"\u0000\"!\u0001\u0000\u0000\u0000#\u0003\u0001\u0000\u0000\u0000\u0002"+
		"\n\"";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}