package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.effect.SnowEffect;
import edu.fiuba.algo3.modelo.enums.SectionType;
import edu.fiuba.algo3.modelo.player.Player;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class SnowEffectTest {

    @Test
    public void snowEffectSetsAllUnitPointsToOneInMeleeRows() {
        UnitCard unitCard1 = new UnitCard("Espadachín", "description", 7, SectionType.MELEE);
        UnitCard unitCard2 = new UnitCard("Lancero", "description", 4, SectionType.MELEE);

        SpecialCard snowCard = new SpecialCard("Nieve", "descrition", new SnowEffect(SectionType.MELEE));

        Deck deck1 = new Deck(Arrays.asList(unitCard1, snowCard));
        Deck deck2 = new Deck(Arrays.asList(unitCard2));

        Player player1 = new Player("Jugador 1", deck1);
        Player player2 = new Player("Jugador 2", deck2);

        Game game = new Game();
        game.setPlayers(player1, player2);

        game.playCard(player1, unitCard1);

        game.playCard(player2, unitCard2);

        game.playCard(player1, snowCard);

        Board board = game.getBoard();
        assertEquals(1, board.getRow(player1, SectionType.MELEE).calculatePoints());
        assertEquals(1, board.getRow(player2, SectionType.MELEE).calculatePoints());
    }
}
