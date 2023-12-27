package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToDoubleFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimitiveFunctionTest {
    @Test
    void should_get_a_primitive_type_as_entry() {
        int v = 5;
        IntFunction<String> toString = String::valueOf;
        String result = toString.apply(v);

        assertThat(result).isEqualTo("5");
    }

    @Test
    void should_return_a_primitive_type_for_given_any_type() {
        String s = "402";
        ToDoubleFunction<String> toDouble = Integer::parseInt;
        double result = toDouble.applyAsDouble(s);

        assertThat(result).isEqualTo(402);
    }

    @Test
    void should_give_a_primitive_as_input_and_output() {
        int var = 156;
        IntToLongFunction intToLong = Long::valueOf;
        long result = intToLong.applyAsLong(var);

        IntUnaryOperator increment = x -> x + 1;
        int plus = increment.applyAsInt(5);

        assertThat(result).isEqualTo(156L);
        assertThat(plus).isEqualTo(10);
    }
}
