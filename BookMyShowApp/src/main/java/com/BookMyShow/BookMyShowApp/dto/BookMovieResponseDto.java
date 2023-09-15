package com.BookMyShow.BookMyShowApp.dto;

import com.BookMyShow.BookMyShowApp.models.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDto {

    private Long bookingId;
    private double amount;
    private ResponseStatus responseStatus;
}
