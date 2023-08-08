package hw1.task_3.loose_coupling;


class Laptop {
    private Role role;

    public Laptop(Role role) {
        this.role = role;
    }

    void openSession() {
        role.start();
    }
}
