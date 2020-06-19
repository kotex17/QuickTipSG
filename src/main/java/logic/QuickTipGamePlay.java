package logic;

import objects.Play;
import objects.QuickTip;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuickTipGamePlay implements GameGenerator {

    //stores tickets map to panel map with pick list
    private Map<Integer, Map<Integer, List<Integer>>> generatedTips;

    private QuickTip game;
    private Play play;

    public QuickTipGamePlay(Play play, QuickTip game) {
        this.game = game;
        this.play = play;
        this.generatedTips = new HashMap<>();
    }

    public void generate() {
        for (int i = 0; i < play.getNumberOfTickets(); i++) {
            this.generatedTips.put(i, game.giveTip());
        }
    }

    public void display() {
        System.out.println(game);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < getGeneratedTips().size(); i++) {
            stringBuilder.append("Ticket").append(i + 1).append(": ");
            Map<Integer, List<Integer>> panelsMap = getGeneratedTips().get(i);

            for (int j = 0; j < panelsMap.size(); j++) { //displays the panels per ticket
                stringBuilder.append("\n\tPanel").append(j + 1).append(": ");
                for (Integer number : panelsMap.get(j)) {
                    stringBuilder.append(number).append("\t");
                }
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    public Map<Integer, Map<Integer, List<Integer>>> getGeneratedTips() {
        return generatedTips;
    }
}
