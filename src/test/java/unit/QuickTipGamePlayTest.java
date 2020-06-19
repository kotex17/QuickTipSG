package unit;

import logic.QuickTipGamePlay;
import objects.Play;
import objects.QuickTip;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class QuickTipGamePlayTest {

    @Mock
    Play play;

    @Mock
    QuickTip game;

    @InjectMocks
    QuickTipGamePlay quickTipGamePlay = new QuickTipGamePlay(play, game);

    @Test
    public void testGenerate() {

        int key = 1;
        List<Integer> numberList = Arrays.asList(1, 23, 44, 67, 2);
        Map<Integer, List<Integer>> gameMap = new HashMap<>();
        gameMap.put(key, numberList);

        Mockito.when(game.giveTip()).thenReturn(gameMap);
        Mockito.when(play.getNumberOfTickets()).thenReturn(1);

        quickTipGamePlay.generate();

        Assert.assertNotNull(quickTipGamePlay.getGeneratedTips());
        Assert.assertTrue(quickTipGamePlay.getGeneratedTips().get(0).size() > 0);
        Assert.assertEquals(5, quickTipGamePlay.getGeneratedTips().get(0).get(key).size());
    }

}
