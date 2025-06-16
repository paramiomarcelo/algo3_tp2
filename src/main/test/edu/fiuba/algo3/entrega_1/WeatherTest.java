package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.*;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.effect.weatherEffects.*;
import edu.fiuba.algo3.modelo.player.Player;

import edu.fiuba.algo3.modelo.visitors.CounterRow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherTest {

    UnitCard unitCard1 = new Melee("Espadachín", "description", 7, "melee");
    UnitCard unitCard2 = new Melee("Lanzero", "description", 4, "melee");
    UnitCard unitCard3 = new Ranged("Arquero", "description", 4, "ranged");
    UnitCard unitCard4 = new Ranged("Ballestero", "description", 4, "ranged");
    UnitCard unitCard5 = new Siege("Catapulta", "description", 4, "siege");
    UnitCard unitCard6 = new Siege("Trebuchet", "description", 4, "siege");

    SpecialCard snowCard = new SpecialCard("Nieve", "descrition", new SnowEffect());
    SpecialCard fogCard = new SpecialCard("Niebla", "descrition", new FogEffect());
    SpecialCard torrentialRainCard = new SpecialCard("Lluvia torrencial", "descrition", new TorrentialRainEffect());
    SpecialCard stormCard = new SpecialCard("Tormenta", "descrition", new StormEffect());
    SpecialCard clearWeatherEffectsCard = new SpecialCard("Despejar Clima", "descrition", new ClearWeatherEffect());

    Deck deck1 = new Deck(Arrays.asList(unitCard1, unitCard3, unitCard5, snowCard, fogCard, torrentialRainCard, stormCard, clearWeatherEffectsCard));
    Deck deck2 = new Deck(Arrays.asList(unitCard2, unitCard4, unitCard6, snowCard, clearWeatherEffectsCard));

    Player player1 = new Player("Jugador 1", deck1);
    Player player2 = new Player("Jugador 2", deck2);

    Game game = new Game();
    Board board = Board.getInstance();
    CounterRow counterRow = new CounterRow();

    @BeforeEach
    public void setBoard() {
        game.setPlayers(player1, player2);
    }

    @Test
    public void snowEffectSetsAllUnitPointsToOneInMeleeRows() {
        player1.playCard(unitCard1);
        player2.playCard(unitCard2);
        player1.playCard(snowCard);

        assertEquals(1, counterRow.visit(board.getSide(player2).getRowMelee()));
        assertEquals(1, counterRow.visit(board.getSide(player2).getRowMelee()));
    }

    @Test
    public void fogEffectSetsAllUnitPointsToOneInRangeRows() {
        player1.playCard(unitCard3);
        player2.playCard(unitCard4);
        player1.playCard(fogCard);

        assertEquals(1, counterRow.visit(board.getSide(player1).getRanged()));
        assertEquals(1, counterRow.visit(board.getSide(player2).getRanged()));
    }

    @Test
    public void stormEffectSetsAllUnitPointsToOneInRangeAndSiegeRows() {
        player1.playCard(unitCard3);
        player2.playCard(unitCard4);
        player1.playCard(unitCard5);
        player2.playCard(unitCard6);
        player1.playCard(stormCard);

        assertEquals(1, counterRow.visit(board.getSide(player1).getRowSiege()));
        assertEquals(1, counterRow.visit(board.getSide(player2).getRowSiege()));
        assertEquals(1, counterRow.visit(board.getSide(player1).getRanged()));
        assertEquals(1, counterRow.visit(board.getSide(player2).getRanged()));
    }

    @Test
    public void torrentialRainEffectSetsAllUnitPointsToOneInSiegeRows() {
        player1.playCard(unitCard5);
        player2.playCard(unitCard6);
        player1.playCard(torrentialRainCard);

        assertEquals(1, counterRow.visit(board.getSide(player1).getRowSiege()));
        assertEquals(1, counterRow.visit(board.getSide(player2).getRowSiege()));
    }

    @Test
    public void clearWeatherEffectClearsWeatherEffects() {
        player1.playCard(unitCard1);
        player2.playCard(unitCard4);
        player1.playCard(unitCard5);

        player2.playCard(snowCard);
        player1.playCard(stormCard);

        player2.playCard(clearWeatherEffectsCard);


        assertEquals(unitCard1.getBasePoints(), counterRow.visit(board.getSide(player1).getRowMelee()));
        assertEquals(unitCard4.getBasePoints(), counterRow.visit(board.getSide(player2).getRanged()));
        assertEquals(unitCard5.getBasePoints(), counterRow.visit(board.getSide(player1).getRowSiege()));
    }
}
