import khodro.mashin.Dande;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;

public class DandeTest {
    @Test
    void print_All_Dande_Values() {
        Dande.print();
    }

    @Test
    void print_All_Dande_Values_In_Persian() {
        out.println("In Persian: ");
        Dande.printInPersian();
    }

    @Test
    void print_All_Dande_Values_In_French() {
        out.println("In French: ");
        Dande.printInFrench();
    }
}
