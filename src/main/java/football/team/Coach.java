package football.team;

import java.util.Optional;

public class Coach {
    private Degree degree;

    public Optional<Degree> getDegree() {
        return Optional.ofNullable(degree);
    }
}
