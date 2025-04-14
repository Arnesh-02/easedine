package com.easedine.easedine.exceptions;

public class UserNameNotFoundException extends Exception{

    public UserNameNotFoundException(){
        super("UserNot not found");
    }

    public  UserNameNotFoundException(String message){
        super(message);
    }
}
