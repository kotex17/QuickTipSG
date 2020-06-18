package objects;

import org.apache.commons.lang3.Range;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "game-type")
public class Ticket {

    @XmlElement(name = "panels")
    private Integer panels = 1;
    @XmlElement(name = "picks")
    private Integer picks = 5;
    @XmlElement(name = "range")
    private Integer range = 90;

    public Range<Integer> getRange() {
        return Range.between(1, range);
    }

    public int getPanels() {
        return panels;
    }

    public int getPicks() {
        return picks;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Panels: ")
                .append(panels)
                .append(":\t")
                .append("Picks: ")
                .append(picks.toString())
                .append("\t")
                .append("Range: 1-")
                .append(range)
                .toString();
    }
}
