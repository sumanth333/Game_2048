package com.appliction.game.model.observers;

public abstract class Observer {

    protected ObserversNotifier observersNotifier;

    public abstract void update();
}