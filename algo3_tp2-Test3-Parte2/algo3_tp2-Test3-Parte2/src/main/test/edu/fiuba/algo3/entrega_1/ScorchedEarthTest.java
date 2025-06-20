package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.Point;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.effect.ScorchedEarth;
import edu.fiuba.algo3.modelo.player.Player;

import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Ranged;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class ScorchedEarthTest {
    UnitCard unitCard1 = new UnitCard("Espadachín", "description", new Point(3), new Melee());
    UnitCard unitCard2 = new UnitCard("Lanzero", "description", new Point(10), new Melee());
    UnitCard unitCard3 = new UnitCard("Ballestero", "description", new Point(7), new Ranged());
    UnitCard unitCard4 = new UnitCard("Arquero", "description", new Point(5), new Ranged());

    SpecialCard scorchedEarthCard = new SpecialCard(
            "Tierra arrasada",
            "Destruye la carta más fuerte de cada jugador",
            new ScorchedEarth(new Melee())
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

        player1.playCard(unitCard1); //3
        player1.playCard(unitCard3); //10

        player2.playCard(unitCard2); //10
        player2.playCard(unitCard4); //15

        assertEquals(10, player1.getPoints());
        assertEquals(15, player2.getPoints());

        player1.playCard(scorchedEarthCard);

        assertEquals(3, player1.getPoints());
        assertEquals(5, player2.getPoints());
    }
}