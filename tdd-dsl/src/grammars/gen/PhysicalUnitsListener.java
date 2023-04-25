// Generated from /home/sgu/IdeaProjects/antlr4-python/tdd-dsl/src/grammars/PhysicalUnits.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PhysicalUnitsParser}.
 */
public interface PhysicalUnitsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PhysicalUnitsParser#unitSpec}.
	 * @param ctx the parse tree
	 */
	void enterUnitSpec(PhysicalUnitsParser.UnitSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhysicalUnitsParser#unitSpec}.
	 * @param ctx the parse tree
	 */
	void exitUnitSpec(PhysicalUnitsParser.UnitSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhysicalUnitsParser#composedUnit}.
	 * @param ctx the parse tree
	 */
	void enterComposedUnit(PhysicalUnitsParser.ComposedUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhysicalUnitsParser#composedUnit}.
	 * @param ctx the parse tree
	 */
	void exitComposedUnit(PhysicalUnitsParser.ComposedUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code siUnitType}
	 * labeled alternative in {@link PhysicalUnitsParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void enterSiUnitType(PhysicalUnitsParser.SiUnitTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code siUnitType}
	 * labeled alternative in {@link PhysicalUnitsParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void exitSiUnitType(PhysicalUnitsParser.SiUnitTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code customUnitType}
	 * labeled alternative in {@link PhysicalUnitsParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void enterCustomUnitType(PhysicalUnitsParser.CustomUnitTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code customUnitType}
	 * labeled alternative in {@link PhysicalUnitsParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void exitCustomUnitType(PhysicalUnitsParser.CustomUnitTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code composedUnitType}
	 * labeled alternative in {@link PhysicalUnitsParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void enterComposedUnitType(PhysicalUnitsParser.ComposedUnitTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code composedUnitType}
	 * labeled alternative in {@link PhysicalUnitsParser#basicUnit}.
	 * @param ctx the parse tree
	 */
	void exitComposedUnitType(PhysicalUnitsParser.ComposedUnitTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhysicalUnitsParser#siUnit}.
	 * @param ctx the parse tree
	 */
	void enterSiUnit(PhysicalUnitsParser.SiUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhysicalUnitsParser#siUnit}.
	 * @param ctx the parse tree
	 */
	void exitSiUnit(PhysicalUnitsParser.SiUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhysicalUnitsParser#customUnit}.
	 * @param ctx the parse tree
	 */
	void enterCustomUnit(PhysicalUnitsParser.CustomUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhysicalUnitsParser#customUnit}.
	 * @param ctx the parse tree
	 */
	void exitCustomUnit(PhysicalUnitsParser.CustomUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noP}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterNoP(PhysicalUnitsParser.NoPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noP}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitNoP(PhysicalUnitsParser.NoPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quetta}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterQuetta(PhysicalUnitsParser.QuettaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quetta}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitQuetta(PhysicalUnitsParser.QuettaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ronna}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterRonna(PhysicalUnitsParser.RonnaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ronna}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitRonna(PhysicalUnitsParser.RonnaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code yotta}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterYotta(PhysicalUnitsParser.YottaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code yotta}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitYotta(PhysicalUnitsParser.YottaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code zetta}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterZetta(PhysicalUnitsParser.ZettaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code zetta}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitZetta(PhysicalUnitsParser.ZettaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exa}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterExa(PhysicalUnitsParser.ExaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exa}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitExa(PhysicalUnitsParser.ExaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code peta}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterPeta(PhysicalUnitsParser.PetaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code peta}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitPeta(PhysicalUnitsParser.PetaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tera}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterTera(PhysicalUnitsParser.TeraContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tera}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitTera(PhysicalUnitsParser.TeraContext ctx);
	/**
	 * Enter a parse tree produced by the {@code giga}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterGiga(PhysicalUnitsParser.GigaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code giga}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitGiga(PhysicalUnitsParser.GigaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mega}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterMega(PhysicalUnitsParser.MegaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mega}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitMega(PhysicalUnitsParser.MegaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code kilo}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterKilo(PhysicalUnitsParser.KiloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code kilo}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitKilo(PhysicalUnitsParser.KiloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hecto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterHecto(PhysicalUnitsParser.HectoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hecto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitHecto(PhysicalUnitsParser.HectoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code deca}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterDeca(PhysicalUnitsParser.DecaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code deca}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitDeca(PhysicalUnitsParser.DecaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code deci}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterDeci(PhysicalUnitsParser.DeciContext ctx);
	/**
	 * Exit a parse tree produced by the {@code deci}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitDeci(PhysicalUnitsParser.DeciContext ctx);
	/**
	 * Enter a parse tree produced by the {@code centi}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterCenti(PhysicalUnitsParser.CentiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code centi}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitCenti(PhysicalUnitsParser.CentiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mili}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterMili(PhysicalUnitsParser.MiliContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mili}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitMili(PhysicalUnitsParser.MiliContext ctx);
	/**
	 * Enter a parse tree produced by the {@code micro}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterMicro(PhysicalUnitsParser.MicroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code micro}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitMicro(PhysicalUnitsParser.MicroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nano}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterNano(PhysicalUnitsParser.NanoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nano}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitNano(PhysicalUnitsParser.NanoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pico}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterPico(PhysicalUnitsParser.PicoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pico}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitPico(PhysicalUnitsParser.PicoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code femto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterFemto(PhysicalUnitsParser.FemtoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code femto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitFemto(PhysicalUnitsParser.FemtoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterAtto(PhysicalUnitsParser.AttoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitAtto(PhysicalUnitsParser.AttoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code zepto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterZepto(PhysicalUnitsParser.ZeptoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code zepto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitZepto(PhysicalUnitsParser.ZeptoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code yocto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterYocto(PhysicalUnitsParser.YoctoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code yocto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitYocto(PhysicalUnitsParser.YoctoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ronto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterRonto(PhysicalUnitsParser.RontoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ronto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitRonto(PhysicalUnitsParser.RontoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quecto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void enterQuecto(PhysicalUnitsParser.QuectoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quecto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 */
	void exitQuecto(PhysicalUnitsParser.QuectoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code second}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterSecond(PhysicalUnitsParser.SecondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code second}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitSecond(PhysicalUnitsParser.SecondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code metre}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterMetre(PhysicalUnitsParser.MetreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code metre}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitMetre(PhysicalUnitsParser.MetreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gram}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterGram(PhysicalUnitsParser.GramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gram}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitGram(PhysicalUnitsParser.GramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ampere}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterAmpere(PhysicalUnitsParser.AmpereContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ampere}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitAmpere(PhysicalUnitsParser.AmpereContext ctx);
	/**
	 * Enter a parse tree produced by the {@code kelvin}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterKelvin(PhysicalUnitsParser.KelvinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code kelvin}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitKelvin(PhysicalUnitsParser.KelvinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mole}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterMole(PhysicalUnitsParser.MoleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mole}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitMole(PhysicalUnitsParser.MoleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code candela}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterCandela(PhysicalUnitsParser.CandelaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code candela}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitCandela(PhysicalUnitsParser.CandelaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pascal}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterPascal(PhysicalUnitsParser.PascalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pascal}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitPascal(PhysicalUnitsParser.PascalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code joule}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterJoule(PhysicalUnitsParser.JouleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code joule}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitJoule(PhysicalUnitsParser.JouleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ton}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void enterTon(PhysicalUnitsParser.TonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ton}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 */
	void exitTon(PhysicalUnitsParser.TonContext ctx);
}