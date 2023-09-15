package com.BookMyShow.BookMyShowApp.dto;

import com.BookMyShow.BookMyShowApp.models.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PaymentResponseDto {
    private ResponseStatus responseStatus;
}
