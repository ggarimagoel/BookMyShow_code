package com.BookMyShow.BookMyShowApp.Repositories;

import com.BookMyShow.BookMyShowApp.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Override
    Optional<ShowSeat> findById(Long aLong);

    @Override
    ShowSeat save(ShowSeat showSeat);
}
