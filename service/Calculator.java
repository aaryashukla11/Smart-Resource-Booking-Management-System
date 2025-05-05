package service;

import entity.DateTimeRange;
import entity.Resource;
import java.time.Duration;

public class Calculator {
    public static double calculateCost(Resource resource, DateTimeRange range) {
        long hours = Duration.between(range.getStart(), range.getEnd()).toHours();
        return hours * resource.getCostPerHour();
    }
}
