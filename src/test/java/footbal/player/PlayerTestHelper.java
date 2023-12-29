package footbal.player;

import football.player.Player;

import java.util.LinkedList;
import java.util.List;

public class PlayerTestHelper {
    public List<Player> getPlayers() {
        final List<Player> goalscorers = new LinkedList<>();
        goalscorers.add(new Player("Cristiano Ronaldo", 128));
        goalscorers.add(new Player("Ali Daei", 109));
        goalscorers.add(new Player("Lionel Messi", 106));
        goalscorers.add(new Player("Sunil Chhetri", 93));
        return goalscorers;

    }

}
