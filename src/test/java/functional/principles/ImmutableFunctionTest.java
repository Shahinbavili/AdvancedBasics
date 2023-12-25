package functional.principles;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ImmutableFunctionTest {
    @Test
    void should_never_be_changed_after_being_constructed() {
        final int var = 5;
        Operation operation = number -> number + var;
        final AddOperationTo addOperationTo = addOperationTo(2, operation);
        final int result = addOperationTo.apply();

        assertThat(result).isEqualTo(7);
    }

    private AddOperationTo addOperationTo(int number, Operation operation) {
        return () -> operation.applyOperation(number);
    }
}
