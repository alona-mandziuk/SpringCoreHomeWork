package hw1.task_1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class MainQuest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
        Knight knight = context.getBean(Knight.class);
        knight.startQuest();
        context.close();
    }
}
