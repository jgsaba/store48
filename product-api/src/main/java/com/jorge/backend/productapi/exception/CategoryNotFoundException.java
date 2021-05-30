package com.jorge.backend.productapi.exception;

public class CategoryNotFoundException extends RuntimeException {

    private final static String errorMessage = "Category not found";

    public CategoryNotFoundException(){
        super(errorMessage);
    }

    public CategoryNotFoundException(Long categoryId){
        super(errorMessage + " with id=" + categoryId);
    }
}
