package com.BookMyShow.BookMyShowApp.Services;

import com.BookMyShow.BookMyShowApp.Repositories.UserRepository;
import com.BookMyShow.BookMyShowApp.models.Users;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Optional;

@Service @Getter @Setter
public class SignUpUserServices {
    private UserRepository userRepository;

    @Autowired
    public SignUpUserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users signup(String email, String password){
        Optional<Users> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isPresent()){
        return logIn(email,password);
        }
        Users user = optionalUser.get();
        user.setEmail(email);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        user.setBookings(new ArrayList<>());

        return userRepository.save(user);
    }
    public Users logIn(String email, String password){
        Optional<Users> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty()){
            throw new RuntimeException("Email not registered");
        }
        Users user = optionalUser.get();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(password, user.getPassword())){
            return user;
        }
        throw new RuntimeException("Invalid password, try again");
    }
}
