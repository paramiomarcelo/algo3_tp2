package edu.fiuba.algo3.modelo.board;

import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.effect.SpecialEffect;
import edu.fiuba.algo3.modelo.section.Section;

import java.util.ArrayList;
import java.util.List;

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

    public void applyEffect(SpecialEffect effect) {
        Section section = effect.getSection();
        section.apply(effect, this);
    }

    public void applyEffectMelee(SpecialEffect effect) {
        melee.applyEffect(effect);
    }

    public int getPoints(){
        return (melee.getPoints() + ranged.getPoints() + siege.getPoints());
    }

    public List<UnitCard> clearBoardRound(){
        List<UnitCard> cards = new ArrayList<>();
        cards.addAll(melee.clearBoardRound());
        cards.addAll(ranged.clearBoardRound());
        cards.addAll(siege.clearBoardRound());
        return cards;
    }

}