package com.BookMyShow.BookMyShowApp.Repositories;

import com.BookMyShow.BookMyShowApp.models.Users;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    //JPARepository -> Inbuilt INTERFACE which support for all type of SQL queries.

    @Override
    // Optional<T> findById will find the T from table using Id from database
    Optional<Users> findById(Long aLong);

    Optional<Users> findByEmail(String email);


    @Override
    // save will save the User user in database, either save the updated version of user or
        // if user not present will add the user in DB
    Users save(Users user);
}
