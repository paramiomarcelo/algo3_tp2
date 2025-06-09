package edu.fiuba.algo3.modelo.section;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;

import java.util.ArrayList;
import java.util.List;

public class Melee extends Section {

    public Melee(){ super("Melee"); }

    public void addCard(UnitCard card){ super.addCard(card); }

    public int calculatePoints(){ return super.calculatePoints(); }

    public boolean compararCosa(String seccion){ return super.compararCosa(seccion); }

    public ArrayList<UnitCard> getCards() { return super.getCards(); }

    public List<UnitCard> cardsBondedAbility(UnitCard card) { return super.cardsBondedAbility(card); }


}
