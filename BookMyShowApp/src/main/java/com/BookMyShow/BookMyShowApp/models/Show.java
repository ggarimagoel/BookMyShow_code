package com.BookMyShow.BookMyShowApp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity(name = "shows")  // because show is reserved keyword in SQL
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;
    @ManyToOne
    private  Screen screen;

//    @ManyToMany    use this for models

//   @Enumerated(EnumType.ORDINAL) will create list in list of numbers <1, 2, 3....>
//   @Enumerated(EnumType.STRING)will craete list using name i.e. <TWO_D, THREE_D ,DOLBY....>
    @Enumerated(EnumType.ORDINAL) // this is for enums
    @ElementCollection  // use this for Lists
    private List<Feature> features;
}
