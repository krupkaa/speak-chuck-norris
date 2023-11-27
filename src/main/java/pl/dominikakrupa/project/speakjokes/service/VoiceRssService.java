package pl.dominikakrupa.project.speakjokes.service;

import okhttp3.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class VoiceRssService {

    private static final Logger LOGGER = Logger.getLogger(VoiceRssService.class.getName());

    private final OkHttpClient client;

    private final AudioPlayService audioPlayService;

    public VoiceRssService(AudioPlayService audioPlayService) {
        this.client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        this.audioPlayService = audioPlayService;
    }

    public boolean speakJoke(String textToVoice) throws IOException {
        LOGGER.info("speakJoke(" + textToVoice +")");


        //przez HttpUrl bo są podawane parametry żądania
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("api.voicerss.org")
                .addQueryParameter("key", "efb148f08c364dcd86de77263ddba57d")
                .addQueryParameter("hl", "en-us")
                .addQueryParameter("src", textToVoice)
                .build();

        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            LOGGER.info("response: " + response);

            if(response != null) {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    InputStream inputStream = new ByteArrayInputStream(responseBody.bytes());
                    if (inputStream != null) {
                        audioPlayService.play(inputStream);
                        LOGGER.info("speakJoke(...) = " + true);
                        return true;
                    }
                }
            }

        }

        LOGGER.info("speakJoke(...) = " + false);
        return false;
    }
}
