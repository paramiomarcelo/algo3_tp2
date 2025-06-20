package edu.fiuba.algo3.modelo.card;

import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

import java.util.List;

public class Melee extends UnitCard{
    public Melee(String name, Point points, Section section, List<Ability> ability) {
        super(name, points, section, ability);
    }
    public Melee(String name, Point points) {
        super(name, points);
    }

    @Override
    public void play(PlayerSection playerSection) {
        playerSection.addCardToMelee(this);
    }
}
