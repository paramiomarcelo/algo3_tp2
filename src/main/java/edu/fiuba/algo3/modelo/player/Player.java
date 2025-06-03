package edu.fiuba.algo3.modelo.player;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.Card;
import edu.fiuba.algo3.modelo.deck.Deck;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Deck deck;
    private List<Card> hand;
    private List<Card> discardPile;
    private Integer points;

    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
        this.hand = new ArrayList<>();
        this.discardPile = new ArrayList<>();
        this.points = 0;
    }

    public void removeCardFromHand(Card card) {
        hand.remove(card);
    }

    public void addPoints(Integer points) {
        this.points += points;
    }

    public void addToDiscardPile(Card card) {
        discardPile.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public List<Card> getDiscardPile() {
        return discardPile;
    }

    public Integer getPoints() {
        return points;
    }

}
