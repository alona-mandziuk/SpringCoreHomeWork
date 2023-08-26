package hw1.task_3.loose_coupling;

class Admin implements Role {
    @Override
    public void start() {
        System.out.println("Session opened by Admin.");
    }
}
