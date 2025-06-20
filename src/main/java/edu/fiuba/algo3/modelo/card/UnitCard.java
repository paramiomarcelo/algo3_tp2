package edu.fiuba.algo3.modelo.card;


import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;
import java.util.List;

public class UnitCard extends AbstractCard {
    private final Section section;
    private List<Ability> ability;
    private Point points;

    public UnitCard(String name, Point points, Section section, List<Ability> ability) {
        super(name);
        this.points = points;
        this.section = section;
        this.ability = ability;
    }
    public UnitCard(String name, Point points, Section section) {
        super(name);
        this.points = points;
        this.section = section;
        this.ability = ability;
    }
    public UnitCard(String name, Point points) {
        super(name);
        this.points = points;
        this.section = null;
    }

    public void addCard(UnitCard card,PlayerSection playerSection) {
        section.addCardToSection(card, playerSection);
    }

    public void play(PlayerSection playerSection) {}

    public void duplicatePoints() {
        points.incrementPoints();
    }
}
