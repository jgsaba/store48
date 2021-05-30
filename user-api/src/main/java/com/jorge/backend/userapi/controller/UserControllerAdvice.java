package com.jorge.backend.userapi.controller;

import com.jorge.backend.userapi.exceptions.UserNotFoundException;
import model.exceptions.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class UserControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    ErrorDTO handleUserNotFound(UserNotFoundException userNotFoundException){
        return ErrorDTO.builder()
                .message(userNotFoundException.getMessage())
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }
}
