package com.appliction.game.controller;

import org.junit.jupiter.api.Test;

import javax.swing.JPanel;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class KeyBoardListenerTest {

    @Test
    void shouldReceiveEmptyKeyBoardEvents() {
        KeyBoardListener testKeyListener = KeyBoardListener.getInstance();
        assertNull(testKeyListener.getEarliestKeyboardEvent());
    }
    @Test
    void shouldAddKeyBoardEventToQueue() {
        KeyBoardListener testKeyListener = KeyBoardListener.getInstance();
        KeyEvent testEvent = new KeyEvent(new JPanel(), 1,2,3,KeyEvent.VK_UP, 't');
        testKeyListener.keyPressed(testEvent);

        assertEquals(KeyEvent.VK_UP, testKeyListener.getEarliestKeyboardEvent());
    }
}