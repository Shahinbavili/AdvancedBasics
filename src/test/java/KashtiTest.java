import khodro.Kashti;
import khodro.Khodro;
import khodro.Mashin;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;

public class KashtiTest {
    @Test
    void protected_method() {
        Khodro kashti = new Kashti();

        kashti.ayaDarHalHarekatAst();
    }

    @Test
    void super_keyword() {
        Khodro kashti = new Kashti();
        out.println(kashti.toString());
    }

    @Test
    public void this_keyword() {
        Kashti kashti = new Kashti();
        Mashin mashin = new Mashin("Zhian", 25, "Manual");

        kashti.printReference();
        kashti.printReferenceObject(this);
        kashti.printReferenceObject(mashin);
    }


}
