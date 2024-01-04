package football.player;

import java.util.List;

public class PlayerWithCups extends Player {
    private final List<String> cup;

    public PlayerWithCups(String name, int goal, List<String> cup) {
        super(name, goal);
        this.cup = cup;
    }

    public List<String> getCup() {
        return cup;
    }
}
