package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.section.Section;

public abstract class GlobalEffect extends SpecialEffect  {

    public GlobalEffect(Section section) {
        super(section);
    }

    @Override
    public void apply(UnitCard card) {
        card.duplicatePoints();
    }

}
