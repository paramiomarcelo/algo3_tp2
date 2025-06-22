package edu.fiuba.algo3.modelo.card;

public interface Points {
    int getPoints();
    void modifyPoints(int points);
    void duplicatedPoints();
    boolean comparePoints(Points points);
    boolean equalPoints(Points points);
    void sumPoints();
    void restoredCurrentPoints();
}
