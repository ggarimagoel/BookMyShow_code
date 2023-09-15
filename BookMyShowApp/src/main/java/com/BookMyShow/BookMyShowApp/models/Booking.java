package com.BookMyShow.BookMyShowApp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Booking extends BaseModel{

    @ManyToMany   // in case of cancellation one showSeat can belong to many bookings
    private List<ShowSeat> showSeat;

    @ManyToOne
    private Users user;

    private int  amount;

    @OneToMany
    private List<Payment> payments;

    @Enumerated( EnumType.ORDINAL)
    private BookingStatus bookingStatus;
}
