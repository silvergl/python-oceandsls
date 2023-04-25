// Generated from /home/sgu/IdeaProjects/antlr4-python/tdd-dsl/src/grammars/PhysicalUnits.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PhysicalUnitsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PhysicalUnitsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PhysicalUnitsParser#unitSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitSpec(PhysicalUnitsParser.UnitSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link PhysicalUnitsParser#composedUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposedUnit(PhysicalUnitsParser.ComposedUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siUnitType}
	 * labeled alternative in {@link PhysicalUnitsParser#basicUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiUnitType(PhysicalUnitsParser.SiUnitTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code customUnitType}
	 * labeled alternative in {@link PhysicalUnitsParser#basicUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomUnitType(PhysicalUnitsParser.CustomUnitTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code composedUnitType}
	 * labeled alternative in {@link PhysicalUnitsParser#basicUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposedUnitType(PhysicalUnitsParser.ComposedUnitTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PhysicalUnitsParser#siUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiUnit(PhysicalUnitsParser.SiUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PhysicalUnitsParser#customUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomUnit(PhysicalUnitsParser.CustomUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noP}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoP(PhysicalUnitsParser.NoPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code quetta}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuetta(PhysicalUnitsParser.QuettaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ronna}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRonna(PhysicalUnitsParser.RonnaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code yotta}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYotta(PhysicalUnitsParser.YottaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code zetta}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitZetta(PhysicalUnitsParser.ZettaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exa}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExa(PhysicalUnitsParser.ExaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code peta}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPeta(PhysicalUnitsParser.PetaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tera}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTera(PhysicalUnitsParser.TeraContext ctx);
	/**
	 * Visit a parse tree produced by the {@code giga}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGiga(PhysicalUnitsParser.GigaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mega}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMega(PhysicalUnitsParser.MegaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code kilo}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKilo(PhysicalUnitsParser.KiloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hecto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHecto(PhysicalUnitsParser.HectoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code deca}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeca(PhysicalUnitsParser.DecaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code deci}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeci(PhysicalUnitsParser.DeciContext ctx);
	/**
	 * Visit a parse tree produced by the {@code centi}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCenti(PhysicalUnitsParser.CentiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mili}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMili(PhysicalUnitsParser.MiliContext ctx);
	/**
	 * Visit a parse tree produced by the {@code micro}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMicro(PhysicalUnitsParser.MicroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nano}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNano(PhysicalUnitsParser.NanoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pico}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPico(PhysicalUnitsParser.PicoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code femto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFemto(PhysicalUnitsParser.FemtoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtto(PhysicalUnitsParser.AttoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code zepto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitZepto(PhysicalUnitsParser.ZeptoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code yocto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYocto(PhysicalUnitsParser.YoctoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ronto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRonto(PhysicalUnitsParser.RontoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code quecto}
	 * labeled alternative in {@link PhysicalUnitsParser#unitPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuecto(PhysicalUnitsParser.QuectoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code second}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecond(PhysicalUnitsParser.SecondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code metre}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetre(PhysicalUnitsParser.MetreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code gram}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGram(PhysicalUnitsParser.GramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ampere}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAmpere(PhysicalUnitsParser.AmpereContext ctx);
	/**
	 * Visit a parse tree produced by the {@code kelvin}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKelvin(PhysicalUnitsParser.KelvinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mole}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMole(PhysicalUnitsParser.MoleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code candela}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCandela(PhysicalUnitsParser.CandelaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pascal}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPascal(PhysicalUnitsParser.PascalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code joule}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoule(PhysicalUnitsParser.JouleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ton}
	 * labeled alternative in {@link PhysicalUnitsParser#siType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTon(PhysicalUnitsParser.TonContext ctx);
}