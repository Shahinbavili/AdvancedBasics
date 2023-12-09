package collection.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayListTest {

    @Test
    void array_List_Should_Be_Empty_When_created() {
        List<String> strings = new ArrayList<>();

        assertThat(strings).isEmpty();
    }

    @Test
    void should_Revers_A_List() {
//        Given
        List<String> animals = new ArrayList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Cat");
        animals.add("Cat");
        animals.add("Rabbit");
//When
        Collections.reverse(animals);
        List<String> reversedAnimal = new ArrayList<>();
        reversedAnimal.add("Rabbit");
        reversedAnimal.add("Cat");
        reversedAnimal.add("Cat");
        reversedAnimal.add("Cat");
        reversedAnimal.add("Dog");

//        Then

        assertThat(animals).isEqualTo(reversedAnimal);
        assertThat(reversedAnimal.indexOf("Cat")).isEqualTo(1);
        assertThat(reversedAnimal.lastIndexOf("Cat")).isEqualTo(3);
        assertThat(reversedAnimal.contains("Dog")).isTrue();

    }

    @Test
    void should_Be_Immutable() {
//        given
        List<String> animals = new ArrayList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Cat");
        animals.add("Cat");
        animals.add("Rabbit");
        List<String> unmodifiableAnimals = Collections.unmodifiableList(animals);
//when
        animals.add("Snack");
//      then
        assertThat(animals.size()).isEqualTo(6);
        assertThat(unmodifiableAnimals.size()).isEqualTo(6);
    }

    @Test
    void Given_an_array_return_an_ArrayList_of_the_appropriate_type_with_all_the_same_elements() {
//        Given
        int[] arrayNumbers = {1, 2, 3};

//        When
        Convertor convertor = new Convertor();
        List<Integer> arrayListNumbers = convertor.convertToArrayList(arrayNumbers);

//        Then
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
        assertThat(arrayListNumbers).isEqualTo(expectedList);
    }

    static class Convertor {

        public List<Integer> convertToArrayList(int[] arrayNumbers) {
            List<Integer> listNumbers = new ArrayList<>();
            for (int arrayNumber : arrayNumbers) {
                listNumbers.add(arrayNumber);
            }
            return listNumbers;
        }
    }
}
