package edu.fiuba.algo3.modelo.deck;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards;
    public Deck(List<Card> cards) {

        this.cards = new ArrayList<>(cards);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int size() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card get(int index) {
        return cards.get(index);
    }
}
