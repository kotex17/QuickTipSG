package logic;

import objects.Game;
import objects.Play;

public class GamePlay implements GameGenerator {

    private Game game;
    private Play play;

    public GamePlay(Play play, Game game) {
        this.game = game;
        this.play = play;
    }

    public void generate() {
        System.out.println(game);
        for (int i = 0; i < play.getNumberOfTickets(); i++) {
            System.out.println(game.giveTip());
        }
    }
}
