package pl.dominikakrupa.project.speakjokes.service;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AudioPlayService {


    private static final int BUFFER_SIZE = 4096;
    private static final Logger LOGGER = Logger.getLogger(AudioPlayService.class.getName());

    public void play(InputStream inputStream) {
        try {
            LOGGER.info("play(inputstream)");

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);

            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

            LOGGER.info("Playback Started.");

            byte[] bufferBytes = new byte[BUFFER_SIZE];
            int readBytes = -1;
            while ((readBytes = audioStream.read(bufferBytes)) != -1) {
                sourceDataLine.write(bufferBytes, 0, readBytes);
            }
            sourceDataLine.drain();
            sourceDataLine.close();
            audioStream.close();

            LOGGER.info("Playback has been finished.");

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            LOGGER.log(Level.SEVERE, "Unable to play sound", ex);
        }
        LOGGER.info("play(...) = ");
    }

}
