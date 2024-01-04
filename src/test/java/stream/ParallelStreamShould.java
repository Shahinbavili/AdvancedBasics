package stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class ParallelStreamShould {
    @Test
    void be_unpredictable() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Sequential stream
        out.println("\nSequential stream result is: ");
        numbers.stream().
                forEach(out::print);

        // Parallel stream
        out.println("\nParallel stream result is: ");
        numbers.parallelStream()
                .forEach(out::print);
        out.println("\n");

        // Sequential stream
        long sequentialSum = numbers.stream()
                .reduce(0, Integer::sum);
        out.println("sequential Sum is : " + sequentialSum);

        // Parallel stream
        long parallelSum = numbers.parallelStream()
                .reduce(0, Integer::sum);
        out.println("parallel Sum is : " + parallelSum);

        // Sequential stream
        long sequentialSumWithIdentity = numbers.stream()
                .reduce(5, Integer::sum);
        out.println("sequential Sum with Identity is : " + sequentialSumWithIdentity);

        // Parallel stream
        long parallelSumWithIdentity = numbers.parallelStream()
                .reduce(5, Integer::sum);
        out.println("parallel Sum with Identity is : " + parallelSumWithIdentity);
    }
}
