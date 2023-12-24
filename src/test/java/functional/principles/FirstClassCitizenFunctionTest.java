package functional.principles;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstClassCitizenFunctionTest {
    //    In Java a function == a lambda expression
//    (parameter1, parameter2, ...) -> expression
//    () -> expression
    @Test
    void should_be_passed_as_method_parameter() {
        List<String> players = getPlayers();
        Collections.sort(players, getStringComparator());

        assertPlayersSort(players);
    }


    @Test
    void should_be_passed_as_value_to_a_variable() {
        List<String> players = getPlayers();
        final Comparator<String> variable = (a, b) -> a.compareTo(b);
        Collections.sort(players, variable);

        assertPlayersSort(players);

    }

    @Test
    void should_be_returned_from_a_method() {
        List<String> players = getPlayers();
        final Comparator<String> variable = getStringComparator();
        Collections.sort(players, variable);

        assertPlayersSort(players);
    }

    private static Comparator<String> getStringComparator() {
        return (a, b) -> a.compareTo(b);
    }

    private static List<String> getPlayers() {
        List<String> players = new ArrayList<>();
        players.add("Ronaldo");
        players.add("Abedzadeh");
        players.add("Majidi");
        return players;
    }

    private static void assertPlayersSort(List<String> players) {
        assertThat(players.get(0)).isEqualTo("Abedzadeh");
        assertThat(players.get(1)).isEqualTo("Majidi");
        assertThat(players.get(2)).isEqualTo("Ronaldo");
    }
}
