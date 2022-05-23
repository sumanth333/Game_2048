package com.appliction.game.model.gamelogic;

import com.appliction.game.view.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TilesMoverTest {

    private TilesMover tilesMover;
    private Tile[][] testTiles;

    @BeforeEach
    void setUp() {
        tilesMover = new TilesMover();
        testTiles = tilesMover.tiles;
        Arrays.stream(testTiles).collect(Collectors.toList()).clear();
    }

    @Test
    void shouldPerformMoveUpOperationAndGenerateValidOutput() {
        testTiles[0][1].updateValue(4);
        testTiles[1][1].updateValue(4);

        assertEquals(4, testTiles[0][1].getValue());
        tilesMover.moveUp();
        assertEquals(8, testTiles[0][1].getValue());
    }

    @Test
    void shouldPerformMoveDownOperationAndGenerateValidOutput() {
        testTiles[0][0].updateValue(2);
        testTiles[1][0].updateValue(2);

        assertEquals(2, testTiles[1][0].getValue());
        tilesMover.moveDown();
        assertEquals(4, testTiles[1][0].getValue());
    }

    @Test
    void shouldPerformMoveLeftOperationAndGenerateValidOutput() {
        testTiles[0][0].updateValue(2);
        testTiles[0][1].updateValue(2);

        assertEquals(2, testTiles[0][0].getValue());
        tilesMover.moveLeft();
        assertEquals(4, testTiles[0][0].getValue());
    }

    @Test
    void shouldPerformMoveRightOperationAndGenerateValidOutput() {
        testTiles[0][3].updateValue(2);
        testTiles[0][2].updateValue(2);

        assertEquals(2, testTiles[0][3].getValue());
        tilesMover.moveRight();
        assertEquals(4, testTiles[0][3].getValue());
    }

}