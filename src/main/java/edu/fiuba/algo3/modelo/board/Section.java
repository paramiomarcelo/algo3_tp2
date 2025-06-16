package edu.fiuba.algo3.modelo.board;

import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.visitors.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Section {
    private String name;
    private RowMelee melee;
    private RowSiege siege;
    private RowRanged ranged;

    public Section(String name) {
        this.name = name;
        melee = new RowMelee();
        ranged = new RowRanged();
        siege = new RowSiege();
    }
    public String getName() { return name; }
    public RowMelee getRowMelee() {
        return melee;
    }
    public RowSiege getRowSiege() {
        return siege;
    }
    public RowRanged getRanged() {
        return ranged;
    }

    public List<UnitCard> discardRound(){
        List<UnitCard> discarded = new ArrayList<UnitCard>();
        discarded.addAll(getRowMelee().getCards());
        discarded.addAll(getRowSiege().getCards());
        discarded.addAll(getRanged().getCards());

        melee.getCards().clear();
        siege.getCards().clear();
        ranged.getCards().clear();

        return discarded;
    }

    public int visitTotalPoints(Visitor v) {
        return v.visit(this);
    }
    public Row getRow(String section) {
        switch (section) {
            case "melee":
                return melee;
                case "siege":
                    return siege;
                    case "ranged":
                        return ranged;
                        default:
                            throw new NoSuchElementException();
        }
    }
}
