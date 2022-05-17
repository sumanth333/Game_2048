package com.appliction.game.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameUITest {

    private GameUI testGameUI;

    @BeforeEach
    void setUp() {
        testGameUI = GameUI.getInstance();
    }

    @Test
    void shouldCreateMainWidowWithGivenState() {
        String expectedTitle = "Game_2048";
        assertEquals(expectedTitle, testGameUI.getTitle());
        assertTrue(testGameUI.isVisible());
        assertTrue(testGameUI.isAlwaysOnTopSupported());
        assertEquals(800, testGameUI.getSize().height);
        assertEquals(800, testGameUI.getSize().width);
    }
}