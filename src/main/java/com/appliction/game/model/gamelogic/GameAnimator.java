package com.appliction.game.model.gamelogic;

import com.appliction.game.view.Tile;

import java.util.ArrayList;
import java.util.List;

public class GameAnimator extends TilesMover {

    private static GameAnimator gameAnimator = null;

    private GameAnimator() {
        super();
    }

    public void mergeTilesRow(Tile[] tilesRow) {
        for (int rowIndex = tilesRow.length - 1; rowIndex >= 1; rowIndex--) {
            if (tilesRow[rowIndex].getValue() == tilesRow[rowIndex - 1].getValue()) {
                performMergeOperation(tilesRow[rowIndex], tilesRow[rowIndex - 1]);
            }
        }
    }

    private void performMergeOperation(Tile destinationTile, Tile sourceTile) {
        destinationTile.updateValue(destinationTile.getValue() + sourceTile.getValue());
        sourceTile.updateValue(0);
        scoreOfPerformedMove += destinationTile.getValue();
    }

    public boolean isGameOver() {
        for (int i = 0; i < ROWS; ++i) {
            for (int j = 0; j < COLUMNS; ++j) {
                if (tiles[i][j].getValue() == 0) {
                    return false;
                }
                if (i != ROWS - 1 && tiles[i][j].getValue() == tiles[i + 1][j].getValue()) {
                    return false;
                }
                if (j != COLUMNS - 1 && tiles[i][j].getValue() == tiles[i][j + 1].getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean spawnTile() {
        List<Tile> tempList = new ArrayList<Tile>();
        for (int i = 0; i < tiles.length; ++i) {
            for (int j = 0; j < tiles[0].length; ++j) {
                if (tiles[i][j].getValue() == 0) {
                    tempList.add(tiles[i][j]);
                }
            }
        }
        if (tempList.isEmpty())
            return false;

        tempList.get((int) Math.floor(Math.random() * tempList.size())).updateValue(Math.random() > 0.5 ? 4 : 2);
        return true;
    }

    public static GameAnimator getInstance() {
        if (gameAnimator == null)
            gameAnimator = new GameAnimator();
        return gameAnimator;
    }

    public int getScoreOfTilesMove() {
        return scoreOfPerformedMove;
    }

    public void resetScoreOfTilesMove() {
        scoreOfPerformedMove = 0;
    }

    public void addScoreOnMergingTiles(int mergedScore) {
        scoreOfPerformedMove += mergedScore;
    }
}
