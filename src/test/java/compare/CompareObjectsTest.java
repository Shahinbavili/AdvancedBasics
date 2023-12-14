package compare;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareObjectsTest {
    @Test
    void should_Compare_Primitives_Objects() {
        assertThat(1 == 1).isTrue();
        assertThat(1 != 2).isTrue();
    }

    @Test
    void should_Compare_Non_Primitives_Objects() {
        String shahin1 = new String("Shahin");
        String shahin2 = new String("Shahin");

        assertThat(shahin1 == shahin2).isFalse();
        assertThat(shahin1).isEqualTo(shahin2);
        assertThat(shahin1.equals(shahin2)).isTrue();
        String shahin3 = new String("SHAHIN");
        assertThat(shahin1.equalsIgnoreCase(shahin3)).isTrue();
    }

    @Test
    void should_Handle_Null_Objects() {
        String shah1 = null;
        String shah2 = "Shahin";

//        assertThat(shah1.equals(shah2)).isFalse(); //Not supports Null values.

        assertThat(Objects.equals(shah1, shah2)).isFalse();
    }
}
