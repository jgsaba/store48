package com.jorge.backend.productapi.exception;

public class ProductNotFoundException extends RuntimeException{

    private final static String errorMessage = "Product not found";

    public ProductNotFoundException(){
        super(errorMessage);
    }

    public ProductNotFoundException(String productIdentifier){
        super(errorMessage + " with id=" + productIdentifier);
    }
}
