package collection.set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    @Test
    void hashSet_Should_Remove_Duplication() {
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

    @Test
    void linkedHashSet_Should_Maintain_Insertion_Order() {
        Set<String> animals = new LinkedHashSet<>();
        animals.add("Monkey");
        animals.add("Zebra");
        animals.add("Elephant");
        animals.add("Crocodile");
        animals.add("Lion");

        for (String animal : animals) {
            System.out.println(animal);
        }
    }

    @Test
    void treeSet_Should_Sort_Data() {
        Set<String> animals = new TreeSet<>();
        animals.add("Monkey");
        animals.add("Zebra");
        animals.add("Elephant");
        animals.add("Elephant");
        animals.add("Elephant");
        animals.add("Crocodile");
        animals.add("Lion");

        for (String animal : animals) {
            System.out.println(animal);
        }
    }
}
