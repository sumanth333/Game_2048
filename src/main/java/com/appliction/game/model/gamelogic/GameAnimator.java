package com.appliction.game.model.gamelogic;

import com.appliction.game.view.Tile;

import java.util.ArrayList;
import java.util.List;

public class GameAnimator extends TilesMover {

    private static GameAnimator gameAnimator = null;

    private GameAnimator() { super(); }

    public boolean perFormMergeOperation(int rowIndex, int columnIndex, int sourceRowIndex, int sourceColumn) {
        Tile destinationTile = tiles[rowIndex][columnIndex];
        Tile sourceTile = tiles[sourceRowIndex][sourceColumn];

        if(destinationTile.getValue() == sourceTile.getValue() && destinationTile.getValue()>0) {
            mergeTiles(sourceTile, destinationTile);
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

    public boolean spawnTile() {
        List<Tile> tempList = new ArrayList<Tile>();
        for(int i=0; i< tiles.length; ++i) {
            for(int j=0; j< tiles[0].length; ++j) {
                if(tiles[i][j].getValue() ==0 ) {
                    tempList.add(tiles[i][j]);
                }
            }
        }
        if(tempList.isEmpty())
            return false;

        tempList.get((int)Math.floor(Math.random()*tempList.size())).updateValue(2);
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
