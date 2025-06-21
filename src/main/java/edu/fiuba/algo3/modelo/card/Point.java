package edu.fiuba.algo3.modelo.card;

public class Point {
    Integer currentPoints;
    Integer basePoints;

    public Point(Integer value) {
        this.currentPoints = value;
        this.basePoints = value;
    }

    public void incrementPoints(){
        this.currentPoints = basePoints*2;
    }

    public void incrementoUno(){
        this.currentPoints = currentPoints+1;
    }
    public int getPoints(){
        return this.currentPoints;
    }
}
