// Generated from /home/armin/Dokumente/antlr4/antlr4-python/cp-dsl/confLSPServer/grammars/Configuration.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ConfigurationParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, ID=21, ELONG=22, EDOUBLE=23, EBoolean=24, 
		INT=25, STRING=26, WS=27, ML_COMMENT=28, SL_COMMENT=29, ANY_OTHER=30;
	public static final int
		RULE_configurationModel = 0, RULE_include = 1, RULE_featureActivation = 2, 
		RULE_featureConfiguration = 3, RULE_parameterGroup = 4, RULE_parameterAssignment = 5, 
		RULE_selector = 6, RULE_elementSelector = 7, RULE_rangeSelector = 8, RULE_unitSpecification = 9, 
		RULE_qualifiedName = 10, RULE_arithmeticExpression = 11, RULE_eAdditionOperator = 12, 
		RULE_multiplicationExpression = 13, RULE_eMultiplicationOperator = 14, 
		RULE_valueExpression = 15, RULE_literalExpression = 16, RULE_literal = 17, 
		RULE_parenthesisExpression = 18, RULE_arrayExpression = 19, RULE_namedElementReference = 20, 
		RULE_stringValue = 21, RULE_longValue = 22, RULE_doubleValue = 23, RULE_booleanValue = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"configurationModel", "include", "featureActivation", "featureConfiguration", 
			"parameterGroup", "parameterAssignment", "selector", "elementSelector", 
			"rangeSelector", "unitSpecification", "qualifiedName", "arithmeticExpression", 
			"eAdditionOperator", "multiplicationExpression", "eMultiplicationOperator", 
			"valueExpression", "literalExpression", "literal", "parenthesisExpression", 
			"arrayExpression", "namedElementReference", "stringValue", "longValue", 
			"doubleValue", "booleanValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'configuration'", "':'", "'activate'", "','", "'include'", "'!'", 
			"'feature'", "'{'", "'}'", "'group'", "'['", "']'", "'.'", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "ID", "ELONG", 
			"EDOUBLE", "EBoolean", "INT", "STRING", "WS", "ML_COMMENT", "SL_COMMENT", 
			"ANY_OTHER"
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
	public String getGrammarFileName() { return "Configuration.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ConfigurationParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ConfigurationModelContext extends ParserRuleContext {
		public Token name;
		public Token declarationModel;
		public IncludeContext include;
		public List<IncludeContext> includes = new ArrayList<IncludeContext>();
		public FeatureActivationContext featureActivation;
		public List<FeatureActivationContext> featureActivations = new ArrayList<FeatureActivationContext>();
		public ParameterGroupContext parameterGroup;
		public List<ParameterGroupContext> parameterGroups = new ArrayList<ParameterGroupContext>();
		public FeatureConfigurationContext featureConfiguration;
		public List<FeatureConfigurationContext> featureConfigurations = new ArrayList<FeatureConfigurationContext>();
		public List<TerminalNode> ID() { return getTokens(ConfigurationParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ConfigurationParser.ID, i);
		}
		public List<IncludeContext> include() {
			return getRuleContexts(IncludeContext.class);
		}
		public IncludeContext include(int i) {
			return getRuleContext(IncludeContext.class,i);
		}
		public List<FeatureActivationContext> featureActivation() {
			return getRuleContexts(FeatureActivationContext.class);
		}
		public FeatureActivationContext featureActivation(int i) {
			return getRuleContext(FeatureActivationContext.class,i);
		}
		public List<ParameterGroupContext> parameterGroup() {
			return getRuleContexts(ParameterGroupContext.class);
		}
		public ParameterGroupContext parameterGroup(int i) {
			return getRuleContext(ParameterGroupContext.class,i);
		}
		public List<FeatureConfigurationContext> featureConfiguration() {
			return getRuleContexts(FeatureConfigurationContext.class);
		}
		public FeatureConfigurationContext featureConfiguration(int i) {
			return getRuleContext(FeatureConfigurationContext.class,i);
		}
		public ConfigurationModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_configurationModel; }
	}

	public final ConfigurationModelContext configurationModel() throws RecognitionException {
		ConfigurationModelContext _localctx = new ConfigurationModelContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_configurationModel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__0);
			setState(51);
			((ConfigurationModelContext)_localctx).name = match(ID);
			setState(52);
			match(T__1);
			setState(53);
			((ConfigurationModelContext)_localctx).declarationModel = match(ID);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(54);
				((ConfigurationModelContext)_localctx).include = include();
				((ConfigurationModelContext)_localctx).includes.add(((ConfigurationModelContext)_localctx).include);
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(60);
				match(T__2);
				setState(61);
				((ConfigurationModelContext)_localctx).featureActivation = featureActivation();
				((ConfigurationModelContext)_localctx).featureActivations.add(((ConfigurationModelContext)_localctx).featureActivation);
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(62);
					match(T__3);
					setState(63);
					((ConfigurationModelContext)_localctx).featureActivation = featureActivation();
					((ConfigurationModelContext)_localctx).featureActivations.add(((ConfigurationModelContext)_localctx).featureActivation);
					}
					}
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6 || _la==T__9) {
				{
				setState(73);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__9:
					{
					setState(71);
					((ConfigurationModelContext)_localctx).parameterGroup = parameterGroup();
					((ConfigurationModelContext)_localctx).parameterGroups.add(((ConfigurationModelContext)_localctx).parameterGroup);
					}
					break;
				case T__6:
					{
					setState(72);
					((ConfigurationModelContext)_localctx).featureConfiguration = featureConfiguration();
					((ConfigurationModelContext)_localctx).featureConfigurations.add(((ConfigurationModelContext)_localctx).featureConfiguration);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(77);
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

	public static class IncludeContext extends ParserRuleContext {
		public QualifiedNameContext importedNamespace;
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__4);
			setState(79);
			((IncludeContext)_localctx).importedNamespace = qualifiedName();
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

	public static class FeatureActivationContext extends ParserRuleContext {
		public Token deactivated;
		public Token declaration;
		public TerminalNode ID() { return getToken(ConfigurationParser.ID, 0); }
		public FeatureActivationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureActivation; }
	}

	public final FeatureActivationContext featureActivation() throws RecognitionException {
		FeatureActivationContext _localctx = new FeatureActivationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_featureActivation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(81);
				((FeatureActivationContext)_localctx).deactivated = match(T__5);
				}
			}

			setState(84);
			((FeatureActivationContext)_localctx).declaration = match(ID);
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

	public static class FeatureConfigurationContext extends ParserRuleContext {
		public Token declaration;
		public FeatureActivationContext featureActivation;
		public List<FeatureActivationContext> featureActivations = new ArrayList<FeatureActivationContext>();
		public ParameterGroupContext parameterGroup;
		public List<ParameterGroupContext> parameterGroups = new ArrayList<ParameterGroupContext>();
		public FeatureConfigurationContext featureConfiguration;
		public List<FeatureConfigurationContext> featureConfigurations = new ArrayList<FeatureConfigurationContext>();
		public TerminalNode ID() { return getToken(ConfigurationParser.ID, 0); }
		public List<FeatureActivationContext> featureActivation() {
			return getRuleContexts(FeatureActivationContext.class);
		}
		public FeatureActivationContext featureActivation(int i) {
			return getRuleContext(FeatureActivationContext.class,i);
		}
		public List<ParameterGroupContext> parameterGroup() {
			return getRuleContexts(ParameterGroupContext.class);
		}
		public ParameterGroupContext parameterGroup(int i) {
			return getRuleContext(ParameterGroupContext.class,i);
		}
		public List<FeatureConfigurationContext> featureConfiguration() {
			return getRuleContexts(FeatureConfigurationContext.class);
		}
		public FeatureConfigurationContext featureConfiguration(int i) {
			return getRuleContext(FeatureConfigurationContext.class,i);
		}
		public FeatureConfigurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureConfiguration; }
	}

	public final FeatureConfigurationContext featureConfiguration() throws RecognitionException {
		FeatureConfigurationContext _localctx = new FeatureConfigurationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_featureConfiguration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__6);
			setState(87);
			((FeatureConfigurationContext)_localctx).declaration = match(ID);
			setState(88);
			match(T__7);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(89);
				match(T__2);
				setState(90);
				((FeatureConfigurationContext)_localctx).featureActivation = featureActivation();
				((FeatureConfigurationContext)_localctx).featureActivations.add(((FeatureConfigurationContext)_localctx).featureActivation);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(91);
					match(T__3);
					setState(92);
					((FeatureConfigurationContext)_localctx).featureActivation = featureActivation();
					((FeatureConfigurationContext)_localctx).featureActivations.add(((FeatureConfigurationContext)_localctx).featureActivation);
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6 || _la==T__9) {
				{
				setState(102);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__9:
					{
					setState(100);
					((FeatureConfigurationContext)_localctx).parameterGroup = parameterGroup();
					((FeatureConfigurationContext)_localctx).parameterGroups.add(((FeatureConfigurationContext)_localctx).parameterGroup);
					}
					break;
				case T__6:
					{
					setState(101);
					((FeatureConfigurationContext)_localctx).featureConfiguration = featureConfiguration();
					((FeatureConfigurationContext)_localctx).featureConfigurations.add(((FeatureConfigurationContext)_localctx).featureConfiguration);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			match(T__8);
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

	public static class ParameterGroupContext extends ParserRuleContext {
		public Token declaration;
		public ParameterAssignmentContext parameterAssignment;
		public List<ParameterAssignmentContext> parameters = new ArrayList<ParameterAssignmentContext>();
		public TerminalNode ID() { return getToken(ConfigurationParser.ID, 0); }
		public List<ParameterAssignmentContext> parameterAssignment() {
			return getRuleContexts(ParameterAssignmentContext.class);
		}
		public ParameterAssignmentContext parameterAssignment(int i) {
			return getRuleContext(ParameterAssignmentContext.class,i);
		}
		public ParameterGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterGroup; }
	}

	public final ParameterGroupContext parameterGroup() throws RecognitionException {
		ParameterGroupContext _localctx = new ParameterGroupContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameterGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(T__9);
			setState(110);
			((ParameterGroupContext)_localctx).declaration = match(ID);
			setState(111);
			match(T__7);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(112);
				((ParameterGroupContext)_localctx).parameterAssignment = parameterAssignment();
				((ParameterGroupContext)_localctx).parameters.add(((ParameterGroupContext)_localctx).parameterAssignment);
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			match(T__8);
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

	public static class ParameterAssignmentContext extends ParserRuleContext {
		public QualifiedNameContext declaration;
		public SelectorContext selector;
		public List<SelectorContext> selectors = new ArrayList<SelectorContext>();
		public ArithmeticExpressionContext value;
		public UnitSpecificationContext unit;
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public List<SelectorContext> selector() {
			return getRuleContexts(SelectorContext.class);
		}
		public SelectorContext selector(int i) {
			return getRuleContext(SelectorContext.class,i);
		}
		public UnitSpecificationContext unitSpecification() {
			return getRuleContext(UnitSpecificationContext.class,0);
		}
		public ParameterAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterAssignment; }
	}

	public final ParameterAssignmentContext parameterAssignment() throws RecognitionException {
		ParameterAssignmentContext _localctx = new ParameterAssignmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameterAssignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			((ParameterAssignmentContext)_localctx).declaration = qualifiedName();
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(121);
				match(T__10);
				setState(122);
				((ParameterAssignmentContext)_localctx).selector = selector();
				((ParameterAssignmentContext)_localctx).selectors.add(((ParameterAssignmentContext)_localctx).selector);
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(123);
					match(T__3);
					setState(124);
					((ParameterAssignmentContext)_localctx).selector = selector();
					((ParameterAssignmentContext)_localctx).selectors.add(((ParameterAssignmentContext)_localctx).selector);
					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(130);
				match(T__11);
				}
			}

			setState(134);
			match(T__1);
			setState(135);
			((ParameterAssignmentContext)_localctx).value = arithmeticExpression();
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(136);
				((ParameterAssignmentContext)_localctx).unit = unitSpecification();
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

	public static class SelectorContext extends ParserRuleContext {
		public ElementSelectorContext elementSelector() {
			return getRuleContext(ElementSelectorContext.class,0);
		}
		public RangeSelectorContext rangeSelector() {
			return getRuleContext(RangeSelectorContext.class,0);
		}
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_selector);
		try {
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				elementSelector();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				rangeSelector();
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

	public static class ElementSelectorContext extends ParserRuleContext {
		public Token element;
		public TerminalNode ELONG() { return getToken(ConfigurationParser.ELONG, 0); }
		public ElementSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementSelector; }
	}

	public final ElementSelectorContext elementSelector() throws RecognitionException {
		ElementSelectorContext _localctx = new ElementSelectorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_elementSelector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			((ElementSelectorContext)_localctx).element = match(ELONG);
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

	public static class RangeSelectorContext extends ParserRuleContext {
		public Token lowerBound;
		public Token upperBound;
		public List<TerminalNode> ELONG() { return getTokens(ConfigurationParser.ELONG); }
		public TerminalNode ELONG(int i) {
			return getToken(ConfigurationParser.ELONG, i);
		}
		public RangeSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeSelector; }
	}

	public final RangeSelectorContext rangeSelector() throws RecognitionException {
		RangeSelectorContext _localctx = new RangeSelectorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rangeSelector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			((RangeSelectorContext)_localctx).lowerBound = match(ELONG);
			setState(146);
			match(T__1);
			setState(147);
			((RangeSelectorContext)_localctx).upperBound = match(ELONG);
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
		public Token unit;
		public TerminalNode ID() { return getToken(ConfigurationParser.ID, 0); }
		public UnitSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unitSpecification; }
	}

	public final UnitSpecificationContext unitSpecification() throws RecognitionException {
		UnitSpecificationContext _localctx = new UnitSpecificationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_unitSpecification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			((UnitSpecificationContext)_localctx).unit = match(ID);
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

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ConfigurationParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ConfigurationParser.ID, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(ID);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(152);
				match(T__12);
				setState(153);
				match(ID);
				}
				}
				setState(158);
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
		enterRule(_localctx, 22, RULE_arithmeticExpression);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				((ArithmeticExpressionContext)_localctx).left = multiplicationExpression();
				setState(160);
				((ArithmeticExpressionContext)_localctx).op = eAdditionOperator();
				setState(161);
				((ArithmeticExpressionContext)_localctx).right = arithmeticExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
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
		enterRule(_localctx, 24, RULE_eAdditionOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==T__14) ) {
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
		enterRule(_localctx, 26, RULE_multiplicationExpression);
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				((MultiplicationExpressionContext)_localctx).left = valueExpression();
				setState(169);
				((MultiplicationExpressionContext)_localctx).op = eMultiplicationOperator();
				setState(170);
				((MultiplicationExpressionContext)_localctx).right = multiplicationExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
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
		enterRule(_localctx, 28, RULE_eMultiplicationOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
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
		enterRule(_localctx, 30, RULE_valueExpression);
		try {
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				parenthesisExpression();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				namedElementReference();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(179);
				arrayExpression();
				}
				break;
			case ELONG:
			case EDOUBLE:
			case EBoolean:
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(180);
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
		enterRule(_localctx, 32, RULE_literalExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
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
		enterRule(_localctx, 34, RULE_literal);
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				stringValue();
				}
				break;
			case ELONG:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				longValue();
				}
				break;
			case EDOUBLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(187);
				doubleValue();
				}
				break;
			case EBoolean:
				enterOuterAlt(_localctx, 4);
				{
				setState(188);
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
		enterRule(_localctx, 36, RULE_parenthesisExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(T__18);
			setState(192);
			((ParenthesisExpressionContext)_localctx).expression = arithmeticExpression();
			setState(193);
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
		enterRule(_localctx, 38, RULE_arrayExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(T__10);
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__18) | (1L << ID) | (1L << ELONG) | (1L << EDOUBLE) | (1L << EBoolean) | (1L << STRING))) != 0)) {
				{
				setState(196);
				((ArrayExpressionContext)_localctx).arithmeticExpression = arithmeticExpression();
				((ArrayExpressionContext)_localctx).elements.add(((ArrayExpressionContext)_localctx).arithmeticExpression);
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(197);
					match(T__3);
					setState(198);
					((ArrayExpressionContext)_localctx).arithmeticExpression = arithmeticExpression();
					((ArrayExpressionContext)_localctx).elements.add(((ArrayExpressionContext)_localctx).arithmeticExpression);
					}
					}
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(206);
			match(T__11);
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
		public List<TerminalNode> ID() { return getTokens(ConfigurationParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ConfigurationParser.ID, i);
		}
		public NamedElementReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedElementReference; }
	}

	public final NamedElementReferenceContext namedElementReference() throws RecognitionException {
		NamedElementReferenceContext _localctx = new NamedElementReferenceContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_namedElementReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			((NamedElementReferenceContext)_localctx).element = match(ID);
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(209);
				match(T__12);
				setState(210);
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
		public TerminalNode STRING() { return getToken(ConfigurationParser.STRING, 0); }
		public StringValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringValue; }
	}

	public final StringValueContext stringValue() throws RecognitionException {
		StringValueContext _localctx = new StringValueContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_stringValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
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
		public TerminalNode ELONG() { return getToken(ConfigurationParser.ELONG, 0); }
		public LongValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_longValue; }
	}

	public final LongValueContext longValue() throws RecognitionException {
		LongValueContext _localctx = new LongValueContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_longValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
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
		public TerminalNode EDOUBLE() { return getToken(ConfigurationParser.EDOUBLE, 0); }
		public DoubleValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleValue; }
	}

	public final DoubleValueContext doubleValue() throws RecognitionException {
		DoubleValueContext _localctx = new DoubleValueContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_doubleValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
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
		public TerminalNode EBoolean() { return getToken(ConfigurationParser.EBoolean, 0); }
		public BooleanValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanValue; }
	}

	public final BooleanValueContext booleanValue() throws RecognitionException {
		BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_booleanValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u00e0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\2\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\3\2\3\2\3\2"+
		"\7\2C\n\2\f\2\16\2F\13\2\5\2H\n\2\3\2\3\2\7\2L\n\2\f\2\16\2O\13\2\3\3"+
		"\3\3\3\3\3\4\5\4U\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5`\n\5\f\5"+
		"\16\5c\13\5\5\5e\n\5\3\5\3\5\7\5i\n\5\f\5\16\5l\13\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\7\6t\n\6\f\6\16\6w\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7\u0080\n"+
		"\7\f\7\16\7\u0083\13\7\3\7\3\7\5\7\u0087\n\7\3\7\3\7\3\7\5\7\u008c\n\7"+
		"\3\b\3\b\5\b\u0090\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\7"+
		"\f\u009d\n\f\f\f\16\f\u00a0\13\f\3\r\3\r\3\r\3\r\3\r\5\r\u00a7\n\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\5\17\u00b0\n\17\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\5\21\u00b8\n\21\3\22\3\22\3\23\3\23\3\23\3\23\5\23\u00c0\n\23\3"+
		"\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u00ca\n\25\f\25\16\25\u00cd"+
		"\13\25\5\25\u00cf\n\25\3\25\3\25\3\26\3\26\3\26\5\26\u00d6\n\26\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\2\2\33\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\2\4\3\2\20\21\3\2\22\24\2\u00e1\2\64\3"+
		"\2\2\2\4P\3\2\2\2\6T\3\2\2\2\bX\3\2\2\2\no\3\2\2\2\fz\3\2\2\2\16\u008f"+
		"\3\2\2\2\20\u0091\3\2\2\2\22\u0093\3\2\2\2\24\u0097\3\2\2\2\26\u0099\3"+
		"\2\2\2\30\u00a6\3\2\2\2\32\u00a8\3\2\2\2\34\u00af\3\2\2\2\36\u00b1\3\2"+
		"\2\2 \u00b7\3\2\2\2\"\u00b9\3\2\2\2$\u00bf\3\2\2\2&\u00c1\3\2\2\2(\u00c5"+
		"\3\2\2\2*\u00d2\3\2\2\2,\u00d7\3\2\2\2.\u00d9\3\2\2\2\60\u00db\3\2\2\2"+
		"\62\u00dd\3\2\2\2\64\65\7\3\2\2\65\66\7\27\2\2\66\67\7\4\2\2\67;\7\27"+
		"\2\28:\5\4\3\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<G\3\2\2\2=;\3\2"+
		"\2\2>?\7\5\2\2?D\5\6\4\2@A\7\6\2\2AC\5\6\4\2B@\3\2\2\2CF\3\2\2\2DB\3\2"+
		"\2\2DE\3\2\2\2EH\3\2\2\2FD\3\2\2\2G>\3\2\2\2GH\3\2\2\2HM\3\2\2\2IL\5\n"+
		"\6\2JL\5\b\5\2KI\3\2\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\3\3"+
		"\2\2\2OM\3\2\2\2PQ\7\7\2\2QR\5\26\f\2R\5\3\2\2\2SU\7\b\2\2TS\3\2\2\2T"+
		"U\3\2\2\2UV\3\2\2\2VW\7\27\2\2W\7\3\2\2\2XY\7\t\2\2YZ\7\27\2\2Zd\7\n\2"+
		"\2[\\\7\5\2\2\\a\5\6\4\2]^\7\6\2\2^`\5\6\4\2_]\3\2\2\2`c\3\2\2\2a_\3\2"+
		"\2\2ab\3\2\2\2be\3\2\2\2ca\3\2\2\2d[\3\2\2\2de\3\2\2\2ej\3\2\2\2fi\5\n"+
		"\6\2gi\5\b\5\2hf\3\2\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2"+
		"\2\2lj\3\2\2\2mn\7\13\2\2n\t\3\2\2\2op\7\f\2\2pq\7\27\2\2qu\7\n\2\2rt"+
		"\5\f\7\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2x"+
		"y\7\13\2\2y\13\3\2\2\2z\u0086\5\26\f\2{|\7\r\2\2|\u0081\5\16\b\2}~\7\6"+
		"\2\2~\u0080\5\16\b\2\177}\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2"+
		"\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085"+
		"\7\16\2\2\u0085\u0087\3\2\2\2\u0086{\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u0089\7\4\2\2\u0089\u008b\5\30\r\2\u008a\u008c\5"+
		"\24\13\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\r\3\2\2\2\u008d"+
		"\u0090\5\20\t\2\u008e\u0090\5\22\n\2\u008f\u008d\3\2\2\2\u008f\u008e\3"+
		"\2\2\2\u0090\17\3\2\2\2\u0091\u0092\7\30\2\2\u0092\21\3\2\2\2\u0093\u0094"+
		"\7\30\2\2\u0094\u0095\7\4\2\2\u0095\u0096\7\30\2\2\u0096\23\3\2\2\2\u0097"+
		"\u0098\7\27\2\2\u0098\25\3\2\2\2\u0099\u009e\7\27\2\2\u009a\u009b\7\17"+
		"\2\2\u009b\u009d\7\27\2\2\u009c\u009a\3\2\2\2\u009d\u00a0\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\27\3\2\2\2\u00a0\u009e\3\2\2"+
		"\2\u00a1\u00a2\5\34\17\2\u00a2\u00a3\5\32\16\2\u00a3\u00a4\5\30\r\2\u00a4"+
		"\u00a7\3\2\2\2\u00a5\u00a7\5\34\17\2\u00a6\u00a1\3\2\2\2\u00a6\u00a5\3"+
		"\2\2\2\u00a7\31\3\2\2\2\u00a8\u00a9\t\2\2\2\u00a9\33\3\2\2\2\u00aa\u00ab"+
		"\5 \21\2\u00ab\u00ac\5\36\20\2\u00ac\u00ad\5\34\17\2\u00ad\u00b0\3\2\2"+
		"\2\u00ae\u00b0\5 \21\2\u00af\u00aa\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\35"+
		"\3\2\2\2\u00b1\u00b2\t\3\2\2\u00b2\37\3\2\2\2\u00b3\u00b8\5&\24\2\u00b4"+
		"\u00b8\5*\26\2\u00b5\u00b8\5(\25\2\u00b6\u00b8\5\"\22\2\u00b7\u00b3\3"+
		"\2\2\2\u00b7\u00b4\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8"+
		"!\3\2\2\2\u00b9\u00ba\5$\23\2\u00ba#\3\2\2\2\u00bb\u00c0\5,\27\2\u00bc"+
		"\u00c0\5.\30\2\u00bd\u00c0\5\60\31\2\u00be\u00c0\5\62\32\2\u00bf\u00bb"+
		"\3\2\2\2\u00bf\u00bc\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0"+
		"%\3\2\2\2\u00c1\u00c2\7\25\2\2\u00c2\u00c3\5\30\r\2\u00c3\u00c4\7\26\2"+
		"\2\u00c4\'\3\2\2\2\u00c5\u00ce\7\r\2\2\u00c6\u00cb\5\30\r\2\u00c7\u00c8"+
		"\7\6\2\2\u00c8\u00ca\5\30\r\2\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3\2\2\2"+
		"\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb"+
		"\3\2\2\2\u00ce\u00c6\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"\u00d1\7\16\2\2\u00d1)\3\2\2\2\u00d2\u00d5\7\27\2\2\u00d3\u00d4\7\17\2"+
		"\2\u00d4\u00d6\7\27\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"+\3\2\2\2\u00d7\u00d8\7\34\2\2\u00d8-\3\2\2\2\u00d9\u00da\7\30\2\2\u00da"+
		"/\3\2\2\2\u00db\u00dc\7\31\2\2\u00dc\61\3\2\2\2\u00dd\u00de\7\32\2\2\u00de"+
		"\63\3\2\2\2\31;DGKMTadhju\u0081\u0086\u008b\u008f\u009e\u00a6\u00af\u00b7"+
		"\u00bf\u00cb\u00ce\u00d5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}