package optional;

import football.team.Coach;
import football.team.Degree;
import football.team.Team;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;

public class OptionalShould {
    //    null: Optional, Maybe
    @Test
    void avoid_null_related_problems() {
//        Before Java 8:
        final Team team = new Team();
        final Coach coach = team.getCoach();
        if (coach != null) {
            final Degree degree = coach.getDegree();
            if (degree != null) {
                final String value = degree.getValue();

                out.println(value);
            }
        }

    }
}
