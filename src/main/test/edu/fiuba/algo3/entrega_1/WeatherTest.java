//package edu.fiuba.algo3.entrega_1;
//
//import edu.fiuba.algo3.modelo.Game;
//import edu.fiuba.algo3.modelo.board.Board;
//import edu.fiuba.algo3.modelo.card.SpecialCard;
//import edu.fiuba.algo3.modelo.card.UnitCard;
//import edu.fiuba.algo3.modelo.deck.Deck;
//import edu.fiuba.algo3.modelo.effect.Weather;
//import edu.fiuba.algo3.modelo.effect.weatherEffects.FogEffect;
//import edu.fiuba.algo3.modelo.effect.weatherEffects.SnowEffect;
//import edu.fiuba.algo3.modelo.effect.weatherEffects.TorrentialRainEffect;
//import edu.fiuba.algo3.modelo.effect.weatherEffects.StormEffect;
//import edu.fiuba.algo3.modelo.effect.weatherEffects.ClearWeatherEffect;
//import edu.fiuba.algo3.modelo.enums.SectionType;
//import edu.fiuba.algo3.modelo.player.Player;
//
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Arrays;
//
//public class WeatherTest {
//    UnitCard unitCard1 = new UnitCard("Espadachín", "description", 7, SectionType.MELEE);
//    UnitCard unitCard2 = new UnitCard("Lanzero", "description", 4, SectionType.MELEE);
//    UnitCard unitCard3 = new UnitCard("Arquero", "description", 4, SectionType.RANGED);
//    UnitCard unitCard4 = new UnitCard("Ballestero", "description", 4, SectionType.RANGED);
//    UnitCard unitCard5 = new UnitCard("Catapulta", "description", 4, SectionType.SIEGE);
//    UnitCard unitCard6 = new UnitCard("Trebuchet", "description", 4, SectionType.SIEGE);
//
//    SpecialCard snowCard = new SpecialCard("Nieve", "descrition", new SnowEffect());
//    SpecialCard fogCard = new SpecialCard("Niebla", "descrition", new FogEffect());
//    SpecialCard torrentialRainCard = new SpecialCard("Lluvia torrencial", "descrition", new TorrentialRainEffect());
//    SpecialCard stormCard = new SpecialCard("Tormenta", "descrition", new StormEffect());
//    SpecialCard clearWeatherEffectsCard = new SpecialCard("Despejar Clima", "descrition", new ClearWeatherEffect());
//
//    Deck deck1 = new Deck(Arrays.asList(unitCard1, unitCard3, unitCard5, snowCard, fogCard, torrentialRainCard, stormCard, clearWeatherEffectsCard));
//    Deck deck2 = new Deck(Arrays.asList(unitCard2, unitCard4, unitCard6, snowCard, clearWeatherEffectsCard));
//
//    Player player1 = new Player("Jugador 1", deck1);
//    Player player2 = new Player("Jugador 2", deck2);
//
//    Game game = new Game();
//
//    @Test
//    public void snowEffectSetsAllUnitPointsToOneInMeleeRows() {
//        game.setPlayers(player1, player2);
//        game.playCard(player1, unitCard1);
//        game.playCard(player2, unitCard2);
//        game.playCard(player1, snowCard);
//
//        Board board = game.getBoard();
//        assertEquals(1, board.getRow(player1, SectionType.MELEE).calculatePoints());
//        assertEquals(1, board.getRow(player2, SectionType.MELEE).calculatePoints());
//    }
//
//
//    @Test
//    public void fogEffectSetsAllUnitPointsToOneInRangeRows() {
//        game.setPlayers(player1, player2);
//        game.playCard(player1, unitCard3);
//        game.playCard(player2, unitCard4);
//        game.playCard(player1, fogCard);
//
//        Board board = game.getBoard();
//        assertEquals(1, board.getRow(player1, SectionType.RANGED).calculatePoints());
//        assertEquals(1, board.getRow(player2, SectionType.RANGED).calculatePoints());
//    }
//
//
//    @Test
//    public void stormEffectSetsAllUnitPointsToOneInRangeAndSiegeRows() {
//        game.setPlayers(player1, player2);
//        game.playCard(player1, unitCard3);
//        game.playCard(player2, unitCard4);
//        game.playCard(player1, unitCard5);
//        game.playCard(player2, unitCard6);
//        game.playCard(player1, stormCard);
//
//        Board board = game.getBoard();
//        assertEquals(1, board.getRow(player1, SectionType.SIEGE).calculatePoints());
//        assertEquals(1, board.getRow(player2, SectionType.SIEGE).calculatePoints());
//        assertEquals(1, board.getRow(player1, SectionType.RANGED).calculatePoints());
//        assertEquals(1, board.getRow(player2, SectionType.RANGED).calculatePoints());
//    }
//
//    @Test
//    public void torrentialRainEffectSetsAllUnitPointsToOneInSiegeRows() {
//        game.setPlayers(player1, player2);
//        game.playCard(player1, unitCard5);
//        game.playCard(player2, unitCard6);
//        game.playCard(player1, torrentialRainCard);
//
//        Board board = game.getBoard();
//        assertEquals(1, board.getRow(player1, SectionType.SIEGE).calculatePoints());
//        assertEquals(1, board.getRow(player2, SectionType.SIEGE).calculatePoints());
//    }
//
//
//    @Test
//    public void clearWeatherEffectClearsWeatherEffects() {
//        game.setPlayers(player1, player2);
//        game.playCard(player1, unitCard1);
//        game.playCard(player2, unitCard4);
//        game.playCard(player1, unitCard5);
//
//        game.playCard(player2, snowCard);
//        game.playCard(player1, stormCard);
//
//        game.playCard(player2, clearWeatherEffectsCard);
//
//        Board board = game.getBoard();
//        assertEquals(unitCard1.getBasePoints(), board.getRow(player1, SectionType.MELEE).calculatePoints());
//        assertEquals(unitCard4.getBasePoints(), board.getRow(player2, SectionType.RANGED).calculatePoints());
//        assertEquals(unitCard5.getBasePoints(), board.getRow(player1, SectionType.SIEGE).calculatePoints());
//    }
//
//
//
//
//
//
//}
