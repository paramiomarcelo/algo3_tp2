package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.Melee;
import edu.fiuba.algo3.modelo.card.Ranged;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.effect.ScorchedEarth;
import edu.fiuba.algo3.modelo.player.Player;

import edu.fiuba.algo3.modelo.visitors.CounterRow;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class ScorchedEarthTest {
    UnitCard unitCard1 = new Melee("Espadachín", "description", 3, "melee");
    UnitCard unitCard2 = new Melee("Lanzero", "description", 10, "melee");
    UnitCard unitCard3 = new Ranged("Ballestero", "description", 7, "ranged");
    UnitCard unitCard4 = new Ranged("Arquero", "description", 5, "ranged");

    SpecialCard scorchedEarthCard = new SpecialCard(
            "Tierra arrasada",
            "Destruye la carta más fuerte de cada jugador",
            new ScorchedEarth()
    );

    Deck deck1 = new Deck(Arrays.asList(unitCard1, unitCard3, scorchedEarthCard));
    Deck deck2 = new Deck(Arrays.asList(unitCard2, unitCard4));

    Player player1 = new Player("Jugador 1", deck1);
    Player player2 = new Player("Jugador 2", deck2);

    Game game = new Game();
    Board board = Board.getInstance();

    @Test
    public void scorchedEarthBurnsStrongestCardFromEachPlayer() {
        game.setPlayers(player1, player2);

        player1.playCard(unitCard1);
        player1.playCard(unitCard3);

        player2.playCard(unitCard2);
        player2.playCard(unitCard4);

        CounterRow counterRow = new CounterRow();

        assertEquals(3, counterRow.visit(board.getSide(player1).getRowMelee()));
        assertEquals(7, counterRow.visit(board.getSide(player1).getRanged()));

        assertEquals(10, counterRow.visit(board.getSide(player2).getRowMelee()));
        assertEquals(5, counterRow.visit(board.getSide(player2).getRanged()));

        player1.playCard(scorchedEarthCard);

        assertEquals(3, counterRow.visit(board.getSide(player1).getRowMelee()));
        assertEquals(0, counterRow.visit(board.getSide(player1).getRanged()));

        assertEquals(0, counterRow.visit(board.getSide(player2).getRowMelee()));
        assertEquals(5, counterRow.visit(board.getSide(player2).getRanged()));
    }
}
