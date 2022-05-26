package com.appliction.game.controller;

import com.appliction.game.model.observers.GameScoreObserver;
import com.appliction.game.model.observers.ObserversNotifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.JPanel;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class KeyBoardListenerTest {

    @Mock
    private GameScoreObserver mockGameScoreObserver;

    @Test
    void shouldReceiveEmptyKeyBoardEvents() {
        KeyBoardListener testKeyListener = KeyBoardListener.getInstance();
        assertNull(testKeyListener.getEarliestKeyboardEvent());
    }

    @Test
    void shouldAddKeyBoardEventToQueue() {
        KeyBoardListener testKeyListener = KeyBoardListener.getInstance();
        KeyEvent testEvent = new KeyEvent(new JPanel(), 1, 2, 3, KeyEvent.VK_UP, 't');
        testKeyListener.keyPressed(testEvent);

        assertEquals(KeyEvent.VK_UP, testKeyListener.getEarliestKeyboardEvent());
    }

    @Test
    void shouldNotifyObserversWhenKeyReleased() {
        doNothing().when(mockGameScoreObserver).update();
        ObserversNotifier observersNotifier = ObserversNotifier.getInstance();
        observersNotifier.subscribeObserver(mockGameScoreObserver);

        KeyBoardListener testKeyListener = KeyBoardListener.getInstance();
        KeyEvent testEvent = new KeyEvent(new JPanel(), 1, 2, 3, KeyEvent.VK_UP, 't');
        testKeyListener.keyReleased(testEvent);

        verify(mockGameScoreObserver, times(1)).update();
        observersNotifier.unSubscribeObserver(mockGameScoreObserver);
    }
}