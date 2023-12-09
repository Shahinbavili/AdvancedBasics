package khodro;

import khodro.mashin.Dande;
import khodro.mashin.Mashin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NamKhodroChapKonTest {
    @Test
    void bayad_nam_khodro_ra_chap_konad() {
//        Given
        Khodro benz = new Mashin("Benz", 120, Dande.AUTOMATIC);
        Khodro volvo = new Mashin("Volvo", 100, Dande.MANUAL);
        Khodro motor = new Motor();
        Khodro kashti = new Kashti();
        Khodro[] khodroha = {benz, volvo, motor, kashti};
        ForoushandeMashinTest.NamKhodroChapKon namKhodroChapKon = new ForoushandeMashinTest.NamKhodroChapKon(khodroha);

//        When
        String listNamKhodroha = namKhodroChapKon.execute();

//        Then
        Assertions.assertEquals("Benz-Volvo-Motor-Kashti", listNamKhodroha);
    }
}
