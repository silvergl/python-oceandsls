// Generated from e:\amack\Documents\UNI\Hiwi\antlr4-python\bgc-dsl\src\grammar\CommonLexerRules.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CommonLexerRulesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, NUM=2, WS=3, COMMENT=4;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ID", "NUM", "INT", "EXP", "DIG", "WS", "COMMENT"
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
			null, "ID", "NUM", "WS", "COMMENT"
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


	public CommonLexerRulesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CommonLexerRules.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\6X\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\23\n\2\r\2\16\2"+
		"\24\3\3\5\3\30\n\3\3\3\3\3\6\3\34\n\3\r\3\16\3\35\3\3\6\3!\n\3\r\3\16"+
		"\3\"\3\3\3\3\7\3\'\n\3\f\3\16\3*\13\3\5\3,\n\3\3\3\5\3/\n\3\5\3\61\n\3"+
		"\3\4\3\4\3\4\7\4\66\n\4\f\4\16\49\13\4\5\4;\n\4\3\5\3\5\5\5?\n\5\3\5\3"+
		"\5\3\6\3\6\3\7\6\7F\n\7\r\7\16\7G\3\7\3\7\3\b\3\b\3\b\3\b\7\bP\n\b\f\b"+
		"\16\bS\13\b\3\b\3\b\3\b\3\b\3Q\2\t\3\3\5\4\7\2\t\2\13\2\r\5\17\6\3\2\b"+
		"\6\2\62;C\\aac|\3\2\63;\4\2GGgg\4\2--//\3\2\62;\4\2\13\f\"\"\2a\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\22\3\2\2\2\5\27\3\2\2\2"+
		"\7:\3\2\2\2\t<\3\2\2\2\13B\3\2\2\2\rE\3\2\2\2\17K\3\2\2\2\21\23\t\2\2"+
		"\2\22\21\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\4\3\2\2"+
		"\2\26\30\7/\2\2\27\26\3\2\2\2\27\30\3\2\2\2\30\60\3\2\2\2\31\33\7\60\2"+
		"\2\32\34\5\13\6\2\33\32\3\2\2\2\34\35\3\2\2\2\35\33\3\2\2\2\35\36\3\2"+
		"\2\2\36\61\3\2\2\2\37!\5\13\6\2 \37\3\2\2\2!\"\3\2\2\2\" \3\2\2\2\"#\3"+
		"\2\2\2#+\3\2\2\2$(\7\60\2\2%\'\5\13\6\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2"+
		"()\3\2\2\2),\3\2\2\2*(\3\2\2\2+$\3\2\2\2+,\3\2\2\2,.\3\2\2\2-/\5\t\5\2"+
		".-\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60\31\3\2\2\2\60 \3\2\2\2\61\6\3\2\2"+
		"\2\62;\7\62\2\2\63\67\t\3\2\2\64\66\5\13\6\2\65\64\3\2\2\2\669\3\2\2\2"+
		"\67\65\3\2\2\2\678\3\2\2\28;\3\2\2\29\67\3\2\2\2:\62\3\2\2\2:\63\3\2\2"+
		"\2;\b\3\2\2\2<>\t\4\2\2=?\t\5\2\2>=\3\2\2\2>?\3\2\2\2?@\3\2\2\2@A\5\7"+
		"\4\2A\n\3\2\2\2BC\t\6\2\2C\f\3\2\2\2DF\t\7\2\2ED\3\2\2\2FG\3\2\2\2GE\3"+
		"\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\b\7\2\2J\16\3\2\2\2KL\7\61\2\2LM\7\61\2\2"+
		"MQ\3\2\2\2NP\13\2\2\2ON\3\2\2\2PS\3\2\2\2QR\3\2\2\2QO\3\2\2\2RT\3\2\2"+
		"\2SQ\3\2\2\2TU\7\f\2\2UV\3\2\2\2VW\b\b\3\2W\20\3\2\2\2\20\2\24\27\35\""+
		"(+.\60\67:>GQ\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}