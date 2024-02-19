package pl.dominikakrupa.project.speakjokes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//repository nie jest wymagane jbc
@Repository
public interface JokesRepository extends JpaRepository<JokesEntity, Long> {


}
