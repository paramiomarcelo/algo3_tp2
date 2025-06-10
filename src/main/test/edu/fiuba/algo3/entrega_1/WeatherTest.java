package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.effect.weatherEffects.*;
import edu.fiuba.algo3.modelo.player.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherTest {

    UnitCard unitCard1 = new UnitCard("Espadachín", "description", 7, "melee");
    UnitCard unitCard2 = new UnitCard("Lanzero", "description", 4, "melee");
    UnitCard unitCard3 = new UnitCard("Arquero", "description", 4, "ranged");
    UnitCard unitCard4 = new UnitCard("Ballestero", "description", 4, "ranged");
    UnitCard unitCard5 = new UnitCard("Catapulta", "description", 4, "siege");
    UnitCard unitCard6 = new UnitCard("Trebuchet", "description", 4, "siege");

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

    @BeforeEach
    public void setBoard() {
        game.setPlayers(player1, player2);
    }

    @Test
    public void snowEffectSetsAllUnitPointsToOneInMeleeRows() {
        player1.playCard(unitCard1);
        player2.playCard(unitCard2);
        player1.playCard(snowCard);

        assertEquals(1, board.getRow(player1, "melee").calculatePoints());
        assertEquals(1, board.getRow(player2, "melee").calculatePoints());
    }

    @Test
    public void fogEffectSetsAllUnitPointsToOneInRangeRows() {
        player1.playCard(unitCard3);
        player2.playCard(unitCard4);
        player1.playCard(fogCard);

        assertEquals(1, board.getRow(player1, "ranged").calculatePoints());
        assertEquals(1, board.getRow(player2, "ranged").calculatePoints());
    }

    @Test
    public void stormEffectSetsAllUnitPointsToOneInRangeAndSiegeRows() {
        player1.playCard(unitCard3);
        player2.playCard(unitCard4);
        player1.playCard(unitCard5);
        player2.playCard(unitCard6);
        player1.playCard(stormCard);

        assertEquals(1, board.getRow(player1, "siege").calculatePoints());
        assertEquals(1, board.getRow(player2, "siege").calculatePoints());
        assertEquals(1, board.getRow(player1, "ranged").calculatePoints());
        assertEquals(1, board.getRow(player2, "ranged").calculatePoints());
    }

    @Test
    public void torrentialRainEffectSetsAllUnitPointsToOneInSiegeRows() {
        player1.playCard(unitCard5);
        player2.playCard(unitCard6);
        player1.playCard(torrentialRainCard);

        assertEquals(1, board.getRow(player1, "siege").calculatePoints());
        assertEquals(1, board.getRow(player2, "siege").calculatePoints());
    }

    @Test
    public void clearWeatherEffectClearsWeatherEffects() {
        player1.playCard(unitCard1);
        player2.playCard(unitCard4);
        player1.playCard(unitCard5);

        player2.playCard(snowCard);
        player1.playCard(stormCard);

        player2.playCard(clearWeatherEffectsCard);

        assertEquals(unitCard1.getBasePoints(), board.getRow(player1, "melee").calculatePoints());
        assertEquals(unitCard4.getBasePoints(), board.getRow(player2, "ranged").calculatePoints());
        assertEquals(unitCard5.getBasePoints(), board.getRow(player1, "siege").calculatePoints());
    }
}
