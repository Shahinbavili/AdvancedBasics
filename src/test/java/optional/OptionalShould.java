package optional;

import football.team.Coach;
import football.team.Degree;
import football.team.Team;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalShould {
    //    null: Optional, Maybe
    @Test
    void avoid_null_related_problems() {
//        Before Java 8:
        final Team team = new Team();
        final Optional<Coach> coach = team.getCoach();
        if (coach.isPresent()) {
            final Optional<Degree> degree = coach.get().getDegree();
            if (degree.isPresent()) {
                final String value = degree.get().getValue();

                assertThat(value).isEqualTo(null);
            }
        }

    }
}
