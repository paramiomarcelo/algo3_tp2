package edu.fiuba.algo3.modelo.card;

public class PointLegendary implements Points{
    Integer basePoints;

    public PointLegendary(Integer value) {
        this.basePoints = value;
    }
    public void duplicatedPoints(){}

    public int getPoints(){
        return this.basePoints;
    }

    public void modifyPoints(int points){}
}
