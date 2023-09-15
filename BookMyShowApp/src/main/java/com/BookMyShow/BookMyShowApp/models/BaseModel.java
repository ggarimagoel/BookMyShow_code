package com.BookMyShow.BookMyShowApp.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass // i.e. this  is a superclass and is attributes will be derived by all classes
public class BaseModel {
    // will contrain attributes which are common to all the classes/tables

    private Date createdAt;

    //GeneratedValue use strategyPattern
    @Id // sets the corresponding val, here id , as PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  Date lastModifiedAt;
}


/* for all the models , primitive datatype will have column in the table,
and non primitive dataType will have column via cardinality(FKs, mapping tables etc),
 */