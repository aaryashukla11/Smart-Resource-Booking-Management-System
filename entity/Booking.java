package entity;

public class Booking {
    private String bookingId;
    private String userId;
    private String resourceId;
    private DateTimeRange timeRange;
    private double totalCost;

    public Booking(String bookingId, String userId, String resourceId, DateTimeRange timeRange, double totalCost) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.resourceId = resourceId;
        this.timeRange = timeRange;
        this.totalCost = totalCost;
    }

    public String getBookingId() { return bookingId; }
    public String getUserId() { return userId; }
    public String getResourceId() { return resourceId; }
    public DateTimeRange getTimeRange() { return timeRange; }
    public double getTotalCost() { return totalCost; }

    @Override
    public String toString() {
        return "BookingID: " + bookingId + ", User: " + userId + ", Resource: " + resourceId +
               ", Time: " + timeRange + ", Cost: ₹" + totalCost;
    }
}
