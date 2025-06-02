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

    public void distributeCards(List<Cards> cards){
        int cardsToDistribute = Math.min(10, cards.size());
        if (cardsToDistribute < 10){
            throw new IllegalArgumentException("the number of cards needed is 10 to start the game");
        }

        for (int i = 0; i < cardsToDistribute; i++){
            addCard(cards.get(i));
        }
    }

    public int numberOfCards(){
        return deckOfCards.size();
    }

}

