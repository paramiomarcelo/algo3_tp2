package edu.fiuba.algo3.modelo.board;


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

    public void applyEffect() {
        for (UnitCard card : cards) {
            card.setPoints(1);
        }
    }
    public List<UnitCard> getCardsBondedAbility(UnitCard card) {
        List<UnitCard> bondedCards = new ArrayList<>();
        for (UnitCard c : cards) {
            if (c.getName().equals(card.getName())){
                bondedCards.add(c);
            }
        }
        return bondedCards;
    }

    public void applyClearWeatherEffect() {
        for (UnitCard card : cards) {
            card.setPoints(card.getBasePoints());
        }
    }


}
