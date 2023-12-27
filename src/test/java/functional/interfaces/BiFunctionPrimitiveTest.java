package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongBiFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class BiFunctionPrimitiveTest {
    @Test
    void should_two_arguments_and_produce_a_primitive_result() {
        ToIntBiFunction<String, String> lengthSum = (s1, s2) -> s1.length() + s2.length();
        int result = lengthSum.applyAsInt("Hello ", "World!");

        assertThat(result).isEqualTo(12);

        ToLongBiFunction<Long, Integer> sum = Long::sum;
        long longSum = sum.applyAsLong(10L, 47);

        assertThat(longSum).isEqualTo(57L);

        ToDoubleBiFunction<Integer, Double> product = (num1, num2) -> num1 * num2;
        double result2 = product.applyAsDouble(5, 3.0);

        assertThat(result2).isEqualTo(15.0);

    }
}
