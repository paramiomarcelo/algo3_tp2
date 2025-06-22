package edu.fiuba.algo3.modelo.card;

public class Point implements Points{
    Integer currentPoints;
    Integer basePoints;

    public Point(Integer value) {
        this.currentPoints = value;
        this.basePoints = value;
    }

    public void duplicatedPoints(){
        this.currentPoints = basePoints*2;
    }

    public void sumPoints() {
        currentPoints = currentPoints + 1;
    }

    public void restoredCurrentPoints() {
        currentPoints = basePoints;
    }

    public int getPoints(){
        return this.currentPoints;
    }

    public void modifyPoints(int points){
        this.currentPoints = points;
    }

    public boolean comparePoints(Points points) {
        return this.currentPoints > points.getPoints();
    }

    public boolean equalPoints(Points points) {
        return this.currentPoints == points.getPoints();
    }
}
