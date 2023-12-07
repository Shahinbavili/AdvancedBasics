import khodro.mashin.Dande;
import khodro.mashin.Mashin;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;

public class MashinTest {
    @Test
    void bayad_Print_Konad() {
        Mashin mashin = new Mashin("Peugeot", 76, Dande.AUTOMATIC);
        out.println(mashin);
}
}
