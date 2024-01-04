package stream.primitive;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class PrimeNumbers {
    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
//       *******************************************************
//        without using functional programming and Stream :
//        for (int i = 2; i < number; i++) {
//            if (number % i == 0) {
//                return false;
//            }
//        }
//         return true;
//        *******************************************************

//        with primitive stream:
        return IntStream.range(2, number)
                .noneMatch(i -> number % i == 0);
    }

    public List<Integer> calculate(int limit) {
        return IntStream.range(2, limit)
                .boxed()
                .filter(this::isPrime)
                .collect(toList());
    }
}
