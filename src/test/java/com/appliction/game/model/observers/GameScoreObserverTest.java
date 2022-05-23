package com.appliction.game.model.observers;

import com.appliction.game.model.gamelogic.GameAnimator;
import com.appliction.game.view.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
class GameScoreObserverTest {

    @Mock
    private ObserversNotifier mockObserversNotifier;

    @BeforeEach
    void setUp() {
        doNothing().when(mockObserversNotifier).subscribeObserver(any());
    }

    @Test
    void shouldUpdateScoreWhenTilesMoved() {
        Score testScore = new Score(0,0,10,10);
        GameScoreObserver gameScoreObserver = new GameScoreObserver(mockObserversNotifier, testScore);
        GameAnimator.getInstance().addScoreOnMergingTiles(8);
        gameScoreObserver.update();

        assertEquals(8, testScore.getScoreValue());
    }

    @Test
    void shouldNotUpdateGameScoreWhenTilesAreNotMerged() {
        Score testScore = new Score(0,0,10,10);
        GameScoreObserver gameScoreObserver = new GameScoreObserver(mockObserversNotifier, testScore);
        gameScoreObserver.update();

        assertEquals(0, testScore.getScoreValue());
    }
}