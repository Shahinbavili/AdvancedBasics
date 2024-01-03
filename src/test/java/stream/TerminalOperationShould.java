package stream;

import footbal.player.PlayerTestHelper;
import football.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

import static java.lang.System.out;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.UUID.randomUUID;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

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

    @Test
    void group_data() {
        List<String> words = asList("Banana", "Apple", "Orange", "Cherry", "Avocado", "Pineapple", "Peach");
        final Map<Integer, List<String>> wordsGroupedByLength = words.stream()
                .collect(groupingBy(String::length));
        out.println(wordsGroupedByLength);

        assertThat(wordsGroupedByLength)
                .containsKeys(5, 6, 7, 9)
                .containsEntry(5, asList("Apple", "Peach"))
                .containsEntry(6, asList("Banana", "Orange", "Cherry"))
                .containsEntry(7, singletonList("Avocado"))
                .containsEntry(9, singletonList("Pineapple"))
                .hasSize(4);
    }

    @Test
    void reduce_data() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        final Optional<Integer> sumByReduce = numbers.stream().reduce(Integer::sum);

        assertThat(sumByReduce).isPresent().hasValue(15);

//        In this example, the sum will start with 2 as the initial value, and the elements 1, 2, 3, 4, and 5 will be added to it. The result is 17.
        final Integer sumByOptionalReduce = numbers.stream().reduce(2, Integer::sum);

        assertThat(sumByOptionalReduce).isEqualTo(17);

        final Optional<String> concatenatedNames = players.stream().map(player -> {
            final String[] namePart = player.getName().split(" ");
            if (namePart.length == 2) {
                return namePart[0] + " " + namePart[1].toUpperCase();
            } else {
                return player.getName();
            }
        }).reduce((a, b) -> a + ", " + b);
        out.println(concatenatedNames);

        assertThat(concatenatedNames).isPresent().hasValue("Cristiano RONALDO, Ali DAEI, Lionel MESSI, Sunil CHHETRI");
    }

    @Test
    void match_data() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // allMatch example: Check if all numbers are greater than 0
        boolean allGreaterThanZero = numbers.stream().allMatch(n -> n > 0);
        System.out.println("All greater than zero: " + allGreaterThanZero);

        // anyMatch example: Check if any number is equal to 3
        boolean anyEqualToThree = numbers.stream().anyMatch(n -> n == 3);
        System.out.println("Any equal to three: " + anyEqualToThree);

        // noneMatch example: Check if no number is greater than 10
        boolean noneGreaterThanTen = numbers.stream().noneMatch(n -> n > 10);
        System.out.println("None greater than ten: " + noneGreaterThanTen);

        assertThat(allGreaterThanZero).isTrue();
        assertThat(anyEqualToThree).isTrue();
        assertThat(noneGreaterThanTen).isTrue();
    }

    @Test
    void find_data() {
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "kiwi", "pear", "olive");
        final Optional<String> fruitStartWithO = fruits.stream().filter(fruit -> fruit.startsWith("o")).findAny();

        assertThat(fruitStartWithO).isPresent();

        // Assert that the result is one of the expected values
        assertThatCode(() -> assertThat(fruitStartWithO)
                .hasValueSatisfying(value -> assertThat(value).isIn("orange", "olive")))
                .doesNotThrowAnyException();

        final Optional<String> fruitStartWithP = fruits.stream().filter(fruit -> fruit.startsWith("p")).findFirst();

        assertThat(fruitStartWithP).isPresent().hasValue("pear");
    }
}
