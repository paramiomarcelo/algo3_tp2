package edu.fiuba.algo3.clases;
import edu.fiuba.algo3.clases.Cards;

import java.util.ArrayList;
import java.util.List;

public class Player{

    private String name;
    private List<Cards> deckOfCards;
    private int life;

    public Player(String name){
        this.name = name;
        this.life = 0;
        this.deckOfCards = new ArrayList<Cards>();
    }

    public void addCard(Cards card){
        deckOfCards.add(card);
    }

    public void distributeCards(Deck deck, int number){
        deck.ensureAtLeast(number);

        int cardsToDistribute = number;

        for (int i = 0; i < cardsToDistribute; i++){
            this.addCard(deck.randomCard());
        }
    }

    public int numberOfCards(){
        return deckOfCards.size();
    }

}

