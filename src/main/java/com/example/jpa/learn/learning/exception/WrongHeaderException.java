package com.example.jpa.learn.learning.exception;

import lombok.*;

@Getter
@Setter
public class WrongHeaderException extends RuntimeException{

    final String message;

    public WrongHeaderException(String message){
        super(message);
        this.message = message;
    }

}
