package pl.dominikakrupa.project.speakjokes.controller;

import pl.dominikakrupa.project.speakjokes.api.chucknorrisjokes.ChuckNorrisJokesApiResponse;
import pl.dominikakrupa.project.speakjokes.service.ChuckNorrisJokesService;

import java.util.logging.Logger;

public class ChuckNorrisJokesController {

    private static final Logger LOGGER = Logger.getLogger(ChuckNorrisJokesController.class.getName());
    private final ChuckNorrisJokesService chuckNorrisJokesService;

    public ChuckNorrisJokesController(ChuckNorrisJokesService chuckNorrisJokesService) {
        this.chuckNorrisJokesService = chuckNorrisJokesService;
    }

    public ChuckNorrisJokesApiResponse randomJoke() {
        LOGGER.info("randomJoke()");
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesService.randomJoke();
        LOGGER.info("randomJoke(...) = " + chuckNorrisJokesApiResponse);
        return chuckNorrisJokesApiResponse;
    }
}
