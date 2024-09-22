package com.cakir.repository;

import com.cakir.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByIdentificationNumber(long identificationNumber);

    Optional<List<Booking>> findByCustomerId(long customerId);

    Optional<List<Booking>> findByMobileNumber(String mobileNumber);
}
