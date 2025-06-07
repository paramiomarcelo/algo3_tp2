package edu.fiuba.algo3.modelo.player;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Deck deck;
    private List<AbstractCard> hand;
    private List<AbstractCard> discardPile;
    private Integer points;

    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
        this.hand = new ArrayList<>();
        this.discardPile = new ArrayList<>();
        this.points = 0;
    }

    public void addCard(AbstractCard card){
        hand.add(card);
    }

    public void distributeCards(Deck deck, int number){
        deck.ensureAtLeast(number);

        int cardsToDistribute = number;

        for (int i = 0; i < cardsToDistribute; i++){
            this.addCard(deck.randomCard());
        }
    }

    public void playCard(UnitCard card, String section){
        removeCardFromHand(card);
        Board board = Board.getInstance();
        board.addCard(this,card,section);
        points = board.getScoreRow(this);
    }

    public int numberOfCards(){
        return hand.size();
    }

    public void removeCardFromHand(AbstractCard card) {
        hand.remove(card);
    }

    public void addPoints(Integer points) {
        this.points += points;
    }

    public void discardCard(AbstractCard card) {
        if (hand.contains(card)) {
            hand.remove(card);
            discardPile.add(card);
        }
    }

    public List<AbstractCard> getHand() {
        return hand;
    }

    public List<AbstractCard> getDiscardPile() {
        return discardPile;
    }

    public Integer getPoints() {
        return points;
    }

    public int totalPointsRound(Board board) {
        return board.getScoreRow(this);
    }
}
