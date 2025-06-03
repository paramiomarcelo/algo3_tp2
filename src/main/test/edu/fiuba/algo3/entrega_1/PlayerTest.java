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

    @BeforeEach
    public void setUp() {

        UnitCard unitCard = new UnitCard("Arquero", "Unidad a distancia", 5, SectionType.RANGED);
        List<Card> cards1 = new ArrayList<>();
        cards1.add(unitCard);
        deck1 = new Deck(cards1);


        deck2 = new Deck(new ArrayList<>());


        player1 = new Player("Jugador1", deck1);
        player2 = new Player("Jugador2", deck2);


        game = new Game();
        game.setPlayers(player1, player2);


        player1.getHand().add(unitCard);
    }

    @Test
    public void testPlayerGetsPointsAfterPlayingCard() {

        Integer initialPoints = player1.getPoints();

        game.playCard(player1, unitCard);


        Assertions.assertEquals(initialPoints.intValue() + unitCard.getPoints().intValue(), player1.getPoints().intValue());
    }
}
