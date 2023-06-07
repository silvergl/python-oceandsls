// Generated from c:\Users\amack\Documents\UNI\python-oceandsls\cp-dsl\confLSPServer\grammars\Configuration.g4 by ANTLR 4.9.2
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
		T__17=18, T__18=19, T__19=20, ID=21, QualifiedName=22, ELONG=23, EDOUBLE=24, 
		EBoolean=25, INT=26, STRING=27, WS=28, ML_COMMENT=29, SL_COMMENT=30, ANY_OTHER=31;
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
			"ELONG", "EDOUBLE", "EBoolean", "INT", "STRING", "WS", "ML_COMMENT", 
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
		public FeatureActivationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureActivation; }
	 
		public FeatureActivationContext() { }
		public void copyFrom(FeatureActivationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FeatureActivateContext extends FeatureActivationContext {
		public Token deactivated;
		public Token declaration;
		public TerminalNode ID() { return getToken(ConfigurationParser.ID, 0); }
		public FeatureActivateContext(FeatureActivationContext ctx) { copyFrom(ctx); }
	}

	public final FeatureActivationContext featureActivation() throws RecognitionException {
		FeatureActivationContext _localctx = new FeatureActivationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_featureActivation);
		int _la;
		try {
			_localctx = new FeatureActivateContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(79);
				((FeatureActivateContext)_localctx).deactivated = match(T__5);
				}
			}

			setState(82);
			((FeatureActivateContext)_localctx).declaration = match(ID);
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
		public FeatureConfigurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureConfiguration; }
	 
		public FeatureConfigurationContext() { }
		public void copyFrom(FeatureConfigurationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FeatureConfigContext extends FeatureConfigurationContext {
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
		public FeatureConfigContext(FeatureConfigurationContext ctx) { copyFrom(ctx); }
	}

	public final FeatureConfigurationContext featureConfiguration() throws RecognitionException {
		FeatureConfigurationContext _localctx = new FeatureConfigurationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_featureConfiguration);
		int _la;
		try {
			_localctx = new FeatureConfigContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__6);
			setState(85);
			((FeatureConfigContext)_localctx).declaration = match(ID);
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
				((FeatureConfigContext)_localctx).featureActivation = featureActivation();
				((FeatureConfigContext)_localctx).featureActivations.add(((FeatureConfigContext)_localctx).featureActivation);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(89);
					match(T__3);
					setState(90);
					((FeatureConfigContext)_localctx).featureActivation = featureActivation();
					((FeatureConfigContext)_localctx).featureActivations.add(((FeatureConfigContext)_localctx).featureActivation);
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
					((FeatureConfigContext)_localctx).parameterGroup = parameterGroup();
					((FeatureConfigContext)_localctx).parameterGroups.add(((FeatureConfigContext)_localctx).parameterGroup);
					}
					break;
				case T__6:
					{
					setState(99);
					((FeatureConfigContext)_localctx).featureConfiguration = featureConfiguration();
					((FeatureConfigContext)_localctx).featureConfigurations.add(((FeatureConfigContext)_localctx).featureConfiguration);
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
		public ParameterGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterGroup; }
	 
		public ParameterGroupContext() { }
		public void copyFrom(ParameterGroupContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParamGroupContext extends ParameterGroupContext {
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
		public ParamGroupContext(ParameterGroupContext ctx) { copyFrom(ctx); }
	}

	public final ParameterGroupContext parameterGroup() throws RecognitionException {
		ParameterGroupContext _localctx = new ParameterGroupContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameterGroup);
		int _la;
		try {
			_localctx = new ParamGroupContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__9);
			setState(108);
			((ParamGroupContext)_localctx).declaration = match(ID);
			setState(109);
			match(T__7);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==QualifiedName) {
				{
				{
				setState(110);
				((ParamGroupContext)_localctx).parameterAssignment = parameterAssignment();
				((ParamGroupContext)_localctx).parameters.add(((ParamGroupContext)_localctx).parameterAssignment);
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
		public ParameterAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterAssignment; }
	 
		public ParameterAssignmentContext() { }
		public void copyFrom(ParameterAssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParameterAssignContext extends ParameterAssignmentContext {
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
		public ParameterAssignContext(ParameterAssignmentContext ctx) { copyFrom(ctx); }
	}

	public final ParameterAssignmentContext parameterAssignment() throws RecognitionException {
		ParameterAssignmentContext _localctx = new ParameterAssignmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameterAssignment);
		int _la;
		try {
			_localctx = new ParameterAssignContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			((ParameterAssignContext)_localctx).declaration = match(QualifiedName);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(119);
				match(T__10);
				setState(120);
				((ParameterAssignContext)_localctx).selector = selector();
				((ParameterAssignContext)_localctx).selectors.add(((ParameterAssignContext)_localctx).selector);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(121);
					match(T__3);
					setState(122);
					((ParameterAssignContext)_localctx).selector = selector();
					((ParameterAssignContext)_localctx).selectors.add(((ParameterAssignContext)_localctx).selector);
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
			((ParameterAssignContext)_localctx).value = arithmeticExpression();
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(134);
				((ParameterAssignContext)_localctx).unit = unitSpecification();
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
		public UnitSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unitSpecification; }
	 
		public UnitSpecificationContext() { }
		public void copyFrom(UnitSpecificationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnitSpecContext extends UnitSpecificationContext {
		public Token unit;
		public TerminalNode ID() { return getToken(ConfigurationParser.ID, 0); }
		public UnitSpecContext(UnitSpecificationContext ctx) { copyFrom(ctx); }
	}

	public final UnitSpecificationContext unitSpecification() throws RecognitionException {
		UnitSpecificationContext _localctx = new UnitSpecificationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_unitSpecification);
		try {
			_localctx = new UnitSpecContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			((UnitSpecContext)_localctx).unit = match(ID);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00d6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\3\2\3\2\7\28\n\2\f\2\16\2;\13\2\3\2\3\2\3\2\3\2\7\2A\n\2"+
		"\f\2\16\2D\13\2\5\2F\n\2\3\2\3\2\7\2J\n\2\f\2\16\2M\13\2\3\3\3\3\3\3\3"+
		"\4\5\4S\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5^\n\5\f\5\16\5a\13"+
		"\5\5\5c\n\5\3\5\3\5\7\5g\n\5\f\5\16\5j\13\5\3\5\3\5\3\6\3\6\3\6\3\6\7"+
		"\6r\n\6\f\6\16\6u\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7~\n\7\f\7\16\7\u0081"+
		"\13\7\3\7\3\7\5\7\u0085\n\7\3\7\3\7\3\7\5\7\u008a\n\7\3\b\3\b\5\b\u008e"+
		"\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u009d\n"+
		"\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\5\16\u00a6\n\16\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\5\20\u00ae\n\20\3\21\3\21\3\22\3\22\3\22\3\22\5\22\u00b6\n"+
		"\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u00c0\n\24\f\24\16\24"+
		"\u00c3\13\24\5\24\u00c5\n\24\3\24\3\24\3\25\3\25\3\25\5\25\u00cc\n\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\2\2\32\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\2\4\3\2\17\20\3\2\21\23\2\u00d7\2\62"+
		"\3\2\2\2\4N\3\2\2\2\6R\3\2\2\2\bV\3\2\2\2\nm\3\2\2\2\fx\3\2\2\2\16\u008d"+
		"\3\2\2\2\20\u008f\3\2\2\2\22\u0091\3\2\2\2\24\u0095\3\2\2\2\26\u009c\3"+
		"\2\2\2\30\u009e\3\2\2\2\32\u00a5\3\2\2\2\34\u00a7\3\2\2\2\36\u00ad\3\2"+
		"\2\2 \u00af\3\2\2\2\"\u00b5\3\2\2\2$\u00b7\3\2\2\2&\u00bb\3\2\2\2(\u00c8"+
		"\3\2\2\2*\u00cd\3\2\2\2,\u00cf\3\2\2\2.\u00d1\3\2\2\2\60\u00d3\3\2\2\2"+
		"\62\63\7\3\2\2\63\64\7\27\2\2\64\65\7\4\2\2\659\7\27\2\2\668\5\4\3\2\67"+
		"\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:E\3\2\2\2;9\3\2\2\2<=\7\5"+
		"\2\2=B\5\6\4\2>?\7\6\2\2?A\5\6\4\2@>\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2"+
		"\2\2CF\3\2\2\2DB\3\2\2\2E<\3\2\2\2EF\3\2\2\2FK\3\2\2\2GJ\5\n\6\2HJ\5\b"+
		"\5\2IG\3\2\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\3\3\2\2\2MK\3"+
		"\2\2\2NO\7\7\2\2OP\7\30\2\2P\5\3\2\2\2QS\7\b\2\2RQ\3\2\2\2RS\3\2\2\2S"+
		"T\3\2\2\2TU\7\27\2\2U\7\3\2\2\2VW\7\t\2\2WX\7\27\2\2Xb\7\n\2\2YZ\7\5\2"+
		"\2Z_\5\6\4\2[\\\7\6\2\2\\^\5\6\4\2][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2"+
		"\2\2`c\3\2\2\2a_\3\2\2\2bY\3\2\2\2bc\3\2\2\2ch\3\2\2\2dg\5\n\6\2eg\5\b"+
		"\5\2fd\3\2\2\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2"+
		"\2\2kl\7\13\2\2l\t\3\2\2\2mn\7\f\2\2no\7\27\2\2os\7\n\2\2pr\5\f\7\2qp"+
		"\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\7\13\2\2"+
		"w\13\3\2\2\2x\u0084\7\30\2\2yz\7\r\2\2z\177\5\16\b\2{|\7\6\2\2|~\5\16"+
		"\b\2}{\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082"+
		"\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083\7\16\2\2\u0083\u0085\3\2\2\2\u0084"+
		"y\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\7\4\2\2"+
		"\u0087\u0089\5\26\f\2\u0088\u008a\5\24\13\2\u0089\u0088\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\r\3\2\2\2\u008b\u008e\5\20\t\2\u008c\u008e\5\22\n"+
		"\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\17\3\2\2\2\u008f\u0090"+
		"\7\31\2\2\u0090\21\3\2\2\2\u0091\u0092\7\31\2\2\u0092\u0093\7\4\2\2\u0093"+
		"\u0094\7\31\2\2\u0094\23\3\2\2\2\u0095\u0096\7\27\2\2\u0096\25\3\2\2\2"+
		"\u0097\u0098\5\32\16\2\u0098\u0099\5\30\r\2\u0099\u009a\5\26\f\2\u009a"+
		"\u009d\3\2\2\2\u009b\u009d\5\32\16\2\u009c\u0097\3\2\2\2\u009c\u009b\3"+
		"\2\2\2\u009d\27\3\2\2\2\u009e\u009f\t\2\2\2\u009f\31\3\2\2\2\u00a0\u00a1"+
		"\5\36\20\2\u00a1\u00a2\5\34\17\2\u00a2\u00a3\5\32\16\2\u00a3\u00a6\3\2"+
		"\2\2\u00a4\u00a6\5\36\20\2\u00a5\u00a0\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6"+
		"\33\3\2\2\2\u00a7\u00a8\t\3\2\2\u00a8\35\3\2\2\2\u00a9\u00ae\5$\23\2\u00aa"+
		"\u00ae\5(\25\2\u00ab\u00ae\5&\24\2\u00ac\u00ae\5 \21\2\u00ad\u00a9\3\2"+
		"\2\2\u00ad\u00aa\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae"+
		"\37\3\2\2\2\u00af\u00b0\5\"\22\2\u00b0!\3\2\2\2\u00b1\u00b6\5*\26\2\u00b2"+
		"\u00b6\5,\27\2\u00b3\u00b6\5.\30\2\u00b4\u00b6\5\60\31\2\u00b5\u00b1\3"+
		"\2\2\2\u00b5\u00b2\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6"+
		"#\3\2\2\2\u00b7\u00b8\7\24\2\2\u00b8\u00b9\5\26\f\2\u00b9\u00ba\7\25\2"+
		"\2\u00ba%\3\2\2\2\u00bb\u00c4\7\r\2\2\u00bc\u00c1\5\26\f\2\u00bd\u00be"+
		"\7\6\2\2\u00be\u00c0\5\26\f\2\u00bf\u00bd\3\2\2\2\u00c0\u00c3\3\2\2\2"+
		"\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1"+
		"\3\2\2\2\u00c4\u00bc\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c7\7\16\2\2\u00c7\'\3\2\2\2\u00c8\u00cb\7\27\2\2\u00c9\u00ca\7\26"+
		"\2\2\u00ca\u00cc\7\27\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		")\3\2\2\2\u00cd\u00ce\7\35\2\2\u00ce+\3\2\2\2\u00cf\u00d0\7\31\2\2\u00d0"+
		"-\3\2\2\2\u00d1\u00d2\7\32\2\2\u00d2/\3\2\2\2\u00d3\u00d4\7\33\2\2\u00d4"+
		"\61\3\2\2\2\309BEIKR_bfhs\177\u0084\u0089\u008d\u009c\u00a5\u00ad\u00b5"+
		"\u00c1\u00c4\u00cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}