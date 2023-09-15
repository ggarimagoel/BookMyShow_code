package com.BookMyShow.BookMyShowApp.Exceptions;

public class PaymentFailedException extends RuntimeException{
    public PaymentFailedException(String s){
        super((s));
    }
}
