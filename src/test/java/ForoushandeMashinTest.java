import foroushande.Foroushande;
import khodro.Mashin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
