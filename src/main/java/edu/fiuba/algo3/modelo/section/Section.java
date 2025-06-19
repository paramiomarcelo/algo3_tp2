package edu.fiuba.algo3.modelo.section;

import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.effect.SpecialEffect;

public abstract class Section {
    public abstract String getType();
    public abstract void addCardToSection(UnitCard card, PlayerSection playerSection);
    public abstract void apply(SpecialEffect effect,  PlayerSection playerSection);
}
