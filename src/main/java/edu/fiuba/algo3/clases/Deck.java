package edu.fiuba.algo3.clases;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Cards> cards;

    public Deck() {
        cards = new ArrayList<Cards>();
    }

    public void addCard(Cards card){
        cards.add(card);
    }

    public Cards randomCard(){
        int position = (int) (Math.random() * cards.size());
        return cards.get(position);
    }

    public void ensureAtLeast(int number){
        if (cards.size() < number){
            throw new IllegalArgumentException("the number of cards needed is 10 to start the game");
        }
    }



}
    public List<Cards> getCards(){
        return new ArrayList<>(cards);
    }
}
