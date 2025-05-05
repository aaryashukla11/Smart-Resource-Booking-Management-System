package service;

import entity.Booking;
import repository.BookingRepository;

import java.util.List;

public class ReportService {
    private BookingRepository bookingRepo;

    public ReportService(BookingRepository bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public void showReports() {
        List<Booking> bookings = bookingRepo.getAllBookings();
        System.out.println("Total Bookings: " + bookings.size());
        // Extend with popular resources, top users, etc.
    }
}
