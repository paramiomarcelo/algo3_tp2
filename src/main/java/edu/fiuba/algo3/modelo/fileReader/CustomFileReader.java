package edu.fiuba.algo3.modelo.fileReader;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.CardFactory;
import edu.fiuba.algo3.modelo.deck.Deck;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomFileReader {

    private final FileParser parser = new FileParser();
    private final CardFactory cardFactory = CardFactory.getInstance();

    public List<Deck> read(String path) throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(new java.io.FileReader(path));

        Deck player1Deck = readPlayerDeck(root, "mazo_jugador_uno");
        Deck player2Deck = readPlayerDeck(root, "mazo_jugador_dos");
        List<Deck> decks = new ArrayList<>();
        decks.add(player1Deck);
        decks.add(player2Deck);
        return decks;
    }

    private Deck readPlayerDeck(JSONObject root, String playerKey) {
        JSONObject deck = (JSONObject) root.get(playerKey);
        if (deck == null) {
            System.out.println("No se encontró el mazo para: " + playerKey);
            return null;
        }

        JSONArray units = (JSONArray) deck.get("unidades");
        JSONArray specials = (JSONArray) deck.get("especiales");

        List<AbstractCard> unitCards = processUnitCards(units);
        List<AbstractCard> specialCards = processSpecialCards(specials);
        List<AbstractCard> playerDeck = new ArrayList<>();
        playerDeck.addAll(unitCards);
        playerDeck.addAll(specialCards);
        return new Deck(playerDeck);
    }

    private List<AbstractCard> processUnitCards(JSONArray unitCards) {
        List<AbstractCard> cards = new ArrayList<>();
        for (Object obj : unitCards) {
            JSONObject card = (JSONObject) obj;
            String nombre = (String) card.get("nombre");
            Long puntos = (Long) card.get("puntos");
            String seccion = (String) card.get("seccion");
            JSONArray modificadores = (JSONArray) card.get("modificador");
            
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("name", nombre);
            attributes.put("points", puntos.intValue());
            attributes.put("section", seccion);
            attributes.put("abilityType", modificadores != null ? modificadores : new ArrayList<>());
            
            cards.add(cardFactory.createCard("UnitCard", attributes));
        }
        return cards;
    }

    private List<AbstractCard> processSpecialCards(JSONArray specialCards) {
        List<AbstractCard> cards = new ArrayList<>();
        for (Object obj : specialCards) {
            JSONObject card = (JSONObject) obj;
            String nombre = (String) card.get("nombre");
            String descripcion = (String) card.get("descripcion");
            String tipo = (String) card.get("tipo");
            JSONArray afectado = (JSONArray) card.get("afectado");

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("name", nombre);
            attributes.put("description", descripcion);
            attributes.put("effectType", tipo);
            
            // Para efectos de clima, usar la primera sección afectada como sección por defecto
            if (afectado != null && !afectado.isEmpty()) {
                attributes.put("section", afectado.get(0));
            } else {
                attributes.put("section", "Cuerpo a Cuerpo"); // Por defecto
            }

            cards.add(cardFactory.createCard("SpecialCard", attributes));
        }
        return cards;
    }
}
