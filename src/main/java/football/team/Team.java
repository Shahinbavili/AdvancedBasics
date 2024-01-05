package football.team;

import java.util.Optional;

public class Team {
    private Coach coach;

    public Optional<Coach> getCoach() {
        return Optional.ofNullable(coach);
    }
}
