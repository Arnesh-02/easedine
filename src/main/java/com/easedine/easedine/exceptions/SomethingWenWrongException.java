package com.easedine.easedine.exceptions;

public class SomethingWenWrongException extends Exception{
    public  SomethingWenWrongException(){
        super("Something went Wrong..!");
    }
    public SomethingWenWrongException(String message){
        super(message);
    }
}
