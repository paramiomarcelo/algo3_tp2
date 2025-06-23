package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.Point;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.effect.WeatherEffect.*;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Ranged;
import edu.fiuba.algo3.modelo.section.Section;
import edu.fiuba.algo3.modelo.section.Siege;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherTest {

    @Test
    public void snowEffectSetsAllUnitPointsToOneInMeleeRows() {
        Board.getInstance().reset();
        
        List<Section> sectionMelee = new ArrayList<>();
        sectionMelee.add(new Melee());

        UnitCard unitCard1 = new UnitCard("Espadachín", "description", new Point(7), sectionMelee);
        UnitCard unitCard2 = new UnitCard("Lanzero", "description", new Point(4), sectionMelee);
        SpecialCard snowCard = new SpecialCard("Nieve", "descrition", new SnowEffect(sectionMelee));

        Deck deck1 = new Deck(Arrays.asList(unitCard1, snowCard));
        Deck deck2 = new Deck(Arrays.asList(unitCard2, snowCard));
        Player player1 = new Player("Jugador 1", deck1);
        Player player2 = new Player("Jugador 2", deck2);
        Game game = new Game();
        game.setPlayers(player1, player2);

        player1.playCard(unitCard1);
        player2.playCard(unitCard2);
        player1.playCard(snowCard);

        assertEquals(1, player1.getPoints());
        assertEquals(1, player2.getPoints());
    }

    @Test
    public void fogEffectSetsAllUnitPointsToOneInRangeRows() {
        Board.getInstance().reset();
        
        List<Section> sectionRanged = new ArrayList<>();
        sectionRanged.add(new Ranged());

        UnitCard unitCard3 = new UnitCard("Arquero", "description", new Point(4), sectionRanged);
        UnitCard unitCard4 = new UnitCard("Ballestero", "description", new Point(4), sectionRanged);
        SpecialCard fogCard = new SpecialCard("Niebla", "descrition", new FogEffect(sectionRanged));

        Deck deck1 = new Deck(Arrays.asList(unitCard3, fogCard));
        Deck deck2 = new Deck(Arrays.asList(unitCard4, fogCard));
        Player player1 = new Player("Jugador 1", deck1);
        Player player2 = new Player("Jugador 2", deck2);
        Game game = new Game();
        game.setPlayers(player1, player2);

        player1.playCard(unitCard3);
        player2.playCard(unitCard4);
        player1.playCard(fogCard);

        assertEquals(1, player1.getPoints());
        assertEquals(1, player2.getPoints());
    }

    @Test
    public void stormEffectSetsAllUnitPointsToOneInRangeAndSiegeRows() {
        Board.getInstance().reset();
        
        List<Section> sectionRanged = new ArrayList<>();
        sectionRanged.add(new Ranged());
        List<Section> sectionMelee = new ArrayList<>();
        sectionMelee.add(new Melee());
        List<Section> stormSections = new ArrayList<>();
        stormSections.add(new Melee());
        stormSections.add(new Ranged());

        UnitCard unitCard1 = new UnitCard("Espadachín", "description", new Point(7), sectionMelee);
        UnitCard unitCard2 = new UnitCard("Lanzero", "description", new Point(4), sectionMelee);
        UnitCard unitCard3 = new UnitCard("Arquero", "description", new Point(4), sectionRanged);
        UnitCard unitCard4 = new UnitCard("Ballestero", "description", new Point(4), sectionRanged);
        SpecialCard stormCard = new SpecialCard("Tormenta", "descrition", new StormEffect(stormSections));

        Deck deck1 = new Deck(Arrays.asList(unitCard1, unitCard3, stormCard));
        Deck deck2 = new Deck(Arrays.asList(unitCard2, unitCard4, stormCard));
        Player player1 = new Player("Jugador 1", deck1);
        Player player2 = new Player("Jugador 2", deck2);
        Game game = new Game();
        game.setPlayers(player1, player2);

        player1.playCard(unitCard3);
        player2.playCard(unitCard4);
        player1.playCard(unitCard1);
        player2.playCard(unitCard2);
        player1.playCard(stormCard);

        assertEquals(2, player1.getPoints());
        assertEquals(2, player2.getPoints());
    }

    @Test
    public void torrentialRainEffectSetsAllUnitPointsToOneInSiegeRows() {
        Board.getInstance().reset();
        
        List<Section> sectionSiege = new ArrayList<>();
        sectionSiege.add(new Siege());

        UnitCard unitCard5 = new UnitCard("Catapulta", "description", new Point(4), sectionSiege);
        UnitCard unitCard6 = new UnitCard("Trebuchet", "description", new Point(4), sectionSiege);
        SpecialCard torrentialRainCard = new SpecialCard("Lluvia torrencial", "descrition", new TorrentialRainEffect(sectionSiege));

        Deck deck1 = new Deck(Arrays.asList(unitCard5, torrentialRainCard));
        Deck deck2 = new Deck(Arrays.asList(unitCard6, torrentialRainCard));
        Player player1 = new Player("Jugador 1", deck1);
        Player player2 = new Player("Jugador 2", deck2);
        Game game = new Game();
        game.setPlayers(player1, player2);

        player1.playCard(unitCard5);
        player2.playCard(unitCard6);
        player1.playCard(torrentialRainCard);

        assertEquals(1, player1.getPoints());
        assertEquals(1, player2.getPoints());
    }

    @Test
    public void clearWeatherEffectClearsWeatherEffects() {
        Board.getInstance().reset();
        
        List<Section> sectionMelee = new ArrayList<>();
        sectionMelee.add(new Melee());
        List<Section> sectionRanged = new ArrayList<>();
        sectionRanged.add(new Ranged());
        List<Section> sectionSiege = new ArrayList<>();
        sectionSiege.add(new Siege());
        List<Section> allSections = new ArrayList<>();
        allSections.add(new Siege());
        allSections.add(new Ranged());
        allSections.add(new Melee());
        List<Section> stormSections = new ArrayList<>();
        stormSections.add(new Melee());
        stormSections.add(new Ranged());

        UnitCard unitCard1 = new UnitCard("Espadachín", "description", new Point(7), sectionMelee);
        UnitCard unitCard4 = new UnitCard("Ballestero", "description", new Point(4), sectionRanged);
        UnitCard unitCard5 = new UnitCard("Catapulta", "description", new Point(4), sectionSiege);
        SpecialCard snowCard = new SpecialCard("Nieve", "descrition", new SnowEffect(sectionMelee));
        SpecialCard stormCard = new SpecialCard("Tormenta", "descrition", new StormEffect(stormSections));
        SpecialCard clearWeatherEffectsCard = new SpecialCard("Despejar Clima", "descrition", new ClearWeatherEffect(allSections));

        Deck deck1 = new Deck(Arrays.asList(unitCard1, unitCard5, snowCard, stormCard));
        Deck deck2 = new Deck(Arrays.asList(unitCard4, clearWeatherEffectsCard));
        Player player1 = new Player("Jugador 1", deck1);
        Player player2 = new Player("Jugador 2", deck2);
        Game game = new Game();
        game.setPlayers(player1, player2);

        player1.playCard(unitCard1);
        player2.playCard(unitCard4);
        player1.playCard(unitCard5);
        player2.playCard(snowCard);
        player1.playCard(stormCard);
        player2.playCard(clearWeatherEffectsCard);

        assertEquals(11, player1.getPoints());
        assertEquals(4, player2.getPoints());
    }

    @Test
    public void simpleSnowEffectTest() {
        Board.getInstance().reset();
        
        List<Section> sectionMelee = new ArrayList<>();
        sectionMelee.add(new Melee());

        UnitCard unitCard1 = new UnitCard("Espadachín", "description", new Point(7), sectionMelee);
        UnitCard unitCard2 = new UnitCard("Lanzero", "description", new Point(4), sectionMelee);
        SpecialCard snowCard = new SpecialCard("Nieve", "descrition", new SnowEffect(sectionMelee));

        Deck deck1 = new Deck(Arrays.asList(unitCard1, snowCard));
        Deck deck2 = new Deck(Arrays.asList(unitCard2));
        Player player1 = new Player("Jugador 1", deck1);
        Player player2 = new Player("Jugador 2", deck2);
        Game game = new Game();
        game.setPlayers(player1, player2);


        player1.playCard(unitCard1);
        player2.playCard(unitCard2);
        assertEquals(7, player1.getPoints());
        assertEquals(4, player2.getPoints());


        player1.playCard(snowCard);
        

        assertEquals(1, player1.getPoints());
        assertEquals(1, player2.getPoints());
    }
}
