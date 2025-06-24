package edu.fiuba.algo3.modelo.card;

public class Point implements Points{
    Integer currentPoints;
    Integer basePoints;

    public Point(Integer value) {
        this.currentPoints = value;
        this.basePoints = value;
    }

    public void duplicatedPoints(){
        this.currentPoints = this.basePoints*2;
    }

    public void sumPoints() {
        this.currentPoints = this.currentPoints + 1;
    }

    public void restoredCurrentPoints() {
        this.currentPoints = this.basePoints;
    }

    public int getPoints(){
        return this.currentPoints;
    }

    public void weatherPoints(){
        this.currentPoints = 1;
    }

    public boolean comparePoints(Points points) {
        return this.currentPoints > points.getPoints();
    }

    public boolean equalPoints(Points points) {
        return this.currentPoints == points.getPoints();
    }

    public void clearPoints(){
        this.currentPoints = this.basePoints;
    }
}
