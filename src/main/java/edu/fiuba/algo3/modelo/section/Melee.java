package edu.fiuba.algo3.modelo.section;

import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.effect.SpecialEffect;

import java.util.ArrayList;
import java.util.List;

public class Melee extends Section {
    @Override
    public void addCardToSection(UnitCard card, PlayerSection playerSection) {
        playerSection.addCardToMelee(card);
    }

    @Override
    public void apply(SpecialEffect effect, PlayerSection playerSection) {
        playerSection.applyEffectMelee(effect);
    }

    @Override
    public List<UnitCard> getCards(PlayerSection playerSection) {
        return playerSection.getCardsMelee();
    }

    @Override
    public void removeCard(PlayerSection playerSection, UnitCard card) {
        playerSection.removeCardMelee(card);
    }
}
