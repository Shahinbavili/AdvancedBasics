package java12;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;

public class FileShould {
    @Test
    void compare_files() throws Exception {
        Path pathFile1 = Path.of(requireNonNull(getClass().getClassLoader().getResource("file1.txt")).toURI());
        Path pathFile2 = Path.of(requireNonNull(getClass().getClassLoader().getResource("file2.txt")).toURI());
        Path pathFile3 = Path.of(requireNonNull(getClass().getClassLoader().getResource("file3.txt")).toURI());

        assertThat(Files.mismatch(pathFile1, pathFile2)).isEqualTo(-1);
        assertThat(Files.mismatch(pathFile1, pathFile3)).isEqualTo(6);
    }
}
