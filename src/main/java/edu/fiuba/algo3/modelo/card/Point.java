package edu.fiuba.algo3.modelo.card;

public class Point {
    Integer currentPoints;
    Integer basePoints;

    public Point(Integer value) {
        this.currentPoints = value;
        this.basePoints = value;
    }

    public void incrementPoints(){
        this.currentPoints = currentPoints*2;
    }

    public int getPoints(){
        return this.currentPoints;
    }
}
