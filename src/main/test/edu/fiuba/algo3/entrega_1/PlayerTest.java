package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.Point;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.effect.MoraleBoost;
import edu.fiuba.algo3.modelo.effect.weatherEffects.*;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Ranged;
import edu.fiuba.algo3.modelo.section.Siege;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Game game;
    private Player player1;
    private Player player2;
    private Deck deck1;
    private Deck deck2;
    private UnitCard unitCard;

    private UnitCard card1;
    private UnitCard card2;
    private UnitCard card3;
    private SpecialCard card4;
    private MoraleBoost moraleBoost = new MoraleBoost(new Melee(), player1);
    @BeforeEach
    public void setUp() {
        unitCard = new UnitCard("Arquero", "Unidad a distancia", new Point(5), new Melee());
        card1 = new UnitCard("Catapulta", "unidad de asedio", new Point(4), new Siege());
        card2 = new UnitCard("Espadachín", "unidad cuerpo a cuerpo",new Point(6), new Melee());
        card3 = new UnitCard("Ballesta", "unidad a distancia",new Point(3), new Siege());
        card4 = new SpecialCard("ejemplo", "ej", moraleBoost);

        List<AbstractCard> cards1 = new ArrayList<>();
        cards1.add(unitCard);
        cards1.add(card1);
        cards1.add(card2);
        cards1.add(card3);
        cards1.add(card4);
        deck1 = new Deck(cards1);

        deck2 = new Deck(new ArrayList<>());

        player1 = new Player("Jugador1", deck1);
        player2 = new Player("Jugador2", deck2);

        game = new Game();
        game.setPlayers(player1, player2);


        player1.addCard(unitCard);
        player1.addCard(card1);
        player1.addCard(card2);
        player1.addCard(card3);
    }

    @Test
    public void testPlayerCanPlayCard() {
        player1.playCard(unitCard);
        player1.playCard(card2);
        player1.playCard(card4);
        //assertEquals(initialHandSize - 1, player1.getHand().size());
    }

    @Test
    public void testPlayerGetsPointsAfterPlayingCard() {
        player1.playCard(unitCard);
        Assertions.assertEquals(unitCard.getPoints(), player1.getPoints());
    }

    @Test
    public void testPlayerCanDiscardCards() {

        int initialDiscardPileSize = player1.getDiscardPile().size();

        player1.discardCard(card1);
        player1.discardCard(card2);

        assertEquals(initialDiscardPileSize + 2, player1.getDiscardPile().size());

    }


    @Test
    public void VerificarQueUnJugadorPoseaCartasSuficientesParaEmpezarElJuegoEnSuMazo() {
        List<AbstractCard> cards1 = new ArrayList<>();


        Deck deck = new Deck(cards1);

        UnitCard guerrero = new UnitCard("guerrero", "guerrero", new Point(10), new Melee());
        deck.addCard(guerrero);
        UnitCard paladin = new UnitCard("paladin", "paladin", new Point(5), new Melee());
        deck.addCard(paladin);
        UnitCard arquero = new UnitCard("arquero", "arquero", new Point(6), new Ranged());
        deck.addCard(arquero);
        UnitCard francotirador = new UnitCard("francotirador", "francotirador", new Point(7), new Ranged());
        deck.addCard(francotirador);
        UnitCard catapulta = new UnitCard("catapulta", "catapulta", new Point(8), new Siege());
        deck.addCard(catapulta);
        UnitCard mortero = new UnitCard("mortero", "siege", new Point(9), new Siege());
        deck.addCard(mortero);
        UnitCard gladiador = new UnitCard("gladiador", "melee", new Point(12), new Melee());
        deck.addCard(gladiador);
        UnitCard centurion = new UnitCard("centurion", "melee", new Point(12), new Melee());
        deck.addCard(centurion);


        Player player1 = new Player("matias", deck);


        assertThrows(IllegalArgumentException.class, () -> player1.distributeCards(10),
                "the number of cards needed is 10 to start the game");

    }

    @Test
    public void VerificarQueAUnJugadorSeLeReparten10CartasDeSuMazo(){

        List<AbstractCard> cards1 = new ArrayList<>();
        Deck deck = new Deck(cards1);

        UnitCard guerrero = new UnitCard("guerrero", "guerrero", new Point(10), new Melee());
        deck.addCard(guerrero);
        UnitCard paladin = new UnitCard("paladin", "paladin", new Point(5), new Melee());
        deck.addCard(paladin);
        UnitCard arquero = new UnitCard("arquero", "arquero", new Point(6), new Ranged());
        deck.addCard(arquero);
        UnitCard francotirador = new UnitCard("francotirador", "francotirador", new Point(7), new Ranged());
        deck.addCard(francotirador);
        UnitCard catapulta = new UnitCard("catapulta", "catapulta", new Point(8), new Siege());
        deck.addCard(catapulta);
        UnitCard mortero = new UnitCard("mortero", "siege", new Point(9), new Siege());
        deck.addCard(mortero);
        UnitCard gladiador = new UnitCard("gladiador", "melee", new Point(12), new Melee());
        deck.addCard(gladiador);
        UnitCard centurion = new UnitCard("centurion", "melee", new Point(12), new Melee());
        deck.addCard(centurion);
        UnitCard canion = new UnitCard("canion", "siege", new Point(14), new Melee());
        deck.addCard(canion);
        UnitCard ariete = new UnitCard("ariete", "melee", new Point(15), new Melee());
        deck.addCard(ariete);
        UnitCard geralt = new UnitCard("geralt", "geralt", new Point(5), new Melee());
        deck.addCard(geralt);
        UnitCard ciri = new UnitCard("ciri", "ciri", new Point(6), new Melee());
        deck.addCard(ciri);
        UnitCard dijkstra = new UnitCard("dijkstra", "dijkstra", new Point(7), new Melee());
        deck.addCard(dijkstra);

        Player player1 = new Player("matias", deck);

        player1.distributeCards(10);

        assertTrue(player1.hasNumberOfCards(10));
    }


    @Test
    public void playCardInIncorrectSection (){
    UnitCard unitCard1 = new UnitCard("Espadachín", "description", new Point(7), new Melee());
    UnitCard unitCard2 = new UnitCard("Lanzero", "description", new Point(4), new Melee());
    UnitCard unitCard3 = new UnitCard("Arquero", "description", new Point(4), new Ranged());
    UnitCard unitCard4 = new UnitCard("Ballestero", "description", new Point(4), new Ranged());
    UnitCard unitCard5 = new UnitCard("Catapulta", "description", new Point(4), new Siege());
    UnitCard unitCard6 = new UnitCard("Trebuchet", "description", new Point(4), new Siege());

    SpecialCard snowCard = new SpecialCard("Nieve", "descrition", new SnowEffect(new Melee(), player1));
    SpecialCard fogCard = new SpecialCard("Niebla", "descrition", new FogEffect(new Melee(),  player1));
    SpecialCard torrentialRainCard = new SpecialCard("Lluvia torrencial", "descrition", new TorrentialRainEffect(new Melee(), player1));
    SpecialCard stormCard = new SpecialCard("Tormenta", "descrition", new StormEffect(new Melee(), player1));
    SpecialCard clearWeatherEffectsCard = new SpecialCard("Despejar Clima", "descrition", new ClearWeatherEffect(new Melee(), player1));

    Deck deck1 = new Deck(Arrays.asList(unitCard1, unitCard3, unitCard5, snowCard, fogCard, torrentialRainCard, stormCard, clearWeatherEffectsCard));
    Deck deck2 = new Deck(Arrays.asList(unitCard2, unitCard4, unitCard6, snowCard, clearWeatherEffectsCard));

    Player player1 = new Player("Jugador 1", deck1);
    Player player2 = new Player("Jugador 2", deck2);

    Game game = new Game();

    game.setPlayers(player1,player2);


        assertThrows(IllegalArgumentException.class, () -> player1.playCard(unitCard2),
                "Cannot play this card in ranged section");


    }
}
