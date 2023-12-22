package generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GenericsTest {
    @Test
    void should_works_but_has_errors_in_runtime() {
        List list = new ArrayList();
        list.add(10);
        list.add("10");

//        assertThat((Integer) list.get(0)).isNotNull(); //gives error in runtime
        assertThat((Integer) list.get(0)).isNotNull();
    }

    @Test
    void should_works() {
        List<Integer> list = new ArrayList<>();
        list.add(5);

        final Integer[] integers = list.toArray(new Integer[0]);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
