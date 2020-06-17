package logic;

import objects.Game;
import objects.Play;
import objects.QuickTip;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuicktipGamePlay implements GameGenerator {

    private Map<Integer, Map<Integer, List<Integer>>> generatedTips;

    private QuickTip game;
    private Play play;

    public QuicktipGamePlay(Play play, QuickTip game) {
        this.game = game;
        this.play = play;
        generatedTips = new HashMap<>();
    }

    public void generate() {
        System.out.println(game);
        for (int i = 0; i < play.getNumberOfTickets(); i++) {
            generatedTips.put(i + 1, game.giveTip());
            System.out.println(new StringBuilder().append("Ticket")
                    .append(i + 1)
                    .append(": ")
                    .append(game.giveTip()));
        }
    }
}
