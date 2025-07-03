package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.ability.Legendary;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.Point;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.effect.WeatherEffect.SnowEffect;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Section;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LegendaryTest {

    private Game game;
    private Player player1;
    private Player player2;
    private Board board;
    private UnitCard legendaryCard;
    private SpecialCard weatherCard;
    private Legendary legendaryAbility;

    @BeforeEach
    void setUp() {
        game = new Game();
        board = Board.getInstance();
        legendaryAbility = new Legendary();
        
        
        List<Section> sections = new ArrayList<>();
        sections.add(new Melee());
        
        
        Point legendaryPoints = new Point(10);
        legendaryCard = new UnitCard("Geralt", "Legendary Card", legendaryPoints, sections, legendaryAbility);
        
        
        List<Section> weatherSections = new ArrayList<>();
        weatherSections.add(new Melee());
        weatherCard = new SpecialCard("Nieve", "Weather Card", new SnowEffect(weatherSections));
        
        
        List<AbstractCard> deck1Cards = new ArrayList<>();
        deck1Cards.add(legendaryCard);
        Deck deck1 = new Deck(deck1Cards);
        
        List<AbstractCard> deck2Cards = new ArrayList<>();
        deck2Cards.add(weatherCard);
        Deck deck2 = new Deck(deck2Cards);
        
        
        player1 = new Player("Player 1", deck1);
        player2 = new Player("Player 2", deck2);
        
        
        game.setPlayers(player1, player2);
    }

    @Test
    void testLegendaryCardResistsWeatherEffect() {
        
        player1.addCard(legendaryCard);
        player2.addCard(weatherCard);
        
        
        player1.playCard(legendaryCard);
        
        
        List<UnitCard> cardsInMelee = board.getCardsRow(player1, new Melee());
        assertEquals(1, cardsInMelee.size());
        assertEquals(legendaryCard, cardsInMelee.get(0));
        
        
        int legendaryInitialPoints = legendaryCard.getPoints();
        assertEquals(10, legendaryInitialPoints);
        
        
        player2.playCard(weatherCard);
        
        
        int legendaryPointsAfterWeather = legendaryCard.getPoints();
        assertEquals(legendaryInitialPoints, legendaryPointsAfterWeather, 
                    "Legendary card should maintain its original points after weather effect");
    }

    @Test
    void testLegendaryCardResistsWeatherEffectFromSamePlayer() {
        
        player1.addCard(legendaryCard);
        player1.addCard(weatherCard);
        

        player1.playCard(legendaryCard);
        
        int legendaryInitialPoints = legendaryCard.getPoints();
        assertEquals(10, legendaryInitialPoints);
        
        
        player1.playCard(weatherCard);
        
        
        int legendaryPointsAfterWeather = legendaryCard.getPoints();
        assertEquals(legendaryInitialPoints, legendaryPointsAfterWeather, 
                    "Legendary card should maintain its original points after weather effect from same player");
    }

    @Test
    void testLegendaryCardResistsMultipleWeatherEffects() {
        
        List<Section> snowSections = new ArrayList<>();
        snowSections.add(new Melee());
        List<Section> fogSections = new ArrayList<>();
        fogSections.add(new Melee());
        
        SpecialCard snowCard = new SpecialCard("Nieve", "Snow", new SnowEffect(snowSections));
        SpecialCard fogCard = new SpecialCard("Niebla", "Fog", new SnowEffect(fogSections));
        
        player1.addCard(legendaryCard);
        player2.addCard(snowCard);
        player2.addCard(fogCard);
        
        
        player1.playCard(legendaryCard);
        
        int legendaryInitialPoints = legendaryCard.getPoints();
        assertEquals(10, legendaryInitialPoints);
        
        
        player2.playCard(snowCard);
        player2.playCard(fogCard);
        
        
        int legendaryPointsAfterWeather = legendaryCard.getPoints();
        assertEquals(legendaryInitialPoints, legendaryPointsAfterWeather, 
                    "Legendary card should maintain its original points after multiple weather effects");
    }

    @Test
    void testLegendaryCardWithDifferentInitialPoints() {
        
        List<Section> sections = new ArrayList<>();
        sections.add(new Melee());
        
        Point highPoints = new Point(15);
        UnitCard highLegendaryCard = new UnitCard("Ciri", "High Legendary", highPoints, sections, legendaryAbility);
        
        player1.addCard(highLegendaryCard);
        player2.addCard(weatherCard);
        
        
        player1.playCard(highLegendaryCard);
        
        int legendaryInitialPoints = highLegendaryCard.getPoints();
        assertEquals(15, legendaryInitialPoints);
        
        
        player2.playCard(weatherCard);
        
        
        int legendaryPointsAfterWeather = highLegendaryCard.getPoints();
        assertEquals(legendaryInitialPoints, legendaryPointsAfterWeather, 
                    "Legendary card with high points should maintain its original points after weather effect");
    }

    @Test
    void testLegendaryCardResistsWeatherEffectInDifferentSection() {
        
        List<Section> rangedSections = new ArrayList<>();
        rangedSections.add(new Melee());
        
        Point rangedPoints = new Point(8);
        UnitCard rangedLegendaryCard = new UnitCard("Yennefer", "Ranged Legendary", rangedPoints, rangedSections, legendaryAbility);

        List<Section> rangedWeatherSections = new ArrayList<>();
        rangedWeatherSections.add(new Melee());
        SpecialCard rangedWeatherCard = new SpecialCard("Nieve Ranged", "Ranged Weather", new SnowEffect(rangedWeatherSections));
        
        player1.addCard(rangedLegendaryCard);
        player2.addCard(rangedWeatherCard);
        
        
        player1.playCard(rangedLegendaryCard);
        
        int legendaryInitialPoints = rangedLegendaryCard.getPoints();
        assertEquals(8, legendaryInitialPoints);
        
        
        player2.playCard(rangedWeatherCard);
        
        
        int legendaryPointsAfterWeather = rangedLegendaryCard.getPoints();
        assertEquals(legendaryInitialPoints, legendaryPointsAfterWeather, 
                    "Legendary card in different section should maintain its original points after weather effect");
    }
} 