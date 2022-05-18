package com.appliction.game.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Queue;

public class KeyBoardListener implements KeyListener {

    private final Queue<Integer> keyBoardEventsQueue;
    private static KeyBoardListener keyBoardListener = null;

    public static KeyBoardListener getInstance() {
        if(keyBoardListener == null)
            keyBoardListener = new KeyBoardListener();
        return keyBoardListener;
    }

    private KeyBoardListener() {
        keyBoardEventsQueue = new LinkedList<>();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyBoardEventsQueue.add(e.getKeyCode());
    }

    public Integer getEarliestKeyboardEvent() {
        return keyBoardEventsQueue.poll();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
