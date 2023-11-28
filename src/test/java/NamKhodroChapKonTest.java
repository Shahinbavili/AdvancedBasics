import khodro.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NamKhodroChapKonTest {
    @Test
    void bayad_nam_khodro_ra_chap_konad() {
//        Given
        Khodro benz = new Mashin("Benz", 120, "Automatic");
        Khodro volvo = new Mashin("Volvo", 100, "Manuelle");
        Khodro motor = new Motor();
        Khodro kashti = new Kashti();
        Khodro[] khodroha = {benz, volvo, motor, kashti};
        NamKhodroChapKon namKhodroChapKon = new NamKhodroChapKon(khodroha);

//        When
        String listNamKhodroha = namKhodroChapKon.execute();

//        Then
        Assertions.assertEquals("Benz-Volvo-Motor-Kashti", listNamKhodroha);
    }
}
