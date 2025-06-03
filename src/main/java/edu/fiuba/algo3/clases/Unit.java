package edu.fiuba.algo3.clases;

import java.util.ArrayList;
import java.util.List;

//Unidades
public class Unit extends Cards {

    private Section section;
    private int points;
    private int originalPoints;
    private Effect effect;

    public Unit(String name, int points, Section section, String description, Effect effect) {

        super(name, description, false);
        this.originalPoints = points;
        this.points = originalPoints;
        this.section = section;
        this.effect = effect;
    }
    public Unit(String name, int points, Section section, String description) {

        super(name, description, false);
        this.originalPoints = points;
        this.points = originalPoints;
        this.section = section;
        this.effect = null;
    }
    public int getPoints() {
        return this.points;
    }
    public int getOriginalPoints() {
        return  this.originalPoints;
    }
    public Section getSection() {
        return this.section;
    }
    public void setPoints(int newPoint) {
        this.points = newPoint;
    }
    @Override
    public void play(Board board, Player player) {
        board.addCard(player,this);
        if(effect != null) {
            effect.effect(board, player, this);
        }
    }
}