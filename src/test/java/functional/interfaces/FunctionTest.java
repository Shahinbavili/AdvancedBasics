package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTest {
    @Test
    void should_get_an_entry_and_produce_an_output() {
//        given
        Map<String, Integer> map = new HashMap<>();
//        when
        Function<? super String, Integer> function = String::length;
        final Integer result = map.computeIfAbsent("Shahin", function);
//        then
        assertThat(result).isEqualTo(6);
    }
}
