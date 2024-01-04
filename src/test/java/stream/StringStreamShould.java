package stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

public class StringStreamShould {
    @Test
    void join_strings() {
        final List<String> names = Arrays.asList("Michel", "Raphaël", "Gabriel");
        final String joinedNames = names.stream().collect(joining("], [", "[", "]"));

        assertThat(joinedNames).isEqualTo("[Michel], [Raphaël], [Gabriel]");
    }
}
