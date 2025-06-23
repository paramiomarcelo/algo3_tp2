package edu.fiuba.algo3.card;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.CardFactory;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.ability.Medic;
import edu.fiuba.algo3.modelo.section.Melee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CardFactoryTest {

    private CardFactory cardFactory;

    @BeforeEach
    void setUp() {
        cardFactory = CardFactory.getInstance();
    }

    @Test
    @DisplayName("Should create a unit card correctly")
    void shouldCreateUnitCard() {
        
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("name", "Swordsman");
        attributes.put("points", 5);
        attributes.put("section", "Cuerpo a Cuerpo");
        attributes.put("abilityType", new ArrayList<String>());

        
        AbstractCard card = cardFactory.createCard("UnitCard", attributes);

        
        assertNotNull(card);
        assertTrue(card instanceof UnitCard);
        assertEquals("Swordsman", card.getName());
        
        UnitCard unitCard = (UnitCard) card;
        assertEquals(5, unitCard.getPoints());
    }

    @Test
    @DisplayName("Should create a unit card with ability")
    void shouldCreateUnitCardWithAbility() {
        
        List<String> abilities = new ArrayList<>();
        abilities.add("Medico");
        
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("name", "Birna Bran");
        attributes.put("points", 2);
        attributes.put("section", "Cuerpo a Cuerpo");
        attributes.put("abilityType", abilities);

        
        AbstractCard card = cardFactory.createCard("UnitCard", attributes);

        
        assertNotNull(card);
        assertEquals("Birna Bran", card.getName());
        
        UnitCard unitCard = (UnitCard) card;
        assertEquals(2, unitCard.getPoints());
        assertEquals("melee", unitCard.getSection().get(0).getType());
    }

    @Test
    @DisplayName("Should create a special card correctly")
    void shouldCreateSpecialCard() {
        
        List<String> secciones = new ArrayList<>();
        secciones.add("Cuerpo a Cuerpo");
        
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("name", "Commander's Horn");
        attributes.put("description", "Doubles the strength of all cards in a specific section.");
        attributes.put("effectType", "Morale boost");
        attributes.put("section", secciones);

        
        AbstractCard card = cardFactory.createCard("SpecialCard", attributes);

        
        assertNotNull(card);
        assertEquals("Commander's Horn", card.getName());
    }

    @Test
    @DisplayName("Should create a weather card with multiple sections")
    void shouldCreateWeatherCardWithMultipleSections() {
        
        List<String> secciones = new ArrayList<>();
        secciones.add("Cuerpo a Cuerpo");
        secciones.add("Combate a Distancia");
        
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("name", "Tormenta de Skellige");
        attributes.put("description", "Establece la fuerza de todas las cartas de Combate Cuerpo a Cuerpo y Combate a Distancia en 1 para ambos jugadores.");
        attributes.put("effectType", "Clima");
        attributes.put("section", secciones);

        
        AbstractCard card = cardFactory.createCard("SpecialCard", attributes);

        
        assertNotNull(card);
        assertTrue(card instanceof SpecialCard);
        assertEquals("Tormenta de Skellige", card.getName());
    }

    @Test
    @DisplayName("Should create an agile card with multiple sections")
    void shouldCreateAgileCard() {

        List<String> abilities = new ArrayList<>();
        abilities.add("Agil");
        
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("name", "Barclay Els");
        attributes.put("points", 6);
        attributes.put("section", "Cuerpo a Cuerpo, Rango");
        attributes.put("abilityType", abilities);


        AbstractCard card = cardFactory.createCard("UnitCard", attributes);


        assertNotNull(card);
        
        UnitCard unitCard = (UnitCard) card;
        assertEquals(2, unitCard.getSection().size(), "Should have 2 sections");
        assertEquals("melee", unitCard.getSection().get(0).getType());
        assertEquals("ranged", unitCard.getSection().get(1).getType());
    }

    @Test
    @DisplayName("Should throw exception for unsupported card type")
    void shouldThrowExceptionForUnsupportedCardType() {
        
        Map<String, Object> attributes = new HashMap<>();


        assertThrows(IllegalArgumentException.class, () -> {
            cardFactory.createCard("NonExistentType", attributes);
        }, "Should throw IllegalArgumentException for unsupported types");
    }

    @Test
    @DisplayName("Should throw exception for unsupported section")
    void shouldThrowExceptionForUnsupportedSection() {
        
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("name", "Test Card");
        attributes.put("points", 5);
        attributes.put("section", "NonExistentSection");
        attributes.put("abilityType", new ArrayList<String>());


        assertThrows(IllegalArgumentException.class, () -> {
            cardFactory.createCard("UnitCard", attributes);
        }, "Should throw IllegalArgumentException for unsupported sections");
    }

    @Test
    @DisplayName("Should throw exception for unsupported ability")
    void shouldThrowExceptionForUnsupportedAbility() {
        
        List<String> abilities = new ArrayList<>();
        abilities.add("NonExistentAbility");
        
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("name", "Test Card");
        attributes.put("points", 5);
        attributes.put("section", "Cuerpo a Cuerpo");
        attributes.put("abilityType", abilities);

        
        assertThrows(IllegalArgumentException.class, () -> {
            cardFactory.createCard("UnitCard", attributes);
        }, "Should throw IllegalArgumentException for unsupported abilities");
    }

    @Test
    @DisplayName("Should use the same singleton instance in multiple calls")
    void shouldUseSameSingletonInstance() {
        
        CardFactory factory1 = CardFactory.getInstance();
        CardFactory factory2 = CardFactory.getInstance();

        
        assertSame(factory1, factory2, "Should be the same singleton instance");
    }
} 