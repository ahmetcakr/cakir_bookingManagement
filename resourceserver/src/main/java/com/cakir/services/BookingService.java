package com.cakir.services;

import com.cakir.model.Booking;
import com.cakir.model.NoContentDTO;
import com.cakir.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    public ResponseEntity<NoContentDTO> deleteBooking(long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking with id: " + bookingId + " not found"));

        bookingRepository.delete(booking);
        return new ResponseEntity<>(new NoContentDTO(), HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Booking> updateBooking(long bookingId, Booking booking) {
        Booking existingBooking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking with id: " + bookingId + " not found"));

        existingBooking.setBookingDate(booking.getBookingDate());
        existingBooking.setCustomer(booking.getCustomer());
        existingBooking.setBookingStatus(booking.getBookingStatus());
        existingBooking.setIdentificationNumber(booking.getIdentificationNumber());
        existingBooking.setMobileNumber(booking.getMobileNumber());
        existingBooking.setName(booking.getName());
        existingBooking.setSurname(booking.getSurname());

        return new ResponseEntity<>(bookingRepository.save(existingBooking), HttpStatus.OK);

    }

    public ResponseEntity<Booking> createBooking(Booking booking) {
        return new ResponseEntity<>(bookingRepository.save(booking), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Booking>> getAllBookings() {
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Booking> getBookingById(long bookingId) {
        return new ResponseEntity<>(bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking with id: " + bookingId + " not found")), HttpStatus.OK);
    }

    public ResponseEntity<Booking> getBookingByIdentificationNumber(long identificationNumber) {
        return new ResponseEntity<>(bookingRepository.findByIdentificationNumber(identificationNumber)
                .orElseThrow(() -> new RuntimeException("Booking with identification number: " + identificationNumber + " not found")), HttpStatus.OK);
    }

    public ResponseEntity<List<Booking>> getBookingsByMobileNumber(String mobileNumber) {
        return new ResponseEntity<>(bookingRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new RuntimeException("Booking with mobile number: " + mobileNumber + " not found")), HttpStatus.OK);
    }

    public ResponseEntity<List<Booking>> getBookingsByCustomerId(long customerId) {
        return new ResponseEntity<>(bookingRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Booking with customer id: " + customerId + " not found")), HttpStatus.OK);
    }




}
