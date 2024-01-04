package footbal.player;

import football.player.Player;
import football.player.PlayerWithCups;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class PlayerTestHelper {
    public List<Player> getPlayers() {
        final List<Player> goalscorers = new LinkedList<>();
        goalscorers.add(new Player("Cristiano Ronaldo", 128));
        goalscorers.add(new Player("Ali Daei", 109));
        goalscorers.add(new Player("Lionel Messi", 106));
        goalscorers.add(new Player("Sunil Chhetri", 93));
        return goalscorers;

    }

    public List<PlayerWithCups> getPlayersWithCups() {
        final List<PlayerWithCups> goalscorers = new LinkedList<>();
        goalscorers.add(new PlayerWithCups("Cristiano Ronaldo", 128, asList("La liga", "UEFA championship")));
        goalscorers.add(new PlayerWithCups("Ali Daei", 109, asList("Iranian championship", "Bundesliga")));
        goalscorers.add(new PlayerWithCups("Lionel Messi", 106, asList("La liga", "UEFA championship")));
        goalscorers.add(new PlayerWithCups("Sunil Chhetri", 93, emptyList()));
        return goalscorers;
    }

}
