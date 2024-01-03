package stream;

import footbal.player.PlayerTestHelper;
import football.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.lang.System.out;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class IntermediateOperationShould {
    private List<Player> players;

    @BeforeEach
    void setUp() {
        players = new PlayerTestHelper().getPlayers();

    }

    @Test
    void filter_data() {
        final List<Player> aliDaei = new LinkedList<>();
        aliDaei.add(new Player("Ali Daei", 109));

        Predicate<? super Player> topScorer = player -> player.getGoal() > 100;
        Predicate<? super Player> nameIsAli = player -> player.getName().contains("Ali");
        final List<Player> topScorerWhereNameContainsAli = players.stream()
                .filter(topScorer)
                .peek(out::println)
                .filter(nameIsAli)
                .collect(toList());

        assertThat(topScorerWhereNameContainsAli).isEqualTo(aliDaei);
    }

    @Test
    void map_data() {
        List<Integer> expectedArray = Arrays.asList(6, 5, 9, 6);

        List<String> words = Arrays.asList("Banana", "Apple", "Pineapple", "Orange");
        final List<Integer> lengths = words.stream().map(String::length)
                .collect(toList());

        assertThat(lengths).isEqualTo(expectedArray);

        final List<String> expectedNames = new LinkedList<>();
        expectedNames.add("Cristiano Ronaldo");
        expectedNames.add("Ali Daei");
        expectedNames.add("Lionel Messi");
        expectedNames.add("Sunil Chhetri");

        Function<? super Player, ?> function = Player::getName;
        final List<?> playerNames = players.stream()
                .map(function)
                .collect(toList());

        assertThat(playerNames).isEqualTo(expectedNames);
    }

    @Test
    void sort_data() {
        final List<Integer> sortedScorerGoals = players.stream()
                .map(Player::getGoal)
                .sorted()
                .collect(toList());

        final List<Integer> expectedGoals = new LinkedList<>();
        expectedGoals.add(93);
        expectedGoals.add(106);
        expectedGoals.add(109);
        expectedGoals.add(128);

        assertThat(sortedScorerGoals).isEqualTo(expectedGoals);

    }

    @Test
    void reversed_sort_data() {
        final List<Integer> reversedSortedScorerGoals = players.stream()
                .map(Player::getGoal)
                .sorted(reverseOrder())
                .collect(toList());

        final List<Integer> expectedGoals = new LinkedList<>();
        expectedGoals.add(128);
        expectedGoals.add(109);
        expectedGoals.add(106);
        expectedGoals.add(93);

        assertThat(reversedSortedScorerGoals).isEqualTo(expectedGoals);

    }

    @Test
    void limit_and_skip_data() {
        final List<Integer> sortedScorerGoals = players.stream()
                .map(Player::getGoal)
                .sorted()
                .skip(3)
                .limit(1)
                .collect(toList());

        final List<Integer> limitedAndSkippedExpectedGoals = new LinkedList<>();
        limitedAndSkippedExpectedGoals.add(128);

        assertThat(sortedScorerGoals).isEqualTo(limitedAndSkippedExpectedGoals);
    }

    @Test
    void be_lazy() {
        final List<Integer> goals = players.stream()
                .map(Player::getGoal)
                .peek(out::println)
                .filter(goal -> goal < 50)
                .peek(goal -> out.println("never happen"))
                .collect(toList());

        assertThat(goals).isEmpty();
    }
}
