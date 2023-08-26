package hw1.task_3.loose_coupling;

class User implements Role {
    @Override
    public void start() {
        System.out.println("Session opened by User.");
    }
}
