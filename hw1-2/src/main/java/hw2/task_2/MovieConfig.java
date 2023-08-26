package hw2.task_2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("hw2.task_2")
@PropertySource("hw2_task1.properties")
class MovieConfig {
}
