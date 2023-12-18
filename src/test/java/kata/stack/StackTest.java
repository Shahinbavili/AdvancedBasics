package kata.stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StackTest {
    private Stack stack;

    @BeforeEach
    public void init() {
        stack = new Stack(5);
    }

    @Test
    void newly_Created_Stacks_Should_Be_Empty() {
        assertThat(stack.getSize()).isEqualTo(0);
    }

    @Test
    void after_one_push_stack_size_should_be_one() {
        stack.push("A");
        assertThat(stack.getSize()).isEqualTo(1);
    }

    @Test
    void after_one_push_and_one_pop_stack_should_be_empty() {
        stack.push("A");
        stack.pop();
        assertThat(stack.getSize()).isEqualTo(0);
    }

    @Test
    void when_pushed_passed_limit_throw_stack_overflows_exception() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");

        Assertions.assertThatExceptionOfType(StackOverflowException.class)
                .isThrownBy(() -> stack.push("F"));
    }
}
