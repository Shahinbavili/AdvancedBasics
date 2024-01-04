package stream.primitive;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeNumbersTest {
    @Test
    void should_find_prime_number() {
        final PrimeNumbers primeNumbers = new PrimeNumbers();

        assertThat(primeNumbers.isPrime(2)).isTrue();
        assertThat(primeNumbers.isPrime(4)).isFalse();
        assertThat(primeNumbers.isPrime(1)).isFalse();
        assertThat(primeNumbers.isPrime(17)).isTrue();
        assertThat(primeNumbers.isPrime(18)).isFalse();

    }

    //    Implement PrimeNumber Class
    @Test
    void should_find_all_prime_numbers_up_to_a_limit() {
        final PrimeNumbers primeNumbers = new PrimeNumbers();
        List<Integer> actualPrimeNumbers = primeNumbers.calculate(30);

        assertThat(actualPrimeNumbers).containsExactly(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
    }
}
