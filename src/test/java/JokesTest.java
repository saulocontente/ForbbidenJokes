import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class JokesTest {

    private String url = "https://api.jokes.one";
    private String resourceEndpointJod = "/jod";

    @Test
    public void getJokeOfToday() {
        ExtractableResponse<Response> extracted =
                when()
                .get(url+resourceEndpointJod)
                .then()
                .statusCode(200)
                .extract()
        ;
        List<String> jokeOfDay = extracted.path("contents.jokes.joke.text");
        System.out.println(jokeOfDay);
    }
}
