package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class PredicateTest {
    @Test
    void should_get_a_type_as_entry_and_return_a_boolean() {
        Predicate<String> isLongWord = (word) -> word.length() > 5;

        System.out.println("is 'hello' a long word? " + isLongWord.test("hello"));
        System.out.println("is 'hallelujah' a long word? " + isLongWord.test("hallelujah"));

        List<String> words = new ArrayList<>(Arrays.asList("Banana", "Apple", "Pineapple", "grapefruit", "Peach"));
        words.removeIf(isLongWord);
        System.out.println("Filtered words are: " + words);

        int var = 8;
        Predicate<Integer> isOdd = (integer) -> integer % 2 == 0;
        boolean result = isOdd.test(var);

        assertThat(result).isTrue();
    }
}
