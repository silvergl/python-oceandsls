// Generated from e:\amack\Documents\UNI\Hiwi\antlr4-python\grammars\CP-DSL\Terminals.g4 by ANTLR 4.9.2
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
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\bT\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\5\2\21\n\2\3\2\5\2\24\n\2\3"+
		"\2\7\2\27\n\2\f\2\16\2\32\13\2\3\3\6\3\35\n\3\r\3\16\3\36\3\4\3\4\3\4"+
		"\3\4\7\4%\n\4\f\4\16\4(\13\4\3\4\3\4\3\4\3\4\3\4\7\4/\n\4\f\4\16\4\62"+
		"\13\4\3\4\5\4\65\n\4\3\5\3\5\3\5\3\5\7\5;\n\5\f\5\16\5>\13\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6I\n\6\f\6\16\6L\13\6\3\6\5\6O\n\6\3\6\3"+
		"\6\3\7\3\7\3<\2\b\3\3\5\4\7\5\t\6\13\7\r\b\3\2\t\5\2C\\aac|\6\2\62;C\\"+
		"aac|\3\2\62;\4\2$$^^\4\2))^^\5\2\f\f\17\17~~\5\2\f\f\17\17AA\2^\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3"+
		"\20\3\2\2\2\5\34\3\2\2\2\7\64\3\2\2\2\t\66\3\2\2\2\13D\3\2\2\2\rR\3\2"+
		"\2\2\17\21\7`\2\2\20\17\3\2\2\2\20\21\3\2\2\2\21\23\3\2\2\2\22\24\t\2"+
		"\2\2\23\22\3\2\2\2\24\30\3\2\2\2\25\27\t\3\2\2\26\25\3\2\2\2\27\32\3\2"+
		"\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\4\3\2\2\2\32\30\3\2\2\2\33\35\t\4"+
		"\2\2\34\33\3\2\2\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\6\3\2"+
		"\2\2 &\7$\2\2!\"\7^\2\2\"%\13\2\2\2#%\n\5\2\2$!\3\2\2\2$#\3\2\2\2%(\3"+
		"\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2)\65\7$\2\2*\60\7)\2\2"+
		"+,\7^\2\2,/\13\2\2\2-/\n\6\2\2.+\3\2\2\2.-\3\2\2\2/\62\3\2\2\2\60.\3\2"+
		"\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62\60\3\2\2\2\63\65\7)\2\2\64 \3\2\2"+
		"\2\64*\3\2\2\2\65\b\3\2\2\2\66\67\7\61\2\2\678\7,\2\28<\3\2\2\29;\13\2"+
		"\2\2:9\3\2\2\2;>\3\2\2\2<=\3\2\2\2<:\3\2\2\2=?\3\2\2\2><\3\2\2\2?@\7,"+
		"\2\2@A\7\61\2\2AB\3\2\2\2BC\b\5\2\2C\n\3\2\2\2DE\7\61\2\2EF\7\61\2\2F"+
		"J\3\2\2\2GI\n\7\2\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KN\3\2\2\2"+
		"LJ\3\2\2\2MO\t\b\2\2NM\3\2\2\2NO\3\2\2\2OP\3\2\2\2PQ\b\6\2\2Q\f\3\2\2"+
		"\2RS\13\2\2\2S\16\3\2\2\2\20\2\20\23\26\30\36$&.\60\64<JN\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}