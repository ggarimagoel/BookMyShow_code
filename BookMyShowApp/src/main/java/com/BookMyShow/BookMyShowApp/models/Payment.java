package com.BookMyShow.BookMyShowApp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private Long referenceId; // from third party
    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

     @Enumerated(EnumType.ORDINAL)
      private PaymentProvider paymentProvider;
}
