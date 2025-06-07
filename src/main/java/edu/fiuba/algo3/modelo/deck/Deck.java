package edu.fiuba.algo3.modelo.deck;

import edu.fiuba.algo3.modelo.card.AbstractCard;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<AbstractCard> cards;
    public Deck(List<AbstractCard> cards) {

        this.cards = new ArrayList<>(cards);
    }

    public void addCard(AbstractCard card) {
        cards.add(card);
    }

    public int size() {
        return cards.size();
    }

    public List<AbstractCard> getCards() {
        return cards;
    }

    public AbstractCard get(int index) {
        return cards.get(index);
    }

    public AbstractCard randomCard(){
        int position = (int) (Math.random() * cards.size());
        return cards.get(position);
    }

    public void ensureAtLeast(int number){
        if (cards.size() < number){
            throw new IllegalArgumentException("the number of cards needed is 10 to start the game");
        }
    }
}
