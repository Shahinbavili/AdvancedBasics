package khodro;

import khodro.Ranande;
import org.junit.jupiter.api.Test;

public class RanandeTest {
    @Test
    void Bayad_Noe_Gavahiname_Va_Nam_Ranande_Ra_Chap_Konad() {
        Ranande ranande = new Ranande();
        Ranande.Gavahiname gavahiname = ranande.new Gavahiname();
        gavahiname.chapKon();
    }

    @Test
    void Bayad_Nam_ranande_ra_Chap_Konad() {
        Ranande.StaticGavahiname staticGavahiname = new Ranande.StaticGavahiname();
        staticGavahiname.chapKon();
    }
}
