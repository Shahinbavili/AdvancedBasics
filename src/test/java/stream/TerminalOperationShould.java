package stream;

import footbal.player.PlayerTestHelper;
import football.player.Player;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static java.lang.System.out;
import static java.util.UUID.randomUUID;
import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.Assertions.assertThat;

public class TerminalOperationShould {
    @Test
    void collect_data() {
        final List<Player> players = new PlayerTestHelper().getPlayers();
        Function<Player, UUID> keys = player -> randomUUID();
        UnaryOperator<Player> values = player -> player;
        Map<UUID, Player> playersWithId = players.stream().collect(toMap(keys, values));
        BiConsumer<UUID, Player> printPlayer = (k, v) -> out.println("Key is " + k + " and value is " + v);
        playersWithId.forEach(printPlayer);

        assertThat(playersWithId.values()).hasSameElementsAs(players);
        assertThat(playersWithId.keySet()).hasOnlyElementsOfType(UUID.class);
    }
}
