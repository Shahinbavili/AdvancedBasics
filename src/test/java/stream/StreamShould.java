package stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamShould {

    @Test
    void be_created() {
//        From Collections:
        List<String> myList = Arrays.asList("apple", "banana", "orange");
        Stream<String> streamFromList = myList.stream();

//        From Arrays:
        String[] array = {"apple", "banana", "orange"};
        Stream<String> streamFromArray = Arrays.stream(array);

//        Using Stream.of:
        Stream<String> streamOfValues = Stream.of("apple", "banana", "orange");

//        From a Range:
        IntStream intStream = IntStream.range(1, 5); // Generates integers from 1 to 4

        streamFromList.forEach(System.out::println);

    }
}
