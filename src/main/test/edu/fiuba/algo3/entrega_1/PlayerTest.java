package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.card.Card;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.enums.SectionType;
import edu.fiuba.algo3.modelo.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        unitCard = new UnitCard("Arquero", "Unidad a distancia", 5, SectionType.RANGED);
        card1 = new UnitCard("Catapulta", "Unidad de asedio", 4, SectionType.SIEGE);
        card2 = new UnitCard("Espadachín", "Unidad cuerpo a cuerpo", 6, SectionType.MELEE);
        card3 = new UnitCard("Ballesta", "Unidad a distancia", 3, SectionType.RANGED);


        List<Card> cards1 = new ArrayList<>();
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


        player1.getHand().add(unitCard);
        player1.getHand().add(card1);
        player1.getHand().add(card2);
        player1.getHand().add(card3);
    }

    @Test
    public void testPlayerGetsPointsAfterPlayingCard() {
        Integer initialPoints = player1.getPoints();
        game.playCard(player1, unitCard);
        Assertions.assertEquals(initialPoints.intValue() + unitCard.getPoints().intValue(), player1.getPoints().intValue());
    }

    @Test
    public void testPlayerCanDiscardCards() {

        int initialDiscardPileSize = player1.getDiscardPile().size();

        player1.discardCard(card1);
        player1.discardCard(card2);

        assertEquals(initialDiscardPileSize + 2, player1.getDiscardPile().size());

    }


    @Test
    public void VerificarQueUnJugadorPoseaCartasSuficientesParaEmpezarElJuegoEnSuMazo() {
        List<Card> cards1 = new ArrayList<>();


        Deck deck = new Deck(cards1);

        UnitCard guerrero = new UnitCard("guerrero", "guerrero", 10, SectionType.MELEE );
        deck.addCard(guerrero);
        UnitCard paladin = new UnitCard("paladin", "paladin", 5, SectionType.MELEE);
        deck.addCard(paladin);
        UnitCard arquero = new UnitCard("arquero", "arquero", 6, SectionType.RANGED);
        deck.addCard(arquero);
        UnitCard francotirador = new UnitCard("francotirador", "francotirador", 7, SectionType.RANGED);
        deck.addCard(francotirador);
        UnitCard geralt = new UnitCard("geralt", "geralt", 5, SectionType.MELEE);
        deck.addCard(geralt);
        UnitCard ciri = new UnitCard("ciri", "ciri", 6, SectionType.MELEE);
        deck.addCard(ciri);
        UnitCard dijkstra = new UnitCard("dijkstra", "dijkstra", 7, SectionType.MELEE);
        deck.addCard(dijkstra);

        Player player1 = new Player("matias", deck);


        assertThrows(IllegalArgumentException.class, () -> player1.distributeCards(deck, 10),
                "the number of cards needed is 10 to start the game");

    }

    @Test
    public void VerificarQueAUnJugadorSeLeReparten10CartasDeSuMazo(){

        List<Card> cards1 = new ArrayList<>();
        Deck deck = new Deck(cards1);

        UnitCard guerrero = new UnitCard("guerrero", "guerrero", 10, SectionType.MELEE);
        deck.addCard(guerrero);
        UnitCard paladin = new UnitCard("paladin", "paladin", 5, SectionType.MELEE);
        deck.addCard(paladin);
        UnitCard arquero = new UnitCard("arquero", "arquero", 6, SectionType.RANGED);
        deck.addCard(arquero);
        UnitCard francotirador = new UnitCard("francotirador", "francotirador", 7, SectionType.RANGED);
        deck.addCard(francotirador);
        UnitCard catapulta = new UnitCard("catapulta", "catapulta", 8, SectionType.SIEGE);
        deck.addCard(catapulta);
        UnitCard mortero = new UnitCard("mortero", "siege", 9, SectionType.SIEGE);
        deck.addCard(mortero);
        UnitCard gladiador = new UnitCard("gladiador", "melee", 12, SectionType.MELEE);
        deck.addCard(gladiador);
        UnitCard centurion = new UnitCard("centurion", "melee", 12, SectionType.MELEE);
        deck.addCard(centurion);
        UnitCard canion = new UnitCard("canion", "siege", 14, SectionType.SIEGE);
        deck.addCard(canion);
        UnitCard ariete = new UnitCard("ariete", "melee", 15, SectionType.MELEE);
        deck.addCard(ariete);
        UnitCard geralt = new UnitCard("geralt", "geralt", 5, SectionType.MELEE);
        deck.addCard(geralt);
        UnitCard ciri = new UnitCard("ciri", "ciri", 6, SectionType.MELEE);
        deck.addCard(ciri);
        UnitCard dijkstra = new UnitCard("dijkstra", "dijkstra", 7, SectionType.MELEE);
        deck.addCard(dijkstra);

        Player player1 = new Player("matias", deck);

        player1.distributeCards(deck, 10);

        Assertions.assertEquals(10, player1.numberOfCards());
    }
}
