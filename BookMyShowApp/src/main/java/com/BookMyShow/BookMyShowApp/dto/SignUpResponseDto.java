package com.BookMyShow.BookMyShowApp.dto;

import com.BookMyShow.BookMyShowApp.models.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class SignUpResponseDto {
    private ResponseStatus responseStatus;
    private Long userId;
}
