package com.BookMyShow.BookMyShowApp.Services;

import com.BookMyShow.BookMyShowApp.Repositories.ShowSeatRepository;
import com.BookMyShow.BookMyShowApp.Repositories.ShowSeatTypeRepository;
import com.BookMyShow.BookMyShowApp.models.Show;
import com.BookMyShow.BookMyShowApp.models.ShowSeat;
import com.BookMyShow.BookMyShowApp.models.ShowSeatType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Getter

@Service
public class PriceCalculator {
    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculator(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository = showSeatTypeRepository;
    }
    public int calculateBookingAmount(List<ShowSeat> showSeatList, Show show){
        int amount = 0;
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show.getId());

        for(ShowSeat showSeat : showSeatList){
            for(ShowSeatType  showSeatType : showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    amount += showSeatType.getPrice();
                }
            }
            // Inner for loop can be removed if we use a HashMap of ShowSeatType and Price.
        }
        return  amount;
    }
}
