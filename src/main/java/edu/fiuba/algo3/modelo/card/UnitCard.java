package edu.fiuba.algo3.modelo.card;


import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

import java.util.List;

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
        Player targetPlayer = ability.effect(player, this, board, 0);
        board.addCard(targetPlayer, this);
    }

    @Override
    public void play(Player player, Board board, int parameter) {
        Player targetPlayer = ability.effect(player, this, board, parameter);
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

    public void sumOne(){ points.sumPoints();}

    public List<Section> getSection() {
        return this.section;
    }
    public boolean comparedName(UnitCard card) { return card.getName().equals(name);}

    public void chooseSection(int index) {
        Section aux = this.section.remove(index);
        this.section.add(0, aux);
    }

    public void weatherPoints() {
        this.points.weatherPoints();
    }

    public void setPoints(Points points) {
        this.points = points;
    }

    public boolean compareCardPoints(UnitCard card) {
        return this.points.comparePoints(card.points);
    }

    public boolean equalPoints(UnitCard card) {
        return this.points.equalPoints(card.points);
    }
    public void restore(){ this.points.restoredCurrentPoints();}

    public void clearPoints(){ this.points.clearPoints();}

    public Ability getAbility() {
        return this.ability;
    }
}
