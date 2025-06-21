package edu.fiuba.algo3.modelo.section;

import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.effect.SpecialEffect;

public class SiegeAffect extends Section {
    @Override
    public String getType() { return "siege"; }
    @Override
    public void addCardToSection(UnitCard card, PlayerSection playerSection) {
        playerSection.addCardToSiege(card);
    }

    @Override
    public void apply(SpecialEffect effect, PlayerSection playerSection) {
        playerSection.applyEffectMelee(effect);
    }
}
