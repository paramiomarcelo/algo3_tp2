package edu.fiuba.algo3.modelo.card;

public class Point {
    Integer currentPoints;
    Integer basePoints;

    public Point(Integer value) {
        this.currentPoints = value;
        this.basePoints = value;
    }

    public void duplicatedPoints(){
        this.currentPoints = currentPoints*2;
    }

    public int getPoints(){
        return this.currentPoints;
    }

    public void modifyPoints(int points){
        this.currentPoints = points;
    }
}
