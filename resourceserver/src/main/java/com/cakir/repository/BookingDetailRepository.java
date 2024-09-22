package com.cakir.repository;

import com.cakir.model.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingDetailRepository extends JpaRepository<BookingDetail, Long> {
    Optional<BookingDetail> findByBookingId(long bookingId);
}
