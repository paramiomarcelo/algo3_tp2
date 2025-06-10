package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.effect.MoraleBoost;
import edu.fiuba.algo3.modelo.player.Player;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class MoraleBoostTest {
    UnitCard unitCard1 = new UnitCard("Espadachín", "description", 7, "melee");
    UnitCard unitCard2 = new UnitCard("Lanzero", "description", 4, "melee");

    Deck deck1 = new Deck(Arrays.asList(unitCard1));
    Deck deck2 = new Deck(Arrays.asList(unitCard2));

    Player player1 = new Player("Jugador 1", deck1);
    Player player2 = new Player("Jugador 2", deck2);

    Game game = new Game();
    Board board = Board.getInstance();

    @Test
    public void moraleBoostDoublesPointsOnlyForPlayingPlayer() {
        game.setPlayers(player1, player2);

        player1.playCard(unitCard1);
        player2.playCard(unitCard2);

        assertEquals(7, board.getRow(player1, "melee").calculatePoints());
        assertEquals(4, board.getRow(player2, "melee").calculatePoints());

        SpecialCard moraleCard = new SpecialCard(
                "Inspiración",
                "Duplica puntos de la fila",
                new MoraleBoost("melee", player1)
        );

        player1.playCard(moraleCard);

        assertEquals(14, board.getRow(player1, "melee").calculatePoints());
        assertEquals(4, board.getRow(player2, "melee").calculatePoints());
    }
}
