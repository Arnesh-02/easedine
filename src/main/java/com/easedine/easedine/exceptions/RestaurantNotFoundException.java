package com.easedine.easedine.exceptions;

public class RestaurantNotFoundException extends  Exception{

    public RestaurantNotFoundException(){
        super("No such restaurant exists");
    }

    public  RestaurantNotFoundException(String message){
        super(message);
    }
}
