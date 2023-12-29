package stream;

import footbal.player.PlayerTestHelper;
import football.player.Player;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamOperatorShould {
    @Test
    void filter_data() {
        final List<Player> aliDaei = new LinkedList<>();
        aliDaei.add(new Player("Ali Daei", 109));

        final List<Player> players = new PlayerTestHelper().getPlayers();
        Predicate<? super Player> topScorer = player -> player.getGoal() > 100;
        Predicate<? super Player> nameIsAli = player -> player.getName().contains("Ali");
        final List<Player> topScorerWhereNameContainsAli = players.stream()
                .filter(topScorer)
                .filter(nameIsAli)
                .collect(Collectors.toList());

        assertThat(topScorerWhereNameContainsAli).isEqualTo(aliDaei);
    }
}
