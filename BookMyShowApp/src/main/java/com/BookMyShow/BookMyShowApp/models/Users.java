package com.BookMyShow.BookMyShowApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//     @Entity annotation in Spring Boot marks a Java class
//     as a special type of class that represents data in a database.
//     It tells Spring Boot that instances of this class should be stored and
//     managed in a database table. This annotation is a way to create a connection between
//     your Java code and the underlying database,
//     allowing you to work with database records using Java objects.
@Getter
@Setter
@Entity
public class Users extends BaseModel{

    private String username;
    private String email;
    private String password;
    @OneToMany
    private List<Booking> bookings;
}
