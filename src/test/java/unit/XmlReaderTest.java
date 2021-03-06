package unit;

import objects.GameList;
import objects.Play;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import reader.XmlReader;


public class XmlReaderTest {

    static String testXmlPath;

    @BeforeClass
    public static void init() {
        testXmlPath = "src/test/resources/test-game-type.xml";
    }

    @Test
    public void testUnmarshalGameList() {

        GameList gameList = XmlReader.unmarshal(testXmlPath, GameList.class);
        Assert.assertNotNull(gameList);
        Assert.assertNotNull(gameList.getGameList());
        Assert.assertNotNull(gameList.getGameTypeById(1).get());
    }

    @Test
    public void testUnmarshalInvalidFile() {

        Play play = XmlReader.unmarshal("invalidPath.xml", Play.class);
        Assert.assertNull(play);
    }
}
