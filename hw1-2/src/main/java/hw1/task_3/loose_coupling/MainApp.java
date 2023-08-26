package hw1.task_3.loose_coupling;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Laptop laptop = applicationContext.getBean(Laptop.class);
        laptop.openSession();
        applicationContext.close();
    }
}
