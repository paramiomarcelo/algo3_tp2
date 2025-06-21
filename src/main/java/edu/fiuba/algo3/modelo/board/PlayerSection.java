package edu.fiuba.algo3.modelo.board;

import edu.fiuba.algo3.modelo.ability.Ability;
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

    public void modifierScore(Player player) {
        player.getScore().setScoreMelee(melee.getPoints());
        player.getScore().setScoreRanged(ranged.getPoints());
        player.getScore().setScoreSiege(siege.getPoints());
    }

    public List<UnitCard> clearBoardRound(){
        List<UnitCard> cards = new ArrayList<>();
        for(Row r : rows()){
            cards.addAll(r.clearBoardRound());
        }
        return cards;
    }
    public void searchPairs(UnitCard card) {
        List<UnitCard> cards = new ArrayList<>();
        cards.add(card);
        for(Row r : rows()){
            cards.addAll(r.compareCards(card));
        }

        if(cards.size() >= 2 ) {
            for (UnitCard c : cards) {
                c.duplicatePoints();
            }
        }
    }
    public void sumBase(UnitCard card) {
        List<Row> row = rows();
        boolean found = false;
        for (Row r : row) {
            if (r.serchRow(card)){
                for (UnitCard c : r.getCards()){
                    c.setPoints().incrementoUno();
                }
            }
        }
    }
    public List<Row> rows(){
        List<Row> rows = new ArrayList<>();
        rows.add(melee);
        rows.add(ranged);
        rows.add(siege);
        return rows;
    }


}