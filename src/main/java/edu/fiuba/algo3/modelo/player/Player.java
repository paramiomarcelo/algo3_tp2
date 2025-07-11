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
    private List<AbstractCard> discardPile;
    private Score score;
    private boolean pass;
    private int life;

    private List<UnitCard> unitsDiscarded;
    private Integer indexSelectCards;

    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
        this.hand = new ArrayList<>();
        this.discardPile = new ArrayList<>();
        score = new Score();
        pass = false;
        life = 2;
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
    public void addUnitCard(){
        this.addCard(this.deck.randomCard());
    }

    public void playCard(AbstractCard card) {
        removeCardFromHand(card);
        Board board = Board.getInstance();
        card.play(this, board);
    }

    public void playCard(AbstractCard card, int parameter) {
        removeCardFromHand(card);
        Board board = Board.getInstance();
        card.play(this, board, parameter);
    }

    public boolean hasNumberOfCards(int number){
        return number == hand.size();
    }

    public void removeCardFromHand(AbstractCard card) {
        hand.remove(card);
    }

    public void discardCard(AbstractCard card) {
        this.discardPile.add(card);
    }

    public void clearRound(Board board){
        List<UnitCard> cards = board.clearBoardRound(this);
        this.discardPile.addAll(cards);
    }

    public List<AbstractCard> getDiscardPile() {
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
    public Score getScore() {return score;}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<AbstractCard> getHand() {
        return hand;
    }
    public void passTurn(){
        pass = true;
    }
    public void resetTurn(){
        pass = false;
    }
    public boolean isPass() {
        return pass;
    }
    public void substractLife(){
        life = life - 1;
    }
    public int getLife() {
        return life;
    }
    
    public void reset() {
        this.hand.clear();
        this.discardPile.clear();
        this.score = new Score();
        this.pass = false;
        this.life = 2;
        this.unitsDiscarded = new ArrayList<>();
        this.indexSelectCards = null;
    }
}
