package com.example.libraryproject.exception.location;

import com.example.libraryproject.exception.general.ResourceIllegalStateException;

public class LocationUnassignedException extends ResourceIllegalStateException {
    public LocationUnassignedException(String s) {
        super(s);
    }
}
