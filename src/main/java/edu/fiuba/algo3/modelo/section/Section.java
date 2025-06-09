package edu.fiuba.algo3.modelo.section;

import edu.fiuba.algo3.modelo.card.UnitCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Section {

    private String sectionName;
    private ArrayList<UnitCard> cards;

    public Section(String name){
        this.sectionName = name;
        this.cards = new ArrayList<>();
    }

    public void addCard(UnitCard card){ cards.add(card); }

    public int calculatePoints(){
        int score = 0;
        for(UnitCard card: cards) {
            score += card.getPoints();
        }
        return score;
    }

    public boolean compararCosa(String seccion){
        return Objects.equals(sectionName, seccion);
    }

    public ArrayList<UnitCard> getCards() { return cards; }

    public List<UnitCard> cardsBondedAbility(UnitCard card) {
        List<UnitCard> bondedCards = new ArrayList<>();
        for (UnitCard c : cards) {
            if (c.getName().equals(card.getName())){
                bondedCards.add(c);
            }
        }
        return bondedCards;
    }
}
