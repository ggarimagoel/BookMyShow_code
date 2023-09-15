package com.BookMyShow.BookMyShowApp.Repositories;

import com.BookMyShow.BookMyShowApp.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    @Override
    Optional<Booking> findById(Long aLong);

    @Override
    Booking save(Booking booking);
}
