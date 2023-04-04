// Generated from e:\amack\Documents\UNI\Hiwi\antlr4-python\grammars\CP-DSL\Declaration.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DeclarationParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, ELONG=61, EDOUBLE=62, EBoolean=63, ID=64, INT=65, STRING=66, 
		ML_COMMENT=67, SL_COMMENT=68, ANY_OTHER=69;
	public static final int
		RULE_declarationModel = 0, RULE_namedElement = 1, RULE_parameterGroupDeclaration = 2, 
		RULE_parameterDeclaration = 3, RULE_featureDeclaration = 4, RULE_featureGroupDeclaration = 5, 
		RULE_eKind = 6, RULE_paramType = 7, RULE_inlineEnumerationType = 8, RULE_typeReference = 9, 
		RULE_arrayType = 10, RULE_dimension = 11, RULE_sizeDimension = 12, RULE_rangeDimension = 13, 
		RULE_declaredType = 14, RULE_rangeType = 15, RULE_enumerationType = 16, 
		RULE_enumeral = 17, RULE_unitSpecification = 18, RULE_basicUnit = 19, 
		RULE_sIUnit = 20, RULE_customUnit = 21, RULE_composedUnit = 22, RULE_ePrefix = 23, 
		RULE_eSIUnitType = 24, RULE_arithmeticExpression = 25, RULE_eAdditionOperator = 26, 
		RULE_multiplicationExpression = 27, RULE_eMultiplicationOperator = 28, 
		RULE_valueExpression = 29, RULE_literalExpression = 30, RULE_literal = 31, 
		RULE_parenthesisExpression = 32, RULE_arrayExpression = 33, RULE_namedElementReference = 34, 
		RULE_stringValue = 35, RULE_longValue = 36, RULE_doubleValue = 37, RULE_booleanValue = 38;
	private static String[] makeRuleNames() {
		return new String[] {
			"declarationModel", "namedElement", "parameterGroupDeclaration", "parameterDeclaration", 
			"featureDeclaration", "featureGroupDeclaration", "eKind", "paramType", 
			"inlineEnumerationType", "typeReference", "arrayType", "dimension", "sizeDimension", 
			"rangeDimension", "declaredType", "rangeType", "enumerationType", "enumeral", 
			"unitSpecification", "basicUnit", "sIUnit", "customUnit", "composedUnit", 
			"ePrefix", "eSIUnitType", "arithmeticExpression", "eAdditionOperator", 
			"multiplicationExpression", "eMultiplicationOperator", "valueExpression", 
			"literalExpression", "literal", "parenthesisExpression", "arrayExpression", 
			"namedElementReference", "stringValue", "longValue", "doubleValue", "booleanValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'model'", "'types'", "'group'", "':'", "'{'", "'}'", "'def'", 
			"','", "'='", "'required'", "'feature'", "'requires'", "'excludes'", 
			"'sub'", "'alternative'", "'multiple'", "'('", "')'", "'['", "']'", "'range'", 
			"'enum'", "'*'", "'/'", "'**'", "'noP'", "'yotta'", "'zetta'", "'exa'", 
			"'peta'", "'tera'", "'giga'", "'mega'", "'kilo'", "'hecto'", "'deca'", 
			"'deci'", "'centi'", "'mili'", "'micro'", "'nano'", "'pico'", "'femto'", 
			"'atto'", "'zepto'", "'yocto'", "'meter'", "'gram'", "'ton'", "'second'", 
			"'ampere'", "'kelvin'", "'mole'", "'candela'", "'pascal'", "'Joul'", 
			"'+'", "'-'", "'%'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ELONG", "EDOUBLE", "EBoolean", "ID", "INT", "STRING", "ML_COMMENT", 
			"SL_COMMENT", "ANY_OTHER"
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
	public String getGrammarFileName() { return "Declaration.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DeclarationParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class DeclarationModelContext extends ParserRuleContext {
		public Token name;
		public DeclaredTypeContext declaredType;
		public List<DeclaredTypeContext> types = new ArrayList<DeclaredTypeContext>();
		public ParameterGroupDeclarationContext parameterGroupDeclaration;
		public List<ParameterGroupDeclarationContext> parameterGroupDeclarations = new ArrayList<ParameterGroupDeclarationContext>();
		public FeatureDeclarationContext featureDeclaration;
		public List<FeatureDeclarationContext> featureDeclarations = new ArrayList<FeatureDeclarationContext>();
		public TerminalNode ID() { return getToken(DeclarationParser.ID, 0); }
		public List<ParameterGroupDeclarationContext> parameterGroupDeclaration() {
			return getRuleContexts(ParameterGroupDeclarationContext.class);
		}
		public ParameterGroupDeclarationContext parameterGroupDeclaration(int i) {
			return getRuleContext(ParameterGroupDeclarationContext.class,i);
		}
		public List<FeatureDeclarationContext> featureDeclaration() {
			return getRuleContexts(FeatureDeclarationContext.class);
		}
		public FeatureDeclarationContext featureDeclaration(int i) {
			return getRuleContext(FeatureDeclarationContext.class,i);
		}
		public List<DeclaredTypeContext> declaredType() {
			return getRuleContexts(DeclaredTypeContext.class);
		}
		public DeclaredTypeContext declaredType(int i) {
			return getRuleContext(DeclaredTypeContext.class,i);
		}
		public DeclarationModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationModel; }
	}

	public final DeclarationModelContext declarationModel() throws RecognitionException {
		DeclarationModelContext _localctx = new DeclarationModelContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_declarationModel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__0);
			setState(79);
			((DeclarationModelContext)_localctx).name = match(ID);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(80);
				match(T__1);
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__20 || _la==T__21) {
					{
					{
					setState(81);
					((DeclarationModelContext)_localctx).declaredType = declaredType();
					((DeclarationModelContext)_localctx).types.add(((DeclarationModelContext)_localctx).declaredType);
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__9) | (1L << T__10))) != 0)) {
				{
				setState(91);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(89);
					((DeclarationModelContext)_localctx).parameterGroupDeclaration = parameterGroupDeclaration();
					((DeclarationModelContext)_localctx).parameterGroupDeclarations.add(((DeclarationModelContext)_localctx).parameterGroupDeclaration);
					}
					break;
				case T__9:
				case T__10:
					{
					setState(90);
					((DeclarationModelContext)_localctx).featureDeclaration = featureDeclaration();
					((DeclarationModelContext)_localctx).featureDeclarations.add(((DeclarationModelContext)_localctx).featureDeclaration);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(95);
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

	public static class NamedElementContext extends ParserRuleContext {
		public ParameterDeclarationContext parameterDeclaration() {
			return getRuleContext(ParameterDeclarationContext.class,0);
		}
		public ParameterGroupDeclarationContext parameterGroupDeclaration() {
			return getRuleContext(ParameterGroupDeclarationContext.class,0);
		}
		public FeatureDeclarationContext featureDeclaration() {
			return getRuleContext(FeatureDeclarationContext.class,0);
		}
		public NamedElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedElement; }
	}

	public final NamedElementContext namedElement() throws RecognitionException {
		NamedElementContext _localctx = new NamedElementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_namedElement);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				parameterDeclaration();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				parameterGroupDeclaration();
				}
				break;
			case T__9:
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				featureDeclaration();
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

	public static class ParameterGroupDeclarationContext extends ParserRuleContext {
		public ParameterGroupDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterGroupDeclaration; }
	 
		public ParameterGroupDeclarationContext() { }
		public void copyFrom(ParameterGroupDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParamGroupAssignStatContext extends ParameterGroupDeclarationContext {
		public Token name;
		public Token description;
		public ParameterDeclarationContext parameterDeclaration;
		public List<ParameterDeclarationContext> parameterDeclarations = new ArrayList<ParameterDeclarationContext>();
		public TerminalNode ID() { return getToken(DeclarationParser.ID, 0); }
		public TerminalNode STRING() { return getToken(DeclarationParser.STRING, 0); }
		public List<ParameterDeclarationContext> parameterDeclaration() {
			return getRuleContexts(ParameterDeclarationContext.class);
		}
		public ParameterDeclarationContext parameterDeclaration(int i) {
			return getRuleContext(ParameterDeclarationContext.class,i);
		}
		public ParamGroupAssignStatContext(ParameterGroupDeclarationContext ctx) { copyFrom(ctx); }
	}

	public final ParameterGroupDeclarationContext parameterGroupDeclaration() throws RecognitionException {
		ParameterGroupDeclarationContext _localctx = new ParameterGroupDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_parameterGroupDeclaration);
		int _la;
		try {
			_localctx = new ParamGroupAssignStatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(T__2);
			setState(102);
			((ParamGroupAssignStatContext)_localctx).name = match(ID);
			setState(103);
			match(T__3);
			setState(104);
			((ParamGroupAssignStatContext)_localctx).description = match(STRING);
			setState(105);
			match(T__4);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(106);
				((ParamGroupAssignStatContext)_localctx).parameterDeclaration = parameterDeclaration();
				((ParamGroupAssignStatContext)_localctx).parameterDeclarations.add(((ParamGroupAssignStatContext)_localctx).parameterDeclaration);
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112);
			match(T__5);
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

	public static class ParameterDeclarationContext extends ParserRuleContext {
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
	 
		public ParameterDeclarationContext() { }
		public void copyFrom(ParameterDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParamAssignStatContext extends ParameterDeclarationContext {
		public Token name;
		public ParamTypeContext type;
		public UnitSpecificationContext unit;
		public Token description;
		public ArithmeticExpressionContext defaultValue;
		public TerminalNode ID() { return getToken(DeclarationParser.ID, 0); }
		public ParamTypeContext paramType() {
			return getRuleContext(ParamTypeContext.class,0);
		}
		public UnitSpecificationContext unitSpecification() {
			return getRuleContext(UnitSpecificationContext.class,0);
		}
		public TerminalNode STRING() { return getToken(DeclarationParser.STRING, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public ParamAssignStatContext(ParameterDeclarationContext ctx) { copyFrom(ctx); }
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parameterDeclaration);
		int _la;
		try {
			_localctx = new ParamAssignStatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__6);
			setState(115);
			((ParamAssignStatContext)_localctx).name = match(ID);
			setState(116);
			((ParamAssignStatContext)_localctx).type = paramType();
			setState(117);
			match(T__3);
			setState(118);
			((ParamAssignStatContext)_localctx).unit = unitSpecification();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(119);
				match(T__7);
				setState(120);
				((ParamAssignStatContext)_localctx).description = match(STRING);
				}
			}

			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(123);
				match(T__8);
				setState(124);
				((ParamAssignStatContext)_localctx).defaultValue = arithmeticExpression();
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

	public static class FeatureDeclarationContext extends ParserRuleContext {
		public FeatureDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureDeclaration; }
	 
		public FeatureDeclarationContext() { }
		public void copyFrom(FeatureDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FeatureAssignStatContext extends FeatureDeclarationContext {
		public Token required;
		public Token name;
		public Token description;
		public Token ID;
		public List<Token> requires = new ArrayList<Token>();
		public List<Token> excludes = new ArrayList<Token>();
		public ParameterGroupDeclarationContext parameterGroupDeclaration;
		public List<ParameterGroupDeclarationContext> parameterGroupDeclarations = new ArrayList<ParameterGroupDeclarationContext>();
		public FeatureGroupDeclarationContext featureGroupDeclaration;
		public List<FeatureGroupDeclarationContext> featureGroupDeclarations = new ArrayList<FeatureGroupDeclarationContext>();
		public List<TerminalNode> ID() { return getTokens(DeclarationParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DeclarationParser.ID, i);
		}
		public TerminalNode STRING() { return getToken(DeclarationParser.STRING, 0); }
		public List<ParameterGroupDeclarationContext> parameterGroupDeclaration() {
			return getRuleContexts(ParameterGroupDeclarationContext.class);
		}
		public ParameterGroupDeclarationContext parameterGroupDeclaration(int i) {
			return getRuleContext(ParameterGroupDeclarationContext.class,i);
		}
		public List<FeatureGroupDeclarationContext> featureGroupDeclaration() {
			return getRuleContexts(FeatureGroupDeclarationContext.class);
		}
		public FeatureGroupDeclarationContext featureGroupDeclaration(int i) {
			return getRuleContext(FeatureGroupDeclarationContext.class,i);
		}
		public FeatureAssignStatContext(FeatureDeclarationContext ctx) { copyFrom(ctx); }
	}

	public final FeatureDeclarationContext featureDeclaration() throws RecognitionException {
		FeatureDeclarationContext _localctx = new FeatureDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_featureDeclaration);
		int _la;
		try {
			_localctx = new FeatureAssignStatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(127);
				((FeatureAssignStatContext)_localctx).required = match(T__9);
				}
			}

			setState(130);
			match(T__10);
			setState(131);
			((FeatureAssignStatContext)_localctx).name = match(ID);
			setState(132);
			match(T__3);
			setState(133);
			((FeatureAssignStatContext)_localctx).description = match(STRING);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(134);
				match(T__4);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(135);
					match(T__11);
					setState(136);
					((FeatureAssignStatContext)_localctx).ID = match(ID);
					((FeatureAssignStatContext)_localctx).requires.add(((FeatureAssignStatContext)_localctx).ID);
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(142);
					match(T__12);
					setState(143);
					((FeatureAssignStatContext)_localctx).ID = match(ID);
					((FeatureAssignStatContext)_localctx).excludes.add(((FeatureAssignStatContext)_localctx).ID);
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2 || _la==T__13) {
					{
					setState(151);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__2:
						{
						setState(149);
						((FeatureAssignStatContext)_localctx).parameterGroupDeclaration = parameterGroupDeclaration();
						((FeatureAssignStatContext)_localctx).parameterGroupDeclarations.add(((FeatureAssignStatContext)_localctx).parameterGroupDeclaration);
						}
						break;
					case T__13:
						{
						setState(150);
						((FeatureAssignStatContext)_localctx).featureGroupDeclaration = featureGroupDeclaration();
						((FeatureAssignStatContext)_localctx).featureGroupDeclarations.add(((FeatureAssignStatContext)_localctx).featureGroupDeclaration);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(156);
				match(T__5);
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

	public static class FeatureGroupDeclarationContext extends ParserRuleContext {
		public FeatureGroupDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureGroupDeclaration; }
	 
		public FeatureGroupDeclarationContext() { }
		public void copyFrom(FeatureGroupDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FeatureGroupAssignStatContext extends FeatureGroupDeclarationContext {
		public EKindContext kind;
		public FeatureDeclarationContext featureDeclaration;
		public List<FeatureDeclarationContext> featureDeclarations = new ArrayList<FeatureDeclarationContext>();
		public EKindContext eKind() {
			return getRuleContext(EKindContext.class,0);
		}
		public List<FeatureDeclarationContext> featureDeclaration() {
			return getRuleContexts(FeatureDeclarationContext.class);
		}
		public FeatureDeclarationContext featureDeclaration(int i) {
			return getRuleContext(FeatureDeclarationContext.class,i);
		}
		public FeatureGroupAssignStatContext(FeatureGroupDeclarationContext ctx) { copyFrom(ctx); }
	}

	public final FeatureGroupDeclarationContext featureGroupDeclaration() throws RecognitionException {
		FeatureGroupDeclarationContext _localctx = new FeatureGroupDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_featureGroupDeclaration);
		int _la;
		try {
			_localctx = new FeatureGroupAssignStatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__13);
			setState(160);
			((FeatureGroupAssignStatContext)_localctx).kind = eKind();
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9 || _la==T__10) {
				{
				{
				setState(161);
				((FeatureGroupAssignStatContext)_localctx).featureDeclaration = featureDeclaration();
				((FeatureGroupAssignStatContext)_localctx).featureDeclarations.add(((FeatureGroupAssignStatContext)_localctx).featureDeclaration);
				}
				}
				setState(166);
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

	public static class EKindContext extends ParserRuleContext {
		public Token alternative;
		public Token multiple;
		public EKindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eKind; }
	}

	public final EKindContext eKind() throws RecognitionException {
		EKindContext _localctx = new EKindContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_eKind);
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				((EKindContext)_localctx).alternative = match(T__14);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				((EKindContext)_localctx).multiple = match(T__15);
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

	public static class ParamTypeContext extends ParserRuleContext {
		public TypeReferenceContext typeReference() {
			return getRuleContext(TypeReferenceContext.class,0);
		}
		public InlineEnumerationTypeContext inlineEnumerationType() {
			return getRuleContext(InlineEnumerationTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public ParamTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramType; }
	}

	public final ParamTypeContext paramType() throws RecognitionException {
		ParamTypeContext _localctx = new ParamTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_paramType);
		try {
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				typeReference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				inlineEnumerationType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				arrayType();
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

	public static class InlineEnumerationTypeContext extends ParserRuleContext {
		public EnumeralContext enumeral;
		public List<EnumeralContext> values = new ArrayList<EnumeralContext>();
		public List<EnumeralContext> enumeral() {
			return getRuleContexts(EnumeralContext.class);
		}
		public EnumeralContext enumeral(int i) {
			return getRuleContext(EnumeralContext.class,i);
		}
		public InlineEnumerationTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineEnumerationType; }
	}

	public final InlineEnumerationTypeContext inlineEnumerationType() throws RecognitionException {
		InlineEnumerationTypeContext _localctx = new InlineEnumerationTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_inlineEnumerationType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(T__16);
			setState(177);
			((InlineEnumerationTypeContext)_localctx).enumeral = enumeral();
			((InlineEnumerationTypeContext)_localctx).values.add(((InlineEnumerationTypeContext)_localctx).enumeral);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(178);
				match(T__7);
				setState(179);
				((InlineEnumerationTypeContext)_localctx).enumeral = enumeral();
				((InlineEnumerationTypeContext)_localctx).values.add(((InlineEnumerationTypeContext)_localctx).enumeral);
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
			match(T__17);
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

	public static class TypeReferenceContext extends ParserRuleContext {
		public Token type;
		public TerminalNode ID() { return getToken(DeclarationParser.ID, 0); }
		public TypeReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeReference; }
	}

	public final TypeReferenceContext typeReference() throws RecognitionException {
		TypeReferenceContext _localctx = new TypeReferenceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typeReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			((TypeReferenceContext)_localctx).type = match(ID);
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

	public static class ArrayTypeContext extends ParserRuleContext {
		public Token type;
		public DimensionContext dimension;
		public List<DimensionContext> dimensions = new ArrayList<DimensionContext>();
		public TerminalNode ID() { return getToken(DeclarationParser.ID, 0); }
		public List<DimensionContext> dimension() {
			return getRuleContexts(DimensionContext.class);
		}
		public DimensionContext dimension(int i) {
			return getRuleContext(DimensionContext.class,i);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arrayType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			((ArrayTypeContext)_localctx).type = match(ID);
			setState(190);
			match(T__18);
			setState(191);
			((ArrayTypeContext)_localctx).dimension = dimension();
			((ArrayTypeContext)_localctx).dimensions.add(((ArrayTypeContext)_localctx).dimension);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(192);
				match(T__7);
				setState(193);
				((ArrayTypeContext)_localctx).dimension = dimension();
				((ArrayTypeContext)_localctx).dimensions.add(((ArrayTypeContext)_localctx).dimension);
				}
				}
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(199);
			match(T__19);
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

	public static class DimensionContext extends ParserRuleContext {
		public SizeDimensionContext sizeDimension() {
			return getRuleContext(SizeDimensionContext.class,0);
		}
		public RangeDimensionContext rangeDimension() {
			return getRuleContext(RangeDimensionContext.class,0);
		}
		public DimensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimension; }
	}

	public final DimensionContext dimension() throws RecognitionException {
		DimensionContext _localctx = new DimensionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_dimension);
		try {
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				sizeDimension();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				rangeDimension();
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

	public static class SizeDimensionContext extends ParserRuleContext {
		public Token size;
		public TerminalNode ELONG() { return getToken(DeclarationParser.ELONG, 0); }
		public SizeDimensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sizeDimension; }
	}

	public final SizeDimensionContext sizeDimension() throws RecognitionException {
		SizeDimensionContext _localctx = new SizeDimensionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sizeDimension);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELONG) {
				{
				setState(205);
				((SizeDimensionContext)_localctx).size = match(ELONG);
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

	public static class RangeDimensionContext extends ParserRuleContext {
		public Token lowerBound;
		public Token upperBound;
		public List<TerminalNode> ELONG() { return getTokens(DeclarationParser.ELONG); }
		public TerminalNode ELONG(int i) {
			return getToken(DeclarationParser.ELONG, i);
		}
		public RangeDimensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeDimension; }
	}

	public final RangeDimensionContext rangeDimension() throws RecognitionException {
		RangeDimensionContext _localctx = new RangeDimensionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_rangeDimension);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELONG) {
				{
				setState(208);
				((RangeDimensionContext)_localctx).lowerBound = match(ELONG);
				}
			}

			setState(211);
			match(T__3);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELONG) {
				{
				setState(212);
				((RangeDimensionContext)_localctx).upperBound = match(ELONG);
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

	public static class DeclaredTypeContext extends ParserRuleContext {
		public RangeTypeContext rangeType() {
			return getRuleContext(RangeTypeContext.class,0);
		}
		public EnumerationTypeContext enumerationType() {
			return getRuleContext(EnumerationTypeContext.class,0);
		}
		public DeclaredTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaredType; }
	}

	public final DeclaredTypeContext declaredType() throws RecognitionException {
		DeclaredTypeContext _localctx = new DeclaredTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_declaredType);
		try {
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				rangeType();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				enumerationType();
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

	public static class RangeTypeContext extends ParserRuleContext {
		public Token name;
		public Token type;
		public LiteralContext minimum;
		public LiteralContext maximum;
		public List<TerminalNode> ID() { return getTokens(DeclarationParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DeclarationParser.ID, i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public RangeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeType; }
	}

	public final RangeTypeContext rangeType() throws RecognitionException {
		RangeTypeContext _localctx = new RangeTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_rangeType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(T__20);
			setState(220);
			((RangeTypeContext)_localctx).name = match(ID);
			setState(221);
			((RangeTypeContext)_localctx).type = match(ID);
			setState(222);
			match(T__18);
			setState(223);
			((RangeTypeContext)_localctx).minimum = literal();
			setState(224);
			match(T__3);
			setState(225);
			((RangeTypeContext)_localctx).maximum = literal();
			setState(226);
			match(T__19);
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

	public static class EnumerationTypeContext extends ParserRuleContext {
		public Token name;
		public EnumeralContext enumeral;
		public List<EnumeralContext> values = new ArrayList<EnumeralContext>();
		public TerminalNode ID() { return getToken(DeclarationParser.ID, 0); }
		public List<EnumeralContext> enumeral() {
			return getRuleContexts(EnumeralContext.class);
		}
		public EnumeralContext enumeral(int i) {
			return getRuleContext(EnumeralContext.class,i);
		}
		public EnumerationTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerationType; }
	}

	public final EnumerationTypeContext enumerationType() throws RecognitionException {
		EnumerationTypeContext _localctx = new EnumerationTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_enumerationType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(T__21);
			setState(229);
			((EnumerationTypeContext)_localctx).name = match(ID);
			setState(230);
			match(T__4);
			setState(231);
			((EnumerationTypeContext)_localctx).enumeral = enumeral();
			((EnumerationTypeContext)_localctx).values.add(((EnumerationTypeContext)_localctx).enumeral);
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(232);
				match(T__7);
				setState(233);
				((EnumerationTypeContext)_localctx).enumeral = enumeral();
				((EnumerationTypeContext)_localctx).values.add(((EnumerationTypeContext)_localctx).enumeral);
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(239);
			match(T__5);
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

	public static class EnumeralContext extends ParserRuleContext {
		public Token name;
		public Token value;
		public TerminalNode ID() { return getToken(DeclarationParser.ID, 0); }
		public TerminalNode ELONG() { return getToken(DeclarationParser.ELONG, 0); }
		public EnumeralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeral; }
	}

	public final EnumeralContext enumeral() throws RecognitionException {
		EnumeralContext _localctx = new EnumeralContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_enumeral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			((EnumeralContext)_localctx).name = match(ID);
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(242);
				match(T__8);
				setState(243);
				((EnumeralContext)_localctx).value = match(ELONG);
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

	public static class UnitSpecificationContext extends ParserRuleContext {
		public ComposedUnitContext composedUnit;
		public List<ComposedUnitContext> units = new ArrayList<ComposedUnitContext>();
		public List<ComposedUnitContext> composedUnit() {
			return getRuleContexts(ComposedUnitContext.class);
		}
		public ComposedUnitContext composedUnit(int i) {
			return getRuleContext(ComposedUnitContext.class,i);
		}
		public UnitSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unitSpecification; }
	}

	public final UnitSpecificationContext unitSpecification() throws RecognitionException {
		UnitSpecificationContext _localctx = new UnitSpecificationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_unitSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			((UnitSpecificationContext)_localctx).composedUnit = composedUnit();
			((UnitSpecificationContext)_localctx).units.add(((UnitSpecificationContext)_localctx).composedUnit);
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(247);
				match(T__22);
				setState(248);
				((UnitSpecificationContext)_localctx).composedUnit = composedUnit();
				((UnitSpecificationContext)_localctx).units.add(((UnitSpecificationContext)_localctx).composedUnit);
				}
				}
				setState(253);
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

	public static class BasicUnitContext extends ParserRuleContext {
		public SIUnitContext sIUnit() {
			return getRuleContext(SIUnitContext.class,0);
		}
		public CustomUnitContext customUnit() {
			return getRuleContext(CustomUnitContext.class,0);
		}
		public UnitSpecificationContext unitSpecification() {
			return getRuleContext(UnitSpecificationContext.class,0);
		}
		public BasicUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicUnit; }
	}

	public final BasicUnitContext basicUnit() throws RecognitionException {
		BasicUnitContext _localctx = new BasicUnitContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_basicUnit);
		try {
			setState(260);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
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
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				sIUnit();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				customUnit();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				match(T__16);
				setState(257);
				unitSpecification();
				setState(258);
				match(T__17);
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

	public static class SIUnitContext extends ParserRuleContext {
		public EPrefixContext prefix;
		public ESIUnitTypeContext type;
		public ESIUnitTypeContext eSIUnitType() {
			return getRuleContext(ESIUnitTypeContext.class,0);
		}
		public EPrefixContext ePrefix() {
			return getRuleContext(EPrefixContext.class,0);
		}
		public SIUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sIUnit; }
	}

	public final SIUnitContext sIUnit() throws RecognitionException {
		SIUnitContext _localctx = new SIUnitContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sIUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) {
				{
				setState(262);
				((SIUnitContext)_localctx).prefix = ePrefix();
				}
			}

			setState(265);
			((SIUnitContext)_localctx).type = eSIUnitType();
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

	public static class CustomUnitContext extends ParserRuleContext {
		public Token name;
		public TerminalNode STRING() { return getToken(DeclarationParser.STRING, 0); }
		public CustomUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_customUnit; }
	}

	public final CustomUnitContext customUnit() throws RecognitionException {
		CustomUnitContext _localctx = new CustomUnitContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_customUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
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

	public static class ComposedUnitContext extends ParserRuleContext {
		public BasicUnitContext numerator;
		public BasicUnitContext denominator;
		public Token exponent;
		public List<BasicUnitContext> basicUnit() {
			return getRuleContexts(BasicUnitContext.class);
		}
		public BasicUnitContext basicUnit(int i) {
			return getRuleContext(BasicUnitContext.class,i);
		}
		public TerminalNode ELONG() { return getToken(DeclarationParser.ELONG, 0); }
		public ComposedUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composedUnit; }
	}

	public final ComposedUnitContext composedUnit() throws RecognitionException {
		ComposedUnitContext _localctx = new ComposedUnitContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_composedUnit);
		try {
			setState(277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				((ComposedUnitContext)_localctx).numerator = basicUnit();
				setState(274);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__23:
					{
					{
					setState(270);
					match(T__23);
					setState(271);
					((ComposedUnitContext)_localctx).denominator = basicUnit();
					}
					}
					break;
				case T__24:
					{
					{
					setState(272);
					match(T__24);
					setState(273);
					((ComposedUnitContext)_localctx).exponent = match(ELONG);
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
				setState(276);
				basicUnit();
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

	public static class EPrefixContext extends ParserRuleContext {
		public Token noP;
		public Token yotta;
		public Token zetta;
		public Token exa;
		public Token peta;
		public Token tera;
		public Token giga;
		public Token mega;
		public Token kilo;
		public Token hecto;
		public Token deca;
		public Token deci;
		public Token centi;
		public Token mili;
		public Token micro;
		public Token nano;
		public Token pico;
		public Token femto;
		public Token atto;
		public Token zepto;
		public Token yocto;
		public EPrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ePrefix; }
	}

	public final EPrefixContext ePrefix() throws RecognitionException {
		EPrefixContext _localctx = new EPrefixContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_ePrefix);
		try {
			setState(300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				((EPrefixContext)_localctx).noP = match(T__25);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 2);
				{
				setState(280);
				((EPrefixContext)_localctx).yotta = match(T__26);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 3);
				{
				setState(281);
				((EPrefixContext)_localctx).zetta = match(T__27);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 4);
				{
				setState(282);
				((EPrefixContext)_localctx).exa = match(T__28);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 5);
				{
				setState(283);
				((EPrefixContext)_localctx).peta = match(T__29);
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 6);
				{
				setState(284);
				((EPrefixContext)_localctx).tera = match(T__30);
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 7);
				{
				setState(285);
				((EPrefixContext)_localctx).giga = match(T__31);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 8);
				{
				setState(286);
				((EPrefixContext)_localctx).mega = match(T__32);
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 9);
				{
				setState(287);
				((EPrefixContext)_localctx).kilo = match(T__33);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 10);
				{
				setState(288);
				((EPrefixContext)_localctx).hecto = match(T__34);
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 11);
				{
				setState(289);
				((EPrefixContext)_localctx).deca = match(T__35);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 12);
				{
				setState(290);
				((EPrefixContext)_localctx).deci = match(T__36);
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 13);
				{
				setState(291);
				((EPrefixContext)_localctx).centi = match(T__37);
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 14);
				{
				setState(292);
				((EPrefixContext)_localctx).mili = match(T__38);
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 15);
				{
				setState(293);
				((EPrefixContext)_localctx).micro = match(T__39);
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 16);
				{
				setState(294);
				((EPrefixContext)_localctx).nano = match(T__40);
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 17);
				{
				setState(295);
				((EPrefixContext)_localctx).pico = match(T__41);
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 18);
				{
				setState(296);
				((EPrefixContext)_localctx).femto = match(T__42);
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 19);
				{
				setState(297);
				((EPrefixContext)_localctx).atto = match(T__43);
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 20);
				{
				setState(298);
				((EPrefixContext)_localctx).zepto = match(T__44);
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 21);
				{
				setState(299);
				((EPrefixContext)_localctx).yocto = match(T__45);
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

	public static class ESIUnitTypeContext extends ParserRuleContext {
		public Token meter;
		public Token gram;
		public Token ton;
		public Token second;
		public Token ampere;
		public Token kelvin;
		public Token mole;
		public Token candela;
		public Token pascal;
		public Token joul;
		public ESIUnitTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eSIUnitType; }
	}

	public final ESIUnitTypeContext eSIUnitType() throws RecognitionException {
		ESIUnitTypeContext _localctx = new ESIUnitTypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_eSIUnitType);
		try {
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__46:
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				((ESIUnitTypeContext)_localctx).meter = match(T__46);
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				((ESIUnitTypeContext)_localctx).gram = match(T__47);
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 3);
				{
				setState(304);
				((ESIUnitTypeContext)_localctx).ton = match(T__48);
				}
				break;
			case T__49:
				enterOuterAlt(_localctx, 4);
				{
				setState(305);
				((ESIUnitTypeContext)_localctx).second = match(T__49);
				}
				break;
			case T__50:
				enterOuterAlt(_localctx, 5);
				{
				setState(306);
				((ESIUnitTypeContext)_localctx).ampere = match(T__50);
				}
				break;
			case T__51:
				enterOuterAlt(_localctx, 6);
				{
				setState(307);
				((ESIUnitTypeContext)_localctx).kelvin = match(T__51);
				}
				break;
			case T__52:
				enterOuterAlt(_localctx, 7);
				{
				setState(308);
				((ESIUnitTypeContext)_localctx).mole = match(T__52);
				}
				break;
			case T__53:
				enterOuterAlt(_localctx, 8);
				{
				setState(309);
				((ESIUnitTypeContext)_localctx).candela = match(T__53);
				}
				break;
			case T__54:
				enterOuterAlt(_localctx, 9);
				{
				setState(310);
				((ESIUnitTypeContext)_localctx).pascal = match(T__54);
				}
				break;
			case T__55:
				enterOuterAlt(_localctx, 10);
				{
				setState(311);
				((ESIUnitTypeContext)_localctx).joul = match(T__55);
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

	public static class ArithmeticExpressionContext extends ParserRuleContext {
		public MultiplicationExpressionContext left;
		public EAdditionOperatorContext op;
		public ArithmeticExpressionContext right;
		public MultiplicationExpressionContext multiplicationExpression() {
			return getRuleContext(MultiplicationExpressionContext.class,0);
		}
		public EAdditionOperatorContext eAdditionOperator() {
			return getRuleContext(EAdditionOperatorContext.class,0);
		}
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public ArithmeticExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticExpression; }
	}

	public final ArithmeticExpressionContext arithmeticExpression() throws RecognitionException {
		ArithmeticExpressionContext _localctx = new ArithmeticExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_arithmeticExpression);
		try {
			setState(319);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				((ArithmeticExpressionContext)_localctx).left = multiplicationExpression();
				setState(315);
				((ArithmeticExpressionContext)_localctx).op = eAdditionOperator();
				setState(316);
				((ArithmeticExpressionContext)_localctx).right = arithmeticExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(318);
				multiplicationExpression();
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

	public static class EAdditionOperatorContext extends ParserRuleContext {
		public EAdditionOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eAdditionOperator; }
	}

	public final EAdditionOperatorContext eAdditionOperator() throws RecognitionException {
		EAdditionOperatorContext _localctx = new EAdditionOperatorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_eAdditionOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			_la = _input.LA(1);
			if ( !(_la==T__56 || _la==T__57) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class MultiplicationExpressionContext extends ParserRuleContext {
		public ValueExpressionContext left;
		public EMultiplicationOperatorContext op;
		public MultiplicationExpressionContext right;
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public EMultiplicationOperatorContext eMultiplicationOperator() {
			return getRuleContext(EMultiplicationOperatorContext.class,0);
		}
		public MultiplicationExpressionContext multiplicationExpression() {
			return getRuleContext(MultiplicationExpressionContext.class,0);
		}
		public MultiplicationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicationExpression; }
	}

	public final MultiplicationExpressionContext multiplicationExpression() throws RecognitionException {
		MultiplicationExpressionContext _localctx = new MultiplicationExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_multiplicationExpression);
		try {
			setState(328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				((MultiplicationExpressionContext)_localctx).left = valueExpression();
				setState(324);
				((MultiplicationExpressionContext)_localctx).op = eMultiplicationOperator();
				setState(325);
				((MultiplicationExpressionContext)_localctx).right = multiplicationExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(327);
				valueExpression();
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

	public static class EMultiplicationOperatorContext extends ParserRuleContext {
		public EMultiplicationOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eMultiplicationOperator; }
	}

	public final EMultiplicationOperatorContext eMultiplicationOperator() throws RecognitionException {
		EMultiplicationOperatorContext _localctx = new EMultiplicationOperatorContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_eMultiplicationOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << T__58))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ValueExpressionContext extends ParserRuleContext {
		public ParenthesisExpressionContext parenthesisExpression() {
			return getRuleContext(ParenthesisExpressionContext.class,0);
		}
		public NamedElementReferenceContext namedElementReference() {
			return getRuleContext(NamedElementReferenceContext.class,0);
		}
		public ArrayExpressionContext arrayExpression() {
			return getRuleContext(ArrayExpressionContext.class,0);
		}
		public LiteralExpressionContext literalExpression() {
			return getRuleContext(LiteralExpressionContext.class,0);
		}
		public ValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueExpression; }
	}

	public final ValueExpressionContext valueExpression() throws RecognitionException {
		ValueExpressionContext _localctx = new ValueExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_valueExpression);
		try {
			setState(336);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				parenthesisExpression();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(333);
				namedElementReference();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 3);
				{
				setState(334);
				arrayExpression();
				}
				break;
			case ELONG:
			case EDOUBLE:
			case EBoolean:
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(335);
				literalExpression();
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

	public static class LiteralExpressionContext extends ParserRuleContext {
		public LiteralContext value;
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalExpression; }
	}

	public final LiteralExpressionContext literalExpression() throws RecognitionException {
		LiteralExpressionContext _localctx = new LiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_literalExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			((LiteralExpressionContext)_localctx).value = literal();
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

	public static class LiteralContext extends ParserRuleContext {
		public StringValueContext stringValue() {
			return getRuleContext(StringValueContext.class,0);
		}
		public LongValueContext longValue() {
			return getRuleContext(LongValueContext.class,0);
		}
		public DoubleValueContext doubleValue() {
			return getRuleContext(DoubleValueContext.class,0);
		}
		public BooleanValueContext booleanValue() {
			return getRuleContext(BooleanValueContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_literal);
		try {
			setState(344);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				stringValue();
				}
				break;
			case ELONG:
				enterOuterAlt(_localctx, 2);
				{
				setState(341);
				longValue();
				}
				break;
			case EDOUBLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(342);
				doubleValue();
				}
				break;
			case EBoolean:
				enterOuterAlt(_localctx, 4);
				{
				setState(343);
				booleanValue();
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

	public static class ParenthesisExpressionContext extends ParserRuleContext {
		public ArithmeticExpressionContext expression;
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public ParenthesisExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesisExpression; }
	}

	public final ParenthesisExpressionContext parenthesisExpression() throws RecognitionException {
		ParenthesisExpressionContext _localctx = new ParenthesisExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_parenthesisExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(T__16);
			setState(347);
			((ParenthesisExpressionContext)_localctx).expression = arithmeticExpression();
			setState(348);
			match(T__17);
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

	public static class ArrayExpressionContext extends ParserRuleContext {
		public ArithmeticExpressionContext arithmeticExpression;
		public List<ArithmeticExpressionContext> elements = new ArrayList<ArithmeticExpressionContext>();
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public ArrayExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayExpression; }
	}

	public final ArrayExpressionContext arrayExpression() throws RecognitionException {
		ArrayExpressionContext _localctx = new ArrayExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_arrayExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			match(T__18);
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__18 - 17)) | (1L << (ELONG - 17)) | (1L << (EDOUBLE - 17)) | (1L << (EBoolean - 17)) | (1L << (ID - 17)) | (1L << (STRING - 17)))) != 0)) {
				{
				setState(351);
				((ArrayExpressionContext)_localctx).arithmeticExpression = arithmeticExpression();
				((ArrayExpressionContext)_localctx).elements.add(((ArrayExpressionContext)_localctx).arithmeticExpression);
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(352);
					match(T__7);
					setState(353);
					((ArrayExpressionContext)_localctx).arithmeticExpression = arithmeticExpression();
					((ArrayExpressionContext)_localctx).elements.add(((ArrayExpressionContext)_localctx).arithmeticExpression);
					}
					}
					setState(358);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(361);
			match(T__19);
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

	public static class NamedElementReferenceContext extends ParserRuleContext {
		public Token element;
		public Token attribute;
		public List<TerminalNode> ID() { return getTokens(DeclarationParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DeclarationParser.ID, i);
		}
		public NamedElementReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedElementReference; }
	}

	public final NamedElementReferenceContext namedElementReference() throws RecognitionException {
		NamedElementReferenceContext _localctx = new NamedElementReferenceContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_namedElementReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			((NamedElementReferenceContext)_localctx).element = match(ID);
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__59) {
				{
				setState(364);
				match(T__59);
				setState(365);
				((NamedElementReferenceContext)_localctx).attribute = match(ID);
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

	public static class StringValueContext extends ParserRuleContext {
		public Token value;
		public TerminalNode STRING() { return getToken(DeclarationParser.STRING, 0); }
		public StringValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringValue; }
	}

	public final StringValueContext stringValue() throws RecognitionException {
		StringValueContext _localctx = new StringValueContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_stringValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			((StringValueContext)_localctx).value = match(STRING);
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

	public static class LongValueContext extends ParserRuleContext {
		public Token value;
		public TerminalNode ELONG() { return getToken(DeclarationParser.ELONG, 0); }
		public LongValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_longValue; }
	}

	public final LongValueContext longValue() throws RecognitionException {
		LongValueContext _localctx = new LongValueContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_longValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			((LongValueContext)_localctx).value = match(ELONG);
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

	public static class DoubleValueContext extends ParserRuleContext {
		public Token value;
		public TerminalNode EDOUBLE() { return getToken(DeclarationParser.EDOUBLE, 0); }
		public DoubleValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleValue; }
	}

	public final DoubleValueContext doubleValue() throws RecognitionException {
		DoubleValueContext _localctx = new DoubleValueContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_doubleValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			((DoubleValueContext)_localctx).value = match(EDOUBLE);
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

	public static class BooleanValueContext extends ParserRuleContext {
		public Token value;
		public TerminalNode EBoolean() { return getToken(DeclarationParser.EBoolean, 0); }
		public BooleanValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanValue; }
	}

	public final BooleanValueContext booleanValue() throws RecognitionException {
		BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_booleanValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			((BooleanValueContext)_localctx).value = match(EBoolean);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3G\u017b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2\3\2\7\2"+
		"U\n\2\f\2\16\2X\13\2\5\2Z\n\2\3\2\3\2\7\2^\n\2\f\2\16\2a\13\2\3\3\3\3"+
		"\3\3\5\3f\n\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4n\n\4\f\4\16\4q\13\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5|\n\5\3\5\3\5\5\5\u0080\n\5\3\6\5\6\u0083"+
		"\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u008c\n\6\f\6\16\6\u008f\13\6\3\6"+
		"\3\6\7\6\u0093\n\6\f\6\16\6\u0096\13\6\3\6\3\6\7\6\u009a\n\6\f\6\16\6"+
		"\u009d\13\6\3\6\5\6\u00a0\n\6\3\7\3\7\3\7\7\7\u00a5\n\7\f\7\16\7\u00a8"+
		"\13\7\3\b\3\b\5\b\u00ac\n\b\3\t\3\t\3\t\5\t\u00b1\n\t\3\n\3\n\3\n\3\n"+
		"\7\n\u00b7\n\n\f\n\16\n\u00ba\13\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\7\f\u00c5\n\f\f\f\16\f\u00c8\13\f\3\f\3\f\3\r\3\r\5\r\u00ce\n\r\3\16"+
		"\5\16\u00d1\n\16\3\17\5\17\u00d4\n\17\3\17\3\17\5\17\u00d8\n\17\3\20\3"+
		"\20\5\20\u00dc\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\7\22\u00ed\n\22\f\22\16\22\u00f0\13\22\3\22"+
		"\3\22\3\23\3\23\3\23\5\23\u00f7\n\23\3\24\3\24\3\24\7\24\u00fc\n\24\f"+
		"\24\16\24\u00ff\13\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0107\n\25\3"+
		"\26\5\26\u010a\n\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u0115\n\30\3\30\5\30\u0118\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5"+
		"\31\u012f\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32"+
		"\u013b\n\32\3\33\3\33\3\33\3\33\3\33\5\33\u0142\n\33\3\34\3\34\3\35\3"+
		"\35\3\35\3\35\3\35\5\35\u014b\n\35\3\36\3\36\3\37\3\37\3\37\3\37\5\37"+
		"\u0153\n\37\3 \3 \3!\3!\3!\3!\5!\u015b\n!\3\"\3\"\3\"\3\"\3#\3#\3#\3#"+
		"\7#\u0165\n#\f#\16#\u0168\13#\5#\u016a\n#\3#\3#\3$\3$\3$\5$\u0171\n$\3"+
		"%\3%\3&\3&\3\'\3\'\3(\3(\3(\2\2)\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFHJLN\2\4\3\2;<\4\2\31\32==\2\u019d\2P\3\2"+
		"\2\2\4e\3\2\2\2\6g\3\2\2\2\bt\3\2\2\2\n\u0082\3\2\2\2\f\u00a1\3\2\2\2"+
		"\16\u00ab\3\2\2\2\20\u00b0\3\2\2\2\22\u00b2\3\2\2\2\24\u00bd\3\2\2\2\26"+
		"\u00bf\3\2\2\2\30\u00cd\3\2\2\2\32\u00d0\3\2\2\2\34\u00d3\3\2\2\2\36\u00db"+
		"\3\2\2\2 \u00dd\3\2\2\2\"\u00e6\3\2\2\2$\u00f3\3\2\2\2&\u00f8\3\2\2\2"+
		"(\u0106\3\2\2\2*\u0109\3\2\2\2,\u010d\3\2\2\2.\u0117\3\2\2\2\60\u012e"+
		"\3\2\2\2\62\u013a\3\2\2\2\64\u0141\3\2\2\2\66\u0143\3\2\2\28\u014a\3\2"+
		"\2\2:\u014c\3\2\2\2<\u0152\3\2\2\2>\u0154\3\2\2\2@\u015a\3\2\2\2B\u015c"+
		"\3\2\2\2D\u0160\3\2\2\2F\u016d\3\2\2\2H\u0172\3\2\2\2J\u0174\3\2\2\2L"+
		"\u0176\3\2\2\2N\u0178\3\2\2\2PQ\7\3\2\2QY\7B\2\2RV\7\4\2\2SU\5\36\20\2"+
		"TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WZ\3\2\2\2XV\3\2\2\2YR\3\2\2\2"+
		"YZ\3\2\2\2Z_\3\2\2\2[^\5\6\4\2\\^\5\n\6\2][\3\2\2\2]\\\3\2\2\2^a\3\2\2"+
		"\2_]\3\2\2\2_`\3\2\2\2`\3\3\2\2\2a_\3\2\2\2bf\5\b\5\2cf\5\6\4\2df\5\n"+
		"\6\2eb\3\2\2\2ec\3\2\2\2ed\3\2\2\2f\5\3\2\2\2gh\7\5\2\2hi\7B\2\2ij\7\6"+
		"\2\2jk\7D\2\2ko\7\7\2\2ln\5\b\5\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2"+
		"\2\2pr\3\2\2\2qo\3\2\2\2rs\7\b\2\2s\7\3\2\2\2tu\7\t\2\2uv\7B\2\2vw\5\20"+
		"\t\2wx\7\6\2\2x{\5&\24\2yz\7\n\2\2z|\7D\2\2{y\3\2\2\2{|\3\2\2\2|\177\3"+
		"\2\2\2}~\7\13\2\2~\u0080\5\64\33\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\t\3\2\2\2\u0081\u0083\7\f\2\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2"+
		"\u0083\u0084\3\2\2\2\u0084\u0085\7\r\2\2\u0085\u0086\7B\2\2\u0086\u0087"+
		"\7\6\2\2\u0087\u009f\7D\2\2\u0088\u008d\7\7\2\2\u0089\u008a\7\16\2\2\u008a"+
		"\u008c\7B\2\2\u008b\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e\u0094\3\2\2\2\u008f\u008d\3\2\2\2\u0090"+
		"\u0091\7\17\2\2\u0091\u0093\7B\2\2\u0092\u0090\3\2\2\2\u0093\u0096\3\2"+
		"\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u009b\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0097\u009a\5\6\4\2\u0098\u009a\5\f\7\2\u0099\u0097\3\2"+
		"\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\7\b"+
		"\2\2\u009f\u0088\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\13\3\2\2\2\u00a1\u00a2"+
		"\7\20\2\2\u00a2\u00a6\5\16\b\2\u00a3\u00a5\5\n\6\2\u00a4\u00a3\3\2\2\2"+
		"\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\r\3"+
		"\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ac\7\21\2\2\u00aa\u00ac\7\22\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac\17\3\2\2\2\u00ad\u00b1\5\24\13"+
		"\2\u00ae\u00b1\5\22\n\2\u00af\u00b1\5\26\f\2\u00b0\u00ad\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\21\3\2\2\2\u00b2\u00b3\7\23\2"+
		"\2\u00b3\u00b8\5$\23\2\u00b4\u00b5\7\n\2\2\u00b5\u00b7\5$\23\2\u00b6\u00b4"+
		"\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00bb\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\7\24\2\2\u00bc\23\3\2\2"+
		"\2\u00bd\u00be\7B\2\2\u00be\25\3\2\2\2\u00bf\u00c0\7B\2\2\u00c0\u00c1"+
		"\7\25\2\2\u00c1\u00c6\5\30\r\2\u00c2\u00c3\7\n\2\2\u00c3\u00c5\5\30\r"+
		"\2\u00c4\u00c2\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7"+
		"\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ca\7\26\2\2"+
		"\u00ca\27\3\2\2\2\u00cb\u00ce\5\32\16\2\u00cc\u00ce\5\34\17\2\u00cd\u00cb"+
		"\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\31\3\2\2\2\u00cf\u00d1\7?\2\2\u00d0"+
		"\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\33\3\2\2\2\u00d2\u00d4\7?\2\2"+
		"\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d7"+
		"\7\6\2\2\u00d6\u00d8\7?\2\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\35\3\2\2\2\u00d9\u00dc\5 \21\2\u00da\u00dc\5\"\22\2\u00db\u00d9\3\2\2"+
		"\2\u00db\u00da\3\2\2\2\u00dc\37\3\2\2\2\u00dd\u00de\7\27\2\2\u00de\u00df"+
		"\7B\2\2\u00df\u00e0\7B\2\2\u00e0\u00e1\7\25\2\2\u00e1\u00e2\5@!\2\u00e2"+
		"\u00e3\7\6\2\2\u00e3\u00e4\5@!\2\u00e4\u00e5\7\26\2\2\u00e5!\3\2\2\2\u00e6"+
		"\u00e7\7\30\2\2\u00e7\u00e8\7B\2\2\u00e8\u00e9\7\7\2\2\u00e9\u00ee\5$"+
		"\23\2\u00ea\u00eb\7\n\2\2\u00eb\u00ed\5$\23\2\u00ec\u00ea\3\2\2\2\u00ed"+
		"\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1\3\2"+
		"\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\7\b\2\2\u00f2#\3\2\2\2\u00f3\u00f6"+
		"\7B\2\2\u00f4\u00f5\7\13\2\2\u00f5\u00f7\7?\2\2\u00f6\u00f4\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7%\3\2\2\2\u00f8\u00fd\5.\30\2\u00f9\u00fa\7\31\2\2"+
		"\u00fa\u00fc\5.\30\2\u00fb\u00f9\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb"+
		"\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\'\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100"+
		"\u0107\5*\26\2\u0101\u0107\5,\27\2\u0102\u0103\7\23\2\2\u0103\u0104\5"+
		"&\24\2\u0104\u0105\7\24\2\2\u0105\u0107\3\2\2\2\u0106\u0100\3\2\2\2\u0106"+
		"\u0101\3\2\2\2\u0106\u0102\3\2\2\2\u0107)\3\2\2\2\u0108\u010a\5\60\31"+
		"\2\u0109\u0108\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c"+
		"\5\62\32\2\u010c+\3\2\2\2\u010d\u010e\7D\2\2\u010e-\3\2\2\2\u010f\u0114"+
		"\5(\25\2\u0110\u0111\7\32\2\2\u0111\u0115\5(\25\2\u0112\u0113\7\33\2\2"+
		"\u0113\u0115\7?\2\2\u0114\u0110\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0118"+
		"\3\2\2\2\u0116\u0118\5(\25\2\u0117\u010f\3\2\2\2\u0117\u0116\3\2\2\2\u0118"+
		"/\3\2\2\2\u0119\u012f\7\34\2\2\u011a\u012f\7\35\2\2\u011b\u012f\7\36\2"+
		"\2\u011c\u012f\7\37\2\2\u011d\u012f\7 \2\2\u011e\u012f\7!\2\2\u011f\u012f"+
		"\7\"\2\2\u0120\u012f\7#\2\2\u0121\u012f\7$\2\2\u0122\u012f\7%\2\2\u0123"+
		"\u012f\7&\2\2\u0124\u012f\7\'\2\2\u0125\u012f\7(\2\2\u0126\u012f\7)\2"+
		"\2\u0127\u012f\7*\2\2\u0128\u012f\7+\2\2\u0129\u012f\7,\2\2\u012a\u012f"+
		"\7-\2\2\u012b\u012f\7.\2\2\u012c\u012f\7/\2\2\u012d\u012f\7\60\2\2\u012e"+
		"\u0119\3\2\2\2\u012e\u011a\3\2\2\2\u012e\u011b\3\2\2\2\u012e\u011c\3\2"+
		"\2\2\u012e\u011d\3\2\2\2\u012e\u011e\3\2\2\2\u012e\u011f\3\2\2\2\u012e"+
		"\u0120\3\2\2\2\u012e\u0121\3\2\2\2\u012e\u0122\3\2\2\2\u012e\u0123\3\2"+
		"\2\2\u012e\u0124\3\2\2\2\u012e\u0125\3\2\2\2\u012e\u0126\3\2\2\2\u012e"+
		"\u0127\3\2\2\2\u012e\u0128\3\2\2\2\u012e\u0129\3\2\2\2\u012e\u012a\3\2"+
		"\2\2\u012e\u012b\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012d\3\2\2\2\u012f"+
		"\61\3\2\2\2\u0130\u013b\7\61\2\2\u0131\u013b\7\62\2\2\u0132\u013b\7\63"+
		"\2\2\u0133\u013b\7\64\2\2\u0134\u013b\7\65\2\2\u0135\u013b\7\66\2\2\u0136"+
		"\u013b\7\67\2\2\u0137\u013b\78\2\2\u0138\u013b\79\2\2\u0139\u013b\7:\2"+
		"\2\u013a\u0130\3\2\2\2\u013a\u0131\3\2\2\2\u013a\u0132\3\2\2\2\u013a\u0133"+
		"\3\2\2\2\u013a\u0134\3\2\2\2\u013a\u0135\3\2\2\2\u013a\u0136\3\2\2\2\u013a"+
		"\u0137\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u0139\3\2\2\2\u013b\63\3\2\2"+
		"\2\u013c\u013d\58\35\2\u013d\u013e\5\66\34\2\u013e\u013f\5\64\33\2\u013f"+
		"\u0142\3\2\2\2\u0140\u0142\58\35\2\u0141\u013c\3\2\2\2\u0141\u0140\3\2"+
		"\2\2\u0142\65\3\2\2\2\u0143\u0144\t\2\2\2\u0144\67\3\2\2\2\u0145\u0146"+
		"\5<\37\2\u0146\u0147\5:\36\2\u0147\u0148\58\35\2\u0148\u014b\3\2\2\2\u0149"+
		"\u014b\5<\37\2\u014a\u0145\3\2\2\2\u014a\u0149\3\2\2\2\u014b9\3\2\2\2"+
		"\u014c\u014d\t\3\2\2\u014d;\3\2\2\2\u014e\u0153\5B\"\2\u014f\u0153\5F"+
		"$\2\u0150\u0153\5D#\2\u0151\u0153\5> \2\u0152\u014e\3\2\2\2\u0152\u014f"+
		"\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0151\3\2\2\2\u0153=\3\2\2\2\u0154"+
		"\u0155\5@!\2\u0155?\3\2\2\2\u0156\u015b\5H%\2\u0157\u015b\5J&\2\u0158"+
		"\u015b\5L\'\2\u0159\u015b\5N(\2\u015a\u0156\3\2\2\2\u015a\u0157\3\2\2"+
		"\2\u015a\u0158\3\2\2\2\u015a\u0159\3\2\2\2\u015bA\3\2\2\2\u015c\u015d"+
		"\7\23\2\2\u015d\u015e\5\64\33\2\u015e\u015f\7\24\2\2\u015fC\3\2\2\2\u0160"+
		"\u0169\7\25\2\2\u0161\u0166\5\64\33\2\u0162\u0163\7\n\2\2\u0163\u0165"+
		"\5\64\33\2\u0164\u0162\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0164\3\2\2\2"+
		"\u0166\u0167\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u0161"+
		"\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c\7\26\2\2"+
		"\u016cE\3\2\2\2\u016d\u0170\7B\2\2\u016e\u016f\7>\2\2\u016f\u0171\7B\2"+
		"\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171G\3\2\2\2\u0172\u0173"+
		"\7D\2\2\u0173I\3\2\2\2\u0174\u0175\7?\2\2\u0175K\3\2\2\2\u0176\u0177\7"+
		"@\2\2\u0177M\3\2\2\2\u0178\u0179\7A\2\2\u0179O\3\2\2\2*VY]_eo{\177\u0082"+
		"\u008d\u0094\u0099\u009b\u009f\u00a6\u00ab\u00b0\u00b8\u00c6\u00cd\u00d0"+
		"\u00d3\u00d7\u00db\u00ee\u00f6\u00fd\u0106\u0109\u0114\u0117\u012e\u013a"+
		"\u0141\u014a\u0152\u015a\u0166\u0169\u0170";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}