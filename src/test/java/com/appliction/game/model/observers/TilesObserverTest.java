package com.appliction.game.model.observers;

import com.appliction.game.controller.KeyBoardListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.JPanel;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
class TilesObserverTest {

    @Mock
    private ObserversNotifier mockObserversNotifier;

    @BeforeEach
    void setUp() {
        doNothing().when(mockObserversNotifier).subscribeObserver(any());
    }

    @Test
    void shouldPerformKeyUpOperationOnTilesUpdate() {
        KeyBoardListener testKeyListener = KeyBoardListener.getInstance();
        KeyEvent testEvent = new KeyEvent(new JPanel(), 1,2,3,KeyEvent.VK_UP, 't');
        testKeyListener.keyPressed(testEvent);

        TilesObserver tilesObserver = new TilesObserver(mockObserversNotifier);
        tilesObserver.update();

        assertNull(testKeyListener.getEarliestKeyboardEvent());
    }

    @Test
    void shouldPerformKeyLeftOperationOnTilesUpdate() {
        KeyBoardListener testKeyListener = KeyBoardListener.getInstance();
        KeyEvent testEvent = new KeyEvent(new JPanel(), 1,2,3,KeyEvent.VK_LEFT, 't');
        testKeyListener.keyPressed(testEvent);

        TilesObserver tilesObserver = new TilesObserver(mockObserversNotifier);
        tilesObserver.update();

        assertNull(testKeyListener.getEarliestKeyboardEvent());
    }

}