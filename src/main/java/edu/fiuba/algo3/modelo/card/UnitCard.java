package edu.fiuba.algo3.modelo.card;


import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

import java.util.ArrayList;
import java.util.List;

public class UnitCard extends AbstractCard {
    private final Section section;
    private List<Ability> ability;
    private Point points;

    public UnitCard(String name, String description, Point points, Section section, List<Ability> ability) {
        super(name, description);
        this.points = points;
        this.section = section;
        this.ability = ability;
    }

    public UnitCard(String name, String description, Point points, Section section) {
        super(name, description);
        this.points = points;
        this.section = section;
        this.ability = new ArrayList<>();
    }

    public void addCard(UnitCard card,PlayerSection playerSection) {
        section.addCardToSection(card, playerSection);
    }


    @Override
    public void play(Player player, Board board) {
        board.addCard(player, this);
    }

    public Player apply(Player player){
        if (this.ability != null){

        }
        return player;
    }

    public int getPoints(){
        return points.getPoints();
    }

    public void duplicatePoints() {
        points.incrementPoints();
    }

    public Section getSection() {
        return section;
    }
}
