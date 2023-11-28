package pl.dominikakrupa.project.speakjokes.service;

import pl.dominikakrupa.project.speakjokes.api.chucknorrisjokes.ChuckNorrisJokesApiResponse;

import java.io.IOException;
import java.util.logging.Logger;

public class SpeakJokeService {
    private static final Logger LOGGER = Logger.getLogger(SpeakJokeService.class.getName());

    private final ChuckNorrisJokesService chuckNorrisJokesService;
    private final VoiceRssService voiceRssService;

    public SpeakJokeService(ChuckNorrisJokesService chuckNorrisJokesService, VoiceRssService voiceRssService) {
        this.chuckNorrisJokesService = chuckNorrisJokesService;
        this.voiceRssService = voiceRssService;
    }

    public boolean speakJoke()  {
        LOGGER.info("speakJoke()");
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesService.randomJoke();
        String joke = chuckNorrisJokesApiResponse.getValue();

        boolean spoken;
        try {
            spoken = voiceRssService.speakJoke(joke);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("speakJoke(...) = " + spoken);
        return spoken;
    }
}
