package com.appliction.game.model.gamelogic;

import com.appliction.game.view.Tile;

public class GameLogic extends MovingLogic{

    private static GameLogic gameLogic = null;

    private GameLogic() { super(); }

    public boolean perFormMergeOperation(int rowIndex, int columnIndex, int sourceRowIndex, int sourceColumn) {
        if (tiles[sourceRowIndex][sourceColumn].getValue()>0) {
            Tile destinationTile = tiles[rowIndex][columnIndex];
            Tile sourceTile = tiles[sourceRowIndex][sourceColumn];
            if (sourceTile.getValue() == destinationTile.getValue()) {
                mergeTiles(sourceTile, destinationTile);
            }
            return true;
        } else {
            tiles[sourceRowIndex][sourceColumn].updateValue(tiles[rowIndex][columnIndex].getValue());
            tiles[rowIndex][columnIndex].updateValue(0);
        }
        return false;
    }

    private void mergeTiles(Tile sourceTile, Tile destinationTile) {
        int mergedValue = destinationTile.getValue() + sourceTile.getValue();
        destinationTile.updateValue(mergedValue);
        sourceTile.updateValue(0);
        scoreOfPerformedMove += mergedValue;
    }

    public static GameLogic getInstance() {
        if (gameLogic == null)
            gameLogic = new GameLogic();
        return gameLogic;
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
