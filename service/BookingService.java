package service;

import entity.*;
import repository.BookingRepository;
import repository.ResourceRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class BookingService {
    private BookingRepository bookingRepo;
    private ResourceRepository resourceRepo;

    public BookingService(BookingRepository bookingRepo, ResourceRepository resourceRepo) {
        this.bookingRepo = bookingRepo;
        this.resourceRepo = resourceRepo;
    }

    public boolean isAvailable(String resourceId, DateTimeRange newRange) {
        List<Booking> bookings = bookingRepo.getAllBookings();
        for (Booking b : bookings) {
            if (b.getResourceId().equals(resourceId) && b.getTimeRange().overlaps(newRange)) {
                return false;
            }
        }
        return true;
    }

    public Booking confirmBooking(String userId, ResourceSelection selection) {
        Resource resource = resourceRepo.getResourceById(selection.getResourceId());
        if (resource == null)
            return null;

        double cost = Calculator.calculateCost(resource, selection.getTimeRange());
        Booking booking = new Booking(UUID.randomUUID().toString(), userId, resource.getId(), selection.getTimeRange(),
                cost);
        bookingRepo.addBooking(booking);
        return booking;
    }

    public void bookResource(String resourceId, String username, String dateFrom, String dateTo, String timeFrom,
            String timeTo) {
        Resource resource = resourceRepo.getResourceById(resourceId);

        if (resource != null && resource.isAvailable()) {
            String bookingId = UUID.randomUUID().toString();
            String userId = username; // Assuming username is the user ID for simplicity
            LocalDateTime start = LocalDateTime.parse(dateFrom + "T" + timeFrom);
            LocalDateTime end = LocalDateTime.parse(dateTo + "T" + timeTo);
            DateTimeRange timeRange = new DateTimeRange(start, end);
            Booking booking = new Booking(bookingId, userId, resourceId, timeRange,
                    resource.getCostPerHour() * timeRange.getDurationInHours());
            bookingRepo.addBooking(booking);

            resource.setAvailable(false);
            resourceRepo.updateResource(resource);

            System.out.println("Resource booked successfully! Booking ID: " + bookingId);
        } else {
            System.out.println("Resource is not available or does not exist.");
        }
    }

    public List<Booking> getAllBookings() {
        return bookingRepo.getAllBookings();
    }
}
