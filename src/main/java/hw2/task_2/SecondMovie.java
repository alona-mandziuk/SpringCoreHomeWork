package hw2.task_2;

import hw2.task_1.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component("secondMovie")
class SecondMovie implements Movie {
    @Value("${movie1.genre}")
    String genre;
    String title;
    String director;
    public SecondMovie(@Value("${movie1.title}") String title) {
        this.title = title;
    }

    @Value("${movie1.director}")
    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    @Override
    @PostConstruct
    public void init() {
        System.out.println("Genre: " + genre);
    }

    @Override
    public void getInfo() {
        System.out.println("Title: " + getTitle());
        System.out.println("Director: " + getDirector());
    }
}
