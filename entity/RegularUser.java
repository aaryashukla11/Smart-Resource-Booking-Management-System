package entity;

public class RegularUser extends User {
    public RegularUser(String id, String name, String password) {
        super(id, name, "RegularUser", password);
    }

    @Override
    public void showMenu() {
        System.out.println("1. View Resources");
        System.out.println("2. Add to Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Confirm Booking");
        System.out.println("5. Cancel Booking");
    }
}
