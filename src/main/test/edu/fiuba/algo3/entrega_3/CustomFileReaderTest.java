package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.repositorios.CustomFileReader;
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
    @DisplayName("Should handle non-existent files correctly")
    void shouldHandleNonExistentFile() {
        String path = "non/existent/file.json";

        assertThrows(IOException.class, () -> {
            customFileReader.read(path);
        }, "Should throw IOException for non-existent files");
    }


}