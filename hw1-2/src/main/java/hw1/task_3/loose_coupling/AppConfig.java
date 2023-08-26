package hw1.task_3.loose_coupling;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AppConfig {
    @Bean
    Role role() {
        System.out.println("Welcome!!!");
        return new Admin();
    }

    @Bean
    Laptop laptop() {
        return new Laptop(role());
    }
}
