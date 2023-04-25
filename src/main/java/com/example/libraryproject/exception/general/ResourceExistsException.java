package com.example.libraryproject.exception.general;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceExistsException extends RuntimeException{
    public ResourceExistsException(String message) {
        super(message);
    }
}
