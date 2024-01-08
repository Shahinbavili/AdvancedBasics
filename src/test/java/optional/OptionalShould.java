package optional;

import football.team.Coach;
import football.team.Degree;
import football.team.Team;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OptionalShould {
    //    null: Optional, Maybe
    @Test
    void avoid_null_related_problems() {
        final Team team = new Team(new Coach(new Degree("A")));

//        Before Java 8:
        final Optional<Coach> coach = team.getCoach();
        if (coach.isPresent()) {
            final Optional<Degree> degree = coach.get().getDegree();
            if (degree.isPresent()) {
                final String value = degree.get().getValue();

                assertThat(value).isEqualTo("A");
            }
        }
//    From Java 8 :
        final Optional<String> value = team.getCoach()
                .flatMap(Coach::getDegree)
                .map(Degree::getValue);
        value.ifPresent(out::println);

        assertThat(value).hasValue("A");
    }

    @Test
    void be_created() {
        String name = "Albert";
        assertThat(Optional.of(name).get()).isEqualTo("Albert");

        String otherName = null;
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> Optional.of(otherName));

//        assertThat(Optional.of(otherName).get()).isEqualTo(null); NPE !

        assertThat(Optional.ofNullable(otherName)).isEmpty(); //No NPE
    }

    @Test
    void have_default_values() {
//        Cautions: if our default value use a function, is better to use orElseGet to benefice the
//        lazy loading concept and avoid the bugs
//        for juste a variable as default value is no problem to use orElse
        String name = "Raphaël";
        out.println("orElse case:");
        final String result1 = Optional.ofNullable(name).orElse(getDefaultName());

        out.println(result1);

        out.println("orElseGet case:");
        final String result2 = Optional.ofNullable(name).orElseGet(this::getDefaultName);

        out.println(result2);
    }

    @Test
    void handle_errors() {
        String name = null;
        final ThrowingCallable result = () -> Optional.ofNullable(name)
                .orElseThrow(() -> new IllegalArgumentException("Name can not to be null"));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(result);
    }

    private String getDefaultName() {
        out.println("Default name called!");
        return "No name is provided";
    }
}
