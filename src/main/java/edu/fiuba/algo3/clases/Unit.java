package edu.fiuba.algo3.clases;

import java.util.ArrayList;
import java.util.List;

//Unidades
public class Unit extends Cards {

    private Section section;
    private int points;
    private List<Ability> abilities;

    public Unit(String name, int points, Section section, String description) {

        super(name, description);
        this.points = points;
        this.section = section;
        this.abilities = new ArrayList<>();
    }
    public int getPoints() {
        return this.points;
    }
    public Section getSection() {
        return this.section;
    }

    void play(Board board, Player player, Unit card) {
        board.addCard(player,card);
    }
}
