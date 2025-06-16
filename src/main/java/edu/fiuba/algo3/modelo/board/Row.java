package edu.fiuba.algo3.modelo.board;


import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.visitors.Visitor;


import java.util.ArrayList;

import java.util.List;

public class Row {
    private List<UnitCard> cards;


    public Row() {
        this.cards = new ArrayList<>();
    }

    public void applyEffect() {
        for (UnitCard card : cards) {
            card.setPoints(1);
        }
    }

    public List<UnitCard> getCards() {return cards;}

    public int visit(Visitor visitor) {return visitor.visit(this);}

}
