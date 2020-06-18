package unit;

import logic.QuickTipGamePlay;
import objects.Play;
import objects.QuickTip;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class QuickTipGamePlayTest {


    @Mock
    Play play;

    @Mock
    QuickTip game;

    @InjectMocks
    QuickTipGamePlay quickTipGamePlay = new QuickTipGamePlay();

    @Test
    public void testGenerate() {

        Mockito.when(play.getGameType()).thenReturn(1);

        Map<Integer, List<Integer>> gameMap = new HashMap<>();
        gameMap.put(1, Arrays.asList(1,55,6,88,29));
        Mockito.when(game.giveTip()).thenReturn(gameMap);

        quickTipGamePlay.generate();
    }

}
