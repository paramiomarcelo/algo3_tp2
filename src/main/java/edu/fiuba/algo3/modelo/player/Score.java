package edu.fiuba.algo3.modelo.player;

public class Score {
    private int scoreTotal;
    private int scoreMelee;
    private int scoreRanged;
    private int scoreSiege;


    public Score() {
        scoreTotal = 0;
        scoreMelee = 0;
        scoreRanged = 0;
        scoreSiege = 0;
    }

    void setScoreTotal() {
        scoreTotal = scoreSiege + scoreMelee + scoreRanged;
    }
    public void setScoreMelee(int score) {
        scoreMelee = score;
        setScoreTotal();
    }

    public void setScoreRanged(int score) {
        scoreRanged = score;
        setScoreTotal();}

    public void setScoreSiege(int score) {
        scoreSiege = score;
        setScoreTotal();}

    public int getScoreTotal() {
        return scoreTotal;
    }
}
