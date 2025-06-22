package edu.fiuba.algo3.modelo.card;


import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

import java.util.List;
import java.util.Scanner;

public class UnitCard extends AbstractCard {
    private final List<Section> section;
    private Ability ability;
    private Points points;

    public UnitCard(String name, String description, Point points, List<Section> section, Ability ability) {
        super(name, description);
        this.points = points;
        this.section = section;
        this.ability = ability;
    }

    public UnitCard(String name, String description, Point points, List<Section> section) {
        super(name, description);
        this.points = points;
        this.section = section;
        this.ability = new NullObjectAbility();
    }

    public void addCard(UnitCard card,PlayerSection playerSection) {
        Section section = this.section.get(0);
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
        return this.section.get(0);
    }

    public void duplicatePoints() {
        points.duplicatedPoints();
    }

    public List<Section> getSection() {
        return this.section;
    }

    public void chooseSection(int index) {
        Section aux = this.section.remove(index);
        this.section.add(0, aux);
    }

    public void modifyPoints(int points) {
        this.points.modifyPoints(points);
    }
    public void setPoints(Points points) {
        this.points = points;
    }
}
