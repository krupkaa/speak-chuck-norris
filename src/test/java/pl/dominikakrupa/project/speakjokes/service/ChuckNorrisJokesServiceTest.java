package pl.dominikakrupa.project.speakjokes.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.dominikakrupa.project.speakjokes.api.chucknorrisjokes.ChuckNorrisJokesApiResponse;

import java.io.IOException;


class ChuckNorrisJokesServiceTest {

    @Test
    void run() throws IOException {
        //given
        ChuckNorrisJokesService service = new ChuckNorrisJokesService();

        //when
        String url = "https://api.chucknorris.io/jokes/random";
        String response = service.getResponse(url);

        //then
        Assertions.assertNotNull(response, "response is null");
    }

    @Test
    void convert() {
        //given
        ChuckNorrisJokesService service = new ChuckNorrisJokesService();

        //when
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = service.convert("{\n" +
                "\"icon_url\" : \"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\n" +
                "\"id\" : \"xjZ8xWi1TBOPZHsBl_CqRw\",\n" +
                "\"url\" : \"\",\n" +
                "\"value\" : \"Chuck Norris once ripped the eyeballs out of Great Horned Owl and wore them around as night vision goggles.\"\n" +
                "}");

        //then
        Assertions.assertNotNull(chuckNorrisJokesApiResponse, "response is null");
    }

    @Test
    void randomJoke() {
        //given
        ChuckNorrisJokesService service = new ChuckNorrisJokesService();

        //when
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = service.randomJoke();


        //then
        Assertions.assertNotNull(chuckNorrisJokesApiResponse);
    }
}