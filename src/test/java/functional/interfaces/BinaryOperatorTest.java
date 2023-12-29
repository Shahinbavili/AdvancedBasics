package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryOperatorTest {
    @Test
    void should_have_two_operands_and_the_only_one_result_all_of_the_same_type() {
        int a = 5;
        int b = 15;
        BinaryOperator<Integer> addition = Integer::sum;
        Integer applied = addition.apply(a, b);

        assertThat(applied).isEqualTo(20);
    }
}
