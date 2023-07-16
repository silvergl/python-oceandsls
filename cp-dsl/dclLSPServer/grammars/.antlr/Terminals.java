// Generated from /home/armin/Dokumente/antlr4/antlr4-python/cp-dsl/dclLSPServer/grammars/Terminals.g4 by ANTLR 4.9.2
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
		ID=1, INT=2, STRING=3, WS=4, ML_COMMENT=5, SL_COMMENT=6, ANY_OTHER=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ID", "INT", "STRING", "WS", "ML_COMMENT", "SL_COMMENT", "ANY_OTHER"
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
			null, "ID", "INT", "STRING", "WS", "ML_COMMENT", "SL_COMMENT", "ANY_OTHER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\t]\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\5\2\23\n\2\3\2\5\2"+
		"\26\n\2\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\3\6\3\37\n\3\r\3\16\3 \3\4\3"+
		"\4\3\4\3\4\7\4\'\n\4\f\4\16\4*\13\4\3\4\3\4\3\4\3\4\3\4\7\4\61\n\4\f\4"+
		"\16\4\64\13\4\3\4\5\4\67\n\4\3\5\6\5:\n\5\r\5\16\5;\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\7\6D\n\6\f\6\16\6G\13\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7"+
		"R\n\7\f\7\16\7U\13\7\3\7\5\7X\n\7\3\7\3\7\3\b\3\b\3E\2\t\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\3\2\n\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\4\2$$^^\4\2)"+
		")^^\5\2\13\f\17\17\"\"\5\2\f\f\17\17~~\5\2\f\f\17\17AA\2h\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\3\22\3\2\2\2\5\36\3\2\2\2\7\66\3\2\2\2\t9\3\2\2\2\13?\3\2\2\2\rM"+
		"\3\2\2\2\17[\3\2\2\2\21\23\7`\2\2\22\21\3\2\2\2\22\23\3\2\2\2\23\25\3"+
		"\2\2\2\24\26\t\2\2\2\25\24\3\2\2\2\26\32\3\2\2\2\27\31\t\3\2\2\30\27\3"+
		"\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\4\3\2\2\2\34\32\3"+
		"\2\2\2\35\37\t\4\2\2\36\35\3\2\2\2\37 \3\2\2\2 \36\3\2\2\2 !\3\2\2\2!"+
		"\6\3\2\2\2\"(\7$\2\2#$\7^\2\2$\'\13\2\2\2%\'\n\5\2\2&#\3\2\2\2&%\3\2\2"+
		"\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+\67\7$\2\2,\62\7"+
		")\2\2-.\7^\2\2.\61\13\2\2\2/\61\n\6\2\2\60-\3\2\2\2\60/\3\2\2\2\61\64"+
		"\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\65\67"+
		"\7)\2\2\66\"\3\2\2\2\66,\3\2\2\2\67\b\3\2\2\28:\t\7\2\298\3\2\2\2:;\3"+
		"\2\2\2;9\3\2\2\2;<\3\2\2\2<=\3\2\2\2=>\b\5\2\2>\n\3\2\2\2?@\7\61\2\2@"+
		"A\7,\2\2AE\3\2\2\2BD\13\2\2\2CB\3\2\2\2DG\3\2\2\2EF\3\2\2\2EC\3\2\2\2"+
		"FH\3\2\2\2GE\3\2\2\2HI\7,\2\2IJ\7\61\2\2JK\3\2\2\2KL\b\6\2\2L\f\3\2\2"+
		"\2MN\7\61\2\2NO\7\61\2\2OS\3\2\2\2PR\n\b\2\2QP\3\2\2\2RU\3\2\2\2SQ\3\2"+
		"\2\2ST\3\2\2\2TW\3\2\2\2US\3\2\2\2VX\t\t\2\2WV\3\2\2\2WX\3\2\2\2XY\3\2"+
		"\2\2YZ\b\7\2\2Z\16\3\2\2\2[\\\13\2\2\2\\\20\3\2\2\2\21\2\22\25\30\32 "+
		"&(\60\62\66;ESW\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}