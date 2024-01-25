package java15;

import org.junit.jupiter.api.Test;

public class NPEShould {
    @Test
    void be_helpful() {
        String s = null;
//        s.isBlank(); //NPE is enhanced now

    }
}
