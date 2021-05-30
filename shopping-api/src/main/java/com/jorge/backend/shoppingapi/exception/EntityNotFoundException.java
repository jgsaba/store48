package com.jorge.backend.shoppingapi.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message){
        super(message);
    }
}
