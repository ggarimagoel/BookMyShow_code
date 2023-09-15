package com.BookMyShow.BookMyShowApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication


@EnableJpaAuditing
/* This feature allows you to automatically track and
record changes to your JPA (Java Persistence API) entities,
such as when they were created and modified.
It is commonly used for recording who created or modified a
particular entity and when those actions occurred.
eg last ModifiedBy, LastModifiedOn will beautomatically changed*/


public class BookMyShowAppApplication {

	public static void main(String[] args){

		SpringApplication.run(BookMyShowAppApplication.class, args);



	}
}
//Requirement
//1. user should be able to book the ticket / handle concurrency