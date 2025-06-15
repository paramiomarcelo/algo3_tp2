package edu.fiuba.algo3.modelo.lectorArchivo;


import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.CardFactory;
import edu.fiuba.algo3.modelo.deck.Deck;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class LectorArchivo {

    private final ParserArchivo parser = new ParserArchivo();
    private final CardFactory cardFactory = CardFactory.getInstance();

    public List<Deck> read(String path) throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(new FileReader(path));

        Deck player1Deck = readPlayerDeck(root, "mazo_jugador_uno");
        Deck player2Deck = readPlayerDeck(root, "mazo_jugador_dos");
        List<Deck>  decks = new ArrayList<>();
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

        JSONArray unidades = (JSONArray) deck.get("unidades");
        JSONArray especiales = (JSONArray) deck.get("especiales");

        List<AbstractCard> unitCards = processUnitCards(unidades);
        List<AbstractCard> specialCards = processSpecialCards(especiales);
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
            int puntos = (int) card.get("puntos");
            String seccion = (String) card.get("seccion");
            JSONArray modificadores = (JSONArray) card.get("modificador");

            cards.add(cardFactory.createCard("UnitCard",
                Map.of(
                    "name", nombre,
                    "points", puntos,
                    "section", seccion,
                    "abilityType", card.get("habilidad")
                )
            ));

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

            cards.add(cardFactory.createCard("SpecialCard",
                Map.of(
                    "name", nombre,
                    "description", descripcion,
                    "effectType", tipo,
                    "affected", afectado
                )
            ));
        }
        return cards;
    }
}
