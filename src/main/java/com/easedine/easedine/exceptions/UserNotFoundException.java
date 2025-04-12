package com.easedine.easedine.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(){
        super("User is not found..!!");
    }

    public UserNotFoundException(String message){
        super(message);
    }
}
