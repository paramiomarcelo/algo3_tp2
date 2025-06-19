package edu.fiuba.algo3.modelo.section;

import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;

import java.util.ArrayList;
import java.util.List;

public class Melee extends Section {
    @Override
    public String getType() { return "melee"; }
    @Override
    public void addCardToSection(UnitCard card, PlayerSection playerSection) {
        playerSection.addCardToMelee(card);
    }
}
