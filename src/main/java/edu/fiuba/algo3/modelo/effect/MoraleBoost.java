package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;


public class MoraleBoost extends SpecialEffect  {

    public MoraleBoost(Section section, Player player) {
        super(section, player);
    }

    @Override
    public void apply(UnitCard card) {
        card.duplicatePoints();
    }

    @Override
    public Section getSection() {
        return this.section;
    }

}

