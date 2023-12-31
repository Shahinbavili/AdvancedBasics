package stream;

import footbal.player.PlayerTestHelper;
import football.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

import static java.lang.System.out;
import static java.util.UUID.randomUUID;
import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.Assertions.assertThat;

public class TerminalOperationShould {
    private List<Player> players;

    @BeforeEach
    void setUp() {
        players = new PlayerTestHelper().getPlayers();
    }

    @Test
    void collect_data() {
        Function<Player, UUID> keys = player -> randomUUID();
        UnaryOperator<Player> values = player -> player;
        Map<UUID, Player> playersWithId = players.stream().collect(toMap(keys, values));
        BiConsumer<UUID, Player> printPlayer = (k, v) -> out.println("Key is " + k + " and value is " + v);
        playersWithId.forEach(printPlayer);

        assertThat(playersWithId.values()).hasSameElementsAs(players);
        assertThat(playersWithId.keySet()).hasOnlyElementsOfType(UUID.class);
    }

    @Test
    void calculate_data() {
        ToIntFunction<Integer> intConvertor = Integer::valueOf;
        final Integer sum = players.stream().map(Player::getGoal).mapToInt(intConvertor).sum();
        assertThat(sum).isEqualTo(436);

        final Double average = players.stream().mapToDouble(Player::getGoal).average().orElse(0);
        assertThat(average).isEqualTo(109.0);

        final Integer max = players.stream().map(Player::getGoal).max(Integer::compareTo).orElse(0);
        assertThat(max).isEqualTo(128);

        final long count = players.stream().map(Player::getGoal).count();
        assertThat(count).isEqualTo(4L);

        final IntSummaryStatistics summary = players.stream().map(Player::getGoal).mapToInt(intConvertor)
                .summaryStatistics();
        assertThat(summary.getSum()).isEqualTo(436);
        assertThat(summary.getAverage()).isEqualTo(109.0);
        assertThat(summary.getMax()).isEqualTo(128);
        assertThat(summary.getMin()).isEqualTo(93);
        assertThat(summary.getCount()).isEqualTo(4L);
    }
}
