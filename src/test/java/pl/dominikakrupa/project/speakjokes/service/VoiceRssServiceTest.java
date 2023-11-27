package pl.dominikakrupa.project.speakjokes.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;


class VoiceRssServiceTest {

    @Test
    void speakJoke() throws IOException {
        //given
        AudioPlayService audioPlayService = new AudioPlayService();
        VoiceRssService voiceRssService = new VoiceRssService(audioPlayService);

        //when
        boolean spoken = voiceRssService.speakJoke("Hello, Joke!!");

        //then
        Assertions.assertTrue(spoken, "not spoken");
    }
}