package edu.fiuba.algo3.modelo.section;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ranged extends Section {

    public Ranged(){ super("Ranged"); }

    public void addCard(UnitCard card){ super.addCard(card); }

    public int calculatePoints(){ return super.calculatePoints(); }

    public boolean compararCosa(String seccion){ return super.compararCosa(seccion); }

    public ArrayList<UnitCard> getCards() { return super.getCards(); }

    public List<UnitCard> cardsBondedAbility(UnitCard card) { return super.cardsBondedAbility(card); }

}
