package pl.dominikakrupa.project.speakjokes.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.dominikakrupa.project.speakjokes.api.chucknorrisjokes.ChuckNorrisJokesApiResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChuckNorrisJokesServiceSpringTest {

    @Autowired
    ChuckNorrisJokesService chuckNorrisJokesService;

    @Test
    void randomJoke() {
        //given
        // ... NOTE: injected by Spring using @Autowired

        //when
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesService.randomJoke();

        //then
        Assertions.assertNotNull(chuckNorrisJokesApiResponse, "response is NULL");
    }


    @Test
    void getResponse() throws IOException {
        //given
        // ... NOTE: injected by Spring using @Autowired
        String url = "https://api.chucknorris.io/jokes/random";

        //when
        String response = chuckNorrisJokesService.getResponse(url);

        //then
        Assertions.assertNotNull(response);
    }
}