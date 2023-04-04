// Generated from e:\amack\Documents\UNI\Hiwi\antlr4-python\grammars\CP-DSL\Expression.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, ELONG=12, EDOUBLE=13, EBoolean=14, ID=15, INT=16, STRING=17, 
		ML_COMMENT=18, SL_COMMENT=19, ANY_OTHER=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "ELONG", "EDOUBLE", "EBoolean", "ID", "INT", "STRING", 
			"ML_COMMENT", "SL_COMMENT", "ANY_OTHER"
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


	public ExpressionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u00a5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\5\rC\n\r"+
		"\3\r\3\r\3\16\5\16H\n\16\3\16\5\16K\n\16\3\16\3\16\3\16\3\16\5\16Q\n\16"+
		"\3\16\5\16T\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17_\n"+
		"\17\3\20\5\20b\n\20\3\20\5\20e\n\20\3\20\7\20h\n\20\f\20\16\20k\13\20"+
		"\3\21\6\21n\n\21\r\21\16\21o\3\22\3\22\3\22\3\22\7\22v\n\22\f\22\16\22"+
		"y\13\22\3\22\3\22\3\22\3\22\3\22\7\22\u0080\n\22\f\22\16\22\u0083\13\22"+
		"\3\22\5\22\u0086\n\22\3\23\3\23\3\23\3\23\7\23\u008c\n\23\f\23\16\23\u008f"+
		"\13\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u009a\n\24\f"+
		"\24\16\24\u009d\13\24\3\24\5\24\u00a0\n\24\3\24\3\24\3\25\3\25\3\u008d"+
		"\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26\3\2\n\4\2GGgg\5\2C\\aac|\6\2\62;C\\aac"+
		"|\3\2\62;\4\2$$^^\4\2))^^\5\2\f\f\17\17~~\5\2\f\f\17\17AA\2\u00b5\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5-\3\2\2\2\7/\3\2\2\2\t"+
		"\61\3\2\2\2\13\63\3\2\2\2\r\65\3\2\2\2\17\67\3\2\2\2\219\3\2\2\2\23;\3"+
		"\2\2\2\25=\3\2\2\2\27?\3\2\2\2\31B\3\2\2\2\33G\3\2\2\2\35^\3\2\2\2\37"+
		"a\3\2\2\2!m\3\2\2\2#\u0085\3\2\2\2%\u0087\3\2\2\2\'\u0095\3\2\2\2)\u00a3"+
		"\3\2\2\2+,\7-\2\2,\4\3\2\2\2-.\7/\2\2.\6\3\2\2\2/\60\7,\2\2\60\b\3\2\2"+
		"\2\61\62\7\61\2\2\62\n\3\2\2\2\63\64\7\'\2\2\64\f\3\2\2\2\65\66\7*\2\2"+
		"\66\16\3\2\2\2\678\7+\2\28\20\3\2\2\29:\7]\2\2:\22\3\2\2\2;<\7.\2\2<\24"+
		"\3\2\2\2=>\7_\2\2>\26\3\2\2\2?@\7\60\2\2@\30\3\2\2\2AC\7/\2\2BA\3\2\2"+
		"\2BC\3\2\2\2CD\3\2\2\2DE\5!\21\2E\32\3\2\2\2FH\7/\2\2GF\3\2\2\2GH\3\2"+
		"\2\2HJ\3\2\2\2IK\5!\21\2JI\3\2\2\2JK\3\2\2\2KL\3\2\2\2LM\7\60\2\2MS\5"+
		"!\21\2NP\t\2\2\2OQ\7/\2\2PO\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RT\5!\21\2SN\3"+
		"\2\2\2ST\3\2\2\2T\34\3\2\2\2UV\7v\2\2VW\7t\2\2WX\7w\2\2X_\7g\2\2YZ\7h"+
		"\2\2Z[\7c\2\2[\\\7n\2\2\\]\7u\2\2]_\7g\2\2^U\3\2\2\2^Y\3\2\2\2_\36\3\2"+
		"\2\2`b\7`\2\2a`\3\2\2\2ab\3\2\2\2bd\3\2\2\2ce\t\3\2\2dc\3\2\2\2ei\3\2"+
		"\2\2fh\t\4\2\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j \3\2\2\2ki\3\2"+
		"\2\2ln\t\5\2\2ml\3\2\2\2no\3\2\2\2om\3\2\2\2op\3\2\2\2p\"\3\2\2\2qw\7"+
		"$\2\2rs\7^\2\2sv\13\2\2\2tv\n\6\2\2ur\3\2\2\2ut\3\2\2\2vy\3\2\2\2wu\3"+
		"\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z\u0086\7$\2\2{\u0081\7)\2\2|}\7^"+
		"\2\2}\u0080\13\2\2\2~\u0080\n\7\2\2\177|\3\2\2\2\177~\3\2\2\2\u0080\u0083"+
		"\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0084\u0086\7)\2\2\u0085q\3\2\2\2\u0085{\3\2\2\2\u0086"+
		"$\3\2\2\2\u0087\u0088\7\61\2\2\u0088\u0089\7,\2\2\u0089\u008d\3\2\2\2"+
		"\u008a\u008c\13\2\2\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090"+
		"\u0091\7,\2\2\u0091\u0092\7\61\2\2\u0092\u0093\3\2\2\2\u0093\u0094\b\23"+
		"\2\2\u0094&\3\2\2\2\u0095\u0096\7\61\2\2\u0096\u0097\7\61\2\2\u0097\u009b"+
		"\3\2\2\2\u0098\u009a\n\b\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2"+
		"\2\2\u009e\u00a0\t\t\2\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a2\b\24\2\2\u00a2(\3\2\2\2\u00a3\u00a4\13\2\2"+
		"\2\u00a4*\3\2\2\2\26\2BGJPS^adgiouw\177\u0081\u0085\u008d\u009b\u009f"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}