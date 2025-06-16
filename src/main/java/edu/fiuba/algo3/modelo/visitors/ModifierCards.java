package edu.fiuba.algo3.modelo.visitors;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.Row;
import edu.fiuba.algo3.modelo.board.Section;
import edu.fiuba.algo3.modelo.card.UnitCard;

import java.util.ArrayList;
import java.util.List;

public class ModifierCards implements ModifiersSection {

    @Override
    public void applyWeatherEffect(Row row) {
        for (UnitCard card : row.getCards()) {
            card.setPoints(1);
        }
    }

    @Override
    public void applyClearWeatherEffect(Row row) {
        for (UnitCard card : row.getCards()) {
            card.setPoints(card.getBasePoints());
        }
    }

    @Override
    public void boostMorale(Row row) {
        for (UnitCard card : row.getCards()) {
            card.setPoints(card.getPoints() * 2);
        }
    }

    @Override
    public UnitCard scorchedEarth(Section section) {
        List<UnitCard> s = new ArrayList<>();
        s.addAll(section.getRowMelee().getCards());
        s.addAll(section.getRanged().getCards());
        s.addAll(section.getRowSiege().getCards());

        UnitCard a = s.get(0);

        for (UnitCard card : s) {
            if(card.getPoints() > a.getPoints()){
                a = card;
            }
        }
        return a;

    }

}
