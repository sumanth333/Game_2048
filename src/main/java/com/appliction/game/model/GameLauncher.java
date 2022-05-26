package com.appliction.game.model;

import com.appliction.game.model.gamelogic.GameAnimator;
import com.appliction.game.model.observers.GameScoreObserver;
import com.appliction.game.model.observers.ObserversNotifier;
import com.appliction.game.model.observers.TilesObserver;
import com.appliction.game.view.GameUI;
import com.appliction.game.view.PlayArea;
import com.appliction.game.view.Score;

import java.awt.BorderLayout;

public class GameLauncher {
    private void initialiseObservers() {
        ObserversNotifier observersNotifier = ObserversNotifier.getInstance();

        Score gamScore = new Score(0,0,100,100);
        GameUI.getInstance().add(gamScore, BorderLayout.NORTH);
        new TilesObserver(observersNotifier);
        new GameScoreObserver(observersNotifier, gamScore);
    }

    public void launchGameUI() {
        initialiseObservers();
        GameUI.getInstance().add(PlayArea.getInstance());
        GameAnimator.getInstance().spawnTile();
    }
}