package collection.map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    @Test
    void should_Sort_Elements() {
//        Given
        Map<String, String> geometrics = new TreeMap<>();
        geometrics.put("Triangle", "Red");
        geometrics.put("Rectangle", "Blue");
        geometrics.put("Circle", "Yellow");
        geometrics.put("Square", "Red");

//        When

//        Then
        Object[] key = geometrics.keySet().toArray();
        Assertions.assertThat(key[0]).isEqualTo("Circle");
        Assertions.assertThat(key[1]).isEqualTo("Rectangle");
        Assertions.assertThat(key[2]).isEqualTo("Square");
        Assertions.assertThat(key[3]).isEqualTo("Triangle");

    }

    @Test
    void should_Sort_Elements_In_Reversed_Order() {
//        Given
        Map<String, String> geometrics = new TreeMap<>(Comparator.reverseOrder());
        geometrics.put("Triangle", "Red");
        geometrics.put("Rectangle", "Blue");
        geometrics.put("Circle", "Yellow");
        geometrics.put("Square", "Red");

//        When

//        Then
        Object[] key = geometrics.keySet().toArray();
        Assertions.assertThat(key[0]).isEqualTo("Triangle");
        Assertions.assertThat(key[1]).isEqualTo("Square");
        Assertions.assertThat(key[2]).isEqualTo("Rectangle");
        Assertions.assertThat(key[3]).isEqualTo("Circle");

    }
}
