package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.card.Point;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Section;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    private Deck deck;
    private UnitCard card1;
    private UnitCard card2;

    @BeforeEach
    void setUp() {
        List<Section> sections = new ArrayList<>();
        sections.add(new Melee());

        card1 = new UnitCard("Carta 1", "Primera carta", new Point(5), sections);
        card2 = new UnitCard("Carta 2", "Segunda carta", new Point(3), sections);

        List<edu.fiuba.algo3.modelo.card.AbstractCard> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);

        deck = new Deck(cards);
    }

    @Test
    void testSize() {
        assertEquals(2, deck.size(), "The deck should have 2 cards");
    }

    @Test
    void testGet() {
        assertEquals(card1, deck.get(0), "The first card should be 'Card 1'");
        assertEquals(card2, deck.get(1), "The second card should be 'Card 2'");
    }

    @Test
    void testGetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> deck.get(2), "Should throw exception if index is invalid");
    }
}