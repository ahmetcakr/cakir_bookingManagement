package com.cakir.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "booking_details")
public class BookingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String district;

    private String city;

    private String country;

    @OneToOne(mappedBy = "bookingDetail")
    private Booking booking;

}
