package com.appliction.game.model.observers;

import com.appliction.game.controller.KeyBoardListener;
import com.appliction.game.model.gamelogic.GameLogic;

import java.awt.event.KeyEvent;

public class TilesObserver extends Observer {

    public TilesObserver(ObserversNotifier observersNotifier) {
        this.observersNotifier = observersNotifier;
        this.observersNotifier.subscribeObserver(this);
    }

    @Override
    public void update() {
        GameLogic gameLogic = GameLogic.getInstance();
        Integer eventCode;
        while ((eventCode = KeyBoardListener.getInstance().getEarliestKeyboardEvent()) != null) {
            switch (eventCode) {
                case KeyEvent.VK_UP:
                    gameLogic.moveUp();break;
                case KeyEvent.VK_DOWN:
                    gameLogic.moveDown();break;
                case KeyEvent.VK_RIGHT:
                    gameLogic.moveRight();break;
                case KeyEvent.VK_LEFT:
                    gameLogic.moveLeft();break;
            }
        }
    }
}
