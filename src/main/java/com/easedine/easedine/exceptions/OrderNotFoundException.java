package com.easedine.easedine.exceptions;

import org.aspectj.weaver.ast.Or;

public class OrderNotFoundException extends Exception{

    public OrderNotFoundException(){
        super("No such order is found ..!");
    }

    public OrderNotFoundException(String message){
        super(message);
    }
}
