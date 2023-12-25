package functional.principles;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecursiveFunctionTest {
    @Test
    void should_call_itself() {
        int limit = 5;

        Assertions.assertThat(iterativeSum(limit)).isEqualTo(15);
        Assertions.assertThat(recursiveSum(limit)).isEqualTo(15);
        Assertions.assertThat(tailRecursiveSum(0, limit)).isEqualTo(15);
    }

    private int tailRecursiveSum(int total, int n) {
        if (n == 0) {
            return total;
        }
        return tailRecursiveSum(total + n, n - 1);
    }

    private int recursiveSum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + recursiveSum(n - 1);
    }

    private int iterativeSum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
