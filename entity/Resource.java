package entity;

public class Resource {
    private String id;
    private String name;
    private String type;
    private double costPerHour;
    private boolean available ;

    public Resource(String id, String name, String type, double costPerHour) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.costPerHour = costPerHour;
        this.available = true;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public double getCostPerHour() { return costPerHour; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return id + " - " + name + " (" + type + ") ₹" + costPerHour + "/hr";
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
