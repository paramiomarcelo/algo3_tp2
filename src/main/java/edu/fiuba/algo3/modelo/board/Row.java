package edu.fiuba.algo3.modelo.board;


import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.effect.MoraleBoost;


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

    public void applyEffect(MoraleBoost moraleBoost){
        for(UnitCard card:cards){
            moraleBoost.applyEffect(card);
        }
    }



}
