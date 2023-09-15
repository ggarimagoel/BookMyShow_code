package com.BookMyShow.BookMyShowApp.Controllers;

import com.BookMyShow.BookMyShowApp.Repositories.UserRepository;
import com.BookMyShow.BookMyShowApp.Services.SignUpUserServices;
import com.BookMyShow.BookMyShowApp.dto.SignUpRequestDto;
import com.BookMyShow.BookMyShowApp.dto.SignUpResponseDto;
import com.BookMyShow.BookMyShowApp.models.ResponseStatus;
import com.BookMyShow.BookMyShowApp.models.Users;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class UserAuthenticationController {
     private UserRepository userRepository;
     private SignUpUserServices signUpUserServices;

    public SignUpResponseDto signup(SignUpRequestDto signUpRequestDto){

         Optional<Users> optionalUser = userRepository.findByEmail(signUpRequestDto.getEmail());
         SignUpResponseDto signUpResponseDto = new SignUpResponseDto();

        if(optionalUser.isEmpty()){
            try{
                Users user = signUpUserServices.signup(signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
                signUpResponseDto.setUserId(user.getId());
                signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            }
            catch (Exception e){
                signUpResponseDto.setResponseStatus(ResponseStatus.FAILED);
            }
        } else{
            try{
                Users user = signUpUserServices.logIn(signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
                signUpResponseDto.setUserId(user.getId());
                signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            }
            catch (Exception e){
                signUpResponseDto.setResponseStatus(ResponseStatus.FAILED);
            }
        }
        return signUpResponseDto;
    }

}
