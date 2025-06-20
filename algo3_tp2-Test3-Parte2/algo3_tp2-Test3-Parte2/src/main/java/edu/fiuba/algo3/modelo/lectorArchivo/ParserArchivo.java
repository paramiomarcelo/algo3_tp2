package edu.fiuba.algo3.modelo.lectorArchivo;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;


public class ParserArchivo {


        public JSONObject parsearMazoJugador(String path, String jugadorKey) {
            try {
                JSONParser parser = new JSONParser();
                JSONObject raiz = (JSONObject) parser.parse(new FileReader(path));
                return (JSONObject) raiz.get(jugadorKey);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

}
