package runner;

import logic.GameGenerator;
import logic.QuickTipGamePlay;
import objects.Play;
import objects.Game;
import objects.GameList;
import reader.XmlReader;

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
            GameGenerator quickTipGenerator = new QuickTipGamePlay(play, game.get());
            quickTipGenerator.generate();
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

