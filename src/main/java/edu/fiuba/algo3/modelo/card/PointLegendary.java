package edu.fiuba.algo3.modelo.card;

public class PointLegendary implements Points{
    Integer basePoints;

    public PointLegendary(Integer value) {
        this.basePoints = value;
    }

    public void duplicatedPoints(){}

    public void sumPoints() {}

    public void restoredCurrentPoints() {}

    public int getPoints(){
        return this.basePoints;
    }

    public void modifyPoints(int points){}
    public boolean comparePoints(Points points) {
        return this.basePoints > points.getPoints();
    }
    public boolean equalPoints(Points points) {
        return this.basePoints == points.getPoints();
    }
}
