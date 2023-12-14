package compare;

import khodro.Khodro;
import khodro.mashin.Mashin;
import khodro.mashin.MashinComparator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static khodro.mashin.Dande.AUTOMATIC;
import static khodro.mashin.Dande.MANUAL;
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

    @Test
    void should_Sort_Mashins() {
        Mashin bmw_1 = new Mashin("BMW", 120, AUTOMATIC);
        Mashin bmw_2 = new Mashin("PEUGEOT", 100, MANUAL);
        Mashin bmw_3 = new Mashin("Benz", 100, AUTOMATIC);
        Mashin bmw_4 = new Mashin("RENAULT", 50, MANUAL);

        List<Mashin> mashinha = new ArrayList<>();
        mashinha.add(bmw_1);
        mashinha.add(bmw_2);
        mashinha.add(bmw_3);
        mashinha.add(bmw_4);

        Collections.sort(mashinha);

        List<Mashin> expectedMashins = new ArrayList<>();
        expectedMashins.add(bmw_4);
        expectedMashins.add(bmw_2);
        expectedMashins.add(bmw_3);
        expectedMashins.add(bmw_1);

        assertThat(mashinha).isEqualTo(expectedMashins);


    }

    @Test
    void should_Sort_Mashins_By_Mrak() {
        Mashin bmw = new Mashin("BMW", 120, AUTOMATIC);
        Mashin peugeot = new Mashin("PEUGEOT", 100, MANUAL);
        Mashin benz = new Mashin("BENZ", 100, AUTOMATIC);
        Mashin renault = new Mashin("RENAULT", 50, MANUAL);

        List<Mashin> mashins = new ArrayList<>();
        mashins.add(bmw);
        mashins.add(peugeot);
        mashins.add(benz);
        mashins.add(renault);

        Collections.sort(mashins, new MashinComparator());

        List<Mashin> expectedMashins = new ArrayList<>();
        expectedMashins.add(benz);
        expectedMashins.add(bmw);
        expectedMashins.add(peugeot);
        expectedMashins.add(renault);

        assertThat(mashins).isEqualTo(expectedMashins);


    }
}
