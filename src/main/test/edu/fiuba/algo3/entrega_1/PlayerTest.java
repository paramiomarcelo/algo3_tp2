package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.clases.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void VerificarQueUnJugadorPoseaCartasSuficientesParaEmpezarElJuegoEnSuMazo() {

        Player player = new Player("matias");

        Deck deck = new Deck();

        Unit warrior = new Unit("warrior", 10, "melee", "warrior");
        deck.addCard(warrior);
        Unit paladin = new Unit("paladin", 5, "melee", "paladin");
        deck.addCard(paladin);
        Unit archer = new Unit("archer", 6, "range", "archer");
        deck.addCard(archer);
        Unit sniper = new Unit("sniper", 7, "range", "sniper");
        deck.addCard(sniper);
        Specials weather = new Weather("snow", "frozen");
        deck.addCard(weather);
        Specials morale = new MoraleBoost("boost", "improvement");
        deck.addCard(morale);
        Specials earth = new ScorcheadEarth("earth", "improvement");
        deck.addCard(earth);

        assertThrows(IllegalArgumentException.class, () -> player.distributeCards(deck),
                "the number of cards needed is 10 to start the game");

    }

    @Test
    public void VerificarQueAUnJugadorSeLeReparten10CartasDeSuMazo(){
        Player player = new Player("matias");

        Deck deck = new Deck();

        Unit warrior = new Unit("warrior", 10, "melee", "warrior");
        deck.addCard(warrior);
        Unit paladin = new Unit("paladin", 5, "melee", "paladin");
        deck.addCard(paladin);
        Unit archer = new Unit("archer", 6, "range", "archer");
        deck.addCard(archer);
        Unit sniper = new Unit("sniper", 7, "range", "sniper");
        deck.addCard(sniper);
        Unit catapulta = new Unit("catapulta", 8, "siege", "catapulta");
        deck.addCard(catapulta);
        Unit mortar = new Unit("mortar", 9, "siege", "mortar");
        deck.addCard(mortar);
        Unit gladiator = new Unit("gladiator", 12, "melee", "gladiator");
        deck.addCard(gladiator);
        Unit centurion = new Unit("centurion", 13, "melee", "centurion");
        deck.addCard(centurion);
        Unit cannon = new Unit("cannon", 14, "siege", "cannon");
        deck.addCard(cannon);
        Unit battleRam = new Unit("battleRam", 15, "melee", "battleRam");
        deck.addCard(battleRam);
        Specials weather = new Weather("snow", "frozen");
        deck.addCard(weather);
        Specials morale = new MoraleBoost("boost", "improvement");
        deck.addCard(morale);
        Specials earth = new ScorcheadEarth("earth", "improvement");
        deck.addCard(earth);

        player.distributeCards(deck);


        assertEquals(10, player.numberOfCards());
    }
}
