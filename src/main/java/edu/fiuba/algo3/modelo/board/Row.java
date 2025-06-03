package edu.fiuba.algo3.modelo.board;


import edu.fiuba.algo3.modelo.card.Card;
import edu.fiuba.algo3.modelo.card.ScorableCard;
import edu.fiuba.algo3.modelo.card.UnitCard;


import java.util.ArrayList;

import java.util.List;

public class Row {
    private List<UnitCard> cards;


    public Row() {
        this.cards = new ArrayList<>();
    }

    public void addCard(UnitCard card) {
        cards.add(card);
    }

    public int calculatePoints() {
        int totalPoints = 0;
        for (UnitCard card : cards) {
            totalPoints += card.getPoints();
        }
        return totalPoints;
    }

    public void applySnowEffect() {
        for (UnitCard card : cards) {
            card.setPoints(1);
        }
    }


}
