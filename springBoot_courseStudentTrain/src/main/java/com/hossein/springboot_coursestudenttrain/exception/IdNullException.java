package com.hossein.springboot_coursestudenttrain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdNullException extends RuntimeException{
    public IdNullException(String message) {
        super(message);
    }
}




