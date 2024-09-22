package com.cakir.services;

import com.cakir.model.BookingDetail;
import com.cakir.repository.BookingDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingDetailService {
    private final BookingDetailRepository bookingDetailRepository;

    public ResponseEntity<BookingDetail> getBookingDetailByBookingId(long bookingId) {
        return bookingDetailRepository.findByBookingId(bookingId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
