package com.BookMyShow.BookMyShowApp.dto;

import com.BookMyShow.BookMyShowApp.models.Booking;
import com.BookMyShow.BookMyShowApp.models.PaymentProvider;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PaymentRequestDto {
    private int amount;
    private PaymentProvider paymentProvider;
    private Long Id;
    private Long refId;
}
