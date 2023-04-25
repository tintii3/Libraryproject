package com.example.libraryproject.exception.address;

import com.example.libraryproject.exception.general.ResourceIllegalStateException;

public class AddressUnassignedException extends ResourceIllegalStateException {
    public AddressUnassignedException(String s) {
        super(s);
    }
}
