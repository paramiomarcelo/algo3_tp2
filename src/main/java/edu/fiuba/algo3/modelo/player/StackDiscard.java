package edu.fiuba.algo3.modelo.player;

import edu.fiuba.algo3.modelo.card.UnitCard;

import java.util.ArrayList;
import java.util.List;

public class StackDiscard {
    private List<UnitCard> cards;

    public StackDiscard() {
        cards = new ArrayList<UnitCard>();
    }
    public void addDiscard(List<UnitCard> c) {
        cards.addAll(c);
    }
    public List<UnitCard> getCards() {
        return cards;
    }
}
