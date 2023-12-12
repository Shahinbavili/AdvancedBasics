package collection.set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    @Test
    void should_Remove_Duplication() {
        Set<String> animals = new HashSet<>();
        animals.add("Monkey");
        animals.add("Zebra");
        animals.add("Elephant");
        animals.add("Elephant");
        animals.add("Elephant");
        animals.add("Crocodile");
        animals.add("Lion");

        Set<String> expectedAnimals = new HashSet<>();
        expectedAnimals.add("Monkey");
        expectedAnimals.add("Zebra");
        expectedAnimals.add("Elephant");
        expectedAnimals.add("Crocodile");
        expectedAnimals.add("Lion");

        Assertions.assertThat(animals).isEqualTo(expectedAnimals);

        for (String animal : animals) {
            System.out.println(animal);
        }
    }
}
