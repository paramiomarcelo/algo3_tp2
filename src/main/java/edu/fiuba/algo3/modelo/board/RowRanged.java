package edu.fiuba.algo3.modelo.board;

import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.visitors.Visitor;

import java.util.List;

public class RowRanged extends Row{

    private List<UnitCard> cards;

    public RowRanged()  {super();}

    //public void addCard(UnitCard card) {super.addCard(card);}

    public List<UnitCard> getCards() {return super.getCards();}

    //public void clear() {super.clear();}

    public int visit(Visitor visitor) {return super.visit(visitor);}
}
