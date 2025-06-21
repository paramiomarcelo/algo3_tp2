package edu.fiuba.algo3.modelo.player;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Deck deck;
    private List<AbstractCard> hand;
    private List<UnitCard> discardPile;

    private List<UnitCard> unitsDiscarded;
    private Integer indexSelectCards;

    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
        this.hand = new ArrayList<>();
        this.discardPile = new ArrayList<>();
    }

    public void addCard(AbstractCard card){
        hand.add(card);
    }

    public void distributeCards(int number){
        this.deck.ensureAtLeast(number);

        for (int i = 0; i < number; i++){
            this.addCard(this.deck.randomCard());
        }
    }

    public void playCard(AbstractCard card) {
        removeCardFromHand(card);
        Board board = Board.getInstance();
        card.play(this, board);
    }


    public boolean hasNumberOfCards(int number){
        return number == hand.size();
    }

    public void removeCardFromHand(AbstractCard card) {
        hand.remove(card);
    }

    public void discardCard(UnitCard card) {
        if (hand.contains(card)) {
            hand.remove(card);
            this.discardPile.add(card);
        }
    }

    public void clearRound(Board board){
        List<UnitCard> cards = board.clearBoardRound(this);
        this.discardPile.addAll(cards);
    }

    public List<UnitCard> getDiscardPile() {
        return discardPile;
    }

    public int getPoints(){
        Board board = Board.getInstance();
        return board.getPoints(this);
    }

    public void selectCard(Integer index) {
        indexSelectCards = index;
    }
    public Integer indexSelectCards() {
        return indexSelectCards;
    }
}
