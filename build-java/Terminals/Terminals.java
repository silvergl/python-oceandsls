// Generated from Terminals.g4 by ANTLR 4.10
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Terminals extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, INT=2, STRING=3, ML_COMMENT=4, SL_COMMENT=5, ANY_OTHER=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ID", "INT", "STRING", "ML_COMMENT", "SL_COMMENT", "ANY_OTHER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "INT", "STRING", "ML_COMMENT", "SL_COMMENT", "ANY_OTHER"
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


	public Terminals(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Terminals.g4"; }

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
		"\u0004\u0000\u0006R\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0001\u0000\u0003\u0000\u000f\b\u0000"+
		"\u0001\u0000\u0003\u0000\u0012\b\u0000\u0001\u0000\u0005\u0000\u0015\b"+
		"\u0000\n\u0000\f\u0000\u0018\t\u0000\u0001\u0001\u0004\u0001\u001b\b\u0001"+
		"\u000b\u0001\f\u0001\u001c\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002#\b\u0002\n\u0002\f\u0002&\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002-\b\u0002\n\u0002\f\u0002"+
		"0\t\u0002\u0001\u0002\u0003\u00023\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u00039\b\u0003\n\u0003\f\u0003<\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004G\b\u0004\n\u0004\f\u0004J\t"+
		"\u0004\u0001\u0004\u0003\u0004M\b\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001:\u0000\u0006\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\u0001\u0000\u0007\u0003\u0000AZ__az\u0004"+
		"\u000009AZ__az\u0001\u000009\u0002\u0000\"\"\\\\\u0002\u0000\'\'\\\\\u0003"+
		"\u0000\n\n\r\r||\u0003\u0000\n\n\r\r??\\\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0001\u000e\u0001\u0000\u0000\u0000"+
		"\u0003\u001a\u0001\u0000\u0000\u0000\u00052\u0001\u0000\u0000\u0000\u0007"+
		"4\u0001\u0000\u0000\u0000\tB\u0001\u0000\u0000\u0000\u000bP\u0001\u0000"+
		"\u0000\u0000\r\u000f\u0005^\u0000\u0000\u000e\r\u0001\u0000\u0000\u0000"+
		"\u000e\u000f\u0001\u0000\u0000\u0000\u000f\u0011\u0001\u0000\u0000\u0000"+
		"\u0010\u0012\u0007\u0000\u0000\u0000\u0011\u0010\u0001\u0000\u0000\u0000"+
		"\u0012\u0016\u0001\u0000\u0000\u0000\u0013\u0015\u0007\u0001\u0000\u0000"+
		"\u0014\u0013\u0001\u0000\u0000\u0000\u0015\u0018\u0001\u0000\u0000\u0000"+
		"\u0016\u0014\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000"+
		"\u0017\u0002\u0001\u0000\u0000\u0000\u0018\u0016\u0001\u0000\u0000\u0000"+
		"\u0019\u001b\u0007\u0002\u0000\u0000\u001a\u0019\u0001\u0000\u0000\u0000"+
		"\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000"+
		"\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u0004\u0001\u0000\u0000\u0000"+
		"\u001e$\u0005\"\u0000\u0000\u001f \u0005\\\u0000\u0000 #\t\u0000\u0000"+
		"\u0000!#\b\u0003\u0000\u0000\"\u001f\u0001\u0000\u0000\u0000\"!\u0001"+
		"\u0000\u0000\u0000#&\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000"+
		"$%\u0001\u0000\u0000\u0000%\'\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000"+
		"\u0000\'3\u0005\"\u0000\u0000(.\u0005\'\u0000\u0000)*\u0005\\\u0000\u0000"+
		"*-\t\u0000\u0000\u0000+-\b\u0004\u0000\u0000,)\u0001\u0000\u0000\u0000"+
		",+\u0001\u0000\u0000\u0000-0\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000"+
		"\u0000./\u0001\u0000\u0000\u0000/1\u0001\u0000\u0000\u00000.\u0001\u0000"+
		"\u0000\u000013\u0005\'\u0000\u00002\u001e\u0001\u0000\u0000\u00002(\u0001"+
		"\u0000\u0000\u00003\u0006\u0001\u0000\u0000\u000045\u0005/\u0000\u0000"+
		"56\u0005*\u0000\u00006:\u0001\u0000\u0000\u000079\t\u0000\u0000\u0000"+
		"87\u0001\u0000\u0000\u00009<\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000"+
		"\u0000:8\u0001\u0000\u0000\u0000;=\u0001\u0000\u0000\u0000<:\u0001\u0000"+
		"\u0000\u0000=>\u0005*\u0000\u0000>?\u0005/\u0000\u0000?@\u0001\u0000\u0000"+
		"\u0000@A\u0006\u0003\u0000\u0000A\b\u0001\u0000\u0000\u0000BC\u0005/\u0000"+
		"\u0000CD\u0005/\u0000\u0000DH\u0001\u0000\u0000\u0000EG\b\u0005\u0000"+
		"\u0000FE\u0001\u0000\u0000\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000"+
		"\u0000\u0000HI\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001"+
		"\u0000\u0000\u0000KM\u0007\u0006\u0000\u0000LK\u0001\u0000\u0000\u0000"+
		"LM\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NO\u0006\u0004\u0000"+
		"\u0000O\n\u0001\u0000\u0000\u0000PQ\t\u0000\u0000\u0000Q\f\u0001\u0000"+
		"\u0000\u0000\u000e\u0000\u000e\u0011\u0014\u0016\u001c\"$,.2:HL\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}