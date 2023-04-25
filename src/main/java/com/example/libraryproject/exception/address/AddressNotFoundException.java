package com.example.libraryproject.exception.address;

import com.example.libraryproject.exception.general.ResourceNotFoundException;

public class AddressNotFoundException extends ResourceNotFoundException {
    public AddressNotFoundException(String message) {
        super(message);
    }
}
