package com.appliction.game.model.gamelogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameAnimatorTest {
    @BeforeEach
    void setUp() {
        GameAnimator.getInstance().resetScoreOfTilesMove();
    }

    @Test
    void shouldAddScoreOnMergingTiles() {
        GameAnimator gameAnimator = GameAnimator.getInstance();
        assertEquals(0, gameAnimator.getScoreOfTilesMove());

        gameAnimator.addScoreOnMergingTiles(8);
        assertEquals(8, gameAnimator.getScoreOfTilesMove());
    }
    @Test
    void shouldResetMergeScoreAfterAddingToScoreBoard() {
        GameAnimator gameAnimator = GameAnimator.getInstance();
        gameAnimator.addScoreOnMergingTiles(10);
        assertEquals(10, gameAnimator.getScoreOfTilesMove());

        gameAnimator.resetScoreOfTilesMove();
        assertEquals(0, gameAnimator.getScoreOfTilesMove());
    }

}