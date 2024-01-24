package java14;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnhancedSwitchShould {
    @Test
    void use_switch_expressions() {
        final SwitchExpressions switchExpressions = new SwitchExpressions();
        final String day3 = switchExpressions.dayType(3);
        final String day7 = switchExpressions.dayType(7);

        assertThat(day3).isEqualTo("Weekday");
        assertThat(day7).isEqualTo("Weekend");


    }
}
