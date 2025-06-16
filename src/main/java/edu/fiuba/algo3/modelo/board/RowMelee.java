package edu.fiuba.algo3.modelo.board;

import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.visitors.Visitor;

import java.util.List;

public class RowMelee extends Row {

    private List<UnitCard> cards;

    public RowMelee() {super();}

    //public void add(UnitCard card) {super.addCard(card);}

    public List<UnitCard> getCards() {
        return super.getCards();
    }

    public int visit(Visitor visitor) {return super.visit(visitor);}

    //public void clear() {super.clear();}
}
