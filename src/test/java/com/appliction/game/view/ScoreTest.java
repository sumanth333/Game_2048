package com.appliction.game.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

class ScoreTest {

    @Test
    void shouldCreateScoreWithGivenDimension() {
        int testXPosition = 50;
        int testYPosition = 50;
        int testWidth = 100;
        int testHeight = 100;
        Score testScore = new Score(testXPosition, testYPosition, testWidth,testHeight);

        assertEquals(testXPosition, testScore.getX());
        assertEquals(testYPosition, testScore.getY());
        assertEquals(testWidth, testScore.getWidth());
        assertEquals(testHeight, testScore.getHeight());
    }

    @Test
    void shouldCreateScoreWithExpectedDefaults() {
        Score testScore = new Score(0, 0, 100,100);

        assertEquals("0", testScore.getText());
        assertEquals("Arial", testScore.getFont().getName());
        assertTrue(testScore.isVisible());
        assertNull(testScore.getLayout());
    }

    @Test
    void shouldUpdateScoreValue() {
        Score testScore = new Score(0, 0, 100,100);

        assertEquals(0, testScore.getScoreValue());
        testScore.updateScore(100);
        assertEquals("100", testScore.getText());
    }
}