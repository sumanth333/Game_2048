package com.appliction.game.model.observers;

import com.appliction.game.controller.KeyBoardListener;
import com.appliction.game.model.gamelogic.GameAnimator;

import java.awt.event.KeyEvent;

public class TilesObserver extends Observer {

    public TilesObserver(ObserversNotifier observersNotifier) {
        this.observersNotifier = observersNotifier;
        this.observersNotifier.subscribeObserver(this);
    }

    @Override
    public void update() {
        GameAnimator gameAnimator = GameAnimator.getInstance();
        Integer eventCode;
        while ((eventCode = KeyBoardListener.getInstance().getEarliestKeyboardEvent()) != null) {
            switch (eventCode) {
                case KeyEvent.VK_UP:
                    gameAnimator.moveUp();gameAnimator.spawnTile();break;
                case KeyEvent.VK_DOWN:
                    gameAnimator.moveDown();gameAnimator.spawnTile();break;
                case KeyEvent.VK_RIGHT:
                    gameAnimator.moveRight();gameAnimator.spawnTile();break;
                case KeyEvent.VK_LEFT:
                    gameAnimator.moveLeft();gameAnimator.spawnTile();break;
            }
        }
    }
}
