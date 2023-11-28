package pl.dominikakrupa.project.speakjokes;

import pl.dominikakrupa.project.speakjokes.controller.VoiceRssController;
import pl.dominikakrupa.project.speakjokes.service.AudioPlayService;
import pl.dominikakrupa.project.speakjokes.service.VoiceRssService;

public class VoiceRssApplication {
    public static void main(String[] args) {
        AudioPlayService audioPlayService = new AudioPlayService();
        VoiceRssService voiceRssService = new VoiceRssService(audioPlayService);
        VoiceRssController voiceRssController = new VoiceRssController(voiceRssService);

        boolean play = voiceRssController.play("Hello Joke!");
    }
}
