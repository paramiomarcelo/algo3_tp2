package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.player.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    private Score score;

    @BeforeEach
    void setUp() {
        score = new Score();
    }

    @Test
    void testScoreInitialization() {
        
        assertEquals(0, score.getScoreTotal());
    }

    @Test
    void testSetScoreMelee() {
        
        score.setScoreMelee(10);
        
        
        assertEquals(10, score.getScoreTotal());
    }

    @Test
    void testSetScoreRanged() {
        
        score.setScoreRanged(15);
        
        
        assertEquals(15, score.getScoreTotal());
    }

    @Test
    void testSetScoreSiege() {
        
        score.setScoreSiege(20);
        
        
        assertEquals(20, score.getScoreTotal());
    }

    @Test
    void testSetScoreMeleeAndRanged() {
        
        score.setScoreMelee(10);
        score.setScoreRanged(15);
        
        
        assertEquals(25, score.getScoreTotal());
    }

    @Test
    void testSetScoreMeleeAndSiege() {
        
        score.setScoreMelee(10);
        score.setScoreSiege(20);
        
        
        assertEquals(30, score.getScoreTotal());
    }

    @Test
    void testSetScoreRangedAndSiege() {
        
        score.setScoreRanged(15);
        score.setScoreSiege(25);
        
        
        assertEquals(40, score.getScoreTotal());
    }

    @Test
    void testSetAllScores() {

        score.setScoreMelee(10);
        score.setScoreRanged(15);
        score.setScoreSiege(25);
        
        
        assertEquals(50, score.getScoreTotal());
    }

    @Test
    void testUpdateScoreMelee() {
        
        score.setScoreMelee(10);
        assertEquals(10, score.getScoreTotal());
        
        
        score.setScoreMelee(20);
        
        
        assertEquals(20, score.getScoreTotal());
    }

    @Test
    void testUpdateScoreRanged() {
        
        score.setScoreRanged(15);
        assertEquals(15, score.getScoreTotal());
        
        
        score.setScoreRanged(30);
        
        
        assertEquals(30, score.getScoreTotal());
    }

    @Test
    void testUpdateScoreSiege() {
        
        score.setScoreSiege(20);
        assertEquals(20, score.getScoreTotal());
        
        score.setScoreSiege(40);
        
        assertEquals(40, score.getScoreTotal());
    }

    @Test
    void testSetZeroScores() {
        score.setScoreMelee(0);
        score.setScoreRanged(0);
        score.setScoreSiege(0);
        
        assertEquals(0, score.getScoreTotal());
    }

    @Test
    void testSetNegativeScores() {
        score.setScoreMelee(-5);
        score.setScoreRanged(-10);
        score.setScoreSiege(-15);
        
        assertEquals(-30, score.getScoreTotal());
    }
} 