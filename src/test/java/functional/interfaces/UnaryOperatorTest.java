package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

public class UnaryOperatorTest {
    @Test
    void should_has_the_same_type_as_entry_and_output() {
        int var = 4;
        UnaryOperator<Integer> power = integer -> integer * integer;
        Integer applied = power.apply(var);

        Assertions.assertThat(applied).isEqualTo(16);
    }
}
