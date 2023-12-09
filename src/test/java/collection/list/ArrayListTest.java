package collection.list;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayListTest {

    @Test
    void array_List_Should_Be_Empty_When_created() {
        List<String> strings = new ArrayList<>();

        assertThat(strings).isEmpty();
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
        Assertions.assertThat(arrayListNumbers).isEqualTo(expectedList);
    }

    class Convertor {

        public List<Integer> convertToArrayList(int[] arrayNumbers) {
            List<Integer> listNumbers = new ArrayList<>();
            for (int arrayNumber : arrayNumbers) {
                listNumbers.add(arrayNumber);
            }
            return listNumbers;
        }
    }
}
