package unit;

import objects.Game;
import objects.GameList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class GameListTest {

    @Mock
    Game game;

    @Spy
    ArrayList<Game> list;

    @InjectMocks
    GameList gameList = new GameList();

    @Before
    public void init() {
        Mockito.when(game.getId()).thenReturn(1);
        list.add(game);
    }

    @Test
    public void getGameTypeById() {
        Assert.assertEquals(game, gameList.getGameTypeById(1).get());
        Assert.assertEquals(Optional.empty(), gameList.getGameTypeById(2));
    }
}
