package pl.dominikakrupa.project.speakjokes.service;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import pl.dominikakrupa.project.speakjokes.api.chucknorrisjokes.ChuckNorrisJokesApiResponse;
import pl.dominikakrupa.project.speakjokes.repository.JokesEntity;
import pl.dominikakrupa.project.speakjokes.repository.JokesRepository;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ChuckNorrisJokesService {

    public static final String API_URL = "https://api.chucknorris.io/jokes/random";
    private static final Logger LOGGER = Logger.getLogger(ChuckNorrisJokesService.class.getName());

    private final JokesRepository jokesRepository;
    private final OkHttpClient client = new OkHttpClient();

    public ChuckNorrisJokesService(JokesRepository jokesRepository) {
        this.jokesRepository = jokesRepository;
    }

    public ChuckNorrisJokesApiResponse randomJoke() {
        LOGGER.info("randomJoke()");
        try {
            String responseBody = getResponse(API_URL);
            ChuckNorrisJokesApiResponse apiResponse = convert(responseBody);

            String joke = apiResponse.getValue();
            JokesEntity jokeEntity = new JokesEntity();
            jokeEntity.setJoke(joke);
            JokesEntity savedJokesEntity = jokesRepository.save(jokeEntity);
            LOGGER.info("savedJokesEntity: " + savedJokesEntity);

            LOGGER.info("randomJoke(...) = " + apiResponse);
            return apiResponse;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Unable to connect with external API.", e);
        }
        LOGGER.info("randomJoke(...) = " + null);
        return null;
    }

    public String getResponse(String url) throws IOException {
        LOGGER.info("run(" + url + ")");
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String body = null;
            if (response.body() != null) {
                body = response.body().string();
            }
            LOGGER.info("run(...) = " + body);
            return body;
        }
    }

    public ChuckNorrisJokesApiResponse convert(String body) {
        LOGGER.info("convert(" + body + ")");
        Gson gson = new Gson();
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = gson.fromJson(body, ChuckNorrisJokesApiResponse.class);
        LOGGER.info("convert(...) = " + chuckNorrisJokesApiResponse);
        return chuckNorrisJokesApiResponse;
    }
}
