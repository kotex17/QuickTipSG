package objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "quicktip")
public class Play {

    @XmlElement(name = "game_type")
    private int gameType;
    @XmlElement(name = "tickets")
    private int numberOfTickets;

    public int getGameType() {
        return gameType;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }
}
