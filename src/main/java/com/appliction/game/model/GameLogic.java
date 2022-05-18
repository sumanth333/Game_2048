package com.appliction.game.model;

public class GameLogic {
    private int scoreOfPerformedMove;
    private static GameLogic gameLogic = null;

    private GameLogic () {
        scoreOfPerformedMove = 0;
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
