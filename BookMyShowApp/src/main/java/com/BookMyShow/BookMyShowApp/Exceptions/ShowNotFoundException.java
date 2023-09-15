package com.BookMyShow.BookMyShowApp.Exceptions;

public class ShowNotFoundException extends RuntimeException{
    public ShowNotFoundException(String s){
        super(s);
    }
}
