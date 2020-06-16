package objects;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.apache.commons.lang3.RandomUtils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (name != null)
            stringBuilder.append(String.format("Name: %s\t", name));
        if (ticket != null)
            stringBuilder.append(String.format("Ticket: %s\t", ticket));
        return stringBuilder.toString();
    }

    @Override
    public Map<Integer,List<Integer>> giveTip() {
        Map<Integer,List<Integer>> lotteryMap = new HashMap<>();

        for (int i = 0; i < this.getTicket().getPanels(); i++) {
            List<Integer> lotteryList = new ArrayList<>();
            lotteryMap.put(i+1,lotteryList);
            for (int j = 0; j < this.getTicket().getPicks(); j++) {
                lotteryList.add(pickNumber());
            }
        }
        return lotteryMap;
    }

    private int pickNumber() {
        return RandomUtils.nextInt(this.getTicket().getRange().getMinimum(), this.getTicket().getRange().getMaximum() + 1);
    }
}
