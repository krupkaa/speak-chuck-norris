package pl.dominikakrupa.project.speakjokes.controller;


import pl.dominikakrupa.project.speakjokes.service.VoiceRssService;

import java.io.IOException;
import java.util.logging.Logger;

public class VoiceRssController {

    private static final Logger LOGGER = Logger.getLogger(VoiceRssController.class.getName());

    private final VoiceRssService voiceRssService;

    public VoiceRssController(VoiceRssService voiceRssService) {
        this.voiceRssService = voiceRssService;
    }

    public boolean play(String textToVoice) {
        LOGGER.info("play(" + textToVoice + ")");

        boolean spoken;
        try {
            spoken = voiceRssService.speakJoke(textToVoice);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        LOGGER.info("play(...) = " + spoken);
        return spoken;
    }
}
