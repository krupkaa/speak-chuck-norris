package pl.dominikakrupa.project.speakjokes.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpeakJokeServiceTest {

    @Test
    void speakJoke() {
        //given
        ChuckNorrisJokesService chuckNorrisJokesService = new ChuckNorrisJokesService();
        AudioPlayService audioPlayService = new AudioPlayService();
        VoiceRssService voiceRssService = new VoiceRssService(audioPlayService);
        SpeakJokeService speakJokeService = new SpeakJokeService(chuckNorrisJokesService, voiceRssService);

        //when
        boolean spoken = speakJokeService.speakJoke();

        //then
        Assertions.assertTrue(spoken, "joke not spoken");

    }
}