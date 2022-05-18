package com.appliction.game.model.observers;

import com.appliction.game.model.GameLogic;
import com.appliction.game.view.Score;

public class GameScoreObserver extends Observer {

    private final Score gameScore;

    public GameScoreObserver(ObserversNotifier observersNotifier, Score gameScore) {
        this.observersNotifier = observersNotifier;
        this.observersNotifier.subscribeObserver(this);
        this.gameScore = gameScore;
    }

    @Override
    public void update() {
        int scoreTobeAdded = GameLogic.getInstance().getScoreOfTilesMove();
        if (scoreTobeAdded > 0) {
            gameScore.updateScore(gameScore.getScoreValue() + scoreTobeAdded);
            GameLogic.getInstance().resetScoreOfTilesMove();
        }
    }
}
