package edu.fiuba.algo3.modelo.card;

import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.section.Section;

import javax.smartcardio.Card;
import java.util.List;

public class Ranged extends UnitCard {
    public Ranged(String name, Point points, Section section, List<Ability> ability) {
        super(name, points, section, ability);
    }
    public Ranged(String name, Point points) {
        super(name, points);
    }

    @Override
    public void play(PlayerSection playerSection) {
        playerSection.addCardToRanged(this);
    }
}
