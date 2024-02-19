package pl.dominikakrupa.project.speakjokes.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class JokesRepositoryTest {

    @Autowired
    private JokesRepository jokesRepository;

    @Test
    void saveJoke() {
        //given
        // ... NOTE injected by @Autowired
        JokesEntity jokeEntity = new JokesEntity();

        //when
        JokesEntity savedJokeEntity = jokesRepository.save(jokeEntity);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedJokeEntity, "savedJokeEntity is NULL"),
                () -> Assertions.assertNotNull(savedJokeEntity.getId(), "savedJokeEntity is NULL")
        );

    }
}