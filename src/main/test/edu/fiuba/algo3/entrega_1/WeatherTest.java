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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherTest {

    List<Section> sectionMelee = new ArrayList<>();
    List<Section> sectionRanged = new ArrayList<>();
    List<Section> sectionSiege = new ArrayList<>();
    List<Section> allSections = new ArrayList<>();
    List<Section> stormSections = new ArrayList<>();

    {
        sectionMelee.add(new Melee());
        sectionRanged.add(new Ranged());
        sectionSiege.add(new Siege());

        allSections.add(new Siege());
        allSections.add(new Ranged());
        allSections.add(new Melee());

        stormSections.add(new Melee());
        stormSections.add(new Ranged());
    }

    UnitCard unitCard1 = new UnitCard("Espadachín", "description", new Point(7), sectionMelee);
    UnitCard unitCard2 = new UnitCard("Lanzero", "description", new Point(4), sectionMelee);
    UnitCard unitCard3 = new UnitCard("Arquero", "description", new Point(4), sectionRanged);
    UnitCard unitCard4 = new UnitCard("Ballestero", "description", new Point(4), sectionRanged);
    UnitCard unitCard5 = new UnitCard("Catapulta", "description", new Point(4), sectionSiege);
    UnitCard unitCard6 = new UnitCard("Trebuchet", "description", new Point(4), sectionSiege);

    SpecialCard snowCard = new SpecialCard("Nieve", "descrition", new SnowEffect(sectionMelee));
    SpecialCard fogCard = new SpecialCard("Niebla", "descrition", new FogEffect(sectionSiege));
    SpecialCard torrentialRainCard = new SpecialCard("Lluvia torrencial", "descrition", new TorrentialRainEffect(sectionRanged));
    SpecialCard stormCard = new SpecialCard("Tormenta", "descrition", new StormEffect(stormSections));
    SpecialCard clearWeatherEffectsCard = new SpecialCard("Despejar Clima", "descrition", new ClearWeatherEffect(allSections));

    Deck deck1 = new Deck(Arrays.asList(unitCard1, unitCard3, unitCard5, snowCard, fogCard, torrentialRainCard, stormCard/*, clearWeatherEffectsCard*/));
    Deck deck2 = new Deck(Arrays.asList(unitCard2, unitCard4, unitCard6, snowCard, clearWeatherEffectsCard));

    Player player1 = new Player("Jugador 1", deck1);
    Player player2 = new Player("Jugador 2", deck2);

    Game game = new Game();

    @BeforeEach
    public void setBoard() {
        game.setPlayers(player1, player2);
    }

    @Test
    public void snowEffectSetsAllUnitPointsToOneInMeleeRows() {
        player1.playCard(unitCard1);
        player2.playCard(unitCard2);
        player1.playCard(snowCard);

        assertEquals(1, player1.getPoints());
        assertEquals(1, player2.getPoints());
    }

    @Test
    public void fogEffectSetsAllUnitPointsToOneInRangeRows() {
        player1.playCard(unitCard3);
        player2.playCard(unitCard4);
        player1.playCard(torrentialRainCard);

        assertEquals(1, player1.getPoints());
        assertEquals(1, player2.getPoints());
    }

    @Test
    public void stormEffectSetsAllUnitPointsToOneInRangeAndSiegeRows() {
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
        player1.playCard(unitCard5);
        player2.playCard(unitCard6);
        player1.playCard(torrentialRainCard);

        assertEquals(1, player1.getPoints());
        assertEquals(1, player2.getPoints());
    }

   @Test
    public void clearWeatherEffectClearsWeatherEffects() {
        player1.playCard(unitCard1);
        player2.playCard(unitCard4);
        player1.playCard(unitCard5);

        player2.playCard(snowCard);
        player1.playCard(stormCard);

        player2.playCard(clearWeatherEffectsCard);

        assertEquals(11, player1.getPoints());
        assertEquals(4, player2.getPoints());
    }
}
