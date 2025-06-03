package edu.fiuba.algo3.clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Row {
    List<Unit> cards;

    public Row() {
        cards = new ArrayList<>();
    }
    public void addCard(Unit card) {
        cards.add(card);
    }
    public List<Unit> getCards() {
        return cards;
    }
    public int getValues() {
        int counter = 0;
        for (Unit card : cards) {
            counter += card.getPoints();
        }
        return counter;
    }
}
