package com.example.libraryproject.exception.location;

import com.example.libraryproject.exception.general.ResourceExistsException;

public class LocationExistsException extends ResourceExistsException {
    public LocationExistsException(String message) {
        super(message);
    }
}
