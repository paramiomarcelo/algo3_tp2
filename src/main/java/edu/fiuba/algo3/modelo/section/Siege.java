package edu.fiuba.algo3.modelo.section;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;

import java.util.ArrayList;

public class Siege implements Section{

    private ArrayList<UnitCard> cards = new ArrayList<>();

    public void addCard(UnitCard card){
        cards.add(card);
    }

    public int calculatePoints(){
        int score = 0;
        for(UnitCard card: cards) {
            score += card.getPoints();
        }
        return score;
    }
}
