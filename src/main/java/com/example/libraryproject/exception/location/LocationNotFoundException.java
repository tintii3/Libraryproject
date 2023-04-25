package com.example.libraryproject.exception.location;

import com.example.libraryproject.exception.general.ResourceNotFoundException;

public class LocationNotFoundException extends ResourceNotFoundException {
    public LocationNotFoundException(String message) {
        super(message);
    }
}
