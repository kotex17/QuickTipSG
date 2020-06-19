package objects;

import org.apache.commons.lang3.RandomUtils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "game-type")
public class Game implements QuickTip {

    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "id")
    private Integer id;
    @XmlElement(name = "ticket")
    private Ticket ticket;

    public String getName() {
        return name;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public Map<Integer, List<Integer>> giveTip() {
        Map<Integer, List<Integer>> lotteryMap = new HashMap<>();

        for (int i = 0; i < this.getTicket().getPanels(); i++) {
            List<Integer> lotteryList = new ArrayList<>();
            lotteryMap.put(i, lotteryList);
            for (int j = 0; j < this.getTicket().getPicks(); j++) {
                lotteryList.add(pickNumber()); //filling the panel with picked numbers
            }
        }
        return lotteryMap;
    }

    //pick random number from the range
    private int pickNumber() {
        return RandomUtils.nextInt(this.getTicket().getRange().getMinimum(), this.getTicket().getRange().getMaximum() + 1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (name != null)
            stringBuilder.append(String.format("Name: %s\t", name));
        if (ticket != null)
            stringBuilder.append(String.format("Ticket: %s\t", ticket));
        return stringBuilder.toString();
    }
}
