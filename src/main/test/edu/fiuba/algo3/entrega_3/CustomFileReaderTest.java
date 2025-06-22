package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.fileReader.CustomFileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomFileReaderTest {

    private CustomFileReader customFileReader;

    @BeforeEach
    void setUp() {
        customFileReader = new CustomFileReader();
    }

    @Test
    @DisplayName("Should read the Gwent JSON file correctly")
    void shouldReadGwentFileCorrectly() throws Exception {
        String path = "src/test/resources/json/gwent.json";


        List<Deck> decks = customFileReader.read(path);


        assertNotNull(decks);
        assertEquals(2, decks.size(), "Should have 2 decks (one for each player)");

        Deck deck1 = decks.get(0);
        Deck deck2 = decks.get(1);

        assertNotNull(deck1);
        assertNotNull(deck2);
    }

    @Test
    @DisplayName("Should read unit cards from the first player correctly")
    void shouldReadUnitCardsFromPlayer1() throws Exception {
        String path = "src/test/resources/json/gwent.json";


        List<Deck> decks = customFileReader.read(path);
        Deck deck1 = decks.get(0);


        assertTrue(deck1.size() > 0, "Player 1's deck should have cards");


        boolean hasGeralt = false;
        boolean hasBirna = false;

        for (int i = 0; i < deck1.size(); i++) {
            AbstractCard card = deck1.get(i);
            if (card instanceof UnitCard) {
                UnitCard unitCard = (UnitCard) card;
                if ("Geralt de Rivia".equals(unitCard.getName())) {
                    hasGeralt = true;
                    assertEquals(15, unitCard.getPoints(), "Geralt should have 15 points");
                }
                if ("Birna Bran".equals(unitCard.getName())) {
                    hasBirna = true;
                    assertEquals(2, unitCard.getPoints(), "Birna should have 2 points");
                }
            }
        }

        assertTrue(hasGeralt, "Should find Geralt de Rivia card");
        assertTrue(hasBirna, "Should find Birna Bran card");
    }

    @Test
    @DisplayName("Should read special cards correctly")
    void shouldReadSpecialCards() throws Exception {

        String path = "src/test/resources/json/gwent.json";

        List<Deck> decks = customFileReader.read(path);
        Deck deck1 = decks.get(0);

        boolean hasCommanderHorn = false;
        boolean hasBitingFrost = false;

        for (int i = 0; i < deck1.size(); i++) {
            AbstractCard card = deck1.get(i);
            if (card instanceof SpecialCard) {
                SpecialCard specialCard = (SpecialCard) card;
                if ("Cuerno del comandante".equals(specialCard.getName())) {
                    hasCommanderHorn = true;
                }
                if ("Escarcha mordaz".equals(specialCard.getName())) {
                    hasBitingFrost = true;
                }
            }
        }

        assertTrue(hasCommanderHorn, "Should find Commander's Horn special card");
        assertTrue(hasBitingFrost, "Should find Biting Frost special card");
    }

    @Test
    @DisplayName("Should read cards with abilities correctly")
    void shouldReadCardsWithAbilities() throws Exception {

        String path = "src/test/resources/json/gwent.json";


        List<Deck> decks = customFileReader.read(path);
        Deck deck1 = decks.get(0);


        boolean hasMedic = false;
        boolean hasSpy = false;

        for (int i = 0; i < deck1.size(); i++) {
            AbstractCard card = deck1.get(i);
            if (card instanceof UnitCard) {
                UnitCard unitCard = (UnitCard) card;
                if ("Birna Bran".equals(unitCard.getName())) {
                    hasMedic = true;
                }
                if ("Thaler".equals(unitCard.getName())) {
                    hasSpy = true;
                }
            }
        }

        assertTrue(hasMedic, "Should find card with medic ability");
        assertTrue(hasSpy, "Should find card with spy ability");
    }

    @Test
    @DisplayName("Should read agile cards with multiple sections correctly")
    void shouldReadAgileCards() throws Exception {
        String path = "src/test/resources/json/gwent.json";


        List<Deck> decks = customFileReader.read(path);
        Deck deck1 = decks.get(0);

        boolean hasAgileCard = false;

        for (int i = 0; i < deck1.size(); i++) {
            AbstractCard card = deck1.get(i);
            if (card instanceof UnitCard) {
                UnitCard unitCard = (UnitCard) card;
                if ("Barclay Els".equals(unitCard.getName()) || "Celaeno Harpía".equals(unitCard.getName())) {
                    hasAgileCard = true;
                    // Verify it has multiple sections
                    assertTrue(unitCard.getSection().size() > 1, "Agile cards should have multiple sections");
                }
            }
        }

        assertTrue(hasAgileCard, "Should find agile cards");
    }

    @Test
    @DisplayName("Should handle non-existent files correctly")
    void shouldHandleNonExistentFile() {
        String path = "non/existent/file.json";

        assertThrows(IOException.class, () -> {
            customFileReader.read(path);
        }, "Should throw IOException for non-existent files");
    }

    @Test
    @DisplayName("Should read both decks with different cards correctly")
    void shouldReadBothDecksCorrectly() throws Exception {
        String path = "src/test/resources/json/gwent.json";

        List<Deck> decks = customFileReader.read(path);
        Deck deck1 = decks.get(0);
        Deck deck2 = decks.get(1);

        assertNotEquals(deck1.size(), 0, "Deck 1 should not be empty");
        assertNotEquals(deck2.size(), 0, "Deck 2 should not be empty");

        // Verify decks are different
        boolean haveDifferentCards = false;
        for (int i = 0; i < deck1.size(); i++) {
            for (int j = 0; j < deck2.size(); j++) {
                if (!deck1.get(i).getName().equals(deck2.get(j).getName())) {
                    haveDifferentCards = true;
                    break;
                }
            }
        }
        assertTrue(haveDifferentCards, "Decks should have different cards");
    }
}