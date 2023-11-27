package pl.dominikakrupa.project.speakjokes.service;

import org.junit.jupiter.api.Test;

import java.io.InputStream;


class AudioPlayServiceTest {

    @Test
    void play() {
        //given
        AudioPlayService audioPlayService = new AudioPlayService();
        InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("hello-joke.wav");

        //when
        audioPlayService.play(inputStream);

        //then

    }
}