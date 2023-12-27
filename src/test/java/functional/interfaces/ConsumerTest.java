package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {
    @Test
    void should_take_a_given_type_parameter_and_perform_a_specific_action() {
        Consumer<String> printUpperCase = (s) -> System.out.println(s.toUpperCase());
        printUpperCase.accept("may name is shahin");


        List<String> fruits = new LinkedList<>();
        fruits.add("banana");
        fruits.add("orange");
        fruits.add("apple");
        fruits.forEach(printUpperCase);

    }
}
