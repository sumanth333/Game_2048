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
                scoreOfPerformedMove += performMergeOperation(tilesRow[rowIndex], tilesRow[rowIndex - 1]);
            }
        }
    }

    private int performMergeOperation(Tile destinationTile, Tile sourceTile) {
        destinationTile.updateValue(destinationTile.getValue() + sourceTile.getValue());
        sourceTile.updateValue(0);
        return destinationTile.getValue();
    }

    public boolean isGameOver(Tile[][] tiles) {
        for (int rowIndex = 0; rowIndex < ROWS; ++rowIndex) {
            for (int columnIndex = 0; columnIndex < COLUMNS; ++columnIndex) {
                if (tiles[rowIndex][columnIndex].getValue() == 0) {
                    return false;
                }
                if (rowIndex != ROWS - 1 && tiles[rowIndex][columnIndex].getValue() == tiles[rowIndex + 1][columnIndex].getValue()) {
                    return false;
                }
                if (columnIndex != COLUMNS - 1 && tiles[rowIndex][columnIndex].getValue() == tiles[rowIndex][columnIndex + 1].getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean spawnTile() {
        List<Tile> tempList = new ArrayList<Tile>();
        for (int rowIndex = 0; rowIndex < tiles.length; ++rowIndex) {
            for (int columnIndex = 0; columnIndex < tiles[0].length; ++columnIndex) {
                if (tiles[rowIndex][columnIndex].getValue() == 0) {
                    tempList.add(tiles[rowIndex][columnIndex]);
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
