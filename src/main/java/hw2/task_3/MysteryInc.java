package hw2.task_3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

class MysteryInc {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hw2_task3_Context.xml");
        ScoobyTeam scoobyTeam = context.getBean("scoobyTeam", ScoobyTeam.class);
        scoobyTeam.showAll();
        context.close();
    }
}
