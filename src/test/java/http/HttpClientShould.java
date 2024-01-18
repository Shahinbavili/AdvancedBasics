package http;

import com.google.gson.Gson;
import football.player.Player;
import football.player.Players;
import football.player.ResponseStatus;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static java.lang.System.out;
import static java.util.stream.Collectors.toUnmodifiableList;
import static org.assertj.core.api.Assertions.assertThat;

public class HttpClientShould {
    @Test
    void call_a_webserver_and_request_information() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://shahin.free.beeceptor.com/players"))
                .build();

        final HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        final String body = response.body();

        final Gson gson = new Gson();
        final Players players = gson.fromJson(body, Players.class);
        players.getPlayers().forEach(out::println);

        final List<Player> bestScorers = players.getPlayers()
                .stream().filter(player -> player.getGoal() > 120).collect(toUnmodifiableList());
        assertThat(bestScorers).contains(new Player("Cristiano Ronaldo", 128));
    }

    @Test
    void send_a_request_to_add_a_player() throws Exception {
        String player = new Gson().toJson(new Player("Kylian Mbappé", 46));
        out.println(player);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://shahin.free.beeceptor.com/players/add"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(player))
                .build();

        final HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        final String body = response.body();

        final Gson gson = new Gson();
        final ResponseStatus responseStatus = gson.fromJson(body, ResponseStatus.class);

        assertThat(responseStatus.getStatus()).isEqualTo("200");
    }
}
