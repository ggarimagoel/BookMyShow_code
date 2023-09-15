package com.BookMyShow.BookMyShowApp.Controllers;


import com.BookMyShow.BookMyShowApp.Services.BookingServices;
import com.BookMyShow.BookMyShowApp.dto.BookMovieRequestDto;
import com.BookMyShow.BookMyShowApp.dto.BookMovieResponseDto;
import com.BookMyShow.BookMyShowApp.models.Booking;
import com.BookMyShow.BookMyShowApp.models.ResponseStatus;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingServices bookingServices;

    public  BookingController(BookingServices bookingServices){
        this.bookingServices = bookingServices;
    }
    public BookMovieResponseDto bookMovie(BookMovieRequestDto bookMovieRequestDto){
        BookMovieResponseDto bookMovieResponseDto = new BookMovieResponseDto();
        try{
            Booking booking = bookingServices.bookMovie(bookMovieRequestDto.getUserId(),
                    bookMovieRequestDto.getShowId(), bookMovieRequestDto.getShowSeatIds());

            bookMovieResponseDto.setBookingId(booking.getId());
            bookMovieResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            bookMovieResponseDto.setAmount(booking.getAmount());
        }
        catch (RuntimeException e){
            bookMovieResponseDto.setResponseStatus(ResponseStatus.FAILED);
        }
        return bookMovieResponseDto;

    }
}
