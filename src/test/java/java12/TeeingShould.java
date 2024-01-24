package java12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TeeingShould {
    @Test
    void perform_two_separate_operations_on_the_elements_of_a_stream_and_combine_their_results() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Using teeing to calculate sum and product of the numbers
        final TeeingResult result = numbers.stream()
                .collect(teeing(
                        summingInt(Integer::intValue), // Collector 1: Sum
                        reducing(1, (a, b) -> a * b), // Collector 2: Product
                        TeeingResult::new // Merger: Combine results into a custom object
                ));
        System.out.println("Sum: " + result.getSum());
        System.out.println("Product: " + result.getProduct());
        assertThat(result.getSum()).isEqualTo(15);
        assertThat(result.getProduct()).isEqualTo(120);

    }
}
