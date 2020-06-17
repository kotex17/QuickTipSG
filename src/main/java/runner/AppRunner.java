package runner;

import logic.GameGenerator;
import logic.QuicktipGamePlay;
import objects.Play;
import objects.Game;
import objects.GameList;
import parser.XmlReader;

import java.util.Optional;

public class AppRunner {

    private static String configPath = "src/main/resources/quicktip-config.xml";
    private static String gameTypesPath = "src/main/resources/game-types.xml";

    public static void main(String[] args) {
        welcome();
        //read xml resources
        Play play = XmlReader.unmarshal(configPath, Play.class);
        GameList gameList = XmlReader.unmarshal(gameTypesPath, GameList.class);
        //get desired type of game
        Optional<Game> game = gameList.getGameTypeById(play.getGameType());

        if (game.isPresent()) {
            //play the game
            GameGenerator quicktipGenerator = new QuicktipGamePlay(play, game.get());
            quicktipGenerator.generate();
        } else {
            System.out.println("Invalid Game");
        }
    }

    private static void welcome() {
        System.out.println(new StringBuilder()
                .append("* * * * * * * * * * * *\n")
                .append("* Welcome to QuickTip *\n")
                .append("* * * * * * * * * * * *\n").toString());
    }
}

