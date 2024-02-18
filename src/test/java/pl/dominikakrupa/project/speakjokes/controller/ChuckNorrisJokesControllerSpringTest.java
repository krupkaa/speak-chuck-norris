package pl.dominikakrupa.project.speakjokes.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.dominikakrupa.project.speakjokes.api.chucknorrisjokes.ChuckNorrisJokesApiResponse;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChuckNorrisJokesControllerSpringTest {

    @Autowired
    ChuckNorrisJokesController chuckNorrisJokesController;

    @Test
    void randomJoke() {
        //given
        // ... NOTE: injected by Spring using @Autowired

        //when
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesController.randomJoke();

        //then
        Assertions.assertNotNull(chuckNorrisJokesApiResponse);
    }

}