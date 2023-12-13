package collection.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    @Test
    void hashMap_Should_Have_Unique_Keys_And_Can_Duplicated_Values() {
        // Creating a HashMap to store geometrical shapes and their colors
        Map<String, String> geometrics = new HashMap<>();
        geometrics.put("Triangle", "Red");
        geometrics.put("Rectangle", "Blue");
        geometrics.put("Circle", "Yellow");
        geometrics.put("Square", "Red");

        Set<Map.Entry<String, String>> entries = geometrics.entrySet();
        // Iterating over the entries and printing key-value pairs
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("The key is " + key + " And its value is " + value + ".");
        }
    }

    @Test
    void linkedHashMap_Should_Sort_Insertion_Order() {
        // Creating a LinkedHashMap to store geometrical shapes and their colors
        Map<String, String> geometrics = new LinkedHashMap<>();
        geometrics.put("Triangle", "Red");
        geometrics.put("Rectangle", "Blue");
        geometrics.put("Circle", "Yellow");
        geometrics.put("Square", "Red");

        Set<Map.Entry<String, String>> entries = geometrics.entrySet();
        // Iterating over the entries and printing key-value pairs
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("The key is " + key + " And its value is " + value + ".");
        }
    }
}
