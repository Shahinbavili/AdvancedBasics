package compare;

import khodro.Khodro;
import khodro.mashin.Mashin;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static khodro.mashin.Dande.AUTOMATIC;
import static org.assertj.core.api.Assertions.assertThat;

public class CompareMashinTest {
    @Test
    void should_Compare_Mashin() {
        Khodro bmw_1 = new Mashin("BMW", 150, AUTOMATIC);
        Khodro bmw_2 = new Mashin("BMW", 150, AUTOMATIC);


        assertThat(bmw_1.equals(bmw_2)).isTrue();
        assertThat(Objects.equals(bmw_1, bmw_2)).isTrue();
        assertThat(bmw_1).isEqualTo(bmw_2);
    }
}
