package optional;

import football.team.Coach;
import football.team.Degree;
import football.team.Team;
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
}
