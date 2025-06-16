package edu.fiuba.algo3.modelo.player;

import edu.fiuba.algo3.modelo.card.AbstractCard;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<AbstractCard> cards;

    public Hand() {
        cards = new ArrayList<AbstractCard>();
    }
    public void addCard(AbstractCard card) {
        cards.add(card);
    }
    public List<AbstractCard> getCards() {
        return cards;
    }
}
