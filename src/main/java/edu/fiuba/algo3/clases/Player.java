package edu.fiuba.algo3.clases;
import java.util.ArrayList;import java.util.List;


public class Player{
    private String name;
    private List<Cards> deckOfCards;
    private int life;
    private int puntaje;


    public Player(String name){
        this.name = name;
        this.life = 0;
        this.deckOfCards = new ArrayList<Cards>();
    }
    public void addCard(Cards card){
        deckOfCards.add(card);
    }
    public int getCardHand() {
        return this.deckOfCards.size();
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
    public void playCard(Board board, int i) {

        if(i < 0 || i > deckOfCards.size()) {
            throw new IllegalArgumentException("the index invalid" + i);
        }
        Cards card = deckOfCards.get(i);
        card.play(board,this);
        deckOfCards.remove(i);
        this.puntaje = board.scorePlayer(this);

       /*
        if (!card.isCardSpecial()) {
            card.play(board,this);
            deckOfCards.remove(i);
            this.puntaje = board.scorePlayer(this);
        }else {
            card.play(board,this);
            deckOfCards.remove(i);
            this.puntaje = board.scorePlayer(this);
        }
        */

    }
    public int getScore() {
        return this.puntaje;
    }
}