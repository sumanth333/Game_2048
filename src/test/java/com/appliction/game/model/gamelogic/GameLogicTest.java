package com.appliction.game.model.gamelogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameLogicTest {
    @BeforeEach
    void setUp() {
        GameLogic.getInstance().resetScoreOfTilesMove();
    }

    @Test
    void shouldAddScoreOnMergingTiles() {
        GameLogic gameLogic = GameLogic.getInstance();
        assertEquals(0, gameLogic.getScoreOfTilesMove());

        gameLogic.addScoreOnMergingTiles(8);
        assertEquals(8, gameLogic.getScoreOfTilesMove());
    }
    @Test
    void shouldResetMergeScoreAfterAddingToScoreBoard() {
        GameLogic gameLogic = GameLogic.getInstance();
        gameLogic.addScoreOnMergingTiles(10);
        assertEquals(10, gameLogic.getScoreOfTilesMove());

        gameLogic.resetScoreOfTilesMove();
        assertEquals(0, gameLogic.getScoreOfTilesMove());
    }

}