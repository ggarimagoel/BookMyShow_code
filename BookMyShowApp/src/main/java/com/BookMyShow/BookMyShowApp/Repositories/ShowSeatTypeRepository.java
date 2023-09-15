package com.BookMyShow.BookMyShowApp.Repositories;

import com.BookMyShow.BookMyShowApp.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

    public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
        List<ShowSeatType> findAllByShow(Long aLong);

}
