package edu.fiuba.algo3.modelo.section;

import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.effect.SpecialEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;   

public class Ranged extends Section {
    @Override
    public String getType() { return "ranged"; }
    @Override
    public void addCardToSection(UnitCard card, PlayerSection playerSection) {
        playerSection.addCardToRanged(card);
    }

    @Override
    public void apply(SpecialEffect effect, PlayerSection playerSection) {
        playerSection.applyEffectRanged(effect);
    }

    @Override
    public List<UnitCard> getCards(PlayerSection playerSection) {
        return playerSection.getCardsRanged();
    }

    @Override
    public void removeCard(PlayerSection playerSection, UnitCard card) {
        playerSection.removeCardRanged(card);
    }
}
