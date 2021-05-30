package com.jorge.backend.shoppingapi.controller;

import com.jorge.backend.shoppingapi.exception.EntityNotFoundException;
import model.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class ShopControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    ErrorDTO handleUserNotFound(EntityNotFoundException entityNotFoundException){
        return ErrorDTO.builder()
                .message(entityNotFoundException.getMessage())
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ValidationError handleValidationError(MethodArgumentNotValidException methodArgumentNotValidException){

        Map<String, String> fieldErrors = new HashMap<>();

        methodArgumentNotValidException
                .getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> fieldErrors.put(fieldError.getField(), fieldError.getDefaultMessage()));

        return ValidationError.builder()
                .message("Field validation error")
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .errors(fieldErrors)
                .build();
    }
}
