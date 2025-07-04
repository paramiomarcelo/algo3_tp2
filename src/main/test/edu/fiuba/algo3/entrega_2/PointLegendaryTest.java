package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.card.PointLegendary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PointLegendaryTest {

    private PointLegendary legendaryPoints;

    @BeforeEach
    void setUp() {
        legendaryPoints = new PointLegendary(10);
    }

    @Test
    void testGetPoints() {
        assertEquals(10, legendaryPoints.getPoints(), "Should return the initial points");
    }

    @Test
    void testDuplicatedPoints() {
        legendaryPoints.duplicatedPoints();
        assertEquals(10, legendaryPoints.getPoints(), "Should duplicate the points");
    }

    @Test
    void testSumPoints() {
        legendaryPoints.sumPoints();
        assertEquals(10, legendaryPoints.getPoints(), "Should sum one point");
    }

    @Test
    void testRestoredCurrentPoints() {
        legendaryPoints.sumPoints();
        legendaryPoints.duplicatedPoints();
        legendaryPoints.restoredCurrentPoints();
        assertEquals(10, legendaryPoints.getPoints(), "Should restore the original points");
    }

    @Test
    void testWeatherPointsDoesNotAffectLegendary() {
        legendaryPoints.weatherPoints();
        assertEquals(10, legendaryPoints.getPoints(), "The weather should not affect the legendary points");
    }

    @Test
    void testClearPoints() {
        legendaryPoints.sumPoints();
        legendaryPoints.clearPoints();
        assertEquals(10, legendaryPoints.getPoints(), "Should restore the original points");
    }
}