package footbal.player;

import football.player.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerShould {
    @Test
    void give_the_best_scorer_with_OOP() {
        List<Player> goalscorers = new PlayerTestHelper().getPlayers();

        Player bestScorer = goalscorers.get(0);
        for (Player goalscorer : goalscorers) {
            if (goalscorer.getGoal() > bestScorer.getGoal()) {
                bestScorer = goalscorer;
            }
        }
        assertThat(bestScorer.getName()).isEqualTo("Cristiano Ronaldo");
    }
}
