package entity;

public class Admin extends User {
    public Admin(String id, String name, String password) {
        super(id, name, "Admin", password);
    }

    @Override
    public void showMenu() {
        System.out.println("1. View All Users");
        System.out.println("2. View Reports");
    }
}
