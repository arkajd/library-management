package com.example.exceptions;

public class BookNotInInventoryException extends RuntimeException{

    public BookNotInInventoryException(String message){
        super(message);
    }
}
