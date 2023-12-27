package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class SupplierTest {
    @Test
    void should_return_a_result_with_a_given_type_for_no_entry_arguments() {
        Supplier<Double> randomSupplier = Math::random;
        double result = randomSupplier.get();

        assertThat(result).isBetween(0.0, 1.0);

        BooleanSupplier isJavaFunSupplier = () -> true;
        boolean asBoolean = isJavaFunSupplier.getAsBoolean();
        System.out.println("is Java Fun? " + asBoolean);

        assertThat(asBoolean).isTrue();
    }
}
