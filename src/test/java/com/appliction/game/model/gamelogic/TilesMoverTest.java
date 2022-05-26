package com.appliction.game.model.gamelogic;

import com.appliction.game.view.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TilesMoverTest {

    private TilesMover tilesMover;
    private Tile[][] testTiles;

    @BeforeEach
    void setUp() {
        tilesMover = new TilesMover();
        testTiles = tilesMover.tiles;
        Arrays.stream(testTiles).forEach(tiles -> {
            Arrays.stream(tiles).forEach(tile -> {tile.updateValue(0);});
        });
    }

    @Test
    void shouldPerformMoveUpOperationAndGenerateValidOutput() {
        testTiles[0][1].updateValue(4);
        testTiles[1][1].updateValue(4);

        assertEquals(4, testTiles[0][1].getValue());
        tilesMover.moveTiles(KeyEvent.VK_UP);
        assertEquals(8, testTiles[0][1].getValue());
    }

    @Test
    void shouldPerformMoveDownOperationAndGenerateValidOutput() {
        testTiles[0][0].updateValue(2);
        testTiles[1][0].updateValue(2);

        assertEquals(0, testTiles[3][0].getValue());
        tilesMover.moveTiles(KeyEvent.VK_DOWN);
        assertEquals(4, testTiles[3][0].getValue());
    }

    @Test
    void shouldPerformMoveLeftOperationAndGenerateValidOutput() {
        testTiles[0][3].updateValue(8);
        testTiles[0][2].updateValue(8);

        assertEquals(0, testTiles[0][0].getValue());
        tilesMover.moveTiles(KeyEvent.VK_LEFT);
        assertEquals(16, testTiles[0][0].getValue());
    }
}