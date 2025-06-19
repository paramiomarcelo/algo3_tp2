package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

public abstract class SpecialEffect {

    protected final Section section;
    protected final Player player;

    public SpecialEffect(Section section, Player player) {
        this.section = section;
        this.player = player;
    }

    public Section getSection(){
        return section;
    }

    public void apply(UnitCard card) {

    }
}