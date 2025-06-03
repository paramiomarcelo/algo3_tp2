package edu.fiuba.algo3.clases;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Board {
    Map<Player, Map<Section, Row>> playerRounds = new HashMap<>();

    public Board(Player player1, Player player2) {
        Map<Section,Row> rows = new HashMap<>();

        for(Section section : Section.values()) {
            rows.put(section, new Row());
        }
        playerRounds.put(player1, rows);
        //exception
        playerRounds.put(player2, rows);
    }
    public void addCard(Player player, Unit card) {
        playerRounds.get(player).get(card.getSection()).addCard(card);
    }
    public int scorePlayer(Player player) {
        int counter = 0;
        for (Map.Entry<Section, Row> entry : playerRounds.get(player).entrySet()) {
            for (Unit card : entry.getValue().getCards()) {
                counter += card.getPoints();
            }
        }
        return counter;
    }
}
