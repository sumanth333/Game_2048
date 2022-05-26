package com.appliction.game.model.observers;

import com.appliction.game.view.Score;

public class BestScoreObserver extends Observer {

    private final Score currentScore;
    private final Score bestScore;

    public BestScoreObserver(ObserversNotifier observersNotifier, Score gameScore, Score bestScore) {
        this.observersNotifier = observersNotifier;
        this.observersNotifier.subscribeObserver(this);
        currentScore = gameScore;
        this.bestScore = bestScore;
    }

    @Override
    public void update() {
        if (currentScore.getScoreValue() > bestScore.getScoreValue()) {
            bestScore.updateScore(currentScore.getScoreValue());
        }
    }
}
