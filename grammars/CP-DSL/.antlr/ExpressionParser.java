// Generated from e:\amack\Documents\UNI\Hiwi\antlr4-python\grammars\CP-DSL\Expression.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, ELONG=12, EDOUBLE=13, EBoolean=14, ID=15, INT=16, STRING=17, 
		ML_COMMENT=18, SL_COMMENT=19, ANY_OTHER=20;
	public static final int
		RULE_arithmeticExpression = 0, RULE_eAdditionOperator = 1, RULE_multiplicationExpression = 2, 
		RULE_eMultiplicationOperator = 3, RULE_valueExpression = 4, RULE_literalExpression = 5, 
		RULE_literal = 6, RULE_parenthesisExpression = 7, RULE_arrayExpression = 8, 
		RULE_namedElementReference = 9, RULE_stringValue = 10, RULE_longValue = 11, 
		RULE_doubleValue = 12, RULE_booleanValue = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"arithmeticExpression", "eAdditionOperator", "multiplicationExpression", 
			"eMultiplicationOperator", "valueExpression", "literalExpression", "literal", 
			"parenthesisExpression", "arrayExpression", "namedElementReference", 
			"stringValue", "longValue", "doubleValue", "booleanValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'%'", "'('", "')'", "'['", "','", 
			"']'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"ELONG", "EDOUBLE", "EBoolean", "ID", "INT", "STRING", "ML_COMMENT", 
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
	public String getGrammarFileName() { return "Expression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
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
		enterRule(_localctx, 0, RULE_arithmeticExpression);
		try {
			setState(33);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				((ArithmeticExpressionContext)_localctx).left = multiplicationExpression();
				setState(29);
				((ArithmeticExpressionContext)_localctx).op = eAdditionOperator();
				setState(30);
				((ArithmeticExpressionContext)_localctx).right = arithmeticExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
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
		enterRule(_localctx, 2, RULE_eAdditionOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
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
		enterRule(_localctx, 4, RULE_multiplicationExpression);
		try {
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				((MultiplicationExpressionContext)_localctx).left = valueExpression();
				setState(38);
				((MultiplicationExpressionContext)_localctx).op = eMultiplicationOperator();
				setState(39);
				((MultiplicationExpressionContext)_localctx).right = multiplicationExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
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
		enterRule(_localctx, 6, RULE_eMultiplicationOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) ) {
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
		enterRule(_localctx, 8, RULE_valueExpression);
		try {
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				parenthesisExpression();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				namedElementReference();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				arrayExpression();
				}
				break;
			case ELONG:
			case EDOUBLE:
			case EBoolean:
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
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
		enterRule(_localctx, 10, RULE_literalExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
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
		enterRule(_localctx, 12, RULE_literal);
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				stringValue();
				}
				break;
			case ELONG:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				longValue();
				}
				break;
			case EDOUBLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				doubleValue();
				}
				break;
			case EBoolean:
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
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
		enterRule(_localctx, 14, RULE_parenthesisExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__5);
			setState(61);
			((ParenthesisExpressionContext)_localctx).expression = arithmeticExpression();
			setState(62);
			match(T__6);
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
		enterRule(_localctx, 16, RULE_arrayExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__7);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << ELONG) | (1L << EDOUBLE) | (1L << EBoolean) | (1L << ID) | (1L << STRING))) != 0)) {
				{
				setState(65);
				((ArrayExpressionContext)_localctx).arithmeticExpression = arithmeticExpression();
				((ArrayExpressionContext)_localctx).elements.add(((ArrayExpressionContext)_localctx).arithmeticExpression);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(66);
					match(T__8);
					setState(67);
					((ArrayExpressionContext)_localctx).arithmeticExpression = arithmeticExpression();
					((ArrayExpressionContext)_localctx).elements.add(((ArrayExpressionContext)_localctx).arithmeticExpression);
					}
					}
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(75);
			match(T__9);
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
		public List<TerminalNode> ID() { return getTokens(ExpressionParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ExpressionParser.ID, i);
		}
		public NamedElementReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedElementReference; }
	}

	public final NamedElementReferenceContext namedElementReference() throws RecognitionException {
		NamedElementReferenceContext _localctx = new NamedElementReferenceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_namedElementReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			((NamedElementReferenceContext)_localctx).element = match(ID);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(78);
				match(T__10);
				setState(79);
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
		public TerminalNode STRING() { return getToken(ExpressionParser.STRING, 0); }
		public StringValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringValue; }
	}

	public final StringValueContext stringValue() throws RecognitionException {
		StringValueContext _localctx = new StringValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stringValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
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
		public TerminalNode ELONG() { return getToken(ExpressionParser.ELONG, 0); }
		public LongValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_longValue; }
	}

	public final LongValueContext longValue() throws RecognitionException {
		LongValueContext _localctx = new LongValueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_longValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
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
		public TerminalNode EDOUBLE() { return getToken(ExpressionParser.EDOUBLE, 0); }
		public DoubleValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleValue; }
	}

	public final DoubleValueContext doubleValue() throws RecognitionException {
		DoubleValueContext _localctx = new DoubleValueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_doubleValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
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
		public TerminalNode EBoolean() { return getToken(ExpressionParser.EBoolean, 0); }
		public BooleanValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanValue; }
	}

	public final BooleanValueContext booleanValue() throws RecognitionException {
		BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_booleanValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26]\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\5\2$\n\2\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\5\4-\n\4\3\5\3\5\3\6\3\6\3\6\3\6\5\6\65\n\6\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\5\b=\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\7\nG\n\n"+
		"\f\n\16\nJ\13\n\5\nL\n\n\3\n\3\n\3\13\3\13\3\13\5\13S\n\13\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\2\4\3\2\3\4\3\2\5\7\2Y\2#\3\2\2\2\4%\3\2\2\2\6,\3\2\2\2\b.\3\2\2\2"+
		"\n\64\3\2\2\2\f\66\3\2\2\2\16<\3\2\2\2\20>\3\2\2\2\22B\3\2\2\2\24O\3\2"+
		"\2\2\26T\3\2\2\2\30V\3\2\2\2\32X\3\2\2\2\34Z\3\2\2\2\36\37\5\6\4\2\37"+
		" \5\4\3\2 !\5\2\2\2!$\3\2\2\2\"$\5\6\4\2#\36\3\2\2\2#\"\3\2\2\2$\3\3\2"+
		"\2\2%&\t\2\2\2&\5\3\2\2\2\'(\5\n\6\2()\5\b\5\2)*\5\6\4\2*-\3\2\2\2+-\5"+
		"\n\6\2,\'\3\2\2\2,+\3\2\2\2-\7\3\2\2\2./\t\3\2\2/\t\3\2\2\2\60\65\5\20"+
		"\t\2\61\65\5\24\13\2\62\65\5\22\n\2\63\65\5\f\7\2\64\60\3\2\2\2\64\61"+
		"\3\2\2\2\64\62\3\2\2\2\64\63\3\2\2\2\65\13\3\2\2\2\66\67\5\16\b\2\67\r"+
		"\3\2\2\28=\5\26\f\29=\5\30\r\2:=\5\32\16\2;=\5\34\17\2<8\3\2\2\2<9\3\2"+
		"\2\2<:\3\2\2\2<;\3\2\2\2=\17\3\2\2\2>?\7\b\2\2?@\5\2\2\2@A\7\t\2\2A\21"+
		"\3\2\2\2BK\7\n\2\2CH\5\2\2\2DE\7\13\2\2EG\5\2\2\2FD\3\2\2\2GJ\3\2\2\2"+
		"HF\3\2\2\2HI\3\2\2\2IL\3\2\2\2JH\3\2\2\2KC\3\2\2\2KL\3\2\2\2LM\3\2\2\2"+
		"MN\7\f\2\2N\23\3\2\2\2OR\7\21\2\2PQ\7\r\2\2QS\7\21\2\2RP\3\2\2\2RS\3\2"+
		"\2\2S\25\3\2\2\2TU\7\23\2\2U\27\3\2\2\2VW\7\16\2\2W\31\3\2\2\2XY\7\17"+
		"\2\2Y\33\3\2\2\2Z[\7\20\2\2[\35\3\2\2\2\t#,\64<HKR";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}