package runner;

import logic.GamePlay;
import objects.Play;
import objects.Game;
import objects.GameList;
import parser.PlayReader;
import parser.PlayReaderImp;
import parser.XmlReader;
import parser.XmlReaderImpl;

import java.util.Optional;

public class AppRunner {

    private static String configPath;
    private static String gameTypesPath;

    public static void main(String[] args) {
        init();
        welcome();

        GameList gameList = XmlReaderImpl.read(gameTypesPath, GameList.class);
        Play play = XmlReaderImpl.read(configPath, Play.class);

        Optional<Game> game = gameList.getGameTypeById(play.getGameType());

        if (game.isPresent()) {
            GamePlay gamePlay = new GamePlay(play, game.get());
            gamePlay.generate();
        } else {
            System.out.println("Invalid Game");
        }
    }

    private static void init() {
        configPath = "src/main/resources/quicktip-config.xml";
        gameTypesPath = "src/main/resources/game-types.xml";
    }

    private static void welcome() {
        System.out.println(new StringBuilder()
                .append("* * * * * * * * * * * *\n")
                .append("* Welcome to QuickTip *\n")
                .append("* * * * * * * * * * * *\n").toString());
    }
}

