package service;

import entity.*;
import repository.BookingRepository;
import repository.ResourceRepository;

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
        if (resource == null) return null;

        double cost = Calculator.calculateCost(resource, selection.getTimeRange());
        Booking booking = new Booking(UUID.randomUUID().toString(), userId, resource.getId(), selection.getTimeRange(), cost);
        bookingRepo.addBooking(booking);
        return booking;
    }

    public List<Booking> getAllBookings() {
        return bookingRepo.getAllBookings();
    }
}
