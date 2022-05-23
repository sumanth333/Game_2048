package com.appliction.game.model.gamelogic;

import com.appliction.game.view.Tile;

public class GameAnimator extends TilesMover {

    private static GameAnimator gameAnimator = null;

    private GameAnimator() { super(); }

    public boolean perFormMergeOperation(int rowIndex, int columnIndex, int sourceRowIndex, int sourceColumn) {
        if (tiles[sourceRowIndex][sourceColumn].getValue()>0) {
            Tile destinationTile = tiles[rowIndex][columnIndex];
            Tile sourceTile = tiles[sourceRowIndex][sourceColumn];
            if (sourceTile.getValue() == destinationTile.getValue()) {
                mergeTiles(sourceTile, destinationTile);
            }
            return true;
        }
        return false;
    }

    private void mergeTiles(Tile sourceTile, Tile destinationTile) {
        int mergedValue = destinationTile.getValue() + sourceTile.getValue();
        destinationTile.updateValue(mergedValue);
        sourceTile.updateValue(0);
        scoreOfPerformedMove += mergedValue;
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
