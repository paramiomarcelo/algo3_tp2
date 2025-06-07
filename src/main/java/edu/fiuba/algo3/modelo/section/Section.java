package edu.fiuba.algo3.modelo.section;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;

public interface Section {
    void addCard(UnitCard card);

    int calculatePoints();
}
