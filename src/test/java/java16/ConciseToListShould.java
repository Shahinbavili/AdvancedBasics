package java16;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ConciseToListShould {
    @Test
    void collect_to_list_in_a_more_concise_syntax() {
        List<Integer> multiplyByTwo = IntStream.range(0, 10)
                .boxed()
                .map(integer -> integer * 2)
                .toList();

        assertThat(multiplyByTwo).isEqualTo(List.of(0, 2, 4, 6, 8, 10, 12, 14, 16, 18));
    }
}
