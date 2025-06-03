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

    public Cards getRandomCard(){
        int position = (int) (Math.random() * cards.size());
        return cards.get(position);
    }

    public int size(){
        if (cards.size() < 10){
            throw new IllegalArgumentException("the number of cards needed is 10 to start the game");
        }
        return Math.min(cards.size(), 10);
    }



}
