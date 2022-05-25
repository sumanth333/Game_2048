package com.appliction.game.model.gamelogic;

import com.appliction.game.view.PlayArea;
import com.appliction.game.view.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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

        boolean isMerged = GameAnimator.getInstance().perFormMergeOperation(0,0,0,1);
        assertTrue(isMerged);
        GameAnimator.getInstance().resetScoreOfTilesMove();
    }

    @Test
    void shouldNotPerformMergeOperation() {
        Tile[][] testTiles = PlayArea.getInstance().getTileObjects();
        testTiles[0][0].updateValue(4);
        testTiles[0][1].updateValue(8);

        boolean isMerged = GameAnimator.getInstance().perFormMergeOperation(0,0,0,1);
        assertFalse(isMerged);
    }
}