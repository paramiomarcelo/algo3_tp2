package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.ability.SumBaseValue;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.Point;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Section;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SumBaseValueTest {

    private Game game;
    private Player player1;
    private Player player2;
    private Board board;
    private UnitCard sumBaseValueCard;
    private UnitCard card1;
    private UnitCard card2;
    private UnitCard card3;
    private SumBaseValue sumBaseValueAbility;

    @BeforeEach
    void setUp() {
        game = new Game();
        board = Board.getInstance();
        sumBaseValueAbility = new SumBaseValue();
        
        
        List<Section> sections = new ArrayList<>();
        sections.add(new Melee());
        
        
        Point sumBaseValuePoints = new Point(5);
        sumBaseValueCard = new UnitCard("SumBaseValue Card", "Sums +1 to all cards in row", sumBaseValuePoints, sections, sumBaseValueAbility);
        
        
        Point point1 = new Point(3);
        card1 = new UnitCard("Card 1", "First card", point1, sections);
        
        Point point2 = new Point(4);
        card2 = new UnitCard("Card 2", "Second card", point2, sections);
        
        Point point3 = new Point(6);
        card3 = new UnitCard("Card 3", "Third card", point3, sections);
        
        
        List<AbstractCard> deck1Cards = new ArrayList<>();
        deck1Cards.add(sumBaseValueCard);
        deck1Cards.add(card1);
        deck1Cards.add(card2);
        deck1Cards.add(card3);
        Deck deck1 = new Deck(deck1Cards);
        
        List<AbstractCard> deck2Cards = new ArrayList<>();
        Deck deck2 = new Deck(deck2Cards);
        
        
        player1 = new Player("Player 1", deck1);
        player2 = new Player("Player 2", deck2);
        
        game.setPlayers(player1, player2);
    }

    @Test
    void testSumBaseValueAddsOneToAllCardsInSection() {
        
        player1.addCard(sumBaseValueCard);
        player1.addCard(card1);
        player1.addCard(card2);
        player1.addCard(card3);
        
        
        player1.playCard(card1);
        player1.playCard(card2);
        player1.playCard(card3);
        
        
        int card1InitialPoints = card1.getPoints();
        int card2InitialPoints = card2.getPoints();
        int card3InitialPoints = card3.getPoints();
        
        assertEquals(3, card1InitialPoints);
        assertEquals(4, card2InitialPoints);
        assertEquals(6, card3InitialPoints);
        
        
        player1.playCard(sumBaseValueCard);
        

        int card1PointsAfter = card1.getPoints();
        int card2PointsAfter = card2.getPoints();
        int card3PointsAfter = card3.getPoints();
        
        assertEquals(card1InitialPoints + 1, card1PointsAfter, "Card 1 should have +1 point");
        assertEquals(card2InitialPoints + 1, card2PointsAfter, "Card 2 should have +1 point");
        assertEquals(card3InitialPoints + 1, card3PointsAfter, "Card 3 should have +1 point");
        
        
        List<UnitCard> cardsInMelee = board.getCardsRow(player1, new Melee());
        assertEquals(4, cardsInMelee.size()); 
        assertTrue(cardsInMelee.contains(sumBaseValueCard));
    }

    @Test
    void testSumBaseValueWithEmptySection() {
        
        player1.addCard(sumBaseValueCard);
        
        
        player1.playCard(sumBaseValueCard);
        
        
        List<UnitCard> cardsInMelee = board.getCardsRow(player1, new Melee());
        assertEquals(1, cardsInMelee.size());
        assertEquals(sumBaseValueCard, cardsInMelee.get(0));
        
        
        int sumBaseValuePoints = sumBaseValueCard.getPoints();
        assertEquals(5, sumBaseValuePoints); 
    }

    @Test
    void testSumBaseValueWithOneCardInSection() {
        
        player1.addCard(sumBaseValueCard);
        player1.addCard(card1);
        
        
        player1.playCard(card1);
        
        int card1InitialPoints = card1.getPoints();
        assertEquals(3, card1InitialPoints);
        
        
        player1.playCard(sumBaseValueCard);
        
        
        int card1PointsAfter = card1.getPoints();
        assertEquals(card1InitialPoints + 1, card1PointsAfter, "Single card should receive +1 point");
    }
} 