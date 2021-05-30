package com.jorge.backend.productapi.controller;

import com.jorge.backend.productapi.exception.ProductNotFoundException;
import model.exceptions.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDTO handleEntityNotFound(ProductNotFoundException entityNotFoundException){
        return ErrorDTO.builder()
                .message(entityNotFoundException.getMessage())
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }
}
