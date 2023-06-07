// Generated from c:\Users\amack\Documents\UNI\python-oceandsls\cp-dsl\confLSPServer\grammars\Configuration.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ConfigurationLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, ID=21, QualifiedName=22, ELONG=23, EDOUBLE=24, 
		EBoolean=25, INT=26, STRING=27, WS=28, ML_COMMENT=29, SL_COMMENT=30, ANY_OTHER=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "ID", "QualifiedName", "ELONG", "EDOUBLE", 
			"EBoolean", "INT", "STRING", "WS", "ML_COMMENT", "SL_COMMENT", "ANY_OTHER"
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


	public ConfigurationLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Configuration.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00fc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\5\26\u008e\n\26\3\26\7\26"+
		"\u0091\n\26\f\26\16\26\u0094\13\26\3\27\3\27\3\27\7\27\u0099\n\27\f\27"+
		"\16\27\u009c\13\27\3\30\5\30\u009f\n\30\3\30\3\30\3\31\5\31\u00a4\n\31"+
		"\3\31\5\31\u00a7\n\31\3\31\3\31\3\31\3\31\5\31\u00ad\n\31\3\31\5\31\u00b0"+
		"\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00bb\n\32\3\33"+
		"\6\33\u00be\n\33\r\33\16\33\u00bf\3\34\3\34\3\34\3\34\7\34\u00c6\n\34"+
		"\f\34\16\34\u00c9\13\34\3\34\3\34\3\34\3\34\3\34\7\34\u00d0\n\34\f\34"+
		"\16\34\u00d3\13\34\3\34\5\34\u00d6\n\34\3\35\6\35\u00d9\n\35\r\35\16\35"+
		"\u00da\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00e3\n\36\f\36\16\36\u00e6"+
		"\13\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u00f1\n\37\f"+
		"\37\16\37\u00f4\13\37\3\37\5\37\u00f7\n\37\3\37\3\37\3 \3 \3\u00e4\2!"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!\3\2\13\5\2C\\aac|\b\2,,//\61;C\\`ac|\4\2GGgg\3\2\62;\4\2$$^^\4\2"+
		"))^^\5\2\13\f\17\17\"\"\5\2\f\f\17\17~~\5\2\f\f\17\17AA\2\u010d\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5O\3\2\2\2\7Q\3\2\2\2\tZ\3\2\2\2\13"+
		"\\\3\2\2\2\rd\3\2\2\2\17f\3\2\2\2\21n\3\2\2\2\23p\3\2\2\2\25r\3\2\2\2"+
		"\27x\3\2\2\2\31z\3\2\2\2\33|\3\2\2\2\35~\3\2\2\2\37\u0080\3\2\2\2!\u0082"+
		"\3\2\2\2#\u0084\3\2\2\2%\u0086\3\2\2\2\'\u0088\3\2\2\2)\u008a\3\2\2\2"+
		"+\u008d\3\2\2\2-\u0095\3\2\2\2/\u009e\3\2\2\2\61\u00a3\3\2\2\2\63\u00ba"+
		"\3\2\2\2\65\u00bd\3\2\2\2\67\u00d5\3\2\2\29\u00d8\3\2\2\2;\u00de\3\2\2"+
		"\2=\u00ec\3\2\2\2?\u00fa\3\2\2\2AB\7e\2\2BC\7q\2\2CD\7p\2\2DE\7h\2\2E"+
		"F\7k\2\2FG\7i\2\2GH\7w\2\2HI\7t\2\2IJ\7c\2\2JK\7v\2\2KL\7k\2\2LM\7q\2"+
		"\2MN\7p\2\2N\4\3\2\2\2OP\7<\2\2P\6\3\2\2\2QR\7c\2\2RS\7e\2\2ST\7v\2\2"+
		"TU\7k\2\2UV\7x\2\2VW\7c\2\2WX\7v\2\2XY\7g\2\2Y\b\3\2\2\2Z[\7.\2\2[\n\3"+
		"\2\2\2\\]\7k\2\2]^\7p\2\2^_\7e\2\2_`\7n\2\2`a\7w\2\2ab\7f\2\2bc\7g\2\2"+
		"c\f\3\2\2\2de\7#\2\2e\16\3\2\2\2fg\7h\2\2gh\7g\2\2hi\7c\2\2ij\7v\2\2j"+
		"k\7w\2\2kl\7t\2\2lm\7g\2\2m\20\3\2\2\2no\7}\2\2o\22\3\2\2\2pq\7\177\2"+
		"\2q\24\3\2\2\2rs\7i\2\2st\7t\2\2tu\7q\2\2uv\7w\2\2vw\7r\2\2w\26\3\2\2"+
		"\2xy\7]\2\2y\30\3\2\2\2z{\7_\2\2{\32\3\2\2\2|}\7-\2\2}\34\3\2\2\2~\177"+
		"\7/\2\2\177\36\3\2\2\2\u0080\u0081\7,\2\2\u0081 \3\2\2\2\u0082\u0083\7"+
		"\61\2\2\u0083\"\3\2\2\2\u0084\u0085\7\'\2\2\u0085$\3\2\2\2\u0086\u0087"+
		"\7*\2\2\u0087&\3\2\2\2\u0088\u0089\7+\2\2\u0089(\3\2\2\2\u008a\u008b\7"+
		"\60\2\2\u008b*\3\2\2\2\u008c\u008e\t\2\2\2\u008d\u008c\3\2\2\2\u008e\u0092"+
		"\3\2\2\2\u008f\u0091\t\3\2\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093,\3\2\2\2\u0094\u0092\3\2\2\2"+
		"\u0095\u009a\5+\26\2\u0096\u0097\7\60\2\2\u0097\u0099\5+\26\2\u0098\u0096"+
		"\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		".\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009f\7/\2\2\u009e\u009d\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\5\65\33\2\u00a1\60\3\2"+
		"\2\2\u00a2\u00a4\7/\2\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a6\3\2\2\2\u00a5\u00a7\5\65\33\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3"+
		"\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\7\60\2\2\u00a9\u00af\5\65\33\2"+
		"\u00aa\u00ac\t\4\2\2\u00ab\u00ad\7/\2\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\5\65\33\2\u00af\u00aa\3\2\2\2"+
		"\u00af\u00b0\3\2\2\2\u00b0\62\3\2\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\7"+
		"t\2\2\u00b3\u00b4\7w\2\2\u00b4\u00bb\7g\2\2\u00b5\u00b6\7h\2\2\u00b6\u00b7"+
		"\7c\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7u\2\2\u00b9\u00bb\7g\2\2\u00ba"+
		"\u00b1\3\2\2\2\u00ba\u00b5\3\2\2\2\u00bb\64\3\2\2\2\u00bc\u00be\t\5\2"+
		"\2\u00bd\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0"+
		"\3\2\2\2\u00c0\66\3\2\2\2\u00c1\u00c7\7$\2\2\u00c2\u00c3\7^\2\2\u00c3"+
		"\u00c6\13\2\2\2\u00c4\u00c6\n\6\2\2\u00c5\u00c2\3\2\2\2\u00c5\u00c4\3"+
		"\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00d6\7$\2\2\u00cb\u00d1\7)\2"+
		"\2\u00cc\u00cd\7^\2\2\u00cd\u00d0\13\2\2\2\u00ce\u00d0\n\7\2\2\u00cf\u00cc"+
		"\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d6\7)"+
		"\2\2\u00d5\u00c1\3\2\2\2\u00d5\u00cb\3\2\2\2\u00d68\3\2\2\2\u00d7\u00d9"+
		"\t\b\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\b\35\2\2\u00dd:\3\2\2\2"+
		"\u00de\u00df\7\61\2\2\u00df\u00e0\7,\2\2\u00e0\u00e4\3\2\2\2\u00e1\u00e3"+
		"\13\2\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e5\3\2\2\2"+
		"\u00e4\u00e2\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e8"+
		"\7,\2\2\u00e8\u00e9\7\61\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\b\36\2\2"+
		"\u00eb<\3\2\2\2\u00ec\u00ed\7\61\2\2\u00ed\u00ee\7\61\2\2\u00ee\u00f2"+
		"\3\2\2\2\u00ef\u00f1\n\t\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2"+
		"\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2"+
		"\2\2\u00f5\u00f7\t\n\2\2\u00f6\u00f5\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		"\u00f8\3\2\2\2\u00f8\u00f9\b\37\2\2\u00f9>\3\2\2\2\u00fa\u00fb\13\2\2"+
		"\2\u00fb@\3\2\2\2\27\2\u008d\u0090\u0092\u009a\u009e\u00a3\u00a6\u00ac"+
		"\u00af\u00ba\u00bf\u00c5\u00c7\u00cf\u00d1\u00d5\u00da\u00e4\u00f2\u00f6"+
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