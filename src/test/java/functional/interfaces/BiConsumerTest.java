package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerTest {
    @Test
    void should_take_two_arguments_and_perform_a_specific_action_without_returning_any_result() {
        BiConsumer<String, Integer> printKeyValue = (key, value) ->
                System.out.println("the key is " + key + " & value is " + value);

        printKeyValue.accept("Julie", 20);

        Map<String, Integer> studentScors = new HashMap<>();
        studentScors.put("Alice", 19);
        studentScors.put("Thomas", 14);
        studentScors.put("Malo", 15);

        studentScors.forEach(printKeyValue);
    }
}
