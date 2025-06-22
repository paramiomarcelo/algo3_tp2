package edu.fiuba.algo3.modelo.board;

import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.effect.SpecialEffect;
import edu.fiuba.algo3.modelo.player.Player;
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

    public void applyEffectRanged(SpecialEffect effect) {
        ranged.applyEffect(effect);
    }

    public void applyEffectSiege(SpecialEffect effect) {
        siege.applyEffect(effect);
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

    public List<UnitCard> getCards(Section section){
        return section.getCards(this);
    }

    public List<UnitCard> getCardsMelee(){
        return melee.getCards();
    }

    public List<UnitCard> getCardsRanged(){
        return ranged.getCards();
    }

    public List<UnitCard> getCardsSiege(){
        return siege.getCards();
    }

    public void removeCard(UnitCard card){
        Section section = card.getRow();
        section.removeCard(this, card);
    }

    public void removeCardMelee(UnitCard card){
        melee.removeCard(card);
    }

    public void removeCardRanged(UnitCard card){
        ranged.removeCard(card);
    }

    public void removeCardSiege(UnitCard card){
        siege.removeCard(card);
    }

    public void modifierScore(Player player) {
        player.getScore().setScoreMelee(melee.getPoints());
        player.getScore().setScoreRanged(ranged.getPoints());
        player.getScore().setScoreSiege(siege.getPoints());
    }
}