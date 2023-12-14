package compare;

import khodro.mashin.Mashin;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static khodro.mashin.Dande.MANUAL;
import static org.assertj.core.api.Assertions.assertThat;

public class CompareCollectionsTest {
    @Test
    void should_Compare_Non_Hash_Collections() {
        List<Object> mashinhaye_1 = new ArrayList<>();
        mashinhaye_1.add(new Mashin("Benz", 110, MANUAL));

        List<Object> mashinhaye_2 = new ArrayList<>();
        mashinhaye_2.add(new Mashin("Benz", 110, MANUAL));

        assertThat(mashinhaye_1.equals(mashinhaye_2)).isTrue();
    }

    @Test
    void should_compare_Hash_Collections() {
        Set<Object> mashinhaye_1 = new HashSet<>();
        mashinhaye_1.add(new Mashin("Benz", 110, MANUAL));

        Set<Object> mashinhaye_2 = new HashSet<>();
        mashinhaye_2.add(new Mashin("Benz", 110, MANUAL));

        assertThat(mashinhaye_1.equals(mashinhaye_2)).isTrue();
    }
}
