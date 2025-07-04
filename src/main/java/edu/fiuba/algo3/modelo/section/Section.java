package edu.fiuba.algo3.modelo.section;

import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.effect.SpecialEffect;

import java.util.List;

public abstract class Section {
    public abstract void addCardToSection(UnitCard card, PlayerSection playerSection);
    public abstract void apply(SpecialEffect effect,  PlayerSection playerSection);
    public abstract List<UnitCard> getCards(PlayerSection playerSection);
    public abstract void removeCard(PlayerSection playerSection, UnitCard card);
}
