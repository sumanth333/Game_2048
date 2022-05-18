package com.appliction.game.model.observers;

import com.appliction.game.view.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BestScoreObserverTest {

    @Mock
    private Score mockCurrentScore;
    @Mock
    private Score mockBestScore;
    @Mock
    private ObserversNotifier mockObserversNotifier;

    @BeforeEach
    void setUp() {
        doNothing().when(mockObserversNotifier).subscribeObserver(any());
    }

    @Test
    void shouldUpdateBestCore() {
        BestScoreObserver bestScoreObserver =
                new BestScoreObserver(mockObserversNotifier, mockCurrentScore, mockBestScore);

        when(mockCurrentScore.getScoreValue()).thenReturn(100);
        when(mockBestScore.getScoreValue()).thenReturn(50);

        verify(mockObserversNotifier).subscribeObserver(any());
        bestScoreObserver.update();
        verify(mockBestScore, times(1)).updateScore(anyInt());
    }

    @Test
    void shouldDoNothingWhenCurrentScoreAndBestScoreAreEqual() {
        BestScoreObserver bestScoreObserver =
                new BestScoreObserver(mockObserversNotifier, mockCurrentScore, mockBestScore);

        when(mockCurrentScore.getScoreValue()).thenReturn(100);
        when(mockBestScore.getScoreValue()).thenReturn(100);


        verify(mockObserversNotifier).subscribeObserver(any());
        bestScoreObserver.update();
        verify(mockBestScore, times(0)).updateScore(anyInt());
    }
}