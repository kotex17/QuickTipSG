package objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@XmlRootElement(name = "game-types")
public class GameList {

    @XmlElement(name = "game-type")
    private List<Game> gameList = new ArrayList<Game>();

    public List<Game> getGameList() {
        return gameList;
    }

    public Optional<Game> getGameTypeById(int id){
       return this.getGameList().stream().filter(g -> g.getId()==id).findFirst();
    }
}
