package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.IntFunction;

public class PrimitiveFunctionTest {
    @Test
    void should_get_a_primitive_type_as_entry() {
        int v = 5;
        IntFunction<String> toString = String::valueOf;
        String result = toString.apply(v);

        Assertions.assertThat(result).isEqualTo("5");
    }
}
