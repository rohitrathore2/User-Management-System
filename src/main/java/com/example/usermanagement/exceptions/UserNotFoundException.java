package com.example.usermanagement.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message); // pass message to runtime exception
    }
}
