package functional.principles;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PureFunctionTest {
    @Test
    void should_depends_only_on_his_own_parameters() {
        PureMethod pureMethod = new PureMethod();
        final int sum = pureMethod.pureMethod(2, 3);

        assertThat(sum).isEqualTo(5);

        ImpureMethod impureMethod = new ImpureMethod();
        final int sum2 = impureMethod.impureMethod(2);
        final int sum3 = impureMethod.impureMethod(5);

        Assertions.assertThat(sum2).isEqualTo(2);
        Assertions.assertThat(sum3).isEqualTo(7);
    }

    @Test
    void should_not_have_any_side_effect() {
        ImpureMethod impureMethod = new ImpureMethod();
        int result = impureMethod.sum(2, 1);
        int effectedVariable = impureMethod.v;

        Assertions.assertThat(result).isEqualTo(3);
        Assertions.assertThat(effectedVariable).isNotEqualTo(0);


    }
}
