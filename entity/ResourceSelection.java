package entity;

public class ResourceSelection {
    private String resourceId;
    private DateTimeRange timeRange;

    public ResourceSelection(String resourceId, DateTimeRange timeRange) {
        this.resourceId = resourceId;
        this.timeRange = timeRange;
    }

    public String getResourceId() { return resourceId; }
    public DateTimeRange getTimeRange() { return timeRange; }
}
