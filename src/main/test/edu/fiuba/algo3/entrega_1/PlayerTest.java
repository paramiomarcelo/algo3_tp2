package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.clases.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void VerificarQueUnJugadorPoseaCartasSuficientesParaEmpezarElJuegoEnSuMazo() {

        Player jugador = new Player("matias");

        Deck mazo = new Deck();

        Unit guerrero = new Unit("guerrero", 10, "melee", "guerrero");
        mazo.addCard(guerrero);
        Unit paladin = new Unit("paladin", 5, "melee", "paladin");
        mazo.addCard(paladin);
        Unit arquero = new Unit("arquero", 6, "range", "arquero");
        mazo.addCard(arquero);
        Unit francotirador = new Unit("francotirador", 7, "range", "francotirador");
        mazo.addCard(francotirador);
        Specials clima = new Weather("nieve", "congela");
        mazo.addCard(clima);
        Specials moral = new MoraleBoost("boost", "mejora");
        mazo.addCard(moral);
        Specials earth = new ScorcheadEarth("earth", "mejora");
        mazo.addCard(earth);

        assertThrows(IllegalArgumentException.class, () -> jugador.distributeCards(mazo.getCards()),
                "the number of cards needed is 10 to start the game");

    }

    @Test
    public void VerificarQueAUnJugadorSeLeReparten10CartasDeSuMazo(){
        Player jugador = new Player("matias");

        Deck mazo = new Deck();

        Unit guerrero = new Unit("guerrero", 10, "melee", "guerrero");
        mazo.addCard(guerrero);
        Unit paladin = new Unit("paladin", 5, "melee", "paladin");
        mazo.addCard(paladin);
        Unit arquero = new Unit("arquero", 6, "range", "arquero");
        mazo.addCard(arquero);
        Unit francotirador = new Unit("francotirador", 7, "range", "francotirador");
        mazo.addCard(francotirador);
        Unit catapulta = new Unit("catapulta", 8, "siege", "catapulta");
        mazo.addCard(catapulta);
        Unit mortero = new Unit("mortero", 9, "siege", "mortero");
        mazo.addCard(mortero);
        Unit gladiador = new Unit("gladiador", 12, "melee", "gladiador");
        mazo.addCard(gladiador);
        Unit centurion = new Unit("centurion", 13, "melee", "centurion");
        mazo.addCard(centurion);
        Unit canion = new Unit("canion", 14, "siege", "canion");
        mazo.addCard(canion);
        Unit ariete = new Unit("ariete", 15, "melee", "ariete");
        mazo.addCard(ariete);
        Specials clima = new Weather("nieve", "congela");
        mazo.addCard(clima);
        Specials moral = new MoraleBoost("boost", "mejora");
        mazo.addCard(moral);
        Specials earth = new ScorcheadEarth("earth", "mejora");
        mazo.addCard(earth);

        jugador.distributeCards(mazo.getCards());

        assertEquals(10, jugador.numberOfCards());
    }
}
