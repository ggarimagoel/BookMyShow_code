package com.BookMyShow.BookMyShowApp.Exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String s){
        super(s);
    }
}
