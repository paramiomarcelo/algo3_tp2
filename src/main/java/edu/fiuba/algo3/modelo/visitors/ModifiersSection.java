package edu.fiuba.algo3.modelo.visitors;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.Row;
import edu.fiuba.algo3.modelo.board.Section;
import edu.fiuba.algo3.modelo.card.UnitCard;

public interface ModifiersSection {
    void applyWeatherEffect(Row row);
    void applyClearWeatherEffect(Row row);
    void boostMorale(Row row);
    UnitCard scorchedEarth(Section section);
}