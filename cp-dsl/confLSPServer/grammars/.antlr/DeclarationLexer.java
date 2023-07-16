// Generated from /home/armin/Dokumente/antlr4/antlr4-python/cp-dsl/confLSPServer/grammars/Declaration.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DeclarationLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, ELONG=61, EDOUBLE=62, EBoolean=63, ID=64, INT=65, STRING=66, 
		WS=67, ML_COMMENT=68, SL_COMMENT=69, ANY_OTHER=70;
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
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
			"T__49", "T__50", "T__51", "T__52", "T__53", "T__54", "T__55", "T__56", 
			"T__57", "T__58", "T__59", "ELONG", "EDOUBLE", "EBoolean", "ID", "INT", 
			"STRING", "WS", "ML_COMMENT", "SL_COMMENT", "ANY_OTHER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'model'", "'types'", "'group'", "':'", "'{'", "'}'", "'def'", 
			"','", "'='", "'required'", "'feature'", "'requires'", "'excludes'", 
			"'sub'", "'alternative'", "'multiple'", "'('", "')'", "'['", "']'", "'range'", 
			"'enum'", "'*'", "'/'", "'**'", "'noP'", "'yotta'", "'zetta'", "'exa'", 
			"'peta'", "'tera'", "'giga'", "'mega'", "'kilo'", "'hecto'", "'deca'", 
			"'deci'", "'centi'", "'mili'", "'micro'", "'nano'", "'pico'", "'femto'", 
			"'atto'", "'zepto'", "'yocto'", "'meter'", "'gram'", "'ton'", "'second'", 
			"'ampere'", "'kelvin'", "'mole'", "'candela'", "'pascal'", "'Joul'", 
			"'+'", "'-'", "'%'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ELONG", "EDOUBLE", "EBoolean", "ID", "INT", "STRING", "WS", "ML_COMMENT", 
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


	public DeclarationLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Declaration.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2H\u0224\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3"+
		"\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\""+
		"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3"+
		"&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3"+
		"*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3"+
		".\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61"+
		"\3\61\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66"+
		"\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\3"+
		"8\38\38\39\39\39\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\5>\u01bb\n>\3>\3>\3"+
		"?\5?\u01c0\n?\3?\5?\u01c3\n?\3?\3?\3?\3?\5?\u01c9\n?\3?\5?\u01cc\n?\3"+
		"@\3@\3@\3@\3@\3@\3@\3@\3@\5@\u01d7\n@\3A\5A\u01da\nA\3A\5A\u01dd\nA\3"+
		"A\7A\u01e0\nA\fA\16A\u01e3\13A\3B\6B\u01e6\nB\rB\16B\u01e7\3C\3C\3C\3"+
		"C\7C\u01ee\nC\fC\16C\u01f1\13C\3C\3C\3C\3C\3C\7C\u01f8\nC\fC\16C\u01fb"+
		"\13C\3C\5C\u01fe\nC\3D\6D\u0201\nD\rD\16D\u0202\3D\3D\3E\3E\3E\3E\7E\u020b"+
		"\nE\fE\16E\u020e\13E\3E\3E\3E\3E\3E\3F\3F\3F\3F\7F\u0219\nF\fF\16F\u021c"+
		"\13F\3F\5F\u021f\nF\3F\3F\3G\3G\3\u020c\2H\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081"+
		"B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH\3\2\13\4\2GGgg\5\2C\\aac|"+
		"\6\2\62;C\\aac|\3\2\62;\4\2$$^^\4\2))^^\5\2\13\f\17\17\"\"\5\2\f\f\17"+
		"\17~~\5\2\f\f\17\17AA\2\u0235\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2"+
		"i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3"+
		"\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081"+
		"\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2"+
		"\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\3\u008f\3\2\2\2\5\u0095\3\2\2\2\7\u009b"+
		"\3\2\2\2\t\u00a1\3\2\2\2\13\u00a3\3\2\2\2\r\u00a5\3\2\2\2\17\u00a7\3\2"+
		"\2\2\21\u00ab\3\2\2\2\23\u00ad\3\2\2\2\25\u00af\3\2\2\2\27\u00b8\3\2\2"+
		"\2\31\u00c0\3\2\2\2\33\u00c9\3\2\2\2\35\u00d2\3\2\2\2\37\u00d6\3\2\2\2"+
		"!\u00e2\3\2\2\2#\u00eb\3\2\2\2%\u00ed\3\2\2\2\'\u00ef\3\2\2\2)\u00f1\3"+
		"\2\2\2+\u00f3\3\2\2\2-\u00f9\3\2\2\2/\u00fe\3\2\2\2\61\u0100\3\2\2\2\63"+
		"\u0102\3\2\2\2\65\u0105\3\2\2\2\67\u0109\3\2\2\29\u010f\3\2\2\2;\u0115"+
		"\3\2\2\2=\u0119\3\2\2\2?\u011e\3\2\2\2A\u0123\3\2\2\2C\u0128\3\2\2\2E"+
		"\u012d\3\2\2\2G\u0132\3\2\2\2I\u0138\3\2\2\2K\u013d\3\2\2\2M\u0142\3\2"+
		"\2\2O\u0148\3\2\2\2Q\u014d\3\2\2\2S\u0153\3\2\2\2U\u0158\3\2\2\2W\u015d"+
		"\3\2\2\2Y\u0163\3\2\2\2[\u0168\3\2\2\2]\u016e\3\2\2\2_\u0174\3\2\2\2a"+
		"\u017a\3\2\2\2c\u017f\3\2\2\2e\u0183\3\2\2\2g\u018a\3\2\2\2i\u0191\3\2"+
		"\2\2k\u0198\3\2\2\2m\u019d\3\2\2\2o\u01a5\3\2\2\2q\u01ac\3\2\2\2s\u01b1"+
		"\3\2\2\2u\u01b3\3\2\2\2w\u01b5\3\2\2\2y\u01b7\3\2\2\2{\u01ba\3\2\2\2}"+
		"\u01bf\3\2\2\2\177\u01d6\3\2\2\2\u0081\u01d9\3\2\2\2\u0083\u01e5\3\2\2"+
		"\2\u0085\u01fd\3\2\2\2\u0087\u0200\3\2\2\2\u0089\u0206\3\2\2\2\u008b\u0214"+
		"\3\2\2\2\u008d\u0222\3\2\2\2\u008f\u0090\7o\2\2\u0090\u0091\7q\2\2\u0091"+
		"\u0092\7f\2\2\u0092\u0093\7g\2\2\u0093\u0094\7n\2\2\u0094\4\3\2\2\2\u0095"+
		"\u0096\7v\2\2\u0096\u0097\7{\2\2\u0097\u0098\7r\2\2\u0098\u0099\7g\2\2"+
		"\u0099\u009a\7u\2\2\u009a\6\3\2\2\2\u009b\u009c\7i\2\2\u009c\u009d\7t"+
		"\2\2\u009d\u009e\7q\2\2\u009e\u009f\7w\2\2\u009f\u00a0\7r\2\2\u00a0\b"+
		"\3\2\2\2\u00a1\u00a2\7<\2\2\u00a2\n\3\2\2\2\u00a3\u00a4\7}\2\2\u00a4\f"+
		"\3\2\2\2\u00a5\u00a6\7\177\2\2\u00a6\16\3\2\2\2\u00a7\u00a8\7f\2\2\u00a8"+
		"\u00a9\7g\2\2\u00a9\u00aa\7h\2\2\u00aa\20\3\2\2\2\u00ab\u00ac\7.\2\2\u00ac"+
		"\22\3\2\2\2\u00ad\u00ae\7?\2\2\u00ae\24\3\2\2\2\u00af\u00b0\7t\2\2\u00b0"+
		"\u00b1\7g\2\2\u00b1\u00b2\7s\2\2\u00b2\u00b3\7w\2\2\u00b3\u00b4\7k\2\2"+
		"\u00b4\u00b5\7t\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7f\2\2\u00b7\26\3\2"+
		"\2\2\u00b8\u00b9\7h\2\2\u00b9\u00ba\7g\2\2\u00ba\u00bb\7c\2\2\u00bb\u00bc"+
		"\7v\2\2\u00bc\u00bd\7w\2\2\u00bd\u00be\7t\2\2\u00be\u00bf\7g\2\2\u00bf"+
		"\30\3\2\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7g\2\2\u00c2\u00c3\7s\2\2\u00c3"+
		"\u00c4\7w\2\2\u00c4\u00c5\7k\2\2\u00c5\u00c6\7t\2\2\u00c6\u00c7\7g\2\2"+
		"\u00c7\u00c8\7u\2\2\u00c8\32\3\2\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7"+
		"z\2\2\u00cb\u00cc\7e\2\2\u00cc\u00cd\7n\2\2\u00cd\u00ce\7w\2\2\u00ce\u00cf"+
		"\7f\2\2\u00cf\u00d0\7g\2\2\u00d0\u00d1\7u\2\2\u00d1\34\3\2\2\2\u00d2\u00d3"+
		"\7u\2\2\u00d3\u00d4\7w\2\2\u00d4\u00d5\7d\2\2\u00d5\36\3\2\2\2\u00d6\u00d7"+
		"\7c\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9\7v\2\2\u00d9\u00da\7g\2\2\u00da"+
		"\u00db\7t\2\2\u00db\u00dc\7p\2\2\u00dc\u00dd\7c\2\2\u00dd\u00de\7v\2\2"+
		"\u00de\u00df\7k\2\2\u00df\u00e0\7x\2\2\u00e0\u00e1\7g\2\2\u00e1 \3\2\2"+
		"\2\u00e2\u00e3\7o\2\2\u00e3\u00e4\7w\2\2\u00e4\u00e5\7n\2\2\u00e5\u00e6"+
		"\7v\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7r\2\2\u00e8\u00e9\7n\2\2\u00e9"+
		"\u00ea\7g\2\2\u00ea\"\3\2\2\2\u00eb\u00ec\7*\2\2\u00ec$\3\2\2\2\u00ed"+
		"\u00ee\7+\2\2\u00ee&\3\2\2\2\u00ef\u00f0\7]\2\2\u00f0(\3\2\2\2\u00f1\u00f2"+
		"\7_\2\2\u00f2*\3\2\2\2\u00f3\u00f4\7t\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6"+
		"\7p\2\2\u00f6\u00f7\7i\2\2\u00f7\u00f8\7g\2\2\u00f8,\3\2\2\2\u00f9\u00fa"+
		"\7g\2\2\u00fa\u00fb\7p\2\2\u00fb\u00fc\7w\2\2\u00fc\u00fd\7o\2\2\u00fd"+
		".\3\2\2\2\u00fe\u00ff\7,\2\2\u00ff\60\3\2\2\2\u0100\u0101\7\61\2\2\u0101"+
		"\62\3\2\2\2\u0102\u0103\7,\2\2\u0103\u0104\7,\2\2\u0104\64\3\2\2\2\u0105"+
		"\u0106\7p\2\2\u0106\u0107\7q\2\2\u0107\u0108\7R\2\2\u0108\66\3\2\2\2\u0109"+
		"\u010a\7{\2\2\u010a\u010b\7q\2\2\u010b\u010c\7v\2\2\u010c\u010d\7v\2\2"+
		"\u010d\u010e\7c\2\2\u010e8\3\2\2\2\u010f\u0110\7|\2\2\u0110\u0111\7g\2"+
		"\2\u0111\u0112\7v\2\2\u0112\u0113\7v\2\2\u0113\u0114\7c\2\2\u0114:\3\2"+
		"\2\2\u0115\u0116\7g\2\2\u0116\u0117\7z\2\2\u0117\u0118\7c\2\2\u0118<\3"+
		"\2\2\2\u0119\u011a\7r\2\2\u011a\u011b\7g\2\2\u011b\u011c\7v\2\2\u011c"+
		"\u011d\7c\2\2\u011d>\3\2\2\2\u011e\u011f\7v\2\2\u011f\u0120\7g\2\2\u0120"+
		"\u0121\7t\2\2\u0121\u0122\7c\2\2\u0122@\3\2\2\2\u0123\u0124\7i\2\2\u0124"+
		"\u0125\7k\2\2\u0125\u0126\7i\2\2\u0126\u0127\7c\2\2\u0127B\3\2\2\2\u0128"+
		"\u0129\7o\2\2\u0129\u012a\7g\2\2\u012a\u012b\7i\2\2\u012b\u012c\7c\2\2"+
		"\u012cD\3\2\2\2\u012d\u012e\7m\2\2\u012e\u012f\7k\2\2\u012f\u0130\7n\2"+
		"\2\u0130\u0131\7q\2\2\u0131F\3\2\2\2\u0132\u0133\7j\2\2\u0133\u0134\7"+
		"g\2\2\u0134\u0135\7e\2\2\u0135\u0136\7v\2\2\u0136\u0137\7q\2\2\u0137H"+
		"\3\2\2\2\u0138\u0139\7f\2\2\u0139\u013a\7g\2\2\u013a\u013b\7e\2\2\u013b"+
		"\u013c\7c\2\2\u013cJ\3\2\2\2\u013d\u013e\7f\2\2\u013e\u013f\7g\2\2\u013f"+
		"\u0140\7e\2\2\u0140\u0141\7k\2\2\u0141L\3\2\2\2\u0142\u0143\7e\2\2\u0143"+
		"\u0144\7g\2\2\u0144\u0145\7p\2\2\u0145\u0146\7v\2\2\u0146\u0147\7k\2\2"+
		"\u0147N\3\2\2\2\u0148\u0149\7o\2\2\u0149\u014a\7k\2\2\u014a\u014b\7n\2"+
		"\2\u014b\u014c\7k\2\2\u014cP\3\2\2\2\u014d\u014e\7o\2\2\u014e\u014f\7"+
		"k\2\2\u014f\u0150\7e\2\2\u0150\u0151\7t\2\2\u0151\u0152\7q\2\2\u0152R"+
		"\3\2\2\2\u0153\u0154\7p\2\2\u0154\u0155\7c\2\2\u0155\u0156\7p\2\2\u0156"+
		"\u0157\7q\2\2\u0157T\3\2\2\2\u0158\u0159\7r\2\2\u0159\u015a\7k\2\2\u015a"+
		"\u015b\7e\2\2\u015b\u015c\7q\2\2\u015cV\3\2\2\2\u015d\u015e\7h\2\2\u015e"+
		"\u015f\7g\2\2\u015f\u0160\7o\2\2\u0160\u0161\7v\2\2\u0161\u0162\7q\2\2"+
		"\u0162X\3\2\2\2\u0163\u0164\7c\2\2\u0164\u0165\7v\2\2\u0165\u0166\7v\2"+
		"\2\u0166\u0167\7q\2\2\u0167Z\3\2\2\2\u0168\u0169\7|\2\2\u0169\u016a\7"+
		"g\2\2\u016a\u016b\7r\2\2\u016b\u016c\7v\2\2\u016c\u016d\7q\2\2\u016d\\"+
		"\3\2\2\2\u016e\u016f\7{\2\2\u016f\u0170\7q\2\2\u0170\u0171\7e\2\2\u0171"+
		"\u0172\7v\2\2\u0172\u0173\7q\2\2\u0173^\3\2\2\2\u0174\u0175\7o\2\2\u0175"+
		"\u0176\7g\2\2\u0176\u0177\7v\2\2\u0177\u0178\7g\2\2\u0178\u0179\7t\2\2"+
		"\u0179`\3\2\2\2\u017a\u017b\7i\2\2\u017b\u017c\7t\2\2\u017c\u017d\7c\2"+
		"\2\u017d\u017e\7o\2\2\u017eb\3\2\2\2\u017f\u0180\7v\2\2\u0180\u0181\7"+
		"q\2\2\u0181\u0182\7p\2\2\u0182d\3\2\2\2\u0183\u0184\7u\2\2\u0184\u0185"+
		"\7g\2\2\u0185\u0186\7e\2\2\u0186\u0187\7q\2\2\u0187\u0188\7p\2\2\u0188"+
		"\u0189\7f\2\2\u0189f\3\2\2\2\u018a\u018b\7c\2\2\u018b\u018c\7o\2\2\u018c"+
		"\u018d\7r\2\2\u018d\u018e\7g\2\2\u018e\u018f\7t\2\2\u018f\u0190\7g\2\2"+
		"\u0190h\3\2\2\2\u0191\u0192\7m\2\2\u0192\u0193\7g\2\2\u0193\u0194\7n\2"+
		"\2\u0194\u0195\7x\2\2\u0195\u0196\7k\2\2\u0196\u0197\7p\2\2\u0197j\3\2"+
		"\2\2\u0198\u0199\7o\2\2\u0199\u019a\7q\2\2\u019a\u019b\7n\2\2\u019b\u019c"+
		"\7g\2\2\u019cl\3\2\2\2\u019d\u019e\7e\2\2\u019e\u019f\7c\2\2\u019f\u01a0"+
		"\7p\2\2\u01a0\u01a1\7f\2\2\u01a1\u01a2\7g\2\2\u01a2\u01a3\7n\2\2\u01a3"+
		"\u01a4\7c\2\2\u01a4n\3\2\2\2\u01a5\u01a6\7r\2\2\u01a6\u01a7\7c\2\2\u01a7"+
		"\u01a8\7u\2\2\u01a8\u01a9\7e\2\2\u01a9\u01aa\7c\2\2\u01aa\u01ab\7n\2\2"+
		"\u01abp\3\2\2\2\u01ac\u01ad\7L\2\2\u01ad\u01ae\7q\2\2\u01ae\u01af\7w\2"+
		"\2\u01af\u01b0\7n\2\2\u01b0r\3\2\2\2\u01b1\u01b2\7-\2\2\u01b2t\3\2\2\2"+
		"\u01b3\u01b4\7/\2\2\u01b4v\3\2\2\2\u01b5\u01b6\7\'\2\2\u01b6x\3\2\2\2"+
		"\u01b7\u01b8\7\60\2\2\u01b8z\3\2\2\2\u01b9\u01bb\7/\2\2\u01ba\u01b9\3"+
		"\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01bd\5\u0083B\2"+
		"\u01bd|\3\2\2\2\u01be\u01c0\7/\2\2\u01bf\u01be\3\2\2\2\u01bf\u01c0\3\2"+
		"\2\2\u01c0\u01c2\3\2\2\2\u01c1\u01c3\5\u0083B\2\u01c2\u01c1\3\2\2\2\u01c2"+
		"\u01c3\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\7\60\2\2\u01c5\u01cb\5"+
		"\u0083B\2\u01c6\u01c8\t\2\2\2\u01c7\u01c9\7/\2\2\u01c8\u01c7\3\2\2\2\u01c8"+
		"\u01c9\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cc\5\u0083B\2\u01cb\u01c6"+
		"\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc~\3\2\2\2\u01cd\u01ce\7v\2\2\u01ce\u01cf"+
		"\7t\2\2\u01cf\u01d0\7w\2\2\u01d0\u01d7\7g\2\2\u01d1\u01d2\7h\2\2\u01d2"+
		"\u01d3\7c\2\2\u01d3\u01d4\7n\2\2\u01d4\u01d5\7u\2\2\u01d5\u01d7\7g\2\2"+
		"\u01d6\u01cd\3\2\2\2\u01d6\u01d1\3\2\2\2\u01d7\u0080\3\2\2\2\u01d8\u01da"+
		"\7`\2\2\u01d9\u01d8\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01dc\3\2\2\2\u01db"+
		"\u01dd\t\3\2\2\u01dc\u01db\3\2\2\2\u01dd\u01e1\3\2\2\2\u01de\u01e0\t\4"+
		"\2\2\u01df\u01de\3\2\2\2\u01e0\u01e3\3\2\2\2\u01e1\u01df\3\2\2\2\u01e1"+
		"\u01e2\3\2\2\2\u01e2\u0082\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e4\u01e6\t\5"+
		"\2\2\u01e5\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e7"+
		"\u01e8\3\2\2\2\u01e8\u0084\3\2\2\2\u01e9\u01ef\7$\2\2\u01ea\u01eb\7^\2"+
		"\2\u01eb\u01ee\13\2\2\2\u01ec\u01ee\n\6\2\2\u01ed\u01ea\3\2\2\2\u01ed"+
		"\u01ec\3\2\2\2\u01ee\u01f1\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef\u01f0\3\2"+
		"\2\2\u01f0\u01f2\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f2\u01fe\7$\2\2\u01f3"+
		"\u01f9\7)\2\2\u01f4\u01f5\7^\2\2\u01f5\u01f8\13\2\2\2\u01f6\u01f8\n\7"+
		"\2\2\u01f7\u01f4\3\2\2\2\u01f7\u01f6\3\2\2\2\u01f8\u01fb\3\2\2\2\u01f9"+
		"\u01f7\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fc\3\2\2\2\u01fb\u01f9\3\2"+
		"\2\2\u01fc\u01fe\7)\2\2\u01fd\u01e9\3\2\2\2\u01fd\u01f3\3\2\2\2\u01fe"+
		"\u0086\3\2\2\2\u01ff\u0201\t\b\2\2\u0200\u01ff\3\2\2\2\u0201\u0202\3\2"+
		"\2\2\u0202\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0204\3\2\2\2\u0204"+
		"\u0205\bD\2\2\u0205\u0088\3\2\2\2\u0206\u0207\7\61\2\2\u0207\u0208\7,"+
		"\2\2\u0208\u020c\3\2\2\2\u0209\u020b\13\2\2\2\u020a\u0209\3\2\2\2\u020b"+
		"\u020e\3\2\2\2\u020c\u020d\3\2\2\2\u020c\u020a\3\2\2\2\u020d\u020f\3\2"+
		"\2\2\u020e\u020c\3\2\2\2\u020f\u0210\7,\2\2\u0210\u0211\7\61\2\2\u0211"+
		"\u0212\3\2\2\2\u0212\u0213\bE\2\2\u0213\u008a\3\2\2\2\u0214\u0215\7\61"+
		"\2\2\u0215\u0216\7\61\2\2\u0216\u021a\3\2\2\2\u0217\u0219\n\t\2\2\u0218"+
		"\u0217\3\2\2\2\u0219\u021c\3\2\2\2\u021a\u0218\3\2\2\2\u021a\u021b\3\2"+
		"\2\2\u021b\u021e\3\2\2\2\u021c\u021a\3\2\2\2\u021d\u021f\t\n\2\2\u021e"+
		"\u021d\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0220\3\2\2\2\u0220\u0221\bF"+
		"\2\2\u0221\u008c\3\2\2\2\u0222\u0223\13\2\2\2\u0223\u008e\3\2\2\2\27\2"+
		"\u01ba\u01bf\u01c2\u01c8\u01cb\u01d6\u01d9\u01dc\u01df\u01e1\u01e7\u01ed"+
		"\u01ef\u01f7\u01f9\u01fd\u0202\u020c\u021a\u021e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}