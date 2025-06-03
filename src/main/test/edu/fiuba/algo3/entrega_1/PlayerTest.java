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

public class PlayerTest {
    private Game game;
    private Player player1;
    private Player player2;
    private Deck deck1;
    private Deck deck2;
    private UnitCard unitCard;
    // Agregamos más cartas para el test de descarte
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
}
