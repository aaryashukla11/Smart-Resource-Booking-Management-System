package entity;

public class ResourceManager extends User {
    public ResourceManager(String id, String name, String password) {
        super(id, name, "ResourceManager", password);
    }

    @Override
    public void showMenu() {
        System.out.println("1. Add Resource");
        System.out.println("2. Edit Resource");
        System.out.println("3. Delete Resource");
        System.out.println("4. View Resources");
    }
}
