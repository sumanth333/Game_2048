package com.appliction.game.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayAreaTest {

    private PlayArea testPlayArea;

    @BeforeEach
    void setUp() {
        testPlayArea = PlayArea.getInstance();
    }

    @Test
    void shouldCreateExpectedNumberOfTileObjects() {
        assertEquals(16, testPlayArea.getComponents().length);
    }

    @Test
    void shouldCreateExpectedTileObject() {
        Tile testTile = testPlayArea.getTileObjects()[0][0];

        testTile.updateValue(2);

        assertEquals(TileColor.getTileColor(2), testTile.getBackground());
        assertEquals(2, testTile.getValue());
    }
}