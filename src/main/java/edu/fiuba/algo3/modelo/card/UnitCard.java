package edu.fiuba.algo3.modelo.card;


import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

public class UnitCard extends AbstractCard {
    private final Section section;
    private Ability ability;
    private Point points;

    public UnitCard(String name, String description, Point points, Section section, Ability ability) {
        super(name, description);
        this.points = points;
        this.section = section;
        this.ability = ability;
    }

    public UnitCard(String name, String description, Point points, Section section) {
        super(name, description);
        this.points = points;
        this.section = section;
        this.ability = new NullObjectAbility();
    }

    public void addCard(UnitCard card,PlayerSection playerSection) {
        section.addCardToSection(card, playerSection);
    }


    @Override
    public void play(Player player, Board board) {
        Player targetPlayer = ability.effect(player, this, board);;

        board.addCard(targetPlayer, this);
    }

    public int getPoints(){
        return points.getPoints();
    }

    public Section getRow(){
        return section;
    }

    public void duplicatePoints() {
        points.duplicatedPoints();
    }

    public Section getSection() {
        return section;
    }

    public void modifyPoints(int points) {
        this.points.modifyPoints(points);
    }
}
