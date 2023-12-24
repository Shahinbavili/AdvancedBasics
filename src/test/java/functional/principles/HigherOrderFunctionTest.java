package functional.principles;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HigherOrderFunctionTest {
    @Test
    void should_take_one_or_more_function_as_parameter_and_return_a_function() {
//        each Interface in java that has only one abstract method can be considered as a functional Interface
//        SAM : Single Abstract Method
        Operation operation = number -> number + 5;
        final int result = addOperationTo(2, operation);

        assertThat(result).isEqualTo(7);

    }

    private int addOperationTo(int number, Operation operation) {
        return operation.applyOperation(number);
    }

    @FunctionalInterface
    interface Operation {
        int applyOperation(int number);

        default int anotherOperation(int number) {
            return 0;
        }
    }
}
