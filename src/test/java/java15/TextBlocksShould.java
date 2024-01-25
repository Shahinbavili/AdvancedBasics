package java15;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextBlocksShould {
    //    String blocks
    @Test
    void use_triple_double_quotes() {
        String message = """
                Hello,
                This is a text block with a tab character (\\t) in Java.
                \tIt makes multiline string handling easier.
                """;
//       we can use text blocks for html tags.
        System.out.println(message);

        assertThat(message)
                .isEqualTo("Hello,\nThis is a text block with a tab character (\\t) in Java.\n\tIt makes multiline string handling easier.\n");
    }
}
