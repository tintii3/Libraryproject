package com.example.libraryproject.exception.address;

import com.example.libraryproject.exception.general.ResourceExistsException;

public class AddressExistsException extends ResourceExistsException {
    public AddressExistsException(String message) {
        super(message);
    }
}
