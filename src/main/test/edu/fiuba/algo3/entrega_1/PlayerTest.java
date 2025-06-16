package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.card.*;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.effect.GlobalEffect;
import edu.fiuba.algo3.modelo.effect.TargetedEffect;
import edu.fiuba.algo3.modelo.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ranges.Range;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Game game;
    private Player player1;
    private Player player2;
    private Deck deck1;
    private Deck deck2;
    private UnitCard unitCard;

    private UnitCard card1;
    private UnitCard card2;
    private UnitCard card3;

    @BeforeEach
    public void setUp() {
        unitCard = new Ranged("Arquero", "Unidad a distancia", 5, "ranged");
        card1 = new Siege("Catapulta", "Unidad de asedio", 4, "siege");
        card2 = new Melee("Espadachín", "Unidad cuerpo a cuerpo", 6, "melee");
        card3 = new Ranged("Ballesta", "Unidad a distancia", 3, "ranged");


        List<AbstractCard> cards1 = new ArrayList<>();
        cards1.add(unitCard);
        cards1.add(card1);
        cards1.add(card2);
        cards1.add(card3);
        deck1 = new Deck(cards1);

        deck2 = new Deck(new ArrayList<>());

        player1 = new Player("Jugador1", deck1);
        player2 = new Player("Jugador2", deck2);

        game = new Game();
        game.setPlayers(player1, player2);


        player1.addCard(unitCard);
        player1.addCard(card1);
        player1.addCard(card2);
        player1.addCard(card3);
    }

    @Test
    public void testPlayerGetsPointsAfterPlayingCard() {
        int initialPoints = player1.getPoints();
        player1.playCard(unitCard);
        Assertions.assertEquals(player1.getPoints(), unitCard.getPoints());
    }

    @Test
    public void testPlayerCanDiscardCards() {

        player1.discardCard(card1);
        player1.discardCard(card2);

        assertEquals(2, player1.getDiscardPile().size());

    }


    @Test
    public void VerificarQueUnJugadorPoseaCartasSuficientesParaEmpezarElJuegoEnSuMazo() {
        List<AbstractCard> cards1 = new ArrayList<>();


        Deck deck = new Deck(cards1);

        UnitCard guerrero = new Melee("guerrero", "guerrero", 10, "melee");
        deck.addCard(guerrero);
        UnitCard paladin = new Melee("paladin", "paladin", 5, "melee");
        deck.addCard(paladin);
        UnitCard arquero = new Ranged("arquero", "arquero", 6, "ranged");
        deck.addCard(arquero);
        UnitCard francotirador = new Ranged("francotirador", "francotirador", 7, "ranged");
        deck.addCard(francotirador);
        UnitCard catapulta = new Siege("catapulta", "catapulta", 8, "siege");
        deck.addCard(catapulta);
        UnitCard mortero = new Siege("mortero", "siege", 9, "siege");
        deck.addCard(mortero);
        UnitCard gladiador = new Melee("gladiador", "melee", 12, "melee");
        deck.addCard(gladiador);
        UnitCard centurion = new Melee("centurion", "melee", 12, "melee");
        deck.addCard(centurion);


        Player player1 = new Player("matias", deck);


        assertThrows(IllegalArgumentException.class, () -> player1.distributeCards(10),
                "the number of cards needed is 10 to start the game");

    }

    @Test
    public void VerificarQueAUnJugadorSeLeReparten10CartasDeSuMazo(){

        List<AbstractCard> cards1 = new ArrayList<>();
        Deck deck = new Deck(cards1);

        UnitCard guerrero = new Melee("guerrero", "guerrero", 10, "melee");
        deck.addCard(guerrero);
        UnitCard paladin = new Melee("paladin", "paladin", 5, "melee");
        deck.addCard(paladin);
        UnitCard arquero = new Ranged("arquero", "arquero", 6, "ranged");
        deck.addCard(arquero);
        UnitCard francotirador = new Ranged("francotirador", "francotirador", 7, "ranged");
        deck.addCard(francotirador);
        UnitCard catapulta = new Siege("catapulta", "catapulta", 8, "siege");
        deck.addCard(catapulta);
        UnitCard mortero = new Siege("mortero", "siege", 9, "siege");
        deck.addCard(mortero);
        UnitCard gladiador = new Melee("gladiador", "melee", 12, "melee");
        deck.addCard(gladiador);
        UnitCard centurion = new Melee("centurion", "melee", 12, "melee");
        deck.addCard(centurion);
        UnitCard canion = new Melee("canion", "siege", 14, "melee");
        deck.addCard(canion);
        UnitCard ariete = new Melee("ariete", "melee", 15, "melee");
        deck.addCard(ariete);
        UnitCard geralt = new Melee("geralt", "geralt", 5, "melee");
        deck.addCard(geralt);
        UnitCard ciri = new Melee("ciri", "ciri", 6, "melee");
        deck.addCard(ciri);
        UnitCard dijkstra = new Melee("dijkstra", "dijkstra", 7, "melee");
        deck.addCard(dijkstra);

        Player player1 = new Player("matias", deck);

        player1.distributeCards(10);

        assertTrue(player1.hasNumberOfCards(10));
    }


//    @Test
//    public void playCardInIncorrectSection (){
//    UnitCard unitCard1 = new Melee("Espadachín", "description", 7, "melee");
//    UnitCard unitCard2 = new Melee("Lanzero", "description", 4, "melee");
//    UnitCard unitCard3 = new Ranged("Arquero", "description", 4, "ranged");
//    UnitCard unitCard4 = new Ranged("Ballestero", "description", 4, "ranged");
//    UnitCard unitCard5 = new Siege("Catapulta", "description", 4, "siege");
//    UnitCard unitCard6 = new Siege("Trebuchet", "description", 4, "siege");
//
//    Player player1 = new Player("Jugador 1", deck1);
//    Player player2 = new Player("Jugador 2", deck2);
//
//    SpecialCard snowCard = new SpecialCard("Nieve", "descrition", new TargetedEffect("siege", player2));
//    SpecialCard fogCard = new SpecialCard("Niebla", "descrition",new TargetedEffect());
//    SpecialCard torrentialRainCard = new SpecialCard("Lluvia torrencial", "descrition",new TargetedEffect());
//    SpecialCard stormCard = new SpecialCard("Tormenta", "descrition", new TargetedEffect());
//    SpecialCard clearWeatherEffectsCard = new SpecialCard("Despejar Clima", "descrition",new TargetedEffect());
//
//    Deck deck1 = new Deck(Arrays.asList(unitCard1, unitCard3, unitCard5, snowCard, fogCard, torrentialRainCard, stormCard, clearWeatherEffectsCard));
//    Deck deck2 = new Deck(Arrays.asList(unitCard2, unitCard4, unitCard6, snowCard, clearWeatherEffectsCard));
//
//
//
//    Game game = new Game();
//
//    game.setPlayers(player1,player2);
//
//
//        assertThrows(IllegalArgumentException.class, () -> player1.playCard(unitCard2,"ranged"),
//                "Cannot play this card in ranged section");
//
//
//    }
}
