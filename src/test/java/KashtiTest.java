import khodro.Kashti;
import khodro.Khodro;
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
}
