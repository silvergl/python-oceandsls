// Generated from /home/sgu/IdeaProjects/antlr4-python/tdd-dsl/src/grammars/PhysicalUnits.g4 by ANTLR 4.12.0
package grammars;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PhysicalUnitsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, ID=40, STRING=41, COMMENT=42, INT=43, NUM=44, DP=45, TDD_COMMENT=46, 
		NEWLINE=47, WS=48;
	public static final int
		RULE_unitSpec = 0, RULE_composedUnit = 1, RULE_basicUnit = 2, RULE_siUnit = 3, 
		RULE_customUnit = 4, RULE_unitPrefix = 5, RULE_siType = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"unitSpec", "composedUnit", "basicUnit", "siUnit", "customUnit", "unitPrefix", 
			"siType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'/'", "'**'", "'('", "')'", "'noP'", "'Q'", "'R'", "'Y'", 
			"'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", 
			"'c'", "'m'", "'\\u03BC'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'", 
			"'r'", "'q'", "'s'", "'g'", "'A'", "'K'", "'mol'", "'cd'", "'Pa'", "'J'", 
			"'t'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "ID", "STRING", "COMMENT", "INT", "NUM", "DP", 
			"TDD_COMMENT", "NEWLINE", "WS"
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
	public String getGrammarFileName() { return "PhysicalUnits.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PhysicalUnitsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnitSpecContext extends ParserRuleContext {
		public ComposedUnitContext composedUnit;
		public List<ComposedUnitContext> units = new ArrayList<ComposedUnitContext>();
		public List<ComposedUnitContext> composedUnit() {
			return getRuleContexts(ComposedUnitContext.class);
		}
		public ComposedUnitContext composedUnit(int i) {
			return getRuleContext(ComposedUnitContext.class,i);
		}
		public UnitSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unitSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterUnitSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitUnitSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitUnitSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnitSpecContext unitSpec() throws RecognitionException {
		UnitSpecContext _localctx = new UnitSpecContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_unitSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			((UnitSpecContext)_localctx).composedUnit = composedUnit();
			((UnitSpecContext)_localctx).units.add(((UnitSpecContext)_localctx).composedUnit);
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(15);
				match(T__0);
				setState(16);
				((UnitSpecContext)_localctx).composedUnit = composedUnit();
				((UnitSpecContext)_localctx).units.add(((UnitSpecContext)_localctx).composedUnit);
				}
				}
				setState(21);
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
	public static class ComposedUnitContext extends ParserRuleContext {
		public BasicUnitContext numerator;
		public BasicUnitContext denominator;
		public Token exponent;
		public BasicUnitContext unit;
		public List<BasicUnitContext> basicUnit() {
			return getRuleContexts(BasicUnitContext.class);
		}
		public BasicUnitContext basicUnit(int i) {
			return getRuleContext(BasicUnitContext.class,i);
		}
		public TerminalNode INT() { return getToken(PhysicalUnitsParser.INT, 0); }
		public ComposedUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composedUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterComposedUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitComposedUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitComposedUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComposedUnitContext composedUnit() throws RecognitionException {
		ComposedUnitContext _localctx = new ComposedUnitContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_composedUnit);
		try {
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				((ComposedUnitContext)_localctx).numerator = basicUnit();
				setState(27);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
					{
					{
					setState(23);
					match(T__1);
					setState(24);
					((ComposedUnitContext)_localctx).denominator = basicUnit();
					}
					}
					break;
				case T__2:
					{
					{
					setState(25);
					match(T__2);
					setState(26);
					((ComposedUnitContext)_localctx).exponent = match(INT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				((ComposedUnitContext)_localctx).unit = basicUnit();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BasicUnitContext extends ParserRuleContext {
		public BasicUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicUnit; }
	 
		public BasicUnitContext() { }
		public void copyFrom(BasicUnitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CustomUnitTypeContext extends BasicUnitContext {
		public CustomUnitContext type;
		public CustomUnitContext customUnit() {
			return getRuleContext(CustomUnitContext.class,0);
		}
		public CustomUnitTypeContext(BasicUnitContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterCustomUnitType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitCustomUnitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitCustomUnitType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SiUnitTypeContext extends BasicUnitContext {
		public SiUnitContext type;
		public SiUnitContext siUnit() {
			return getRuleContext(SiUnitContext.class,0);
		}
		public SiUnitTypeContext(BasicUnitContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterSiUnitType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitSiUnitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitSiUnitType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComposedUnitTypeContext extends BasicUnitContext {
		public UnitSpecContext type;
		public UnitSpecContext unitSpec() {
			return getRuleContext(UnitSpecContext.class,0);
		}
		public ComposedUnitTypeContext(BasicUnitContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterComposedUnitType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitComposedUnitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitComposedUnitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicUnitContext basicUnit() throws RecognitionException {
		BasicUnitContext _localctx = new BasicUnitContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_basicUnit);
		try {
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
				_localctx = new SiUnitTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				((SiUnitTypeContext)_localctx).type = siUnit();
				}
				break;
			case STRING:
				_localctx = new CustomUnitTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				((CustomUnitTypeContext)_localctx).type = customUnit();
				}
				break;
			case T__3:
				_localctx = new ComposedUnitTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				match(T__3);
				setState(35);
				((ComposedUnitTypeContext)_localctx).type = unitSpec();
				setState(36);
				match(T__4);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SiUnitContext extends ParserRuleContext {
		public UnitPrefixContext prefix;
		public SiTypeContext type;
		public SiTypeContext siType() {
			return getRuleContext(SiTypeContext.class,0);
		}
		public UnitPrefixContext unitPrefix() {
			return getRuleContext(UnitPrefixContext.class,0);
		}
		public SiUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_siUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterSiUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitSiUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitSiUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SiUnitContext siUnit() throws RecognitionException {
		SiUnitContext _localctx = new SiUnitContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_siUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(40);
				((SiUnitContext)_localctx).prefix = unitPrefix();
				}
				break;
			}
			setState(43);
			((SiUnitContext)_localctx).type = siType();
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
	public static class CustomUnitContext extends ParserRuleContext {
		public Token name;
		public TerminalNode STRING() { return getToken(PhysicalUnitsParser.STRING, 0); }
		public CustomUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_customUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterCustomUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitCustomUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitCustomUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CustomUnitContext customUnit() throws RecognitionException {
		CustomUnitContext _localctx = new CustomUnitContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_customUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			((CustomUnitContext)_localctx).name = match(STRING);
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
	public static class UnitPrefixContext extends ParserRuleContext {
		public UnitPrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unitPrefix; }
	 
		public UnitPrefixContext() { }
		public void copyFrom(UnitPrefixContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MegaContext extends UnitPrefixContext {
		public Token value;
		public MegaContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterMega(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitMega(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitMega(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttoContext extends UnitPrefixContext {
		public Token value;
		public AttoContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterAtto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitAtto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitAtto(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FemtoContext extends UnitPrefixContext {
		public Token value;
		public FemtoContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterFemto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitFemto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitFemto(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ZeptoContext extends UnitPrefixContext {
		public Token value;
		public ZeptoContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterZepto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitZepto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitZepto(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NanoContext extends UnitPrefixContext {
		public Token value;
		public NanoContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterNano(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitNano(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitNano(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeciContext extends UnitPrefixContext {
		public Token value;
		public DeciContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterDeci(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitDeci(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitDeci(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GigaContext extends UnitPrefixContext {
		public Token value;
		public GigaContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterGiga(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitGiga(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitGiga(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QuectoContext extends UnitPrefixContext {
		public Token value;
		public QuectoContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterQuecto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitQuecto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitQuecto(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExaContext extends UnitPrefixContext {
		public Token value;
		public ExaContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterExa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitExa(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitExa(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PicoContext extends UnitPrefixContext {
		public Token value;
		public PicoContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterPico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitPico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitPico(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class KiloContext extends UnitPrefixContext {
		public Token value;
		public KiloContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterKilo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitKilo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitKilo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class YoctoContext extends UnitPrefixContext {
		public Token value;
		public YoctoContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterYocto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitYocto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitYocto(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class YottaContext extends UnitPrefixContext {
		public Token value;
		public YottaContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterYotta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitYotta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitYotta(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PetaContext extends UnitPrefixContext {
		public Token value;
		public PetaContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterPeta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitPeta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitPeta(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TeraContext extends UnitPrefixContext {
		public Token value;
		public TeraContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterTera(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitTera(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitTera(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CentiContext extends UnitPrefixContext {
		public Token value;
		public CentiContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterCenti(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitCenti(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitCenti(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HectoContext extends UnitPrefixContext {
		public Token value;
		public HectoContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterHecto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitHecto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitHecto(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MiliContext extends UnitPrefixContext {
		public Token value;
		public MiliContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterMili(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitMili(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitMili(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NoPContext extends UnitPrefixContext {
		public Token value;
		public NoPContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterNoP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitNoP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitNoP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ZettaContext extends UnitPrefixContext {
		public Token value;
		public ZettaContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterZetta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitZetta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitZetta(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecaContext extends UnitPrefixContext {
		public Token value;
		public DecaContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterDeca(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitDeca(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitDeca(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QuettaContext extends UnitPrefixContext {
		public Token value;
		public QuettaContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterQuetta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitQuetta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitQuetta(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MicroContext extends UnitPrefixContext {
		public Token value;
		public MicroContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterMicro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitMicro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitMicro(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RontoContext extends UnitPrefixContext {
		public Token value;
		public RontoContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterRonto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitRonto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitRonto(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RonnaContext extends UnitPrefixContext {
		public Token value;
		public RonnaContext(UnitPrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterRonna(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitRonna(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitRonna(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnitPrefixContext unitPrefix() throws RecognitionException {
		UnitPrefixContext _localctx = new UnitPrefixContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_unitPrefix);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new NoPContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				((NoPContext)_localctx).value = match(T__5);
				}
				break;
			case T__6:
				_localctx = new QuettaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				((QuettaContext)_localctx).value = match(T__6);
				}
				break;
			case T__7:
				_localctx = new RonnaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				((RonnaContext)_localctx).value = match(T__7);
				}
				break;
			case T__8:
				_localctx = new YottaContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(50);
				((YottaContext)_localctx).value = match(T__8);
				}
				break;
			case T__9:
				_localctx = new ZettaContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				((ZettaContext)_localctx).value = match(T__9);
				}
				break;
			case T__10:
				_localctx = new ExaContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(52);
				((ExaContext)_localctx).value = match(T__10);
				}
				break;
			case T__11:
				_localctx = new PetaContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(53);
				((PetaContext)_localctx).value = match(T__11);
				}
				break;
			case T__12:
				_localctx = new TeraContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(54);
				((TeraContext)_localctx).value = match(T__12);
				}
				break;
			case T__13:
				_localctx = new GigaContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(55);
				((GigaContext)_localctx).value = match(T__13);
				}
				break;
			case T__14:
				_localctx = new MegaContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(56);
				((MegaContext)_localctx).value = match(T__14);
				}
				break;
			case T__15:
				_localctx = new KiloContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(57);
				((KiloContext)_localctx).value = match(T__15);
				}
				break;
			case T__16:
				_localctx = new HectoContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(58);
				((HectoContext)_localctx).value = match(T__16);
				}
				break;
			case T__17:
				_localctx = new DecaContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(59);
				((DecaContext)_localctx).value = match(T__17);
				}
				break;
			case T__18:
				_localctx = new DeciContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(60);
				((DeciContext)_localctx).value = match(T__18);
				}
				break;
			case T__19:
				_localctx = new CentiContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(61);
				((CentiContext)_localctx).value = match(T__19);
				}
				break;
			case T__20:
				_localctx = new MiliContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(62);
				((MiliContext)_localctx).value = match(T__20);
				}
				break;
			case T__21:
				_localctx = new MicroContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(63);
				((MicroContext)_localctx).value = match(T__21);
				}
				break;
			case T__22:
				_localctx = new NanoContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(64);
				((NanoContext)_localctx).value = match(T__22);
				}
				break;
			case T__23:
				_localctx = new PicoContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(65);
				((PicoContext)_localctx).value = match(T__23);
				}
				break;
			case T__24:
				_localctx = new FemtoContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(66);
				((FemtoContext)_localctx).value = match(T__24);
				}
				break;
			case T__25:
				_localctx = new AttoContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(67);
				((AttoContext)_localctx).value = match(T__25);
				}
				break;
			case T__26:
				_localctx = new ZeptoContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(68);
				((ZeptoContext)_localctx).value = match(T__26);
				}
				break;
			case T__27:
				_localctx = new YoctoContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(69);
				((YoctoContext)_localctx).value = match(T__27);
				}
				break;
			case T__28:
				_localctx = new RontoContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(70);
				((RontoContext)_localctx).value = match(T__28);
				}
				break;
			case T__29:
				_localctx = new QuectoContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(71);
				((QuectoContext)_localctx).value = match(T__29);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SiTypeContext extends ParserRuleContext {
		public SiTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_siType; }
	 
		public SiTypeContext() { }
		public void copyFrom(SiTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MetreContext extends SiTypeContext {
		public Token value;
		public MetreContext(SiTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterMetre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitMetre(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitMetre(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JouleContext extends SiTypeContext {
		public Token value;
		public JouleContext(SiTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterJoule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitJoule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitJoule(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class KelvinContext extends SiTypeContext {
		public Token value;
		public KelvinContext(SiTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterKelvin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitKelvin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitKelvin(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TonContext extends SiTypeContext {
		public Token value;
		public TonContext(SiTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterTon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitTon(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitTon(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GramContext extends SiTypeContext {
		public Token value;
		public GramContext(SiTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterGram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitGram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitGram(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PascalContext extends SiTypeContext {
		public Token value;
		public PascalContext(SiTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterPascal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitPascal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitPascal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MoleContext extends SiTypeContext {
		public Token value;
		public MoleContext(SiTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterMole(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitMole(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitMole(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CandelaContext extends SiTypeContext {
		public Token value;
		public CandelaContext(SiTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterCandela(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitCandela(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitCandela(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AmpereContext extends SiTypeContext {
		public Token value;
		public AmpereContext(SiTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterAmpere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitAmpere(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitAmpere(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SecondContext extends SiTypeContext {
		public Token value;
		public SecondContext(SiTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).enterSecond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhysicalUnitsListener ) ((PhysicalUnitsListener)listener).exitSecond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhysicalUnitsVisitor ) return ((PhysicalUnitsVisitor<? extends T>)visitor).visitSecond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SiTypeContext siType() throws RecognitionException {
		SiTypeContext _localctx = new SiTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_siType);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				_localctx = new SecondContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				((SecondContext)_localctx).value = match(T__30);
				}
				break;
			case T__20:
				_localctx = new MetreContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				((MetreContext)_localctx).value = match(T__20);
				}
				break;
			case T__31:
				_localctx = new GramContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				((GramContext)_localctx).value = match(T__31);
				}
				break;
			case T__32:
				_localctx = new AmpereContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				((AmpereContext)_localctx).value = match(T__32);
				}
				break;
			case T__33:
				_localctx = new KelvinContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				((KelvinContext)_localctx).value = match(T__33);
				}
				break;
			case T__34:
				_localctx = new MoleContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
				((MoleContext)_localctx).value = match(T__34);
				}
				break;
			case T__35:
				_localctx = new CandelaContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(80);
				((CandelaContext)_localctx).value = match(T__35);
				}
				break;
			case T__36:
				_localctx = new PascalContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(81);
				((PascalContext)_localctx).value = match(T__36);
				}
				break;
			case T__37:
				_localctx = new JouleContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(82);
				((JouleContext)_localctx).value = match(T__37);
				}
				break;
			case T__38:
				_localctx = new TonContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(83);
				((TonContext)_localctx).value = match(T__38);
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
		"\u0004\u00010W\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000\u0012\b\u0000\n\u0000\f\u0000\u0015\t\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u001c\b\u0001\u0001"+
		"\u0001\u0003\u0001\u001f\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002\'\b\u0002\u0001\u0003\u0003"+
		"\u0003*\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005I\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006U\b\u0006\u0001\u0006\u0000\u0000\u0007\u0000\u0002"+
		"\u0004\u0006\b\n\f\u0000\u0000v\u0000\u000e\u0001\u0000\u0000\u0000\u0002"+
		"\u001e\u0001\u0000\u0000\u0000\u0004&\u0001\u0000\u0000\u0000\u0006)\u0001"+
		"\u0000\u0000\u0000\b-\u0001\u0000\u0000\u0000\nH\u0001\u0000\u0000\u0000"+
		"\fT\u0001\u0000\u0000\u0000\u000e\u0013\u0003\u0002\u0001\u0000\u000f"+
		"\u0010\u0005\u0001\u0000\u0000\u0010\u0012\u0003\u0002\u0001\u0000\u0011"+
		"\u000f\u0001\u0000\u0000\u0000\u0012\u0015\u0001\u0000\u0000\u0000\u0013"+
		"\u0011\u0001\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000\u0014"+
		"\u0001\u0001\u0000\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0016"+
		"\u001b\u0003\u0004\u0002\u0000\u0017\u0018\u0005\u0002\u0000\u0000\u0018"+
		"\u001c\u0003\u0004\u0002\u0000\u0019\u001a\u0005\u0003\u0000\u0000\u001a"+
		"\u001c\u0005+\u0000\u0000\u001b\u0017\u0001\u0000\u0000\u0000\u001b\u0019"+
		"\u0001\u0000\u0000\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d\u001f"+
		"\u0003\u0004\u0002\u0000\u001e\u0016\u0001\u0000\u0000\u0000\u001e\u001d"+
		"\u0001\u0000\u0000\u0000\u001f\u0003\u0001\u0000\u0000\u0000 \'\u0003"+
		"\u0006\u0003\u0000!\'\u0003\b\u0004\u0000\"#\u0005\u0004\u0000\u0000#"+
		"$\u0003\u0000\u0000\u0000$%\u0005\u0005\u0000\u0000%\'\u0001\u0000\u0000"+
		"\u0000& \u0001\u0000\u0000\u0000&!\u0001\u0000\u0000\u0000&\"\u0001\u0000"+
		"\u0000\u0000\'\u0005\u0001\u0000\u0000\u0000(*\u0003\n\u0005\u0000)(\u0001"+
		"\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000"+
		"+,\u0003\f\u0006\u0000,\u0007\u0001\u0000\u0000\u0000-.\u0005)\u0000\u0000"+
		".\t\u0001\u0000\u0000\u0000/I\u0005\u0006\u0000\u00000I\u0005\u0007\u0000"+
		"\u00001I\u0005\b\u0000\u00002I\u0005\t\u0000\u00003I\u0005\n\u0000\u0000"+
		"4I\u0005\u000b\u0000\u00005I\u0005\f\u0000\u00006I\u0005\r\u0000\u0000"+
		"7I\u0005\u000e\u0000\u00008I\u0005\u000f\u0000\u00009I\u0005\u0010\u0000"+
		"\u0000:I\u0005\u0011\u0000\u0000;I\u0005\u0012\u0000\u0000<I\u0005\u0013"+
		"\u0000\u0000=I\u0005\u0014\u0000\u0000>I\u0005\u0015\u0000\u0000?I\u0005"+
		"\u0016\u0000\u0000@I\u0005\u0017\u0000\u0000AI\u0005\u0018\u0000\u0000"+
		"BI\u0005\u0019\u0000\u0000CI\u0005\u001a\u0000\u0000DI\u0005\u001b\u0000"+
		"\u0000EI\u0005\u001c\u0000\u0000FI\u0005\u001d\u0000\u0000GI\u0005\u001e"+
		"\u0000\u0000H/\u0001\u0000\u0000\u0000H0\u0001\u0000\u0000\u0000H1\u0001"+
		"\u0000\u0000\u0000H2\u0001\u0000\u0000\u0000H3\u0001\u0000\u0000\u0000"+
		"H4\u0001\u0000\u0000\u0000H5\u0001\u0000\u0000\u0000H6\u0001\u0000\u0000"+
		"\u0000H7\u0001\u0000\u0000\u0000H8\u0001\u0000\u0000\u0000H9\u0001\u0000"+
		"\u0000\u0000H:\u0001\u0000\u0000\u0000H;\u0001\u0000\u0000\u0000H<\u0001"+
		"\u0000\u0000\u0000H=\u0001\u0000\u0000\u0000H>\u0001\u0000\u0000\u0000"+
		"H?\u0001\u0000\u0000\u0000H@\u0001\u0000\u0000\u0000HA\u0001\u0000\u0000"+
		"\u0000HB\u0001\u0000\u0000\u0000HC\u0001\u0000\u0000\u0000HD\u0001\u0000"+
		"\u0000\u0000HE\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HG\u0001"+
		"\u0000\u0000\u0000I\u000b\u0001\u0000\u0000\u0000JU\u0005\u001f\u0000"+
		"\u0000KU\u0005\u0015\u0000\u0000LU\u0005 \u0000\u0000MU\u0005!\u0000\u0000"+
		"NU\u0005\"\u0000\u0000OU\u0005#\u0000\u0000PU\u0005$\u0000\u0000QU\u0005"+
		"%\u0000\u0000RU\u0005&\u0000\u0000SU\u0005\'\u0000\u0000TJ\u0001\u0000"+
		"\u0000\u0000TK\u0001\u0000\u0000\u0000TL\u0001\u0000\u0000\u0000TM\u0001"+
		"\u0000\u0000\u0000TN\u0001\u0000\u0000\u0000TO\u0001\u0000\u0000\u0000"+
		"TP\u0001\u0000\u0000\u0000TQ\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000"+
		"\u0000TS\u0001\u0000\u0000\u0000U\r\u0001\u0000\u0000\u0000\u0007\u0013"+
		"\u001b\u001e&)HT";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}