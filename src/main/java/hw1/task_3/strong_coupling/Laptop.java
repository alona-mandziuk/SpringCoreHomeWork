package hw1.task_3.strong_coupling;

class Laptop {
    private User user;

    Laptop(User user) {
        this.user = user;
    }

    void openSession() {
        user.enter();
    }

}
