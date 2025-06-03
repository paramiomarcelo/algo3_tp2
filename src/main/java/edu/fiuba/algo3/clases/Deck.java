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

    public List<Cards> getCards(){
        return new ArrayList<>(cards);
    }
}