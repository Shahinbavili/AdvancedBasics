package java16;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordShould {
    @Test
    void be_immutable() {
        final Person person = new Person("John", 43);

        assertThat(person.name()).isEqualTo("John");
        assertThat(person.age()).isEqualTo(43);
        assertThat(person).hasToString("Person[name=John, age=43]");
    }
}
