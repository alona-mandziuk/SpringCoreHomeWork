package hw2.task_2;

import hw2.task_1.Movie;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class MovieAct {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MovieConfig.class);
        Movie movie = context.getBean("secondMovie", SecondMovie.class);
        movie.getInfo();
        context.close();
    }
}
