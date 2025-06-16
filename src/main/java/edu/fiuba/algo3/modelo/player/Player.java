package edu.fiuba.algo3.modelo.player;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.visitors.CounterRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Player {
    private String name;
    private Deck deck;
    private List<AbstractCard> hand;
    private List<UnitCard> discardPile;
    private Integer points;
    StackDiscard discard;

    private List<UnitCard> unitsDiscarded;
    private Integer indexSelectCards;

    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
        this.hand = new ArrayList<>();
        this.discardPile = new ArrayList<>();
        this.points = 0;
        this.discard = new StackDiscard();
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

    public void playCard(UnitCard card){
        removeCardFromHand(card);
        Board board = Board.getInstance();
        board.addCard(this,card);
        setPoint();
    }
    public void setPoint() {
        CounterRow visitorPoint = new CounterRow();
        points = Board.getInstance().getSide(this).visitTotalPoints(visitorPoint);
    }

    public void playCard(SpecialCard card) {
        removeCardFromHand(card);
        card.getEffect().apply();
    }
    public String name(){ return this.name; }

    public boolean hasNumberOfCards(int number){
        return number == hand.size();
    }

    public void removeCardFromHand(AbstractCard card) {
        hand.remove(card);
    }

    public void addPoints(Integer points) {
        this.points += points;
    }

    public void discardCard(UnitCard card) {
        if (hand.contains(card)) {
            hand.remove(card);
            discard.getCards().add(card);
            //this.discardPile.add(card);
        }
    }

    public List<AbstractCard> getHand() {
        return hand;
    }

    public List<UnitCard> getDiscardPile() {
        return discard.getCards();
    }

    public void clearRound() {
        List<UnitCard> cards = Board.getInstance().clearBoardRound(this);
        discard.getCards().addAll(cards);
    }

    public Integer getPoints() {
        return points;
    }

//    public int totalPointsRound(Board board) {
//        return board.getScoreRow(this);
//    }

    public void selectCard(Integer index) {
        indexSelectCards = index;
    }
    public Integer indexSelectCards() {
        return indexSelectCards;
    }

}
