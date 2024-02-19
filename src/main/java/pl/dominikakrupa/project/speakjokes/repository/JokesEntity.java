package pl.dominikakrupa.project.speakjokes.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "JOKES")
public class JokesEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String joke;

    @Override
    public String toString() {
        return "JokesEntity{" +
                "id=" + id +
                ", joke='" + joke + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public JokesEntity() {
    }
}
