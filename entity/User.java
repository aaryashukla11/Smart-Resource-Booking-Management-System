package entity;

public abstract class User {
    protected String id;
    protected String name;
    protected String role;
    protected String password;

    public User(String id, String name, String role, String password) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public String getPassword() { return password; }

    public abstract void showMenu();
}
