// Generated from Configuration.g4 by ANTLR 4.10
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
	static { RuntimeMetaData.checkVersion("4.10", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, ID=21, QualifiedName=22, ELONG=23, EDOUBLE=24, 
		EBoolean=25, INT=26, STRING=27, ML_COMMENT=28, SL_COMMENT=29, ANY_OTHER=30;
	public static final int
		RULE_configurationModel = 0, RULE_include = 1, RULE_featureActivation = 2, 
		RULE_featureConfiguration = 3, RULE_parameterGroup = 4, RULE_parameterAssignment = 5, 
		RULE_selector = 6, RULE_elementSelector = 7, RULE_rangeSelector = 8, RULE_unitSpecification = 9, 
		RULE_arithmeticExpression = 10, RULE_eAdditionOperator = 11, RULE_multiplicationExpression = 12, 
		RULE_eMultiplicationOperator = 13, RULE_valueExpression = 14, RULE_literalExpression = 15, 
		RULE_literal = 16, RULE_parenthesisExpression = 17, RULE_arrayExpression = 18, 
		RULE_namedElementReference = 19, RULE_stringValue = 20, RULE_longValue = 21, 
		RULE_doubleValue = 22, RULE_booleanValue = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"configurationModel", "include", "featureActivation", "featureConfiguration", 
			"parameterGroup", "parameterAssignment", "selector", "elementSelector", 
			"rangeSelector", "unitSpecification", "arithmeticExpression", "eAdditionOperator", 
			"multiplicationExpression", "eMultiplicationOperator", "valueExpression", 
			"literalExpression", "literal", "parenthesisExpression", "arrayExpression", 
			"namedElementReference", "stringValue", "longValue", "doubleValue", "booleanValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'configuration'", "':'", "'activate'", "','", "'include'", "'!'", 
			"'feature'", "'{'", "'}'", "'group'", "'['", "']'", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'('", "')'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "ID", "QualifiedName", 
			"ELONG", "EDOUBLE", "EBoolean", "INT", "STRING", "ML_COMMENT", "SL_COMMENT", 
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterConfigurationModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitConfigurationModel(this);
		}
	}

	public final ConfigurationModelContext configurationModel() throws RecognitionException {
		ConfigurationModelContext _localctx = new ConfigurationModelContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_configurationModel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__0);
			setState(49);
			((ConfigurationModelContext)_localctx).name = match(ID);
			setState(50);
			match(T__1);
			setState(51);
			((ConfigurationModelContext)_localctx).declarationModel = match(ID);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(52);
				((ConfigurationModelContext)_localctx).include = include();
				((ConfigurationModelContext)_localctx).includes.add(((ConfigurationModelContext)_localctx).include);
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(58);
				match(T__2);
				setState(59);
				((ConfigurationModelContext)_localctx).featureActivation = featureActivation();
				((ConfigurationModelContext)_localctx).featureActivations.add(((ConfigurationModelContext)_localctx).featureActivation);
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(60);
					match(T__3);
					setState(61);
					((ConfigurationModelContext)_localctx).featureActivation = featureActivation();
					((ConfigurationModelContext)_localctx).featureActivations.add(((ConfigurationModelContext)_localctx).featureActivation);
					}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6 || _la==T__9) {
				{
				setState(71);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__9:
					{
					setState(69);
					((ConfigurationModelContext)_localctx).parameterGroup = parameterGroup();
					((ConfigurationModelContext)_localctx).parameterGroups.add(((ConfigurationModelContext)_localctx).parameterGroup);
					}
					break;
				case T__6:
					{
					setState(70);
					((ConfigurationModelContext)_localctx).featureConfiguration = featureConfiguration();
					((ConfigurationModelContext)_localctx).featureConfigurations.add(((ConfigurationModelContext)_localctx).featureConfiguration);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(75);
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
		public Token importedNamespace;
		public TerminalNode QualifiedName() { return getToken(ConfigurationParser.QualifiedName, 0); }
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterInclude(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitInclude(this);
		}
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__4);
			setState(77);
			((IncludeContext)_localctx).importedNamespace = match(QualifiedName);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterFeatureActivation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitFeatureActivation(this);
		}
	}

	public final FeatureActivationContext featureActivation() throws RecognitionException {
		FeatureActivationContext _localctx = new FeatureActivationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_featureActivation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(79);
				((FeatureActivationContext)_localctx).deactivated = match(T__5);
				}
			}

			setState(82);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterFeatureConfiguration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitFeatureConfiguration(this);
		}
	}

	public final FeatureConfigurationContext featureConfiguration() throws RecognitionException {
		FeatureConfigurationContext _localctx = new FeatureConfigurationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_featureConfiguration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__6);
			setState(85);
			((FeatureConfigurationContext)_localctx).declaration = match(ID);
			setState(86);
			match(T__7);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(87);
				match(T__2);
				setState(88);
				((FeatureConfigurationContext)_localctx).featureActivation = featureActivation();
				((FeatureConfigurationContext)_localctx).featureActivations.add(((FeatureConfigurationContext)_localctx).featureActivation);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(89);
					match(T__3);
					setState(90);
					((FeatureConfigurationContext)_localctx).featureActivation = featureActivation();
					((FeatureConfigurationContext)_localctx).featureActivations.add(((FeatureConfigurationContext)_localctx).featureActivation);
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6 || _la==T__9) {
				{
				setState(100);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__9:
					{
					setState(98);
					((FeatureConfigurationContext)_localctx).parameterGroup = parameterGroup();
					((FeatureConfigurationContext)_localctx).parameterGroups.add(((FeatureConfigurationContext)_localctx).parameterGroup);
					}
					break;
				case T__6:
					{
					setState(99);
					((FeatureConfigurationContext)_localctx).featureConfiguration = featureConfiguration();
					((FeatureConfigurationContext)_localctx).featureConfigurations.add(((FeatureConfigurationContext)_localctx).featureConfiguration);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterParameterGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitParameterGroup(this);
		}
	}

	public final ParameterGroupContext parameterGroup() throws RecognitionException {
		ParameterGroupContext _localctx = new ParameterGroupContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameterGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__9);
			setState(108);
			((ParameterGroupContext)_localctx).declaration = match(ID);
			setState(109);
			match(T__7);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==QualifiedName) {
				{
				{
				setState(110);
				((ParameterGroupContext)_localctx).parameterAssignment = parameterAssignment();
				((ParameterGroupContext)_localctx).parameters.add(((ParameterGroupContext)_localctx).parameterAssignment);
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
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
		public Token declaration;
		public SelectorContext selector;
		public List<SelectorContext> selectors = new ArrayList<SelectorContext>();
		public ArithmeticExpressionContext value;
		public UnitSpecificationContext unit;
		public TerminalNode QualifiedName() { return getToken(ConfigurationParser.QualifiedName, 0); }
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterParameterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitParameterAssignment(this);
		}
	}

	public final ParameterAssignmentContext parameterAssignment() throws RecognitionException {
		ParameterAssignmentContext _localctx = new ParameterAssignmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameterAssignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			((ParameterAssignmentContext)_localctx).declaration = match(QualifiedName);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(119);
				match(T__10);
				setState(120);
				((ParameterAssignmentContext)_localctx).selector = selector();
				((ParameterAssignmentContext)_localctx).selectors.add(((ParameterAssignmentContext)_localctx).selector);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(121);
					match(T__3);
					setState(122);
					((ParameterAssignmentContext)_localctx).selector = selector();
					((ParameterAssignmentContext)_localctx).selectors.add(((ParameterAssignmentContext)_localctx).selector);
					}
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(128);
				match(T__11);
				}
			}

			setState(132);
			match(T__1);
			setState(133);
			((ParameterAssignmentContext)_localctx).value = arithmeticExpression();
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(134);
				((ParameterAssignmentContext)_localctx).unit = unitSpecification();
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitSelector(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_selector);
		try {
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				elementSelector();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterElementSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitElementSelector(this);
		}
	}

	public final ElementSelectorContext elementSelector() throws RecognitionException {
		ElementSelectorContext _localctx = new ElementSelectorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_elementSelector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterRangeSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitRangeSelector(this);
		}
	}

	public final RangeSelectorContext rangeSelector() throws RecognitionException {
		RangeSelectorContext _localctx = new RangeSelectorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rangeSelector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			((RangeSelectorContext)_localctx).lowerBound = match(ELONG);
			setState(144);
			match(T__1);
			setState(145);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterUnitSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitUnitSpecification(this);
		}
	}

	public final UnitSpecificationContext unitSpecification() throws RecognitionException {
		UnitSpecificationContext _localctx = new UnitSpecificationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_unitSpecification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterArithmeticExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitArithmeticExpression(this);
		}
	}

	public final ArithmeticExpressionContext arithmeticExpression() throws RecognitionException {
		ArithmeticExpressionContext _localctx = new ArithmeticExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arithmeticExpression);
		try {
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				((ArithmeticExpressionContext)_localctx).left = multiplicationExpression();
				setState(150);
				((ArithmeticExpressionContext)_localctx).op = eAdditionOperator();
				setState(151);
				((ArithmeticExpressionContext)_localctx).right = arithmeticExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterEAdditionOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitEAdditionOperator(this);
		}
	}

	public final EAdditionOperatorContext eAdditionOperator() throws RecognitionException {
		EAdditionOperatorContext _localctx = new EAdditionOperatorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_eAdditionOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_la = _input.LA(1);
			if ( !(_la==T__12 || _la==T__13) ) {
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterMultiplicationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitMultiplicationExpression(this);
		}
	}

	public final MultiplicationExpressionContext multiplicationExpression() throws RecognitionException {
		MultiplicationExpressionContext _localctx = new MultiplicationExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_multiplicationExpression);
		try {
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				((MultiplicationExpressionContext)_localctx).left = valueExpression();
				setState(159);
				((MultiplicationExpressionContext)_localctx).op = eMultiplicationOperator();
				setState(160);
				((MultiplicationExpressionContext)_localctx).right = multiplicationExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterEMultiplicationOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitEMultiplicationOperator(this);
		}
	}

	public final EMultiplicationOperatorContext eMultiplicationOperator() throws RecognitionException {
		EMultiplicationOperatorContext _localctx = new EMultiplicationOperatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_eMultiplicationOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) ) {
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterValueExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitValueExpression(this);
		}
	}

	public final ValueExpressionContext valueExpression() throws RecognitionException {
		ValueExpressionContext _localctx = new ValueExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_valueExpression);
		try {
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				parenthesisExpression();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				namedElementReference();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				arrayExpression();
				}
				break;
			case ELONG:
			case EDOUBLE:
			case EBoolean:
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitLiteralExpression(this);
		}
	}

	public final LiteralExpressionContext literalExpression() throws RecognitionException {
		LiteralExpressionContext _localctx = new LiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_literalExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_literal);
		try {
			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				stringValue();
				}
				break;
			case ELONG:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				longValue();
				}
				break;
			case EDOUBLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				doubleValue();
				}
				break;
			case EBoolean:
				enterOuterAlt(_localctx, 4);
				{
				setState(178);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterParenthesisExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitParenthesisExpression(this);
		}
	}

	public final ParenthesisExpressionContext parenthesisExpression() throws RecognitionException {
		ParenthesisExpressionContext _localctx = new ParenthesisExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_parenthesisExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(T__17);
			setState(182);
			((ParenthesisExpressionContext)_localctx).expression = arithmeticExpression();
			setState(183);
			match(T__18);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterArrayExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitArrayExpression(this);
		}
	}

	public final ArrayExpressionContext arrayExpression() throws RecognitionException {
		ArrayExpressionContext _localctx = new ArrayExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arrayExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__10);
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__17) | (1L << ID) | (1L << ELONG) | (1L << EDOUBLE) | (1L << EBoolean) | (1L << STRING))) != 0)) {
				{
				setState(186);
				((ArrayExpressionContext)_localctx).arithmeticExpression = arithmeticExpression();
				((ArrayExpressionContext)_localctx).elements.add(((ArrayExpressionContext)_localctx).arithmeticExpression);
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(187);
					match(T__3);
					setState(188);
					((ArrayExpressionContext)_localctx).arithmeticExpression = arithmeticExpression();
					((ArrayExpressionContext)_localctx).elements.add(((ArrayExpressionContext)_localctx).arithmeticExpression);
					}
					}
					setState(193);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(196);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterNamedElementReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitNamedElementReference(this);
		}
	}

	public final NamedElementReferenceContext namedElementReference() throws RecognitionException {
		NamedElementReferenceContext _localctx = new NamedElementReferenceContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_namedElementReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			((NamedElementReferenceContext)_localctx).element = match(ID);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(199);
				match(T__19);
				setState(200);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterStringValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitStringValue(this);
		}
	}

	public final StringValueContext stringValue() throws RecognitionException {
		StringValueContext _localctx = new StringValueContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_stringValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterLongValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitLongValue(this);
		}
	}

	public final LongValueContext longValue() throws RecognitionException {
		LongValueContext _localctx = new LongValueContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_longValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterDoubleValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitDoubleValue(this);
		}
	}

	public final DoubleValueContext doubleValue() throws RecognitionException {
		DoubleValueContext _localctx = new DoubleValueContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_doubleValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterBooleanValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitBooleanValue(this);
		}
	}

	public final BooleanValueContext booleanValue() throws RecognitionException {
		BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_booleanValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
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
		"\u0004\u0001\u001e\u00d4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u00006\b\u0000\n\u0000"+
		"\f\u00009\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005"+
		"\u0000?\b\u0000\n\u0000\f\u0000B\t\u0000\u0003\u0000D\b\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000H\b\u0000\n\u0000\f\u0000K\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0003\u0002Q\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003\\\b\u0003\n\u0003\f\u0003_\t\u0003"+
		"\u0003\u0003a\b\u0003\u0001\u0003\u0001\u0003\u0005\u0003e\b\u0003\n\u0003"+
		"\f\u0003h\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004p\b\u0004\n\u0004\f\u0004s\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005|\b\u0005\n\u0005\f\u0005\u007f\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u0083\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u0088\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006\u008c\b"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u009b\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00a4"+
		"\b\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u00ac\b\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u00b4\b\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005"+
		"\u0012\u00be\b\u0012\n\u0012\f\u0012\u00c1\t\u0012\u0003\u0012\u00c3\b"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u00ca\b\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0000\u0000\u0018"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.\u0000\u0002\u0001\u0000\r\u000e\u0001\u0000\u000f"+
		"\u0011\u00d5\u00000\u0001\u0000\u0000\u0000\u0002L\u0001\u0000\u0000\u0000"+
		"\u0004P\u0001\u0000\u0000\u0000\u0006T\u0001\u0000\u0000\u0000\bk\u0001"+
		"\u0000\u0000\u0000\nv\u0001\u0000\u0000\u0000\f\u008b\u0001\u0000\u0000"+
		"\u0000\u000e\u008d\u0001\u0000\u0000\u0000\u0010\u008f\u0001\u0000\u0000"+
		"\u0000\u0012\u0093\u0001\u0000\u0000\u0000\u0014\u009a\u0001\u0000\u0000"+
		"\u0000\u0016\u009c\u0001\u0000\u0000\u0000\u0018\u00a3\u0001\u0000\u0000"+
		"\u0000\u001a\u00a5\u0001\u0000\u0000\u0000\u001c\u00ab\u0001\u0000\u0000"+
		"\u0000\u001e\u00ad\u0001\u0000\u0000\u0000 \u00b3\u0001\u0000\u0000\u0000"+
		"\"\u00b5\u0001\u0000\u0000\u0000$\u00b9\u0001\u0000\u0000\u0000&\u00c6"+
		"\u0001\u0000\u0000\u0000(\u00cb\u0001\u0000\u0000\u0000*\u00cd\u0001\u0000"+
		"\u0000\u0000,\u00cf\u0001\u0000\u0000\u0000.\u00d1\u0001\u0000\u0000\u0000"+
		"01\u0005\u0001\u0000\u000012\u0005\u0015\u0000\u000023\u0005\u0002\u0000"+
		"\u000037\u0005\u0015\u0000\u000046\u0003\u0002\u0001\u000054\u0001\u0000"+
		"\u0000\u000069\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001"+
		"\u0000\u0000\u00008C\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000"+
		":;\u0005\u0003\u0000\u0000;@\u0003\u0004\u0002\u0000<=\u0005\u0004\u0000"+
		"\u0000=?\u0003\u0004\u0002\u0000><\u0001\u0000\u0000\u0000?B\u0001\u0000"+
		"\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AD\u0001"+
		"\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000C:\u0001\u0000\u0000\u0000"+
		"CD\u0001\u0000\u0000\u0000DI\u0001\u0000\u0000\u0000EH\u0003\b\u0004\u0000"+
		"FH\u0003\u0006\u0003\u0000GE\u0001\u0000\u0000\u0000GF\u0001\u0000\u0000"+
		"\u0000HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000"+
		"\u0000\u0000J\u0001\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000"+
		"LM\u0005\u0005\u0000\u0000MN\u0005\u0016\u0000\u0000N\u0003\u0001\u0000"+
		"\u0000\u0000OQ\u0005\u0006\u0000\u0000PO\u0001\u0000\u0000\u0000PQ\u0001"+
		"\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RS\u0005\u0015\u0000\u0000"+
		"S\u0005\u0001\u0000\u0000\u0000TU\u0005\u0007\u0000\u0000UV\u0005\u0015"+
		"\u0000\u0000V`\u0005\b\u0000\u0000WX\u0005\u0003\u0000\u0000X]\u0003\u0004"+
		"\u0002\u0000YZ\u0005\u0004\u0000\u0000Z\\\u0003\u0004\u0002\u0000[Y\u0001"+
		"\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000"+
		"]^\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000"+
		"\u0000`W\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000af\u0001\u0000"+
		"\u0000\u0000be\u0003\b\u0004\u0000ce\u0003\u0006\u0003\u0000db\u0001\u0000"+
		"\u0000\u0000dc\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000fd\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gi\u0001\u0000\u0000\u0000"+
		"hf\u0001\u0000\u0000\u0000ij\u0005\t\u0000\u0000j\u0007\u0001\u0000\u0000"+
		"\u0000kl\u0005\n\u0000\u0000lm\u0005\u0015\u0000\u0000mq\u0005\b\u0000"+
		"\u0000np\u0003\n\u0005\u0000on\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000"+
		"\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rt\u0001\u0000"+
		"\u0000\u0000sq\u0001\u0000\u0000\u0000tu\u0005\t\u0000\u0000u\t\u0001"+
		"\u0000\u0000\u0000v\u0082\u0005\u0016\u0000\u0000wx\u0005\u000b\u0000"+
		"\u0000x}\u0003\f\u0006\u0000yz\u0005\u0004\u0000\u0000z|\u0003\f\u0006"+
		"\u0000{y\u0001\u0000\u0000\u0000|\u007f\u0001\u0000\u0000\u0000}{\u0001"+
		"\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080\u0001\u0000\u0000"+
		"\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0081\u0005\f\u0000\u0000"+
		"\u0081\u0083\u0001\u0000\u0000\u0000\u0082w\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084"+
		"\u0085\u0005\u0002\u0000\u0000\u0085\u0087\u0003\u0014\n\u0000\u0086\u0088"+
		"\u0003\u0012\t\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0087\u0088\u0001"+
		"\u0000\u0000\u0000\u0088\u000b\u0001\u0000\u0000\u0000\u0089\u008c\u0003"+
		"\u000e\u0007\u0000\u008a\u008c\u0003\u0010\b\u0000\u008b\u0089\u0001\u0000"+
		"\u0000\u0000\u008b\u008a\u0001\u0000\u0000\u0000\u008c\r\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0005\u0017\u0000\u0000\u008e\u000f\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0005\u0017\u0000\u0000\u0090\u0091\u0005\u0002\u0000"+
		"\u0000\u0091\u0092\u0005\u0017\u0000\u0000\u0092\u0011\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0005\u0015\u0000\u0000\u0094\u0013\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0003\u0018\f\u0000\u0096\u0097\u0003\u0016\u000b\u0000"+
		"\u0097\u0098\u0003\u0014\n\u0000\u0098\u009b\u0001\u0000\u0000\u0000\u0099"+
		"\u009b\u0003\u0018\f\u0000\u009a\u0095\u0001\u0000\u0000\u0000\u009a\u0099"+
		"\u0001\u0000\u0000\u0000\u009b\u0015\u0001\u0000\u0000\u0000\u009c\u009d"+
		"\u0007\u0000\u0000\u0000\u009d\u0017\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0003\u001c\u000e\u0000\u009f\u00a0\u0003\u001a\r\u0000\u00a0\u00a1\u0003"+
		"\u0018\f\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a4\u0003\u001c"+
		"\u000e\u0000\u00a3\u009e\u0001\u0000\u0000\u0000\u00a3\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a4\u0019\u0001\u0000\u0000\u0000\u00a5\u00a6\u0007\u0001"+
		"\u0000\u0000\u00a6\u001b\u0001\u0000\u0000\u0000\u00a7\u00ac\u0003\"\u0011"+
		"\u0000\u00a8\u00ac\u0003&\u0013\u0000\u00a9\u00ac\u0003$\u0012\u0000\u00aa"+
		"\u00ac\u0003\u001e\u000f\u0000\u00ab\u00a7\u0001\u0000\u0000\u0000\u00ab"+
		"\u00a8\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ac\u001d\u0001\u0000\u0000\u0000\u00ad"+
		"\u00ae\u0003 \u0010\u0000\u00ae\u001f\u0001\u0000\u0000\u0000\u00af\u00b4"+
		"\u0003(\u0014\u0000\u00b0\u00b4\u0003*\u0015\u0000\u00b1\u00b4\u0003,"+
		"\u0016\u0000\u00b2\u00b4\u0003.\u0017\u0000\u00b3\u00af\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4!\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b6\u0005\u0012\u0000\u0000\u00b6\u00b7\u0003\u0014\n\u0000\u00b7"+
		"\u00b8\u0005\u0013\u0000\u0000\u00b8#\u0001\u0000\u0000\u0000\u00b9\u00c2"+
		"\u0005\u000b\u0000\u0000\u00ba\u00bf\u0003\u0014\n\u0000\u00bb\u00bc\u0005"+
		"\u0004\u0000\u0000\u00bc\u00be\u0003\u0014\n\u0000\u00bd\u00bb\u0001\u0000"+
		"\u0000\u0000\u00be\u00c1\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c2\u00ba\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c5\u0005\f\u0000\u0000\u00c5%\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c9\u0005\u0015\u0000\u0000\u00c7\u00c8\u0005\u0014\u0000"+
		"\u0000\u00c8\u00ca\u0005\u0015\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000"+
		"\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\'\u0001\u0000\u0000\u0000"+
		"\u00cb\u00cc\u0005\u001b\u0000\u0000\u00cc)\u0001\u0000\u0000\u0000\u00cd"+
		"\u00ce\u0005\u0017\u0000\u0000\u00ce+\u0001\u0000\u0000\u0000\u00cf\u00d0"+
		"\u0005\u0018\u0000\u0000\u00d0-\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005"+
		"\u0019\u0000\u0000\u00d2/\u0001\u0000\u0000\u0000\u00167@CGIP]`dfq}\u0082"+
		"\u0087\u008b\u009a\u00a3\u00ab\u00b3\u00bf\u00c2\u00c9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}