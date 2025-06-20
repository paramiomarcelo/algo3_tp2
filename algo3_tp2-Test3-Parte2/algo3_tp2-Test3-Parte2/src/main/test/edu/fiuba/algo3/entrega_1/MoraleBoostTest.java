package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.Point;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.effect.MoraleBoost;
import edu.fiuba.algo3.modelo.player.Player;

import edu.fiuba.algo3.modelo.section.Melee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class MoraleBoostTest {

    UnitCard unitCard1 = new UnitCard("Espadachín", "description", new Point(7), new Melee());
    UnitCard unitCard2 = new UnitCard("Lanzero", "description", new Point(4), new Melee());

    List<AbstractCard> card1 = new ArrayList<>();
    List<AbstractCard> card2 = new ArrayList<>();

    Deck deck1 = new Deck(card1);
    Deck deck2 = new Deck(card2);

    Player player1 = new Player("Jugador 1", deck1);
    Player player2 = new Player("Jugador 2", deck2);

    Game game = new Game();
    Board board = Board.getInstance();

    @BeforeEach
    public void setUp() {
        card1.add(unitCard1);
        card2.add(unitCard2);
    }

    @Test
    public void moraleBoostDoublesPointsOnlyForPlayingPlayer() {
        game.setPlayers(player1, player2);

        player1.playCard(unitCard1);
        player2.playCard(unitCard2);

        assertEquals(7, player1.getPoints());
        assertEquals(4, player2.getPoints());

        SpecialCard moraleCard = new SpecialCard(
                "Inspiración",
                "Duplica puntos de la fila",
                new MoraleBoost(new Melee())
        );

        player1.playCard(moraleCard);

        assertEquals(14, player1.getPoints());
        assertEquals(4,  player2.getPoints());
    }
}
