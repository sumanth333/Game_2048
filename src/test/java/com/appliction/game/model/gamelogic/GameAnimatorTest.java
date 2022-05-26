package com.appliction.game.model.gamelogic;

import com.appliction.game.view.PlayArea;
import com.appliction.game.view.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

    @Test
    void shouldNotSpawnNewTileOnFilledPlayArea() {
        Tile[][] testTiles = PlayArea.getInstance().getTileObjects();
        Arrays.stream(testTiles).forEach(tiles -> Arrays.stream(tiles).forEach(tile -> tile.updateValue(2)));

        boolean isSpawned = GameAnimator.getInstance().spawnTile();
        assertFalse(isSpawned);
        Arrays.stream(testTiles).forEach(tiles -> Arrays.stream(tiles).forEach(tile -> tile.updateValue(0)));
    }

    @Test
    void shouldSpawnNewTileOnPlayArea() {
        Tile[][] testTiles = PlayArea.getInstance().getTileObjects();
        Arrays.stream(testTiles).forEach(tiles -> Arrays.stream(tiles).forEach(tile -> tile.updateValue(0)));

        boolean isSpawned = GameAnimator.getInstance().spawnTile();
        assertTrue(isSpawned);
    }

    @Test
    void shouldPerformMergeOperation() {
        Tile[][] testTiles = PlayArea.getInstance().getTileObjects();
        testTiles[0][0].updateValue(4);
        testTiles[0][1].updateValue(4);

        GameAnimator.getInstance().mergeTilesRow(testTiles[0]);
        assertEquals(8, GameAnimator.getInstance().getScoreOfTilesMove());
        GameAnimator.getInstance().resetScoreOfTilesMove();
    }

    @Test
    void shouldNotPerformMergeOperation() {
        Tile[][] testTiles = PlayArea.getInstance().getTileObjects();
        testTiles[0][0].updateValue(4);
        testTiles[0][1].updateValue(8);

        GameAnimator.getInstance().mergeTilesRow(testTiles[0]);
        assertEquals(0, GameAnimator.getInstance().getScoreOfTilesMove());
    }

    @Test
    void shouldReturnTrueWhenGameOver() {
        Tile testTile2 = new Tile();testTile2.updateValue(2);
        Tile testTile4 = new Tile();testTile4.updateValue(4);
        Tile[][] testTiles = {
                                {testTile2,testTile4,testTile2,testTile4},
                                {testTile4,testTile2,testTile4,testTile2},
                                {testTile2,testTile4,testTile2,testTile4},
                                {testTile4,testTile2,testTile4,testTile2}
                            };

        assertTrue(GameAnimator.getInstance().isGameOver(testTiles));
    }

    @Test
    void shouldReturnFalseWhenGameOver() {
        Tile testTile2 = new Tile();testTile2.updateValue(0);
        Tile testTile4 = new Tile();testTile4.updateValue(4);
        Tile[][] testTiles = {
                {testTile2,testTile4,testTile2,testTile4},
                {testTile4,testTile2,testTile4,testTile2},
                {testTile2,testTile4,testTile2,testTile4},
                {testTile4,testTile2,testTile4,testTile2}
        };

        assertFalse(GameAnimator.getInstance().isGameOver(testTiles));
        testTile2.updateValue(2);testTile4.updateValue(2);
        assertFalse(GameAnimator.getInstance().isGameOver(testTiles));
    }
    @Test
    void shouldReturnGameOverFalseWhenPossibleMovePresent() {
        Tile testTile2 = new Tile();testTile2.updateValue(2);
        Tile testTile4 = new Tile();testTile4.updateValue(4);
        Tile[][] testTiles = {
                {testTile2,testTile2,testTile2,testTile2},
                {testTile4,testTile4,testTile2,testTile4},
                {testTile2,testTile4,testTile2,testTile4},
                {testTile4,testTile4,testTile2,testTile4}
        };

        assertFalse(GameAnimator.getInstance().isGameOver(testTiles));
    }

}