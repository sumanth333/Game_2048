package com.appliction.game.view;

import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TileTest {

    @Test
    void validateDefaultStateOfGivenTile() {
        Tile testTile = new Tile();
        Color testColor = TileColor.getTileColor(1);

        assertEquals(testColor, testTile.getBackground());
        assertTrue(testTile.getText().isEmpty());
    }

    @Test
    void shouldReturnZeroWhenTileValueIsNotSet() {
        Tile testTile = new Tile();
        assertEquals(0, testTile.getValue());
    }

    @Test
    void shouldUpdateValueOfGivenTile() {
        Tile testTile = new Tile();
        testTile.updateValue(2);

        assertEquals(TileColor.getTileColor(2), testTile.getBackground());
        assertEquals(2, testTile.getValue());

        testTile.updateValue(0);

        assertEquals(TileColor.getTileColor(1), testTile.getBackground());
        assertEquals(0, testTile.getValue());
    }
}