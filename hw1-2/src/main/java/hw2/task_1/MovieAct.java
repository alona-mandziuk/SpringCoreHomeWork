package hw2.task_1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

class MovieAct {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Movie movie = context.getBean("movie", FirstMovie.class);
        movie.getInfo();
        context.close();
    }
}
