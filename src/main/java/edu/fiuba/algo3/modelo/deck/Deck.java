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
}
