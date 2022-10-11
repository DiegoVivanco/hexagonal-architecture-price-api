package com.dlvivanco.price.api.domain.exception;

public class PriceNotFoundException extends RuntimeException {

    public PriceNotFoundException(String message){
        super(message);
    }
    
}
