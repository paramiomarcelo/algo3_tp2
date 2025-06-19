package edu.fiuba.algo3.modelo.board;

import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.effect.MoraleBoost;

public class PlayerSection {
    private final Row melee = new Row();
    private final Row ranged = new Row();
    private final Row siege = new Row();

    public void addCard(UnitCard card) {
        card.addCard(card, this);
    }

    public void addCardToMelee(UnitCard card) {
        melee.add(card);
    }

    public void addCardToRanged(UnitCard card) {
        ranged.add(card);
    }

    public void addCardToSiege(UnitCard card) {
        siege.add(card);
    }

    public void applyEffect(MoraleBoost moraleBoost) {
        melee.applyEffect(moraleBoost);
    }
    
}