package hw1.task_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class KnightConfig {
    @Bean
    Quest quest(){
        System.out.println("Congratulaions in winning!");
        return new DragonQuest();
    }
    @Bean
    Knight knight(){
        return new Knight(quest());
    }

}
