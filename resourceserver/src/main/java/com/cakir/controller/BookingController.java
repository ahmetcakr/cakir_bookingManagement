package com.cakir.controller;

import com.cakir.model.Booking;
import com.cakir.model.NoContentDTO;
import com.cakir.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    @RequestMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @RequestMapping("/get")
    public ResponseEntity<Booking> getBookingById(@RequestParam long bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    @RequestMapping("/delete")
    public ResponseEntity<NoContentDTO> deleteBooking(@RequestParam long bookingId) {
        return bookingService.deleteBooking(bookingId);
    }

    @RequestMapping("/update")
    public ResponseEntity<Booking> updateBooking(@RequestParam long bookingId, @RequestBody Booking booking) {
        return bookingService.updateBooking(bookingId, booking);
    }

    @RequestMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @RequestMapping("/getByIdentificationNumber")
    public ResponseEntity<Booking> getBookingByIdentificationNumber(@RequestParam long identificationNumber) {
        return bookingService.getBookingByIdentificationNumber(identificationNumber);
    }

    @RequestMapping("/getByCustomerId")
    public ResponseEntity<List<Booking>> getBookingsByCustomerId(@RequestParam long customerId) {
        return bookingService.getBookingsByCustomerId(customerId);
    }

}
