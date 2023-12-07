import foroushande.Foroushande;
import khodro.Khodro;
import khodro.mashin.Mashin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

public class ForoushandeMashinTest {
    @Test
    void Bayad_Tedade_Kol_Mashinhaye_foroukhte_Shode_Ra_Bedast_Avarim() {
        Foroushande ali = new Foroushande();
        Foroushande nasser = new Foroushande();

        ali.foroushMashin();
        ali.foroushMashin();
        ali.foroushMashin();
        ali.foroushMashin();
        nasser.foroushMashin();


        Assertions.assertEquals(5, Mashin.tedadForoush);
    }

    public static class NamKhodroChapKon {
        Khodro[] khodroha;

        public NamKhodroChapKon(Khodro[] khodroha) {
            this.khodroha = khodroha;
        }

        public String execute() {
            StringJoiner namKhodroha = new StringJoiner("-");
            for (int i = 0; i < khodroha.length; i++) {
                Khodro khodro = khodroha[i];
                namKhodroha.add(khodro.getMark());
            }
            return namKhodroha.toString();
        }
    }
}
