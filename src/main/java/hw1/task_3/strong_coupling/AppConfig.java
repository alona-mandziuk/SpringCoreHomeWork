package hw1.task_3.strong_coupling;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AppConfig {
    @Bean
    User user() {
        System.out.println("Welcome!!!");
        return new User();
    }

    @Bean
    Laptop laptop() {
        return new Laptop(user());
    }
}
