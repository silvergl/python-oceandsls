// Generated from c:\Users\amack\Documents\UNI\python-oceandsls\cp-dsl\confLSPServer\grammars\Expression.g4 by ANTLR 4.9.2
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
		WS=18, ML_COMMENT=19, SL_COMMENT=20, ANY_OTHER=21;
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
			"WS", "ML_COMMENT", "SL_COMMENT", "ANY_OTHER"
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
			"ELONG", "EDOUBLE", "EBoolean", "ID", "INT", "STRING", "WS", "ML_COMMENT", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u00ae\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\5\rE\n\r\3\r\3\r\3\16\5\16J\n\16\3\16\5\16M\n\16\3\16\3\16\3\16\3\16"+
		"\5\16S\n\16\3\16\5\16V\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\5\17a\n\17\3\20\5\20d\n\20\3\20\5\20g\n\20\3\20\7\20j\n\20\f\20\16"+
		"\20m\13\20\3\21\6\21p\n\21\r\21\16\21q\3\22\3\22\3\22\3\22\7\22x\n\22"+
		"\f\22\16\22{\13\22\3\22\3\22\3\22\3\22\3\22\7\22\u0082\n\22\f\22\16\22"+
		"\u0085\13\22\3\22\5\22\u0088\n\22\3\23\6\23\u008b\n\23\r\23\16\23\u008c"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u0095\n\24\f\24\16\24\u0098\13\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u00a3\n\25\f\25\16"+
		"\25\u00a6\13\25\3\25\5\25\u00a9\n\25\3\25\3\25\3\26\3\26\3\u0096\2\27"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27\3\2\13\4\2GGgg\5\2C\\aac|\6\2\62;C\\a"+
		"ac|\3\2\62;\4\2$$^^\4\2))^^\5\2\13\f\17\17\"\"\5\2\f\f\17\17~~\5\2\f\f"+
		"\17\17AA\2\u00bf\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3"+
		"\2\2\2\5/\3\2\2\2\7\61\3\2\2\2\t\63\3\2\2\2\13\65\3\2\2\2\r\67\3\2\2\2"+
		"\179\3\2\2\2\21;\3\2\2\2\23=\3\2\2\2\25?\3\2\2\2\27A\3\2\2\2\31D\3\2\2"+
		"\2\33I\3\2\2\2\35`\3\2\2\2\37c\3\2\2\2!o\3\2\2\2#\u0087\3\2\2\2%\u008a"+
		"\3\2\2\2\'\u0090\3\2\2\2)\u009e\3\2\2\2+\u00ac\3\2\2\2-.\7-\2\2.\4\3\2"+
		"\2\2/\60\7/\2\2\60\6\3\2\2\2\61\62\7,\2\2\62\b\3\2\2\2\63\64\7\61\2\2"+
		"\64\n\3\2\2\2\65\66\7\'\2\2\66\f\3\2\2\2\678\7*\2\28\16\3\2\2\29:\7+\2"+
		"\2:\20\3\2\2\2;<\7]\2\2<\22\3\2\2\2=>\7.\2\2>\24\3\2\2\2?@\7_\2\2@\26"+
		"\3\2\2\2AB\7\60\2\2B\30\3\2\2\2CE\7/\2\2DC\3\2\2\2DE\3\2\2\2EF\3\2\2\2"+
		"FG\5!\21\2G\32\3\2\2\2HJ\7/\2\2IH\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KM\5!\21"+
		"\2LK\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\7\60\2\2OU\5!\21\2PR\t\2\2\2QS\7/\2"+
		"\2RQ\3\2\2\2RS\3\2\2\2ST\3\2\2\2TV\5!\21\2UP\3\2\2\2UV\3\2\2\2V\34\3\2"+
		"\2\2WX\7v\2\2XY\7t\2\2YZ\7w\2\2Za\7g\2\2[\\\7h\2\2\\]\7c\2\2]^\7n\2\2"+
		"^_\7u\2\2_a\7g\2\2`W\3\2\2\2`[\3\2\2\2a\36\3\2\2\2bd\7`\2\2cb\3\2\2\2"+
		"cd\3\2\2\2df\3\2\2\2eg\t\3\2\2fe\3\2\2\2gk\3\2\2\2hj\t\4\2\2ih\3\2\2\2"+
		"jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l \3\2\2\2mk\3\2\2\2np\t\5\2\2on\3\2\2\2"+
		"pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\"\3\2\2\2sy\7$\2\2tu\7^\2\2ux\13\2\2\2"+
		"vx\n\6\2\2wt\3\2\2\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2"+
		"{y\3\2\2\2|\u0088\7$\2\2}\u0083\7)\2\2~\177\7^\2\2\177\u0082\13\2\2\2"+
		"\u0080\u0082\n\7\2\2\u0081~\3\2\2\2\u0081\u0080\3\2\2\2\u0082\u0085\3"+
		"\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086\u0088\7)\2\2\u0087s\3\2\2\2\u0087}\3\2\2\2\u0088"+
		"$\3\2\2\2\u0089\u008b\t\b\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2"+
		"\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f"+
		"\b\23\2\2\u008f&\3\2\2\2\u0090\u0091\7\61\2\2\u0091\u0092\7,\2\2\u0092"+
		"\u0096\3\2\2\2\u0093\u0095\13\2\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3"+
		"\2\2\2\u0096\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0099\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0099\u009a\7,\2\2\u009a\u009b\7\61\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u009d\b\24\2\2\u009d(\3\2\2\2\u009e\u009f\7\61\2\2\u009f\u00a0"+
		"\7\61\2\2\u00a0\u00a4\3\2\2\2\u00a1\u00a3\n\t\2\2\u00a2\u00a1\3\2\2\2"+
		"\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a8"+
		"\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a9\t\n\2\2\u00a8\u00a7\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\b\25\2\2\u00ab*\3\2\2\2"+
		"\u00ac\u00ad\13\2\2\2\u00ad,\3\2\2\2\27\2DILRU`cfikqwy\u0081\u0083\u0087"+
		"\u008c\u0096\u00a4\u00a8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}