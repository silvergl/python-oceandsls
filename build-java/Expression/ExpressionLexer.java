// Generated from Expression.g4 by ANTLR 4.10
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
	static { RuntimeMetaData.checkVersion("4.10", RuntimeMetaData.VERSION); }

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
		"\u0004\u0000\u0014\u00a3\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0003\u000bA\b\u000b\u0001\u000b\u0001\u000b\u0001\f\u0003"+
		"\fF\b\f\u0001\f\u0003\fI\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\fO"+
		"\b\f\u0001\f\u0003\fR\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r]\b\r\u0001\u000e\u0003\u000e`\b\u000e"+
		"\u0001\u000e\u0003\u000ec\b\u000e\u0001\u000e\u0005\u000ef\b\u000e\n\u000e"+
		"\f\u000ei\t\u000e\u0001\u000f\u0004\u000fl\b\u000f\u000b\u000f\f\u000f"+
		"m\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010t\b\u0010"+
		"\n\u0010\f\u0010w\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0005\u0010~\b\u0010\n\u0010\f\u0010\u0081\t\u0010\u0001"+
		"\u0010\u0003\u0010\u0084\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0005\u0011\u008a\b\u0011\n\u0011\f\u0011\u008d\t\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0005\u0012\u0098\b\u0012\n\u0012\f\u0012\u009b"+
		"\t\u0012\u0001\u0012\u0003\u0012\u009e\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u008b\u0000\u0014\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014\u0001\u0000\b\u0002\u0000EEee\u0003\u0000AZ__a"+
		"z\u0004\u000009AZ__az\u0001\u000009\u0002\u0000\"\"\\\\\u0002\u0000\'"+
		"\'\\\\\u0003\u0000\n\n\r\r||\u0003\u0000\n\n\r\r??\u00b3\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0001)\u0001\u0000\u0000\u0000\u0003+\u0001\u0000"+
		"\u0000\u0000\u0005-\u0001\u0000\u0000\u0000\u0007/\u0001\u0000\u0000\u0000"+
		"\t1\u0001\u0000\u0000\u0000\u000b3\u0001\u0000\u0000\u0000\r5\u0001\u0000"+
		"\u0000\u0000\u000f7\u0001\u0000\u0000\u0000\u00119\u0001\u0000\u0000\u0000"+
		"\u0013;\u0001\u0000\u0000\u0000\u0015=\u0001\u0000\u0000\u0000\u0017@"+
		"\u0001\u0000\u0000\u0000\u0019E\u0001\u0000\u0000\u0000\u001b\\\u0001"+
		"\u0000\u0000\u0000\u001d_\u0001\u0000\u0000\u0000\u001fk\u0001\u0000\u0000"+
		"\u0000!\u0083\u0001\u0000\u0000\u0000#\u0085\u0001\u0000\u0000\u0000%"+
		"\u0093\u0001\u0000\u0000\u0000\'\u00a1\u0001\u0000\u0000\u0000)*\u0005"+
		"+\u0000\u0000*\u0002\u0001\u0000\u0000\u0000+,\u0005-\u0000\u0000,\u0004"+
		"\u0001\u0000\u0000\u0000-.\u0005*\u0000\u0000.\u0006\u0001\u0000\u0000"+
		"\u0000/0\u0005/\u0000\u00000\b\u0001\u0000\u0000\u000012\u0005%\u0000"+
		"\u00002\n\u0001\u0000\u0000\u000034\u0005(\u0000\u00004\f\u0001\u0000"+
		"\u0000\u000056\u0005)\u0000\u00006\u000e\u0001\u0000\u0000\u000078\u0005"+
		"[\u0000\u00008\u0010\u0001\u0000\u0000\u00009:\u0005,\u0000\u0000:\u0012"+
		"\u0001\u0000\u0000\u0000;<\u0005]\u0000\u0000<\u0014\u0001\u0000\u0000"+
		"\u0000=>\u0005.\u0000\u0000>\u0016\u0001\u0000\u0000\u0000?A\u0005-\u0000"+
		"\u0000@?\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0001\u0000"+
		"\u0000\u0000BC\u0003\u001f\u000f\u0000C\u0018\u0001\u0000\u0000\u0000"+
		"DF\u0005-\u0000\u0000ED\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000"+
		"FH\u0001\u0000\u0000\u0000GI\u0003\u001f\u000f\u0000HG\u0001\u0000\u0000"+
		"\u0000HI\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0005.\u0000"+
		"\u0000KQ\u0003\u001f\u000f\u0000LN\u0007\u0000\u0000\u0000MO\u0005-\u0000"+
		"\u0000NM\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OP\u0001\u0000"+
		"\u0000\u0000PR\u0003\u001f\u000f\u0000QL\u0001\u0000\u0000\u0000QR\u0001"+
		"\u0000\u0000\u0000R\u001a\u0001\u0000\u0000\u0000ST\u0005t\u0000\u0000"+
		"TU\u0005r\u0000\u0000UV\u0005u\u0000\u0000V]\u0005e\u0000\u0000WX\u0005"+
		"f\u0000\u0000XY\u0005a\u0000\u0000YZ\u0005l\u0000\u0000Z[\u0005s\u0000"+
		"\u0000[]\u0005e\u0000\u0000\\S\u0001\u0000\u0000\u0000\\W\u0001\u0000"+
		"\u0000\u0000]\u001c\u0001\u0000\u0000\u0000^`\u0005^\u0000\u0000_^\u0001"+
		"\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`b\u0001\u0000\u0000\u0000"+
		"ac\u0007\u0001\u0000\u0000ba\u0001\u0000\u0000\u0000cg\u0001\u0000\u0000"+
		"\u0000df\u0007\u0002\u0000\u0000ed\u0001\u0000\u0000\u0000fi\u0001\u0000"+
		"\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000h\u001e"+
		"\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000jl\u0007\u0003\u0000"+
		"\u0000kj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mk\u0001\u0000"+
		"\u0000\u0000mn\u0001\u0000\u0000\u0000n \u0001\u0000\u0000\u0000ou\u0005"+
		"\"\u0000\u0000pq\u0005\\\u0000\u0000qt\t\u0000\u0000\u0000rt\b\u0004\u0000"+
		"\u0000sp\u0001\u0000\u0000\u0000sr\u0001\u0000\u0000\u0000tw\u0001\u0000"+
		"\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vx\u0001"+
		"\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000x\u0084\u0005\"\u0000\u0000"+
		"y\u007f\u0005\'\u0000\u0000z{\u0005\\\u0000\u0000{~\t\u0000\u0000\u0000"+
		"|~\b\u0005\u0000\u0000}z\u0001\u0000\u0000\u0000}|\u0001\u0000\u0000\u0000"+
		"~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0001\u0000\u0000\u0000\u0080\u0082\u0001\u0000\u0000\u0000\u0081\u007f"+
		"\u0001\u0000\u0000\u0000\u0082\u0084\u0005\'\u0000\u0000\u0083o\u0001"+
		"\u0000\u0000\u0000\u0083y\u0001\u0000\u0000\u0000\u0084\"\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0005/\u0000\u0000\u0086\u0087\u0005*\u0000\u0000"+
		"\u0087\u008b\u0001\u0000\u0000\u0000\u0088\u008a\t\u0000\u0000\u0000\u0089"+
		"\u0088\u0001\u0000\u0000\u0000\u008a\u008d\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008c"+
		"\u008e\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e"+
		"\u008f\u0005*\u0000\u0000\u008f\u0090\u0005/\u0000\u0000\u0090\u0091\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0006\u0011\u0000\u0000\u0092$\u0001\u0000"+
		"\u0000\u0000\u0093\u0094\u0005/\u0000\u0000\u0094\u0095\u0005/\u0000\u0000"+
		"\u0095\u0099\u0001\u0000\u0000\u0000\u0096\u0098\b\u0006\u0000\u0000\u0097"+
		"\u0096\u0001\u0000\u0000\u0000\u0098\u009b\u0001\u0000\u0000\u0000\u0099"+
		"\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a"+
		"\u009d\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c"+
		"\u009e\u0007\u0007\u0000\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009d"+
		"\u009e\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f"+
		"\u00a0\u0006\u0012\u0000\u0000\u00a0&\u0001\u0000\u0000\u0000\u00a1\u00a2"+
		"\t\u0000\u0000\u0000\u00a2(\u0001\u0000\u0000\u0000\u0014\u0000@EHNQ\\"+
		"_begmsu}\u007f\u0083\u008b\u0099\u009d\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}