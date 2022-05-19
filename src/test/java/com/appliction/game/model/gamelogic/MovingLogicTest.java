package com.appliction.game.model.gamelogic;

import com.appliction.game.view.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovingLogicTest {

    private MovingLogic movingLogic;
    private Tile[][] testTiles;

    @BeforeEach
    void setUp() {
        movingLogic = new MovingLogic();
        testTiles = movingLogic.tiles;
        Arrays.stream(testTiles).collect(Collectors.toList()).clear();
    }

    @Test
    void shouldPerformMoveUpOperationAndGenerateValidOutput() {
        testTiles[0][1].updateValue(4);
        testTiles[1][1].updateValue(4);

        assertEquals(4, testTiles[0][1].getValue());
        movingLogic.moveUp();
        assertEquals(8, testTiles[0][1].getValue());
    }

    @Test
    void shouldPerformMoveDownOperationAndGenerateValidOutput() {
        testTiles[0][0].updateValue(2);
        testTiles[1][0].updateValue(2);

        assertEquals(2, testTiles[1][0].getValue());
        movingLogic.moveDown();
        assertEquals(4, testTiles[1][0].getValue());
    }

    @Test
    void shouldPerformMoveLeftOperationAndGenerateValidOutput() {
        testTiles[0][0].updateValue(2);
        testTiles[0][1].updateValue(2);

        assertEquals(2, testTiles[0][0].getValue());
        movingLogic.moveLeft();
        assertEquals(4, testTiles[0][0].getValue());
    }

    @Test
    void shouldPerformMoveRightOperationAndGenerateValidOutput() {
        testTiles[0][3].updateValue(2);
        testTiles[0][2].updateValue(2);

        assertEquals(2, testTiles[0][3].getValue());
        movingLogic.moveRight();
        assertEquals(4, testTiles[0][3].getValue());
    }

}