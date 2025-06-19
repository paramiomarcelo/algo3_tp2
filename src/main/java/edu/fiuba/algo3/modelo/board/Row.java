package edu.fiuba.algo3.modelo.board;


import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.effect.MoraleBoost;
import edu.fiuba.algo3.modelo.effect.SpecialEffect;


import java.util.ArrayList;

import java.util.List;

public class Row  {

    private final List<UnitCard> cards;

    public Row() {
        this.cards = new ArrayList<>();
    }

    public void add(UnitCard card) {
        this.cards.add(card);
    }

    public void applyEffect(SpecialEffect effect) {
        for(UnitCard card:cards){
            effect.apply(card);
        }
    }

    public int getPoints(){
        if (cards.isEmpty()){
            return 0;
        }

        int points = 0;
        for (UnitCard card: cards){
            points += card.getPoints();
        }
        return points;
    }

    public List<UnitCard> clearBoardRound(){
        List<UnitCard> cardsAux = new ArrayList<>();
        for (UnitCard card: cards){
            cardsAux.add(card);
            cards.remove(card);
        }
        return cardsAux;
    }

}
