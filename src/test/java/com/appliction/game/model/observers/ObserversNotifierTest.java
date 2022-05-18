package com.appliction.game.model.observers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ObserversNotifierTest {

    @Mock
    private BestScoreObserver mockBestScoreObserver;
    @Mock
    private GameScoreObserver mockGameScoreObserver;

    private ObserversNotifier observersNotifier;

    @BeforeEach
    void setUp() {
        observersNotifier = ObserversNotifier.getInstance();
        observersNotifier.subscribeObserver(mockGameScoreObserver);
        observersNotifier.subscribeObserver(mockBestScoreObserver);

        doNothing().when(mockGameScoreObserver).update();
        doNothing().when(mockBestScoreObserver).update();
    }

    @Test
    void shouldNotifyAllObservers() {
        observersNotifier.notifyAllObservers();

        verify(mockGameScoreObserver, times(1)).update();
        verify(mockBestScoreObserver, times(1)).update();
    }

    @Test
    void shouldUnSubscribeObserver() {
        observersNotifier.notifyAllObservers();
        verify(mockGameScoreObserver, times(1)).update();
        verify(mockBestScoreObserver, times(1)).update();

        observersNotifier.unSubscribeObserver(mockBestScoreObserver);
        observersNotifier.notifyAllObservers();
        verify(mockGameScoreObserver, times(2)).update();
        verify(mockBestScoreObserver, times(1)).update();
    }
}