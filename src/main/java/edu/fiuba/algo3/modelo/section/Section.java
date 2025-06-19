package edu.fiuba.algo3.modelo.section;

import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.card.UnitCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Section {
    public abstract String getType();
    public abstract void addCardToSection(UnitCard card, PlayerSection playerSection);
}
