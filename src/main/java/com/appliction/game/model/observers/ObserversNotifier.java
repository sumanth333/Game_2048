package com.appliction.game.model.observers;

import java.util.ArrayList;
import java.util.List;

public class ObserversNotifier {

    private final List<Observer> observersList = new ArrayList<>();
    private static ObserversNotifier observersNotifier = null;

    private ObserversNotifier(){}

    public void subscribeObserver(Observer observer) {
        observersList.add(observer);
    }

    public void unSubscribeObserver(Observer observer) {
        observersList.remove(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observersList) {
            observer.update();
        }
    }

    public static ObserversNotifier getInstance() {
        if(observersNotifier == null)
            observersNotifier = new ObserversNotifier();
        return observersNotifier;
    }
}
