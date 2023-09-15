package com.BookMyShow.BookMyShowApp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{

    @ManyToOne
    private Show show;

    private int price;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
}

/* showseatType  --  show
    1       -- >   1
    M       <--    1
 */