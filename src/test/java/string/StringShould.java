package string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toUnmodifiableList;

public class StringShould {
    @Test
    void split_a_string_line_by_line() {
        String s = "\t line 1 \u2005 \n line 2 \r        \n line 3 \r\n line 4 \n line 5";
        final List<String> lines = s.lines()
//                .filter(line -> !line.isBlank())
                .filter(Predicate.not(String::isBlank))
                .map(String::strip)
                .collect(toUnmodifiableList());

        final String[] stringsArray = lines.toArray(String[]::new);

        Assertions.assertThat(lines).containsExactly("line 1", "line 2", "line 3", "line 4", "line 5");
        Assertions.assertThat(stringsArray).containsExactly("line 1", "line 2", "line 3", "line 4", "line 5");
    }
}
