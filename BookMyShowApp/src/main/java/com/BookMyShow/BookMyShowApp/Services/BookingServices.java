package com.BookMyShow.BookMyShowApp.Services;

import com.BookMyShow.BookMyShowApp.Exceptions.ShowSeatNotFoundException;
import com.BookMyShow.BookMyShowApp.Exceptions.UserNotFoundException;
import com.BookMyShow.BookMyShowApp.Repositories.*;
import com.BookMyShow.BookMyShowApp.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServices {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;
    private PriceCalculator priceCalculator;

    @Autowired //autowire with the dependencies(repositories) we are using
    public BookingServices(UserRepository userRepository, ShowRepository showRepository,
                           ShowSeatRepository showSeatRepository, BookingRepository bookingRepository,
                           PriceCalculator priceCalculator) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.priceCalculator = priceCalculator;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE) // to take  a lock on entire loop
//    ---------LOCK IS ACQUIRED-----------
    public Booking bookMovie(Long userId, Long showId , List<Long> showSeatId) {
        /*
        steps

        ------TAKE A LOCK------
        1)  get user from userId
        2)  get the show from showId
        3)  get list of showseats from showseatId
        4)  check if all the show seat are available
        5)  if all the show seat not available throw exception.
        6)  if all are available,then change the status to LOCKED
        7)  change the status in db as well
        8)  create the booking object and store it in db
        9)  return the booking obj
        ------RELEASE A LOCK-------
         */

//        1)  get user from userId
        Optional<Users> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("Invalid user");
        }
        Users bookedBy = optionalUser.get();

//        2)  get the show from showId
         Optional<Show> optionalShow = showRepository.findById(showId);
         if(optionalShow.isEmpty()){
             throw new ShowSeatNotFoundException("Invalid Show");
         }
         Show show = optionalShow.get();

//        3)  get list of showseats from showseatId
         List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatId);

//         4) check if all showseats are available
         for(ShowSeat showSeat : showSeats){
             if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
//         5) if all seats are not available throw an exception
                 throw new ShowSeatNotFoundException("ShowSeat with id " + showSeat.getId() + " is not available");
             }
         }
         List<ShowSeat> bookedShowSeats = new ArrayList<>();

//         6) if all are available change status to LOCKED
         for(ShowSeat showSeat : showSeats){
             showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);

//         7) change the status in DB as well
             bookedShowSeats.add(showSeatRepository.save(showSeat));
//           bookedShowSeats is the List of showSeats which are locked for payment.
         }

//         8) create a booking object and save in DB
         Booking booking = new Booking();
         booking.setUser(bookedBy);
         booking.setBookingStatus(BookingStatus.IN_PROGRESS);
         booking.setPayments(new ArrayList<>());
         booking.setCreatedAt(new Date());
         booking.setLastModifiedAt(new Date());
         booking.setAmount(priceCalculator.calculateBookingAmount(bookedShowSeats, show));


         return bookingRepository.save(booking);// saving Booking in DB and returning the value

//        ---------LOCK WILL BE RELEASED-----------

    }
}
