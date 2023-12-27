package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class BiFunctionTest {
    @Test
    void should_take_two_arguments_and_return_a_result() {
        BiFunction<String, String, String> concatenate = (s1, s2) -> s1 + s2;
        String result = concatenate.apply("Hello ", "World!");

        assertThat(result).isEqualTo("Hello World!");
    }
}
