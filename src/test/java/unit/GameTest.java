package unit;

import objects.Game;
import objects.Ticket;
import org.apache.commons.lang3.Range;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    Ticket ticket;

    @InjectMocks
    Game game;

    @Test
    public void giveTipTest() {
        int range = 90;
        int panels = 1;
        int picks = 5;

        Mockito.when(ticket.getRange()).thenReturn(Range.between(1, range));
        Mockito.when(ticket.getPanels()).thenReturn(panels);
        Mockito.when(ticket.getPicks()).thenReturn(picks);

        Map<Integer, List<Integer>> tips = game.giveTip();
        Assert.assertNotNull(tips);
        Assert.assertEquals(tips.get(0).size(), picks);
    }
}
