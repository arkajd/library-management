package com.example.exceptions;

public class BookUnavailableException extends RuntimeException{

    public BookUnavailableException(String message){
        super(message);
    }
}
