package com.BookMyShow.BookMyShowApp.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Region extends BaseModel {
    private String name;
    //private List<Theatre> theatres; /// Depends on access pattern.
}
